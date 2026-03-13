package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEnchantments;
import net.mcreator.thedeepvoid.entity.VoidbornEntity;
import net.mcreator.thedeepvoid.entity.LightEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

public class VoidbornEntityIsHurtProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		if (immediatesourceentity instanceof Player && !world.getEntitiesOfClass(LightEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 8, 8, 8), e -> true).isEmpty()
				&& (entity instanceof VoidbornEntity _datEntI ? _datEntI.getEntityData().get(VoidbornEntity.DATA_hitCooldown) : 0) <= 0) {
			if (entity instanceof VoidbornEntity _datEntSetI)
				_datEntSetI.getEntityData().set(VoidbornEntity.DATA_hit, (int) ((entity instanceof VoidbornEntity _datEntI ? _datEntI.getEntityData().get(VoidbornEntity.DATA_hit) : 0)
						+ (EnchantmentHelper.getItemEnchantmentLevel(TheDeepVoidModEnchantments.RADIANCE.get(), (immediatesourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0 ? 2 : 1)));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 200, 0, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 99, false, false));
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SQUID_INK, (entity.getX()), (entity.getY() + 4), (entity.getZ()), 25, 0, (-1), 0, 0.2);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SQUID_INK, (entity.getX()), (entity.getY() + 2), (entity.getZ()), 25, 0, (-1), 0, 0.2);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt")), SoundSource.HOSTILE, 1, (float) Mth.nextDouble(RandomSource.create(), 0.4, 0.5));
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt")), SoundSource.HOSTILE, 1, (float) Mth.nextDouble(RandomSource.create(), 0.4, 0.5), false);
				}
			}
			if (entity instanceof VoidbornEntity _datEntSetI)
				_datEntSetI.getEntityData().set(VoidbornEntity.DATA_hitCooldown, (int) (double) DeepVoidConfigConfiguration.VOIDBORNHITCOOLDOWN.get());
			if (Math.random() < 0.2) {
				if (!world.getBlockState(BlockPos.containing(sourceentity.level()
						.clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale((-5))), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, sourceentity)).getBlockPos().getX(),
						sourceentity.getY(),
						sourceentity.level().clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale((-5))), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, sourceentity))
								.getBlockPos().getZ()))
						.canOcclude()
						&& !world
								.getBlockState(
										BlockPos.containing(
												sourceentity.level()
														.clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale((-5))), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																sourceentity))
														.getBlockPos().getX(),
												sourceentity.getY() + 1,
												sourceentity.level()
														.clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale((-5))), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																sourceentity))
														.getBlockPos().getZ()))
								.canOcclude()
						&& world.getBlockState(BlockPos.containing(
								sourceentity.level()
										.clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale((-5))), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, sourceentity))
										.getBlockPos().getX(),
								sourceentity.getY() - 1,
								sourceentity.level()
										.clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale((-5))), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, sourceentity))
										.getBlockPos().getZ()))
								.canOcclude()) {
					{
						Entity _ent = entity;
						_ent.teleportTo(
								(sourceentity.level()
										.clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale((-5))), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, sourceentity))
										.getBlockPos().getX()),
								(sourceentity.getY()),
								(sourceentity.level()
										.clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale((-5))), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, sourceentity))
										.getBlockPos().getZ()));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection
									.teleport(
											(sourceentity.level()
													.clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale((-5))), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
															sourceentity))
													.getBlockPos().getX()),
											(sourceentity.getY()),
											(sourceentity.level().clip(
													new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale((-5))), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, sourceentity))
													.getBlockPos().getZ()),
											_ent.getYRot(), _ent.getXRot());
					}
				}
			}
		}
		if ((entity instanceof VoidbornEntity _datEntI ? _datEntI.getEntityData().get(VoidbornEntity.DATA_hit) : 0) >= (double) DeepVoidConfigConfiguration.VOIDBORNHEALTH.get()) {
			if (entity instanceof VoidbornEntity _datEntSetI)
				_datEntSetI.getEntityData().set(VoidbornEntity.DATA_hit, -99);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SQUID_INK, (entity.getX()), (entity.getY() + 4), (entity.getZ()), 25, 0, (-1), 0, 0.2);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SQUID_INK, (entity.getX()), (entity.getY() + 2), (entity.getZ()), 25, 0, (-1), 0, 0.2);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:nightmare_whispers")), SoundSource.HOSTILE, 1,
							(float) Mth.nextDouble(RandomSource.create(), 0.6, 0.7));
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:nightmare_whispers")), SoundSource.HOSTILE, 1, (float) Mth.nextDouble(RandomSource.create(), 0.6, 0.7), false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/loot spawn ~ ~ ~ loot the_deep_void:entities/voidborn");
			if (!entity.level().isClientSide())
				entity.discard();
			if (((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.GRIM_SCYTHE.get()
					|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.CRUEL_STILETTO.get()
					|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.SHADESTORM.get()
					|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.VOID_MATTER_GREATSWORD.get())
					&& !(sourceentity instanceof ServerPlayer _plr63 && _plr63.level() instanceof ServerLevel
							&& _plr63.getAdvancements().getOrStartProgress(_plr63.server.getAdvancements().getAdvancement(new ResourceLocation("the_deep_void:watch_it_punk"))).isDone())) {
				if (sourceentity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("the_deep_void:watch_it_punk"));
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
