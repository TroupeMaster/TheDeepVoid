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
import net.mcreator.thedeepvoid.entity.MotherBoneCrawlerEntity;
import net.mcreator.thedeepvoid.entity.BoneCrawlerEntity;
import net.mcreator.thedeepvoid.entity.AlphaBoneCrawlerEntity;

import java.util.List;
import java.util.Comparator;

public class TamedMotherBoneCrawlerOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) {
			if ((entity instanceof MotherBoneCrawlerEntity _datEntL1 && _datEntL1.getEntityData().get(MotherBoneCrawlerEntity.DATA_tamed)) == false) {
				if (entity instanceof MotherBoneCrawlerEntity _datEntSetL)
					_datEntSetL.getEntityData().set(MotherBoneCrawlerEntity.DATA_tamed, true);
				if (entity instanceof MotherBoneCrawlerEntity animatable)
					animatable.setTexture("mother_crawler_no_egg");
			}
			if ((entity instanceof MotherBoneCrawlerEntity _datEntI ? _datEntI.getEntityData().get(MotherBoneCrawlerEntity.DATA_layEgg) : 0) >= 1200) {
				if (entity instanceof MotherBoneCrawlerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(MotherBoneCrawlerEntity.DATA_layEgg, 0);
				if (Math.random() < 0.1) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, entity.getX() + entity.getLookAngle().x * (-2), y, entity.getZ() + entity.getLookAngle().z * (-2), new ItemStack(TheDeepVoidModBlocks.BONE_CRAWLER_EGG.get()));
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
				if (entity instanceof MotherBoneCrawlerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(MotherBoneCrawlerEntity.DATA_layEgg, (int) ((entity instanceof MotherBoneCrawlerEntity _datEntI ? _datEntI.getEntityData().get(MotherBoneCrawlerEntity.DATA_layEgg) : 0) + 1));
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof BoneCrawlerEntity || entityiterator instanceof AlphaBoneCrawlerEntity) {
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
