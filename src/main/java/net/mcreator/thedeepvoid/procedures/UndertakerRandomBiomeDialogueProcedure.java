package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class UndertakerRandomBiomeDialogueProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		if (sourceentity == null)
			return;
		double dialogue = 0;
		double interrupt = 0;
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:mourning_graveyard"))) {
			dialogue = Mth.nextInt(RandomSource.create(), 1, 4);
			if (dialogue == 1) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.graveyard1").getString())), false);
			} else if (dialogue == 2) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.graveyard2").getString())), false);
			} else if (dialogue == 3) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.graveyard3").getString())), false);
			} else if (dialogue == 4) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.graveyard4").getString())), false);
			}
		} else if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:filled_graveyard")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:forgotten_valley"))) {
			dialogue = Mth.nextInt(RandomSource.create(), 1, 3);
			if (dialogue == 1) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.graveyard2").getString())), false);
			} else if (dialogue == 2) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.graveyard3").getString())), false);
			} else if (dialogue == 3) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.graveyard4").getString())), false);
			}
		} else if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:drifting_monoliths"))) {
			dialogue = Mth.nextInt(RandomSource.create(), 1, 4);
			if (dialogue == 1) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.driftingmonoliths1").getString())),
							false);
			} else if (dialogue == 2) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.driftingmonoliths2").getString())),
							false);
			} else if (dialogue == 3) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.driftingmonoliths3").getString())),
							false);
			} else if (dialogue == 4) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.driftingmonoliths4").getString())),
							false);
			}
		} else if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:deep_marrows"))) {
			dialogue = Mth.nextInt(RandomSource.create(), 1, 4);
			if (dialogue == 1) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.marrows1").getString())), false);
			} else if (dialogue == 2) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.marrows2").getString())), false);
			} else if (dialogue == 3) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.marrows3").getString())), false);
			} else if (dialogue == 4) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.marrows4").getString())), false);
			}
		} else if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:grim_canopy")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:watching_undergrowth"))) {
			dialogue = Mth.nextInt(RandomSource.create(), 1, 4);
			if (dialogue == 1) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.canopy1").getString())), false);
			} else if (dialogue == 2) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.canopy2").getString())), false);
			} else if (dialogue == 3) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.canopy3").getString())), false);
			} else if (dialogue == 4) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.canopy4").getString())), false);
			}
		} else if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:windswept_hollow"))) {
			dialogue = Mth.nextInt(RandomSource.create(), 1, 3);
			if (dialogue == 1) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.windswept1").getString())), false);
			} else if (dialogue == 2) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.windswept2").getString())), false);
			} else if (dialogue == 3) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.windswept3").getString())), false);
			}
		} else if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:gaol_of_heretics"))) {
			dialogue = Mth.nextInt(RandomSource.create(), 1, 3);
			if (dialogue == 1) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.gaol1").getString())), false);
			} else if (dialogue == 2) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.gaol2").getString())), false);
			} else if (dialogue == 3) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.gaol3").getString())), false);
			}
		} else {
			dialogue = Mth.nextInt(RandomSource.create(), 1, 4);
			if (dialogue == 1) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.generic1").getString())), false);
			} else if (dialogue == 2) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.generic2").getString())), false);
			} else if (dialogue == 3) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.generic3").getString())), false);
			} else if (dialogue == 4) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.generic4").getString())), false);
			}
		}
		interrupt = Mth.nextInt(RandomSource.create(), 1, 4);
		if (interrupt == 1) {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.interrupt1").getString())), false);
		} else if (interrupt == 2) {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.interrupt2").getString())), false);
		} else if (interrupt == 3) {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.interrupt3").getString())), false);
		} else if (interrupt == 4) {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.interrupt4").getString())), false);
		}
	}
}
