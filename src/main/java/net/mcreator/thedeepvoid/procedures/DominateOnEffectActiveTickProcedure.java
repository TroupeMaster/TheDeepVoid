package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.thedeepvoid.entity.FalseHydraEntity;
import net.mcreator.thedeepvoid.entity.FalseHydraArmEntity;

import java.util.List;
import java.util.Comparator;

public class DominateOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _entUseItem0 ? _entUseItem0.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem
				&& !world.getEntitiesOfClass(FalseHydraEntity.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).isEmpty()) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(64 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof FalseHydraEntity || entityiterator instanceof FalseHydraArmEntity) {
						if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2.1) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400, (int) (entityiterator instanceof FalseHydraArmEntity ? 1 : 5), false, false));
						} else {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400, (int) (entityiterator instanceof FalseHydraArmEntity ? 0 : 4), false, false));
						}
					}
				}
			}
		}
	}
}
