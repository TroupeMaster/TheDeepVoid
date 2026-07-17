package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHealEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.entity.FalseHydraEntity;
import net.mcreator.thedeepvoid.entity.FalseHydraArmEntity;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class GoldenBloodRegenerationProcedure {
	@SubscribeEvent
	public static void onEntityHealed(LivingHealEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getAmount());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double amount) {
		execute(null, world, x, y, z, entity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, double amount) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(TheDeepVoidModMobEffects.GOLDEN_BLOOD.get())) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)
						+ amount * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.GOLDEN_BLOOD.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.GOLDEN_BLOOD.get()).getAmplifier() : 0) + 0.5)));
		}
		if (entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(TheDeepVoidModMobEffects.DEBILITATED.get())) {
			if (Math.random() < 0.4) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(TheDeepVoidModMobEffects.GLUTTONY.get()) && !world.getEntitiesOfClass(FalseHydraEntity.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).isEmpty()) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(64 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof FalseHydraEntity || entityiterator instanceof FalseHydraArmEntity) {
						if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
							if (entityiterator instanceof LivingEntity _entity)
								_entity.setHealth((float) ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + amount * 5));
						}
					}
				}
			}
		}
	}
}
