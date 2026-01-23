package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.entity.VoidbornEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class VoidbornCrouchProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.getBlockState(
				BlockPos.containing(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
						entity.getY(), entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos()
								.getZ()))
				.canOcclude()
				&& !world
						.getBlockState(BlockPos.containing(
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
								entity.getY() + 1,
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()))
						.canOcclude()
				&& world.getBlockState(BlockPos.containing(
						entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
						entity.getY() + 2,
						entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())).canOcclude()
				&& !((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if (entity.getPersistentData().getBoolean("crouch") == false) {
				entity.getPersistentData().putBoolean("crouch", true);
			}
			if (entity instanceof VoidbornEntity) {
				((VoidbornEntity) entity).setAnimation("animation.caveNightmare_walkStealth");
			}
			if (entity.getPersistentData().getBoolean("cancelCrouch") == false) {
				entity.getPersistentData().putBoolean("cancelCrouch", true);
			}
		} else if (entity.getPersistentData().getBoolean("crouch") == true) {
			TheDeepVoidMod.queueServerWork(40, () -> {
				entity.getPersistentData().putBoolean("crouch", false);
				if (entity.getPersistentData().getBoolean("cancelCrouch") == true) {
					entity.getPersistentData().putBoolean("cancelCrouch", false);
					if (entity instanceof VoidbornEntity) {
						((VoidbornEntity) entity).setAnimation("empty");
					}
				}
			});
		}
	}
}
