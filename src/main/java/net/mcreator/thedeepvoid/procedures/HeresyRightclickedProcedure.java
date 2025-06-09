package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.item.HeresyItem;
import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.BloodshotEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class HeresyRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getDouble("deep_void:rounds") > 0) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 25);
			{
				Entity _shootFrom = entity;
				Level projectileLevel = _shootFrom.level();
				if (!projectileLevel.isClientSide()) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
							AbstractArrow entityToSpawn = new BloodshotEntity(TheDeepVoidModEntities.BLOODSHOT.get(), level);
							entityToSpawn.setOwner(shooter);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback(knockback);
							entityToSpawn.setSilent(true);
							entityToSpawn.setPierceLevel(piercing);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, entity, 3, 0, (byte) 2);
					_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
					_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 4, 1);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
			if (itemstack.getItem() instanceof HeresyItem)
				itemstack.getOrCreateTag().putString("geckoAnim", "animation.heresy_shoot");
			itemstack.getOrCreateTag().putDouble("deep_void:rounds", (itemstack.getOrCreateTag().getDouble("deep_void:rounds") - 1));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:heresy_shoot")), SoundSource.PLAYERS, 3, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:heresy_shoot")), SoundSource.PLAYERS, 3, 1, false);
				}
			}
			TheDeepVoidMod.queueServerWork(12, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:heresy_lever")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:heresy_lever")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
			});
			TheDeepVoidMod.queueServerWork(14, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -1, 1), y, z + Mth.nextInt(RandomSource.create(), -1, 1)),
								ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:heresy_shell_fall")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound((x + Mth.nextInt(RandomSource.create(), -1, 1)), y, (z + Mth.nextInt(RandomSource.create(), -1, 1)), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:heresy_shell_fall")),
								SoundSource.PLAYERS, 1, 1, false);
					}
				}
			});
		} else if (itemstack.getOrCreateTag().getDouble("deep_void:rounds") <= 0) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 25);
			if (itemstack.getItem() instanceof HeresyItem)
				itemstack.getOrCreateTag().putString("geckoAnim", "animation.heresy_reload");
			TheDeepVoidMod.queueServerWork(10, () -> {
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:void_energy")))),
						(float) Math.ceil(((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) * 25) / 100));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fox.bite")), SoundSource.PLAYERS, 1, (float) 0.8);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fox.bite")), SoundSource.PLAYERS, 1, (float) 0.8, false);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:stab")), SoundSource.PLAYERS, 1, (float) 0.8);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:stab")), SoundSource.PLAYERS, 1, (float) 0.8, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.BLOOD.get()),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(0.7)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
							(entity.getY() + 1.5),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(0.7)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()), 5,
							0.04, 0.04, 0.04, 0.1);
				itemstack.getOrCreateTag().putDouble("deep_void:rounds", 7);
			});
		}
	}
}
