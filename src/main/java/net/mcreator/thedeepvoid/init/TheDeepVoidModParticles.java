
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedeepvoid.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.thedeepvoid.client.particle.ShadeDropParticle;
import net.mcreator.thedeepvoid.client.particle.PusSporeParticle;
import net.mcreator.thedeepvoid.client.particle.PentagramParticle;
import net.mcreator.thedeepvoid.client.particle.LickerTongueParticle;
import net.mcreator.thedeepvoid.client.particle.GrimSweepParticle;
import net.mcreator.thedeepvoid.client.particle.FlyParticle;
import net.mcreator.thedeepvoid.client.particle.FlameOfSpiteParticle;
import net.mcreator.thedeepvoid.client.particle.EyeParticle;
import net.mcreator.thedeepvoid.client.particle.DeepslatePebbleParticle;
import net.mcreator.thedeepvoid.client.particle.DarkTearParticle;
import net.mcreator.thedeepvoid.client.particle.BrokenBoneParticle;
import net.mcreator.thedeepvoid.client.particle.BloodParticle;

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
	}
}
