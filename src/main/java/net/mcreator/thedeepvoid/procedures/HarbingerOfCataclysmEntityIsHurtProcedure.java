package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.entity.HarbingerOfCataclysmEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class HarbingerOfCataclysmEntityIsHurtProcedure {
	public static boolean execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return false;
		if (sourceentity instanceof LivingEntity && (entity instanceof HarbingerOfCataclysmEntity _datEntI ? _datEntI.getEntityData().get(HarbingerOfCataclysmEntity.DATA_parry) : 0) > 0) {
			if (entity instanceof HarbingerOfCataclysmEntity) {
				((HarbingerOfCataclysmEntity) entity).setAnimation("empty");
			}
			if (entity instanceof HarbingerOfCataclysmEntity) {
				((HarbingerOfCataclysmEntity) entity).setAnimation("animation.harbinger_parrySuccess");
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.HOSTILE, 1, (float) 1.6);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.HOSTILE, 1, (float) 1.6, false);
				}
			}
			if (entity instanceof HarbingerOfCataclysmEntity _datEntSetI)
				_datEntSetI.getEntityData().set(HarbingerOfCataclysmEntity.DATA_parry, 0);
			if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 16, 1));
			if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 16, 9));
			TheDeepVoidMod.queueServerWork(5, () -> {
				if (entity instanceof HarbingerOfCataclysmEntity) {
					((HarbingerOfCataclysmEntity) entity).setAnimation("empty");
				}
				if (entity instanceof HarbingerOfCataclysmEntity) {
					((HarbingerOfCataclysmEntity) entity).setAnimation("animation.harbinger_teleportSlash");
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 16, 99, false, false));
			});
			TheDeepVoidMod.queueServerWork(13, () -> {
				{
					final Vec3 _center = new Vec3(
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
							(entity.getY()),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof LivingEntity && !(entityiterator == entity) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:boss")))) {
							if ((entityiterator instanceof LivingEntity _entUseItem21 ? _entUseItem21.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem) {
								if (entityiterator instanceof Player _player)
									_player.getCooldowns().addCooldown((entityiterator instanceof LivingEntity _entUseItem23 ? _entUseItem23.getUseItem() : ItemStack.EMPTY).getItem(), 100);
								{
									ItemStack _ist = (entityiterator instanceof LivingEntity _entUseItem25 ? _entUseItem25.getUseItem() : ItemStack.EMPTY);
									if (_ist.hurt(6, RandomSource.create(), null)) {
										_ist.shrink(1);
										_ist.setDamageValue(0);
									}
								}
								if (entityiterator instanceof LivingEntity _entity)
									_entity.stopUsingItem();
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")),
												SoundSource.PLAYERS, 1, 1);
									} else {
										_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")), SoundSource.PLAYERS, 1, 1,
												false);
									}
								}
							} else {
								entityiterator.hurt(
										new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:boss_attack"))), entity), 12);
							}
						}
					}
				}
			});
			TheDeepVoidMod.queueServerWork(16, () -> {
				if (entity instanceof HarbingerOfCataclysmEntity _datEntSetL)
					_datEntSetL.getEntityData().set(HarbingerOfCataclysmEntity.DATA_attacking, false);
			});
			return false;
		}
		return true;
	}
}
