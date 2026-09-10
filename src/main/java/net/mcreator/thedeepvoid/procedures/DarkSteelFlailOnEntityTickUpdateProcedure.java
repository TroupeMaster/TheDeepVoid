package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;
import net.mcreator.thedeepvoid.entity.DarkSteelFlailEntity;

import java.util.List;
import java.util.Comparator;

public class DarkSteelFlailOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double distance = 0;
		double Delta_X = 0;
		double Delta_Z = 0;
		double Delta_Y = 0;
		double Cur_Z = 0;
		double steps = 0;
		double Cur_Y = 0;
		double Cur_X = 0;
		if ((entity instanceof DarkSteelFlailEntity _datEntL0 && _datEntL0.getEntityData().get(DarkSteelFlailEntity.DATA_retract)) == false && entity.onGround()) {
			if (entity instanceof DarkSteelFlailEntity _datEntSetL)
				_datEntSetL.getEntityData().set(DarkSteelFlailEntity.DATA_retract, true);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:flail_impact")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.95, 1.05));
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:flail_impact")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.95, 1.05), false);
				}
			}
			if (!world.isEmptyBlock(BlockPos.containing(x, y - 1, z))) {
				int horizontalRadiusSquare = (int) 3 - 1;
				int verticalRadiusSquare = (int) 3 - 1;
				int yIterationsSquare = verticalRadiusSquare;
				for (int i = -yIterationsSquare; i <= yIterationsSquare; i++) {
					for (int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; xi++) {
						for (int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; zi++) {
							// Execute the desired statements within the square/cube
							if (world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi)).canOcclude() && !world.getBlockState(BlockPos.containing(x + xi, y + i + 1, z + zi)).canOcclude()) {
								world.levelEvent(2001, BlockPos.containing(x + xi + 0.5, y + i + 1, z + zi + 0.5), Block.getId((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi)))));
							}
						}
					}
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity && !(entityiterator == entity) && entityiterator.onGround()) {
						if (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) {
							if (!(entityiterator == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null))) {
								entityiterator.hurt(
										new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)),
										(float) ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue());
								if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:boss")))) {
									entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x()), 0.6, (entityiterator.getDeltaMovement().z())));
								}
							}
						} else {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity),
									(float) ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue());
							if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:boss")))) {
								entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x()), 0.6, (entityiterator.getDeltaMovement().z())));
							}
						}
					}
				}
			}
		} else if ((entity instanceof DarkSteelFlailEntity _datEntL45 && _datEntL45.getEntityData().get(DarkSteelFlailEntity.DATA_retract)) == true && (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false)) {
			entity.setDeltaMovement(new Vec3((((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getX() - entity.getX()) * 0.15),
					((((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getY() + (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getEyeHeight() / 1.5) - entity.getY()) * 0.15),
					(((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getZ() - entity.getZ()) * 0.15)));
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2.5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)) {
						if (entityiterator instanceof Player) {
							entityiterator.getPersistentData().putDouble("flailUsed", 0);
						}
						if (!entity.level().isClientSide())
							entity.discard();
					}
				}
			}
			if ((entity instanceof DarkSteelFlailEntity _datEntI ? _datEntI.getEntityData().get(DarkSteelFlailEntity.DATA_despawn) : 0) >= 1200) {
				if ((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof Player) {
					(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getPersistentData().putDouble("flailUsed", 0);
				}
				if (!entity.level().isClientSide())
					entity.discard();
			} else {
				if (entity instanceof DarkSteelFlailEntity _datEntSetI)
					_datEntSetI.getEntityData().set(DarkSteelFlailEntity.DATA_despawn, (int) ((entity instanceof DarkSteelFlailEntity _datEntI ? _datEntI.getEntityData().get(DarkSteelFlailEntity.DATA_despawn) : 0) + 1));
			}
		}
		if ((entity instanceof DarkSteelFlailEntity _datEntL73 && _datEntL73.getEntityData().get(DarkSteelFlailEntity.DATA_hit)) == false
				|| (entity instanceof DarkSteelFlailEntity _datEntL74 && _datEntL74.getEntityData().get(DarkSteelFlailEntity.DATA_retract)) == true) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity && !(entityiterator == entity)) {
						if (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) {
							if (!(entityiterator == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null))) {
								entityiterator.hurt(
										new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_ATTACK), (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)),
										(float) ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue());
								if ((entity instanceof DarkSteelFlailEntity _datEntL84 && _datEntL84.getEntityData().get(DarkSteelFlailEntity.DATA_retract)) == false) {
									entityiterator.setDeltaMovement(new Vec3(0, (-1), 0));
								}
								if (entity instanceof DarkSteelFlailEntity _datEntSetL)
									_datEntSetL.getEntityData().set(DarkSteelFlailEntity.DATA_hit, true);
							}
						} else {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity),
									(float) ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue());
							if ((entity instanceof DarkSteelFlailEntity _datEntL90 && _datEntL90.getEntityData().get(DarkSteelFlailEntity.DATA_retract)) == false) {
								entityiterator.setDeltaMovement(new Vec3(0, (-1), 0));
							}
							if (entity instanceof DarkSteelFlailEntity _datEntSetL)
								_datEntSetL.getEntityData().set(DarkSteelFlailEntity.DATA_hit, true);
						}
					}
				}
			}
		}
		if (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) {
			distance = Math.sqrt(Math.pow((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getX() - entity.getX(), 2)
					+ Math.pow(((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getY() + 1.2) - entity.getY(), 2)
					+ Math.pow((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getZ() - entity.getZ(), 2));
			steps = distance * 2.5;
			Delta_X = ((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getX() - entity.getX()) / steps;
			Delta_Y = (((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getY() + 1.2) - entity.getY()) / steps;
			Delta_Z = ((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getZ() - entity.getZ()) / steps;
			Cur_X = entity.getX();
			Cur_Y = entity.getY();
			Cur_Z = entity.getZ();
			for (int index0 = 0; index0 < (int) (steps + 1); index0++) {
				if ((entity instanceof DarkSteelFlailEntity _datEntL116 && _datEntL116.getEntityData().get(DarkSteelFlailEntity.DATA_secret)) == true) {
					world.addParticle((SimpleParticleType) (TheDeepVoidModParticleTypes.MORNINGSTAR_CHAIN.get()), Cur_X, Cur_Y, Cur_Z, 0, 0, 0);
				} else {
					world.addParticle((SimpleParticleType) (TheDeepVoidModParticleTypes.CONNECTING_DARK_STEEL_CHAIN.get()), Cur_X, Cur_Y, Cur_Z, 0, 0, 0);
				}
				Cur_X = Cur_X + Delta_X;
				Cur_Y = Cur_Y + Delta_Y;
				Cur_Z = Cur_Z + Delta_Z;
			}
		}
	}
}
