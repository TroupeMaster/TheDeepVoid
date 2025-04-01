package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class VoidPendantItemInHandTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getBoolean("linked") == true) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Linked to :" + " x=" + itemstack.getOrCreateTag().getDouble("coreX") + " y=" + itemstack.getOrCreateTag().getDouble("coreY") + " z=" + itemstack.getOrCreateTag().getDouble("coreZ"))),
						true);
		}
	}
}
