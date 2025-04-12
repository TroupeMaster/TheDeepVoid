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
			clone.crateX = original.crateX;
			clone.crateY = original.crateY;
			clone.crateZ = original.crateZ;
			clone.VoidCaveAmbientSound = original.VoidCaveAmbientSound;
			clone.InCreative = original.InCreative;
			clone.InAdventure = original.InAdventure;
			clone.cave_tremble = original.cave_tremble;
			clone.seek_light = original.seek_light;
			clone.playerCallOfTheVoid = original.playerCallOfTheVoid;
			clone.CallOfTheVoidEnd = original.CallOfTheVoidEnd;
			clone.InSurvival = original.InSurvival;
			clone.SendToHell = original.SendToHell;
			if (!event.isWasDeath()) {
				clone.playerX = original.playerX;
				clone.playerY = original.playerY;
				clone.playerZ = original.playerZ;
				clone.RottenArmorAbility = original.RottenArmorAbility;
				clone.NightmareCount = original.NightmareCount;
				clone.VoidCloakAbility = original.VoidCloakAbility;
				clone.darkness_absorption = original.darkness_absorption;
				clone.hallucinating = original.hallucinating;
				clone.deathgrounds_ambience = original.deathgrounds_ambience;
				clone.playAmbient = original.playAmbient;
				clone.flesh_roar = original.flesh_roar;
				clone.caveAmbience = original.caveAmbience;
				clone.armorToggle = original.armorToggle;
				clone.monolithAmbience = original.monolithAmbience;
				clone.StalkerAmbientRandom = original.StalkerAmbientRandom;
				clone.hasteAllSeeing = original.hasteAllSeeing;
				clone.hasteShovel = original.hasteShovel;
				clone.allseeingArmor = original.allseeingArmor;
				clone.hallucinateX = original.hallucinateX;
				clone.hallucinateY = original.hallucinateY;
				clone.hallucinateZ = original.hallucinateZ;
				clone.playCaveAmbient = original.playCaveAmbient;
				clone.CaveAmbientRandom = original.CaveAmbientRandom;
				clone.soundHallX = original.soundHallX;
				clone.soundHallY = original.soundHallY;
				clone.soundHallZ = original.soundHallZ;
				clone.hallucinateHurt = original.hallucinateHurt;
				clone.nestAmbience = original.nestAmbience;
				clone.breathingHillsAmbience = original.breathingHillsAmbience;
				clone.breathingHillsHeart = original.breathingHillsHeart;
				clone.darknessDamageBuildUp = original.darknessDamageBuildUp;
				clone.motherCallOutCooldown = original.motherCallOutCooldown;
				clone.motherlyCallCooldown = original.motherlyCallCooldown;
				clone.FallSound = original.FallSound;
				clone.healthBoostLevel = original.healthBoostLevel;
				clone.healthMask = original.healthMask;
				clone.godsScourgeDash = original.godsScourgeDash;
				clone.grimRottenArmorAttack = original.grimRottenArmorAttack;
				clone.naturalTeleport = original.naturalTeleport;
				clone.weaverBoots = original.weaverBoots;
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
		public boolean WeaverTemplePlaced = false;
		public double stalkerSpawnX = 0;
		public double stalkerSpawnZ = 0;

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			CultTemplePlaced = nbt.getBoolean("CultTemplePlaced");
			StalkerDespawned = nbt.getBoolean("StalkerDespawned");
			WeaverTemplePlaced = nbt.getBoolean("WeaverTemplePlaced");
			stalkerSpawnX = nbt.getDouble("stalkerSpawnX");
			stalkerSpawnZ = nbt.getDouble("stalkerSpawnZ");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putBoolean("CultTemplePlaced", CultTemplePlaced);
			nbt.putBoolean("StalkerDespawned", StalkerDespawned);
			nbt.putBoolean("WeaverTemplePlaced", WeaverTemplePlaced);
			nbt.putDouble("stalkerSpawnX", stalkerSpawnX);
			nbt.putDouble("stalkerSpawnZ", stalkerSpawnZ);
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
		public double crateX = 0;
		public double crateY = 0;
		public double crateZ = 0;
		public double VoidCaveAmbientSound = 0;
		public double NightmareCount = 0;
		public double VoidCloakAbility = 0;
		public boolean InCreative = false;
		public boolean InAdventure = false;
		public double cave_tremble = 0;
		public double darkness_absorption = 0;
		public boolean seek_light = false;
		public boolean playerCallOfTheVoid = false;
		public boolean CallOfTheVoidEnd = false;
		public boolean hallucinating = false;
		public double deathgrounds_ambience = 0;
		public boolean playAmbient = false;
		public double flesh_roar = 0;
		public double caveAmbience = 0;
		public boolean armorToggle = false;
		public double monolithAmbience = 0;
		public double StalkerAmbientRandom = 0;
		public double hasteAllSeeing = 0;
		public double hasteShovel = 0;
		public double allseeingArmor = 0;
		public double hallucinateX = 0;
		public double hallucinateY = 0;
		public double hallucinateZ = 0;
		public boolean playCaveAmbient = false;
		public double CaveAmbientRandom = 0;
		public double soundHallX = 0;
		public double soundHallY = 0;
		public double soundHallZ = 0;
		public double hallucinateHurt = 0;
		public double nestAmbience = 0;
		public boolean InSurvival = false;
		public double breathingHillsAmbience = 0;
		public double breathingHillsHeart = 0;
		public double darknessDamageBuildUp = 0;
		public double motherCallOutCooldown = 0;
		public double motherlyCallCooldown = 0;
		public boolean FallSound = false;
		public double healthBoostLevel = 0;
		public double healthMask = 0;
		public boolean godsScourgeDash = false;
		public boolean grimRottenArmorAttack = false;
		public boolean SendToHell = false;
		public boolean naturalTeleport = false;
		public double weaverBoots = 0;

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
			nbt.putDouble("crateX", crateX);
			nbt.putDouble("crateY", crateY);
			nbt.putDouble("crateZ", crateZ);
			nbt.putDouble("VoidCaveAmbientSound", VoidCaveAmbientSound);
			nbt.putDouble("NightmareCount", NightmareCount);
			nbt.putDouble("VoidCloakAbility", VoidCloakAbility);
			nbt.putBoolean("InCreative", InCreative);
			nbt.putBoolean("InAdventure", InAdventure);
			nbt.putDouble("cave_tremble", cave_tremble);
			nbt.putDouble("darkness_absorption", darkness_absorption);
			nbt.putBoolean("seek_light", seek_light);
			nbt.putBoolean("playerCallOfTheVoid", playerCallOfTheVoid);
			nbt.putBoolean("CallOfTheVoidEnd", CallOfTheVoidEnd);
			nbt.putBoolean("hallucinating", hallucinating);
			nbt.putDouble("deathgrounds_ambience", deathgrounds_ambience);
			nbt.putBoolean("playAmbient", playAmbient);
			nbt.putDouble("flesh_roar", flesh_roar);
			nbt.putDouble("caveAmbience", caveAmbience);
			nbt.putBoolean("armorToggle", armorToggle);
			nbt.putDouble("monolithAmbience", monolithAmbience);
			nbt.putDouble("StalkerAmbientRandom", StalkerAmbientRandom);
			nbt.putDouble("hasteAllSeeing", hasteAllSeeing);
			nbt.putDouble("hasteShovel", hasteShovel);
			nbt.putDouble("allseeingArmor", allseeingArmor);
			nbt.putDouble("hallucinateX", hallucinateX);
			nbt.putDouble("hallucinateY", hallucinateY);
			nbt.putDouble("hallucinateZ", hallucinateZ);
			nbt.putBoolean("playCaveAmbient", playCaveAmbient);
			nbt.putDouble("CaveAmbientRandom", CaveAmbientRandom);
			nbt.putDouble("soundHallX", soundHallX);
			nbt.putDouble("soundHallY", soundHallY);
			nbt.putDouble("soundHallZ", soundHallZ);
			nbt.putDouble("hallucinateHurt", hallucinateHurt);
			nbt.putDouble("nestAmbience", nestAmbience);
			nbt.putBoolean("InSurvival", InSurvival);
			nbt.putDouble("breathingHillsAmbience", breathingHillsAmbience);
			nbt.putDouble("breathingHillsHeart", breathingHillsHeart);
			nbt.putDouble("darknessDamageBuildUp", darknessDamageBuildUp);
			nbt.putDouble("motherCallOutCooldown", motherCallOutCooldown);
			nbt.putDouble("motherlyCallCooldown", motherlyCallCooldown);
			nbt.putBoolean("FallSound", FallSound);
			nbt.putDouble("healthBoostLevel", healthBoostLevel);
			nbt.putDouble("healthMask", healthMask);
			nbt.putBoolean("godsScourgeDash", godsScourgeDash);
			nbt.putBoolean("grimRottenArmorAttack", grimRottenArmorAttack);
			nbt.putBoolean("SendToHell", SendToHell);
			nbt.putBoolean("naturalTeleport", naturalTeleport);
			nbt.putDouble("weaverBoots", weaverBoots);
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
			crateX = nbt.getDouble("crateX");
			crateY = nbt.getDouble("crateY");
			crateZ = nbt.getDouble("crateZ");
			VoidCaveAmbientSound = nbt.getDouble("VoidCaveAmbientSound");
			NightmareCount = nbt.getDouble("NightmareCount");
			VoidCloakAbility = nbt.getDouble("VoidCloakAbility");
			InCreative = nbt.getBoolean("InCreative");
			InAdventure = nbt.getBoolean("InAdventure");
			cave_tremble = nbt.getDouble("cave_tremble");
			darkness_absorption = nbt.getDouble("darkness_absorption");
			seek_light = nbt.getBoolean("seek_light");
			playerCallOfTheVoid = nbt.getBoolean("playerCallOfTheVoid");
			CallOfTheVoidEnd = nbt.getBoolean("CallOfTheVoidEnd");
			hallucinating = nbt.getBoolean("hallucinating");
			deathgrounds_ambience = nbt.getDouble("deathgrounds_ambience");
			playAmbient = nbt.getBoolean("playAmbient");
			flesh_roar = nbt.getDouble("flesh_roar");
			caveAmbience = nbt.getDouble("caveAmbience");
			armorToggle = nbt.getBoolean("armorToggle");
			monolithAmbience = nbt.getDouble("monolithAmbience");
			StalkerAmbientRandom = nbt.getDouble("StalkerAmbientRandom");
			hasteAllSeeing = nbt.getDouble("hasteAllSeeing");
			hasteShovel = nbt.getDouble("hasteShovel");
			allseeingArmor = nbt.getDouble("allseeingArmor");
			hallucinateX = nbt.getDouble("hallucinateX");
			hallucinateY = nbt.getDouble("hallucinateY");
			hallucinateZ = nbt.getDouble("hallucinateZ");
			playCaveAmbient = nbt.getBoolean("playCaveAmbient");
			CaveAmbientRandom = nbt.getDouble("CaveAmbientRandom");
			soundHallX = nbt.getDouble("soundHallX");
			soundHallY = nbt.getDouble("soundHallY");
			soundHallZ = nbt.getDouble("soundHallZ");
			hallucinateHurt = nbt.getDouble("hallucinateHurt");
			nestAmbience = nbt.getDouble("nestAmbience");
			InSurvival = nbt.getBoolean("InSurvival");
			breathingHillsAmbience = nbt.getDouble("breathingHillsAmbience");
			breathingHillsHeart = nbt.getDouble("breathingHillsHeart");
			darknessDamageBuildUp = nbt.getDouble("darknessDamageBuildUp");
			motherCallOutCooldown = nbt.getDouble("motherCallOutCooldown");
			motherlyCallCooldown = nbt.getDouble("motherlyCallCooldown");
			FallSound = nbt.getBoolean("FallSound");
			healthBoostLevel = nbt.getDouble("healthBoostLevel");
			healthMask = nbt.getDouble("healthMask");
			godsScourgeDash = nbt.getBoolean("godsScourgeDash");
			grimRottenArmorAttack = nbt.getBoolean("grimRottenArmorAttack");
			SendToHell = nbt.getBoolean("SendToHell");
			naturalTeleport = nbt.getBoolean("naturalTeleport");
			weaverBoots = nbt.getDouble("weaverBoots");
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
					variables.crateX = message.data.crateX;
					variables.crateY = message.data.crateY;
					variables.crateZ = message.data.crateZ;
					variables.VoidCaveAmbientSound = message.data.VoidCaveAmbientSound;
					variables.NightmareCount = message.data.NightmareCount;
					variables.VoidCloakAbility = message.data.VoidCloakAbility;
					variables.InCreative = message.data.InCreative;
					variables.InAdventure = message.data.InAdventure;
					variables.cave_tremble = message.data.cave_tremble;
					variables.darkness_absorption = message.data.darkness_absorption;
					variables.seek_light = message.data.seek_light;
					variables.playerCallOfTheVoid = message.data.playerCallOfTheVoid;
					variables.CallOfTheVoidEnd = message.data.CallOfTheVoidEnd;
					variables.hallucinating = message.data.hallucinating;
					variables.deathgrounds_ambience = message.data.deathgrounds_ambience;
					variables.playAmbient = message.data.playAmbient;
					variables.flesh_roar = message.data.flesh_roar;
					variables.caveAmbience = message.data.caveAmbience;
					variables.armorToggle = message.data.armorToggle;
					variables.monolithAmbience = message.data.monolithAmbience;
					variables.StalkerAmbientRandom = message.data.StalkerAmbientRandom;
					variables.hasteAllSeeing = message.data.hasteAllSeeing;
					variables.hasteShovel = message.data.hasteShovel;
					variables.allseeingArmor = message.data.allseeingArmor;
					variables.hallucinateX = message.data.hallucinateX;
					variables.hallucinateY = message.data.hallucinateY;
					variables.hallucinateZ = message.data.hallucinateZ;
					variables.playCaveAmbient = message.data.playCaveAmbient;
					variables.CaveAmbientRandom = message.data.CaveAmbientRandom;
					variables.soundHallX = message.data.soundHallX;
					variables.soundHallY = message.data.soundHallY;
					variables.soundHallZ = message.data.soundHallZ;
					variables.hallucinateHurt = message.data.hallucinateHurt;
					variables.nestAmbience = message.data.nestAmbience;
					variables.InSurvival = message.data.InSurvival;
					variables.breathingHillsAmbience = message.data.breathingHillsAmbience;
					variables.breathingHillsHeart = message.data.breathingHillsHeart;
					variables.darknessDamageBuildUp = message.data.darknessDamageBuildUp;
					variables.motherCallOutCooldown = message.data.motherCallOutCooldown;
					variables.motherlyCallCooldown = message.data.motherlyCallCooldown;
					variables.FallSound = message.data.FallSound;
					variables.healthBoostLevel = message.data.healthBoostLevel;
					variables.healthMask = message.data.healthMask;
					variables.godsScourgeDash = message.data.godsScourgeDash;
					variables.grimRottenArmorAttack = message.data.grimRottenArmorAttack;
					variables.SendToHell = message.data.SendToHell;
					variables.naturalTeleport = message.data.naturalTeleport;
					variables.weaverBoots = message.data.weaverBoots;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
