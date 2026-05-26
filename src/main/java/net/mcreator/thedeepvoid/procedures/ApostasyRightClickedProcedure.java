package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.item.ApostasyItem;
import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;
import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.SoulFusedShotEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class ApostasyRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getDouble("deep_void:rounds") > 0) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 25);
			if (itemstack.getItem() instanceof ApostasyItem)
				itemstack.getOrCreateTag().putString("geckoAnim", "animation.apostasy_shoot");
			if (world instanceof Level)
				((Level) world).playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:apostasy_shoot")), SoundSource.PLAYERS, 3, 1, false);
			TheDeepVoidMod.queueServerWork(12, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:apostasy_reload")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:apostasy_reload")), SoundSource.PLAYERS, 1, 1, false);
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
			{
				Entity _shootFrom = entity;
				Level projectileLevel = _shootFrom.level();
				if (!projectileLevel.isClientSide()) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
							AbstractArrow entityToSpawn = new SoulFusedShotEntity(TheDeepVoidModEntities.SOUL_FUSED_SHOT.get(), level);
							entityToSpawn.setOwner(shooter);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback(knockback);
							entityToSpawn.setSilent(true);
							entityToSpawn.setPierceLevel(piercing);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, entity, (float) (double) DeepVoidConfigConfiguration.APOSTASYSOULFUSEDSHOT.get(), 0, (byte) 5);
					_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
					_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 8, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
			if (itemstack.getOrCreateTag().getDouble("deep_void:rounds") == 4) {
				for (int index0 = 0; index0 < 4; index0++) {
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
									AbstractArrow entityToSpawn = new SoulFusedShotEntity(TheDeepVoidModEntities.SOUL_FUSED_SHOT.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									entityToSpawn.setPierceLevel(piercing);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, (float) (double) DeepVoidConfigConfiguration.APOSTASYSOULFUSEDSHOT.get(), 0, (byte) 2);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 6);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
				}
			}
			entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * (-1.7)), (Math.sin(Math.toRadians(0 - entity.getXRot())) * (-0.8)), (Math.cos(Math.toRadians(entity.getYRot())) * (-1.7))));
			itemstack.getOrCreateTag().putDouble("deep_void:rounds", (itemstack.getOrCreateTag().getDouble("deep_void:rounds") - 1));
		} else if (itemstack.getOrCreateTag().getDouble("deep_void:rounds") <= 0) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 25);
			if (itemstack.getItem() instanceof ApostasyItem)
				itemstack.getOrCreateTag().putString("geckoAnim", "animation.apostasy_reload");
			TheDeepVoidMod.queueServerWork(10, () -> {
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth((float) Math.ceil((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)
							* ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.GUNSLINGER_HELMET.get()
									&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.GUNSLINGER_CHESTPLATE.get()
									&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.GUNSLINGER_LEGGINGS.get()
									&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.GUNSLINGER_BOOTS.get() ? 40 : 50))
							/ 100));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.phantom.bite")), SoundSource.PLAYERS, 1, (float) 0.8);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.phantom.bite")), SoundSource.PLAYERS, 1, (float) 0.8, false);
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
				itemstack.getOrCreateTag().putDouble("deep_void:rounds", 4);
			});
		}
	}
}
