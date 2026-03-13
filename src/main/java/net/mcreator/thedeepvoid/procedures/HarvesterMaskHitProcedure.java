package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class HarvesterMaskHitProcedure {
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
		double amplifier = 0;
		if ((sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.HARVESTER_MASK_HELMET.get()) {
			if (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(TheDeepVoidModMobEffects.HEXED.get())
					&& (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) >= (sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.ABSORPTION) ? _livEnt.getEffect(MobEffects.ABSORPTION).getAmplifier() : 0) * 2
							+ (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem() || sourceentity.isShiftKeyDown()) {
					entity.getPersistentData().putDouble("deep_void:hexedBuildUp", (entity.getPersistentData().getDouble("deep_void:hexedBuildUp") + Math.ceil((entity.getPersistentData().getDouble("deep_void:hexedBuildUp") * 60) / 100)));
					amplifier = sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.ABSORPTION) ? _livEnt.getEffect(MobEffects.ABSORPTION).getAmplifier() : 0;
					if (sourceentity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.ABSORPTION);
					if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 200, (int) (amplifier + Math.floor(entity.getPersistentData().getDouble("deep_void:hexedBuildUp") / 45)), false, false));
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(TheDeepVoidModMobEffects.HEXED.get());
				}
			}
		}
	}
}
