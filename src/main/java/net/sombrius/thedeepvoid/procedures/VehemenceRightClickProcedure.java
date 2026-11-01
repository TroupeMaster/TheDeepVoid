package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.item.VehemenceItem;
import net.sombrius.thedeepvoid.init.TheDeepVoidModItems;
import net.sombrius.thedeepvoid.init.TheDeepVoidModEntities;
import net.sombrius.thedeepvoid.init.TheDeepVoidModEnchantments;
import net.sombrius.thedeepvoid.entity.IronSpikeEntity;
import net.sombrius.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.sombrius.thedeepvoid.TheDeepVoidMod;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

public class VehemenceRightClickProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
			if (itemstack.getOrCreateTag().getDouble("shot") > 0 && (entity instanceof Player _plrCldRem6 ? _plrCldRem6.getCooldowns().getCooldownPercent(itemstack.getItem(), 0f) * 100 : 0) <= 0) {
				itemstack.getOrCreateTag().putDouble("shot", (itemstack.getOrCreateTag().getDouble("shot") - 1));
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), (int) (EnchantmentHelper.getItemEnchantmentLevel(TheDeepVoidModEnchantments.MARKSMAN.get(), itemstack) != 0 ? 8 : 5));
				if (itemstack.getItem() instanceof VehemenceItem)
					itemstack.getOrCreateTag().putString("geckoAnim", "shoot");
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new IronSpikeEntity(TheDeepVoidModEntities.IRON_SPIKE.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								entityToSpawn.setPierceLevel(piercing);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity,
								(float) ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.GUNSLINGER_HELMET.get()
										&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.GUNSLINGER_CHESTPLATE.get()
										&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.GUNSLINGER_LEGGINGS.get()
										&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.GUNSLINGER_BOOTS.get()
												? (double) DeepVoidConfigConfiguration.VEHEMENCE.get() * 1.2
												: (double) DeepVoidConfigConfiguration.VEHEMENCE.get()),
								0, (byte) 99);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 4, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:vehemence_shoot")), SoundSource.PLAYERS, 1,
								Mth.nextInt(RandomSource.create(), (int) 0.99, (int) 1.01));
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:vehemence_shoot")), SoundSource.PLAYERS, 1,
								Mth.nextInt(RandomSource.create(), (int) 0.99, (int) 1.01), false);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:vehemence_open")), SoundSource.PLAYERS, 1, (float) 1.1);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:vehemence_open")), SoundSource.PLAYERS, 1, (float) 1.1, false);
					}
				}
				if (!(EnchantmentHelper.getItemEnchantmentLevel(TheDeepVoidModEnchantments.MARKSMAN.get(), itemstack) != 0)) {
					entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * (-0.25)), 0, (Math.cos(Math.toRadians(entity.getYRot())) * (-0.25))));
				}
			} else if (itemstack.getOrCreateTag().getDouble("shot") <= 0) {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 60);
				itemstack.getOrCreateTag().putDouble("shot", 8);
				if (itemstack.getItem() instanceof VehemenceItem)
					itemstack.getOrCreateTag().putString("geckoAnim", "reload");
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:vehemence_open")), SoundSource.PLAYERS, 1, (float) 1.1);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:vehemence_open")), SoundSource.PLAYERS, 1, (float) 1.1, false);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:vehemence_eject")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:vehemence_eject")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
				TheDeepVoidMod.queueServerWork(35, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:vehemence_insert")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:vehemence_insert")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
				});
				TheDeepVoidMod.queueServerWork(39, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:vehemence_open")), SoundSource.PLAYERS, 1, (float) 0.8);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:vehemence_open")), SoundSource.PLAYERS, 1, (float) 0.8, false);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.phantom.bite")), SoundSource.PLAYERS, 1, (float) 1.4);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.phantom.bite")), SoundSource.PLAYERS, 1, (float) 1.4, false);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:flesh")), SoundSource.PLAYERS, 1, (float) 1.4);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:flesh")), SoundSource.PLAYERS, 1, (float) 1.4, false);
						}
					}
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:void_sickness")))), 5);
				});
			}
		}
	}
}
