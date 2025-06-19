package net.minecraft.data.advancements.packs;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;

public class UpdateOneTwentyOneAdvancementProvider {
    public static AdvancementProvider create(PackOutput p_314656_, CompletableFuture<HolderLookup.Provider> p_314534_) {
        return new AdvancementProvider(p_314656_, p_314534_, List.of(new UpdateOneTwentyOneAdventureAdvancements()));
    }
}
