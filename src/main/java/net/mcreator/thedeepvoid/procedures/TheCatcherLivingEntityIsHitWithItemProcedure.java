package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import java.util.UUID;

public class TheCatcherLivingEntityIsHitWithItemProcedure {
	public static void execute(Entity sourceentity, ItemStack itemstack) {
		if (sourceentity == null)
			return;
		if (itemstack.getOrCreateTag().getDouble("state") == 1) {
			itemstack.getOrCreateTag().putDouble("state", 0);
			if (((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getModifier(UUID.fromString("681aea3b-26bb-484f-8f6a-fa1c1fac1fa7")) != null) {
				((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).removeModifier(UUID.fromString("681aea3b-26bb-484f-8f6a-fa1c1fac1fa7"));
			}
		}
	}
}
