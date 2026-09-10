package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.BlockPos;

public class PitShakeOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			_ent.setYRot((float) (entity.getYRot() + Mth.nextDouble(RandomSource.create(), -0.2, 0.2)));
			_ent.setXRot((float) (entity.getXRot() + Mth.nextDouble(RandomSource.create(), -0.2, 0.2)));
			_ent.setYBodyRot(_ent.getYRot());
			_ent.setYHeadRot(_ent.getYRot());
			_ent.yRotO = _ent.getYRot();
			_ent.xRotO = _ent.getXRot();
			if (_ent instanceof LivingEntity _entity) {
				_entity.yBodyRotO = _entity.getYRot();
				_entity.yHeadRotO = _entity.getYRot();
			}
		}
		int horizontalRadiusSphere = (int) 14 - 1;
		int verticalRadiusSphere = (int) 14 - 1;
		int yIterationsSphere = verticalRadiusSphere;
		for (int i = -yIterationsSphere; i <= yIterationsSphere; i++) {
			for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
				for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
					double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (i * i) / (double) (verticalRadiusSphere * verticalRadiusSphere)
							+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
					if (distanceSq <= 1.0) {
						if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).is(BlockTags.create(new ResourceLocation("the_deep_void:spawn_particles_pit")))
								&& !world.getBlockState(BlockPos.containing(x + xi, y + i - 1, z + zi)).canOcclude() && Math.random() < 0.25) {
							world.addParticle((new BlockParticleOption(ParticleTypes.BLOCK, (world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))))), (x + xi + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (y + i - 0.1),
									(z + zi + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 0, (-1.65), 0);
						}
					}
				}
			}
		}
	}
}
