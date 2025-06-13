
package net.mcreator.thedeepvoid.block;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.common.util.ForgeSoundType;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.resources.ResourceLocation;

public class FleshBrickWallBlock extends WallBlock {
	public FleshBrickWallBlock() {
		super(BlockBehaviour.Properties.of()
				.sound(new ForgeSoundType(1.0f, 1.0f, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.slime_block.break")), () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:flesh_block_step")),
						() -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:flesh_block_place")), () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.slime_block.hit")),
						() -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wet_grass.fall"))))
				.strength(1f, 4f).friction(0.7f).forceSolidOn());
	}
}
