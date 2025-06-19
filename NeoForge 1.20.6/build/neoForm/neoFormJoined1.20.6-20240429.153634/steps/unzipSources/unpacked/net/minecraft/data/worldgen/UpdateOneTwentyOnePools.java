package net.minecraft.data.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

public class UpdateOneTwentyOnePools {
    public static final ResourceKey<StructureTemplatePool> EMPTY = createKey("empty");

    public static ResourceKey<StructureTemplatePool> createKey(String p_311848_) {
        return ResourceKey.create(Registries.TEMPLATE_POOL, new ResourceLocation(p_311848_));
    }

    public static void register(BootstrapContext<StructureTemplatePool> p_321681_, String p_312542_, StructureTemplatePool p_312302_) {
        Pools.register(p_321681_, p_312542_, p_312302_);
    }

    public static void bootstrap(BootstrapContext<StructureTemplatePool> p_321564_) {
        TrialChambersStructurePools.bootstrap(p_321564_);
    }
}
