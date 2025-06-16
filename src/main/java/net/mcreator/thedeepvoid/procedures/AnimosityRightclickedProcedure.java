package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;

public class AnimosityRightclickedProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack data = ItemStack.EMPTY;
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(TheDeepVoidModItems.ANIMOSITY.get(), 40);
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(TheDeepVoidModItems.ANIMOSITY_HIDDEN.get(), 40);
		data = (itemstack.copy());
		if (entity instanceof LivingEntity _entity) {
			ItemStack _setstack = new ItemStack(TheDeepVoidModItems.ANIMOSITY_HIDDEN.get()).copy();
			_setstack.setCount(1);
			_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
			if (_entity instanceof Player _player)
				_player.getInventory().setChanged();
		}
		{
			CompoundTag _nbtTag = data.getTag();
			if (_nbtTag != null)
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).setTag(_nbtTag.copy());
		}
	}
}
