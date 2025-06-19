package net.minecraft.data.tags;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;

public class UpdateOneTwentyOneDamageTypes {
    public static void bootstrap(BootstrapContext<DamageType> p_321858_) {
        p_321858_.register(DamageTypes.WIND_CHARGE, new DamageType("mob", 0.1F));
    }
}
