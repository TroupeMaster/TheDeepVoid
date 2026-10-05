package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.network.TheDeepVoidModVariables;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class MiniatureCofferRightclickedProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 10);
		TheDeepVoidModVariables.MapVariables.get(world).undertakerSpawn = 60;
		TheDeepVoidModVariables.MapVariables.get(world).syncData(world);
	}
}
