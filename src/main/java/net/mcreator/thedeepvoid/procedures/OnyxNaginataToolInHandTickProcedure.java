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

public class OnyxNaginataToolInHandTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!(((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get()).getModifier(UUID.fromString("2b644960-a218-4287-927a-2e21362ba9a0")) != null)) {
			if (!(((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get())
					.hasModifier((new AttributeModifier(UUID.fromString("2b644960-a218-4287-927a-2e21362ba9a0"), "onyxNaginata_reach", ((double) DeepVoidConfigConfiguration.ONYXNAGINATAREACHADDITION.get()), AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get()).addTransientModifier(
						(new AttributeModifier(UUID.fromString("2b644960-a218-4287-927a-2e21362ba9a0"), "onyxNaginata_reach", ((double) DeepVoidConfigConfiguration.ONYXNAGINATAREACHADDITION.get()), AttributeModifier.Operation.ADDITION)));
		}
		TheDeepVoidMod.queueServerWork(20, () -> {
			if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.ONYX_NAGINATA.get())
					&& ((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get()).getModifier(UUID.fromString("2b644960-a218-4287-927a-2e21362ba9a0")) != null) {
				((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get()).removeModifier(UUID.fromString("2b644960-a218-4287-927a-2e21362ba9a0"));
			}
		});
	}
}
