package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;

import java.util.List;
import java.util.Comparator;

public class ClawScytheItemInHandTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getBoolean("clicked") == true && (entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) > 6) {
			if (itemstack.getOrCreateTag().getDouble("state") > 8) {
				itemstack.getOrCreateTag().putDouble("state", 1);
			} else {
				itemstack.getOrCreateTag().putDouble("state", (itemstack.getOrCreateTag().getDouble("state") + 1));
			}
			if (itemstack.getOrCreateTag().getDouble("sound") >= 8) {
				itemstack.getOrCreateTag().putDouble("sound", 0);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.PLAYERS, (float) 1.5, (float) 0.4);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.PLAYERS, (float) 1.5, (float) 0.4, false);
					}
				}
			} else {
				itemstack.getOrCreateTag().putDouble("sound", (itemstack.getOrCreateTag().getDouble("sound") + 1));
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity && !(entityiterator == entity)) {
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_ATTACK), entity),
								(float) (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue() * 1.2));
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 0));
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.ROT.get(), 100, 1));
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SWEEP_ATTACK, (entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()), 1, 0, 0, 0, 0);
					}
				}
			}
			if (entity.getPersistentData().getBoolean("grabbedByApostle") == false && entity.getPersistentData().getBoolean("piercedByApostle") == false && entity.getPersistentData().getBoolean("grabbedByExecutioner") == false
					&& !(entity instanceof LivingEntity _livEnt35 && _livEnt35.hasEffect(TheDeepVoidModMobEffects.BULLSEYE.get())) && !(entity instanceof LivingEntity _livEnt36 && _livEnt36.hasEffect(TheDeepVoidModMobEffects.CHAINED.get()))
					&& !(entity instanceof LivingEntity _livEnt37 && _livEnt37.hasEffect(TheDeepVoidModMobEffects.ROOT_BLIND.get())) && !(entity instanceof LivingEntity _livEnt38 && _livEnt38.hasEffect(TheDeepVoidModMobEffects.HEAVY.get()))) {
				entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 0.3), (-0.6), (Math.cos(Math.toRadians(entity.getYRot())) * 0.3)));
			}
			if (itemstack.getOrCreateTag().getDouble("food") >= 10) {
				itemstack.getOrCreateTag().putDouble("food", 0);
				if (entity instanceof Player _player)
					_player.getFoodData().setFoodLevel((int) ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) - 0.4));
			} else {
				itemstack.getOrCreateTag().putDouble("food", (itemstack.getOrCreateTag().getDouble("food") + 1));
			}
		}
	}
}
