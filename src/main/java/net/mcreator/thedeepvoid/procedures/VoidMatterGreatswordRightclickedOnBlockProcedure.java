package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class VoidMatterGreatswordRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown() && (entity instanceof Player _plrCldRem2 ? _plrCldRem2.getCooldowns().getCooldownPercent(itemstack.getItem(), 0f) * 100 : 0) <= 0) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 100);
			VoidMatterGreatswordImpactProcedure.execute(world, entity, 1);
			TheDeepVoidMod.queueServerWork(3, () -> {
				VoidMatterGreatswordImpactProcedure.execute(world, entity, 3);
			});
			TheDeepVoidMod.queueServerWork(6, () -> {
				VoidMatterGreatswordImpactProcedure.execute(world, entity, 5);
			});
			TheDeepVoidMod.queueServerWork(8, () -> {
				VoidMatterGreatswordImpactProcedure.execute(world, entity, 7);
			});
		}
	}
}
