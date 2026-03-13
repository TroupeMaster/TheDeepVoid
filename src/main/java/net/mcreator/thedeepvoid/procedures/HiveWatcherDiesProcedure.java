package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;
import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.HiveWatcherEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class HiveWatcherDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof HiveWatcherEntity _datEntL0 && _datEntL0.getEntityData().get(HiveWatcherEntity.DATA_dying)) == false) {
			if (entity instanceof HiveWatcherEntity _datEntSetL)
				_datEntSetL.getEntityData().set(HiveWatcherEntity.DATA_dying, true);
			if (entity instanceof HiveWatcherEntity) {
				((HiveWatcherEntity) entity).setAnimation("empty");
			}
			if (entity instanceof HiveWatcherEntity) {
				((HiveWatcherEntity) entity).setAnimation("animation.hiveWatcher_death");
			}
			TheDeepVoidMod.queueServerWork(30, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:fleshy_explosion")), SoundSource.HOSTILE, 2, (float) 0.9);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:fleshy_explosion")), SoundSource.HOSTILE, 2, (float) 0.9, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.BLOOD.get()), (entity.getX()), (entity.getY() + 2), (entity.getZ()), 25, (Mth.nextDouble(RandomSource.create(), -1, 1)), 0.1,
							(Mth.nextDouble(RandomSource.create(), -1, 1)), 0.1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.LICKER_TONGUE.get()), (entity.getX()), (entity.getY() + 2), (entity.getZ()), 25, (Mth.nextDouble(RandomSource.create(), -1, 1)), 0.1,
							(Mth.nextDouble(RandomSource.create(), -1, 1)), 0.1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.AMBROSIA_DROPLET.get()), (entity.getX()), (entity.getY() + 2), (entity.getZ()), 15, (Mth.nextDouble(RandomSource.create(), -1, 1)), 0.1,
							(Mth.nextDouble(RandomSource.create(), -1, 1)), 0.1);
			});
			TheDeepVoidMod.queueServerWork(60, () -> {
				if (DeepVoidConfigConfiguration.SUMMONBOSSRESPAWN.get() == true) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.EYE_OF_THE_WATCHER.get().spawn(_level,
								BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
				{
					double _setval = (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).watcherFightCount + 1;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.watcherFightCount = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Player) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(TheDeepVoidModItems.HIVE_WATCHER_TREASURE_BAG.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							if (!(entityiterator instanceof ServerPlayer _plr31 && _plr31.level() instanceof ServerLevel
									&& _plr31.getAdvancements().getOrStartProgress(_plr31.server.getAdvancements().getAdvancement(new ResourceLocation("the_deep_void:ommetaphobia"))).isDone())) {
								if (entityiterator instanceof ServerPlayer _player) {
									Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("the_deep_void:ommetaphobia"));
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
						}
					}
				}
			});
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"stopsound @a record the_deep_void:monsters_lair");
			TheDeepVoidMod.queueServerWork(20, () -> {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"stopsound @a record the_deep_void:monsters_lair");
			});
		}
	}
}
