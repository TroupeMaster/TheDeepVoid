package net.mcreator.thedeepvoid.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.MobEffectEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.HiveBrainEntity;
import net.mcreator.thedeepvoid.entity.EyeOfTheWatcherEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EntityEffectTriesToApplyProcedure {
	@SubscribeEvent
	public static void onMobEffectEvent(MobEffectEvent.Applicable event) {
		if (event != null && event.getEntity() != null) {
			String effect = event.getEffectInstance().toString();
			int level = new Object() {
				int convert(String s) {
					try {
						return (int) Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(effect.substring(effect.indexOf("x ") + "x ".length(), effect.indexOf(",")));
			level = Math.max(1, level);
			int duration = new Object() {
				int convert(String s) {
					try {
						return (int) Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(effect.substring(effect.indexOf("Duration: ") + 10, effect.length()));
			effect = effect.replace("effect.", "").replace(".", ":").replace(",", "");
			effect = effect.substring(0, effect.indexOf(" "));
			execute(event, event.getEntity());
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof HiveBrainEntity || entity instanceof EyeOfTheWatcherEntity) {
			if (event != null && event.hasResult()) {
				event.setResult(Event.Result.DENY);
			}
		}
	}
}
