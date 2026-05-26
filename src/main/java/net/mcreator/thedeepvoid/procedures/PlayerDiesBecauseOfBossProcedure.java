package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.entity.WeaverOfSoulsBossEntity;
import net.mcreator.thedeepvoid.entity.PrimordialBoneCrawlerEntity;
import net.mcreator.thedeepvoid.entity.MisanthropicHivemindEntity;
import net.mcreator.thedeepvoid.entity.HiveWatcherEntity;
import net.mcreator.thedeepvoid.entity.FleshWormEntity;
import net.mcreator.thedeepvoid.entity.ElderMimicEntity;
import net.mcreator.thedeepvoid.entity.ApostleBossEntity;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class PlayerDiesBecauseOfBossProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player && (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).noHit == true) {
			{
				boolean _setval = false;
				entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.noHit = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (entity instanceof MisanthropicHivemindEntity || entity instanceof HiveWatcherEntity || entity instanceof PrimordialBoneCrawlerEntity || entity instanceof ApostleBossEntity || entity instanceof WeaverOfSoulsBossEntity
				|| entity instanceof ElderMimicEntity || entity instanceof FleshWormEntity) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(80 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						{
							double _setval = 0;
							entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MusicWait = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
						{
							double _setval = -1;
							entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MusicTick = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
						{
							String _setval = "";
							entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MusicPlay = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
						{
							boolean _setval = false;
							entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MusicLock = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
						{
							boolean _setval = false;
							entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MusicReplace = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
					}
				}
			}
		}
	}
}
