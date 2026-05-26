package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.ThumperEntityEntity;
import net.mcreator.thedeepvoid.entity.FleshWormEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class ThumperEntityOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.setDeltaMovement(new Vec3(0, (-5), 0));
		entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(1, y, z));
		if ((entity instanceof ThumperEntityEntity _datEntI ? _datEntI.getEntityData().get(ThumperEntityEntity.DATA_sound) : 0) >= 20) {
			if (entity instanceof ThumperEntityEntity _datEntSetI)
				_datEntSetI.getEntityData().set(ThumperEntityEntity.DATA_sound, 0);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:amalgam_step")), SoundSource.BLOCKS, (float) 0.1, (float) 0.4);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:amalgam_step")), SoundSource.BLOCKS, (float) 0.1, (float) 0.4, false);
				}
			}
		} else {
			if (entity instanceof ThumperEntityEntity _datEntSetI)
				_datEntSetI.getEntityData().set(ThumperEntityEntity.DATA_sound, (int) ((entity instanceof ThumperEntityEntity _datEntI ? _datEntI.getEntityData().get(ThumperEntityEntity.DATA_sound) : 0) + 1));
		}
		if (!(!world.getEntitiesOfClass(FleshWormEntity.class, AABB.ofSize(new Vec3(x, y, z), 250, 250, 250), e -> true).isEmpty())
				&& world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("the_deep_void:flesh_biome")))
				&& (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("the_deep_void:flesh_blocks")))) {
			if ((entity instanceof ThumperEntityEntity _datEntI ? _datEntI.getEntityData().get(ThumperEntityEntity.DATA_summon) : 0) >= 400) {
				if (entity instanceof ThumperEntityEntity _datEntSetI)
					_datEntSetI.getEntityData().set(ThumperEntityEntity.DATA_summon, 0);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:deep_rumble")), SoundSource.BLOCKS, 2, 1);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:deep_rumble")), SoundSource.BLOCKS, 2, 1, false);
					}
				}
				TheDeepVoidMod.queueServerWork(60, () -> {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.FLESH_WORM.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				});
			} else {
				if (entity instanceof ThumperEntityEntity _datEntSetI)
					_datEntSetI.getEntityData().set(ThumperEntityEntity.DATA_summon, (int) ((entity instanceof ThumperEntityEntity _datEntI ? _datEntI.getEntityData().get(ThumperEntityEntity.DATA_summon) : 0) + 1));
			}
		}
	}
}
