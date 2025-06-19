package net.mcreator.thedeepvoid.procedures;

import net.neoforged.neoforge.event.entity.living.LivingAttackEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.entity.ChainedWeaverEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ChainedWeaverEntityIsHurtProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof ChainedWeaverEntity) {
			if (sourceentity instanceof Player) {
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
				if (entity.getPersistentData().getBoolean("deep_void:free") == false) {
					entity.getPersistentData().putDouble("deep_void:chainBreak", (entity.getPersistentData().getDouble("deep_void:chainBreak") + 1));
					world.levelEvent(2001, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), Block.getId(Blocks.CHAIN.defaultBlockState()));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.chain.break")), SoundSource.HOSTILE, 2, (float) 0.8);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.chain.break")), SoundSource.HOSTILE, 2, (float) 0.8, false);
						}
					}
					if (entity.getPersistentData().getDouble("deep_void:chainBreak") >= 9) {
						entity.getPersistentData().putBoolean("deep_void:free", true);
					}
					if (entity.getPersistentData().getDouble("deep_void:chainBreak") == 2) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7c\u00A7l\u00A7kGOD \u00A7c\u00A7lTo weave, to provide vessels.. \u00A7c\u00A7l\u00A7kGOD"), false);
					}
					if (entity.getPersistentData().getDouble("deep_void:chainBreak") == 4) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7c\u00A7l\u00A7kGOD \u00A7c\u00A7lIsn't it a wonderful thing, god.. \u00A7c\u00A7l\u00A7kGOD"), false);
					}
					if (entity.getPersistentData().getDouble("deep_void:chainBreak") == 6) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7c\u00A7l\u00A7kGOD \u00A7c\u00A7lTo ascend, to make one with the Void.. \u00A7c\u00A7l\u00A7kGOD"), false);
					}
					if (entity.getPersistentData().getDouble("deep_void:chainBreak") == 8) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7c\u00A7l\u00A7kGOD \u00A7c\u00A7lRedemption awaits all.. \u00A7c\u00A7l\u00A7kGOD"), false);
					}
					if (entity.getPersistentData().getDouble("deep_void:chainBreak") == 9) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7c\u00A7l\u00A7kGOD \u00A7c\u00A7lIt's time. \u00A7c\u00A7l\u00A7kGOD"), false);
					}
				}
			}
		}
	}
}
