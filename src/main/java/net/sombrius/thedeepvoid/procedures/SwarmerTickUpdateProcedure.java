package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.SwarmerEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

public class SwarmerTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if ((entity instanceof SwarmerEntity _datEntI ? _datEntI.getEntityData().get(SwarmerEntity.DATA_dash) : 0) >= 40) {
				if (entity instanceof SwarmerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(SwarmerEntity.DATA_dash, 0);
				entity.setDeltaMovement(new Vec3((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - entity.getX()) * 0.18),
						(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() - entity.getY()) * 0.18), (((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - entity.getZ()) * 0.18)));
			} else {
				if (entity instanceof SwarmerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(SwarmerEntity.DATA_dash, (int) ((entity instanceof SwarmerEntity _datEntI ? _datEntI.getEntityData().get(SwarmerEntity.DATA_dash) : 0) + 1));
			}
		}
	}
}
