package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingChangeTargetEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;
import net.mcreator.thedeepvoid.entity.VoidDwellerEntity;
import net.mcreator.thedeepvoid.entity.StalkingStalkerEntity;
import net.mcreator.thedeepvoid.entity.StalkerEntity;
import net.mcreator.thedeepvoid.entity.OverseerPillarEntity;
import net.mcreator.thedeepvoid.entity.OverseerEntity;
import net.mcreator.thedeepvoid.entity.NightmareEntity;
import net.mcreator.thedeepvoid.entity.MultipleEyesEntity;
import net.mcreator.thedeepvoid.entity.HallucinationEntity;
import net.mcreator.thedeepvoid.entity.GhostlyNightmareEntity;
import net.mcreator.thedeepvoid.entity.FourEyesEntity;
import net.mcreator.thedeepvoid.entity.EverhungerEntity;
import net.mcreator.thedeepvoid.entity.DamnedEntity;
import net.mcreator.thedeepvoid.entity.CrossEyesEntity;
import net.mcreator.thedeepvoid.entity.BigEyeEntity;
import net.mcreator.thedeepvoid.entity.BeholderEntity;
import net.mcreator.thedeepvoid.entity.AbductorEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AllSeeingArmorAttackTargetProcedure {
	@SubscribeEvent
	public static void onEntitySetsAttackTarget(LivingChangeTargetEvent event) {
		execute(event, event.getOriginalTarget(), event.getEntity());
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.ALL_SEEING_HELMET.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.ALL_SEEING_CHESTPLATE.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.ALL_SEEING_LEGGINGS.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.ALL_SEEING_BOOTS.get()) {
			if (!(sourceentity instanceof StalkerEntity) && !(sourceentity instanceof AbductorEntity) && !(sourceentity instanceof BeholderEntity) && !(sourceentity instanceof EverhungerEntity) && !(sourceentity instanceof DamnedEntity)
					&& !(sourceentity instanceof CrossEyesEntity) && !(sourceentity instanceof BigEyeEntity) && !(sourceentity instanceof FourEyesEntity) && !(sourceentity instanceof GhostlyNightmareEntity)
					&& !(sourceentity instanceof HallucinationEntity) && !(sourceentity instanceof MultipleEyesEntity) && !(sourceentity instanceof NightmareEntity) && !(sourceentity instanceof OverseerEntity)
					&& !(sourceentity instanceof OverseerPillarEntity) && !(sourceentity instanceof StalkingStalkerEntity) && !(sourceentity instanceof VoidDwellerEntity)) {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 100, 0, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 0, false, false));
			}
		}
	}
}
