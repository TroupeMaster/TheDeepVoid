package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import java.util.UUID;

public class DebilitatedEffectStartedappliedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).hasModifier((new AttributeModifier(UUID.fromString("b62dcadb-d9b4-46da-b37c-6378ea720d21"), "debilitatedArmor",
				(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).getValue() * (-0.7)), AttributeModifier.Operation.ADDITION)))))
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).addTransientModifier((new AttributeModifier(UUID.fromString("b62dcadb-d9b4-46da-b37c-6378ea720d21"), "debilitatedArmor",
					(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).getValue() * (-0.7)), AttributeModifier.Operation.ADDITION)));
		if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS).hasModifier((new AttributeModifier(UUID.fromString("d747b3a8-1b6a-48bb-a3fe-d9de22cb7fc8"), "debilitatedArmorTough",
				(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS).getValue() * (-0.7)), AttributeModifier.Operation.ADDITION)))))
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS).addTransientModifier((new AttributeModifier(UUID.fromString("d747b3a8-1b6a-48bb-a3fe-d9de22cb7fc8"), "debilitatedArmorTough",
					(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS).getValue() * (-0.7)), AttributeModifier.Operation.ADDITION)));
		if ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) <= 6) {
			if (entity instanceof Player _player)
				_player.getFoodData().setFoodLevel(7);
			if ((entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) > 1) {
				if (entity instanceof Player _player)
					_player.getFoodData().setSaturation((float) ((entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) - 2));
			}
		}
	}
}
