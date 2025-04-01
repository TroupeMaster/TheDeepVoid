package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.entity.StalkerEntity;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class CallOfTheVoidDigProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double xPos = 0;
		double yPos = 0;
		double zPos = 0;
		if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).playerCallOfTheVoid == true) {
			if (entity.getPersistentData().getDouble("deep_void:digTime") < 190) {
				if (entity.getPersistentData().getDouble("deep_void:digCooldown") >= 10) {
					entity.getPersistentData().putDouble("deep_void:digCooldown", 0);
					entity.getPersistentData().putDouble("deep_void:digTime", (entity.getPersistentData().getDouble("deep_void:digTime") + 10));
					if (!(!world.getEntitiesOfClass(StalkerEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty()) && !world.getEntitiesOfClass(StalkerEntity.class,
							AABB.ofSize(new Vec3((entity.getPersistentData().getDouble("deep_void:xDig")), (entity.getPersistentData().getDouble("deep_void:yDig")), (entity.getPersistentData().getDouble("deep_void:zDig"))), 350, 350, 350), e -> true)
							.isEmpty()) {
						if (world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("deep_void:xDig"), entity.getPersistentData().getDouble("deep_void:yDig") - 1, entity.getPersistentData().getDouble("deep_void:zDig")))
								.canOcclude()) {
							world.levelEvent(2001, BlockPos.containing(entity.getPersistentData().getDouble("deep_void:xDig"), entity.getPersistentData().getDouble("deep_void:yDig"), entity.getPersistentData().getDouble("deep_void:zDig")),
									Block.getId((world.getBlockState(
											BlockPos.containing(entity.getPersistentData().getDouble("deep_void:xDig"), entity.getPersistentData().getDouble("deep_void:yDig") - 1, entity.getPersistentData().getDouble("deep_void:zDig"))))));
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getPersistentData().getDouble("deep_void:xDig"), entity.getPersistentData().getDouble("deep_void:yDig"), entity.getPersistentData().getDouble("deep_void:zDig")),
											ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.hit")), SoundSource.AMBIENT, 1, 1);
								} else {
									_level.playLocalSound((entity.getPersistentData().getDouble("deep_void:xDig")), (entity.getPersistentData().getDouble("deep_void:yDig")), (entity.getPersistentData().getDouble("deep_void:zDig")),
											ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.hit")), SoundSource.AMBIENT, 1, 1, false);
								}
							}
						}
					} else if (!world.getEntitiesOfClass(StalkerEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty() || !(!world.getEntitiesOfClass(StalkerEntity.class,
							AABB.ofSize(new Vec3((entity.getPersistentData().getDouble("deep_void:xDig")), (entity.getPersistentData().getDouble("deep_void:yDig")), (entity.getPersistentData().getDouble("deep_void:zDig"))), 350, 350, 350), e -> true)
							.isEmpty())) {
						{
							boolean _setval = false;
							entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerCallOfTheVoid = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						entity.getPersistentData().putDouble("deep_void:digCooldown", 0);
						entity.getPersistentData().putDouble("deep_void:digTime", 0);
					}
				} else {
					entity.getPersistentData().putDouble("deep_void:digCooldown", (entity.getPersistentData().getDouble("deep_void:digCooldown") + 1));
				}
			}
			if (entity.getPersistentData().getDouble("deep_void:digTime") >= 190) {
				if (entity.getPersistentData().getDouble("deep_void:digCooldown") >= 10) {
					{
						boolean _setval = false;
						entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.playerCallOfTheVoid = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					entity.getPersistentData().putDouble("deep_void:digCooldown", 0);
					entity.getPersistentData().putDouble("deep_void:digTime", 0);
					if (!world.getEntitiesOfClass(StalkerEntity.class,
							AABB.ofSize(new Vec3((entity.getPersistentData().getDouble("deep_void:xDig")), (entity.getPersistentData().getDouble("deep_void:yDig")), (entity.getPersistentData().getDouble("deep_void:zDig"))), 350, 350, 350), e -> true)
							.isEmpty()) {
						if (!(!world.getEntitiesOfClass(StalkerEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty())
								&& !world
										.getEntitiesOfClass(Player.class,
												AABB.ofSize(new Vec3((entity.getPersistentData().getDouble("deep_void:xDig")), (entity.getPersistentData().getDouble("deep_void:yDig")), (entity.getPersistentData().getDouble("deep_void:zDig"))), 25,
														25, 25),
												e -> true)
										.isEmpty()
								&& world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("deep_void:xDig"), entity.getPersistentData().getDouble("deep_void:yDig") - 1, entity.getPersistentData().getDouble("deep_void:zDig")))
										.canOcclude()) {
							{
								Entity _ent = ((Entity) world.getEntitiesOfClass(StalkerEntity.class, AABB.ofSize(
										new Vec3((entity.getPersistentData().getDouble("deep_void:xDig")), (entity.getPersistentData().getDouble("deep_void:yDig")), (entity.getPersistentData().getDouble("deep_void:zDig"))), 350, 350, 350), e -> true)
										.stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
											}
										}.compareDistOf((entity.getPersistentData().getDouble("deep_void:xDig")), (entity.getPersistentData().getDouble("deep_void:yDig")), (entity.getPersistentData().getDouble("deep_void:zDig")))).findFirst()
										.orElse(null));
								_ent.teleportTo((entity.getPersistentData().getDouble("deep_void:xDig")), (entity.getPersistentData().getDouble("deep_void:yDig") + 1), (entity.getPersistentData().getDouble("deep_void:zDig")));
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport((entity.getPersistentData().getDouble("deep_void:xDig")), (entity.getPersistentData().getDouble("deep_void:yDig") + 1), (entity.getPersistentData().getDouble("deep_void:zDig")),
											_ent.getYRot(), _ent.getXRot());
							}
							{
								final Vec3 _center = new Vec3((entity.getPersistentData().getDouble("deep_void:xDig")), (entity.getPersistentData().getDouble("deep_void:yDig")), (entity.getPersistentData().getDouble("deep_void:zDig")));
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof StalkerEntity) {
										if (entityiterator instanceof StalkerEntity) {
											((StalkerEntity) entityiterator).setAnimation("animation.stalker_dig");
										}
										if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80, 99, false, false));
										if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 80, 99, false, false));
										if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 80, 99, false, false));
									}
								}
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getPersistentData().getDouble("deep_void:xDig"), entity.getPersistentData().getDouble("deep_void:yDig"), entity.getPersistentData().getDouble("deep_void:zDig")),
											ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:stalker_emerges_new")), SoundSource.NEUTRAL, 2, 1);
								} else {
									_level.playLocalSound((entity.getPersistentData().getDouble("deep_void:xDig")), (entity.getPersistentData().getDouble("deep_void:yDig")), (entity.getPersistentData().getDouble("deep_void:zDig")),
											ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:stalker_emerges_new")), SoundSource.NEUTRAL, 2, 1, false);
								}
							}
						}
					}
				} else {
					entity.getPersistentData().putDouble("deep_void:digCooldown", (entity.getPersistentData().getDouble("deep_void:digCooldown") + 1));
				}
			}
		}
	}
}
