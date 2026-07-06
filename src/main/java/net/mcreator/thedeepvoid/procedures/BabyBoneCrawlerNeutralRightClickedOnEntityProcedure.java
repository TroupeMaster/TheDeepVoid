package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.BabyBoneCrawlerEntity;

public class BabyBoneCrawlerNeutralRightClickedOnEntityProcedure {
	public static InteractionResult execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return InteractionResult.PASS;
		if (entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BONE) {
				if (!(new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayer _serverPlayer) {
							return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
						} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
							return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
									&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
						}
						return false;
					}
				}.checkGamemode(sourceentity))) {
					(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fox.bite")), SoundSource.HOSTILE, 1, (float) 1.6);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fox.bite")), SoundSource.HOSTILE, 1, (float) 1.6, false);
					}
				}
				if (entity instanceof BabyBoneCrawlerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(BabyBoneCrawlerEntity.DATA_growth, (int) ((entity instanceof BabyBoneCrawlerEntity _datEntI ? _datEntI.getEntityData().get(BabyBoneCrawlerEntity.DATA_growth) : 0) + 1));
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.HEART, x, y, z, 2, 0.1, 0.1, 0.1, 0.1);
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 2));
				if ((entity instanceof BabyBoneCrawlerEntity _datEntI ? _datEntI.getEntityData().get(BabyBoneCrawlerEntity.DATA_growth) : 0) >= 64) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:insect_cry_1")), SoundSource.HOSTILE, 1, (float) 1.4);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:insect_cry_1")), SoundSource.HOSTILE, 1, (float) 1.4, false);
						}
					}
					if (world instanceof ServerLevel _serverLevel) {
						Entity entityinstance = TheDeepVoidModEntities.BONE_CRAWLER.get().create(_serverLevel, null, null, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED, false, false);
						if (entityinstance != null) {
							entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
							if (entityinstance instanceof TamableAnimal _toTame && sourceentity instanceof Player _owner)
								_toTame.tame(_owner);
							_serverLevel.addFreshEntity(entityinstance);
						}
					}
					for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 0, 4); index0++) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(TheDeepVoidModItems.BONE_CRAWLER_CHITIN.get()));
							entityToSpawn.setPickUpDelay(10);
							entityToSpawn.setUnlimitedLifetime();
							_level.addFreshEntity(entityToSpawn);
						}
					}
					if (!(sourceentity instanceof ServerPlayer _plr19 && _plr19.level() instanceof ServerLevel
							&& _plr19.getAdvancements().getOrStartProgress(_plr19.server.getAdvancements().getAdvancement(new ResourceLocation("the_deep_void:miracle_of_life"))).isDone())) {
						if (sourceentity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("the_deep_void:miracle_of_life"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
					if (!entity.level().isClientSide())
						entity.discard();
				}
				return InteractionResult.SUCCESS;
			} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.BONE_CRAWLER_FEED.get()) {
				if (!(new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayer _serverPlayer) {
							return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
						} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
							return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
									&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
						}
						return false;
					}
				}.checkGamemode(sourceentity))) {
					(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fox.bite")), SoundSource.HOSTILE, 1, (float) 1.6);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fox.bite")), SoundSource.HOSTILE, 1, (float) 1.6, false);
					}
				}
				if (entity instanceof BabyBoneCrawlerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(BabyBoneCrawlerEntity.DATA_growth, (int) ((entity instanceof BabyBoneCrawlerEntity _datEntI ? _datEntI.getEntityData().get(BabyBoneCrawlerEntity.DATA_growth) : 0) + 2));
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.HEART, x, y, z, 2, 0.1, 0.1, 0.1, 0.1);
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 4));
				if ((entity instanceof BabyBoneCrawlerEntity _datEntI ? _datEntI.getEntityData().get(BabyBoneCrawlerEntity.DATA_growth) : 0) >= 64) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:insect_cry_1")), SoundSource.HOSTILE, 1, (float) 1.4);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:insect_cry_1")), SoundSource.HOSTILE, 1, (float) 1.4, false);
						}
					}
					if (world instanceof ServerLevel _serverLevel) {
						Entity entityinstance = TheDeepVoidModEntities.BONE_CRAWLER.get().create(_serverLevel, null, null, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED, false, false);
						if (entityinstance != null) {
							entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
							if (entityinstance instanceof TamableAnimal _toTame && sourceentity instanceof Player _owner)
								_toTame.tame(_owner);
							_serverLevel.addFreshEntity(entityinstance);
						}
					}
					for (int index1 = 0; index1 < Mth.nextInt(RandomSource.create(), 1, 5); index1++) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(TheDeepVoidModItems.BONE_CRAWLER_CHITIN.get()));
							entityToSpawn.setPickUpDelay(10);
							entityToSpawn.setUnlimitedLifetime();
							_level.addFreshEntity(entityToSpawn);
						}
					}
					if (!(sourceentity instanceof ServerPlayer _plr41 && _plr41.level() instanceof ServerLevel
							&& _plr41.getAdvancements().getOrStartProgress(_plr41.server.getAdvancements().getAdvancement(new ResourceLocation("the_deep_void:miracle_of_life"))).isDone())) {
						if (sourceentity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("the_deep_void:miracle_of_life"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
					if (!entity.level().isClientSide())
						entity.discard();
				}
				return InteractionResult.SUCCESS;
			}
		}
		return InteractionResult.PASS;
	}
}
