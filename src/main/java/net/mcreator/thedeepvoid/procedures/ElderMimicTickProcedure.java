package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.entity.ElderMimicEntity;

import java.util.List;
import java.util.Comparator;

public class ElderMimicTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Player) {
				ElderMimicCopyEquipmentProcedure.execute(entity);
				ElderMimicEatProcedure.execute(world, x, y, z, entity);
			}
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
			if (entity instanceof ElderMimicEntity _datEntSetI)
				_datEntSetI.getEntityData().set(ElderMimicEntity.DATA_attackChance, (int) ((entity instanceof ElderMimicEntity _datEntI ? _datEntI.getEntityData().get(ElderMimicEntity.DATA_attackChance) : 0) + 1));
		}
		if ((entity instanceof ElderMimicEntity _datEntI ? _datEntI.getEntityData().get(ElderMimicEntity.DATA_attackChance) : 0) == 80) {
			ElderMimicShootProcedure.execute(world, x, y, z, entity);
		} else if ((entity instanceof ElderMimicEntity _datEntI ? _datEntI.getEntityData().get(ElderMimicEntity.DATA_attackChance) : 0) == 160) {
			entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 2), 0.2, (Math.cos(Math.toRadians(entity.getYRot())) * 2)));
		} else if ((entity instanceof ElderMimicEntity _datEntI ? _datEntI.getEntityData().get(ElderMimicEntity.DATA_attackChance) : 0) == 240) {
			ElderMimicSummonClonesProcedure.execute(world, x, y, z, entity);
		} else if ((entity instanceof ElderMimicEntity _datEntI ? _datEntI.getEntityData().get(ElderMimicEntity.DATA_attackChance) : 0) == 340) {
			if (entity instanceof ElderMimicEntity _datEntSetI)
				_datEntSetI.getEntityData().set(ElderMimicEntity.DATA_attackChance, 0);
		}
		WeaverBossMusicProcedure.execute(world, x, y, z, entity);
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).isEmpty()) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.WEAVER_CURSE.get(), 5, 0, false, false));
					}
				}
			}
		}
	}
}
