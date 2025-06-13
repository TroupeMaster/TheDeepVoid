
package net.mcreator.thedeepvoid.block;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.common.util.ForgeSoundType;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.procedures.FleshBlockEntityWalksOnTheBlockProcedure;

public class FleshSlabBlock extends SlabBlock {
	public FleshSlabBlock() {
		super(BlockBehaviour.Properties.of()
				.sound(new ForgeSoundType(1.0f, 1.0f, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.slime_block.break")), () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:flesh_block_step")),
						() -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:flesh_block_place")), () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.slime_block.hit")),
						() -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wet_grass.fall"))))
				.strength(1f, 4f).friction(0.7f).speedFactor(0.9f));
	}

	@Override
	public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
		super.stepOn(world, pos, blockstate, entity);
		FleshBlockEntityWalksOnTheBlockProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
	}
}
