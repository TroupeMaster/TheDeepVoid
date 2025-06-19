package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class GodsScourgeGreatswordLivingEntityIsHitWithToolProcedure {
	public static void execute(Entity sourceentity, ItemStack itemstack) {
		if (sourceentity == null)
			return;
		itemstack.getOrCreateTag().putDouble("deep_void:soulAmount", (itemstack.getOrCreateTag().getDouble("deep_void:soulAmount") + 1));
		if (sourceentity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("" + itemstack.getOrCreateTag().getDouble("deep_void:soulAmount"))), true);
	}
}
