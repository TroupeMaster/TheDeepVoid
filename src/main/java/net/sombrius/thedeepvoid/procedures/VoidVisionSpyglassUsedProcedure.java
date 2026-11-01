package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.init.TheDeepVoidModEnchantments;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class VoidVisionSpyglassUsedProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _entUseItem0 ? _entUseItem0.getUseItem() : ItemStack.EMPTY).getItem() == Items.SPYGLASS
				&& EnchantmentHelper.getItemEnchantmentLevel(TheDeepVoidModEnchantments.VOID_VISION.get(), (entity instanceof LivingEntity _entUseItem2 ? _entUseItem2.getUseItem() : ItemStack.EMPTY)) != 0 && (new Object() {
					public Entity func(Entity player, double entityReach) {
						double distance = entityReach * entityReach;
						Vec3 eyePos = player.getEyePosition(1.0f);
						HitResult hitResult = entity.pick(entityReach, 1.0f, false);
						if (hitResult != null && hitResult.getType() != HitResult.Type.MISS) {
							distance = hitResult.getLocation().distanceToSqr(eyePos);
							double blockReach = 5;
							if (distance > blockReach * blockReach) {
								Vec3 pos = hitResult.getLocation();
								hitResult = BlockHitResult.miss(pos, Direction.getNearest(eyePos.x, eyePos.y, eyePos.z), BlockPos.containing(pos));
							}
						}
						Vec3 viewVec = player.getViewVector(1.0F);
						Vec3 toVec = eyePos.add(viewVec.x * entityReach, viewVec.y * entityReach, viewVec.z * entityReach);
						AABB aabb = entity.getBoundingBox().expandTowards(viewVec.scale(entityReach)).inflate(1.0D, 1.0D, 1.0D);
						EntityHitResult entityhitresult = ProjectileUtil.getEntityHitResult(player, eyePos, toVec, aabb, (p_234237_) -> {
							return !p_234237_.isSpectator();
						}, distance);
						if (entityhitresult != null) {
							Entity entity1 = entityhitresult.getEntity();
							Vec3 targetPos = entityhitresult.getLocation();
							double distanceToTarget = eyePos.distanceToSqr(targetPos);
							if (distanceToTarget > distance || distanceToTarget > entityReach * entityReach) {
								hitResult = BlockHitResult.miss(targetPos, Direction.getNearest(viewVec.x, viewVec.y, viewVec.z), BlockPos.containing(targetPos));
							} else if (distanceToTarget < distance) {
								hitResult = entityhitresult;
							}
						}
						if (hitResult.getType() == HitResult.Type.ENTITY) {
							return ((EntityHitResult) hitResult).getEntity();
						}
						return null;
					}
				}.func(entity, 42)) instanceof LivingEntity && !((new Object() {
					public Entity func(Entity player, double entityReach) {
						double distance = entityReach * entityReach;
						Vec3 eyePos = player.getEyePosition(1.0f);
						HitResult hitResult = entity.pick(entityReach, 1.0f, false);
						if (hitResult != null && hitResult.getType() != HitResult.Type.MISS) {
							distance = hitResult.getLocation().distanceToSqr(eyePos);
							double blockReach = 5;
							if (distance > blockReach * blockReach) {
								Vec3 pos = hitResult.getLocation();
								hitResult = BlockHitResult.miss(pos, Direction.getNearest(eyePos.x, eyePos.y, eyePos.z), BlockPos.containing(pos));
							}
						}
						Vec3 viewVec = player.getViewVector(1.0F);
						Vec3 toVec = eyePos.add(viewVec.x * entityReach, viewVec.y * entityReach, viewVec.z * entityReach);
						AABB aabb = entity.getBoundingBox().expandTowards(viewVec.scale(entityReach)).inflate(1.0D, 1.0D, 1.0D);
						EntityHitResult entityhitresult = ProjectileUtil.getEntityHitResult(player, eyePos, toVec, aabb, (p_234237_) -> {
							return !p_234237_.isSpectator();
						}, distance);
						if (entityhitresult != null) {
							Entity entity1 = entityhitresult.getEntity();
							Vec3 targetPos = entityhitresult.getLocation();
							double distanceToTarget = eyePos.distanceToSqr(targetPos);
							if (distanceToTarget > distance || distanceToTarget > entityReach * entityReach) {
								hitResult = BlockHitResult.miss(targetPos, Direction.getNearest(viewVec.x, viewVec.y, viewVec.z), BlockPos.containing(targetPos));
							} else if (distanceToTarget < distance) {
								hitResult = entityhitresult;
							}
						}
						if (hitResult.getType() == HitResult.Type.ENTITY) {
							return ((EntityHitResult) hitResult).getEntity();
						}
						return null;
					}
				}.func(entity, 42)) instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(MobEffects.GLOWING))) {
			if ((new Object() {
				public Entity func(Entity player, double entityReach) {
					double distance = entityReach * entityReach;
					Vec3 eyePos = player.getEyePosition(1.0f);
					HitResult hitResult = entity.pick(entityReach, 1.0f, false);
					if (hitResult != null && hitResult.getType() != HitResult.Type.MISS) {
						distance = hitResult.getLocation().distanceToSqr(eyePos);
						double blockReach = 5;
						if (distance > blockReach * blockReach) {
							Vec3 pos = hitResult.getLocation();
							hitResult = BlockHitResult.miss(pos, Direction.getNearest(eyePos.x, eyePos.y, eyePos.z), BlockPos.containing(pos));
						}
					}
					Vec3 viewVec = player.getViewVector(1.0F);
					Vec3 toVec = eyePos.add(viewVec.x * entityReach, viewVec.y * entityReach, viewVec.z * entityReach);
					AABB aabb = entity.getBoundingBox().expandTowards(viewVec.scale(entityReach)).inflate(1.0D, 1.0D, 1.0D);
					EntityHitResult entityhitresult = ProjectileUtil.getEntityHitResult(player, eyePos, toVec, aabb, (p_234237_) -> {
						return !p_234237_.isSpectator();
					}, distance);
					if (entityhitresult != null) {
						Entity entity1 = entityhitresult.getEntity();
						Vec3 targetPos = entityhitresult.getLocation();
						double distanceToTarget = eyePos.distanceToSqr(targetPos);
						if (distanceToTarget > distance || distanceToTarget > entityReach * entityReach) {
							hitResult = BlockHitResult.miss(targetPos, Direction.getNearest(viewVec.x, viewVec.y, viewVec.z), BlockPos.containing(targetPos));
						} else if (distanceToTarget < distance) {
							hitResult = entityhitresult;
						}
					}
					if (hitResult.getType() == HitResult.Type.ENTITY) {
						return ((EntityHitResult) hitResult).getEntity();
					}
					return null;
				}
			}.func(entity, 42)) instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 240, 0, false, false));
		}
	}
}
