package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.IPlantable;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;

public class ArmorAbilityAllSeeingArmorProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).allseeingArmor <= 0) {
			if (!world.isEmptyBlock(BlockPos.containing(x, y - 1, z)) && !((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() instanceof LiquidBlock)
					&& !(world.getBlockState(BlockPos.containing(x, y - 1, z)).getBlock() instanceof IPlantable _plant3 && _plant3.getPlantType(world, BlockPos.containing(x, y - 1, z)) == PlantType.PLAINS)
					&& !(world.getBlockState(BlockPos.containing(x, y - 1, z)).getBlock() instanceof IPlantable _plant4 && _plant4.getPlantType(world, BlockPos.containing(x, y - 1, z)) == PlantType.DESERT)
					&& !(world.getBlockState(BlockPos.containing(x, y - 1, z)).getBlock() instanceof IPlantable _plant5 && _plant5.getPlantType(world, BlockPos.containing(x, y - 1, z)) == PlantType.BEACH)
					&& !(world.getBlockState(BlockPos.containing(x, y - 1, z)).getBlock() instanceof IPlantable _plant6 && _plant6.getPlantType(world, BlockPos.containing(x, y - 1, z)) == PlantType.CAVE)
					&& !(world.getBlockState(BlockPos.containing(x, y - 1, z)).getBlock() instanceof IPlantable _plant7 && _plant7.getPlantType(world, BlockPos.containing(x, y - 1, z)) == PlantType.WATER)
					&& !(world.getBlockState(BlockPos.containing(x, y - 1, z)).getBlock() instanceof IPlantable _plant8 && _plant8.getPlantType(world, BlockPos.containing(x, y - 1, z)) == PlantType.NETHER)
					&& !(world.getBlockState(BlockPos.containing(x, y - 1, z)).getBlock() instanceof IPlantable _plant9 && _plant9.getPlantType(world, BlockPos.containing(x, y - 1, z)) == PlantType.CROP)) {
				{
					double _setval = 12;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.allseeingArmor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.witch.throw")), SoundSource.PLAYERS, 1, (float) 0.8);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.witch.throw")), SoundSource.PLAYERS, 1, (float) 0.8, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.POOF, x, y, z, 8, 0.8, 0.8, 0.8, 0.1);
				entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 1.8), (Math.sin(Math.toRadians(0 - entity.getXRot())) * 1.8), (Math.cos(Math.toRadians(entity.getYRot())) * 1.8)));
			}
		}
	}
}
