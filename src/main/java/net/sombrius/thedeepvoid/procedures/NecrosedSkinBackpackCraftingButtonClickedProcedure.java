package net.sombrius.thedeepvoid.procedures;

import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class NecrosedSkinBackpackCraftingButtonClickedProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player) {
			BlockPos _blockPos = BlockPos.containing(x, y, z);
			_player.openMenu(new SimpleMenuProvider((_containerID, _inventory, _entity) -> {
				return new CraftingMenu(_containerID, _inventory, ContainerLevelAccess.create(_player.level(), _blockPos)) {
					@Override
					public boolean stillValid(Player player) {
						return true;
					}
				};
			}, Component.literal((Component.translatable("container.crafting").getString()))));
		}
	}
}
