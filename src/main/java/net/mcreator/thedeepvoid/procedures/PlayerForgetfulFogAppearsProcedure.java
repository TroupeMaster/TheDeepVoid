package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;
import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class PlayerForgetfulFogAppearsProcedure {
	@SubscribeEvent
	public static void updateWorldTick(TickEvent.ClientTickEvent event) {
		if (event.phase != TickEvent.Phase.START)
			return;
		Minecraft minecraft = Minecraft.getInstance();
		ClientLevel level = minecraft.level;
		Entity entity = minecraft.gameRenderer.getMainCamera().getEntity();
		if (level != null && entity != null) {
			Vec3 pos = entity.getPosition(minecraft.getPartialTick());
			execute(event, level, pos.x(), pos.z(), entity);
		}
	}

	public static void execute(LevelAccessor world, double x, double z, Entity entity) {
		execute(null, world, x, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(TheDeepVoidModMobEffects.BRAIN_FOG.get())) {
			if (world instanceof ClientLevel) {
				for (Entity entityiterator : ((ClientLevel) world).entitiesForRendering()) {
					if (entityiterator instanceof Player && !(entityiterator == entity)) {
						world.addParticle((SimpleParticleType) (TheDeepVoidModParticleTypes.FORGETFUL_FOG.get()), (entityiterator.getX() + Mth.nextDouble(RandomSource.create(), -1, 1)),
								(entityiterator.getY() + Mth.nextDouble(RandomSource.create(), 0, 1.8)), (entityiterator.getZ() + Mth.nextDouble(RandomSource.create(), -1, 1)), (Mth.nextDouble(RandomSource.create(), -0.005, 0.005)), 0,
								(Mth.nextDouble(RandomSource.create(), -0.005, 0.005)));
						world.addParticle((SimpleParticleType) (TheDeepVoidModParticleTypes.FORGETFUL_FOG.get()), entityiterator.getX() + entityiterator.getLookAngle().x * 0.7, (entityiterator.getY() + 1.8),
								entityiterator.getZ() + entityiterator.getLookAngle().z * 0.7, (Mth.nextDouble(RandomSource.create(), -0.005, 0.005)), 0, (Mth.nextDouble(RandomSource.create(), -0.005, 0.005)));
						entityiterator.setCustomName(Component.literal(("\u00A7k" + entityiterator.getDisplayName().getString())));
					}
					if (entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) {
						world.addParticle((SimpleParticleType) (TheDeepVoidModParticleTypes.FORGETFUL_FOG.get()), (entityiterator.getX() + Mth.nextDouble(RandomSource.create(), -1, 1)),
								(entityiterator.getY() + entityiterator.getEyeHeight() + Mth.nextDouble(RandomSource.create(), -1, 1)), (entityiterator.getZ() + Mth.nextDouble(RandomSource.create(), -1, 1)),
								(Mth.nextDouble(RandomSource.create(), -0.005, 0.005)), 0, (Mth.nextDouble(RandomSource.create(), -0.005, 0.005)));
						world.addParticle((SimpleParticleType) (TheDeepVoidModParticleTypes.FORGETFUL_FOG.get()), entityiterator.getX() + entityiterator.getLookAngle().x * 1, (entityiterator.getY() + entityiterator.getEyeHeight()),
								entityiterator.getZ() + entityiterator.getLookAngle().z * 1, (Mth.nextDouble(RandomSource.create(), -0.005, 0.005)), 0, (Mth.nextDouble(RandomSource.create(), -0.005, 0.005)));
						if (!(entityiterator.getDisplayName().getString()).isEmpty()) {
							entityiterator.setCustomName(Component.literal(("\u00A7k" + entityiterator.getDisplayName().getString())));
						}
					}
				}
			}
		}
	}
}
