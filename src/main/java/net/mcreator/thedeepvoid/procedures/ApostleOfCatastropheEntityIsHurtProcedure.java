package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.entity.SawThrowerEntity;
import net.mcreator.thedeepvoid.entity.HiveWatcherEntity;
import net.mcreator.thedeepvoid.entity.ApostleOfCatastropheEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ApostleOfCatastropheEntityIsHurtProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getDirectEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, immediatesourceentity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		double slowness = 0;
		double resistance = 0;
		if (entity instanceof ApostleOfCatastropheEntity && entity.getPersistentData().getBoolean("deep_void:spinning") == true && !(immediatesourceentity == sourceentity) && !(sourceentity == null) && !(sourceentity == entity)) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
			immediatesourceentity.setDeltaMovement(new Vec3(((immediatesourceentity.getX() - sourceentity.getX()) * 2), ((immediatesourceentity.getY() - (sourceentity.getY() + 2)) * 2), ((immediatesourceentity.getZ() - sourceentity.getZ()) * 2)));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.HOSTILE, 2, (float) 1.5);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.HOSTILE, 2, (float) 1.5, false);
				}
			}
		}
		if (entity instanceof SawThrowerEntity && (entity instanceof SawThrowerEntity _datEntL14 && _datEntL14.getEntityData().get(SawThrowerEntity.DATA_spinning)) == true && !(immediatesourceentity == sourceentity) && !(sourceentity == null)
				&& !(sourceentity == entity)) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
			immediatesourceentity.setDeltaMovement(new Vec3(((immediatesourceentity.getX() - sourceentity.getX()) * 2), ((immediatesourceentity.getY() - (sourceentity.getY() + 2)) * 2), ((immediatesourceentity.getZ() - sourceentity.getZ()) * 2)));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.HOSTILE, 2, (float) 1.5);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.HOSTILE, 2, (float) 1.5, false);
				}
			}
		}
		if (entity instanceof HiveWatcherEntity && (entity instanceof HiveWatcherEntity _datEntL27 && _datEntL27.getEntityData().get(HiveWatcherEntity.DATA_spinning)) == true && !(immediatesourceentity == sourceentity) && !(sourceentity == null)
				&& !(sourceentity == entity)) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
			immediatesourceentity.setDeltaMovement(new Vec3(((immediatesourceentity.getX() - sourceentity.getX()) * 2), ((immediatesourceentity.getY() - (sourceentity.getY() + 2)) * 2), ((immediatesourceentity.getZ() - sourceentity.getZ()) * 2)));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.HOSTILE, 4, (float) 1.5);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.HOSTILE, 4, (float) 1.5, false);
				}
			}
		}
	}
}
