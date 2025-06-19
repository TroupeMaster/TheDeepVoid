package net.minecraft.gametest.framework;

import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.AABB;

public class StructureGridSpawner implements GameTestRunner.StructureSpawner {
    private static final int SPACE_BETWEEN_COLUMNS = 5;
    private static final int SPACE_BETWEEN_ROWS = 6;
    private final int testsPerRow;
    private int currentRowCount;
    private AABB rowBounds;
    private final BlockPos.MutableBlockPos nextTestNorthWestCorner;
    private final BlockPos firstTestNorthWestCorner;

    public StructureGridSpawner(BlockPos p_320479_, int p_320201_) {
        this.testsPerRow = p_320201_;
        this.nextTestNorthWestCorner = p_320479_.mutable();
        this.rowBounds = new AABB(this.nextTestNorthWestCorner);
        this.firstTestNorthWestCorner = p_320479_;
    }

    @Override
    public Optional<GameTestInfo> spawnStructure(GameTestInfo p_320875_) {
        BlockPos blockpos = new BlockPos(this.nextTestNorthWestCorner);
        p_320875_.setNorthWestCorner(blockpos);
        p_320875_.prepareTestStructure();
        AABB aabb = StructureUtils.getStructureBounds(p_320875_.getStructureBlockEntity());
        this.rowBounds = this.rowBounds.minmax(aabb);
        this.nextTestNorthWestCorner.move((int)aabb.getXsize() + 5, 0, 0);
        if (++this.currentRowCount >= this.testsPerRow) {
            this.currentRowCount = 0;
            this.nextTestNorthWestCorner.move(0, 0, (int)this.rowBounds.getZsize() + 6);
            this.nextTestNorthWestCorner.setX(this.firstTestNorthWestCorner.getX());
            this.rowBounds = new AABB(this.nextTestNorthWestCorner);
        }

        return Optional.of(p_320875_);
    }
}
