package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.thedeepvoid.entity.XrayEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class XrayOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((x + 1), y, z));
		if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(MobEffects.GLOWING))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, (int) Double.POSITIVE_INFINITY, 0, false, false));
		}
		if (!(world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("forge:ores"))) && !(world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("the_deep_void:ores")))) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("forge:ores"))) || (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("the_deep_void:ores")))) {
			TheDeepVoidMod.queueServerWork(200, () -> {
				if (!world.getEntitiesOfClass(XrayEntity.class, AABB.ofSize(new Vec3(x, y, z), 1, 1, 1), e -> true).isEmpty()) {
					if (!entity.level().isClientSide())
						entity.discard();
				}
			});
		}
	}
}
