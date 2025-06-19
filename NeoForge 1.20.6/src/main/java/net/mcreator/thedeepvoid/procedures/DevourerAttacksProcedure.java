package net.mcreator.thedeepvoid.procedures;

import net.neoforged.neoforge.event.entity.living.LivingAttackEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.thedeepvoid.entity.DevourerEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class DevourerAttacksProcedure {
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
		if ((entity instanceof Player || entity instanceof ServerPlayer) && sourceentity instanceof DevourerEntity) {
			entity.setDeltaMovement(new Vec3(((sourceentity.getX() - entity.getX()) * 0.5), ((sourceentity.getY() - entity.getY()) * 0.5), ((sourceentity.getZ() - entity.getZ()) * 0.5)));
		}
	}
}
