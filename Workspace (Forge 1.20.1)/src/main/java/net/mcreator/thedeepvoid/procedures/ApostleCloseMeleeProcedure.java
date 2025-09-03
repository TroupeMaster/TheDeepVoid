package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.thedeepvoid.entity.ApostleOfCatastropheEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class ApostleCloseMeleeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ApostleOfCatastropheEntity) {
			if (entity.getPersistentData().getBoolean("deep_void:spinning") == false && entity.getPersistentData().getBoolean("deep_void:shooting") == false && entity.getPersistentData().getBoolean("deep_void:slashing") == false
					&& entity.getPersistentData().getBoolean("deep_void:noEscape") == false && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
				if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
					if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 3, 3, 3), e -> true).isEmpty()) {
						if (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 3, 3, 3), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
							if (entity.getPersistentData().getBoolean("deep_void:doingCloseMelee") == false) {
								if (Math.random() < 0.1) {
									entity.getPersistentData().putBoolean("deep_void:doingCloseMelee", true);
									entity.lookAt(EntityAnchorArgument.Anchor.EYES,
											new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), y, ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
									if (entity instanceof ApostleOfCatastropheEntity) {
										((ApostleOfCatastropheEntity) entity).setAnimation("animation.apostle_melee");
									}
									TheDeepVoidMod.queueServerWork(8, () -> {
										entity.getPersistentData().putBoolean("deep_void:doingCloseMelee", false);
										{
											final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
											List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
													.toList();
											for (Entity entityiterator : _entfound) {
												if (entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
													if ((entityiterator instanceof LivingEntity _entUseItem26 ? _entUseItem26.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem) {
														{
															ItemStack _ist = (entityiterator instanceof LivingEntity _entUseItem28 ? _entUseItem28.getUseItem() : ItemStack.EMPTY);
															if (_ist.hurt(25, RandomSource.create(), null)) {
																_ist.shrink(1);
																_ist.setDamageValue(0);
															}
														}
														if (entityiterator instanceof Player _player)
															_player.getCooldowns().addCooldown((entityiterator instanceof LivingEntity _entUseItem30 ? _entUseItem30.getUseItem() : ItemStack.EMPTY).getItem(), 60);
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
																		ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")), SoundSource.PLAYERS, 1, 1);
															} else {
																_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")),
																		SoundSource.PLAYERS, 1, 1, false);
															}
														}
													} else {
														entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity), 10);
													}
												}
											}
										}
									});
								}
							}
						}
					}
				}
			}
		}
	}
}
