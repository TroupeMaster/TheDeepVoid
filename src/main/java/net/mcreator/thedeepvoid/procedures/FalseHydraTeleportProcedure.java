package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.thedeepvoid.entity.FalseHydraEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class FalseHydraTeleportProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if (entity instanceof FalseHydraEntity) {
				((FalseHydraEntity) entity).setAnimation("empty");
			}
			if (entity instanceof FalseHydraEntity) {
				((FalseHydraEntity) entity).setAnimation("animation.falseHydra_dig");
			}
			TheDeepVoidMod.queueServerWork(40, () -> {
				{
					Entity _ent = entity;
					_ent.teleportTo(
							((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).level()
									.clip(new ClipContext((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f),
											(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f).add((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getViewVector(1f).scale((-10))),
											ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)))
									.getBlockPos().getX()),
							((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()),
							((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).level()
									.clip(new ClipContext((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f),
											(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f).add((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getViewVector(1f).scale((-10))),
											ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)))
									.getBlockPos().getZ()));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection
								.teleport(
										((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).level()
												.clip(new ClipContext((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f),
														(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f)
																.add((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getViewVector(1f).scale((-10))),
														ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)))
												.getBlockPos().getX()),
										((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()),
										((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).level()
												.clip(new ClipContext((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f),
														(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f)
																.add((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getViewVector(1f).scale((-10))),
														ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)))
												.getBlockPos().getZ()),
										_ent.getYRot(), _ent.getXRot());
				}
				if (entity instanceof FalseHydraEntity) {
					((FalseHydraEntity) entity).setAnimation("animation.falseHydra_out");
				}
			});
		}
	}
}
