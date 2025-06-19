package net.mcreator.thedeepvoid.procedures;

import net.neoforged.neoforge.event.entity.living.LivingAttackEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.OverseerPillarEntity;
import net.mcreator.thedeepvoid.entity.OverseerEntity;
import net.mcreator.thedeepvoid.entity.OverseerBigPillarEntity;
import net.mcreator.thedeepvoid.entity.GhostlyNightmareEntity;
import net.mcreator.thedeepvoid.entity.BuiltOverseerPillarEntity;
import net.mcreator.thedeepvoid.entity.BuiltBigOverseerPillarEntity;
import net.mcreator.thedeepvoid.entity.BigOverseerEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class OverseerAttackedProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof LivingEntity) {
			if (entity instanceof OverseerEntity || entity instanceof OverseerPillarEntity || entity instanceof BigOverseerEntity || entity instanceof OverseerBigPillarEntity || entity instanceof BuiltOverseerPillarEntity
					|| entity instanceof BuiltBigOverseerPillarEntity) {
				if (!((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof PickaxeItem)) {
					if (event instanceof ICancellableEvent _cancellable) {
						_cancellable.setCanceled(true);
					}
				}
			}
		}
		if (entity instanceof GhostlyNightmareEntity) {
			if (event instanceof ICancellableEvent _cancellable) {
				_cancellable.setCanceled(true);
			}
		}
	}
}
