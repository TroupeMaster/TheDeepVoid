package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;
import net.mcreator.thedeepvoid.entity.LavenditeShardProjEntity;

public class LavenditeSwordLivingEntityIsHitWithToolProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity, ItemStack itemstack) {
		if (sourceentity == null)
			return;
		if (Math.random() < 0.5) {
			{
				ItemStack _ist = itemstack;
				if (_ist.hurt(999, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			for (int index0 = 0; index0 < 6; index0++) {
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
							AbstractArrow entityToSpawn = new LavenditeShardProjEntity(TheDeepVoidModEntities.LAVENDITE_SHARD_PROJ.get(), level);
							entityToSpawn.setOwner(shooter);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback(knockback);
							entityToSpawn.setSilent(true);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, sourceentity, 3, (int) 0.1);
					_entityToSpawn.setPos(x, (y + 1), z);
					_entityToSpawn.shoot((Mth.nextDouble(RandomSource.create(), -0.4, 0.4)), 0.1, (Mth.nextDouble(RandomSource.create(), -0.4, 0.4)), (float) 1.2, 10);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
			world.levelEvent(2001, BlockPos.containing(x, y + 0.7, z), Block.getId(TheDeepVoidModBlocks.BLOCK_OF_LAVENDITE.get().defaultBlockState()));
		}
	}
}
