package net.minecraft.world.level.block.entity.trialspawner;

import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.serialization.codecs.RecordCodecBuilder.Instance;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import javax.annotation.Nullable;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.UUIDUtil;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.random.WeightedEntry;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.SpawnData;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class TrialSpawnerData {
    public static final String TAG_SPAWN_DATA = "spawn_data";
    private static final String TAG_NEXT_MOB_SPAWNS_AT = "next_mob_spawns_at";
    private static final int DELAY_BETWEEN_PLAYER_SCANS = 20;
    private static final int TRIAL_OMEN_PER_BAD_OMEN_LEVEL = 18000;
    public static MapCodec<TrialSpawnerData> MAP_CODEC = RecordCodecBuilder.mapCodec(
        p_312830_ -> p_312830_.group(
                    UUIDUtil.CODEC_SET.lenientOptionalFieldOf("registered_players", Sets.newHashSet()).forGetter(p_312495_ -> p_312495_.detectedPlayers),
                    UUIDUtil.CODEC_SET.lenientOptionalFieldOf("current_mobs", Sets.newHashSet()).forGetter(p_312798_ -> p_312798_.currentMobs),
                    Codec.LONG.lenientOptionalFieldOf("cooldown_ends_at", Long.valueOf(0L)).forGetter(p_312792_ -> p_312792_.cooldownEndsAt),
                    Codec.LONG.lenientOptionalFieldOf("next_mob_spawns_at", Long.valueOf(0L)).forGetter(p_311772_ -> p_311772_.nextMobSpawnsAt),
                    Codec.intRange(0, Integer.MAX_VALUE).lenientOptionalFieldOf("total_mobs_spawned", 0).forGetter(p_312862_ -> p_312862_.totalMobsSpawned),
                    SpawnData.CODEC.lenientOptionalFieldOf("spawn_data").forGetter(p_312634_ -> p_312634_.nextSpawnData),
                    ResourceKey.codec(Registries.LOOT_TABLE).lenientOptionalFieldOf("ejecting_loot_table").forGetter(p_312388_ -> p_312388_.ejectingLootTable)
                )
                .apply(p_312830_, TrialSpawnerData::new)
    );
    protected final Set<UUID> detectedPlayers = new HashSet<>();
    protected final Set<UUID> currentMobs = new HashSet<>();
    protected long cooldownEndsAt;
    protected long nextMobSpawnsAt;
    protected int totalMobsSpawned;
    protected Optional<SpawnData> nextSpawnData;
    protected Optional<ResourceKey<LootTable>> ejectingLootTable;
    @Nullable
    protected Entity displayEntity;
    @Nullable
    private SimpleWeightedRandomList<ItemStack> dispensing;
    protected double spin;
    protected double oSpin;

    public TrialSpawnerData() {
        this(Collections.emptySet(), Collections.emptySet(), 0L, 0L, 0, Optional.empty(), Optional.empty());
    }

    public TrialSpawnerData(
        Set<UUID> p_312283_,
        Set<UUID> p_312919_,
        long p_312537_,
        long p_311955_,
        int p_312227_,
        Optional<SpawnData> p_312562_,
        Optional<ResourceKey<LootTable>> p_312406_
    ) {
        this.detectedPlayers.addAll(p_312283_);
        this.currentMobs.addAll(p_312919_);
        this.cooldownEndsAt = p_312537_;
        this.nextMobSpawnsAt = p_311955_;
        this.totalMobsSpawned = p_312227_;
        this.nextSpawnData = p_312562_;
        this.ejectingLootTable = p_312406_;
    }

    public void reset() {
        this.detectedPlayers.clear();
        this.totalMobsSpawned = 0;
        this.nextMobSpawnsAt = 0L;
        this.cooldownEndsAt = 0L;
        this.currentMobs.clear();
    }

    public boolean hasMobToSpawn(TrialSpawner p_331432_, RandomSource p_330985_) {
        boolean flag = this.getOrCreateNextSpawnData(p_331432_, p_330985_).getEntityToSpawn().contains("id", 8);
        return flag || !p_331432_.getConfig().spawnPotentialsDefinition().isEmpty();
    }

    public boolean hasFinishedSpawningAllMobs(TrialSpawnerConfig p_311805_, int p_312034_) {
        return this.totalMobsSpawned >= p_311805_.calculateTargetTotalMobs(p_312034_);
    }

    public boolean haveAllCurrentMobsDied() {
        return this.currentMobs.isEmpty();
    }

    public boolean isReadyToSpawnNextMob(ServerLevel p_311818_, TrialSpawnerConfig p_312100_, int p_312550_) {
        return p_311818_.getGameTime() >= this.nextMobSpawnsAt && this.currentMobs.size() < p_312100_.calculateTargetSimultaneousMobs(p_312550_);
    }

    public int countAdditionalPlayers(BlockPos p_312262_) {
        if (this.detectedPlayers.isEmpty()) {
            Util.logAndPauseIfInIde("Trial Spawner at " + p_312262_ + " has no detected players");
        }

        return Math.max(0, this.detectedPlayers.size() - 1);
    }

    public void tryDetectPlayers(ServerLevel p_311852_, BlockPos p_312503_, TrialSpawner p_338452_) {
        boolean flag = (p_312503_.asLong() + p_311852_.getGameTime()) % 20L != 0L;
        if (!flag) {
            if (!p_338452_.getState().equals(TrialSpawnerState.COOLDOWN) || !p_338452_.isOminous()) {
                List<UUID> list = p_338452_.getPlayerDetector()
                    .detect(p_311852_, p_338452_.getEntitySelector(), p_312503_, (double)p_338452_.getRequiredPlayerRange(), true);
                Player player = null;

                for (UUID uuid : list) {
                    Player player1 = p_311852_.getPlayerByUUID(uuid);
                    if (player1 != null) {
                        if (player1.hasEffect(MobEffects.BAD_OMEN)) {
                            this.transformBadOmenIntoTrialOmen(player1, player1.getEffect(MobEffects.BAD_OMEN));
                            player = player1;
                        } else if (player1.hasEffect(MobEffects.TRIAL_OMEN)) {
                            player = player1;
                        }
                    }
                }

                boolean flag1 = !p_338452_.isOminous() && player != null;
                if (!p_338452_.getState().equals(TrialSpawnerState.COOLDOWN) || flag1) {
                    if (flag1) {
                        p_311852_.levelEvent(3020, BlockPos.containing(player.getEyePosition()), 0);
                        p_338452_.applyOminous(p_311852_, p_312503_);
                    }

                    boolean flag2 = p_338452_.getData().detectedPlayers.isEmpty();
                    List<UUID> list1 = flag2
                        ? list
                        : p_338452_.getPlayerDetector()
                            .detect(p_311852_, p_338452_.getEntitySelector(), p_312503_, (double)p_338452_.getRequiredPlayerRange(), false);
                    if (this.detectedPlayers.addAll(list1)) {
                        this.nextMobSpawnsAt = Math.max(p_311852_.getGameTime() + 40L, this.nextMobSpawnsAt);
                        if (!flag1) {
                            int i = p_338452_.isOminous() ? 3019 : 3013;
                            p_311852_.levelEvent(i, p_312503_, this.detectedPlayers.size());
                        }
                    }
                }
            }
        }
    }

    public void resetAfterBecomingOminous(TrialSpawner p_338478_, ServerLevel p_338185_) {
        this.currentMobs.stream().map(p_338185_::getEntity).forEach(p_338043_ -> {
            if (p_338043_ != null) {
                p_338185_.levelEvent(3012, p_338043_.blockPosition(), TrialSpawner.FlameParticle.NORMAL.encode());
                p_338043_.remove(Entity.RemovalReason.DISCARDED);
            }
        });
        if (!p_338478_.getOminousConfig().spawnPotentialsDefinition().isEmpty()) {
            this.nextSpawnData = Optional.empty();
        }

        this.totalMobsSpawned = 0;
        this.currentMobs.clear();
        this.nextMobSpawnsAt = p_338185_.getGameTime() + (long)p_338478_.getOminousConfig().ticksBetweenSpawn();
        p_338478_.markUpdated();
        this.cooldownEndsAt = p_338185_.getGameTime() + p_338478_.getOminousConfig().ticksBetweenItemSpawners();
    }

    private void transformBadOmenIntoTrialOmen(Player p_338616_, MobEffectInstance p_338599_) {
        int i = p_338599_.getAmplifier() + 1;
        int j = 18000 * i;
        p_338616_.removeEffect(MobEffects.BAD_OMEN);
        p_338616_.addEffect(new MobEffectInstance(MobEffects.TRIAL_OMEN, j, 0));
    }

    public boolean isReadyToOpenShutter(ServerLevel p_312291_, float p_312417_, int p_338634_) {
        long i = this.cooldownEndsAt - (long)p_338634_;
        return (float)p_312291_.getGameTime() >= (float)i + p_312417_;
    }

    public boolean isReadyToEjectItems(ServerLevel p_312692_, float p_312374_, int p_338651_) {
        long i = this.cooldownEndsAt - (long)p_338651_;
        return (float)(p_312692_.getGameTime() - i) % p_312374_ == 0.0F;
    }

    public boolean isCooldownFinished(ServerLevel p_312743_) {
        return p_312743_.getGameTime() >= this.cooldownEndsAt;
    }

    public void setEntityId(TrialSpawner p_312044_, RandomSource p_312864_, EntityType<?> p_312415_) {
        this.getOrCreateNextSpawnData(p_312044_, p_312864_).getEntityToSpawn().putString("id", BuiltInRegistries.ENTITY_TYPE.getKey(p_312415_).toString());
    }

    protected SpawnData getOrCreateNextSpawnData(TrialSpawner p_312745_, RandomSource p_312242_) {
        if (this.nextSpawnData.isPresent()) {
            return this.nextSpawnData.get();
        } else {
            SimpleWeightedRandomList<SpawnData> simpleweightedrandomlist = p_312745_.getConfig().spawnPotentialsDefinition();
            Optional<SpawnData> optional = simpleweightedrandomlist.isEmpty()
                ? this.nextSpawnData
                : simpleweightedrandomlist.getRandom(p_312242_).map(WeightedEntry.Wrapper::data);
            this.nextSpawnData = Optional.of(optional.orElseGet(SpawnData::new));
            p_312745_.markUpdated();
            return this.nextSpawnData.get();
        }
    }

    @Nullable
    public Entity getOrCreateDisplayEntity(TrialSpawner p_312366_, Level p_312148_, TrialSpawnerState p_311790_) {
        if (p_312366_.canSpawnInLevel(p_312148_) && p_311790_.hasSpinningMob()) {
            if (this.displayEntity == null) {
                CompoundTag compoundtag = this.getOrCreateNextSpawnData(p_312366_, p_312148_.getRandom()).getEntityToSpawn();
                if (compoundtag.contains("id", 8)) {
                    this.displayEntity = EntityType.loadEntityRecursive(compoundtag, p_312148_, Function.identity());
                }
            }

            return this.displayEntity;
        } else {
            return null;
        }
    }

    public CompoundTag getUpdateTag(TrialSpawnerState p_312104_) {
        CompoundTag compoundtag = new CompoundTag();
        if (p_312104_ == TrialSpawnerState.ACTIVE) {
            compoundtag.putLong("next_mob_spawns_at", this.nextMobSpawnsAt);
        }

        this.nextSpawnData
            .ifPresent(
                p_338045_ -> compoundtag.put(
                        "spawn_data",
                        SpawnData.CODEC.encodeStart(NbtOps.INSTANCE, p_338045_).result().orElseThrow(() -> new IllegalStateException("Invalid SpawnData"))
                    )
            );
        return compoundtag;
    }

    public double getSpin() {
        return this.spin;
    }

    public double getOSpin() {
        return this.oSpin;
    }

    SimpleWeightedRandomList<ItemStack> getDispensingItems(ServerLevel p_338857_, TrialSpawnerConfig p_338213_, BlockPos p_338577_) {
        if (this.dispensing != null) {
            return this.dispensing;
        } else {
            LootTable loottable = p_338857_.getServer().reloadableRegistries().getLootTable(p_338213_.itemsToDropWhenOminous());
            LootParams lootparams = new LootParams.Builder(p_338857_).create(LootContextParamSets.EMPTY);
            long i = lowResolutionPosition(p_338857_, p_338577_);
            ObjectArrayList<ItemStack> objectarraylist = loottable.getRandomItems(lootparams, i);
            if (objectarraylist.isEmpty()) {
                return SimpleWeightedRandomList.empty();
            } else {
                SimpleWeightedRandomList.Builder<ItemStack> builder = new SimpleWeightedRandomList.Builder<>();

                for (ItemStack itemstack : objectarraylist) {
                    builder.add(itemstack.copyWithCount(1), itemstack.getCount());
                }

                this.dispensing = builder.build();
                return this.dispensing;
            }
        }
    }

    private static long lowResolutionPosition(ServerLevel p_338878_, BlockPos p_338542_) {
        BlockPos blockpos = new BlockPos(
            Mth.floor((float)p_338542_.getX() / 30.0F), Mth.floor((float)p_338542_.getY() / 20.0F), Mth.floor((float)p_338542_.getZ() / 30.0F)
        );
        return p_338878_.getSeed() + blockpos.asLong();
    }
}
