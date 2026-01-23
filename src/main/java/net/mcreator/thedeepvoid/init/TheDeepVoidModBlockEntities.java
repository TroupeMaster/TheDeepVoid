
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedeepvoid.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.thedeepvoid.block.entity.WatcherOnBlockEntity;
import net.mcreator.thedeepvoid.block.entity.VoidriumSawTrapBlockEntity;
import net.mcreator.thedeepvoid.block.entity.VoidriumGlassBlockEntity;
import net.mcreator.thedeepvoid.block.entity.SoulOrbPillarBlockEntity;
import net.mcreator.thedeepvoid.block.entity.SoulForgeBlockEntity;
import net.mcreator.thedeepvoid.block.entity.InfestedBoneCrawlerEggBlockEntity;
import net.mcreator.thedeepvoid.block.entity.GluttonBlockBlockEntity;
import net.mcreator.thedeepvoid.block.entity.DeepslateSarcophagusBlockEntity;
import net.mcreator.thedeepvoid.block.entity.DeepslateSarcophagusBlockBlockEntity;
import net.mcreator.thedeepvoid.block.entity.BoneCrawlerEggBlockEntity;
import net.mcreator.thedeepvoid.block.entity.AncientPotBlockBlockEntity;
import net.mcreator.thedeepvoid.block.entity.AncientDeepslateSawTrapBlockEntity;
import net.mcreator.thedeepvoid.block.entity.AncientDeepslateDartTrapBlockEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class TheDeepVoidModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TheDeepVoidMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> GLUTTON_BLOCK = register("glutton_block", TheDeepVoidModBlocks.GLUTTON_BLOCK, GluttonBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> DEEPSLATE_SARCOPHAGUS = register("deepslate_sarcophagus", TheDeepVoidModBlocks.DEEPSLATE_SARCOPHAGUS, DeepslateSarcophagusBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> DEEPSLATE_SARCOPHAGUS_BLOCK = register("deepslate_sarcophagus_block", TheDeepVoidModBlocks.DEEPSLATE_SARCOPHAGUS_BLOCK, DeepslateSarcophagusBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BONE_CRAWLER_EGG = register("bone_crawler_egg", TheDeepVoidModBlocks.BONE_CRAWLER_EGG, BoneCrawlerEggBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> VOIDRIUM_GLASS = register("voidrium_glass", TheDeepVoidModBlocks.VOIDRIUM_GLASS, VoidriumGlassBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SOUL_ORB_PILLAR = register("soul_orb_pillar", TheDeepVoidModBlocks.SOUL_ORB_PILLAR, SoulOrbPillarBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SOUL_FORGE = register("soul_forge", TheDeepVoidModBlocks.SOUL_FORGE, SoulForgeBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ANCIENT_POT_BLOCK = register("ancient_pot_block", TheDeepVoidModBlocks.ANCIENT_POT_BLOCK, AncientPotBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WATCHER_ON = register("watcher_on", TheDeepVoidModBlocks.WATCHER_ON, WatcherOnBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ANCIENT_DEEPSLATE_SAW_TRAP = register("ancient_deepslate_saw_trap", TheDeepVoidModBlocks.ANCIENT_DEEPSLATE_SAW_TRAP, AncientDeepslateSawTrapBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> VOIDRIUM_SAW_TRAP = register("voidrium_saw_trap", TheDeepVoidModBlocks.VOIDRIUM_SAW_TRAP, VoidriumSawTrapBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ANCIENT_DEEPSLATE_DART_TRAP = register("ancient_deepslate_dart_trap", TheDeepVoidModBlocks.ANCIENT_DEEPSLATE_DART_TRAP, AncientDeepslateDartTrapBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> INFESTED_BONE_CRAWLER_EGG = register("infested_bone_crawler_egg", TheDeepVoidModBlocks.INFESTED_BONE_CRAWLER_EGG, InfestedBoneCrawlerEggBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
