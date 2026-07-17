package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;
import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerRightClicksInNetherProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getFace(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Direction direction, Entity entity) {
		execute(null, world, x, y, z, direction, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Direction direction, Entity entity) {
		if (direction == null || entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.LIQUID_VOID_BUCKET.get() && (entity.level().dimension()) == Level.NETHER) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
			if (direction == Direction.UP) {
				world.setBlock(BlockPos.containing(x, y + 1, z), TheDeepVoidModBlocks.LIQUID_VOID.get().defaultBlockState(), 3);
			} else if (direction == Direction.DOWN) {
				world.setBlock(BlockPos.containing(x, y - 1, z), TheDeepVoidModBlocks.LIQUID_VOID.get().defaultBlockState(), 3);
			} else if (direction == Direction.NORTH) {
				world.setBlock(BlockPos.containing(x, y, z - 1), TheDeepVoidModBlocks.LIQUID_VOID.get().defaultBlockState(), 3);
			} else if (direction == Direction.SOUTH) {
				world.setBlock(BlockPos.containing(x, y, z + 1), TheDeepVoidModBlocks.LIQUID_VOID.get().defaultBlockState(), 3);
			} else if (direction == Direction.WEST) {
				world.setBlock(BlockPos.containing(x - 1, y, z), TheDeepVoidModBlocks.LIQUID_VOID.get().defaultBlockState(), 3);
			} else if (direction == Direction.EAST) {
				world.setBlock(BlockPos.containing(x + 1, y, z), TheDeepVoidModBlocks.LIQUID_VOID.get().defaultBlockState(), 3);
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.LIQUID_ICHOR_BUCKET.get() && (entity.level().dimension()) == Level.NETHER) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty_lava")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty_lava")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
			if (direction == Direction.UP) {
				world.setBlock(BlockPos.containing(x, y + 1, z), TheDeepVoidModBlocks.LIQUID_ICHOR.get().defaultBlockState(), 3);
			} else if (direction == Direction.DOWN) {
				world.setBlock(BlockPos.containing(x, y - 1, z), TheDeepVoidModBlocks.LIQUID_ICHOR.get().defaultBlockState(), 3);
			} else if (direction == Direction.NORTH) {
				world.setBlock(BlockPos.containing(x, y, z - 1), TheDeepVoidModBlocks.LIQUID_ICHOR.get().defaultBlockState(), 3);
			} else if (direction == Direction.SOUTH) {
				world.setBlock(BlockPos.containing(x, y, z + 1), TheDeepVoidModBlocks.LIQUID_ICHOR.get().defaultBlockState(), 3);
			} else if (direction == Direction.WEST) {
				world.setBlock(BlockPos.containing(x - 1, y, z), TheDeepVoidModBlocks.LIQUID_ICHOR.get().defaultBlockState(), 3);
			} else if (direction == Direction.EAST) {
				world.setBlock(BlockPos.containing(x + 1, y, z), TheDeepVoidModBlocks.LIQUID_ICHOR.get().defaultBlockState(), 3);
			}
		}
	}
}
