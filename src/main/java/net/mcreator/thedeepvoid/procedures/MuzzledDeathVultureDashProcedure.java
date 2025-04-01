package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.entity.MuzzledDeathVultureEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class MuzzledDeathVultureDashProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.isPassenger()) {
			if ((entity.getVehicle()) instanceof MuzzledDeathVultureEntity) {
				if (world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude()) {
					if (Math.random() < 0.05) {
						if (entity instanceof Player _player)
							_player.getCooldowns().addCooldown(itemstack.getItem(), 45);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing((entity.getVehicle()).getX(), (entity.getVehicle()).getY(), (entity.getVehicle()).getZ()),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:riding_crop_hit")), SoundSource.PLAYERS, 1, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
							} else {
								_level.playLocalSound(((entity.getVehicle()).getX()), ((entity.getVehicle()).getY()), ((entity.getVehicle()).getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:riding_crop_hit")),
										SoundSource.PLAYERS, 1, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing((entity.getVehicle()).getX(), (entity.getVehicle()).getY(), (entity.getVehicle()).getZ()),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:death_vulture_hurt")), SoundSource.HOSTILE, 1, (float) 0.8);
							} else {
								_level.playLocalSound(((entity.getVehicle()).getX()), ((entity.getVehicle()).getY()), ((entity.getVehicle()).getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:death_vulture_hurt")),
										SoundSource.HOSTILE, 1, (float) 0.8, false);
							}
						}
						entity.stopRiding();
					} else {
						if (entity instanceof Player _player)
							_player.getCooldowns().addCooldown(itemstack.getItem(), 45);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing((entity.getVehicle()).getX(), (entity.getVehicle()).getY(), (entity.getVehicle()).getZ()),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:riding_crop_hit")), SoundSource.PLAYERS, 1, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
							} else {
								_level.playLocalSound(((entity.getVehicle()).getX()), ((entity.getVehicle()).getY()), ((entity.getVehicle()).getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:riding_crop_hit")),
										SoundSource.PLAYERS, 1, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
							}
						}
						if ((entity.getVehicle()) instanceof MuzzledDeathVultureEntity) {
							((MuzzledDeathVultureEntity) (entity.getVehicle())).setAnimation("animation.vulture_dash");
						}
						TheDeepVoidMod.queueServerWork(6, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing((entity.getVehicle()).getX(), (entity.getVehicle()).getY(), (entity.getVehicle()).getZ()),
											ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:death_vulture_ambient")), SoundSource.HOSTILE, (float) 1.2, (float) Mth.nextDouble(RandomSource.create(), 1.3, 1.7));
								} else {
									_level.playLocalSound(((entity.getVehicle()).getX()), ((entity.getVehicle()).getY()), ((entity.getVehicle()).getZ()),
											ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:death_vulture_ambient")), SoundSource.HOSTILE, (float) 1.2, (float) Mth.nextDouble(RandomSource.create(), 1.3, 1.7), false);
								}
							}
							(entity.getVehicle()).setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 2.4), (Math.sin(Math.toRadians(0 - entity.getXRot())) * 2.4), (Math.cos(Math.toRadians(entity.getYRot())) * 2.4)));
						});
					}
				}
			}
		}
	}
}
