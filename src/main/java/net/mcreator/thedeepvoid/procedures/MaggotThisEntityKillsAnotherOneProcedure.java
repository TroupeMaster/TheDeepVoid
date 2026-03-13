package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.MaggotEntity;
import net.mcreator.thedeepvoid.entity.BabyBoneCrawlerNeutralEntity;
import net.mcreator.thedeepvoid.entity.BabyBoneCrawlerEntity;

public class MaggotThisEntityKillsAnotherOneProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof BabyBoneCrawlerEntity || entity instanceof BabyBoneCrawlerNeutralEntity) {
			if (entity instanceof MaggotEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MaggotEntity.DATA_killed, (int) ((entity instanceof MaggotEntity _datEntI ? _datEntI.getEntityData().get(MaggotEntity.DATA_killed) : 0) + 1));
			if ((entity instanceof MaggotEntity _datEntI ? _datEntI.getEntityData().get(MaggotEntity.DATA_killed) : 0) >= 2) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:fleshy_explosion")), SoundSource.HOSTILE, 1,
								(float) Mth.nextDouble(RandomSource.create(), 1.2, 1.4));
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:fleshy_explosion")), SoundSource.HOSTILE, 1,
								(float) Mth.nextDouble(RandomSource.create(), 1.2, 1.4), false);
					}
				}
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheDeepVoidModEntities.BLACK_FLY.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/loot spawn ~ ~ ~ loot the_deep_void:entities/maggot_grow");
				if (!entity.level().isClientSide())
					entity.discard();
			}
		}
	}
}
