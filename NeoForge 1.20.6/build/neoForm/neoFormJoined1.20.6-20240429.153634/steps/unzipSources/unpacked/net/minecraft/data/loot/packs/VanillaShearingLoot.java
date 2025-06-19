package net.minecraft.data.loot.packs;

import java.util.function.BiConsumer;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;

public class VanillaShearingLoot implements LootTableSubProvider {
    @Override
    public void generate(HolderLookup.Provider p_332108_, BiConsumer<ResourceKey<LootTable>, LootTable.Builder> p_332018_) {
        p_332018_.accept(BuiltInLootTables.BOGGED_SHEAR, LootTable.lootTable());
    }
}
