package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.DarkSteelFlailEntity;

public class BallAndChainRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("flailUsed") == 0) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 10);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.snowball.throw")), SoundSource.PLAYERS, 2, (float) 0.5);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.snowball.throw")), SoundSource.PLAYERS, 2, (float) 0.5, false);
				}
			}
			entity.getPersistentData().putDouble("flailUsed", 1);
			if (world instanceof ServerLevel _serverLevel) {
				Entity entityinstance = TheDeepVoidModEntities.DARK_STEEL_FLAIL.get().create(_serverLevel, null, null,
						BlockPos.containing(entity.getX() + entity.getLookAngle().x * 1, entity.getY() + entity.getLookAngle().y + 1.5 * 1, entity.getZ() + entity.getLookAngle().z * 1), MobSpawnType.MOB_SUMMONED, false, false);
				if (entityinstance != null) {
					entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
					if (itemstack.getOrCreateTag().getDouble("secret") == 1) {
						if (entityinstance instanceof DarkSteelFlailEntity _datEntSetL)
							_datEntSetL.getEntityData().set(DarkSteelFlailEntity.DATA_secret, true);
					}
					if (entityinstance instanceof TamableAnimal _toTame && entity instanceof Player _owner)
						_toTame.tame(_owner);
					entityinstance.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 1.5), (Math.sin(Math.toRadians(0 - entity.getXRot())) * 1.5), (Math.cos(Math.toRadians(entity.getYRot())) * 1.5)));
					_serverLevel.addFreshEntity(entityinstance);
				}
			}
		}
	}
}
