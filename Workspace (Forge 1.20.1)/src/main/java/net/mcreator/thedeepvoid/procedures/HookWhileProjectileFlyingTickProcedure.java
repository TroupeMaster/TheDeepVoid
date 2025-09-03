package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class HookWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		double T = 0;
		double Zo = 0;
		double Yo = 0;
		double Za = 0;
		double Xo = 0;
		double Ya = 0;
		double Xa = 0;
		immediatesourceentity.setNoGravity(true);
		TheDeepVoidMod.queueServerWork(40, () -> {
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		});
		Xo = entity.getX() - immediatesourceentity.getX();
		Yo = entity.getY() - immediatesourceentity.getY();
		Zo = entity.getZ() - immediatesourceentity.getZ();
		if (Math.floor(entity.getX()) <= Math.floor(immediatesourceentity.getX())) {
			if (Math.floor(entity.getX()) == Math.floor(immediatesourceentity.getX())) {
				if (Math.floor(entity.getY()) == Math.floor(immediatesourceentity.getY())) {
					if (Math.floor(entity.getZ()) <= Math.floor(immediatesourceentity.getZ())) {
						Za = Math.floor(entity.getZ()) + 0.2;
						while (Za <= Math.floor(immediatesourceentity.getZ())) {
							T = (Za - entity.getZ()) / Zo;
							Ya = entity.getBbHeight() / 2 + entity.getY() + Yo * T;
							Xa = entity.getX() + Xo * T;
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.HOOK_LINE.get()), Xa, Ya, Za, 1, 0, 0, 0, 0);
							Za = 0.2 + Za;
						}
					} else {
						Za = Math.floor(immediatesourceentity.getZ()) + 0.2;
						while (Za <= Math.floor(entity.getZ())) {
							T = (Za - entity.getZ()) / Zo;
							Ya = entity.getBbHeight() / 2 + entity.getY() + Yo * T;
							Xa = entity.getX() + Xo * T;
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.HOOK_LINE.get()), Xa, Ya, Za, 1, 0, 0, 0, 0);
							Za = 0.2 + Za;
						}
					}
				} else {
					if (Math.floor(entity.getY()) <= Math.floor(immediatesourceentity.getY())) {
						Ya = Math.floor(entity.getY()) + 0.2;
						while (Ya <= Math.floor(immediatesourceentity.getY())) {
							T = (Ya - entity.getY()) / Yo;
							Xa = entity.getX() + Xo * T;
							Za = entity.getZ() + Zo * T;
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.HOOK_LINE.get()), Xa, Ya, Za, 1, 0, 0, 0, 0);
							Ya = 0.2 + Ya;
						}
					} else {
						Ya = Math.floor(immediatesourceentity.getY()) + 0.2;
						while (Ya <= Math.floor(entity.getY())) {
							T = (Ya - entity.getY()) / Yo;
							Xa = entity.getX() + Xo * T;
							Za = entity.getZ() + Zo * T;
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.HOOK_LINE.get()), Xa, Ya, Za, 1, 0, 0, 0, 0);
							Ya = 0.2 + Ya;
						}
					}
				}
			} else {
				Xa = Math.floor(entity.getX()) + 0.2;
				while (Xa <= Math.floor(immediatesourceentity.getX())) {
					T = (Xa - entity.getX()) / Xo;
					Ya = entity.getBbHeight() / 2 + entity.getY() + Yo * T;
					Za = entity.getZ() + Zo * T;
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.HOOK_LINE.get()), Xa, Ya, Za, 1, 0, 0, 0, 0);
					Xa = 0.2 + Xa;
				}
			}
		} else {
			Xa = immediatesourceentity.getX() + 0.2;
			while (Xa < Math.floor(entity.getX())) {
				T = (Xa - entity.getX()) / Xo;
				Ya = entity.getBbHeight() / 2 + entity.getY() + Yo * T;
				Za = entity.getZ() + Zo * T;
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.HOOK_LINE.get()), Xa, Ya, Za, 1, 0, 0, 0, 0);
				Xa = 0.2 + Xa;
			}
		}
	}
}
