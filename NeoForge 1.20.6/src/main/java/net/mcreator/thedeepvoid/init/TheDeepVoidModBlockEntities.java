
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedeepvoid.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.thedeepvoid.block.entity.VoidriumGlassBlockEntity;
import net.mcreator.thedeepvoid.block.entity.SoulOrbPillarBlockEntity;
import net.mcreator.thedeepvoid.block.entity.SoulForgeBlockEntity;
import net.mcreator.thedeepvoid.block.entity.GluttonBlockBlockEntity;
import net.mcreator.thedeepvoid.block.entity.DeepslateSarcophagusBlockEntity;
import net.mcreator.thedeepvoid.block.entity.DeepslateSarcophagusBlockBlockEntity;
import net.mcreator.thedeepvoid.block.entity.BoneCrawlerEggBlockEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class TheDeepVoidModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, TheDeepVoidMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> GLUTTON_BLOCK = register("glutton_block", TheDeepVoidModBlocks.GLUTTON_BLOCK, GluttonBlockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> DEEPSLATE_SARCOPHAGUS = register("deepslate_sarcophagus", TheDeepVoidModBlocks.DEEPSLATE_SARCOPHAGUS, DeepslateSarcophagusBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> DEEPSLATE_SARCOPHAGUS_BLOCK = register("deepslate_sarcophagus_block", TheDeepVoidModBlocks.DEEPSLATE_SARCOPHAGUS_BLOCK, DeepslateSarcophagusBlockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> BONE_CRAWLER_EGG = register("bone_crawler_egg", TheDeepVoidModBlocks.BONE_CRAWLER_EGG, BoneCrawlerEggBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> VOIDRIUM_GLASS = register("voidrium_glass", TheDeepVoidModBlocks.VOIDRIUM_GLASS, VoidriumGlassBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> SOUL_ORB_PILLAR = register("soul_orb_pillar", TheDeepVoidModBlocks.SOUL_ORB_PILLAR, SoulOrbPillarBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> SOUL_FORGE = register("soul_forge", TheDeepVoidModBlocks.SOUL_FORGE, SoulForgeBlockEntity::new);

	private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GLUTTON_BLOCK.get(), (blockEntity, side) -> ((GluttonBlockBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, DEEPSLATE_SARCOPHAGUS.get(), (blockEntity, side) -> ((DeepslateSarcophagusBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, DEEPSLATE_SARCOPHAGUS_BLOCK.get(), (blockEntity, side) -> ((DeepslateSarcophagusBlockBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BONE_CRAWLER_EGG.get(), (blockEntity, side) -> ((BoneCrawlerEggBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, VOIDRIUM_GLASS.get(), (blockEntity, side) -> ((VoidriumGlassBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SOUL_ORB_PILLAR.get(), (blockEntity, side) -> ((SoulOrbPillarBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SOUL_FORGE.get(), (blockEntity, side) -> ((SoulForgeBlockEntity) blockEntity).getItemHandler());
	}
}
