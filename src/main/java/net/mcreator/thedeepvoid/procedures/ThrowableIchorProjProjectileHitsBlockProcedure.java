package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.IchorFlameShotEntity;

public class ThrowableIchorProjProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 8, 16); index0++) {
			if (world instanceof ServerLevel projectileLevel) {
				Projectile _entityToSpawn = new Object() {
					public Projectile getArrow(Level level, float damage, int knockback) {
						AbstractArrow entityToSpawn = new IchorFlameShotEntity(TheDeepVoidModEntities.ICHOR_FLAME_SHOT.get(), level);
						entityToSpawn.setBaseDamage(damage);
						entityToSpawn.setKnockback(knockback);
						entityToSpawn.setSilent(true);
						return entityToSpawn;
					}
				}.getArrow(projectileLevel, 2, 0);
				_entityToSpawn.setPos(x, (y + 1), z);
				_entityToSpawn.shoot((Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 0.2, (Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (float) Mth.nextDouble(RandomSource.create(), 0.1, 0.8), 50);
				projectileLevel.addFreshEntity(_entityToSpawn);
			}
		}
		world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.GLASS.defaultBlockState()));
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.BLOCKS, 1, (float) 0.7);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.BLOCKS, 1, (float) 0.7, false);
			}
		}
	}
}
