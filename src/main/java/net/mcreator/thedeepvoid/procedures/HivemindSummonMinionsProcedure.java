package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.SkullSmasherEntity;
import net.mcreator.thedeepvoid.entity.SawThrowerEntity;
import net.mcreator.thedeepvoid.entity.MisanthropicHivemindEntity;

public class HivemindSummonMinionsProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double xPos = 0;
		double yPos = 0;
		double zPos = 0;
		if (entity instanceof MisanthropicHivemindEntity) {
			((MisanthropicHivemindEntity) entity).setAnimation("animation.hivemind_scream");
		}
		for (int index0 = 0; index0 < 100; index0++) {
			xPos = entity.getX() + Mth.nextInt(RandomSource.create(), -10, 10);
			yPos = entity.getY() + Mth.nextInt(RandomSource.create(), -1, 1);
			zPos = entity.getZ() + Mth.nextInt(RandomSource.create(), -10, 10);
			if (world.getBlockState(BlockPos.containing(xPos, yPos - 1, zPos)).canOcclude() && world.isEmptyBlock(BlockPos.containing(xPos, yPos, zPos))) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entityinstance = TheDeepVoidModEntities.SAW_THROWER.get().create(_serverLevel, null, null, BlockPos.containing(xPos, yPos, zPos), MobSpawnType.MOB_SUMMONED, false, false);
					if (entityinstance != null) {
						entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
						if (entityinstance instanceof SawThrowerEntity) {
							((SawThrowerEntity) entityinstance).setAnimation("animation.sawThrower_out");
						}
						if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
							if (entityinstance instanceof Mob _entity && (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _ent)
								_entity.setTarget(_ent);
						}
						_serverLevel.addFreshEntity(entityinstance);
					}
				}
				break;
			}
		}
		for (int index1 = 0; index1 < 100; index1++) {
			xPos = entity.getX() + Mth.nextInt(RandomSource.create(), -10, 10);
			yPos = entity.getY() + Mth.nextInt(RandomSource.create(), -1, 1);
			zPos = entity.getZ() + Mth.nextInt(RandomSource.create(), -10, 10);
			if (world.getBlockState(BlockPos.containing(xPos, yPos - 1, zPos)).canOcclude() && world.isEmptyBlock(BlockPos.containing(xPos, yPos, zPos))) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entityinstance = TheDeepVoidModEntities.SKULL_SMASHER.get().create(_serverLevel, null, null, BlockPos.containing(xPos, yPos, zPos), MobSpawnType.MOB_SUMMONED, false, false);
					if (entityinstance != null) {
						entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
						if (entityinstance instanceof SkullSmasherEntity) {
							((SkullSmasherEntity) entityinstance).setAnimation("animation.skullSmasher_out");
						}
						if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
							if (entityinstance instanceof Mob _entity && (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _ent)
								_entity.setTarget(_ent);
						}
						_serverLevel.addFreshEntity(entityinstance);
					}
				}
				break;
			}
		}
	}
}
