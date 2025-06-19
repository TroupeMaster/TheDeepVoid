package net.minecraft.world.entity;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Either;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Vec3i;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.FloatTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.protocol.game.ClientboundSetEntityLinkPacket;
import net.minecraft.network.protocol.game.DebugPackets;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.control.JumpControl;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.GoalSelector;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.sensing.Sensing;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.decoration.LeashFenceKnotEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.AABB;

public abstract class Mob extends LivingEntity implements EquipmentUser, Targeting {
    private static final EntityDataAccessor<Byte> DATA_MOB_FLAGS_ID = SynchedEntityData.defineId(Mob.class, EntityDataSerializers.BYTE);
    private static final int MOB_FLAG_NO_AI = 1;
    private static final int MOB_FLAG_LEFTHANDED = 2;
    private static final int MOB_FLAG_AGGRESSIVE = 4;
    protected static final int PICKUP_REACH = 1;
    private static final Vec3i ITEM_PICKUP_REACH = new Vec3i(1, 0, 1);
    public static final float MAX_WEARING_ARMOR_CHANCE = 0.15F;
    public static final float MAX_PICKUP_LOOT_CHANCE = 0.55F;
    public static final float MAX_ENCHANTED_ARMOR_CHANCE = 0.5F;
    public static final float MAX_ENCHANTED_WEAPON_CHANCE = 0.25F;
    public static final String LEASH_TAG = "leash";
    public static final float DEFAULT_EQUIPMENT_DROP_CHANCE = 0.085F;
    public static final int PRESERVE_ITEM_DROP_CHANCE = 2;
    public static final int UPDATE_GOAL_SELECTOR_EVERY_N_TICKS = 2;
    private static final double DEFAULT_ATTACK_REACH = Math.sqrt(2.04F) - 0.6F;
    public int ambientSoundTime;
    protected int xpReward;
    protected LookControl lookControl;
    protected MoveControl moveControl;
    protected JumpControl jumpControl;
    private final BodyRotationControl bodyRotationControl;
    protected PathNavigation navigation;
    public final GoalSelector goalSelector;
    public final GoalSelector targetSelector;
    @Nullable
    private LivingEntity target;
    private final Sensing sensing;
    private final NonNullList<ItemStack> handItems = NonNullList.withSize(2, ItemStack.EMPTY);
    protected final float[] handDropChances = new float[2];
    private final NonNullList<ItemStack> armorItems = NonNullList.withSize(4, ItemStack.EMPTY);
    protected final float[] armorDropChances = new float[4];
    private ItemStack bodyArmorItem = ItemStack.EMPTY;
    protected float bodyArmorDropChance;
    private boolean canPickUpLoot;
    private boolean persistenceRequired;
    private final Map<PathType, Float> pathfindingMalus = Maps.newEnumMap(PathType.class);
    @Nullable
    private ResourceKey<LootTable> lootTable;
    private long lootTableSeed;
    @Nullable
    private Entity leashHolder;
    private int delayedLeashHolderId;
    @Nullable
    private Either<UUID, BlockPos> delayedLeashInfo;
    private BlockPos restrictCenter = BlockPos.ZERO;
    private float restrictRadius = -1.0F;
    @Nullable
    private MobSpawnType spawnType;
    private boolean spawnCancelled = false;

    protected Mob(EntityType<? extends Mob> p_21368_, Level p_21369_) {
        super(p_21368_, p_21369_);
        this.goalSelector = new GoalSelector(p_21369_.getProfilerSupplier());
        this.targetSelector = new GoalSelector(p_21369_.getProfilerSupplier());
        this.lookControl = new LookControl(this);
        this.moveControl = new MoveControl(this);
        this.jumpControl = new JumpControl(this);
        this.bodyRotationControl = this.createBodyControl();
        this.navigation = this.createNavigation(p_21369_);
        this.sensing = new Sensing(this);
        Arrays.fill(this.armorDropChances, 0.085F);
        Arrays.fill(this.handDropChances, 0.085F);
        this.bodyArmorDropChance = 0.085F;
        if (p_21369_ != null && !p_21369_.isClientSide) {
            this.registerGoals();
        }
    }

    protected void registerGoals() {
    }

    public static AttributeSupplier.Builder createMobAttributes() {
        return LivingEntity.createLivingAttributes().add(Attributes.FOLLOW_RANGE, 16.0).add(Attributes.ATTACK_KNOCKBACK);
    }

    protected PathNavigation createNavigation(Level p_21480_) {
        return new GroundPathNavigation(this, p_21480_);
    }

    protected boolean shouldPassengersInheritMalus() {
        return false;
    }

    public float getPathfindingMalus(PathType p_326934_) {
        Mob mob;
        label17: {
            if (this.getControlledVehicle() instanceof Mob mob1 && mob1.shouldPassengersInheritMalus()) {
                mob = mob1;
                break label17;
            }

            mob = this;
        }

        Float f = mob.pathfindingMalus.get(p_326934_);
        return f == null ? p_326934_.getMalus() : f;
    }

    public void setPathfindingMalus(PathType p_326826_, float p_21443_) {
        this.pathfindingMalus.put(p_326826_, p_21443_);
    }

    public void onPathfindingStart() {
    }

    public void onPathfindingDone() {
    }

    protected BodyRotationControl createBodyControl() {
        return new BodyRotationControl(this);
    }

    public LookControl getLookControl() {
        return this.lookControl;
    }

    public MoveControl getMoveControl() {
        return this.getControlledVehicle() instanceof Mob mob ? mob.getMoveControl() : this.moveControl;
    }

    public JumpControl getJumpControl() {
        return this.jumpControl;
    }

    public PathNavigation getNavigation() {
        return this.getControlledVehicle() instanceof Mob mob ? mob.getNavigation() : this.navigation;
    }

    @Nullable
    @Override
    public LivingEntity getControllingPassenger() {
        Entity entity = this.getFirstPassenger();
        if (!this.isNoAi() && entity instanceof Mob mob && entity.canControlVehicle()) {
            return mob;
        }

        return null;
    }

    public Sensing getSensing() {
        return this.sensing;
    }

    @Nullable
    @Override
    public LivingEntity getTarget() {
        return this.target;
    }

