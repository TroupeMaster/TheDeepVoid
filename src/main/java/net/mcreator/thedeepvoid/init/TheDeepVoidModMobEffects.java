
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedeepvoid.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.thedeepvoid.potion.VoidriumMarkMobEffect;
import net.mcreator.thedeepvoid.potion.VoidBlessingMobEffect;
import net.mcreator.thedeepvoid.potion.TrembleMobEffect;
import net.mcreator.thedeepvoid.potion.TerrifiedMobEffect;
import net.mcreator.thedeepvoid.potion.StareMobEffect;
import net.mcreator.thedeepvoid.potion.SinsAndSinnersMusicMobEffect;
import net.mcreator.thedeepvoid.potion.RottenHeartMobEffect;
import net.mcreator.thedeepvoid.potion.RotMobEffect;
import net.mcreator.thedeepvoid.potion.RootBlindMobEffect;
import net.mcreator.thedeepvoid.potion.ParanoiaMobEffect;
import net.mcreator.thedeepvoid.potion.PainfulMobEffect;
import net.mcreator.thedeepvoid.potion.PainKillerMobEffect;
import net.mcreator.thedeepvoid.potion.MotherlyCallMobEffect;
import net.mcreator.thedeepvoid.potion.MadnessMobEffect;
import net.mcreator.thedeepvoid.potion.LurkerHeadNearMobEffect;
import net.mcreator.thedeepvoid.potion.LookingMobEffect;
import net.mcreator.thedeepvoid.potion.InvisibleHandsMobEffect;
import net.mcreator.thedeepvoid.potion.HallucinateMobEffect;
import net.mcreator.thedeepvoid.potion.GoldenBloodMobEffect;
import net.mcreator.thedeepvoid.potion.FixationMobEffect;
import net.mcreator.thedeepvoid.potion.DistractedMobEffect;
import net.mcreator.thedeepvoid.potion.DecompositionMobEffect;
import net.mcreator.thedeepvoid.potion.DeadInsideMobEffect;
import net.mcreator.thedeepvoid.potion.ComboMobEffect;
import net.mcreator.thedeepvoid.potion.CallOfTheVoidMobEffect;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class TheDeepVoidModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, TheDeepVoidMod.MODID);
	public static final RegistryObject<MobEffect> DECOMPOSITION = REGISTRY.register("decomposition", () -> new DecompositionMobEffect());
	public static final RegistryObject<MobEffect> INVISIBLE_HANDS = REGISTRY.register("invisible_hands", () -> new InvisibleHandsMobEffect());
	public static final RegistryObject<MobEffect> DEAD_INSIDE = REGISTRY.register("dead_inside", () -> new DeadInsideMobEffect());
	public static final RegistryObject<MobEffect> CALL_OF_THE_VOID = REGISTRY.register("call_of_the_void", () -> new CallOfTheVoidMobEffect());
	public static final RegistryObject<MobEffect> ROTTEN_HEART = REGISTRY.register("rotten_heart", () -> new RottenHeartMobEffect());
	public static final RegistryObject<MobEffect> HALLUCINATE = REGISTRY.register("hallucinate", () -> new HallucinateMobEffect());
	public static final RegistryObject<MobEffect> COMBO = REGISTRY.register("combo", () -> new ComboMobEffect());
	public static final RegistryObject<MobEffect> MADNESS = REGISTRY.register("madness", () -> new MadnessMobEffect());
	public static final RegistryObject<MobEffect> FIXATION = REGISTRY.register("fixation", () -> new FixationMobEffect());
	public static final RegistryObject<MobEffect> VOID_BLESSING = REGISTRY.register("void_blessing", () -> new VoidBlessingMobEffect());
	public static final RegistryObject<MobEffect> ROT = REGISTRY.register("rot", () -> new RotMobEffect());
	public static final RegistryObject<MobEffect> PAIN_KILLER = REGISTRY.register("pain_killer", () -> new PainKillerMobEffect());
	public static final RegistryObject<MobEffect> STARE = REGISTRY.register("stare", () -> new StareMobEffect());
	public static final RegistryObject<MobEffect> TREMBLE = REGISTRY.register("tremble", () -> new TrembleMobEffect());
	public static final RegistryObject<MobEffect> PARANOIA = REGISTRY.register("paranoia", () -> new ParanoiaMobEffect());
	public static final RegistryObject<MobEffect> GOLDEN_BLOOD = REGISTRY.register("golden_blood", () -> new GoldenBloodMobEffect());
	public static final RegistryObject<MobEffect> TERRIFIED = REGISTRY.register("terrified", () -> new TerrifiedMobEffect());
	public static final RegistryObject<MobEffect> LOOKING = REGISTRY.register("looking", () -> new LookingMobEffect());
	public static final RegistryObject<MobEffect> PAINFUL = REGISTRY.register("painful", () -> new PainfulMobEffect());
	public static final RegistryObject<MobEffect> ROOT_BLIND = REGISTRY.register("root_blind", () -> new RootBlindMobEffect());
	public static final RegistryObject<MobEffect> LURKER_HEAD_NEAR = REGISTRY.register("lurker_head_near", () -> new LurkerHeadNearMobEffect());
	public static final RegistryObject<MobEffect> VOIDRIUM_MARK = REGISTRY.register("voidrium_mark", () -> new VoidriumMarkMobEffect());
	public static final RegistryObject<MobEffect> MOTHERLY_CALL = REGISTRY.register("motherly_call", () -> new MotherlyCallMobEffect());
	public static final RegistryObject<MobEffect> SINS_AND_SINNERS_MUSIC = REGISTRY.register("sins_and_sinners_music", () -> new SinsAndSinnersMusicMobEffect());
	public static final RegistryObject<MobEffect> DISTRACTED = REGISTRY.register("distracted", () -> new DistractedMobEffect());
}
