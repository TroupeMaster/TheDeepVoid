package net.mcreator.thedeepvoid;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.util.thread.SidedThreadGroups;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;

import net.mcreator.thedeepvoid.world.features.StructureFeature;
import net.mcreator.thedeepvoid.init.TheDeepVoidModTabs;
import net.mcreator.thedeepvoid.init.TheDeepVoidModSounds;
import net.mcreator.thedeepvoid.init.TheDeepVoidModPotions;
import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;
import net.mcreator.thedeepvoid.init.TheDeepVoidModPaintings;
import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.init.TheDeepVoidModMenus;
import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;
import net.mcreator.thedeepvoid.init.TheDeepVoidModFluids;
import net.mcreator.thedeepvoid.init.TheDeepVoidModFluidTypes;
import net.mcreator.thedeepvoid.init.TheDeepVoidModFeatures;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEnchantments;
import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;
import net.mcreator.thedeepvoid.init.TheDeepVoidModBlockEntities;

import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiConsumer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;
import java.util.AbstractMap;

@Mod("the_deep_void")
public class TheDeepVoidMod {
	public static final Logger LOGGER = LogManager.getLogger(TheDeepVoidMod.class);
	public static final String MODID = "the_deep_void";

	public TheDeepVoidMod() {
		// Start of user code block mod constructor
		// End of user code block mod constructor
		MinecraftForge.EVENT_BUS.register(this);
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		TheDeepVoidModSounds.REGISTRY.register(bus);
		TheDeepVoidModBlocks.REGISTRY.register(bus);
		TheDeepVoidModBlockEntities.REGISTRY.register(bus);
		TheDeepVoidModItems.REGISTRY.register(bus);
		TheDeepVoidModEntities.REGISTRY.register(bus);
		TheDeepVoidModEnchantments.REGISTRY.register(bus);
		TheDeepVoidModTabs.REGISTRY.register(bus);
		TheDeepVoidModFeatures.REGISTRY.register(bus);
		StructureFeature.REGISTRY.register(bus);
		TheDeepVoidModMobEffects.REGISTRY.register(bus);
		TheDeepVoidModPotions.REGISTRY.register(bus);
		TheDeepVoidModPaintings.REGISTRY.register(bus);
		TheDeepVoidModParticleTypes.REGISTRY.register(bus);

		TheDeepVoidModMenus.REGISTRY.register(bus);
		TheDeepVoidModFluids.REGISTRY.register(bus);
		TheDeepVoidModFluidTypes.REGISTRY.register(bus);
		// Start of user code block mod init
		// End of user code block mod init
	}

	// Start of user code block mod methods
	// End of user code block mod methods
	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(MODID, MODID), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	private static int messageID = 0;

	public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
		PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
		messageID++;
	}

	private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

	public static void queueServerWork(int tick, Runnable action) {
		if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
			workQueue.add(new AbstractMap.SimpleEntry<>(action, tick));
	}

	@SubscribeEvent
	public void tick(TickEvent.ServerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
			workQueue.forEach(work -> {
				work.setValue(work.getValue() - 1);
				if (work.getValue() == 0)
					actions.add(work);
			});
			actions.forEach(e -> e.getKey().run());
			workQueue.removeAll(actions);
		}
	}
}
