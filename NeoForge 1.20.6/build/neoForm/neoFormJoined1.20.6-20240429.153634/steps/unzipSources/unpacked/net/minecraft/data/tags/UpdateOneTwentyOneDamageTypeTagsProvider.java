package net.minecraft.data.tags;

import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;

public class UpdateOneTwentyOneDamageTypeTagsProvider extends TagsProvider<DamageType> {
    public UpdateOneTwentyOneDamageTypeTagsProvider(PackOutput p_312525_, CompletableFuture<HolderLookup.Provider> p_311905_) {
        super(p_312525_, Registries.DAMAGE_TYPE, p_311905_);
    }

    @Override
    protected void addTags(HolderLookup.Provider p_311770_) {
        this.tag(DamageTypeTags.BREEZE_IMMUNE_TO).add(DamageTypes.ARROW, DamageTypes.TRIDENT);
        this.tag(DamageTypeTags.IS_PROJECTILE).add(DamageTypes.WIND_CHARGE);
        this.tag(DamageTypeTags.ALWAYS_KILLS_ARMOR_STANDS).add(DamageTypes.WIND_CHARGE);
    }
}
