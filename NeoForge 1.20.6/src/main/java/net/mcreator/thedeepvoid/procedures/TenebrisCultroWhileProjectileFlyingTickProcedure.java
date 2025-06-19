package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class TenebrisCultroWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.DARK_TEAR.get()), x, y, z, 3, (Mth.nextInt(RandomSource.create(), (int) (-0.1), (int) 0.1)), (-0.1), (Mth.nextInt(RandomSource.create(), (int) (-0.1), (int) 0.1)),
					0.1);
		TheDeepVoidMod.queueServerWork(20, () -> {
			if (immediatesourceentity.getPersistentData().getBoolean("deep_void_played") == false) {
				immediatesourceentity.getPersistentData().putBoolean("deep_void_played", true);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("item.trident.throw")), SoundSource.PLAYERS, 1, (float) 1.4);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("item.trident.throw")), SoundSource.PLAYERS, 1, (float) 1.4, false);
					}
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, y, z), 30, 30, 30), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) == entityiterator) {
						if (!(entityiterator == entity || entityiterator == immediatesourceentity)) {
							immediatesourceentity.getPersistentData().putDouble("deep_void_dis",
									Math.sqrt(Math.pow(entityiterator.getX() - immediatesourceentity.getX(), 2) + Math.pow(entityiterator.getY() - immediatesourceentity.getY(), 2) + Math.pow(entityiterator.getZ() - immediatesourceentity.getZ(), 2)));
							immediatesourceentity.setDeltaMovement(new Vec3(((entityiterator.getX() - immediatesourceentity.getX()) / immediatesourceentity.getPersistentData().getDouble("deep_void_dis")),
									((entityiterator.getY() - immediatesourceentity.getY()) / immediatesourceentity.getPersistentData().getDouble("deep_void_dis")),
									((entityiterator.getZ() - immediatesourceentity.getZ()) / immediatesourceentity.getPersistentData().getDouble("deep_void_dis"))));
						}
					}
				}
			}
		});
	}
}
