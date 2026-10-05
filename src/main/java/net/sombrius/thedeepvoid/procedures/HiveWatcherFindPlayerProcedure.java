package net.sombrius.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class HiveWatcherFindPlayerProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double pos = 0;
		for (int index0 = 0; index0 < 26; index0++) {
			if (!world.getEntitiesOfClass(Player.class,
					AABB.ofSize(new Vec3((entity.getX() + pos), (entity.getY() + 1), (entity.getZ())),
							((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 4 ? 20 : 7),
							((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 4 ? 20 : 7),
							((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 4 ? 20 : 7)),
					e -> true).isEmpty()) {
				entity.getPersistentData().putBoolean("foundPlayer", true);
				entity.getPersistentData().putDouble("playerIsIn", 1);
				break;
			} else if (!world.getEntitiesOfClass(Player.class,
					AABB.ofSize(new Vec3((entity.getX() - pos), (entity.getY() + 1), (entity.getZ())),
							((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 4 ? 20 : 7),
							((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 4 ? 20 : 7),
							((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 4 ? 20 : 7)),
					e -> true).isEmpty()) {
				entity.getPersistentData().putBoolean("foundPlayer", true);
				entity.getPersistentData().putDouble("playerIsIn", 2);
				break;
			} else if (!world.getEntitiesOfClass(Player.class,
					AABB.ofSize(new Vec3((entity.getX()), (entity.getY() + 1), (entity.getZ() + pos)),
							((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 4 ? 20 : 7),
							((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 4 ? 20 : 7),
							((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 4 ? 20 : 7)),
					e -> true).isEmpty()) {
				entity.getPersistentData().putBoolean("foundPlayer", true);
				entity.getPersistentData().putDouble("playerIsIn", 3);
				break;
			} else if (!world.getEntitiesOfClass(Player.class,
					AABB.ofSize(new Vec3((entity.getX()), (entity.getY() + 1), (entity.getZ() - pos)),
							((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 4 ? 20 : 7),
							((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 4 ? 20 : 7),
							((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 4 ? 20 : 7)),
					e -> true).isEmpty()) {
				entity.getPersistentData().putBoolean("foundPlayer", true);
				entity.getPersistentData().putDouble("playerIsIn", 4);
				break;
			}
			pos = pos + 1;
		}
	}
}
