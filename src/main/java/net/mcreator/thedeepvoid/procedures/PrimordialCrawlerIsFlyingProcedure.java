package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.thedeepvoid.entity.PrimordialBoneCrawlerEntity;

public class PrimordialCrawlerIsFlyingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof PrimordialBoneCrawlerEntity _datEntL0 && _datEntL0.getEntityData().get(PrimordialBoneCrawlerEntity.DATA_fly)) == true) {
			if (world.getBlockState(BlockPos.containing(x, y - 10, z)).canOcclude() || world.getBlockState(BlockPos.containing(x, y - 9, z)).canOcclude() || world.getBlockState(BlockPos.containing(x, y - 8, z)).canOcclude()
					|| world.getBlockState(BlockPos.containing(x, y - 7, z)).canOcclude() || world.getBlockState(BlockPos.containing(x, y - 6, z)).canOcclude() || world.getBlockState(BlockPos.containing(x, y - 5, z)).canOcclude()
					|| world.getBlockState(BlockPos.containing(x, y - 4, z)).canOcclude() || world.getBlockState(BlockPos.containing(x, y - 3, z)).canOcclude() || world.getBlockState(BlockPos.containing(x, y - 2, z)).canOcclude()
					|| world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude()) {
				entity.setDeltaMovement(new Vec3(0, 0.3, 0));
			}
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()),
						((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
			}
		}
	}
}
