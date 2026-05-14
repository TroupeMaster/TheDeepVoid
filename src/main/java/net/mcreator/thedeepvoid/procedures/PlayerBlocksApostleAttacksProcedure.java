package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.MadCultistEntity;
import net.mcreator.thedeepvoid.entity.ExecutionerEntity;
import net.mcreator.thedeepvoid.entity.ApostleBossEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerBlocksApostleAttacksProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof Player) {
			if ((sourceentity instanceof ApostleBossEntity || sourceentity instanceof ExecutionerEntity || sourceentity instanceof MadCultistEntity)
					&& (entity instanceof LivingEntity _entUseItem4 ? _entUseItem4.getUseItem() : ItemStack.EMPTY).getItem().isEdible()) {
				if (entity instanceof LivingEntity _entity)
					_entity.stopUsingItem();
			}
		}
	}
}