    @Nullable
    protected final LivingEntity getTargetFromBrain() {
        return this.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).orElse(null);
    }

    public void setTarget(@Nullable LivingEntity p_21544_) {
        net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent changeTargetEvent = net.neoforged.neoforge.common.CommonHooks.onLivingChangeTarget(this, p_21544_, net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent.LivingTargetType.MOB_TARGET);
        if(!changeTargetEvent.isCanceled()) {
             this.target = changeTargetEvent.getNewTarget();
        }
    }

    @Override
    public boolean canAttackType(EntityType<?> p_21399_) {
        return p_21399_ != EntityType.GHAST;
    }

    public boolean canFireProjectileWeapon(ProjectileWeaponItem p_21430_) {
        return false;
    }

    public void ate() {
        this.gameEvent(GameEvent.EAT);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326499_) {
        super.defineSynchedData(p_326499_);
        p_326499_.define(DATA_MOB_FLAGS_ID, (byte)0);
    }

    public int getAmbientSoundInterval() {
        return 80;
    }

    public void playAmbientSound() {
        this.makeSound(this.getAmbientSound());
    }

    @Override
    public void baseTick() {
        super.baseTick();
        this.level().getProfiler().push("mobBaseTick");
        if (this.isAlive() && this.random.nextInt(1000) < this.ambientSoundTime++) {
            this.resetAmbientSoundTime();
            this.playAmbientSound();
        }

        this.level().getProfiler().pop();
    }

    @Override
    protected void playHurtSound(DamageSource p_21493_) {
        this.resetAmbientSoundTime();
        super.playHurtSound(p_21493_);
    }

    private void resetAmbientSoundTime() {
        this.ambientSoundTime = -this.getAmbientSoundInterval();
    }

    @Override
    public int getExperienceReward() {
        if (this.xpReward > 0) {
            int i = this.xpReward;

            for (int j = 0; j < this.armorItems.size(); j++) {
                if (!this.armorItems.get(j).isEmpty() && this.armorDropChances[j] <= 1.0F) {
                    i += 1 + this.random.nextInt(3);
                }
            }

            for (int k = 0; k < this.handItems.size(); k++) {
                if (!this.handItems.get(k).isEmpty() && this.handDropChances[k] <= 1.0F) {
                    i += 1 + this.random.nextInt(3);
                }
            }

            if (!this.bodyArmorItem.isEmpty() && this.bodyArmorDropChance <= 1.0F) {
                i += 1 + this.random.nextInt(3);
            }

            return i;
        } else {
            return this.xpReward;
        }
    }

    public void spawnAnim() {
        if (this.level().isClientSide) {
            for (int i = 0; i < 20; i++) {
                double d0 = this.random.nextGaussian() * 0.02;
                double d1 = this.random.nextGaussian() * 0.02;
                double d2 = this.random.nextGaussian() * 0.02;
                double d3 = 10.0;
                this.level()
                    .addParticle(ParticleTypes.POOF, this.getX(1.0) - d0 * 10.0, this.getRandomY() - d1 * 10.0, this.getRandomZ(1.0) - d2 * 10.0, d0, d1, d2);
            }
        } else {
            this.level().broadcastEntityEvent(this, (byte)20);
        }
    }

    @Override
    public void handleEntityEvent(byte p_21375_) {
        if (p_21375_ == 20) {
            this.spawnAnim();
        } else {
            super.handleEntityEvent(p_21375_);
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide) {
            this.tickLeash();
            if (this.tickCount % 5 == 0) {
                this.updateControlFlags();
            }
        }

        // Neo: Animal armor tick patch
        if (this.canWearBodyArmor()) {
            ItemStack stack = this.getBodyArmorItem();
            if (isBodyArmorItem(stack)) stack.onAnimalArmorTick(level(), this);
        }
    }

    protected void updateControlFlags() {
        boolean flag = !(this.getControllingPassenger() instanceof Mob);
        boolean flag1 = !(this.getVehicle() instanceof Boat);
        this.goalSelector.setControlFlag(Goal.Flag.MOVE, flag);
        this.goalSelector.setControlFlag(Goal.Flag.JUMP, flag && flag1);
        this.goalSelector.setControlFlag(Goal.Flag.LOOK, flag);
    }

    @Override
    protected float tickHeadTurn(float p_21538_, float p_21539_) {
        this.bodyRotationControl.clientTick();
        return p_21539_;
    }

    @Nullable
    protected SoundEvent getAmbientSound() {
        return null;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag p_21484_) {
        super.addAdditionalSaveData(p_21484_);
        p_21484_.putBoolean("CanPickUpLoot", this.canPickUpLoot());
        p_21484_.putBoolean("PersistenceRequired", this.persistenceRequired);
        ListTag listtag = new ListTag();

        for (ItemStack itemstack : this.armorItems) {
            if (!itemstack.isEmpty()) {
                listtag.add(itemstack.save(this.registryAccess()));
            } else {
                listtag.add(new CompoundTag());
            }
        }

        p_21484_.put("ArmorItems", listtag);
        ListTag listtag1 = new ListTag();

        for (float f : this.armorDropChances) {
            listtag1.add(FloatTag.valueOf(f));
        }

        p_21484_.put("ArmorDropChances", listtag1);
        ListTag listtag2 = new ListTag();

        for (ItemStack itemstack1 : this.handItems) {
            if (!itemstack1.isEmpty()) {
                listtag2.add(itemstack1.save(this.registryAccess()));
            } else {
                listtag2.add(new CompoundTag());
            }
        }

        p_21484_.put("HandItems", listtag2);
        ListTag listtag3 = new ListTag();

        for (float f1 : this.handDropChances) {
            listtag3.add(FloatTag.valueOf(f1));
        }

        p_21484_.put("HandDropChances", listtag3);
        if (!this.bodyArmorItem.isEmpty()) {
            p_21484_.put("body_armor_item", this.bodyArmorItem.save(this.registryAccess()));
            p_21484_.putFloat("body_armor_drop_chance", this.bodyArmorDropChance);
        }

        Either<UUID, BlockPos> either = this.delayedLeashInfo;
        if (this.leashHolder instanceof LivingEntity) {
            either = Either.left(this.leashHolder.getUUID());
        } else if (this.leashHolder instanceof HangingEntity hangingentity) {
            either = Either.right(hangingentity.getPos());
        }

        if (either != null) {
            p_21484_.put("leash", either.map(p_325668_ -> {
                CompoundTag compoundtag = new CompoundTag();
                compoundtag.putUUID("UUID", p_325668_);
                return compoundtag;
            }, NbtUtils::writeBlockPos));
        }

        p_21484_.putBoolean("LeftHanded", this.isLeftHanded());
        if (this.lootTable != null) {
            p_21484_.putString("DeathLootTable", this.lootTable.location().toString());
            if (this.lootTableSeed != 0L) {
                p_21484_.putLong("DeathLootTableSeed", this.lootTableSeed);
            }
        }

        if (this.isNoAi()) {
            p_21484_.putBoolean("NoAI", this.isNoAi());
        }
        if (this.spawnType != null) {
            p_21484_.putString("neoforge:spawn_type", this.spawnType.name());
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag p_21450_) {
        super.readAdditionalSaveData(p_21450_);
        if (p_21450_.contains("CanPickUpLoot", 1)) {
            this.setCanPickUpLoot(p_21450_.getBoolean("CanPickUpLoot"));
        }

        this.persistenceRequired = p_21450_.getBoolean("PersistenceRequired");
        if (p_21450_.contains("ArmorItems", 9)) {
            ListTag listtag = p_21450_.getList("ArmorItems", 10);

            for (int i = 0; i < this.armorItems.size(); i++) {
                CompoundTag compoundtag = listtag.getCompound(i);
                this.armorItems.set(i, ItemStack.parseOptional(this.registryAccess(), compoundtag));
            }
        }

        if (p_21450_.contains("ArmorDropChances", 9)) {
            ListTag listtag1 = p_21450_.getList("ArmorDropChances", 5);

            for (int j = 0; j < listtag1.size(); j++) {
                this.armorDropChances[j] = listtag1.getFloat(j);
            }
        }

        if (p_21450_.contains("HandItems", 9)) {
            ListTag listtag2 = p_21450_.getList("HandItems", 10);

            for (int k = 0; k < this.handItems.size(); k++) {
                CompoundTag compoundtag1 = listtag2.getCompound(k);
                this.handItems.set(k, ItemStack.parseOptional(this.registryAccess(), compoundtag1));
            }
        }

        if (p_21450_.contains("HandDropChances", 9)) {
            ListTag listtag3 = p_21450_.getList("HandDropChances", 5);

            for (int l = 0; l < listtag3.size(); l++) {
                this.handDropChances[l] = listtag3.getFloat(l);
            }
        }

        if (p_21450_.contains("body_armor_item", 10)) {
            this.bodyArmorItem = ItemStack.parse(this.registryAccess(), p_21450_.getCompound("body_armor_item")).orElse(ItemStack.EMPTY);
            this.bodyArmorDropChance = p_21450_.getFloat("body_armor_drop_chance");
        } else {
            this.bodyArmorItem = ItemStack.EMPTY;
        }

        if (p_21450_.contains("leash", 10)) {
            this.delayedLeashInfo = Either.left(p_21450_.getCompound("leash").getUUID("UUID"));
        } else if (p_21450_.contains("leash", 11)) {
            this.delayedLeashInfo = NbtUtils.readBlockPos(p_21450_, "leash").<Either<UUID, BlockPos>>map(Either::right).orElse(null);
        } else {
            this.delayedLeashInfo = null;
        }

        this.setLeftHanded(p_21450_.getBoolean("LeftHanded"));
        if (p_21450_.contains("DeathLootTable", 8)) {
            this.lootTable = ResourceKey.create(Registries.LOOT_TABLE, new ResourceLocation(p_21450_.getString("DeathLootTable")));
            this.lootTableSeed = p_21450_.getLong("DeathLootTableSeed");
        }

        this.setNoAi(p_21450_.getBoolean("NoAI"));

        if (p_21450_.contains("neoforge:spawn_type")) {
            try {
                this.spawnType = MobSpawnType.valueOf(p_21450_.getString("neoforge:spawn_type"));
            } catch (Exception ex) {
                p_21450_.remove("neoforge:spawn_type");
            }
        }
    }

    @Override
    protected void dropFromLootTable(DamageSource p_21389_, boolean p_21390_) {
        super.dropFromLootTable(p_21389_, p_21390_);
        this.lootTable = null;
    }

    @Override
    public final ResourceKey<LootTable> getLootTable() {
        return this.lootTable == null ? this.getDefaultLootTable() : this.lootTable;
    }

    protected ResourceKey<LootTable> getDefaultLootTable() {
        return super.getLootTable();
    }

    @Override
    public long getLootTableSeed() {
        return this.lootTableSeed;
    }

    public void setZza(float p_21565_) {
        this.zza = p_21565_;
    }

    public void setYya(float p_21568_) {
        this.yya = p_21568_;
    }

    public void setXxa(float p_21571_) {
        this.xxa = p_21571_;
    }

    @Override
    public void setSpeed(float p_21556_) {
        super.setSpeed(p_21556_);
        this.setZza(p_21556_);
    }

    public void stopInPlace() {
        this.getNavigation().stop();
        this.setXxa(0.0F);
        this.setYya(0.0F);
        this.setSpeed(0.0F);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.level().getProfiler().push("looting");
        if (!this.level().isClientSide
            && this.canPickUpLoot()
            && this.isAlive()
            && !this.dead
            && net.neoforged.neoforge.event.EventHooks.canEntityGrief(this.level(), this)) {
            Vec3i vec3i = this.getPickupReach();

            for (ItemEntity itementity : this.level()
                .getEntitiesOfClass(ItemEntity.class, this.getBoundingBox().inflate((double)vec3i.getX(), (double)vec3i.getY(), (double)vec3i.getZ()))) {
                if (!itementity.isRemoved() && !itementity.getItem().isEmpty() && !itementity.hasPickUpDelay() && this.wantsToPickUp(itementity.getItem())) {
                    this.pickUpItem(itementity);
                }
            }
        }

        this.level().getProfiler().pop();
    }

    protected Vec3i getPickupReach() {
        return ITEM_PICKUP_REACH;
    }

    protected void pickUpItem(ItemEntity p_21471_) {
        ItemStack itemstack = p_21471_.getItem();
        ItemStack itemstack1 = this.equipItemIfPossible(itemstack.copy());
        if (!itemstack1.isEmpty()) {
            this.onItemPickup(p_21471_);
            this.take(p_21471_, itemstack1.getCount());
            itemstack.shrink(itemstack1.getCount());
            if (itemstack.isEmpty()) {
                p_21471_.discard();
            }
        }
    }

    public ItemStack equipItemIfPossible(ItemStack p_255842_) {
        EquipmentSlot equipmentslot = getEquipmentSlotForItem(p_255842_);
        ItemStack itemstack = this.getItemBySlot(equipmentslot);
        boolean flag = this.canReplaceCurrentItem(p_255842_, itemstack);
        if (equipmentslot.isArmor() && !flag) {
            equipmentslot = EquipmentSlot.MAINHAND;
            itemstack = this.getItemBySlot(equipmentslot);
            flag = itemstack.isEmpty();
        }

        if (flag && this.canHoldItem(p_255842_)) {
            double d0 = (double)this.getEquipmentDropChance(equipmentslot);
            if (!itemstack.isEmpty() && (double)Math.max(this.random.nextFloat() - 0.1F, 0.0F) < d0) {
                this.spawnAtLocation(itemstack);
            }

            if (equipmentslot.isArmor() && p_255842_.getCount() > 1) {
                ItemStack itemstack1 = p_255842_.copyWithCount(1);
                this.setItemSlotAndDropWhenKilled(equipmentslot, itemstack1);
                return itemstack1;
            } else {
                this.setItemSlotAndDropWhenKilled(equipmentslot, p_255842_);
                return p_255842_;
            }
        } else {
            return ItemStack.EMPTY;
        }
    }

    protected void setItemSlotAndDropWhenKilled(EquipmentSlot p_21469_, ItemStack p_21470_) {
        this.setItemSlot(p_21469_, p_21470_);
        this.setGuaranteedDrop(p_21469_);
        this.persistenceRequired = true;
    }

    public void setGuaranteedDrop(EquipmentSlot p_21509_) {
        switch (p_21509_.getType()) {
            case HAND:
                this.handDropChances[p_21509_.getIndex()] = 2.0F;
                break;
            case ARMOR:
                this.armorDropChances[p_21509_.getIndex()] = 2.0F;
                break;
            case BODY:
                this.bodyArmorDropChance = 2.0F;
        }
    }

    protected boolean canReplaceCurrentItem(ItemStack p_21428_, ItemStack p_21429_) {
        if (p_21429_.isEmpty()) {
            return true;
        } else if (p_21428_.getItem() instanceof SwordItem) {
            if (!(p_21429_.getItem() instanceof SwordItem)) {
                return true;
            } else {
                double d2 = this.getApproximateAttackDamageWithItem(p_21428_);
                double d3 = this.getApproximateAttackDamageWithItem(p_21429_);
                return d2 != d3 ? d2 > d3 : this.canReplaceEqualItem(p_21428_, p_21429_);
            }
        } else if (p_21428_.getItem() instanceof BowItem && p_21429_.getItem() instanceof BowItem) {
            return this.canReplaceEqualItem(p_21428_, p_21429_);
        } else if (p_21428_.getItem() instanceof CrossbowItem && p_21429_.getItem() instanceof CrossbowItem) {
            return this.canReplaceEqualItem(p_21428_, p_21429_);
        } else if (p_21428_.getItem() instanceof ArmorItem armoritem) {
            if (EnchantmentHelper.hasBindingCurse(p_21429_)) {
                return false;
            } else if (!(p_21429_.getItem() instanceof ArmorItem)) {
                return true;
            } else {
                ArmorItem armoritem1 = (ArmorItem)p_21429_.getItem();
                if (armoritem.getDefense() != armoritem1.getDefense()) {
                    return armoritem.getDefense() > armoritem1.getDefense();
                } else {
                    return armoritem.getToughness() != armoritem1.getToughness()
                        ? armoritem.getToughness() > armoritem1.getToughness()
                        : this.canReplaceEqualItem(p_21428_, p_21429_);
                }
            }
        } else {
            if (p_21428_.getItem() instanceof DiggerItem) {
                if (p_21429_.getItem() instanceof BlockItem) {
                    return true;
                }

                if (p_21429_.getItem() instanceof DiggerItem) {
                    double d1 = this.getApproximateAttackDamageWithItem(p_21428_);
                    double d0 = this.getApproximateAttackDamageWithItem(p_21429_);
                    if (d1 != d0) {
                        return d1 > d0;
                    }

                    return this.canReplaceEqualItem(p_21428_, p_21429_);
                }
            }

            return false;
        }
    }

    private double getApproximateAttackDamageWithItem(ItemStack p_330413_) {
        ItemAttributeModifiers itemattributemodifiers = p_330413_.getOrDefault(DataComponents.ATTRIBUTE_MODIFIERS, ItemAttributeModifiers.EMPTY);
        return itemattributemodifiers.compute(this.getAttributeBaseValue(Attributes.ATTACK_DAMAGE), EquipmentSlot.MAINHAND);
    }

    public boolean canReplaceEqualItem(ItemStack p_21478_, ItemStack p_21479_) {
        return p_21478_.getDamageValue() < p_21479_.getDamageValue() ? true : hasAnyComponentExceptDamage(p_21478_) && !hasAnyComponentExceptDamage(p_21479_);
    }

    private static boolean hasAnyComponentExceptDamage(ItemStack p_332136_) {
        DataComponentMap datacomponentmap = p_332136_.getComponents();
        int i = datacomponentmap.size();
        return i > 1 || i == 1 && !datacomponentmap.has(DataComponents.DAMAGE);
    }

    public boolean canHoldItem(ItemStack p_21545_) {
        return true;
    }

    public boolean wantsToPickUp(ItemStack p_21546_) {
        return this.canHoldItem(p_21546_);
    }

    public boolean removeWhenFarAway(double p_21542_) {
        return true;
    }

    public boolean requiresCustomPersistence() {
        return this.isPassenger();
    }

    protected boolean shouldDespawnInPeaceful() {
        return false;
    }

    @Override
    public void checkDespawn() {
        if (net.neoforged.neoforge.event.EventHooks.checkMobDespawn(this)) return;
        if (this.level().getDifficulty() == Difficulty.PEACEFUL && this.shouldDespawnInPeaceful()) {
            this.discard();
        } else if (!this.isPersistenceRequired() && !this.requiresCustomPersistence()) {
            Entity entity = this.level().getNearestPlayer(this, -1.0);
            if (entity != null) {
                double d0 = entity.distanceToSqr(this);
                int i = this.getType().getCategory().getDespawnDistance();
                int j = i * i;
                if (d0 > (double)j && this.removeWhenFarAway(d0)) {
                    this.discard();
                }

                int k = this.getType().getCategory().getNoDespawnDistance();
                int l = k * k;
                if (this.noActionTime > 600 && this.random.nextInt(800) == 0 && d0 > (double)l && this.removeWhenFarAway(d0)) {
                    this.discard();
                } else if (d0 < (double)l) {
                    this.noActionTime = 0;
                }
            }
        } else {
            this.noActionTime = 0;
        }
    }

    @Override
    protected final void serverAiStep() {
        this.noActionTime++;
        ProfilerFiller profilerfiller = this.level().getProfiler();
        profilerfiller.push("sensing");
        this.sensing.tick();
        profilerfiller.pop();
        int i = this.tickCount + this.getId();
        if (i % 2 != 0 && this.tickCount > 1) {
            profilerfiller.push("targetSelector");
            this.targetSelector.tickRunningGoals(false);
            profilerfiller.pop();
            profilerfiller.push("goalSelector");
            this.goalSelector.tickRunningGoals(false);
            profilerfiller.pop();
        } else {
            profilerfiller.push("targetSelector");
            this.targetSelector.tick();
            profilerfiller.pop();
            profilerfiller.push("goalSelector");
            this.goalSelector.tick();
            profilerfiller.pop();
        }

        profilerfiller.push("navigation");
        this.navigation.tick();
        profilerfiller.pop();
        profilerfiller.push("mob tick");
        this.customServerAiStep();
        profilerfiller.pop();
        profilerfiller.push("controls");
        profilerfiller.push("move");
        this.moveControl.tick();
        profilerfiller.popPush("look");
        this.lookControl.tick();
        profilerfiller.popPush("jump");
        this.jumpControl.tick();
        profilerfiller.pop();
        profilerfiller.pop();
        this.sendDebugPackets();
    }

    protected void sendDebugPackets() {
        DebugPackets.sendGoalSelector(this.level(), this, this.goalSelector);
    }

    protected void customServerAiStep() {
    }

    public int getMaxHeadXRot() {
        return 40;
    }

    public int getMaxHeadYRot() {
        return 75;
    }

    protected void clampHeadRotationToBody() {
        float f = (float)this.getMaxHeadYRot();
        float f1 = this.getYHeadRot();
        float f2 = Mth.wrapDegrees(this.yBodyRot - f1);
        float f3 = Mth.clamp(Mth.wrapDegrees(this.yBodyRot - f1), -f, f);
        float f4 = f1 + f2 - f3;
        this.setYHeadRot(f4);
    }

    public int getHeadRotSpeed() {
        return 10;
    }

    public void lookAt(Entity p_21392_, float p_21393_, float p_21394_) {
        double d0 = p_21392_.getX() - this.getX();
        double d2 = p_21392_.getZ() - this.getZ();
        double d1;
        if (p_21392_ instanceof LivingEntity livingentity) {
            d1 = livingentity.getEyeY() - this.getEyeY();
        } else {
            d1 = (p_21392_.getBoundingBox().minY + p_21392_.getBoundingBox().maxY) / 2.0 - this.getEyeY();
        }

        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        float f = (float)(Mth.atan2(d2, d0) * 180.0F / (float)Math.PI) - 90.0F;
        float f1 = (float)(-(Mth.atan2(d1, d3) * 180.0F / (float)Math.PI));
        this.setXRot(this.rotlerp(this.getXRot(), f1, p_21394_));
        this.setYRot(this.rotlerp(this.getYRot(), f, p_21393_));
    }

    private float rotlerp(float p_21377_, float p_21378_, float p_21379_) {
        float f = Mth.wrapDegrees(p_21378_ - p_21377_);
        if (f > p_21379_) {
            f = p_21379_;
        }

        if (f < -p_21379_) {
            f = -p_21379_;
        }

        return p_21377_ + f;
    }

    public static boolean checkMobSpawnRules(
        EntityType<? extends Mob> p_217058_, LevelAccessor p_217059_, MobSpawnType p_217060_, BlockPos p_217061_, RandomSource p_217062_
    ) {
        BlockPos blockpos = p_217061_.below();
        return p_217060_ == MobSpawnType.SPAWNER || p_217059_.getBlockState(blockpos).isValidSpawn(p_217059_, blockpos, p_217058_);
    }

    public boolean checkSpawnRules(LevelAccessor p_21431_, MobSpawnType p_21432_) {
        return true;
    }

    public boolean checkSpawnObstruction(LevelReader p_21433_) {
        return !p_21433_.containsAnyLiquid(this.getBoundingBox()) && p_21433_.isUnobstructed(this);
    }

    public int getMaxSpawnClusterSize() {
        return 4;
    }

    public boolean isMaxGroupSizeReached(int p_21489_) {
        return false;
    }

    @Override
    public int getMaxFallDistance() {
        if (this.getTarget() == null) {
            return this.getComfortableFallDistance(0.0F);
        } else {
            int i = (int)(this.getHealth() - this.getMaxHealth() * 0.33F);
            i -= (3 - this.level().getDifficulty().getId()) * 4;
            if (i < 0) {
                i = 0;
            }

            return this.getComfortableFallDistance((float)i);
        }
    }

    @Override
    public Iterable<ItemStack> getHandSlots() {
        return this.handItems;
    }

    @Override
    public Iterable<ItemStack> getArmorSlots() {
        return this.armorItems;
    }

    public ItemStack getBodyArmorItem() {
        return this.bodyArmorItem;
    }

    public boolean canWearBodyArmor() {
        return false;
    }

    @Override
    public boolean canUseSlot(EquipmentSlot p_326379_) {
        return true;
    }

    public boolean isWearingBodyArmor() {
        return !this.getItemBySlot(EquipmentSlot.BODY).isEmpty();
    }

    public boolean isBodyArmorItem(ItemStack p_324454_) {
        return false;
    }

    public void setBodyArmorItem(ItemStack p_323721_) {
        this.setItemSlotAndDropWhenKilled(EquipmentSlot.BODY, p_323721_);
    }

    @Override
    public Iterable<ItemStack> getArmorAndBodyArmorSlots() {
        return (Iterable<ItemStack>)(this.bodyArmorItem.isEmpty() ? this.armorItems : Iterables.concat(this.armorItems, List.of(this.bodyArmorItem)));
    }

    @Override
    public ItemStack getItemBySlot(EquipmentSlot p_21467_) {
        return switch (p_21467_.getType()) {
            case HAND -> (ItemStack)this.handItems.get(p_21467_.getIndex());
            case ARMOR -> (ItemStack)this.armorItems.get(p_21467_.getIndex());
            case BODY -> this.bodyArmorItem;
        };
    }

    @Override
    public void setItemSlot(EquipmentSlot p_21416_, ItemStack p_21417_) {
        this.verifyEquippedItem(p_21417_);
        switch (p_21416_.getType()) {
            case HAND:
                this.onEquipItem(p_21416_, this.handItems.set(p_21416_.getIndex(), p_21417_), p_21417_);
                break;
            case ARMOR:
                this.onEquipItem(p_21416_, this.armorItems.set(p_21416_.getIndex(), p_21417_), p_21417_);
                break;
            case BODY:
                ItemStack itemstack = this.bodyArmorItem;
                this.bodyArmorItem = p_21417_;
                this.onEquipItem(p_21416_, itemstack, p_21417_);
        }
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource p_21385_, int p_21386_, boolean p_21387_) {
        super.dropCustomDeathLoot(p_21385_, p_21386_, p_21387_);

        for (EquipmentSlot equipmentslot : EquipmentSlot.values()) {
            ItemStack itemstack = this.getItemBySlot(equipmentslot);
            float f = this.getEquipmentDropChance(equipmentslot);
            boolean flag = f > 1.0F;
            if (!itemstack.isEmpty()
                && !EnchantmentHelper.hasVanishingCurse(itemstack)
                && (p_21387_ || flag)
                && Math.max(this.random.nextFloat() - (float)p_21386_ * 0.01F, 0.0F) < f) {
                if (!flag && itemstack.isDamageableItem()) {
                    itemstack.setDamageValue(itemstack.getMaxDamage() - this.random.nextInt(1 + this.random.nextInt(Math.max(itemstack.getMaxDamage() - 3, 1))));
                }

                this.spawnAtLocation(itemstack);
                this.setItemSlot(equipmentslot, ItemStack.EMPTY);
            }
        }
    }

    protected float getEquipmentDropChance(EquipmentSlot p_21520_) {
        return switch (p_21520_.getType()) {
            case HAND -> this.handDropChances[p_21520_.getIndex()];
            case ARMOR -> this.armorDropChances[p_21520_.getIndex()];
            case BODY -> this.bodyArmorDropChance;
        };
    }

    private LootParams createEquipmentParams(ServerLevel p_338758_) {
        return new LootParams.Builder(p_338758_)
            .withParameter(LootContextParams.ORIGIN, this.position())
            .withParameter(LootContextParams.THIS_ENTITY, this)
            .create(LootContextParamSets.EQUIPMENT);
    }

    public void equip(EquipmentTable p_341198_) {
        this.equip(p_341198_.lootTable(), p_341198_.slotDropChances());
    }

    public void equip(ResourceKey<LootTable> p_340912_, Map<EquipmentSlot, Float> p_340996_) {
        if (this.level() instanceof ServerLevel serverlevel) {
            this.equip(p_340912_, this.createEquipmentParams(serverlevel), p_340996_);
        }
    }

    protected void populateDefaultEquipmentSlots(RandomSource p_217055_, DifficultyInstance p_217056_) {
        if (p_217055_.nextFloat() < 0.15F * p_217056_.getSpecialMultiplier()) {
            int i = p_217055_.nextInt(2);
            float f = this.level().getDifficulty() == Difficulty.HARD ? 0.1F : 0.25F;
            if (p_217055_.nextFloat() < 0.095F) {
                i++;
            }

            if (p_217055_.nextFloat() < 0.095F) {
                i++;
            }

            if (p_217055_.nextFloat() < 0.095F) {
                i++;
            }

            boolean flag = true;

            for (EquipmentSlot equipmentslot : EquipmentSlot.values()) {
                if (equipmentslot.getType() == EquipmentSlot.Type.ARMOR) {
                    ItemStack itemstack = this.getItemBySlot(equipmentslot);
                    if (!flag && p_217055_.nextFloat() < f) {
                        break;
                    }

                    flag = false;
                    if (itemstack.isEmpty()) {
                        Item item = getEquipmentForSlot(equipmentslot, i);
                        if (item != null) {
                            this.setItemSlot(equipmentslot, new ItemStack(item));
                        }
                    }
                }
            }
        }
    }

    @Nullable
    public static Item getEquipmentForSlot(EquipmentSlot p_21413_, int p_21414_) {
        switch (p_21413_) {
            case HEAD:
                if (p_21414_ == 0) {
                    return Items.LEATHER_HELMET;
                } else if (p_21414_ == 1) {
                    return Items.GOLDEN_HELMET;
                } else if (p_21414_ == 2) {
                    return Items.CHAINMAIL_HELMET;
                } else if (p_21414_ == 3) {
                    return Items.IRON_HELMET;
                } else if (p_21414_ == 4) {
                    return Items.DIAMOND_HELMET;
                }
            case CHEST:
                if (p_21414_ == 0) {
                    return Items.LEATHER_CHESTPLATE;
                } else if (p_21414_ == 1) {
                    return Items.GOLDEN_CHESTPLATE;
                } else if (p_21414_ == 2) {
                    return Items.CHAINMAIL_CHESTPLATE;
                } else if (p_21414_ == 3) {
                    return Items.IRON_CHESTPLATE;
                } else if (p_21414_ == 4) {
                    return Items.DIAMOND_CHESTPLATE;
                }
            case LEGS:
                if (p_21414_ == 0) {
                    return Items.LEATHER_LEGGINGS;
                } else if (p_21414_ == 1) {
                    return Items.GOLDEN_LEGGINGS;
                } else if (p_21414_ == 2) {
                    return Items.CHAINMAIL_LEGGINGS;
                } else if (p_21414_ == 3) {
                    return Items.IRON_LEGGINGS;
                } else if (p_21414_ == 4) {
                    return Items.DIAMOND_LEGGINGS;
                }
            case FEET:
                if (p_21414_ == 0) {
                    return Items.LEATHER_BOOTS;
                } else if (p_21414_ == 1) {
                    return Items.GOLDEN_BOOTS;
                } else if (p_21414_ == 2) {
                    return Items.CHAINMAIL_BOOTS;
                } else if (p_21414_ == 3) {
                    return Items.IRON_BOOTS;
                } else if (p_21414_ == 4) {
                    return Items.DIAMOND_BOOTS;
                }
            default:
                return null;
        }
    }

    protected void populateDefaultEquipmentEnchantments(RandomSource p_217063_, DifficultyInstance p_217064_) {
        float f = p_217064_.getSpecialMultiplier();
        this.enchantSpawnedWeapon(p_217063_, f);

        for (EquipmentSlot equipmentslot : EquipmentSlot.values()) {
            if (equipmentslot.getType() == EquipmentSlot.Type.ARMOR) {
                this.enchantSpawnedArmor(p_217063_, f, equipmentslot);
            }
        }
    }

    protected void enchantSpawnedWeapon(RandomSource p_217049_, float p_217050_) {
        if (!this.getMainHandItem().isEmpty() && p_217049_.nextFloat() < 0.25F * p_217050_) {
            this.setItemSlot(
                EquipmentSlot.MAINHAND,
                EnchantmentHelper.enchantItem(
                    this.level().enabledFeatures(), p_217049_, this.getMainHandItem(), (int)(5.0F + p_217050_ * (float)p_217049_.nextInt(18)), false
                )
            );
        }
    }

    protected void enchantSpawnedArmor(RandomSource p_217052_, float p_217053_, EquipmentSlot p_217054_) {
        ItemStack itemstack = this.getItemBySlot(p_217054_);
        if (!itemstack.isEmpty() && p_217052_.nextFloat() < 0.5F * p_217053_) {
            this.setItemSlot(
                p_217054_,
                EnchantmentHelper.enchantItem(
                    this.level().enabledFeatures(), p_217052_, itemstack, (int)(5.0F + p_217053_ * (float)p_217052_.nextInt(18)), false
                )
            );
        }
    }

    /**
     * @deprecated Override-Only. External callers should call via {@link net.neoforged.neoforge.event.EventHooks#finalizeMobSpawn}.
     */
    @Deprecated
    @org.jetbrains.annotations.ApiStatus.OverrideOnly
    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_21434_, DifficultyInstance p_21435_, MobSpawnType p_21436_, @Nullable SpawnGroupData p_21437_) {
        RandomSource randomsource = p_21434_.getRandom();
        this.getAttribute(Attributes.FOLLOW_RANGE)
            .addPermanentModifier(
                new AttributeModifier("Random spawn bonus", randomsource.triangle(0.0, 0.11485000000000001), AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
            );
        this.setLeftHanded(randomsource.nextFloat() < 0.05F);
        this.spawnType = p_21436_;
        return p_21437_;
    }

    public void setPersistenceRequired() {
        this.persistenceRequired = true;
    }

    @Override
    public void setDropChance(EquipmentSlot p_21410_, float p_21411_) {
        switch (p_21410_.getType()) {
            case HAND:
                this.handDropChances[p_21410_.getIndex()] = p_21411_;
                break;
            case ARMOR:
                this.armorDropChances[p_21410_.getIndex()] = p_21411_;
                break;
            case BODY:
                this.bodyArmorDropChance = p_21411_;
        }
    }

    public boolean canPickUpLoot() {
        return this.canPickUpLoot;
    }

    public void setCanPickUpLoot(boolean p_21554_) {
        this.canPickUpLoot = p_21554_;
    }

    @Override
    public boolean canTakeItem(ItemStack p_21522_) {
        EquipmentSlot equipmentslot = getEquipmentSlotForItem(p_21522_);
        return this.getItemBySlot(equipmentslot).isEmpty() && this.canPickUpLoot();
    }

    public boolean isPersistenceRequired() {
        return this.persistenceRequired;
    }

    @Override
    public final InteractionResult interact(Player p_21420_, InteractionHand p_21421_) {
        if (!this.isAlive()) {
            return InteractionResult.PASS;
        } else if (this.getLeashHolder() == p_21420_) {
            this.dropLeash(true, !p_21420_.hasInfiniteMaterials());
            this.gameEvent(GameEvent.ENTITY_INTERACT, p_21420_);
            return InteractionResult.sidedSuccess(this.level().isClientSide);
        } else {
            InteractionResult interactionresult = this.checkAndHandleImportantInteractions(p_21420_, p_21421_);
            if (interactionresult.consumesAction()) {
                this.gameEvent(GameEvent.ENTITY_INTERACT, p_21420_);
                return interactionresult;
            } else {
                interactionresult = this.mobInteract(p_21420_, p_21421_);
                if (interactionresult.consumesAction()) {
                    this.gameEvent(GameEvent.ENTITY_INTERACT, p_21420_);
                    return interactionresult;
                } else {
                    return super.interact(p_21420_, p_21421_);
                }
            }
        }
    }

    private InteractionResult checkAndHandleImportantInteractions(Player p_21500_, InteractionHand p_21501_) {
        ItemStack itemstack = p_21500_.getItemInHand(p_21501_);
        if (itemstack.is(Items.LEAD) && this.canBeLeashed(p_21500_)) {
            this.setLeashedTo(p_21500_, true);
            itemstack.shrink(1);
            return InteractionResult.sidedSuccess(this.level().isClientSide);
        } else {
            if (itemstack.is(Items.NAME_TAG)) {
                InteractionResult interactionresult = itemstack.interactLivingEntity(p_21500_, this, p_21501_);
                if (interactionresult.consumesAction()) {
                    return interactionresult;
                }
            }

            if (itemstack.getItem() instanceof SpawnEggItem) {
                if (this.level() instanceof ServerLevel) {
                    SpawnEggItem spawneggitem = (SpawnEggItem)itemstack.getItem();
                    Optional<Mob> optional = spawneggitem.spawnOffspringFromSpawnEgg(
                        p_21500_, this, (EntityType<? extends Mob>)this.getType(), (ServerLevel)this.level(), this.position(), itemstack
                    );
                    optional.ifPresent(p_21476_ -> this.onOffspringSpawnedFromEgg(p_21500_, p_21476_));
                    return optional.isPresent() ? InteractionResult.SUCCESS : InteractionResult.PASS;
                } else {
                    return InteractionResult.CONSUME;
                }
            } else {
                return InteractionResult.PASS;
            }
        }
    }

    protected void onOffspringSpawnedFromEgg(Player p_21422_, Mob p_21423_) {
    }

    protected InteractionResult mobInteract(Player p_21472_, InteractionHand p_21473_) {
        return InteractionResult.PASS;
    }

    public boolean isWithinRestriction() {
        return this.isWithinRestriction(this.blockPosition());
    }

    public boolean isWithinRestriction(BlockPos p_21445_) {
        return this.restrictRadius == -1.0F ? true : this.restrictCenter.distSqr(p_21445_) < (double)(this.restrictRadius * this.restrictRadius);
    }

    public void restrictTo(BlockPos p_21447_, int p_21448_) {
        this.restrictCenter = p_21447_;
        this.restrictRadius = (float)p_21448_;
    }

    public BlockPos getRestrictCenter() {
        return this.restrictCenter;
    }

    public float getRestrictRadius() {
        return this.restrictRadius;
    }

    public void clearRestriction() {
        this.restrictRadius = -1.0F;
    }

    public boolean hasRestriction() {
        return this.restrictRadius != -1.0F;
    }

    @Nullable
    public <T extends Mob> T convertTo(EntityType<T> p_21407_, boolean p_21408_) {
        if (this.isRemoved()) {
            return null;
        } else {
            T t = (T)p_21407_.create(this.level());
            if (t == null) {
                return null;
            } else {
                t.copyPosition(this);
                t.setBaby(this.isBaby());
                t.setNoAi(this.isNoAi());
                if (this.hasCustomName()) {
                    t.setCustomName(this.getCustomName());
                    t.setCustomNameVisible(this.isCustomNameVisible());
                }

                if (this.isPersistenceRequired()) {
                    t.setPersistenceRequired();
                }

                t.setInvulnerable(this.isInvulnerable());
                if (p_21408_) {
                    t.setCanPickUpLoot(this.canPickUpLoot());

                    for (EquipmentSlot equipmentslot : EquipmentSlot.values()) {
                        ItemStack itemstack = this.getItemBySlot(equipmentslot);
                        if (!itemstack.isEmpty()) {
                            t.setItemSlot(equipmentslot, itemstack.copyAndClear());
                            t.setDropChance(equipmentslot, this.getEquipmentDropChance(equipmentslot));
                        }
                    }
                }

                this.level().addFreshEntity(t);
                if (this.isPassenger()) {
                    Entity entity = this.getVehicle();
                    this.stopRiding();
                    t.startRiding(entity, true);
                }

                this.discard();
                return t;
            }
        }
    }

    protected void tickLeash() {
        if (this.delayedLeashInfo != null) {
            this.restoreLeashFromSave();
        }

        if (this.leashHolder != null) {
            if (!this.isAlive() || !this.leashHolder.isAlive()) {
                this.dropLeash(true, true);
            }
        }
    }

    public void dropLeash(boolean p_21456_, boolean p_21457_) {
        if (this.leashHolder != null) {
            this.leashHolder = null;
            this.delayedLeashInfo = null;
            this.clearRestriction();
            if (!this.level().isClientSide && p_21457_) {
                this.spawnAtLocation(Items.LEAD);
            }

            if (!this.level().isClientSide && p_21456_ && this.level() instanceof ServerLevel) {
                ((ServerLevel)this.level()).getChunkSource().broadcast(this, new ClientboundSetEntityLinkPacket(this, null));
            }
        }
    }

    public boolean canBeLeashed(Player p_21418_) {
        return !this.isLeashed() && !(this instanceof Enemy);
    }

    public boolean isLeashed() {
        return this.leashHolder != null;
    }

    public boolean mayBeLeashed() {
        return this.isLeashed() || this.delayedLeashInfo != null;
    }

    @Nullable
    public Entity getLeashHolder() {
        if (this.leashHolder == null && this.delayedLeashHolderId != 0 && this.level().isClientSide) {
            this.leashHolder = this.level().getEntity(this.delayedLeashHolderId);
        }

        return this.leashHolder;
    }

    public void setLeashedTo(Entity p_21464_, boolean p_21465_) {
        this.leashHolder = p_21464_;
        this.delayedLeashInfo = null;
        if (!this.level().isClientSide && p_21465_ && this.level() instanceof ServerLevel) {
            ((ServerLevel)this.level()).getChunkSource().broadcast(this, new ClientboundSetEntityLinkPacket(this, this.leashHolder));
        }

        if (this.isPassenger()) {
            this.stopRiding();
        }
    }

    public void setDelayedLeashHolderId(int p_21507_) {
        this.delayedLeashHolderId = p_21507_;
        this.dropLeash(false, false);
    }

    @Override
    public boolean startRiding(Entity p_21396_, boolean p_21397_) {
        boolean flag = super.startRiding(p_21396_, p_21397_);
        if (flag && this.isLeashed()) {
            this.dropLeash(true, true);
        }

        return flag;
    }

    private void restoreLeashFromSave() {
        if (this.delayedLeashInfo != null && this.level() instanceof ServerLevel serverlevel) {
            Optional<UUID> optional1 = this.delayedLeashInfo.left();
            Optional<BlockPos> optional = this.delayedLeashInfo.right();
            if (optional1.isPresent()) {
                Entity entity = serverlevel.getEntity(optional1.get());
                if (entity != null) {
                    this.setLeashedTo(entity, true);
                    return;
                }
            } else if (optional.isPresent()) {
                this.setLeashedTo(LeashFenceKnotEntity.getOrCreateKnot(this.level(), optional.get()), true);
                return;
            }

            if (this.tickCount > 100) {
                this.spawnAtLocation(Items.LEAD);
                this.delayedLeashInfo = null;
            }
        }
    }

    @Override
    public boolean isEffectiveAi() {
        return super.isEffectiveAi() && !this.isNoAi();
    }

    public void setNoAi(boolean p_21558_) {
        byte b0 = this.entityData.get(DATA_MOB_FLAGS_ID);
        this.entityData.set(DATA_MOB_FLAGS_ID, p_21558_ ? (byte)(b0 | 1) : (byte)(b0 & -2));
    }

    public void setLeftHanded(boolean p_21560_) {
        byte b0 = this.entityData.get(DATA_MOB_FLAGS_ID);
        this.entityData.set(DATA_MOB_FLAGS_ID, p_21560_ ? (byte)(b0 | 2) : (byte)(b0 & -3));
    }

    public void setAggressive(boolean p_21562_) {
        byte b0 = this.entityData.get(DATA_MOB_FLAGS_ID);
        this.entityData.set(DATA_MOB_FLAGS_ID, p_21562_ ? (byte)(b0 | 4) : (byte)(b0 & -5));
    }

    public boolean isNoAi() {
        return (this.entityData.get(DATA_MOB_FLAGS_ID) & 1) != 0;
    }

    public boolean isLeftHanded() {
        return (this.entityData.get(DATA_MOB_FLAGS_ID) & 2) != 0;
    }

    public boolean isAggressive() {
        return (this.entityData.get(DATA_MOB_FLAGS_ID) & 4) != 0;
    }

    public void setBaby(boolean p_21451_) {
    }

    @Override
    public HumanoidArm getMainArm() {
        return this.isLeftHanded() ? HumanoidArm.LEFT : HumanoidArm.RIGHT;
    }

    public boolean isWithinMeleeAttackRange(LivingEntity p_217067_) {
        return this.getAttackBoundingBox().intersects(p_217067_.getHitbox());
    }

    protected AABB getAttackBoundingBox() {
        Entity entity = this.getVehicle();
        AABB aabb;
        if (entity != null) {
            AABB aabb1 = entity.getBoundingBox();
            AABB aabb2 = this.getBoundingBox();
            aabb = new AABB(
                Math.min(aabb2.minX, aabb1.minX),
                aabb2.minY,
                Math.min(aabb2.minZ, aabb1.minZ),
                Math.max(aabb2.maxX, aabb1.maxX),
                aabb2.maxY,
                Math.max(aabb2.maxZ, aabb1.maxZ)
            );
        } else {
            aabb = this.getBoundingBox();
        }

        return aabb.inflate(DEFAULT_ATTACK_REACH, 0.0, DEFAULT_ATTACK_REACH);
    }

    @Override
    public boolean doHurtTarget(Entity p_21372_) {
        float f = (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
        float f1 = (float)this.getAttributeValue(Attributes.ATTACK_KNOCKBACK);
        if (p_21372_ instanceof LivingEntity) {
            f += EnchantmentHelper.getDamageBonus(this.getMainHandItem(), p_21372_.getType());
            f1 += (float)EnchantmentHelper.getKnockbackBonus(this);
        }

        int i = EnchantmentHelper.getFireAspect(this);
        if (i > 0) {
            p_21372_.igniteForSeconds(i * 4);
        }

        boolean flag = p_21372_.hurt(this.damageSources().mobAttack(this), f);
        if (flag) {
            if (f1 > 0.0F && p_21372_ instanceof LivingEntity) {
                ((LivingEntity)p_21372_)
                    .knockback(
                        (double)(f1 * 0.5F),
                        (double)Mth.sin(this.getYRot() * (float) (Math.PI / 180.0)),
                        (double)(-Mth.cos(this.getYRot() * (float) (Math.PI / 180.0)))
                    );
                this.setDeltaMovement(this.getDeltaMovement().multiply(0.6, 1.0, 0.6));
            }

            this.doEnchantDamageEffects(this, p_21372_);
            this.setLastHurtMob(p_21372_);
        }

        return flag;
    }

    protected boolean isSunBurnTick() {
        if (this.level().isDay() && !this.level().isClientSide) {
            float f = this.getLightLevelDependentMagicValue();
            BlockPos blockpos = BlockPos.containing(this.getX(), this.getEyeY(), this.getZ());
            boolean flag = this.isInWaterRainOrBubble() || this.isInPowderSnow || this.wasInPowderSnow;
            if (f > 0.5F && this.random.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && !flag && this.level().canSeeSky(blockpos)) {
                return true;
            }
        }

        return false;
    }

    @Override
    @Deprecated // FORGE: use jumpInFluid instead
    protected void jumpInLiquid(TagKey<Fluid> p_204045_) {
        this.jumpInLiquidInternal(() -> super.jumpInLiquid(p_204045_));
    }

    private void jumpInLiquidInternal(Runnable onSuper) {
        if (this.getNavigation().canFloat()) {
            onSuper.run();
        } else {
            this.setDeltaMovement(this.getDeltaMovement().add(0.0, 0.3, 0.0));
        }
    }

    @Override
    public void jumpInFluid(net.neoforged.neoforge.fluids.FluidType type) {
        this.jumpInLiquidInternal(() -> super.jumpInFluid(type));
    }

    @VisibleForTesting
    public void removeFreeWill() {
        this.removeAllGoals(p_262562_ -> true);
        this.getBrain().removeAllBehaviors();
    }

    public void removeAllGoals(Predicate<Goal> p_262667_) {
        this.goalSelector.removeAllGoals(p_262667_);
    }

    @Override
    protected void removeAfterChangingDimensions() {
        super.removeAfterChangingDimensions();
        this.dropLeash(true, false);
        this.getAllSlots().forEach(p_278936_ -> {
            if (!p_278936_.isEmpty()) {
                p_278936_.setCount(0);
            }
        });
    }

    @Nullable
    @Override
    public ItemStack getPickResult() {
        SpawnEggItem spawneggitem = SpawnEggItem.byId(this.getType());
        return spawneggitem == null ? null : new ItemStack(spawneggitem);
    }

    /**
    * Returns the type of spawn that created this mob, if applicable.
    * If it could not be determined, this will return null.
    * <p>
    * This is set via {@link Mob#finalizeSpawn}, so you should not call this from within that method, instead using the parameter.
    */
    @Nullable
    public final MobSpawnType getSpawnType() {
        return this.spawnType;
    }

    /**
     * This method exists so that spawns can be cancelled from the {@link net.neoforged.neoforge.event.entity.living.MobSpawnEvent.FinalizeSpawn FinalizeSpawnEvent}
     * without needing to hook up an additional handler for the {@link net.neoforged.neoforge.event.entity.EntityJoinLevelEvent EntityJoinLevelEvent}.
     * @return if this mob will be blocked from spawning during {@link Level#addFreshEntity(Entity)}
     * @apiNote Not public-facing API.
     */
    @org.jetbrains.annotations.ApiStatus.Internal
    public final boolean isSpawnCancelled() {
        return this.spawnCancelled;
    }

    /**
     * Marks this mob as being disallowed to spawn during {@link Level#addFreshEntity(Entity)}.<p>
     * @throws UnsupportedOperationException if this entity has already been {@link Entity#isAddedToWorld() added to the world}.
     * @apiNote Not public-facing API.
     */
    @org.jetbrains.annotations.ApiStatus.Internal
    public final void setSpawnCancelled(boolean cancel) {
        if (this.isAddedToWorld()) {
            throw new UnsupportedOperationException("Late invocations of Mob#setSpawnCancelled are not permitted.");
        }
        this.spawnCancelled = cancel;
    }
}
