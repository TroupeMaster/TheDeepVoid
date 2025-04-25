package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.registries.Registries;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;

import java.util.List;
import java.util.Comparator;

public class SoulOrbOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("deep_void:pickedUp") == true) {
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 8, 8, 8), e -> true).isEmpty()) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Player) {
							if ((entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hasSoulOrb == true) {
								if ((entity.getPersistentData().getString("deep_void:owner")).equals(entityiterator.getDisplayName().getString())) {
									{
										Entity _ent = entity;
										_ent.teleportTo((entityiterator.getX()), (entityiterator.getY() + 2.5), (entityiterator.getZ()));
										if (_ent instanceof ServerPlayer _serverPlayer)
											_serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY() + 2.5), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
									}
								}
							} else {
								entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_ATTACK), entityiterator), 1);
							}
						}
					}
				}
			}
		}
	}
}
