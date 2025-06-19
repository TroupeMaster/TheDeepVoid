
package net.mcreator.thedeepvoid.item.extension;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.Direction;

import net.mcreator.thedeepvoid.procedures.SulfurTntDispensedOnDispenseAttemptWithResultProcedure;
import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class SulfurTntDispensedItemExtension {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> DispenserBlock.registerBehavior(TheDeepVoidModBlocks.SULFUR_TNT.get().asItem(), new OptionalDispenseItemBehavior() {
			public ItemStack execute(BlockSource blockSource, ItemStack stack) {
				ItemStack itemstack = stack.copy();
				Level world = blockSource.level();
				Direction direction = blockSource.state().getValue(DispenserBlock.FACING);
				int x = blockSource.pos().getX();
				int y = blockSource.pos().getY();
				int z = blockSource.pos().getZ();
				boolean success = this.isSuccess();
				SulfurTntDispensedOnDispenseAttemptWithResultProcedure.execute(world, x, y, z);
				itemstack.shrink(1);
				return itemstack;
			}
		}));
	}
}
