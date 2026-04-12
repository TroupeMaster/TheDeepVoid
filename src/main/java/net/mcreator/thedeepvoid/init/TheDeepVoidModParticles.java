
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedeepvoid.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.thedeepvoid.client.particle.XpSmokeParticle;
import net.mcreator.thedeepvoid.client.particle.VoidriumSmokeParticle;
import net.mcreator.thedeepvoid.client.particle.VoidMatterResidueParticle;
import net.mcreator.thedeepvoid.client.particle.VoidMatterCritParticle;
import net.mcreator.thedeepvoid.client.particle.SulfurSmokeParticle;
import net.mcreator.thedeepvoid.client.particle.SoulSweepParticle;
import net.mcreator.thedeepvoid.client.particle.SoulHookLineParticle;
import net.mcreator.thedeepvoid.client.particle.SoulFusedBloodParticle;
import net.mcreator.thedeepvoid.client.particle.ShadeDropParticle;
import net.mcreator.thedeepvoid.client.particle.RedSmokeParticle;
import net.mcreator.thedeepvoid.client.particle.RedGreatSlashParticle;
import net.mcreator.thedeepvoid.client.particle.PusSporeParticle;
import net.mcreator.thedeepvoid.client.particle.PlagueSmokeParticle;
import net.mcreator.thedeepvoid.client.particle.PentagramParticle;
import net.mcreator.thedeepvoid.client.particle.MobRespawnParticle;
import net.mcreator.thedeepvoid.client.particle.LunaticEyeParticle;
import net.mcreator.thedeepvoid.client.particle.LickerTongueParticle;
import net.mcreator.thedeepvoid.client.particle.IchorFlameParticle;
import net.mcreator.thedeepvoid.client.particle.HookLineParticle;
import net.mcreator.thedeepvoid.client.particle.GrimSweepParticle;
import net.mcreator.thedeepvoid.client.particle.GrimHookLineParticle;
import net.mcreator.thedeepvoid.client.particle.GoldenSmokeParticle;
import net.mcreator.thedeepvoid.client.particle.GoldBloodParticle;
import net.mcreator.thedeepvoid.client.particle.FlyParticle;
import net.mcreator.thedeepvoid.client.particle.FlameOfSpiteParticle;
import net.mcreator.thedeepvoid.client.particle.FallingVoidAshParticle;
import net.mcreator.thedeepvoid.client.particle.EyeParticle;
import net.mcreator.thedeepvoid.client.particle.EldritchEyeParticle;
import net.mcreator.thedeepvoid.client.particle.DeepslatePebbleParticle;
import net.mcreator.thedeepvoid.client.particle.DarkTearParticle;
import net.mcreator.thedeepvoid.client.particle.DarkSweepParticle;
import net.mcreator.thedeepvoid.client.particle.BrokenBoneParticle;
import net.mcreator.thedeepvoid.client.particle.BrightSmokeParticle;
import net.mcreator.thedeepvoid.client.particle.BloodSmokeParticle;
import net.mcreator.thedeepvoid.client.particle.BloodParticle;
import net.mcreator.thedeepvoid.client.particle.BlackTentacleParticle;
import net.mcreator.thedeepvoid.client.particle.BlackFlameParticle;
import net.mcreator.thedeepvoid.client.particle.BiteParticle;
import net.mcreator.thedeepvoid.client.particle.AmbrosiaDropletParticle;

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
		event.registerSpriteSet(TheDeepVoidModParticleTypes.RED_GREAT_SLASH.get(), RedGreatSlashParticle::provider);
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
	}
}
