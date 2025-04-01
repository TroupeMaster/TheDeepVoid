
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedeepvoid.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.entity.decoration.PaintingVariant;

import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class TheDeepVoidModPaintings {
	public static final DeferredRegister<PaintingVariant> REGISTRY = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, TheDeepVoidMod.MODID);
	public static final RegistryObject<PaintingVariant> DECEITFUL = REGISTRY.register("deceitful", () -> new PaintingVariant(32, 32));
	public static final RegistryObject<PaintingVariant> OMINOUS = REGISTRY.register("ominous", () -> new PaintingVariant(16, 16));
	public static final RegistryObject<PaintingVariant> NECROSIS = REGISTRY.register("necrosis", () -> new PaintingVariant(16, 32));
	public static final RegistryObject<PaintingVariant> SCOPOPHOBIA = REGISTRY.register("scopophobia", () -> new PaintingVariant(32, 16));
	public static final RegistryObject<PaintingVariant> SANCTUARY = REGISTRY.register("sanctuary", () -> new PaintingVariant(48, 48));
	public static final RegistryObject<PaintingVariant> UNEASY = REGISTRY.register("uneasy", () -> new PaintingVariant(32, 32));
	public static final RegistryObject<PaintingVariant> REGRETS = REGISTRY.register("regrets", () -> new PaintingVariant(16, 16));
	public static final RegistryObject<PaintingVariant> GRUESOME = REGISTRY.register("gruesome", () -> new PaintingVariant(48, 48));
	public static final RegistryObject<PaintingVariant> I_AM_YOU = REGISTRY.register("i_am_you", () -> new PaintingVariant(32, 32));
	public static final RegistryObject<PaintingVariant> THREATENING = REGISTRY.register("threatening", () -> new PaintingVariant(32, 32));
	public static final RegistryObject<PaintingVariant> THE_DEEP_VOID_MOD = REGISTRY.register("the_deep_void_mod", () -> new PaintingVariant(400, 400));
}
