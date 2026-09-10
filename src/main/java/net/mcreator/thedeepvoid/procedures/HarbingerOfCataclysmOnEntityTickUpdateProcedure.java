package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.thedeepvoid.entity.HarbingerOfCataclysmEntity;

public class HarbingerOfCataclysmOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double rnd = 0;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Player
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0 && (entity instanceof HarbingerOfCataclysmEntity _datEntL5 && _datEntL5.getEntityData().get(HarbingerOfCataclysmEntity.DATA_attacking)) == false) {
			if (entity instanceof HarbingerOfCataclysmEntity _datEntSetI)
				_datEntSetI.getEntityData().set(HarbingerOfCataclysmEntity.DATA_attackChance, (int) ((entity instanceof HarbingerOfCataclysmEntity _datEntI ? _datEntI.getEntityData().get(HarbingerOfCataclysmEntity.DATA_attackChance) : 0)
						+ (((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _entUseItem8 ? _entUseItem8.getUseItem() : ItemStack.EMPTY).getItem().isEdible() ? 2 : 1)));
		}
		if ((entity instanceof HarbingerOfCataclysmEntity _datEntI ? _datEntI.getEntityData().get(HarbingerOfCataclysmEntity.DATA_attackChance) : 0) >= 60) {
			if (entity instanceof HarbingerOfCataclysmEntity _datEntSetI)
				_datEntSetI.getEntityData().set(HarbingerOfCataclysmEntity.DATA_attackChance, 0);
			rnd = Mth.nextInt(RandomSource.create(), 1, 5);
			if (rnd == 1) {
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty()) {
					HarbingerSlashProcedure.execute(world, entity);
				} else {
					if (entity instanceof HarbingerOfCataclysmEntity _datEntSetI)
						_datEntSetI.getEntityData().set(HarbingerOfCataclysmEntity.DATA_attackChance, 60);
				}
			} else if (rnd == 2) {
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 28, 28, 28), e -> true).isEmpty()) {
					HarbingerPierceProcedure.execute(world, entity);
				} else {
					if (entity instanceof HarbingerOfCataclysmEntity _datEntSetI)
						_datEntSetI.getEntityData().set(HarbingerOfCataclysmEntity.DATA_attackChance, 60);
				}
			} else if (rnd == 3) {
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty()) {
					HarbingerGroundPoundProcedure.execute(world, x, y, z, entity);
				} else {
					if (entity instanceof HarbingerOfCataclysmEntity _datEntSetI)
						_datEntSetI.getEntityData().set(HarbingerOfCataclysmEntity.DATA_attackChance, 60);
				}
			} else if (rnd == 4) {
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty()) {
					HarbingerParryProcedure.execute(world, entity);
				} else {
					if (entity instanceof HarbingerOfCataclysmEntity _datEntSetI)
						_datEntSetI.getEntityData().set(HarbingerOfCataclysmEntity.DATA_attackChance, 60);
				}
			} else if (rnd == 5) {
				if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty())) {
					HarbingerTeleportProcedure.execute(world, entity);
				} else {
					if (entity instanceof HarbingerOfCataclysmEntity _datEntSetI)
						_datEntSetI.getEntityData().set(HarbingerOfCataclysmEntity.DATA_attackChance, 60);
				}
			}
		}
		HarbingerTeleportAttackProcedure.execute(world, x, y, z, entity);
		HarbingerTickAdditionsProcedure.execute(world, x, y, z, entity);
		WeaverBossMusicProcedure.execute(world, x, y, z, entity);
	}
}
