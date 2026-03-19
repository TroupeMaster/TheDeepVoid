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
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.item.PerilItem;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.PerilBulletEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class PerilRightClickProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getDouble("shot") > 0 && (entity instanceof Player _plrCldRem3 ? _plrCldRem3.getCooldowns().getCooldownPercent(itemstack.getItem(), 0f) * 100 : 0) <= 0) {
			if (entity.isShiftKeyDown()) {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 60);
				if (Math.random() < 1 / itemstack.getOrCreateTag().getDouble("selfShot")) {
					itemstack.getOrCreateTag().putBoolean("shootSelf", true);
				}
				if (itemstack.getOrCreateTag().getBoolean("shootSelf") == true) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
						if (itemstack.getItem() instanceof PerilItem)
							itemstack.getOrCreateTag().putString("geckoAnim", "animation.peril_shootSelfLeft");
					} else {
						if (itemstack.getItem() instanceof PerilItem)
							itemstack.getOrCreateTag().putString("geckoAnim", "animation.peril_shootSelf");
					}
					if (world instanceof Level)
						((Level) world).playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:peril_cylinder")), SoundSource.PLAYERS, 1, 1, false);
				} else {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
						if (itemstack.getItem() instanceof PerilItem)
							itemstack.getOrCreateTag().putString("geckoAnim", "animation.peril_shootSelfFailLeft");
					} else {
						if (itemstack.getItem() instanceof PerilItem)
							itemstack.getOrCreateTag().putString("geckoAnim", "animation.peril_shootSelfFail");
					}
					if (world instanceof Level)
						((Level) world).playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:peril_cylinder")), SoundSource.PLAYERS, 1, 1, false);
					itemstack.getOrCreateTag().putDouble("selfShot", (itemstack.getOrCreateTag().getDouble("selfShot") - 1));
				}
				TheDeepVoidMod.queueServerWork(45, () -> {
					if (itemstack.getOrCreateTag().getBoolean("shootSelf") == true) {
						itemstack.getOrCreateTag().putBoolean("shootSelf", false);
						itemstack.getOrCreateTag().putDouble("adrenaline", 0);
						itemstack.getOrCreateTag().putDouble("selfShot", 6);
						entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:suicide")))),
								(float) (double) DeepVoidConfigConfiguration.PERILSELFDAMAGE.get());
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:peril_hammer_hit")), SoundSource.PLAYERS, 1, 1);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:peril_hammer_hit")), SoundSource.PLAYERS, 1, 1, false);
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:peril_shoot_new")), SoundSource.PLAYERS, 1, 1);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:peril_shoot_new")), SoundSource.PLAYERS, 1, 1, false);
							}
						}
						itemstack.getOrCreateTag().putDouble("shot", (itemstack.getOrCreateTag().getDouble("shot") - 1));
					} else {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:peril_hammer_hit")), SoundSource.PLAYERS, 1, 1);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:peril_hammer_hit")), SoundSource.PLAYERS, 1, 1, false);
							}
						}
						itemstack.getOrCreateTag().putDouble("adrenaline", (itemstack.getOrCreateTag().getDouble("adrenaline") + 1));
					}
				});
			} else {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 25);
				itemstack.getOrCreateTag().putDouble("shot", (itemstack.getOrCreateTag().getDouble("shot") - 1));
				if (itemstack.getItem() instanceof PerilItem)
					itemstack.getOrCreateTag().putString("geckoAnim", "animation.peril_shoot");
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new PerilBulletEntity(TheDeepVoidModEntities.PERIL_BULLET.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								entityToSpawn.setPierceLevel(piercing);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, (float) ((double) DeepVoidConfigConfiguration.PERIL.get() * (1 + itemstack.getOrCreateTag().getDouble("adrenaline") * (double) DeepVoidConfigConfiguration.PERILDAMAGEMULTIPLIER.get())), 0,
								(byte) 5);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				itemstack.getOrCreateTag().putDouble("adrenaline", 0);
				itemstack.getOrCreateTag().putDouble("selfShot", 6);
				if (world instanceof Level)
					((Level) world).playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:peril_hammer_hit")), SoundSource.PLAYERS, 1, 1, false);
				if (world instanceof Level)
					((Level) world).playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:peril_shoot_new")), SoundSource.PLAYERS, 1, 1, false);
				TheDeepVoidMod.queueServerWork(17, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:peril_cocking")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:peril_cocking")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
				});
			}
		} else if (itemstack.getOrCreateTag().getDouble("shot") <= 0) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 50);
			itemstack.getOrCreateTag().putDouble("shot", 6);
			itemstack.getOrCreateTag().putDouble("selfShot", 6);
			itemstack.getOrCreateTag().putDouble("adrenaline", 0);
			itemstack.getOrCreateTag().putBoolean("shootSelf", false);
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
				if (itemstack.getItem() instanceof PerilItem)
					itemstack.getOrCreateTag().putString("geckoAnim", "animation.peril_reloadLeft");
			} else {
				if (itemstack.getItem() instanceof PerilItem)
					itemstack.getOrCreateTag().putString("geckoAnim", "animation.peril_reload");
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50, 4, false, false));
			TheDeepVoidMod.queueServerWork(10, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:peril_cylinder")), SoundSource.PLAYERS, 1,
								Mth.nextInt(RandomSource.create(), 1, (int) 1.1));
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:peril_cylinder")), SoundSource.PLAYERS, 1,
								Mth.nextInt(RandomSource.create(), 1, (int) 1.1), false);
					}
				}
			});
			TheDeepVoidMod.queueServerWork(25, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fox.bite")), SoundSource.PLAYERS, 1,
								(float) Mth.nextDouble(RandomSource.create(), 0.8, 0.9));
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fox.bite")), SoundSource.PLAYERS, 1,
								(float) Mth.nextDouble(RandomSource.create(), 0.8, 0.9), false);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:flesh")), SoundSource.PLAYERS, 1,
								(float) Mth.nextDouble(RandomSource.create(), 0.9, 1));
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:flesh")), SoundSource.PLAYERS, 1,
								(float) Mth.nextDouble(RandomSource.create(), 0.9, 1), false);
					}
				}
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)), 4);
			});
			TheDeepVoidMod.queueServerWork(38, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:peril_cylinder")), SoundSource.PLAYERS, 1,
								Mth.nextInt(RandomSource.create(), (int) 0.9, 1));
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:peril_cylinder")), SoundSource.PLAYERS, 1,
								Mth.nextInt(RandomSource.create(), (int) 0.9, 1), false);
					}
				}
			});
			TheDeepVoidMod.queueServerWork(45, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:peril_cocking")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:peril_cocking")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
			});
		}
	}
}
