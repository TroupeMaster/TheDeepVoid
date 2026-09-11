package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.UndertakerEntity;

import java.util.List;
import java.util.Comparator;

public class UndertakerOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean success = false;
		UndertakerAttacksProcedure.execute(world, entity);
		if (entity.getPersistentData().getBoolean("noConversion") == true && entity.getPersistentData().getDouble("conversionQut") != 0) {
			entity.getPersistentData().putDouble("conversionQut", 0);
		}
		if ((entity instanceof UndertakerEntity _datEntI ? _datEntI.getEntityData().get(UndertakerEntity.DATA_despawn) : 0) > 0) {
			if (entity instanceof UndertakerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(UndertakerEntity.DATA_despawn, (int) ((entity instanceof UndertakerEntity _datEntI ? _datEntI.getEntityData().get(UndertakerEntity.DATA_despawn) : 0) - 1));
		} else if ((entity instanceof UndertakerEntity _datEntI ? _datEntI.getEntityData().get(UndertakerEntity.DATA_despawn) : 0) == 0) {
			success = true;
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(46 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player && (entity instanceof LivingEntity _entity ? _entity.hasLineOfSight(entityiterator) : false)) {
						success = false;
						break;
					}
				}
			}
			if (success == true) {
				if (!entity.level().isClientSide())
					entity.discard();
			} else {
				if (entity instanceof UndertakerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(UndertakerEntity.DATA_despawn, 4000);
			}
		}
		if ((entity instanceof UndertakerEntity _datEntL12 && _datEntL12.getEntityData().get(UndertakerEntity.DATA_empty)) == false && entity.getPersistentData().getDouble("firstTradeQut") == 0
				&& entity.getPersistentData().getDouble("secondTradeQut") == 0 && entity.getPersistentData().getDouble("thirdTradeQut") == 0 && entity.getPersistentData().getDouble("fourthTradeQut") == 0
				&& entity.getPersistentData().getDouble("potionTradeQut") == 0) {
			if (entity instanceof UndertakerEntity _datEntSetL)
				_datEntSetL.getEntityData().set(UndertakerEntity.DATA_empty, true);
		}
		if ((entity instanceof UndertakerEntity _datEntI ? _datEntI.getEntityData().get(UndertakerEntity.DATA_dialogueCooldown) : 0) > 0) {
			if (entity instanceof UndertakerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(UndertakerEntity.DATA_dialogueCooldown, (int) ((entity instanceof UndertakerEntity _datEntI ? _datEntI.getEntityData().get(UndertakerEntity.DATA_dialogueCooldown) : 0) - 1));
		}
		if ((entity instanceof UndertakerEntity _datEntI ? _datEntI.getEntityData().get(UndertakerEntity.DATA_talkCooldown) : 0) > 0) {
			if (entity instanceof UndertakerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(UndertakerEntity.DATA_talkCooldown, (int) ((entity instanceof UndertakerEntity _datEntI ? _datEntI.getEntityData().get(UndertakerEntity.DATA_talkCooldown) : 0) - 1));
		}
	}
}
