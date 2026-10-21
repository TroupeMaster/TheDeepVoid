
package net.sombrius.thedeepvoid.block;

import net.sombrius.thedeepvoid.procedures.UmbriumOreAdditionalHarvestConditionProcedure;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;

public class BlockOfUmbriumBlock extends Block {
	public BlockOfUmbriumBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.NETHERITE_BLOCK).strength(25f, 6f).requiresCorrectToolForDrops().pushReaction(PushReaction.BLOCK));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
		return super.canHarvestBlock(state, world, pos, player) && UmbriumOreAdditionalHarvestConditionProcedure.execute(player);
	}
}
