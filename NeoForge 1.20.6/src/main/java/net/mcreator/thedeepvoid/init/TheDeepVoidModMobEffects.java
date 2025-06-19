
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedeepvoid.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.thedeepvoid.procedures.SinsAndSinnersMusicEffectExpiresProcedure;
import net.mcreator.thedeepvoid.procedures.RootBlindEffectExpiresProcedure;
import net.mcreator.thedeepvoid.procedures.PitchBlackExpiresProcedure;
import net.mcreator.thedeepvoid.procedures.HexedEffectExpiresProcedure;
import net.mcreator.thedeepvoid.procedures.DarkmareExpiresProcedure;
import net.mcreator.thedeepvoid.procedures.ChainsawExpiresProcedure;
import net.mcreator.thedeepvoid.procedures.CallOfTheVoidEffectExpiresProcedure;
import net.mcreator.thedeepvoid.procedures.BloodBoilEffectExpiresProcedure;
import net.mcreator.thedeepvoid.potion.WeaverCurseMobEffect;
import net.mcreator.thedeepvoid.potion.VoidriumMarkMobEffect;
import net.mcreator.thedeepvoid.potion.VoidBlessingMobEffect;
import net.mcreator.thedeepvoid.potion.TrembleMobEffect;
import net.mcreator.thedeepvoid.potion.TerrifiedMobEffect;
import net.mcreator.thedeepvoid.potion.StareMobEffect;
import net.mcreator.thedeepvoid.potion.SinsAndSinnersMusicMobEffect;
import net.mcreator.thedeepvoid.potion.RottenHeartMobEffect;
import net.mcreator.thedeepvoid.potion.RotMobEffect;
import net.mcreator.thedeepvoid.potion.RootBlindMobEffect;
import net.mcreator.thedeepvoid.potion.PitchBlackMusicMobEffect;
import net.mcreator.thedeepvoid.potion.ParanoiaMobEffect;
import net.mcreator.thedeepvoid.potion.PainfulMobEffect;
import net.mcreator.thedeepvoid.potion.PainKillerMobEffect;
import net.mcreator.thedeepvoid.potion.MotherlyCallMobEffect;
import net.mcreator.thedeepvoid.potion.MadnessMobEffect;
import net.mcreator.thedeepvoid.potion.LurkerHeadNearMobEffect;
import net.mcreator.thedeepvoid.potion.LookingMobEffect;
import net.mcreator.thedeepvoid.potion.LacerationMobEffect;
import net.mcreator.thedeepvoid.potion.InvisibleHandsMobEffect;
import net.mcreator.thedeepvoid.potion.HexedMobEffect;
import net.mcreator.thedeepvoid.potion.HallucinateMobEffect;
import net.mcreator.thedeepvoid.potion.GoldenBloodMobEffect;
import net.mcreator.thedeepvoid.potion.FixationMobEffect;
import net.mcreator.thedeepvoid.potion.DoomMobEffect;
import net.mcreator.thedeepvoid.potion.DistractedMobEffect;
import net.mcreator.thedeepvoid.potion.DecompositionMobEffect;
import net.mcreator.thedeepvoid.potion.DeadInsideMobEffect;
import net.mcreator.thedeepvoid.potion.DarkmareMusicMobEffect;
import net.mcreator.thedeepvoid.potion.ComboMobEffect;
import net.mcreator.thedeepvoid.potion.ChainsawMusicMobEffect;
import net.mcreator.thedeepvoid.potion.CallOfTheVoidMobEffect;
import net.mcreator.thedeepvoid.potion.BloodBoilMobEffect;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

