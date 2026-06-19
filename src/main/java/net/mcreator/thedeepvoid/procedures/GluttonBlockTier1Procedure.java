package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class GluttonBlockTier1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, String command) {
		if (entity == null || command == null)
			return;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fox.bite")), SoundSource.BLOCKS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fox.bite")), SoundSource.BLOCKS, 1, 1, false);
			}
		}
		if (!(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
				}
				return false;
			}
		}.checkGamemode(entity))) {
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).setCount((int) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1));
		}
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 10);
		{
			int _value = 1;
			BlockPos _pos = BlockPos.containing(x, y, z);
			BlockState _bs = world.getBlockState(_pos);
			if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
				world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
		}
		TheDeepVoidMod.queueServerWork(5, () -> {
			{
				int _value = 0;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		});
		TheDeepVoidMod.queueServerWork(20, () -> {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.eat")), SoundSource.BLOCKS, (float) 0.5, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.eat")), SoundSource.BLOCKS, (float) 0.5, 1, false);
				}
			}
		});
		TheDeepVoidMod.queueServerWork(40, () -> {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.eat")), SoundSource.BLOCKS, (float) 0.5, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.eat")), SoundSource.BLOCKS, (float) 0.5, 1, false);
				}
			}
		});
		TheDeepVoidMod.queueServerWork(80, () -> {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.GLUTTON_BLOCK.get()) {
				if ((command).equals("bossLoot")) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.burp")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.burp")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
					for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 2, 6); index0++) {
						if (world instanceof ServerLevel _level)
							_level.addFreshEntity(new ExperienceOrb(_level, (x + 0.5), (y + 1), (z + 0.5), Mth.nextInt(RandomSource.create(), 4, 8)));
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.CRIT, (x + 0.5), (y + 1), (z + 0.5), 10, 1, 1, 1, 0.1);
				} else {
					if (new Object() {
						public int getContainerSize(LevelAccessor world, BlockPos pos) {
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null) {
								if (_ent instanceof BaseContainerBlockEntity _block) {
									return _block.getContainerSize();
								}
							}
							return 0;
						}

						public int getAmount(LevelAccessor world, BlockPos pos) {
							Block block = world.getBlockState(pos).getBlock();
							if (block == Blocks.CHEST || block == Blocks.TRAPPED_CHEST) {
								boolean isSingle = block.getStateDefinition().getProperty("type") instanceof EnumProperty _getep5 && world.getBlockState(pos).getValue(_getep5).toString().equals("SINGLE");
								if (!isSingle) {
									return getContainerSize(world, pos) * 2;
								}
							}
							return getContainerSize(world, pos);
						}
					}.getAmount(world, new BlockPos((int) x, (int) (y + 1), (int) z)) > 0) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.burp")), SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.burp")), SoundSource.BLOCKS, 1, 1, false);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y + 1), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), command);
						GluttonBlockChestSlotCheckProcedure.execute(world, x, y, z);
					} else {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.burp")), SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.burp")), SoundSource.BLOCKS, 1, 1, false);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y + 1), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), command);
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.CRIT, (x + 0.5), (y + 1), (z + 0.5), 10, 1, 1, 1, 0.1);
					}
				}
			}
		});
	}
}
