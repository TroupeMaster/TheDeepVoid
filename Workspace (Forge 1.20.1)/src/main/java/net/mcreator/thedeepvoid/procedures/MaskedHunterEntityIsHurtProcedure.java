package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.entity.MaskedHunterEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class MaskedHunterEntityIsHurtProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
				}
				return false;
			}
		}.checkGamemode(sourceentity)) && !entity.isInWaterOrBubble()) {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == sourceentity) {
					if (sourceentity.getY() > entity.getY() + 2 && sourceentity.getY() < entity.getY() + 6) {
						if (Math.random() < 0.5) {
							if (entity.getPersistentData().getBoolean("jumping") == false) {
								entity.getPersistentData().putBoolean("jumping", true);
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 99, false, false));
								if (entity instanceof MaskedHunterEntity) {
									((MaskedHunterEntity) entity).setAnimation("animation.hunterTrue_jump");
								}
								TheDeepVoidMod.queueServerWork(10, () -> {
									entity.getPersistentData().putBoolean("jumping", false);
									entity.setDeltaMovement(new Vec3(((sourceentity.getX() - entity.getX()) * 0.15), ((sourceentity.getY() - entity.getY()) * 0.2), ((sourceentity.getZ() - entity.getZ()) * 0.15)));
								});
							}
						}
					}
				}
			}
		}
	}
}
