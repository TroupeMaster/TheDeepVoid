package net.minecraft.data.loot.packs;

import java.util.function.BiConsumer;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;

public class VanillaEquipmentLoot implements LootTableSubProvider {
    @Override
    public void generate(HolderLookup.Provider p_338887_, BiConsumer<ResourceKey<LootTable>, LootTable.Builder> p_338322_) {
        p_338322_.accept(BuiltInLootTables.EQUIPMENT_TRIAL_CHAMBER, LootTable.lootTable());
        p_338322_.accept(BuiltInLootTables.EQUIPMENT_TRIAL_CHAMBER_MELEE, LootTable.lootTable());
        p_338322_.accept(BuiltInLootTables.EQUIPMENT_TRIAL_CHAMBER_RANGED, LootTable.lootTable());
    }
}
