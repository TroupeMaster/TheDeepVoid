package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.entity.WeaverOfSoulsEntity;
import net.mcreator.thedeepvoid.entity.PrimordialBoneCrawlerEntity;
import net.mcreator.thedeepvoid.entity.MisanthropicHivemindEntity;
import net.mcreator.thedeepvoid.entity.HiveWatcherEntity;
import net.mcreator.thedeepvoid.entity.ElderMimicEntity;
import net.mcreator.thedeepvoid.entity.ApostleOfCatastropheEntity;

import java.util.List;
import java.util.Comparator;

public class WeaverBossMusicProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof WeaverOfSoulsEntity) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(200 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).MusicLock) {
						{
							boolean _setval = true;
							entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MusicLock = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
						{
							double _setval = 0;
							entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MusicTick = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
						{
							double _setval = 0;
							entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MusicWait = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
						{
							String _setval = "darkmare";
							entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MusicPlay = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
					} else if ((entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).MusicReplace) {
						{
							double _setval = 3300;
							entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MusicWait = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
					}
				}
			}
		} else if (entity instanceof ApostleOfCatastropheEntity) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(200 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).MusicLock) {
						{
							boolean _setval = true;
							entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MusicLock = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
						{
							double _setval = 0;
							entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MusicTick = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
						{
							double _setval = 0;
							entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MusicWait = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
						{
							String _setval = "chainsaw";
							entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MusicPlay = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
					} else if ((entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).MusicReplace) {
						{
							double _setval = 2350;
							entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MusicWait = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
					}
				}
			}
		} else if (entity instanceof MisanthropicHivemindEntity || entity instanceof ElderMimicEntity) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(200 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).MusicLock) {
						{
							boolean _setval = true;
							entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MusicLock = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
						{
							double _setval = 0;
							entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MusicTick = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
						{
							double _setval = 0;
							entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MusicWait = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
						{
							String _setval = "pitch_black";
							entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MusicPlay = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
					} else if ((entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).MusicReplace) {
						{
							double _setval = 1700;
							entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MusicWait = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
					}
				}
			}
		} else if (entity instanceof PrimordialBoneCrawlerEntity) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(200 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).MusicLock) {
						{
							boolean _setval = true;
							entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MusicLock = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
						{
							double _setval = 0;
							entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MusicTick = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
						{
							double _setval = 0;
							entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MusicWait = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
						{
							String _setval = "the_haunt";
							entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MusicPlay = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
					} else if ((entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).MusicReplace) {
						{
							double _setval = 5020;
							entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MusicWait = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
					}
				}
			}
		} else if (entity instanceof HiveWatcherEntity) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(200 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).MusicLock) {
						{
							boolean _setval = true;
							entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MusicLock = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
						{
							double _setval = 0;
							entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MusicTick = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
						{
							double _setval = 0;
							entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MusicWait = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
						{
							String _setval = "monsters_lair";
							entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MusicPlay = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
					} else if ((entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).MusicReplace) {
						{
							double _setval = 3600;
							entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MusicWait = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
					}
				}
			}
		}
	}
}
