package net.minecraft.data.tags;

import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BannerPatternTags;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.block.entity.BannerPatterns;

public class UpdateOneTwentyOneBannerPatternTagsProvider extends TagsProvider<BannerPattern> {
    public UpdateOneTwentyOneBannerPatternTagsProvider(
        PackOutput p_334007_, CompletableFuture<HolderLookup.Provider> p_334027_, CompletableFuture<TagsProvider.TagLookup<BannerPattern>> p_334001_
    ) {
        super(p_334007_, Registries.BANNER_PATTERN, p_334027_, p_334001_);
    }

    @Override
    protected void addTags(HolderLookup.Provider p_333976_) {
        this.tag(BannerPatternTags.PATTERN_ITEM_FLOW).add(BannerPatterns.FLOW);
        this.tag(BannerPatternTags.PATTERN_ITEM_GUSTER).add(BannerPatterns.GUSTER);
    }
}
