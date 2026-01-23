package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.RotKnifeEntity;
import net.mcreator.thedeepvoid.entity.PoisonKnifeEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class KnifeBandolierRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getDouble("count") >= (double) DeepVoidConfigConfiguration.KNIFEBANDOLIERTIMEBEFORECHARGE.get() / 4.5
				&& itemstack.getOrCreateTag().getDouble("count") < (double) DeepVoidConfigConfiguration.KNIFEBANDOLIERTIMEBEFORECHARGE.get() / 2.25) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 5);
			itemstack.getOrCreateTag().putDouble("count", 0);
			if (Math.random() < 0.5) {
				{
					Entity _shootFrom = entity;
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
						}.getArrow(projectileLevel, entity, (float) ((double) DeepVoidConfigConfiguration.KNIFEBANDOLIERKNIFE.get() - 2), 0);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, (float) 1.4, 5);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			} else {
				{
					Entity _shootFrom = entity;
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
						}.getArrow(projectileLevel, entity, (float) ((double) DeepVoidConfigConfiguration.KNIFEBANDOLIERKNIFE.get() - 2), 0);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, (float) 1.4, 5);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.PLAYERS, 1, (float) Mth.nextDouble(RandomSource.create(), 1.4, 1.6));
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.PLAYERS, 1, (float) Mth.nextDouble(RandomSource.create(), 1.4, 1.6), false);
				}
			}
		} else if (itemstack.getOrCreateTag().getDouble("count") >= (double) DeepVoidConfigConfiguration.KNIFEBANDOLIERTIMEBEFORECHARGE.get() / 2.25
				&& itemstack.getOrCreateTag().getDouble("count") < (double) DeepVoidConfigConfiguration.KNIFEBANDOLIERTIMEBEFORECHARGE.get() / 1.5) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 5);
			itemstack.getOrCreateTag().putDouble("count", 0);
			KnifeBandolierSimpleShootProcedure.execute(world, x, y, z, entity);
		} else if (itemstack.getOrCreateTag().getDouble("count") >= (double) DeepVoidConfigConfiguration.KNIFEBANDOLIERTIMEBEFORECHARGE.get() / 1.5
				&& itemstack.getOrCreateTag().getDouble("count") < (double) DeepVoidConfigConfiguration.KNIFEBANDOLIERTIMEBEFORECHARGE.get()) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 5);
			itemstack.getOrCreateTag().putDouble("count", 0);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:apostle_laugh")), SoundSource.PLAYERS, 2, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:apostle_laugh")), SoundSource.PLAYERS, 2, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
				}
			}
			KnifeBandolierSmallSpinProcedure.execute(world, x, y, z, entity);
			TheDeepVoidMod.queueServerWork(10, () -> {
				KnifeBandolierSmallSpinProcedure.execute(world, x, y, z, entity);
			});
			TheDeepVoidMod.queueServerWork(20, () -> {
				KnifeBandolierSmallSpinProcedure.execute(world, x, y, z, entity);
			});
		} else if (itemstack.getOrCreateTag().getDouble("count") >= (double) DeepVoidConfigConfiguration.KNIFEBANDOLIERTIMEBEFORECHARGE.get()) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 5);
			itemstack.getOrCreateTag().putDouble("count", (-40));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, false, false));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:apostle_hysterical_laugh")), SoundSource.PLAYERS, 4,
							(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:apostle_hysterical_laugh")), SoundSource.PLAYERS, 4, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
				}
			}
			KnifeBandolierSpinProcedure.execute(world, x, y, z, entity);
			TheDeepVoidMod.queueServerWork(5, () -> {
				KnifeBandolierSpinProcedure.execute(world, x, y, z, entity);
			});
			TheDeepVoidMod.queueServerWork(10, () -> {
				KnifeBandolierSpinProcedure.execute(world, x, y, z, entity);
			});
			TheDeepVoidMod.queueServerWork(15, () -> {
				KnifeBandolierSpinProcedure.execute(world, x, y, z, entity);
			});
			TheDeepVoidMod.queueServerWork(20, () -> {
				KnifeBandolierSpinProcedure.execute(world, x, y, z, entity);
			});
			TheDeepVoidMod.queueServerWork(25, () -> {
				KnifeBandolierSpinProcedure.execute(world, x, y, z, entity);
			});
			TheDeepVoidMod.queueServerWork(30, () -> {
				KnifeBandolierSpinProcedure.execute(world, x, y, z, entity);
			});
			TheDeepVoidMod.queueServerWork(35, () -> {
				KnifeBandolierSpinProcedure.execute(world, x, y, z, entity);
			});
			TheDeepVoidMod.queueServerWork(40, () -> {
				KnifeBandolierSpinProcedure.execute(world, x, y, z, entity);
			});
		}
	}
}
