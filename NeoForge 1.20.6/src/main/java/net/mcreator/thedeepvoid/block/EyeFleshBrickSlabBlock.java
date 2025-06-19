
package net.mcreator.thedeepvoid.block;

import net.neoforged.neoforge.common.util.DeferredSoundType;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

public class EyeFleshBrickSlabBlock extends SlabBlock {
	public EyeFleshBrickSlabBlock() {
		super(BlockBehaviour.Properties.of()
				.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.slime_block.break")), () -> BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:flesh_block_step")),
						() -> BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:flesh_block_place")), () -> BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.slime_block.hit")),
						() -> BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.wet_grass.fall"))))
				.strength(1f, 4f).friction(0.7f));
	}
}
