package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import java.util.UUID;

public class ModifiersRemoveAttributesProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		//Lavendite
		if (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getModifier(UUID.fromString("bd693a85-8070-460a-99c7-a3e4335c7106")) != null) {
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).removeModifier(UUID.fromString("bd693a85-8070-460a-99c7-a3e4335c7106"));
		}
		if (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED).getModifier(UUID.fromString("fc2b6742-191e-4c45-9dfd-d3a22493c141")) != null) {
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED).removeModifier(UUID.fromString("fc2b6742-191e-4c45-9dfd-d3a22493c141"));
		} //Rot
		if (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED).getModifier(UUID.fromString("3b71bdcc-6ddf-4b2c-a521-b67097a89ee4")) != null) {
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED).removeModifier(UUID.fromString("3b71bdcc-6ddf-4b2c-a521-b67097a89ee4"));
		} //Dark Steel
		if (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED).getModifier(UUID.fromString("740510ec-164b-4253-b513-3367bc1740af")) != null) {
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED).removeModifier(UUID.fromString("740510ec-164b-4253-b513-3367bc1740af"));
		}
		if (((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get()).getModifier(UUID.fromString("fec8e968-08ad-46b3-91af-503d3adf17b1")) != null) {
			((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get()).removeModifier(UUID.fromString("fec8e968-08ad-46b3-91af-503d3adf17b1"));
		}
		if (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getModifier(UUID.fromString("24ab05c9-3824-49f6-adf3-029fa9b4194b")) != null) {
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).removeModifier(UUID.fromString("24ab05c9-3824-49f6-adf3-029fa9b4194b"));
		}
	}
}