@EventBusSubscriber
public class TheDeepVoidModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, TheDeepVoidMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> DECOMPOSITION = REGISTRY.register("decomposition", () -> new DecompositionMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> INVISIBLE_HANDS = REGISTRY.register("invisible_hands", () -> new InvisibleHandsMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> DEAD_INSIDE = REGISTRY.register("dead_inside", () -> new DeadInsideMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> CALL_OF_THE_VOID = REGISTRY.register("call_of_the_void", () -> new CallOfTheVoidMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> ROTTEN_HEART = REGISTRY.register("rotten_heart", () -> new RottenHeartMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> HALLUCINATE = REGISTRY.register("hallucinate", () -> new HallucinateMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> COMBO = REGISTRY.register("combo", () -> new ComboMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> MADNESS = REGISTRY.register("madness", () -> new MadnessMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> FIXATION = REGISTRY.register("fixation", () -> new FixationMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> VOID_BLESSING = REGISTRY.register("void_blessing", () -> new VoidBlessingMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> ROT = REGISTRY.register("rot", () -> new RotMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> PAIN_KILLER = REGISTRY.register("pain_killer", () -> new PainKillerMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> STARE = REGISTRY.register("stare", () -> new StareMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> TREMBLE = REGISTRY.register("tremble", () -> new TrembleMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> PARANOIA = REGISTRY.register("paranoia", () -> new ParanoiaMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> GOLDEN_BLOOD = REGISTRY.register("golden_blood", () -> new GoldenBloodMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> TERRIFIED = REGISTRY.register("terrified", () -> new TerrifiedMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> LOOKING = REGISTRY.register("looking", () -> new LookingMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> PAINFUL = REGISTRY.register("painful", () -> new PainfulMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> ROOT_BLIND = REGISTRY.register("root_blind", () -> new RootBlindMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> LURKER_HEAD_NEAR = REGISTRY.register("lurker_head_near", () -> new LurkerHeadNearMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> VOIDRIUM_MARK = REGISTRY.register("voidrium_mark", () -> new VoidriumMarkMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> MOTHERLY_CALL = REGISTRY.register("motherly_call", () -> new MotherlyCallMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SINS_AND_SINNERS_MUSIC = REGISTRY.register("sins_and_sinners_music", () -> new SinsAndSinnersMusicMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> DISTRACTED = REGISTRY.register("distracted", () -> new DistractedMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> DARKMARE_MUSIC = REGISTRY.register("darkmare_music", () -> new DarkmareMusicMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> WEAVER_CURSE = REGISTRY.register("weaver_curse", () -> new WeaverCurseMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> HEXED = REGISTRY.register("hexed", () -> new HexedMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> DOOM = REGISTRY.register("doom", () -> new DoomMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> LACERATION = REGISTRY.register("laceration", () -> new LacerationMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> CHAINSAW_MUSIC = REGISTRY.register("chainsaw_music", () -> new ChainsawMusicMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> BLOOD_BOIL = REGISTRY.register("blood_boil", () -> new BloodBoilMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> PITCH_BLACK_MUSIC = REGISTRY.register("pitch_black_music", () -> new PitchBlackMusicMobEffect());

	@SubscribeEvent
	public static void onEffectRemoved(MobEffectEvent.Remove event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	@SubscribeEvent
	public static void onEffectExpired(MobEffectEvent.Expired event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	private static void expireEffects(Entity entity, MobEffectInstance effectInstance) {
		if (effectInstance.getEffect().is(CALL_OF_THE_VOID)) {
			CallOfTheVoidEffectExpiresProcedure.execute(entity.level(), entity);
		} else if (effectInstance.getEffect().is(ROOT_BLIND)) {
			RootBlindEffectExpiresProcedure.execute(entity.level(), entity);
		} else if (effectInstance.getEffect().is(SINS_AND_SINNERS_MUSIC)) {
			SinsAndSinnersMusicEffectExpiresProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
		} else if (effectInstance.getEffect().is(DARKMARE_MUSIC)) {
			DarkmareExpiresProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
		} else if (effectInstance.getEffect().is(HEXED)) {
			HexedEffectExpiresProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(CHAINSAW_MUSIC)) {
			ChainsawExpiresProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
		} else if (effectInstance.getEffect().is(BLOOD_BOIL)) {
			BloodBoilEffectExpiresProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(PITCH_BLACK_MUSIC)) {
			PitchBlackExpiresProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
		}
	}
}
