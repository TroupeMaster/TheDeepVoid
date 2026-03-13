package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.entity.GoreLurkerEntity;
import net.mcreator.thedeepvoid.entity.DevourerEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DevourerAttacksProcedure {
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
		if (entity instanceof Player && sourceentity instanceof DevourerEntity) {
			entity.setDeltaMovement(new Vec3(((sourceentity.getX() - entity.getX()) * 0.5), ((sourceentity.getY() - entity.getY()) * 0.5), ((sourceentity.getZ() - entity.getZ()) * 0.5)));
		}
		if (entity instanceof Player && sourceentity instanceof GoreLurkerEntity) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.BLOSSOM.get(), 100, 0));
		}
	}
}
