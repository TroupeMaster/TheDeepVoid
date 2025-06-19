package net.minecraft.data.tags;

import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.StructureTags;
import net.minecraft.world.level.levelgen.structure.BuiltinStructures;
import net.minecraft.world.level.levelgen.structure.Structure;

public class UpdateOneTwentyOneStructureTagsProvider extends TagsProvider<Structure> {
    public UpdateOneTwentyOneStructureTagsProvider(
        PackOutput p_336023_, CompletableFuture<HolderLookup.Provider> p_335689_, CompletableFuture<TagsProvider.TagLookup<Structure>> p_336105_
    ) {
        super(p_336023_, Registries.STRUCTURE, p_335689_, p_336105_);
    }

    @Override
    protected void addTags(HolderLookup.Provider p_335750_) {
        this.tag(StructureTags.ON_TRIAL_CHAMBERS_MAPS).add(BuiltinStructures.TRIAL_CHAMBERS);
    }
}
