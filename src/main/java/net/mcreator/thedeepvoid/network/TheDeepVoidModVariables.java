package net.mcreator.thedeepvoid.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TheDeepVoidModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		TheDeepVoidMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		TheDeepVoidMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.StalkerCount = original.StalkerCount;
			clone.ForgottenValleyAmbientSound = original.ForgottenValleyAmbientSound;
			clone.StalkerSpawn = original.StalkerSpawn;
			clone.StalkerCountFinish = original.StalkerCountFinish;
			clone.hallucinate = original.hallucinate;
			clone.StalkerStalkCount = original.StalkerStalkCount;
			clone.VoidCaveAmbientSound = original.VoidCaveAmbientSound;
			clone.InCreative = original.InCreative;
			clone.InAdventure = original.InAdventure;
			clone.cave_tremble = original.cave_tremble;
			clone.seek_light = original.seek_light;
			clone.playerCallOfTheVoid = original.playerCallOfTheVoid;
			clone.InSurvival = original.InSurvival;
			clone.SendToHell = original.SendToHell;
			clone.randomStalkerValue = original.randomStalkerValue;
			clone.stalkingCount = original.stalkingCount;
			clone.stalkWatcherCount = original.stalkWatcherCount;
			clone.noGravity = original.noGravity;
			clone.teleportToVoid = original.teleportToVoid;
			clone.hiveCallX = original.hiveCallX;
			clone.hiveCallY = original.hiveCallY;
			clone.hiveCallZ = original.hiveCallZ;
			clone.saveArmor3 = original.saveArmor3;
			clone.saveArmor2 = original.saveArmor2;
			clone.saveArmor1 = original.saveArmor1;
			clone.saveArmor0 = original.saveArmor0;
			clone.saveArmorPoint = original.saveArmorPoint;
			clone.MusicTick = original.MusicTick;
			clone.MusicWait = original.MusicWait;
			clone.MusicLock = original.MusicLock;
			clone.MusicReplace = original.MusicReplace;
			clone.MusicPlay = original.MusicPlay;
			clone.watcherFightCount = original.watcherFightCount;
			clone.sendToPurgatory = original.sendToPurgatory;
			clone.receivedWikiBook = original.receivedWikiBook;
			clone.saveArmorToughness = original.saveArmorToughness;
			clone.saveKnockbackResistance = original.saveKnockbackResistance;
			clone.saveStepHeight = original.saveStepHeight;
			clone.parasitizedType = original.parasitizedType;
			if (!event.isWasDeath()) {
				clone.playerX = original.playerX;
				clone.playerY = original.playerY;
				clone.playerZ = original.playerZ;
				clone.RottenArmorAbility = original.RottenArmorAbility;
				clone.VoidCloakAbility = original.VoidCloakAbility;
				clone.darkness_absorption = original.darkness_absorption;
				clone.hallucinating = original.hallucinating;
				clone.deathgrounds_ambience = original.deathgrounds_ambience;
				clone.flesh_roar = original.flesh_roar;
				clone.armorToggle = original.armorToggle;
				clone.monolithAmbience = original.monolithAmbience;
				clone.hasteAllSeeing = original.hasteAllSeeing;
				clone.allseeingArmor = original.allseeingArmor;
				clone.hallucinateX = original.hallucinateX;
				clone.hallucinateY = original.hallucinateY;
				clone.hallucinateZ = original.hallucinateZ;
				clone.soundHallX = original.soundHallX;
				clone.soundHallY = original.soundHallY;
				clone.soundHallZ = original.soundHallZ;
				clone.hallucinateHurt = original.hallucinateHurt;
				clone.nestAmbience = original.nestAmbience;
				clone.darknessDamageBuildUp = original.darknessDamageBuildUp;
				clone.motherCallOutCooldown = original.motherCallOutCooldown;
				clone.motherlyCallCooldown = original.motherlyCallCooldown;
				clone.FallSound = original.FallSound;
				clone.healthBoostLevel = original.healthBoostLevel;
				clone.healthMask = original.healthMask;
				clone.grimRottenArmorAttack = original.grimRottenArmorAttack;
				clone.naturalTeleport = original.naturalTeleport;
				clone.weaverBoots = original.weaverBoots;
				clone.heartbeatIndicator = original.heartbeatIndicator;
				clone.hasSoulOrb = original.hasSoulOrb;
				clone.weaverRobeCooldown = original.weaverRobeCooldown;
				clone.gatheringAmbience = original.gatheringAmbience;
				clone.attackedByAnimosity = original.attackedByAnimosity;
				clone.eyekinCooldown = original.eyekinCooldown;
				clone.eyekinDash = original.eyekinDash;
				clone.wingFlapSound = original.wingFlapSound;
				clone.hookX = original.hookX;
				clone.hookY = original.hookY;
				clone.hookZ = original.hookZ;
				clone.hooked = original.hooked;
				clone.voidriumTeleport = original.voidriumTeleport;
				clone.noEscape = original.noEscape;
				clone.hunterArmorAbility = original.hunterArmorAbility;
				clone.mistedRemnantAmbience = original.mistedRemnantAmbience;
				clone.gaol_ambience = original.gaol_ambience;
				clone.noHit = original.noHit;
				clone.vultureArmorAbility = original.vultureArmorAbility;
				clone.gunslingerArmorAbility = original.gunslingerArmorAbility;
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					TheDeepVoidMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					TheDeepVoidMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					TheDeepVoidMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "the_deep_void_worldvars";

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				TheDeepVoidMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "the_deep_void_mapvars";
		public boolean CultTemplePlaced = false;
		public boolean StalkerDespawned = false;
		public double breathingHillsAmbience = 0;
		public double breathingHillsHeart = 0;
		public boolean WeaverTemplePlaced = false;
		public double stalkerSpawnX = 0;
		public double stalkerSpawnZ = 0;
		public double weaverFightCount = 0;
		public boolean overwritten = false;
		public boolean surfaceOverwritten = false;
		public double apostleFightCount = 0;
		public double hivemindFightCount = 0;
		public double primordialcrawlerFightCount = 0;
		public double hunterSpawnCooldown = 72000.0;

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			CultTemplePlaced = nbt.getBoolean("CultTemplePlaced");
			StalkerDespawned = nbt.getBoolean("StalkerDespawned");
			breathingHillsAmbience = nbt.getDouble("breathingHillsAmbience");
			breathingHillsHeart = nbt.getDouble("breathingHillsHeart");
			WeaverTemplePlaced = nbt.getBoolean("WeaverTemplePlaced");
			stalkerSpawnX = nbt.getDouble("stalkerSpawnX");
			stalkerSpawnZ = nbt.getDouble("stalkerSpawnZ");
			weaverFightCount = nbt.getDouble("weaverFightCount");
			overwritten = nbt.getBoolean("overwritten");
			surfaceOverwritten = nbt.getBoolean("surfaceOverwritten");
			apostleFightCount = nbt.getDouble("apostleFightCount");
			hivemindFightCount = nbt.getDouble("hivemindFightCount");
			primordialcrawlerFightCount = nbt.getDouble("primordialcrawlerFightCount");
			hunterSpawnCooldown = nbt.getDouble("hunterSpawnCooldown");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putBoolean("CultTemplePlaced", CultTemplePlaced);
			nbt.putBoolean("StalkerDespawned", StalkerDespawned);
			nbt.putDouble("breathingHillsAmbience", breathingHillsAmbience);
			nbt.putDouble("breathingHillsHeart", breathingHillsHeart);
			nbt.putBoolean("WeaverTemplePlaced", WeaverTemplePlaced);
			nbt.putDouble("stalkerSpawnX", stalkerSpawnX);
			nbt.putDouble("stalkerSpawnZ", stalkerSpawnZ);
			nbt.putDouble("weaverFightCount", weaverFightCount);
			nbt.putBoolean("overwritten", overwritten);
			nbt.putBoolean("surfaceOverwritten", surfaceOverwritten);
			nbt.putDouble("apostleFightCount", apostleFightCount);
			nbt.putDouble("hivemindFightCount", hivemindFightCount);
			nbt.putDouble("primordialcrawlerFightCount", primordialcrawlerFightCount);
			nbt.putDouble("hunterSpawnCooldown", hunterSpawnCooldown);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				TheDeepVoidMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		private final int type;
		private SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			if (nbt != null) {
				this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
				if (this.data instanceof MapVariables mapVariables)
					mapVariables.read(nbt);
				else if (this.data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt);
			}
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("the_deep_void", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double StalkerCount = 0.0;
		public double ForgottenValleyAmbientSound = 0;
		public boolean StalkerSpawn = false;
		public boolean StalkerCountFinish = false;
		public double playerX = 0;
		public double playerY = 0;
		public double playerZ = 0;
		public double RottenArmorAbility = 0;
		public double hallucinate = 0;
		public double StalkerStalkCount = 0;
		public double VoidCaveAmbientSound = 0;
		public double VoidCloakAbility = 0;
		public boolean InCreative = false;
		public boolean InAdventure = false;
		public double cave_tremble = 0;
		public double darkness_absorption = 0;
		public boolean seek_light = false;
		public boolean playerCallOfTheVoid = false;
		public boolean hallucinating = false;
		public double deathgrounds_ambience = 0;
		public double flesh_roar = 0;
		public boolean armorToggle = false;
		public double monolithAmbience = 0;
		public double hasteAllSeeing = 0;
		public double allseeingArmor = 0;
		public double hallucinateX = 0;
		public double hallucinateY = 0;
		public double hallucinateZ = 0;
		public double soundHallX = 0;
		public double soundHallY = 0;
		public double soundHallZ = 0;
		public double hallucinateHurt = 0;
		public double nestAmbience = 0;
		public boolean InSurvival = false;
		public double darknessDamageBuildUp = 0;
		public double motherCallOutCooldown = 0;
		public double motherlyCallCooldown = 0;
		public boolean FallSound = false;
		public double healthBoostLevel = 0;
		public double healthMask = 0;
		public boolean grimRottenArmorAttack = false;
		public boolean SendToHell = false;
		public boolean naturalTeleport = false;
		public double weaverBoots = 0;
		public double randomStalkerValue = 0;
		public double stalkingCount = 0;
		public double stalkWatcherCount = 0;
		public boolean noGravity = false;
		public double heartbeatIndicator = 0;
		public boolean hasSoulOrb = false;
		public boolean teleportToVoid = false;
		public double weaverRobeCooldown = 0;
		public double gatheringAmbience = 0;
		public boolean attackedByAnimosity = false;
		public double eyekinCooldown = 0;
		public double eyekinDash = 0;
		public double wingFlapSound = 0;
		public double hookX = 0;
		public double hookY = 0;
		public double hookZ = 0;
		public boolean hooked = false;
		public double voidriumTeleport = 0;
		public boolean noEscape = false;
		public double hiveCallX = 0;
		public double hiveCallY = 0;
		public double hiveCallZ = 0;
		public double hunterArmorAbility = 0.0;
		public double mistedRemnantAmbience = 0;
		public ItemStack saveArmor3 = ItemStack.EMPTY;
		public ItemStack saveArmor2 = ItemStack.EMPTY;
		public ItemStack saveArmor1 = ItemStack.EMPTY;
		public ItemStack saveArmor0 = ItemStack.EMPTY;
		public double saveArmorPoint = 0;
		public double gaol_ambience = 0.0;
		public boolean noHit = true;
		public double MusicTick = 0.0;
		public double MusicWait = 0;
		public boolean MusicLock = false;
		public boolean MusicReplace = false;
		public String MusicPlay = "\"\"";
		public double watcherFightCount = 0;
		public boolean sendToPurgatory = false;
		public boolean receivedWikiBook = false;
		public double saveArmorToughness = 0;
		public double saveKnockbackResistance = 0;
		public double saveStepHeight = 0;
		public double parasitizedType = 0;
		public double vultureArmorAbility = 0;
		public double gunslingerArmorAbility = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				TheDeepVoidMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("StalkerCount", StalkerCount);
			nbt.putDouble("ForgottenValleyAmbientSound", ForgottenValleyAmbientSound);
			nbt.putBoolean("StalkerSpawn", StalkerSpawn);
			nbt.putBoolean("StalkerCountFinish", StalkerCountFinish);
			nbt.putDouble("playerX", playerX);
			nbt.putDouble("playerY", playerY);
			nbt.putDouble("playerZ", playerZ);
			nbt.putDouble("RottenArmorAbility", RottenArmorAbility);
			nbt.putDouble("hallucinate", hallucinate);
			nbt.putDouble("StalkerStalkCount", StalkerStalkCount);
			nbt.putDouble("VoidCaveAmbientSound", VoidCaveAmbientSound);
			nbt.putDouble("VoidCloakAbility", VoidCloakAbility);
			nbt.putBoolean("InCreative", InCreative);
			nbt.putBoolean("InAdventure", InAdventure);
			nbt.putDouble("cave_tremble", cave_tremble);
			nbt.putDouble("darkness_absorption", darkness_absorption);
			nbt.putBoolean("seek_light", seek_light);
			nbt.putBoolean("playerCallOfTheVoid", playerCallOfTheVoid);
			nbt.putBoolean("hallucinating", hallucinating);
			nbt.putDouble("deathgrounds_ambience", deathgrounds_ambience);
			nbt.putDouble("flesh_roar", flesh_roar);
			nbt.putBoolean("armorToggle", armorToggle);
			nbt.putDouble("monolithAmbience", monolithAmbience);
			nbt.putDouble("hasteAllSeeing", hasteAllSeeing);
			nbt.putDouble("allseeingArmor", allseeingArmor);
			nbt.putDouble("hallucinateX", hallucinateX);
			nbt.putDouble("hallucinateY", hallucinateY);
			nbt.putDouble("hallucinateZ", hallucinateZ);
			nbt.putDouble("soundHallX", soundHallX);
			nbt.putDouble("soundHallY", soundHallY);
			nbt.putDouble("soundHallZ", soundHallZ);
			nbt.putDouble("hallucinateHurt", hallucinateHurt);
			nbt.putDouble("nestAmbience", nestAmbience);
			nbt.putBoolean("InSurvival", InSurvival);
			nbt.putDouble("darknessDamageBuildUp", darknessDamageBuildUp);
			nbt.putDouble("motherCallOutCooldown", motherCallOutCooldown);
			nbt.putDouble("motherlyCallCooldown", motherlyCallCooldown);
			nbt.putBoolean("FallSound", FallSound);
			nbt.putDouble("healthBoostLevel", healthBoostLevel);
			nbt.putDouble("healthMask", healthMask);
			nbt.putBoolean("grimRottenArmorAttack", grimRottenArmorAttack);
			nbt.putBoolean("SendToHell", SendToHell);
			nbt.putBoolean("naturalTeleport", naturalTeleport);
			nbt.putDouble("weaverBoots", weaverBoots);
			nbt.putDouble("randomStalkerValue", randomStalkerValue);
			nbt.putDouble("stalkingCount", stalkingCount);
			nbt.putDouble("stalkWatcherCount", stalkWatcherCount);
			nbt.putBoolean("noGravity", noGravity);
			nbt.putDouble("heartbeatIndicator", heartbeatIndicator);
			nbt.putBoolean("hasSoulOrb", hasSoulOrb);
			nbt.putBoolean("teleportToVoid", teleportToVoid);
			nbt.putDouble("weaverRobeCooldown", weaverRobeCooldown);
			nbt.putDouble("gatheringAmbience", gatheringAmbience);
			nbt.putBoolean("attackedByAnimosity", attackedByAnimosity);
			nbt.putDouble("eyekinCooldown", eyekinCooldown);
			nbt.putDouble("eyekinDash", eyekinDash);
			nbt.putDouble("wingFlapSound", wingFlapSound);
			nbt.putDouble("hookX", hookX);
			nbt.putDouble("hookY", hookY);
			nbt.putDouble("hookZ", hookZ);
			nbt.putBoolean("hooked", hooked);
			nbt.putDouble("voidriumTeleport", voidriumTeleport);
			nbt.putBoolean("noEscape", noEscape);
			nbt.putDouble("hiveCallX", hiveCallX);
			nbt.putDouble("hiveCallY", hiveCallY);
			nbt.putDouble("hiveCallZ", hiveCallZ);
			nbt.putDouble("hunterArmorAbility", hunterArmorAbility);
			nbt.putDouble("mistedRemnantAmbience", mistedRemnantAmbience);
			nbt.put("saveArmor3", saveArmor3.save(new CompoundTag()));
			nbt.put("saveArmor2", saveArmor2.save(new CompoundTag()));
			nbt.put("saveArmor1", saveArmor1.save(new CompoundTag()));
			nbt.put("saveArmor0", saveArmor0.save(new CompoundTag()));
			nbt.putDouble("saveArmorPoint", saveArmorPoint);
			nbt.putDouble("gaol_ambience", gaol_ambience);
			nbt.putBoolean("noHit", noHit);
			nbt.putDouble("MusicTick", MusicTick);
			nbt.putDouble("MusicWait", MusicWait);
			nbt.putBoolean("MusicLock", MusicLock);
			nbt.putBoolean("MusicReplace", MusicReplace);
			nbt.putString("MusicPlay", MusicPlay);
			nbt.putDouble("watcherFightCount", watcherFightCount);
			nbt.putBoolean("sendToPurgatory", sendToPurgatory);
			nbt.putBoolean("receivedWikiBook", receivedWikiBook);
			nbt.putDouble("saveArmorToughness", saveArmorToughness);
			nbt.putDouble("saveKnockbackResistance", saveKnockbackResistance);
			nbt.putDouble("saveStepHeight", saveStepHeight);
			nbt.putDouble("parasitizedType", parasitizedType);
			nbt.putDouble("vultureArmorAbility", vultureArmorAbility);
			nbt.putDouble("gunslingerArmorAbility", gunslingerArmorAbility);
			return nbt;
		}

		public void readNBT(Tag tag) {
			CompoundTag nbt = (CompoundTag) tag;
			StalkerCount = nbt.getDouble("StalkerCount");
			ForgottenValleyAmbientSound = nbt.getDouble("ForgottenValleyAmbientSound");
			StalkerSpawn = nbt.getBoolean("StalkerSpawn");
			StalkerCountFinish = nbt.getBoolean("StalkerCountFinish");
			playerX = nbt.getDouble("playerX");
			playerY = nbt.getDouble("playerY");
			playerZ = nbt.getDouble("playerZ");
			RottenArmorAbility = nbt.getDouble("RottenArmorAbility");
			hallucinate = nbt.getDouble("hallucinate");
			StalkerStalkCount = nbt.getDouble("StalkerStalkCount");
			VoidCaveAmbientSound = nbt.getDouble("VoidCaveAmbientSound");
			VoidCloakAbility = nbt.getDouble("VoidCloakAbility");
			InCreative = nbt.getBoolean("InCreative");
			InAdventure = nbt.getBoolean("InAdventure");
			cave_tremble = nbt.getDouble("cave_tremble");
			darkness_absorption = nbt.getDouble("darkness_absorption");
			seek_light = nbt.getBoolean("seek_light");
			playerCallOfTheVoid = nbt.getBoolean("playerCallOfTheVoid");
			hallucinating = nbt.getBoolean("hallucinating");
			deathgrounds_ambience = nbt.getDouble("deathgrounds_ambience");
			flesh_roar = nbt.getDouble("flesh_roar");
			armorToggle = nbt.getBoolean("armorToggle");
			monolithAmbience = nbt.getDouble("monolithAmbience");
			hasteAllSeeing = nbt.getDouble("hasteAllSeeing");
			allseeingArmor = nbt.getDouble("allseeingArmor");
			hallucinateX = nbt.getDouble("hallucinateX");
			hallucinateY = nbt.getDouble("hallucinateY");
			hallucinateZ = nbt.getDouble("hallucinateZ");
			soundHallX = nbt.getDouble("soundHallX");
			soundHallY = nbt.getDouble("soundHallY");
			soundHallZ = nbt.getDouble("soundHallZ");
			hallucinateHurt = nbt.getDouble("hallucinateHurt");
			nestAmbience = nbt.getDouble("nestAmbience");
			InSurvival = nbt.getBoolean("InSurvival");
			darknessDamageBuildUp = nbt.getDouble("darknessDamageBuildUp");
			motherCallOutCooldown = nbt.getDouble("motherCallOutCooldown");
			motherlyCallCooldown = nbt.getDouble("motherlyCallCooldown");
			FallSound = nbt.getBoolean("FallSound");
			healthBoostLevel = nbt.getDouble("healthBoostLevel");
			healthMask = nbt.getDouble("healthMask");
			grimRottenArmorAttack = nbt.getBoolean("grimRottenArmorAttack");
			SendToHell = nbt.getBoolean("SendToHell");
			naturalTeleport = nbt.getBoolean("naturalTeleport");
			weaverBoots = nbt.getDouble("weaverBoots");
			randomStalkerValue = nbt.getDouble("randomStalkerValue");
			stalkingCount = nbt.getDouble("stalkingCount");
			stalkWatcherCount = nbt.getDouble("stalkWatcherCount");
			noGravity = nbt.getBoolean("noGravity");
			heartbeatIndicator = nbt.getDouble("heartbeatIndicator");
			hasSoulOrb = nbt.getBoolean("hasSoulOrb");
			teleportToVoid = nbt.getBoolean("teleportToVoid");
			weaverRobeCooldown = nbt.getDouble("weaverRobeCooldown");
			gatheringAmbience = nbt.getDouble("gatheringAmbience");
			attackedByAnimosity = nbt.getBoolean("attackedByAnimosity");
			eyekinCooldown = nbt.getDouble("eyekinCooldown");
			eyekinDash = nbt.getDouble("eyekinDash");
			wingFlapSound = nbt.getDouble("wingFlapSound");
			hookX = nbt.getDouble("hookX");
			hookY = nbt.getDouble("hookY");
			hookZ = nbt.getDouble("hookZ");
			hooked = nbt.getBoolean("hooked");
			voidriumTeleport = nbt.getDouble("voidriumTeleport");
			noEscape = nbt.getBoolean("noEscape");
			hiveCallX = nbt.getDouble("hiveCallX");
			hiveCallY = nbt.getDouble("hiveCallY");
			hiveCallZ = nbt.getDouble("hiveCallZ");
			hunterArmorAbility = nbt.getDouble("hunterArmorAbility");
			mistedRemnantAmbience = nbt.getDouble("mistedRemnantAmbience");
			saveArmor3 = ItemStack.of(nbt.getCompound("saveArmor3"));
			saveArmor2 = ItemStack.of(nbt.getCompound("saveArmor2"));
			saveArmor1 = ItemStack.of(nbt.getCompound("saveArmor1"));
			saveArmor0 = ItemStack.of(nbt.getCompound("saveArmor0"));
			saveArmorPoint = nbt.getDouble("saveArmorPoint");
			gaol_ambience = nbt.getDouble("gaol_ambience");
			noHit = nbt.getBoolean("noHit");
			MusicTick = nbt.getDouble("MusicTick");
			MusicWait = nbt.getDouble("MusicWait");
			MusicLock = nbt.getBoolean("MusicLock");
			MusicReplace = nbt.getBoolean("MusicReplace");
			MusicPlay = nbt.getString("MusicPlay");
			watcherFightCount = nbt.getDouble("watcherFightCount");
			sendToPurgatory = nbt.getBoolean("sendToPurgatory");
			receivedWikiBook = nbt.getBoolean("receivedWikiBook");
			saveArmorToughness = nbt.getDouble("saveArmorToughness");
			saveKnockbackResistance = nbt.getDouble("saveKnockbackResistance");
			saveStepHeight = nbt.getDouble("saveStepHeight");
			parasitizedType = nbt.getDouble("parasitizedType");
			vultureArmorAbility = nbt.getDouble("vultureArmorAbility");
			gunslingerArmorAbility = nbt.getDouble("gunslingerArmorAbility");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.StalkerCount = message.data.StalkerCount;
					variables.ForgottenValleyAmbientSound = message.data.ForgottenValleyAmbientSound;
					variables.StalkerSpawn = message.data.StalkerSpawn;
					variables.StalkerCountFinish = message.data.StalkerCountFinish;
					variables.playerX = message.data.playerX;
					variables.playerY = message.data.playerY;
					variables.playerZ = message.data.playerZ;
					variables.RottenArmorAbility = message.data.RottenArmorAbility;
					variables.hallucinate = message.data.hallucinate;
					variables.StalkerStalkCount = message.data.StalkerStalkCount;
					variables.VoidCaveAmbientSound = message.data.VoidCaveAmbientSound;
					variables.VoidCloakAbility = message.data.VoidCloakAbility;
					variables.InCreative = message.data.InCreative;
					variables.InAdventure = message.data.InAdventure;
					variables.cave_tremble = message.data.cave_tremble;
					variables.darkness_absorption = message.data.darkness_absorption;
					variables.seek_light = message.data.seek_light;
					variables.playerCallOfTheVoid = message.data.playerCallOfTheVoid;
					variables.hallucinating = message.data.hallucinating;
					variables.deathgrounds_ambience = message.data.deathgrounds_ambience;
					variables.flesh_roar = message.data.flesh_roar;
					variables.armorToggle = message.data.armorToggle;
					variables.monolithAmbience = message.data.monolithAmbience;
					variables.hasteAllSeeing = message.data.hasteAllSeeing;
					variables.allseeingArmor = message.data.allseeingArmor;
					variables.hallucinateX = message.data.hallucinateX;
					variables.hallucinateY = message.data.hallucinateY;
					variables.hallucinateZ = message.data.hallucinateZ;
					variables.soundHallX = message.data.soundHallX;
					variables.soundHallY = message.data.soundHallY;
					variables.soundHallZ = message.data.soundHallZ;
					variables.hallucinateHurt = message.data.hallucinateHurt;
					variables.nestAmbience = message.data.nestAmbience;
					variables.InSurvival = message.data.InSurvival;
					variables.darknessDamageBuildUp = message.data.darknessDamageBuildUp;
					variables.motherCallOutCooldown = message.data.motherCallOutCooldown;
					variables.motherlyCallCooldown = message.data.motherlyCallCooldown;
					variables.FallSound = message.data.FallSound;
					variables.healthBoostLevel = message.data.healthBoostLevel;
					variables.healthMask = message.data.healthMask;
					variables.grimRottenArmorAttack = message.data.grimRottenArmorAttack;
					variables.SendToHell = message.data.SendToHell;
					variables.naturalTeleport = message.data.naturalTeleport;
					variables.weaverBoots = message.data.weaverBoots;
					variables.randomStalkerValue = message.data.randomStalkerValue;
					variables.stalkingCount = message.data.stalkingCount;
					variables.stalkWatcherCount = message.data.stalkWatcherCount;
					variables.noGravity = message.data.noGravity;
					variables.heartbeatIndicator = message.data.heartbeatIndicator;
					variables.hasSoulOrb = message.data.hasSoulOrb;
					variables.teleportToVoid = message.data.teleportToVoid;
					variables.weaverRobeCooldown = message.data.weaverRobeCooldown;
					variables.gatheringAmbience = message.data.gatheringAmbience;
					variables.attackedByAnimosity = message.data.attackedByAnimosity;
					variables.eyekinCooldown = message.data.eyekinCooldown;
					variables.eyekinDash = message.data.eyekinDash;
					variables.wingFlapSound = message.data.wingFlapSound;
					variables.hookX = message.data.hookX;
					variables.hookY = message.data.hookY;
					variables.hookZ = message.data.hookZ;
					variables.hooked = message.data.hooked;
					variables.voidriumTeleport = message.data.voidriumTeleport;
					variables.noEscape = message.data.noEscape;
					variables.hiveCallX = message.data.hiveCallX;
					variables.hiveCallY = message.data.hiveCallY;
					variables.hiveCallZ = message.data.hiveCallZ;
					variables.hunterArmorAbility = message.data.hunterArmorAbility;
					variables.mistedRemnantAmbience = message.data.mistedRemnantAmbience;
					variables.saveArmor3 = message.data.saveArmor3;
					variables.saveArmor2 = message.data.saveArmor2;
					variables.saveArmor1 = message.data.saveArmor1;
					variables.saveArmor0 = message.data.saveArmor0;
					variables.saveArmorPoint = message.data.saveArmorPoint;
					variables.gaol_ambience = message.data.gaol_ambience;
					variables.noHit = message.data.noHit;
					variables.MusicTick = message.data.MusicTick;
					variables.MusicWait = message.data.MusicWait;
					variables.MusicLock = message.data.MusicLock;
					variables.MusicReplace = message.data.MusicReplace;
					variables.MusicPlay = message.data.MusicPlay;
					variables.watcherFightCount = message.data.watcherFightCount;
					variables.sendToPurgatory = message.data.sendToPurgatory;
					variables.receivedWikiBook = message.data.receivedWikiBook;
					variables.saveArmorToughness = message.data.saveArmorToughness;
					variables.saveKnockbackResistance = message.data.saveKnockbackResistance;
					variables.saveStepHeight = message.data.saveStepHeight;
					variables.parasitizedType = message.data.parasitizedType;
					variables.vultureArmorAbility = message.data.vultureArmorAbility;
					variables.gunslingerArmorAbility = message.data.gunslingerArmorAbility;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
