package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;

import java.util.List;
import java.util.Comparator;

public class ArmorAbilityVultureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).vultureArmorAbility <= 0) {
			if (entity.isShiftKeyDown()) {
				{
					double _setval = 50;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.vultureArmorAbility = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity.onGround() && !(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(TheDeepVoidModMobEffects.WEAVER_CURSE.get()))) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:death_vulture_ambient")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:death_vulture_ambient")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
					entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 1.5), 1.25, (Math.cos(Math.toRadians(entity.getYRot())) * 1.5)));
				}
			} else {
				{
					double _setval = 100;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.vultureArmorAbility = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if ((entity instanceof Player _plr10 ? _plr10.getArrowCount() : 0) > 0) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:death_vulture_ambient")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:death_vulture_ambient")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
					while ((entity instanceof Player _plr15 ? _plr15.getArrowCount() : 0) > 0) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")), SoundSource.PLAYERS, 1,
										(float) Mth.nextDouble(RandomSource.create(), 5 / 6, 1.25));
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")), SoundSource.PLAYERS, 1,
										(float) Mth.nextDouble(RandomSource.create(), 5 / 6, 1.25), false);
							}
						}
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(35 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator == entity) && !(entityiterator == (entity.getVehicle()))
										&& !(entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false)
										&& (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
									if (world instanceof ServerLevel projectileLevel) {
										Projectile _entityToSpawn = new Object() {
											public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
												AbstractArrow entityToSpawn = new Arrow(EntityType.ARROW, level);
												entityToSpawn.setOwner(shooter);
												entityToSpawn.setBaseDamage(damage);
												entityToSpawn.setKnockback(knockback);
												entityToSpawn.setCritArrow(true);
												entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
												return entityToSpawn;
											}
										}.getArrow(projectileLevel, entity, 3, (int) 0.25);
										_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1.6), (entity.getZ()));
										_entityToSpawn.shoot((entityiterator.getX() - entity.getX()), ((entityiterator.getY() + entityiterator.getEyeHeight()) - (entity.getY() + 1.6)), (entityiterator.getZ() - entity.getZ()), 3, 5);
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
									if (entity instanceof Player _plr39)
										_plr39.setArrowCount((int) ((entity instanceof Player _plr38 ? _plr38.getArrowCount() : 0) - 1));
								}
							}
						}
					}
					if (entity instanceof Player _plr41)
						_plr41.setArrowCount(0);
				}
			}
		}
	}
}
