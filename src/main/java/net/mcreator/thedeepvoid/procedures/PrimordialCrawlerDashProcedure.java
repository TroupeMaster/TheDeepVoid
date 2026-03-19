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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.entity.PrimordialBoneCrawlerEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class PrimordialCrawlerDashProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof PrimordialBoneCrawlerEntity) {
			((PrimordialBoneCrawlerEntity) entity).setAnimation("animation.primordialCrawler_dash");
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 99, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20, 99, false, false));
		TheDeepVoidMod.queueServerWork(5, () -> {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:mother_crawler_ambient")), SoundSource.HOSTILE, 5, (float) 0.7);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:mother_crawler_ambient")), SoundSource.HOSTILE, 5, (float) 0.7, false);
				}
			}
		});
		TheDeepVoidMod.queueServerWork(15, () -> {
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).isEmpty()) {
				if (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
					entity.getPersistentData().putDouble("dashPlayerX", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()));
					entity.getPersistentData().putDouble("dashPlayerZ", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()));
				}
			}
			entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entity.getPersistentData().getDouble("dashPlayerX")), y, (entity.getPersistentData().getDouble("dashPlayerZ"))));
		});
		TheDeepVoidMod.queueServerWork(25, () -> {
			entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entity.getPersistentData().getDouble("dashPlayerX")), y, (entity.getPersistentData().getDouble("dashPlayerZ"))));
			if (entity instanceof PrimordialBoneCrawlerEntity _datEntSetL)
				_datEntSetL.getEntityData().set(PrimordialBoneCrawlerEntity.DATA_dashing, true);
			entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 5), 0.15, (Math.cos(Math.toRadians(entity.getYRot())) * 5)));
		});
		TheDeepVoidMod.queueServerWork(45, () -> {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:primordial_crawler_impact")), SoundSource.HOSTILE, 4, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:primordial_crawler_impact")), SoundSource.HOSTILE, 4, 1, false);
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
			if (entity instanceof PrimordialBoneCrawlerEntity _datEntSetL)
				_datEntSetL.getEntityData().set(PrimordialBoneCrawlerEntity.DATA_dashing, false);
			if (Math.random() < 0.4) {
				if (entity instanceof PrimordialBoneCrawlerEntity) {
					((PrimordialBoneCrawlerEntity) entity).setAnimation("empty");
				}
				PrimordialCrawlerSpitProcedure.execute(world, entity);
			}
		});
	}
}
