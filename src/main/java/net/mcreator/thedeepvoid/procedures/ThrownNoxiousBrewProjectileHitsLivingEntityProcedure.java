package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.UndertakerEntity;
import net.mcreator.thedeepvoid.entity.ThrownNoxiousBrewEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ThrownNoxiousBrewProjectileHitsLivingEntityProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getDirectEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, immediatesourceentity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		if (immediatesourceentity instanceof ThrownNoxiousBrewEntity) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.shulker_bullet.hit")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.shulker_bullet.hit")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (entity instanceof UndertakerEntity) {
				if (entity instanceof Mob) {
					try {
						((Mob) entity).setTarget(null);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if ((entity instanceof UndertakerEntity _datEntL4 && _datEntL4.getEntityData().get(UndertakerEntity.DATA_empty)) == true) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.receive_brew_empty").getString())),
								false);
					if (sourceentity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(TheDeepVoidModItems.DARK_STEEL_COIN.get()).copy();
						_setstack.setCount(Mth.nextInt(RandomSource.create(), 8, 16));
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				} else {
					if (world instanceof ServerLevel _serverLevel) {
						Entity entityinstance = TheDeepVoidModEntities.UNDERTAKER.get().create(_serverLevel, null, null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED, false, false);
						if (entityinstance != null) {
							entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
							if (entityinstance instanceof UndertakerEntity _datEntSetL)
								_datEntSetL.getEntityData().set(UndertakerEntity.DATA_talkedTo, true);
							entityinstance.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((sourceentity.getX()), (sourceentity.getY() + 1.5), (sourceentity.getZ())));
							_serverLevel.addFreshEntity(entityinstance);
						}
					}
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.receive_brew").getString())), false);
					if (!entity.level().isClientSide())
						entity.discard();
				}
			} else {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 200, 0));
			}
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
		}
	}
}
