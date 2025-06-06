
package net.mcreator.thedeepvoid.block;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.common.util.ForgeSoundType;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class GooBrickStairsBlock extends StairBlock {
	public GooBrickStairsBlock() {
		super(() -> Blocks.AIR.defaultBlockState(),
				BlockBehaviour.Properties.of()
						.sound(new ForgeSoundType(1.0f, 1.0f, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.slime_block.break")),
								() -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:flesh_block_step")), () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:flesh_block_step")),
								() -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.slime_block.hit")), () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.slime_block.fall"))))
						.strength(0.8f, 1f));
	}

	@Override
	public float getExplosionResistance() {
		return 1f;
	}

	@Override
	public boolean isRandomlyTicking(BlockState state) {
		return false;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 4;
	}
}
