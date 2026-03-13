package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityAnchorArgument;

public class GiantBoneCrawlerEggOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(1, y, z));
		if (entity instanceof LivingEntity _entity)
			_entity.removeAllEffects();
		SleepingPrimordialCrawlerOnEntityTickUpdateProcedure.execute(world, x, y, z, entity);
	}
}
