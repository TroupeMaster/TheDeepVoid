package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import java.util.UUID;

public class ChainGauntletToolInHandTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plrCldRem1 ? _plrCldRem1.getCooldowns().getCooldownPercent(itemstack.getItem(), 0f) * 100 : 0) <= 0
				&& !(((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get()).getModifier(UUID.fromString("01387b5f-4dbd-4d94-b869-7f35d57d896e")) != null)) {
			if (!(((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get()).hasModifier((new AttributeModifier(UUID.fromString("01387b5f-4dbd-4d94-b869-7f35d57d896e"), "chainReach", 12, AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get()).addTransientModifier((new AttributeModifier(UUID.fromString("01387b5f-4dbd-4d94-b869-7f35d57d896e"), "chainReach", 12, AttributeModifier.Operation.ADDITION)));
		} else if ((entity instanceof Player _plrCldRem6 ? _plrCldRem6.getCooldowns().getCooldownPercent(itemstack.getItem(), 0f) * 100 : 0) > 0
				&& ((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get()).getModifier(UUID.fromString("01387b5f-4dbd-4d94-b869-7f35d57d896e")) != null) {
			((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get()).removeModifier(UUID.fromString("01387b5f-4dbd-4d94-b869-7f35d57d896e"));
		}
	}
}
