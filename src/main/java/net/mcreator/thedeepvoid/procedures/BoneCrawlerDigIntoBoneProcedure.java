package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;
import net.mcreator.thedeepvoid.entity.BoneCrawlerEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class BoneCrawlerDigIntoBoneProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("the_deep_void:natural_bone_block")))
				&& !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty()) && (entity instanceof BoneCrawlerEntity _datEntL3 && _datEntL3.getEntityData().get(BoneCrawlerEntity.DATA_dig)) == false) {
			if (entity instanceof BoneCrawlerEntity _datEntSetL)
				_datEntSetL.getEntityData().set(BoneCrawlerEntity.DATA_dig, true);
			if (entity instanceof BoneCrawlerEntity) {
				((BoneCrawlerEntity) entity).setAnimation("animation.boneCrawler_dig");
			}
			TheDeepVoidMod.queueServerWork(20, () -> {
				if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty())) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, (int) Double.POSITIVE_INFINITY, 0, false, false));
				}
			});
		} else if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("the_deep_void:natural_bone_block")))
				&& !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty() && (entity instanceof BoneCrawlerEntity _datEntL12 && _datEntL12.getEntityData().get(BoneCrawlerEntity.DATA_dig)) == true) {
			if (entity instanceof BoneCrawlerEntity _datEntSetL)
				_datEntSetL.getEntityData().set(BoneCrawlerEntity.DATA_dig, false);
			if (entity instanceof BoneCrawlerEntity) {
				((BoneCrawlerEntity) entity).setAnimation("animation.boneCrawler_out");
			}
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.INVISIBILITY);
		}
		if (entity instanceof LivingEntity _livEnt16 && _livEnt16.hasEffect(MobEffects.INVISIBILITY)) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.BROKEN_BONE.get()), x, y, z, 2, 0.1, 0.1, 0.1, 0.1);
		}
	}
}
