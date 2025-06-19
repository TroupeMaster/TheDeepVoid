package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;
import net.mcreator.thedeepvoid.entity.MisanthropicHivemindEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.ArrayList;

public class HivemindPlayerCountProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof MisanthropicHivemindEntity) {
			((MisanthropicHivemindEntity) entity).setAnimation("animation.hivemind_emerge");
		}
		TheDeepVoidMod.queueServerWork(10, () -> {
			world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(TheDeepVoidModBlocks.FLESH_BLOCK.get().defaultBlockState()));
		});
		TheDeepVoidMod.queueServerWork(20, () -> {
			world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(TheDeepVoidModBlocks.FLESH_BLOCK.get().defaultBlockState()));
		});
		TheDeepVoidMod.queueServerWork(30, () -> {
			world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(TheDeepVoidModBlocks.FLESH_BLOCK.get().defaultBlockState()));
		});
		TheDeepVoidMod.queueServerWork(40, () -> {
			world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(TheDeepVoidModBlocks.FLESH_BLOCK.get().defaultBlockState()));
		});
		if (world.players().size() > 1) {
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				entity.getPersistentData().putDouble("deep_void:playerCount", (entity.getPersistentData().getDouble("deep_void:playerCount") + 1));
			}
		}
		if (entity.getPersistentData().getDouble("deep_void:playerCount") > 1) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, (int) Double.POSITIVE_INFINITY, (int) (entity.getPersistentData().getDouble("deep_void:playerCount") * 16), false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 5, 200, false, false));
		}
		if (entity.getPersistentData().getDouble("deep_void:playerCount") > 3) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, (int) Double.POSITIVE_INFINITY, 0, false, false));
		}
		entity.getPersistentData().putDouble("deep_void:startingX", x);
		entity.getPersistentData().putDouble("deep_void:startingY", (y - 1));
		entity.getPersistentData().putDouble("deep_void:startingZ", z);
	}
}
