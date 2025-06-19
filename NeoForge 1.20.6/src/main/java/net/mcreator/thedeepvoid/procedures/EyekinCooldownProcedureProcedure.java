package net.mcreator.thedeepvoid.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.entity.RideableFlyingEyekinEntity;
import net.mcreator.thedeepvoid.entity.RideableEyekinEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class EyekinCooldownProcedureProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).eyekinCooldown > 0) {
			{
				TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
				_vars.eyekinCooldown = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).eyekinCooldown - 1;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).eyekinDash > 0) {
			{
				TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
				_vars.eyekinDash = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).eyekinDash - 1;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (entity.isPassenger()) {
			if ((entity.getVehicle()) instanceof RideableEyekinEntity || (entity.getVehicle()) instanceof RideableFlyingEyekinEntity) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.VOID_BLESSING, 40, 0, false, false));
			}
		}
	}
}
