package net.mcreator.thedeepvoid.procedures;

import net.neoforged.neoforge.event.entity.living.LivingAttackEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class AllSeeingSwordKillProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(Entity entity, Entity sourceentity, double amount) {
		execute(null, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity, double amount) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof LivingEntity && sourceentity instanceof LivingEntity) {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.ALL_SEEING_SWORD.get()
					|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.LAVENDITE_ALL_SEEING_SWORD.get()
					|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.ROTTEN_ALL_SEEING_SWORD.get()) {
				if (Math.random() < 0.5) {
					if (amount >= 5) {
						{
							TheDeepVoidModVariables.PlayerVariables _vars = sourceentity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
							_vars.hasteAllSeeing = sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DIG_SPEED) ? _livEnt.getEffect(MobEffects.DIG_SPEED).getAmplifier() : 0;
							_vars.syncPlayerVariables(sourceentity);
						}
						if (sourceentity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.DIG_SPEED);
						if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 40, (int) (sourceentity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hasteAllSeeing + 1), false, false));
					}
				}
			}
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.SOUL_CLEAVER.get()) {
				if (Math.random() < 0.7) {
					if (amount >= 8) {
						{
							TheDeepVoidModVariables.PlayerVariables _vars = sourceentity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
							_vars.hasteAllSeeing = sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DIG_SPEED) ? _livEnt.getEffect(MobEffects.DIG_SPEED).getAmplifier() : 0;
							_vars.syncPlayerVariables(sourceentity);
						}
						if (sourceentity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.DIG_SPEED);
						if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 55, (int) (sourceentity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hasteAllSeeing + 1), false, false));
					}
				}
			}
		}
	}
}
