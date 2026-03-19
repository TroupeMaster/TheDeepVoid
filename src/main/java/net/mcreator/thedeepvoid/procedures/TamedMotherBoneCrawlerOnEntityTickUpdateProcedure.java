package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;
import net.mcreator.thedeepvoid.entity.TamedMotherBoneCrawlerEntity;
import net.mcreator.thedeepvoid.entity.TamedBoneCrawlerEntity;
import net.mcreator.thedeepvoid.entity.TamedAlphaBoneCrawlerEntity;
import net.mcreator.thedeepvoid.entity.BabyBoneCrawlerNeutralEntity;

import java.util.List;
import java.util.Comparator;

public class TamedMotherBoneCrawlerOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof TamedMotherBoneCrawlerEntity _datEntI ? _datEntI.getEntityData().get(TamedMotherBoneCrawlerEntity.DATA_layTick) : 0) >= 1200) {
			if (entity instanceof TamedMotherBoneCrawlerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(TamedMotherBoneCrawlerEntity.DATA_layTick, 0);
			if (Math.random() < 0.1) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(TheDeepVoidModBlocks.BONE_CRAWLER_EGG.get()));
					entityToSpawn.setPickUpDelay(10);
					entityToSpawn.setUnlimitedLifetime();
					_level.addFreshEntity(entityToSpawn);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.chicken.egg")), SoundSource.NEUTRAL, 1, (float) 0.8);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.chicken.egg")), SoundSource.NEUTRAL, 1, (float) 0.8, false);
					}
				}
			}
		} else {
			if (entity instanceof TamedMotherBoneCrawlerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(TamedMotherBoneCrawlerEntity.DATA_layTick, (int) ((entity instanceof TamedMotherBoneCrawlerEntity _datEntI ? _datEntI.getEntityData().get(TamedMotherBoneCrawlerEntity.DATA_layTick) : 0) + 1));
		}
		if (!world.getEntitiesOfClass(TamedBoneCrawlerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).isEmpty()
				|| !world.getEntitiesOfClass(TamedAlphaBoneCrawlerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).isEmpty()
				|| !world.getEntitiesOfClass(BabyBoneCrawlerNeutralEntity.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).isEmpty()) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof TamedBoneCrawlerEntity || entityiterator instanceof TamedAlphaBoneCrawlerEntity || entityiterator instanceof BabyBoneCrawlerNeutralEntity) {
						if ((entityiterator instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 5, 0, false, false));
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 5, 0, false, false));
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 5, 0, false, false));
						}
					}
				}
			}
		}
	}
}
