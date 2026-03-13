package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerKillsEntityProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.GRIM_ROTTEN_BONE_HELMET.get()
				&& (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.GRIM_ROTTEN_BONE_CHESTPLATE.get()
				&& (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.GRIM_ROTTEN_BONE_LEGGINGS.get()
				&& (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.GRIM_ROTTEN_BONE_BOOTS.get()) {
			{
				double _setval = 0;
				sourceentity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.RottenArmorAbility = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		}
		if (entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(TheDeepVoidModMobEffects.EXPERIENCED.get()) && entity instanceof LivingEntity && sourceentity instanceof LivingEntity) {
			for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(),
					(int) (1 + Math.round((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.EXPERIENCED.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.EXPERIENCED.get()).getAmplifier() : 0) / 2)),
					(int) (4 + Math.round((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.EXPERIENCED.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.EXPERIENCED.get()).getAmplifier() : 0) / 2))); index0++) {
				if (world instanceof ServerLevel _level)
					_level.addFreshEntity(new ExperienceOrb(_level, (entity.getX()), (entity.getY()), (entity.getZ()),
							Mth.nextInt(RandomSource.create(), 1,
									(int) Math.round((4 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.EXPERIENCED.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.EXPERIENCED.get()).getAmplifier() : 0))
											* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.EXPERIENCED.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.EXPERIENCED.get()).getDuration() : 0) / 120)))));
			}
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(TheDeepVoidModMobEffects.EXPERIENCED.get());
		}
	}
}
