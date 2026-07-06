package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.thedeepvoid.entity.PrimordialBoneCrawlerEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class PrimordialCrawlerAirSlamProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof PrimordialBoneCrawlerEntity) {
			((PrimordialBoneCrawlerEntity) entity).setAnimation("animation.primordialCrawler_fly");
		}
		TheDeepVoidMod.queueServerWork(18, () -> {
			if (entity instanceof PrimordialBoneCrawlerEntity _datEntSetL)
				_datEntSetL.getEntityData().set(PrimordialBoneCrawlerEntity.DATA_fly, true);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:primordial_crawler_flying")), SoundSource.HOSTILE, 2, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:primordial_crawler_flying")), SoundSource.HOSTILE, 2, 1, false);
				}
			}
		});
		TheDeepVoidMod.queueServerWork(54, () -> {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				entity.getPersistentData().putDouble("airX", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()));
				entity.getPersistentData().putDouble("airY", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()));
				entity.getPersistentData().putDouble("airZ", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()));
			}
		});
		TheDeepVoidMod.queueServerWork(68, () -> {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:mother_crawler_ambient")), SoundSource.HOSTILE, 2, (float) 0.4);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:mother_crawler_ambient")), SoundSource.HOSTILE, 2, (float) 0.4, false);
				}
			}
		});
		TheDeepVoidMod.queueServerWork(71, () -> {
			if (entity instanceof PrimordialBoneCrawlerEntity _datEntSetL)
				_datEntSetL.getEntityData().set(PrimordialBoneCrawlerEntity.DATA_airSlam, true);
			if (entity instanceof PrimordialBoneCrawlerEntity _datEntSetL)
				_datEntSetL.getEntityData().set(PrimordialBoneCrawlerEntity.DATA_fly, false);
			entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entity.getPersistentData().getDouble("airX")), (entity.getPersistentData().getDouble("airY")), (entity.getPersistentData().getDouble("airZ"))));
			entity.setDeltaMovement(
					new Vec3(((entity.getPersistentData().getDouble("airX") - entity.getX()) * 0.4), ((entity.getPersistentData().getDouble("airY") - entity.getY()) * 0.4), ((entity.getPersistentData().getDouble("airZ") - entity.getZ()) * 0.4)));
		});
	}
}
