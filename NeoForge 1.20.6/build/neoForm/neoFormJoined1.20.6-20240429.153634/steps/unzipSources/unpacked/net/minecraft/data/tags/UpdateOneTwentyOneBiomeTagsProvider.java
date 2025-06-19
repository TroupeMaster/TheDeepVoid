package net.minecraft.data.tags;

import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;

public class UpdateOneTwentyOneBiomeTagsProvider extends TagsProvider<Biome> {
    public UpdateOneTwentyOneBiomeTagsProvider(
        PackOutput p_312141_, CompletableFuture<HolderLookup.Provider> p_312432_, CompletableFuture<TagsProvider.TagLookup<Biome>> p_311761_
    ) {
        super(p_312141_, Registries.BIOME, p_312432_, p_311761_);
    }

    @Override
    protected void addTags(HolderLookup.Provider p_311777_) {
        this.tag(BiomeTags.HAS_TRIAL_CHAMBERS).addTag(BiomeTags.IS_OVERWORLD);
    }
}
