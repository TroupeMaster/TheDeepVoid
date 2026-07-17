package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.FalseHydraEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

public class FalseHydraVolleyProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof FalseHydraEntity _datEntL0 && _datEntL0.getEntityData().get(FalseHydraEntity.DATA_volley)) == true && !((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()),
					((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
			entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * (double) DeepVoidConfigConfiguration.HYDRASLIDESPEED.get()), (entity.getDeltaMovement().y()),
					(Math.cos(Math.toRadians(entity.getYRot())) * (double) DeepVoidConfigConfiguration.HYDRASLIDESPEED.get())));
			for (int index0 = 0; index0 < 4; index0++) {
				world.levelEvent(2001, BlockPos.containing(entity.getX() + Mth.nextInt(RandomSource.create(), -5, 5) + 0.5, entity.getY(), entity.getZ() + Mth.nextInt(RandomSource.create(), -5, 5) + 0.5),
						Block.getId((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1, entity.getZ())))));
			}
			if (Math.random() < 0.1) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:bone_crack")), SoundSource.BLOCKS, 2, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:bone_crack")), SoundSource.BLOCKS, 2, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
					}
				}
			}
			if (Math.random() < 0.1) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheDeepVoidModEntities.FALLING_CORPSE.get().spawn(_level, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -2, 2), y + 1, z + Mth.nextInt(RandomSource.create(), -2, 2)), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot((float) Math.random());
						entityToSpawn.setYBodyRot((float) Math.random());
						entityToSpawn.setYHeadRot((float) Math.random());
						entityToSpawn.setXRot((float) Math.random());
						entityToSpawn.setDeltaMovement((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 0.2), 0.1, (Math.cos(Math.toRadians(entity.getYRot())) * 0.2));
					}
				}
			}
		}
	}
}
