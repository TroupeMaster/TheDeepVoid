
package net.mcreator.thedeepvoid.block;

import net.neoforged.neoforge.common.util.DeferredSoundType;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

public class RottenFleshStairsBlock extends StairBlock {
	public RottenFleshStairsBlock() {
		super(Blocks.AIR.defaultBlockState(),
				BlockBehaviour.Properties.of()
						.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.slime_block.break")),
								() -> BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:flesh_block_step")), () -> BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:flesh_block_step")),
								() -> BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.slime_block.hit")), () -> BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.slime_block.fall"))))
						.strength(0.4f, 1f));
	}

	@Override
	public float getExplosionResistance() {
		return 1f;
	}
}
