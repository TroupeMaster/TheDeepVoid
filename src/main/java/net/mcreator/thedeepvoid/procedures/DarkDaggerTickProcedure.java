package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class DarkDaggerTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.DARK_TEAR.get()), x, y, z, 1, (Mth.nextInt(RandomSource.create(), (int) (-0.1), (int) 0.1)), (-0.1), (Mth.nextInt(RandomSource.create(), (int) (-0.1), (int) 0.1)),
					0.1);
		immediatesourceentity.setNoGravity(true);
		TheDeepVoidMod.queueServerWork(20, () -> {
			if (immediatesourceentity.getPersistentData().getBoolean("deep_void_played") == false) {
				immediatesourceentity.getPersistentData().putBoolean("deep_void_played", true);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.HOSTILE, 1, (float) 1.6);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.HOSTILE, 1, (float) 1.6, false);
					}
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						immediatesourceentity.getPersistentData().putDouble("deep_void_dis", Math
								.sqrt(Math.pow(entityiterator.getX() - immediatesourceentity.getX(), 0.8) + Math.pow(entityiterator.getY() - immediatesourceentity.getY(), 0.8) + Math.pow(entityiterator.getZ() - immediatesourceentity.getZ(), 0.8)));
						immediatesourceentity.setDeltaMovement(new Vec3(((entityiterator.getX() - immediatesourceentity.getX()) / immediatesourceentity.getPersistentData().getDouble("deep_void_dis")),
								((entityiterator.getY() - immediatesourceentity.getY()) / immediatesourceentity.getPersistentData().getDouble("deep_void_dis")),
								((entityiterator.getZ() - immediatesourceentity.getZ()) / immediatesourceentity.getPersistentData().getDouble("deep_void_dis"))));
					}
				}
			}
		});
		TheDeepVoidMod.queueServerWork(240, () -> {
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		});
	}
}
