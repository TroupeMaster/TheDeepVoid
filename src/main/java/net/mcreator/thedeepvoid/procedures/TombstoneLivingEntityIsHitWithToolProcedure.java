package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.entity.LightEntity;
import net.mcreator.thedeepvoid.entity.DoomingTombstoneEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class TombstoneLivingEntityIsHitWithToolProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		double xRadius = 0;
		double loop = 0;
		double zRadius = 0;
		double particleAmount = 0;
		itemstack.getOrCreateTag().putDouble("deep_void:doom", (itemstack.getOrCreateTag().getDouble("deep_void:doom") + 1));
		if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 8, 99, false, false));
		if (itemstack.getOrCreateTag().getDouble("deep_void:doom") == 1) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:tombstone_mobhit1")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:tombstone_mobhit1")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
		}
		if (itemstack.getOrCreateTag().getDouble("deep_void:doom") == 2) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:tombstone_mobhit2")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:tombstone_mobhit2")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			itemstack.getOrCreateTag().putBoolean("deep_void:jump", true);
		}
		if (itemstack.getOrCreateTag().getDouble("deep_void:doom") == 3) {
			itemstack.getOrCreateTag().putDouble("deep_void:doom", 0);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:tombstone_mobhit3")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:tombstone_mobhit3")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity && !(entityiterator == sourceentity) && !(entityiterator instanceof DoomingTombstoneEntity) && !(entityiterator instanceof LightEntity)) {
						TheDeepVoidMod.queueServerWork(Mth.nextInt(RandomSource.create(), 0, 20), () -> {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.DOOM.get(), 20, 0));
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 5, 0.1, 1, 0.1, 0.1);
						});
					}
				}
			}
		}
	}
}
