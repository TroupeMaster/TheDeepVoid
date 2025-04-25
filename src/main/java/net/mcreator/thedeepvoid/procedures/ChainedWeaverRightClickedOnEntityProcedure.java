package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class ChainedWeaverRightClickedOnEntityProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		entity.getPersistentData().putDouble("deep_void:discuss", (entity.getPersistentData().getDouble("deep_void:discuss") + 1));
		if (entity.getPersistentData().getDouble("deep_void:discuss") == 1) {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7c\u00A7l\u00A7kGOD \u00A7c\u00A7lAre you a new desciple ? \u00A7c\u00A7l\u00A7kGOD"), false);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
			entity.getPersistentData().putBoolean("deep_void:talking", true);
		}
		if (entity.getPersistentData().getDouble("deep_void:discuss") == 2) {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7c\u00A7l\u00A7kGOD \u00A7c\u00A7lYour soul is tainted, it smells of rot and decay.. \u00A7c\u00A7l\u00A7kGOD"), false);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
		}
		if (entity.getPersistentData().getDouble("deep_void:discuss") == 3) {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7c\u00A7l\u00A7kGOD \u00A7c\u00A7lSo interesting, so beautiful, so tasteful.. \u00A7c\u00A7l\u00A7kGOD"), false);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
		}
		if (entity.getPersistentData().getDouble("deep_void:discuss") == 4) {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(
						"\u00A7c\u00A7l\u00A7kGOD \u00A7c\u00A7lAre you here for my craft ? Perhaps you are here for answers, for your path to be shown ? Are your motivations guided by a twisted interest, maybe you are in search of knowledge ? \u00A7c\u00A7l\u00A7kGOD"),
						false);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
		}
		if (entity.getPersistentData().getDouble("deep_void:discuss") == 5) {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7c\u00A7l\u00A7kGOD \u00A7c\u00A7lGreed is blinding your actions. You want riches, you want glory. \u00A7c\u00A7l\u00A7kGOD"), false);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
		}
		if (entity.getPersistentData().getDouble("deep_void:discuss") == 6) {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7c\u00A7l\u00A7kGOD \u00A7c\u00A7lSlothful is what you are, you want to be powerful so you do not have to make any effort. \u00A7c\u00A7l\u00A7kGOD"), false);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
		}
		if (entity.getPersistentData().getDouble("deep_void:discuss") == 7) {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7c\u00A7l\u00A7kGOD \u00A7c\u00A7lYou envy others. I can see the look in your eyes, you want my power for yourself, do you ? \u00A7c\u00A7l\u00A7kGOD"), false);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
		}
		if (entity.getPersistentData().getDouble("deep_void:discuss") == 8) {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(
						Component.literal("\u00A7c\u00A7l\u00A7kGOD \u00A7c\u00A7lYour wrath is immense. You look like someone who has seen death countless times. Each of your lives are lead by revenge. \u00A7c\u00A7l\u00A7kGOD"), false);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
		}
		if (entity.getPersistentData().getDouble("deep_void:discuss") == 9) {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7c\u00A7l\u00A7kGOD \u00A7c\u00A7lPride describes you well. You find yourself far more superior to others. \u00A7c\u00A7l\u00A7kGOD"), false);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
		}
		if (entity.getPersistentData().getDouble("deep_void:discuss") == 10) {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7c\u00A7l\u00A7kGOD \u00A7c\u00A7lGluttony goes well with one such as you. You fancy prestigious meals and choose delight over simple bread. \u00A7c\u00A7l\u00A7kGOD"), false);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
		}
		if (entity.getPersistentData().getDouble("deep_void:discuss") == 11) {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7c\u00A7l\u00A7kGOD \u00A7c\u00A7lAll living beings are lustful, keeping the species alive is one of the main goals of all creatures. \u00A7c\u00A7l\u00A7kGOD"), false);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
		}
		if (entity.getPersistentData().getDouble("deep_void:discuss") == 12) {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(
						"\u00A7c\u00A7l\u00A7kGOD \u00A7c\u00A7lA Sinner is what you are. You go against the ideals of humanity and indulge in activities considered immoral. Do not despair, my friend. We accept all, the Void accepts all. \u00A7c\u00A7l\u00A7kGOD"),
						false);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
		}
		if (entity.getPersistentData().getDouble("deep_void:discuss") == 13) {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(
						Component.literal("\u00A7c\u00A7l\u00A7kGOD \u00A7c\u00A7lGod is here, guiding his lost lambs to the right path and I shall give his teachings, provide Vessels so that lambs such as you can ascend. \u00A7c\u00A7l\u00A7kGOD"),
						false);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
		}
		if (entity.getPersistentData().getDouble("deep_void:discuss") == 14) {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7c\u00A7l\u00A7kGOD \u00A7c\u00A7lThis is my duty, my life, my craft. \u00A7c\u00A7l\u00A7kGOD"), false);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
		}
		if (entity.getPersistentData().getDouble("deep_void:discuss") == 15) {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7c\u00A7l\u00A7kGOD \u00A7c\u00A7lIf you break the seal binding me to this place, I shall tell you more. I will give you the power you desire.. \u00A7c\u00A7l\u00A7kGOD"), false);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, 1, (float) 0.9);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, 1, (float) 0.9, false);
				}
			}
		}
		if (entity.getPersistentData().getDouble("deep_void:discuss") >= 15) {
			entity.getPersistentData().putBoolean("deep_void:talking", false);
		}
	}
}
