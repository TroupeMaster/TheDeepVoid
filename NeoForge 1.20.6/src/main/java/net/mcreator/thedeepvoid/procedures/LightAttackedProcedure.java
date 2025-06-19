package net.mcreator.thedeepvoid.procedures;

import net.neoforged.neoforge.event.entity.living.LivingAttackEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.entity.WeaverOfSoulsEntity;
import net.mcreator.thedeepvoid.entity.ThrownSoulSeekerEntity;
import net.mcreator.thedeepvoid.entity.SummonedShadowHandEntity;
import net.mcreator.thedeepvoid.entity.SummonedCharredSpikeEntity;
import net.mcreator.thedeepvoid.entity.SulfurTntEntityEntity;
import net.mcreator.thedeepvoid.entity.StalkingStalkerEntity;
import net.mcreator.thedeepvoid.entity.SoulOrbEntity;
import net.mcreator.thedeepvoid.entity.ShadowHandEntity;
import net.mcreator.thedeepvoid.entity.ShadowEntity;
import net.mcreator.thedeepvoid.entity.RootedCloneEntity;
import net.mcreator.thedeepvoid.entity.MultipleEyesEntity;
import net.mcreator.thedeepvoid.entity.LightEntity;
import net.mcreator.thedeepvoid.entity.HandSpawnEntity;
import net.mcreator.thedeepvoid.entity.FourEyesEntity;
import net.mcreator.thedeepvoid.entity.DeathMawHiddenEntity;
import net.mcreator.thedeepvoid.entity.DamnedEntity;
import net.mcreator.thedeepvoid.entity.CrossEyesEntity;
import net.mcreator.thedeepvoid.entity.CharredSpikeEntity;
import net.mcreator.thedeepvoid.entity.BigEyeEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@EventBusSubscriber
public class LightAttackedProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof LightEntity) {
			if (DeepVoidConfigConfiguration.DESTROYLIGHTSOURCES.get() == true) {
				if (sourceentity == null) {
					if (event instanceof ICancellableEvent _cancellable) {
						_cancellable.setCanceled(true);
					}
				}
				if (!(sourceentity instanceof ShadowEntity)) {
					if (event instanceof ICancellableEvent _cancellable) {
						_cancellable.setCanceled(true);
					}
				} else {
					if (!entity.level().isClientSide())
						entity.discard();
					TheDeepVoidMod.queueServerWork(15, () -> {
						if (!sourceentity.level().isClientSide())
							sourceentity.discard();
					});
					if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 0.45, entity.getZ())).getLightEmission(world, BlockPos.containing(entity.getX(), entity.getY() - 0.45, entity.getZ())) > 0) {
						TheDeepVoidMod.queueServerWork(15, () -> {
							world.destroyBlock(BlockPos.containing(entity.getX(), entity.getY() - 0.45, entity.getZ()), false);
						});
					}
					if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).getLightEmission(world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())) > 0) {
						TheDeepVoidMod.queueServerWork(15, () -> {
							world.destroyBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), false);
						});
					}
				}
				if (sourceentity instanceof StalkingStalkerEntity) {
					if (!entity.level().isClientSide())
						entity.discard();
					if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 0.45, entity.getZ())).getLightEmission(world, BlockPos.containing(entity.getX(), entity.getY() - 0.45, entity.getZ())) > 0) {
						TheDeepVoidMod.queueServerWork(15, () -> {
							world.destroyBlock(BlockPos.containing(entity.getX(), entity.getY() - 0.45, entity.getZ()), false);
						});
					}
					if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).getLightEmission(world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())) > 0) {
						TheDeepVoidMod.queueServerWork(15, () -> {
							world.destroyBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), false);
						});
					}
				}
				if (sourceentity instanceof DamnedEntity || sourceentity instanceof BigEyeEntity || sourceentity instanceof CrossEyesEntity || sourceentity instanceof FourEyesEntity || sourceentity instanceof MultipleEyesEntity) {
					if (!entity.level().isClientSide())
						entity.discard();
					if (!sourceentity.level().isClientSide())
						sourceentity.discard();
					if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 0.45, entity.getZ())).getLightEmission(world, BlockPos.containing(entity.getX(), entity.getY() - 0.45, entity.getZ())) > 0) {
						world.destroyBlock(BlockPos.containing(entity.getX(), entity.getY() - 0.45, entity.getZ()), false);
					}
					if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).getLightEmission(world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())) > 0) {
						world.destroyBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), false);
					}
				}
			}
		}
		if (entity instanceof SulfurTntEntityEntity) {
			if (event instanceof ICancellableEvent _cancellable) {
				_cancellable.setCanceled(true);
			}
		}
		if (entity instanceof RootedCloneEntity) {
			if (event instanceof ICancellableEvent _cancellable) {
				_cancellable.setCanceled(true);
			}
		}
		if (entity instanceof DeathMawHiddenEntity) {
			if (event instanceof ICancellableEvent _cancellable) {
				_cancellable.setCanceled(true);
			}
		}
		if (entity instanceof ThrownSoulSeekerEntity) {
			if (event instanceof ICancellableEvent _cancellable) {
				_cancellable.setCanceled(true);
			}
		}
		if (entity instanceof CharredSpikeEntity || entity instanceof SummonedCharredSpikeEntity) {
			if (event instanceof ICancellableEvent _cancellable) {
				_cancellable.setCanceled(true);
			}
		}
		if (entity instanceof ShadowEntity) {
			if (sourceentity instanceof Player) {
				if (!entity.level().isClientSide())
					entity.discard();
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SMOKE, (entity.getX()), (entity.getY()), (entity.getZ()), 10, (Mth.nextDouble(RandomSource.create(), -0.01, 0.01)), 1, (Mth.nextDouble(RandomSource.create(), -0.01, 0.01)), 0.4);
			}
		}
		if (entity instanceof ShadowHandEntity || entity instanceof SummonedShadowHandEntity || entity instanceof HandSpawnEntity) {
			if (event instanceof ICancellableEvent _cancellable) {
				_cancellable.setCanceled(true);
			}
		}
		if (entity instanceof SoulOrbEntity) {
			if (sourceentity instanceof Player) {
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7b\u00A7l\u00A7kSOUL \u00A7b\u00A7lTake me. \u00A7b\u00A7l\u00A7kSOUL"), true);
			} else {
				if (!entity.level().isClientSide())
					entity.discard();
				world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.BLUE_ICE.defaultBlockState()));
			}
		}
		if (entity instanceof Player) {
			if (!world.getEntitiesOfClass(SoulOrbEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 8, 8, 8), e -> true).isEmpty()) {
				{
					final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof SoulOrbEntity) {
							world.levelEvent(2001, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), Block.getId(Blocks.BLUE_ICE.defaultBlockState()));
							if (!entityiterator.level().isClientSide())
								entityiterator.discard();
						}
					}
				}
			}
		}
		if (sourceentity instanceof ShadowHandEntity) {
			if (entity instanceof Player) {
				if (!world.getEntitiesOfClass(WeaverOfSoulsEntity.class, AABB.ofSize(new Vec3(x, y, z), 80, 80, 80), e -> true).isEmpty()) {
					if (((Entity) world.getEntitiesOfClass(WeaverOfSoulsEntity.class, AABB.ofSize(new Vec3(x, y, z), 80, 80, 80), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof Mob _entity)
						_entity.getNavigation().moveTo((entity.getX()), (entity.getY()), (entity.getZ()), 1.2);
				}
			}
		}
	}
}
