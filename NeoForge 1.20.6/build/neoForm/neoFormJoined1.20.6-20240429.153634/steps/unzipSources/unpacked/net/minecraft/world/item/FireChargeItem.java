package net.minecraft.world.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

public class FireChargeItem extends Item implements ProjectileItem {
    public FireChargeItem(Item.Properties p_41202_) {
        super(p_41202_);
    }

    @Override
    public InteractionResult useOn(UseOnContext p_41204_) {
        Level level = p_41204_.getLevel();
        BlockPos blockpos = p_41204_.getClickedPos();
        BlockState blockstate = level.getBlockState(blockpos);
        boolean flag = false;
        if (!CampfireBlock.canLight(blockstate) && !CandleBlock.canLight(blockstate) && !CandleCakeBlock.canLight(blockstate)) {
            blockpos = blockpos.relative(p_41204_.getClickedFace());
            if (BaseFireBlock.canBePlacedAt(level, blockpos, p_41204_.getHorizontalDirection())) {
                this.playSound(level, blockpos);
                level.setBlockAndUpdate(blockpos, BaseFireBlock.getState(level, blockpos));
                level.gameEvent(p_41204_.getPlayer(), GameEvent.BLOCK_PLACE, blockpos);
                flag = true;
            }
        } else {
            this.playSound(level, blockpos);
            level.setBlockAndUpdate(blockpos, blockstate.setValue(BlockStateProperties.LIT, Boolean.valueOf(true)));
            level.gameEvent(p_41204_.getPlayer(), GameEvent.BLOCK_CHANGE, blockpos);
            flag = true;
        }

        if (flag) {
            p_41204_.getItemInHand().shrink(1);
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return InteractionResult.FAIL;
        }
    }

    private void playSound(Level p_41206_, BlockPos p_41207_) {
        RandomSource randomsource = p_41206_.getRandom();
        p_41206_.playSound(
            null, p_41207_, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 1.0F, (randomsource.nextFloat() - randomsource.nextFloat()) * 0.2F + 1.0F
        );
    }

    @Override
    public Projectile asProjectile(Level p_338826_, Position p_338780_, ItemStack p_338320_, Direction p_338841_) {
        RandomSource randomsource = p_338826_.getRandom();
        double d0 = randomsource.triangle((double)p_338841_.getStepX(), 0.11485000000000001);
        double d1 = randomsource.triangle((double)p_338841_.getStepY(), 0.11485000000000001);
        double d2 = randomsource.triangle((double)p_338841_.getStepZ(), 0.11485000000000001);
        SmallFireball smallfireball = new SmallFireball(p_338826_, p_338780_.x(), p_338780_.y(), p_338780_.z(), d0, d1, d2);
        smallfireball.setItem(p_338320_);
        return smallfireball;
    }

    @Override
    public void shoot(Projectile p_338389_, double p_338344_, double p_338646_, double p_338223_, float p_338688_, float p_338812_) {
    }

    @Override
    public ProjectileItem.DispenseConfig createDispenseConfig() {
        return ProjectileItem.DispenseConfig.builder()
            .positionFunction((p_338834_, p_338717_) -> DispenserBlock.getDispensePosition(p_338834_, 1.0, Vec3.ZERO))
            .uncertainty(6.6666665F)
            .power(1.0F)
            .overrideDispenseEvent(1018)
            .build();
    }
}
