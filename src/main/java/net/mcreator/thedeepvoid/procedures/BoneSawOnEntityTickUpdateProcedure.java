package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.thedeepvoid.entity.BoneSawEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class BoneSawOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.1) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:sentient_chainsaw_use")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:sentient_chainsaw_use")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator instanceof BoneSawEntity) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:fleshkin")))) {
					entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:rotten"))), entity),
							(float) (double) DeepVoidConfigConfiguration.THROWERBONESAW.get());
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:sentient_chainsaw_use")), SoundSource.HOSTILE, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:sentient_chainsaw_use")), SoundSource.HOSTILE, 1, 1, false);
						}
					}
					entityiterator.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 1), 0.05, (Math.cos(Math.toRadians(entity.getYRot())) * 1)));
				}
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.LAVA, x, y, z, 2, 0.3, 1, 0.3, 0.1);
		if ((entity instanceof BoneSawEntity _datEntL12 && _datEntL12.getEntityData().get(BoneSawEntity.DATA_positiveX)) == true) {
			entity.setDeltaMovement(new Vec3(1, 0, 0));
			entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(1, y, z));
		} else if ((entity instanceof BoneSawEntity _datEntL15 && _datEntL15.getEntityData().get(BoneSawEntity.DATA_negativeX)) == true) {
			entity.setDeltaMovement(new Vec3((-1), 0, 0));
			entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((-1), y, z));
		} else if ((entity instanceof BoneSawEntity _datEntL18 && _datEntL18.getEntityData().get(BoneSawEntity.DATA_positiveZ)) == true) {
			entity.setDeltaMovement(new Vec3(0, 0, 1));
			entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(x, y, 1));
		} else if ((entity instanceof BoneSawEntity _datEntL21 && _datEntL21.getEntityData().get(BoneSawEntity.DATA_negativeZ)) == true) {
			entity.setDeltaMovement(new Vec3(0, 0, (-1)));
			entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(x, y, (-1)));
		}
		TheDeepVoidMod.queueServerWork(50, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
	}
}
