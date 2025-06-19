package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;

public class TrembleOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			_ent.setYRot((float) (entity.getYRot() + Mth.nextDouble(RandomSource.create(), -2, 2)));
			_ent.setXRot((float) (entity.getXRot() + Mth.nextDouble(RandomSource.create(), -2, 2)));
			_ent.setYBodyRot(_ent.getYRot());
			_ent.setYHeadRot(_ent.getYRot());
			_ent.yRotO = _ent.getYRot();
			_ent.xRotO = _ent.getXRot();
			if (_ent instanceof LivingEntity _entity) {
				_entity.yBodyRotO = _entity.getYRot();
				_entity.yHeadRotO = _entity.getYRot();
			}
		}
		for (int index0 = 0; index0 < 3; index0++) {
			world.addParticle((SimpleParticleType) (TheDeepVoidModParticleTypes.DEEPSLATE_PEBBLE.get()), (x + Mth.nextDouble(RandomSource.create(), -20, 20)), (y + 10), (z + Mth.nextDouble(RandomSource.create(), -20, 20)), 0, (-1), 0);
			world.addParticle(ParticleTypes.SMOKE, (x + Mth.nextDouble(RandomSource.create(), -20, 20)), (y + 10), (z + Mth.nextDouble(RandomSource.create(), -20, 20)), 0, (-0.5), 0);
		}
		if (Math.random() < 0.01) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:falling_rocks")), SoundSource.AMBIENT, 5, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:falling_rocks")), SoundSource.AMBIENT, 5, 1, false);
				}
			}
		}
	}
}
