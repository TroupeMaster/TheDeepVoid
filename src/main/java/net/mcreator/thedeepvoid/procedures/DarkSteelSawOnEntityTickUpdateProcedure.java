package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;
import net.mcreator.thedeepvoid.entity.DarkSteelSawEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class DarkSteelSawOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == TheDeepVoidModBlocks.ANCIENT_DEEPSLATE_SAW_TRAP_TRACK.get()) {
			if ((new Object() {
				public Direction getDirection(BlockPos pos) {
					BlockState _bs = world.getBlockState(pos);
					Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (property != null && _bs.getValue(property) instanceof Direction _dir)
						return _dir;
					else if (_bs.hasProperty(BlockStateProperties.AXIS))
						return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
					else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
						return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
					return Direction.NORTH;
				}
			}.getDirection(BlockPos.containing(x, y - 1, z))) == Direction.NORTH) {
				entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(x, y, (-2)));
				if (entity.getPersistentData().getBoolean("fast") == true) {
					entity.setDeltaMovement(new Vec3(0, 0, (-0.65)));
				} else {
					TheDeepVoidMod.queueServerWork(1, () -> {
						entity.setDeltaMovement(new Vec3(0, 0, (-0.4)));
					});
				}
			} else if ((new Object() {
				public Direction getDirection(BlockPos pos) {
					BlockState _bs = world.getBlockState(pos);
					Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (property != null && _bs.getValue(property) instanceof Direction _dir)
						return _dir;
					else if (_bs.hasProperty(BlockStateProperties.AXIS))
						return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
					else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
						return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
					return Direction.NORTH;
				}
			}.getDirection(BlockPos.containing(x, y - 1, z))) == Direction.SOUTH) {
				entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(x, y, 2));
				if (entity.getPersistentData().getBoolean("fast") == true) {
					entity.setDeltaMovement(new Vec3(0, 0, 0.65));
				} else {
					TheDeepVoidMod.queueServerWork(1, () -> {
						entity.setDeltaMovement(new Vec3(0, 0, 0.4));
					});
				}
			} else if ((new Object() {
				public Direction getDirection(BlockPos pos) {
					BlockState _bs = world.getBlockState(pos);
					Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (property != null && _bs.getValue(property) instanceof Direction _dir)
						return _dir;
					else if (_bs.hasProperty(BlockStateProperties.AXIS))
						return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
					else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
						return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
					return Direction.NORTH;
				}
			}.getDirection(BlockPos.containing(x, y - 1, z))) == Direction.WEST) {
				entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((-2), y, z));
				if (entity.getPersistentData().getBoolean("fast") == true) {
					entity.setDeltaMovement(new Vec3((-0.65), 0, 0));
				} else {
					TheDeepVoidMod.queueServerWork(1, () -> {
						entity.setDeltaMovement(new Vec3((-0.4), 0, 0));
					});
				}
			} else if ((new Object() {
				public Direction getDirection(BlockPos pos) {
					BlockState _bs = world.getBlockState(pos);
					Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (property != null && _bs.getValue(property) instanceof Direction _dir)
						return _dir;
					else if (_bs.hasProperty(BlockStateProperties.AXIS))
						return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
					else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
						return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
					return Direction.NORTH;
				}
			}.getDirection(BlockPos.containing(x, y - 1, z))) == Direction.EAST) {
				entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(2, y, z));
				if (entity.getPersistentData().getBoolean("fast") == true) {
					entity.setDeltaMovement(new Vec3(0.65, 0, 0));
				} else {
					TheDeepVoidMod.queueServerWork(1, () -> {
						entity.setDeltaMovement(new Vec3(0.4, 0, 0));
					});
				}
			}
		} else {
			if (!entity.level().isClientSide())
				entity.discard();
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LAVA, x, y, z, Mth.nextInt(RandomSource.create(), 5, 15), 0, 0.1, 0, 0.1);
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, 0, Level.ExplosionInteraction.NONE);
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof LivingEntity && !(entityiterator instanceof DarkSteelSawEntity) && !(entityiterator == entity)) {
					entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)),
							(float) (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:trap_vulnerable"))) ? 11 : 7));
					if (Math.random() < 0.4) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:sentient_chainsaw_use")), SoundSource.HOSTILE, (float) 0.4, (float) 1.4);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:sentient_chainsaw_use")), SoundSource.HOSTILE, (float) 0.4, (float) 1.4, false);
							}
						}
					}
				}
			}
		}
		if (!world.getEntitiesOfClass(DarkSteelSawEntity.class, AABB.ofSize(new Vec3(x, y, z), 1, 1, 1), e -> true).isEmpty()) {
			if (!(((Entity) world.getEntitiesOfClass(DarkSteelSawEntity.class, AABB.ofSize(new Vec3(x, y, z), 1, 1, 1), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)) == entity)) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof DarkSteelSawEntity) {
							if (!entityiterator.level().isClientSide())
								entityiterator.discard();
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.LAVA, x, y, z, Mth.nextInt(RandomSource.create(), 5, 15), 0, 0.1, 0, 0.1);
							if (world instanceof Level _level && !_level.isClientSide())
								_level.explode(null, x, y, z, 0, Level.ExplosionInteraction.NONE);
						}
					}
				}
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.LAVA, x, y, z, Mth.nextInt(RandomSource.create(), 0, 2), 0, 0.1, 0, 0.1);
		if (Math.random() < 0.1) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:sentient_chainsaw_use")), SoundSource.HOSTILE, (float) 0.4, (float) 0.8);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:sentient_chainsaw_use")), SoundSource.HOSTILE, (float) 0.4, (float) 0.8, false);
				}
			}
		}
		TheDeepVoidMod.queueServerWork(140, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
	}
}
