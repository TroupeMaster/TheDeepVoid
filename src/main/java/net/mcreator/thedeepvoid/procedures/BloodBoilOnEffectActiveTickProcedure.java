package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;

public class BloodBoilOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)), 1);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.FLAME_OF_SPITE.get()), x, (y + Mth.nextInt(RandomSource.create(), 0, 2)), z, 2, 0.01, 0.1, 0.01, 0.1);
	}
}
