package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.entity.ExecutionerEntity;

import java.util.List;
import java.util.Comparator;

public class ExecutionerBashWaveProcedure {
	public static void execute(LevelAccessor world, double x, double z, Entity entity, double distance) {
		if (entity == null)
			return;
		{
			final Vec3 _center = new Vec3(entity.getX() + entity.getLookAngle().x * distance, (entity.getY()), entity.getZ() + entity.getLookAngle().z * distance);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof LivingEntity && !(entityiterator instanceof ExecutionerEntity)) {
					if ((entityiterator instanceof LivingEntity _entUseItem5 ? _entUseItem5.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem) {
						if (entityiterator instanceof Player _player)
							_player.getCooldowns().addCooldown((entityiterator instanceof LivingEntity _entUseItem7 ? _entUseItem7.getUseItem() : ItemStack.EMPTY).getItem(), 100);
						{
							ItemStack _ist = (entityiterator instanceof LivingEntity _entUseItem9 ? _entUseItem9.getUseItem() : ItemStack.EMPTY);
							if (_ist.hurt(10, RandomSource.create(), null)) {
								_ist.shrink(1);
								_ist.setDamageValue(0);
							}
						}
						if (entityiterator instanceof LivingEntity _entity)
							_entity.stopUsingItem();
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.break_block")),
										SoundSource.PLAYERS, (float) 0.4, 1);
							} else {
								_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.break_block")), SoundSource.PLAYERS,
										(float) 0.4, 1, false);
							}
						}
					}
					entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:boss_attack"))), entity), 18);
					entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x()), 1, (entityiterator.getDeltaMovement().z())));
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.BROKEN_ARMOR.get(), 100, 0));
				}
			}
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(entity.getX() + entity.getLookAngle().x * distance, entity.getY(), entity.getZ() + entity.getLookAngle().z * distance),
						ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.HOSTILE, 1, (float) 0.8);
			} else {
				_level.playLocalSound(entity.getX() + entity.getLookAngle().x * distance, (entity.getY()), entity.getZ() + entity.getLookAngle().z * distance, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
						SoundSource.HOSTILE, 1, (float) 0.8, false);
			}
		}
		for (int index0 = 0; index0 < 8; index0++) {
			entity.getPersistentData().putDouble("xPos", (Mth.nextInt(RandomSource.create(), -2, 2)));
			entity.getPersistentData().putDouble("zPos", (Mth.nextInt(RandomSource.create(), -2, 2)));
			world.levelEvent(2001,
					BlockPos.containing(entity.getX() + entity.getLookAngle().x * distance + 0.5 + entity.getPersistentData().getDouble("xPos"), entity.getY(),
							entity.getZ() + entity.getLookAngle().z * distance + 0.5 + entity.getPersistentData().getDouble("zPos")),
					Block.getId((world.getBlockState(BlockPos.containing(entity.getX() + entity.getLookAngle().x * distance + entity.getPersistentData().getDouble("xPos"), entity.getY() - 1,
							entity.getZ() + entity.getLookAngle().z * distance + entity.getPersistentData().getDouble("zPos"))))));
		}
	}
}
