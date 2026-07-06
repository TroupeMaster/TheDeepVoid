package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;
import net.mcreator.thedeepvoid.entity.PrimordialBoneCrawlerEntity;
import net.mcreator.thedeepvoid.entity.GooBlockEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

import java.util.List;
import java.util.Comparator;

public class PrimordialCrawlerAirSlamTouchGroundProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof PrimordialBoneCrawlerEntity _datEntL0 && _datEntL0.getEntityData().get(PrimordialBoneCrawlerEntity.DATA_airSlam)) == true && entity.onGround()) {
			if (entity instanceof PrimordialBoneCrawlerEntity _datEntSetL)
				_datEntSetL.getEntityData().set(PrimordialBoneCrawlerEntity.DATA_airSlam, false);
			if (entity instanceof PrimordialBoneCrawlerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(PrimordialBoneCrawlerEntity.DATA_stun, (int) (double) DeepVoidConfigConfiguration.PRIMORDIALCRAWLERSTUNDURATION.get());
			Vec3 motion = entity.getDeltaMovement().scale(0.1);
			entity.setDeltaMovement(motion);
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, (entity.getX()), (entity.getY()), (entity.getZ()), 0, Level.ExplosionInteraction.MOB);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:primordial_crawler_impact")), SoundSource.HOSTILE, 2, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:primordial_crawler_impact")), SoundSource.HOSTILE, 2, 1, false);
				}
			}
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(9 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity) && entityiterator instanceof LivingEntity) {
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:boss_attack"))), entity),
								(float) (double) DeepVoidConfigConfiguration.PRIMORDIALCRAWLERAIRSLAM.get());
						entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x()), 0.4, (entityiterator.getDeltaMovement().z())));
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 0));
					}
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.TREMBLE.get(), 20, 0, false, false));
					}
				}
			}
			for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 6, 12); index0++) {
				world.levelEvent(2001, BlockPos.containing(entity.getX() + Mth.nextInt(RandomSource.create(), -4, 4) + 0.5, entity.getY() + Mth.nextInt(RandomSource.create(), -1, 1), entity.getZ() + Mth.nextInt(RandomSource.create(), -4, 4) + 0.5),
						Block.getId(TheDeepVoidModBlocks.BLOCK_OF_GOO.get().defaultBlockState()));
			}
			for (int index1 = 0; index1 < 5; index1++) {
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
							AbstractArrow entityToSpawn = new GooBlockEntity(TheDeepVoidModEntities.GOO_BLOCK.get(), level);
							entityToSpawn.setOwner(shooter);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback(knockback);
							entityToSpawn.setSilent(true);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, entity, 6, 4);
					_entityToSpawn.setPos(x, (y + 3), z);
					_entityToSpawn.shoot((Mth.nextDouble(RandomSource.create(), -0.6, 0.6)), (Mth.nextDouble(RandomSource.create(), 0.5, 1)), (Mth.nextDouble(RandomSource.create(), -0.6, 0.6)), 1, 8);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
		}
	}
}
