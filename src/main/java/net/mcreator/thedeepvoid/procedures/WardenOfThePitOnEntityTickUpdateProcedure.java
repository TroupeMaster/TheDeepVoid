package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;
import net.mcreator.thedeepvoid.entity.WardenOfThePitEntity;

public class WardenOfThePitOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if (entity.getPersistentData().getBoolean("setLook") == false) {
				entity.getPersistentData().putBoolean("setLook", true);
				entity.getPersistentData().putDouble("xPos", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()));
				entity.getPersistentData().putDouble("zPos", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()));
			}
			entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(120, y, z));
			if (entity.getY() < (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() && (entity instanceof WardenOfThePitEntity _datEntL14 && _datEntL14.getEntityData().get(WardenOfThePitEntity.DATA_grabbedPlayer)) == false) {
				entity.setDeltaMovement(new Vec3(0, 1, 0));
				if (entity instanceof WardenOfThePitEntity) {
					((WardenOfThePitEntity) entity).setAnimation("animation.warden_aggressive");
				}
				if ((entity instanceof WardenOfThePitEntity _datEntI ? _datEntI.getEntityData().get(WardenOfThePitEntity.DATA_playSound) : 0) <= 0) {
					if (entity instanceof WardenOfThePitEntity _datEntSetI)
						_datEntSetI.getEntityData().set(WardenOfThePitEntity.DATA_playSound, 4);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:amalgam_step")), SoundSource.HOSTILE, 10,
									(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:amalgam_step")), SoundSource.HOSTILE, 10,
									(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
						}
					}
					if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.PIT_SHAKE.get(), 10, 0, false, false));
					if (Math.random() < 0.35) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.break_block")), SoundSource.HOSTILE, 10,
										(float) Mth.nextDouble(RandomSource.create(), 0.9, 1));
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.break_block")), SoundSource.HOSTILE, 10,
										(float) Mth.nextDouble(RandomSource.create(), 0.9, 1), false);
							}
						}
					}
				} else {
					if (entity instanceof WardenOfThePitEntity _datEntSetI)
						_datEntSetI.getEntityData().set(WardenOfThePitEntity.DATA_playSound, (int) ((entity instanceof WardenOfThePitEntity _datEntI ? _datEntI.getEntityData().get(WardenOfThePitEntity.DATA_playSound) : 0) - 1));
				}
			} else if (entity.getY() >= (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()
					&& (entity instanceof WardenOfThePitEntity _datEntL36 && _datEntL36.getEntityData().get(WardenOfThePitEntity.DATA_grabbedPlayer)) == false) {
				if (entity instanceof WardenOfThePitEntity _datEntSetL)
					_datEntSetL.getEntityData().set(WardenOfThePitEntity.DATA_grabbedPlayer, true);
				if (entity instanceof WardenOfThePitEntity) {
					((WardenOfThePitEntity) entity).setAnimation("empty");
				}
			} else if ((entity instanceof WardenOfThePitEntity _datEntL39 && _datEntL39.getEntityData().get(WardenOfThePitEntity.DATA_grabbedPlayer)) == true) {
				entity.setDeltaMovement(new Vec3(0, (-1), 0));
				{
					Entity _ent = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null);
					_ent.teleportTo(entity.getX() + entity.getLookAngle().x * 6, (entity.getY() + 28), entity.getZ() + entity.getLookAngle().z * 6);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(entity.getX() + entity.getLookAngle().x * 6, (entity.getY() + 28), entity.getZ() + entity.getLookAngle().z * 6, _ent.getYRot(), _ent.getXRot());
				}
				(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())));
				if (entity instanceof WardenOfThePitEntity) {
					((WardenOfThePitEntity) entity).setAnimation("animation.warden_down");
				}
				if ((entity instanceof WardenOfThePitEntity _datEntI ? _datEntI.getEntityData().get(WardenOfThePitEntity.DATA_playSound) : 0) <= 0) {
					if (entity instanceof WardenOfThePitEntity _datEntSetI)
						_datEntSetI.getEntityData().set(WardenOfThePitEntity.DATA_playSound, 4);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:amalgam_step")), SoundSource.HOSTILE, 10,
									(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:amalgam_step")), SoundSource.HOSTILE, 10,
									(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
						}
					}
					if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.PIT_SHAKE.get(), 10, 0, false, false));
				} else {
					if (entity instanceof WardenOfThePitEntity _datEntSetI)
						_datEntSetI.getEntityData().set(WardenOfThePitEntity.DATA_playSound, (int) ((entity instanceof WardenOfThePitEntity _datEntI ? _datEntI.getEntityData().get(WardenOfThePitEntity.DATA_playSound) : 0) - 1));
				}
				if (entity.getY() <= 8) {
					(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)
							.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:effigy")))), 999);
					if (!entity.level().isClientSide())
						entity.discard();
				}
			} else {
				entity.setDeltaMovement(new Vec3(0, 0, 0));
			}
			int horizontalRadiusSquare = (int) 8 - 1;
			int verticalRadiusSquare = (int) 8 - 1;
			int yIterationsSquare = verticalRadiusSquare;
			for (int i = -yIterationsSquare; i <= yIterationsSquare; i++) {
				for (int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; xi++) {
					for (int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; zi++) {
						// Execute the desired statements within the square/cube
						if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == TheDeepVoidModBlocks.ANCIENT_DEEPSLATE_BRICK_STAIRS.get()
								|| (world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == TheDeepVoidModBlocks.CRACKED_ANCIENT_DEEPSLATE_BRICK_STAIRS.get()) {
							world.destroyBlock(BlockPos.containing(x + xi, y + i, z + zi), false);
						}
					}
				}
			}
		}
	}
}
