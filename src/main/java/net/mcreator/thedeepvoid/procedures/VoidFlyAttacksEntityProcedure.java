package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.entity.BlackFlyEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class VoidFlyAttacksEntityProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getDirectEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		execute(null, world, entity, immediatesourceentity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		if (immediatesourceentity instanceof BlackFlyEntity && !(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(TheDeepVoidModMobEffects.PARASITIZED.get())) && Math.random() < 0.25) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.PARASITIZED.get(), 100, 0));
			entity.getPersistentData().putBoolean("voidFlyParasitized", true);
		}
		if (sourceentity instanceof BlackFlyEntity) {
			if (sourceentity instanceof BlackFlyEntity) {
				((BlackFlyEntity) sourceentity).setAnimation("animation.voidFly_attack");
			}
		}
		if (entity instanceof BlackFlyEntity && sourceentity instanceof LivingEntity && Math.random() < 0.25) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			} else if (event != null && event.hasResult()) {
				event.setResult(Event.Result.DENY);
			}
			entity.setDeltaMovement(new Vec3((Mth.nextDouble(RandomSource.create(), -1, 1)), 0, (Mth.nextDouble(RandomSource.create(), -1, 1))));
			TheDeepVoidMod.queueServerWork(10, () -> {
				entity.setDeltaMovement(new Vec3(0, 0, 0));
			});
		}
	}
}
