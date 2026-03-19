package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;
import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.WeaverOfSoulsBossEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.Comparator;

public class WeaverOfSoulsOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 80, 80, 80), e -> true).isEmpty()
				&& !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty())
				&& (entity instanceof WeaverOfSoulsBossEntity _datEntL8 && _datEntL8.getEntityData().get(WeaverOfSoulsBossEntity.DATA_stunned)) == false) {
			if ((entity instanceof WeaverOfSoulsBossEntity _datEntI ? _datEntI.getEntityData().get(WeaverOfSoulsBossEntity.DATA_locate) : 0) >= 80) {
				if (entity instanceof WeaverOfSoulsBossEntity _datEntSetI)
					_datEntSetI.getEntityData().set(WeaverOfSoulsBossEntity.DATA_locate, 0);
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 80, 80, 80), e -> true).isEmpty()
						&& !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty())) {
					TheDeepVoidMod.queueServerWork(40, () -> {
						if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 80, 80, 80), e -> true).isEmpty()
								&& !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty())) {
							if (!((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 80, 80, 80), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).isShiftKeyDown()) {
								if (entity instanceof Mob _entity)
									_entity.getNavigation().moveTo((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 80, 80, 80), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX() + Mth.nextInt(RandomSource.create(), -20, 20)), (entity.getY()),
											(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 80, 80, 80), e -> true).stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
												}
											}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ() + Mth.nextInt(RandomSource.create(), -20, 20)), 1);
							}
						}
					});
				}
			} else {
				if (entity instanceof WeaverOfSoulsBossEntity _datEntSetI)
					_datEntSetI.getEntityData().set(WeaverOfSoulsBossEntity.DATA_locate, (int) ((entity instanceof WeaverOfSoulsBossEntity _datEntI ? _datEntI.getEntityData().get(WeaverOfSoulsBossEntity.DATA_locate) : 0) + 1));
			}
		}
		WeaverSpawnHandSpawnsProcedure.execute(world, entity);
		WeaverSpawnHandWallProcedure.execute(world, entity);
		WeaverIsStunnedProcedure.execute(world, x, y, z, entity);
		WeaverSpawnHandBlockadeProcedure.execute(world, entity);
		WeaverBreakEnderPearlProcedure.execute(world, x, y, z);
		if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 110, 110, 110), e -> true).isEmpty()) && DeepVoidConfigConfiguration.BOSSIDLES.get() == true) {
			if (!entity.level().isClientSide())
				entity.discard();
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:fog_appear")), SoundSource.HOSTILE, 1, (float) 0.8);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:fog_appear")), SoundSource.HOSTILE, 1, (float) 0.8, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SQUID_INK, x, y, z, 25, 0, 0.8, 0, 0.1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.DARK_TEAR.get()), x, y, z, 25, 0, 0.8, 0, 0.1);
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(TheDeepVoidModItems.HEXED_DOLL.get()));
				entityToSpawn.setPickUpDelay(10);
				entityToSpawn.setUnlimitedLifetime();
				_level.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"stopsound @a record the_deep_void:darkmare");
			TheDeepVoidMod.queueServerWork(20, () -> {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"stopsound @a record the_deep_void:darkmare");
			});
		}
		if ((entity instanceof WeaverOfSoulsBossEntity _datEntI ? _datEntI.getEntityData().get(WeaverOfSoulsBossEntity.DATA_scream) : 0) > 0) {
			if (entity instanceof WeaverOfSoulsBossEntity _datEntSetI)
				_datEntSetI.getEntityData().set(WeaverOfSoulsBossEntity.DATA_scream, (int) ((entity instanceof WeaverOfSoulsBossEntity _datEntI ? _datEntI.getEntityData().get(WeaverOfSoulsBossEntity.DATA_scream) : 0) - 1));
		}
		if ((entity instanceof WeaverOfSoulsBossEntity _datEntI ? _datEntI.getEntityData().get(WeaverOfSoulsBossEntity.DATA_scream) : 0) <= 0
				&& (entity instanceof WeaverOfSoulsBossEntity _datEntL63 && _datEntL63.getEntityData().get(WeaverOfSoulsBossEntity.DATA_screamPlayed)) == true) {
			if (entity instanceof WeaverOfSoulsBossEntity _datEntSetL)
				_datEntSetL.getEntityData().set(WeaverOfSoulsBossEntity.DATA_screamPlayed, false);
		}
		if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 90, 90, 90), e -> true).isEmpty())
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) != (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() > entity.getY() + 3) {
				if ((entity instanceof WeaverOfSoulsBossEntity _datEntI ? _datEntI.getEntityData().get(WeaverOfSoulsBossEntity.DATA_giantHand) : 0) >= 200) {
					if (entity instanceof WeaverOfSoulsBossEntity _datEntSetI)
						_datEntSetI.getEntityData().set(WeaverOfSoulsBossEntity.DATA_giantHand, 0);
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.GIANT_SHADOW_HAND.get().spawn(_level, BlockPos.containing((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX(),
								(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 1, (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.GIANT_SHADOW_HAND.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 3, entity.getZ()), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				} else {
					if (entity instanceof WeaverOfSoulsBossEntity _datEntSetI)
						_datEntSetI.getEntityData().set(WeaverOfSoulsBossEntity.DATA_giantHand, (int) ((entity instanceof WeaverOfSoulsBossEntity _datEntI ? _datEntI.getEntityData().get(WeaverOfSoulsBossEntity.DATA_giantHand) : 0) + 1));
				}
			}
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).isEmpty()) {
			if ((entity instanceof WeaverOfSoulsBossEntity _datEntI ? _datEntI.getEntityData().get(WeaverOfSoulsBossEntity.DATA_murmurs) : 0) >= 800) {
				if (entity instanceof WeaverOfSoulsBossEntity _datEntSetI)
					_datEntSetI.getEntityData().set(WeaverOfSoulsBossEntity.DATA_murmurs, 0);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:ominous_murmurs")), SoundSource.AMBIENT, 3, 1);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:ominous_murmurs")), SoundSource.AMBIENT, 3, 1, false);
					}
				}
			} else {
				if (entity instanceof WeaverOfSoulsBossEntity _datEntSetI)
					_datEntSetI.getEntityData().set(WeaverOfSoulsBossEntity.DATA_murmurs, (int) ((entity instanceof WeaverOfSoulsBossEntity _datEntI ? _datEntI.getEntityData().get(WeaverOfSoulsBossEntity.DATA_murmurs) : 0) + 1));
			}
		}
		if ((entity instanceof WeaverOfSoulsBossEntity _datEntL102 && _datEntL102.getEntityData().get(WeaverOfSoulsBossEntity.DATA_stunned)) == false) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeAllEffects();
		}
		WeaverBossMusicProcedure.execute(world, x, y, z, entity);
	}
}
