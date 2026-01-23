package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class GluttonBlockOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("the_deep_void:glutton_tier1")))) {
			GluttonBlockTier1Procedure.execute(world, x, y, z, entity, "/loot spawn ~ ~ ~ loot the_deep_void:blocks/glutton_tier_1");
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("the_deep_void:glutton_tier2")))) {
			GluttonBlockTier1Procedure.execute(world, x, y, z, entity, "/loot spawn ~ ~ ~ loot the_deep_void:blocks/glutton_tier_2");
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("the_deep_void:glutton_tier3")))) {
			GluttonBlockTier1Procedure.execute(world, x, y, z, entity, "/loot spawn ~ ~ ~ loot the_deep_void:blocks/glutton_tier_3");
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("the_deep_void:glutton_desolate")))) {
			GluttonBlockTier1Procedure.execute(world, x, y, z, entity, "/loot spawn ~ ~ ~ loot the_deep_void:blocks/glutton_desolate_soil");
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("minecraft:soul_fire_base_blocks")))) {
			GluttonBlockTier1Procedure.execute(world, x, y, z, entity, "/loot spawn ~ ~ ~ loot the_deep_void:blocks/glutton_soul_soil");
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("the_deep_void:glutton_end")))) {
			GluttonBlockTier1Procedure.execute(world, x, y, z, entity, "/loot spawn ~ ~ ~ loot the_deep_void:blocks/glutton_end");
		} else if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fox.aggro")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fox.aggro")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.ANGRY_VILLAGER, (x + 0.5), (y + 1), (z + 0.5), 5, 1, 1, 1, 0.1);
		}
	}
}
