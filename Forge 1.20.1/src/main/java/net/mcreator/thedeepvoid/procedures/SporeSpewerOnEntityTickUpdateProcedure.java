package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;
import net.mcreator.thedeepvoid.entity.SporeSpewerEntity;
import net.mcreator.thedeepvoid.entity.SmallFleshCubeEntity;
import net.mcreator.thedeepvoid.entity.LickerEntity;
import net.mcreator.thedeepvoid.entity.FleshCubeEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class SporeSpewerOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty() && !((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if (entity.getPersistentData().getDouble("deep_void:spew") >= 40) {
				entity.getPersistentData().putDouble("deep_void:spew", 0);
				if (entity instanceof SporeSpewerEntity) {
					((SporeSpewerEntity) entity).setAnimation("animation.sporeSpewer_spew");
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.shulker_bullet.hit")), SoundSource.HOSTILE, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.shulker_bullet.hit")), SoundSource.HOSTILE, 1, 1, false);
					}
				}
				TheDeepVoidMod.queueServerWork(10, () -> {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.PUS_SPORE.get()), x, (y + 0.8), z, 40, 4, 0.5, 4, 0.1);
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof SporeSpewerEntity == false && entityiterator instanceof LickerEntity == false && entityiterator instanceof FleshCubeEntity == false
									&& entityiterator instanceof SmallFleshCubeEntity == false) {
								if (!(entityiterator instanceof LivingEntity _livEnt12 && _livEnt12.hasEffect(MobEffects.CONFUSION))) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 240, 3));
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 240, 0));
								}
							}
						}
					}
				});
			} else {
				entity.getPersistentData().putDouble("deep_void:spew", (entity.getPersistentData().getDouble("deep_void:spew") + 1));
			}
		}
	}
}
