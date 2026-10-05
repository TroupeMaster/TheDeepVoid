
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.sombrius.thedeepvoid.init;

import net.sombrius.thedeepvoid.client.particle.XpSmokeParticle;
import net.sombrius.thedeepvoid.client.particle.VoidriumSmokeParticle;
import net.sombrius.thedeepvoid.client.particle.VoidMatterResidueParticle;
import net.sombrius.thedeepvoid.client.particle.VoidMatterCritParticle;
import net.sombrius.thedeepvoid.client.particle.SulfurSmokeParticle;
import net.sombrius.thedeepvoid.client.particle.SoulSweepParticle;
import net.sombrius.thedeepvoid.client.particle.SoulHookLineParticle;
import net.sombrius.thedeepvoid.client.particle.SoulFusedBloodParticle;
import net.sombrius.thedeepvoid.client.particle.ShotgunShellParticle;
import net.sombrius.thedeepvoid.client.particle.ShadeDropParticle;
import net.sombrius.thedeepvoid.client.particle.RedSmokeParticle;
import net.sombrius.thedeepvoid.client.particle.PusSporeParticle;
import net.sombrius.thedeepvoid.client.particle.PlagueSmokeParticle;
import net.sombrius.thedeepvoid.client.particle.PentagramParticle;
import net.sombrius.thedeepvoid.client.particle.MorningstarChainParticle;
import net.sombrius.thedeepvoid.client.particle.MobRespawnParticle;
import net.sombrius.thedeepvoid.client.particle.LunaticEyeParticle;
import net.sombrius.thedeepvoid.client.particle.LickerTongueParticle;
import net.sombrius.thedeepvoid.client.particle.LastingBloodParticle;
import net.sombrius.thedeepvoid.client.particle.IchorSmokeParticle;
import net.sombrius.thedeepvoid.client.particle.IchorLavaParticle;
import net.sombrius.thedeepvoid.client.particle.IchorFlameParticle;
import net.sombrius.thedeepvoid.client.particle.HydraSweepParticle;
import net.sombrius.thedeepvoid.client.particle.HookLineParticle;
import net.sombrius.thedeepvoid.client.particle.GrimSweepParticle;
import net.sombrius.thedeepvoid.client.particle.GrimHookLineParticle;
import net.sombrius.thedeepvoid.client.particle.GoldenSmokeParticle;
import net.sombrius.thedeepvoid.client.particle.GoldBloodParticle;
import net.sombrius.thedeepvoid.client.particle.ForgetfulFogParticle;
import net.sombrius.thedeepvoid.client.particle.FlyParticle;
import net.sombrius.thedeepvoid.client.particle.FlameOfSpiteParticle;
import net.sombrius.thedeepvoid.client.particle.FallingVoidAshParticle;
import net.sombrius.thedeepvoid.client.particle.EyeParticle;
import net.sombrius.thedeepvoid.client.particle.EldritchEyeParticle;
import net.sombrius.thedeepvoid.client.particle.DeepslatePebbleParticle;
import net.sombrius.thedeepvoid.client.particle.DarkTearParticle;
import net.sombrius.thedeepvoid.client.particle.DarkSweepParticle;
import net.sombrius.thedeepvoid.client.particle.ConnectingDarkSteelChainParticle;
import net.sombrius.thedeepvoid.client.particle.ChainParticle;
import net.sombrius.thedeepvoid.client.particle.BrokenBoneParticle;
import net.sombrius.thedeepvoid.client.particle.BrightSmokeParticle;
import net.sombrius.thedeepvoid.client.particle.BrainPieceParticle;
import net.sombrius.thedeepvoid.client.particle.BloodSmokeParticle;
import net.sombrius.thedeepvoid.client.particle.BloodParticle;
import net.sombrius.thedeepvoid.client.particle.BlackTentacleParticle;
import net.sombrius.thedeepvoid.client.particle.BlackFlameParticle;
import net.sombrius.thedeepvoid.client.particle.BiteParticle;
import net.sombrius.thedeepvoid.client.particle.AmbrosiaDropletParticle;
import net.sombrius.thedeepvoid.client.particle.AberrationHandParticle;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TheDeepVoidModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(TheDeepVoidModParticleTypes.BROKEN_BONE.get(), BrokenBoneParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.DARK_TEAR.get(), DarkTearParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.EYE.get(), EyeParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.LICKER_TONGUE.get(), LickerTongueParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.PUS_SPORE.get(), PusSporeParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.DEEPSLATE_PEBBLE.get(), DeepslatePebbleParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.PENTAGRAM.get(), PentagramParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.FLY.get(), FlyParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.BLOOD.get(), BloodParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.GRIM_SWEEP.get(), GrimSweepParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.SHADE_DROP.get(), ShadeDropParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.FLAME_OF_SPITE.get(), FlameOfSpiteParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.BLACK_TENTACLE.get(), BlackTentacleParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.SOUL_SWEEP.get(), SoulSweepParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.GOLD_BLOOD.get(), GoldBloodParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.HOOK_LINE.get(), HookLineParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.GRIM_HOOK_LINE.get(), GrimHookLineParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.SOUL_HOOK_LINE.get(), SoulHookLineParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.SOUL_FUSED_BLOOD.get(), SoulFusedBloodParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.MOB_RESPAWN.get(), MobRespawnParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.AMBROSIA_DROPLET.get(), AmbrosiaDropletParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.ICHOR_FLAME.get(), IchorFlameParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.LUNATIC_EYE.get(), LunaticEyeParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.BLACK_FLAME.get(), BlackFlameParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.ELDRITCH_EYE.get(), EldritchEyeParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.DARK_SWEEP.get(), DarkSweepParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.BITE.get(), BiteParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.VOID_MATTER_CRIT.get(), VoidMatterCritParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.VOID_MATTER_RESIDUE.get(), VoidMatterResidueParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.RED_SMOKE.get(), RedSmokeParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.BRIGHT_SMOKE.get(), BrightSmokeParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.XP_SMOKE.get(), XpSmokeParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.GOLDEN_SMOKE.get(), GoldenSmokeParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.SULFUR_SMOKE.get(), SulfurSmokeParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.VOIDRIUM_SMOKE.get(), VoidriumSmokeParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.BLOOD_SMOKE.get(), BloodSmokeParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.PLAGUE_SMOKE.get(), PlagueSmokeParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.FALLING_VOID_ASH.get(), FallingVoidAshParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.ICHOR_LAVA.get(), IchorLavaParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.CHAIN.get(), ChainParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.SHOTGUN_SHELL.get(), ShotgunShellParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.FORGETFUL_FOG.get(), ForgetfulFogParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.BRAIN_PIECE.get(), BrainPieceParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.LASTING_BLOOD.get(), LastingBloodParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.HYDRA_SWEEP.get(), HydraSweepParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.ABERRATION_HAND.get(), AberrationHandParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.ICHOR_SMOKE.get(), IchorSmokeParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.CONNECTING_DARK_STEEL_CHAIN.get(), ConnectingDarkSteelChainParticle::provider);
		event.registerSpriteSet(TheDeepVoidModParticleTypes.MORNINGSTAR_CHAIN.get(), MorningstarChainParticle::provider);
	}
}
