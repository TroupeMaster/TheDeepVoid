package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.UUID;

public class CrossToolInHandTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!(((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get()).getModifier(UUID.fromString("25077204-40c9-4acd-ae7d-9f396bbbd614")) != null)) {
			if (!(((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get())
					.hasModifier((new AttributeModifier(UUID.fromString("25077204-40c9-4acd-ae7d-9f396bbbd614"), "penitentCross_reach", ((double) DeepVoidConfigConfiguration.PENITENTCROSSREACHADDITION.get()), AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get()).addTransientModifier(
						(new AttributeModifier(UUID.fromString("25077204-40c9-4acd-ae7d-9f396bbbd614"), "penitentCross_reach", ((double) DeepVoidConfigConfiguration.PENITENTCROSSREACHADDITION.get()), AttributeModifier.Operation.ADDITION)));
		}
		if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK).getModifier(UUID.fromString("cd21e4b9-a572-464f-b715-eb4e5081851a")) != null)) {
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK)
					.hasModifier((new AttributeModifier(UUID.fromString("cd21e4b9-a572-464f-b715-eb4e5081851a"), "penitentCross_knockback", 1.3, AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK)
						.addTransientModifier((new AttributeModifier(UUID.fromString("cd21e4b9-a572-464f-b715-eb4e5081851a"), "penitentCross_knockback", 1.3, AttributeModifier.Operation.ADDITION)));
		}
		TheDeepVoidMod.queueServerWork(20, () -> {
			if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.PENITENT_CROSS.get())) {
				if (((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get()).getModifier(UUID.fromString("25077204-40c9-4acd-ae7d-9f396bbbd614")) != null) {
					((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get()).removeModifier(UUID.fromString("25077204-40c9-4acd-ae7d-9f396bbbd614"));
				}
				if (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK).getModifier(UUID.fromString("cd21e4b9-a572-464f-b715-eb4e5081851a")) != null) {
					((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK).removeModifier(UUID.fromString("cd21e4b9-a572-464f-b715-eb4e5081851a"));
				}
			}
		});
	}
}
