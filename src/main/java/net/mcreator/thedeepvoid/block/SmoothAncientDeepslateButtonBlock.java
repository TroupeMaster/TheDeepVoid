
package net.mcreator.thedeepvoid.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.ButtonBlock;

public class SmoothAncientDeepslateButtonBlock extends ButtonBlock {
	public SmoothAncientDeepslateButtonBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.DEEPSLATE_TILES).strength(4.5f, 7.5f).requiresCorrectToolForDrops().dynamicShape(), BlockSetType.STONE, 20, false);
	}
}
