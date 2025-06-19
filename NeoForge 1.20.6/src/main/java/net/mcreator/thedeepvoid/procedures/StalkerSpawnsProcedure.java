package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.Comparator;

public class StalkerSpawnsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Mob _entity && ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 150, 150, 150), e -> true).stream().sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
			}
		}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _ent)
			_entity.setTarget(_ent);
		entity.getPersistentData().putDouble("voidCallCooldown", 540);
		TheDeepVoidMod.queueServerWork(5400, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
			TheDeepVoidModVariables.MapVariables.get(world).StalkerDespawned = true;
			TheDeepVoidModVariables.MapVariables.get(world).syncData(world);
		});
	}
}
