package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.RotKnifeEntity;
import net.mcreator.thedeepvoid.entity.PoisonKnifeEntity;
import net.mcreator.thedeepvoid.entity.BloodSpitEntity;

import javax.annotation.Nullable;

import java.util.concurrent.atomic.AtomicReference;

@Mod.EventBusSubscriber
public class AdaptiveClawToolInHandTickProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getSource(), event.getEntity(), event.getSource().getDirectEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, DamageSource damagesource, Entity entity, Entity immediatesourceentity, Entity sourceentity, double amount) {
		execute(null, world, damagesource, entity, immediatesourceentity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, DamageSource damagesource, Entity entity, Entity immediatesourceentity, Entity sourceentity, double amount) {
		if (damagesource == null || entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.ADAPTIVE_CLAW.get()
				&& !damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:void_energy"))) && immediatesourceentity == sourceentity) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
			(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("damage", 0);
			(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putString("claw", "");
			{
				AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
				sourceentity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
				if (_iitemhandlerref.get() != null) {
					for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
						ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
						if (itemstackiterator.is(ItemTags.create(new ResourceLocation("the_deep_void:claws"))) && !(itemstackiterator.getItem() == TheDeepVoidModItems.ADAPTIVE_CLAW.get())) {
							(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("damage",
									((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("damage") + 0.65));
							if (Math.random() < 0.25 && ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("claw")).isEmpty()) {
								(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putString("claw", (ForgeRegistries.ITEMS.getKey(itemstackiterator.getItem()).toString()));
							}
						}
					}
				}
			}
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:void_energy"))), sourceentity),
					(float) (amount + Math.round(Math.sqrt((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("damage")) * 1.55)));
			if ((sourceentity instanceof Player _plr ? _plr.getAttackStrengthScale(0) : 0) >= 0.848) {
				if (ForgeRegistries.ITEMS.getValue(new ResourceLocation(
						(((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("claw"))).toLowerCase(java.util.Locale.ENGLISH))) == TheDeepVoidModItems.STALKER_SCYTHE_CLAW.get()) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.DECOMPOSITION.get(), 200, 0));
				} else if (ForgeRegistries.ITEMS.getValue(new ResourceLocation(
						(((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("claw"))).toLowerCase(java.util.Locale.ENGLISH))) == TheDeepVoidModItems.FLESH_GLOVE.get()) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.LACERATION.get(), 40, 0));
				} else if (ForgeRegistries.ITEMS.getValue(new ResourceLocation(
						(((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("claw"))).toLowerCase(java.util.Locale.ENGLISH))) == TheDeepVoidModItems.PLAGUE_DOCTOR_GLOVE.get()) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.PLAGUE.get(), 100, 0));
				} else if (ForgeRegistries.ITEMS.getValue(new ResourceLocation(
						(((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("claw"))).toLowerCase(java.util.Locale.ENGLISH))) == TheDeepVoidModItems.RUSTY_CLAWS.get()) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.BROKEN_ARMOR.get(), 30, 0));
				} else if (ForgeRegistries.ITEMS.getValue(new ResourceLocation(
						(((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("claw"))).toLowerCase(java.util.Locale.ENGLISH))) == TheDeepVoidModItems.HUNTER_CLAWS.get()) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.ROT.get(), 50, 1));
				} else if (ForgeRegistries.ITEMS.getValue(new ResourceLocation(
						(((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("claw"))).toLowerCase(java.util.Locale.ENGLISH))) == TheDeepVoidModItems.BONE_CRAWLER_CLAW.get()) {
					if (entity instanceof LivingEntity _livEnt57 && _livEnt57.hasEffect(TheDeepVoidModMobEffects.ROT.get())) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.ROT.get(),
									entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.ROT.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.ROT.get()).getDuration() : 0,
									(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.ROT.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.ROT.get()).getAmplifier() : 0) + 1)));
					}
				} else if (ForgeRegistries.ITEMS.getValue(new ResourceLocation(
						(((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("claw"))).toLowerCase(java.util.Locale.ENGLISH))) == TheDeepVoidModItems.KNIVES_GLOVE.get()) {
					{
						Entity _shootFrom = sourceentity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new PoisonKnifeEntity(TheDeepVoidModEntities.POISON_KNIFE.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, sourceentity, 2, (int) 0.1);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, (float) 1.4, 5);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
					{
						Entity _shootFrom = sourceentity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new RotKnifeEntity(TheDeepVoidModEntities.ROT_KNIFE.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, sourceentity, 2, (int) 0.1);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, (float) 1.4, 5);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
				} else if (ForgeRegistries.ITEMS.getValue(new ResourceLocation(
						(((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("claw"))).toLowerCase(java.util.Locale.ENGLISH))) == TheDeepVoidModItems.BLOODTHIRSTY_CLAWS.get()) {
					{
						Entity _shootFrom = sourceentity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new BloodSpitEntity(TheDeepVoidModEntities.BLOOD_SPIT.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, sourceentity, 2, (int) 0.1);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, (float) 1.6, 5);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
				} else if (ForgeRegistries.ITEMS.getValue(new ResourceLocation(
						(((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("claw"))).toLowerCase(java.util.Locale.ENGLISH))) == TheDeepVoidModItems.CHAIN_GAUNTLET.get()) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.CHAINED.get(), 30, 0));
				}
				if (!sourceentity.onGround()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.crit")), SoundSource.PLAYERS, 1,
									1);
						} else {
							_level.playLocalSound((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.crit")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
				} else {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:claws_slash")), SoundSource.PLAYERS, 1,
									(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
						} else {
							_level.playLocalSound((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:claws_slash")), SoundSource.PLAYERS, 1,
									(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
						}
					}
				}
			}
		}
	}
}
