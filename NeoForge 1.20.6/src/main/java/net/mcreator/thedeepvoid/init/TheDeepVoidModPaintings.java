
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedeepvoid.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.core.registries.Registries;

import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class TheDeepVoidModPaintings {
	public static final DeferredRegister<PaintingVariant> REGISTRY = DeferredRegister.create(Registries.PAINTING_VARIANT, TheDeepVoidMod.MODID);
	public static final DeferredHolder<PaintingVariant, PaintingVariant> DECEITFUL = REGISTRY.register("deceitful", () -> new PaintingVariant(32, 32));
	public static final DeferredHolder<PaintingVariant, PaintingVariant> OMINOUS = REGISTRY.register("ominous", () -> new PaintingVariant(16, 16));
	public static final DeferredHolder<PaintingVariant, PaintingVariant> NECROSIS = REGISTRY.register("necrosis", () -> new PaintingVariant(16, 32));
	public static final DeferredHolder<PaintingVariant, PaintingVariant> SCOPOPHOBIA = REGISTRY.register("scopophobia", () -> new PaintingVariant(32, 16));
	public static final DeferredHolder<PaintingVariant, PaintingVariant> SANCTUARY = REGISTRY.register("sanctuary", () -> new PaintingVariant(48, 48));
	public static final DeferredHolder<PaintingVariant, PaintingVariant> UNEASY = REGISTRY.register("uneasy", () -> new PaintingVariant(32, 32));
	public static final DeferredHolder<PaintingVariant, PaintingVariant> REGRETS = REGISTRY.register("regrets", () -> new PaintingVariant(16, 16));
	public static final DeferredHolder<PaintingVariant, PaintingVariant> GRUESOME = REGISTRY.register("gruesome", () -> new PaintingVariant(48, 48));
	public static final DeferredHolder<PaintingVariant, PaintingVariant> I_AM_YOU = REGISTRY.register("i_am_you", () -> new PaintingVariant(32, 32));
	public static final DeferredHolder<PaintingVariant, PaintingVariant> THREATENING = REGISTRY.register("threatening", () -> new PaintingVariant(32, 32));
	public static final DeferredHolder<PaintingVariant, PaintingVariant> THE_DEEP_VOID_MOD = REGISTRY.register("the_deep_void_mod", () -> new PaintingVariant(400, 400));
	public static final DeferredHolder<PaintingVariant, PaintingVariant> CHAINED_UP = REGISTRY.register("chained_up", () -> new PaintingVariant(48, 32));
}
