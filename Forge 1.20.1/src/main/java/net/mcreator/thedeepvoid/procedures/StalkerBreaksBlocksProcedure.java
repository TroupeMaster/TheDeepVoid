package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.entity.StalkerEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class StalkerBreaksBlocksProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (DeepVoidConfigConfiguration.STALKERBREAKSBLOCKS.get() == true) {
			if (entity instanceof StalkerEntity) {
				if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
					if (entity.getPersistentData().getDouble("deep_void:break_block") >= 10) {
						entity.getPersistentData().putDouble("deep_void:break_block", 0);
						if ((world.getBlockState(BlockPos.containing(entity.getX() + 1, entity.getY(), entity.getZ()))).is(BlockTags.create(new ResourceLocation("the_deep_void:breakable")))) {
							{
								BlockPos _pos = BlockPos.containing(entity.getX() + 1, entity.getY(), entity.getZ());
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX() + 1, entity.getY(), entity.getZ()), null);
								world.destroyBlock(_pos, false);
							}
							if ((world.getBlockState(BlockPos.containing(entity.getX() + 1, entity.getY() + 1, entity.getZ()))).is(BlockTags.create(new ResourceLocation("the_deep_void:breakable")))) {
								{
									BlockPos _pos = BlockPos.containing(entity.getX() + 1, entity.getY() + 1, entity.getZ());
									Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX() + 1, entity.getY() + 1, entity.getZ()), null);
									world.destroyBlock(_pos, false);
								}
							}
						}
						if ((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 1))).is(BlockTags.create(new ResourceLocation("the_deep_void:breakable")))) {
							{
								BlockPos _pos = BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 1);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 1), null);
								world.destroyBlock(_pos, false);
							}
							if ((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ() + 1))).is(BlockTags.create(new ResourceLocation("the_deep_void:breakable")))) {
								{
									BlockPos _pos = BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ() + 1);
									Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ() + 1), null);
									world.destroyBlock(_pos, false);
								}
							}
						}
						if ((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() - 1))).is(BlockTags.create(new ResourceLocation("the_deep_void:breakable")))) {
							{
								BlockPos _pos = BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() - 1);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() - 1), null);
								world.destroyBlock(_pos, false);
							}
							if ((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ() - 1))).is(BlockTags.create(new ResourceLocation("the_deep_void:breakable")))) {
								{
									BlockPos _pos = BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ() - 1);
									Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ() - 1), null);
									world.destroyBlock(_pos, false);
								}
							}
						}
						if ((world.getBlockState(BlockPos.containing(entity.getX() - 1, entity.getY(), entity.getZ()))).is(BlockTags.create(new ResourceLocation("the_deep_void:breakable")))) {
							{
								BlockPos _pos = BlockPos.containing(entity.getX() - 1, entity.getY(), entity.getZ());
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX() - 1, entity.getY(), entity.getZ()), null);
								world.destroyBlock(_pos, false);
							}
							if ((world.getBlockState(BlockPos.containing(entity.getX() - 1, entity.getY() + 1, entity.getZ()))).is(BlockTags.create(new ResourceLocation("the_deep_void:breakable")))) {
								{
									BlockPos _pos = BlockPos.containing(entity.getX() - 1, entity.getY() + 1, entity.getZ());
									Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX() - 1, entity.getY() + 1, entity.getZ()), null);
									world.destroyBlock(_pos, false);
								}
							}
						}
						if ((world.getBlockState(BlockPos.containing(entity.getX() - 1, entity.getY(), entity.getZ() - 1))).is(BlockTags.create(new ResourceLocation("the_deep_void:breakable")))) {
							{
								BlockPos _pos = BlockPos.containing(entity.getX() - 1, entity.getY(), entity.getZ() - 1);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX() - 1, entity.getY(), entity.getZ() - 1), null);
								world.destroyBlock(_pos, false);
							}
							if ((world.getBlockState(BlockPos.containing(entity.getX() - 1, entity.getY() + 1, entity.getZ() - 1))).is(BlockTags.create(new ResourceLocation("the_deep_void:breakable")))) {
								{
									BlockPos _pos = BlockPos.containing(entity.getX() - 1, entity.getY() + 1, entity.getZ() - 1);
									Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX() - 1, entity.getY() + 1, entity.getZ() - 1), null);
									world.destroyBlock(_pos, false);
								}
							}
						}
						if ((world.getBlockState(BlockPos.containing(entity.getX() + 1, entity.getY(), entity.getZ() + 1))).is(BlockTags.create(new ResourceLocation("the_deep_void:breakable")))) {
							{
								BlockPos _pos = BlockPos.containing(entity.getX() + 1, entity.getY(), entity.getZ() + 1);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX() + 1, entity.getY(), entity.getZ() + 1), null);
								world.destroyBlock(_pos, false);
							}
							if ((world.getBlockState(BlockPos.containing(entity.getX() + 1, entity.getY() + 1, entity.getZ() + 1))).is(BlockTags.create(new ResourceLocation("the_deep_void:breakable")))) {
								{
									BlockPos _pos = BlockPos.containing(entity.getX() + 1, entity.getY() + 1, entity.getZ() + 1);
									Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX() + 1, entity.getY() + 1, entity.getZ() + 1), null);
									world.destroyBlock(_pos, false);
								}
							}
						}
						if ((world.getBlockState(BlockPos.containing(entity.getX() - 1, entity.getY(), entity.getZ() + 1))).is(BlockTags.create(new ResourceLocation("the_deep_void:breakable")))) {
							{
								BlockPos _pos = BlockPos.containing(entity.getX() - 1, entity.getY(), entity.getZ() + 1);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX() - 1, entity.getY(), entity.getZ() + 1), null);
								world.destroyBlock(_pos, false);
							}
							if ((world.getBlockState(BlockPos.containing(entity.getX() - 1, entity.getY() + 1, entity.getZ() + 1))).is(BlockTags.create(new ResourceLocation("the_deep_void:breakable")))) {
								{
									BlockPos _pos = BlockPos.containing(entity.getX() - 1, entity.getY() + 1, entity.getZ() + 1);
									Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX() - 1, entity.getY() + 1, entity.getZ() + 1), null);
									world.destroyBlock(_pos, false);
								}
							}
						}
						if ((world.getBlockState(BlockPos.containing(entity.getX() + 1, entity.getY(), entity.getZ() - 1))).is(BlockTags.create(new ResourceLocation("the_deep_void:breakable")))) {
							{
								BlockPos _pos = BlockPos.containing(entity.getX() + 1, entity.getY(), entity.getZ() - 1);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX() + 1, entity.getY(), entity.getZ() - 1), null);
								world.destroyBlock(_pos, false);
							}
							if ((world.getBlockState(BlockPos.containing(entity.getX() + 1, entity.getY() + 1, entity.getZ() - 1))).is(BlockTags.create(new ResourceLocation("the_deep_void:breakable")))) {
								{
									BlockPos _pos = BlockPos.containing(entity.getX() + 1, entity.getY() + 1, entity.getZ() - 1);
									Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX() + 1, entity.getY() + 1, entity.getZ() - 1), null);
									world.destroyBlock(_pos, false);
								}
							}
						}
					} else {
						entity.getPersistentData().putDouble("deep_void:break_block", (entity.getPersistentData().getDouble("deep_void:break_block") + 1));
					}
				}
			}
		}
	}
}
