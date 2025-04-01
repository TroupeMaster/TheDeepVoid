package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.level.BlockEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class LightExtinguishProcedureProcedure {
	@SubscribeEvent
	public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (DeepVoidConfigConfiguration.OLDLIGHTSYSTEM.get() == true) {
			if (DeepVoidConfigConfiguration.DESTROYLIGHTSOURCES.get() == true) {
				if (DeepVoidConfigConfiguration.ALLOWSOULLIGHT.get() == true) {
					if (entity.getY() > 0) {
						if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == ResourceKey.create(Registries.DIMENSION,
								new ResourceLocation("the_deep_void:deep_void")) && world.getBlockState(BlockPos.containing(x, y, z)).getLightEmission(world, BlockPos.containing(x, y, z)) > 0
								&& !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.FERRYMAN_LANTERN.get())
								&& !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.FERRYMAN_LANTERN_HANGED.get())
								&& !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.EYE_VINE.get())
								&& !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.GREEN_EYE_VINE.get())
								&& !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.RED_EYE_VINE.get())
								&& !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.YELLOW_EYE_VINE.get())
								&& !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.VOIDLIGHT.get()) && !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.SOUL_TORCH)
								&& !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.SOUL_WALL_TORCH) && !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.SOUL_FIRE)
								&& !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.SOUL_LANTERN) && !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.SOUL_CAMPFIRE)) {
							TheDeepVoidMod.queueServerWork(160, () -> {
								if (world.getBlockState(BlockPos.containing(x, y, z)).getLightEmission(world, BlockPos.containing(x, y, z)) > 0
										&& !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.FERRYMAN_LANTERN.get())
										&& !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.FERRYMAN_LANTERN_HANGED.get())) {
									world.destroyBlock(BlockPos.containing(x, y, z), false);
									world.addParticle(ParticleTypes.SOUL, x, (y + 1), z, 0, 0.4, 0);
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("particle.soul_escape")), SoundSource.AMBIENT, (float) 1.5, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("particle.soul_escape")), SoundSource.AMBIENT, (float) 1.5, 1, false);
										}
									}
								}
							});
							if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty() == false) {
								world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
							}
						}
					}
				} else {
					if (entity.getY() > 0) {
						if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == ResourceKey.create(Registries.DIMENSION,
								new ResourceLocation("the_deep_void:deep_void")) && world.getBlockState(BlockPos.containing(x, y, z)).getLightEmission(world, BlockPos.containing(x, y, z)) > 0
								&& !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.FERRYMAN_LANTERN.get())
								&& !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.FERRYMAN_LANTERN_HANGED.get())
								&& !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.EYE_VINE.get())
								&& !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.GREEN_EYE_VINE.get())
								&& !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.RED_EYE_VINE.get())
								&& !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.YELLOW_EYE_VINE.get())
								&& !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.VOIDLIGHT.get())) {
							TheDeepVoidMod.queueServerWork(160, () -> {
								if (world.getBlockState(BlockPos.containing(x, y, z)).getLightEmission(world, BlockPos.containing(x, y, z)) > 0
										&& !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.FERRYMAN_LANTERN.get())
										&& !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.FERRYMAN_LANTERN_HANGED.get())) {
									world.destroyBlock(BlockPos.containing(x, y, z), false);
									world.addParticle(ParticleTypes.SOUL, x, (y + 1), z, 0, 0.4, 0);
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("particle.soul_escape")), SoundSource.AMBIENT, (float) 1.5, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("particle.soul_escape")), SoundSource.AMBIENT, (float) 1.5, 1, false);
										}
									}
								}
							});
							if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty() == false) {
								world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
							}
						}
					}
				}
			}
		}
	}
}
