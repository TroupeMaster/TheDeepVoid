package net.mcreator.thedeepvoid.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PlayerKillsEntityWithMaskProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
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
		if ((sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.WEAVER_MASK_HELMET.get()) {
			if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.HEALTH_BOOST) ? _livEnt.getEffect(MobEffects.HEALTH_BOOST).getAmplifier() : 0) < 24) {
				{
					TheDeepVoidModVariables.PlayerVariables _vars = sourceentity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
					_vars.healthBoostLevel = sourceentity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).healthBoostLevel + 1;
					_vars.syncPlayerVariables(sourceentity);
				}
				{
					TheDeepVoidModVariables.PlayerVariables _vars = sourceentity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
					_vars.healthMask = sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1;
					_vars.syncPlayerVariables(sourceentity);
				}
				if (sourceentity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.HEALTH_BOOST);
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, (int) Double.POSITIVE_INFINITY, (int) sourceentity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).healthBoostLevel, false, false));
				if (sourceentity instanceof LivingEntity _entity)
					_entity.setHealth((float) sourceentity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).healthMask);
			} else {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 160, 0, false, false));
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 160, 1, false, false));
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 160, 1, false, false));
			}
		}
		if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).healthBoostLevel > 0) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.HEALTH_BOOST);
			{
				TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
				_vars.healthBoostLevel = 0;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
