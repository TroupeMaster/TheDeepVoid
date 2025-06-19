package net.mcreator.thedeepvoid.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;

import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.function.Supplier;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class TheDeepVoidModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, TheDeepVoidMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		TheDeepVoidMod.addNetworkMessage(SavedDataSyncMessage.TYPE, SavedDataSyncMessage.STREAM_CODEC, SavedDataSyncMessage::handleData);
		TheDeepVoidMod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
			PlayerVariables clone = new PlayerVariables();
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
			clone.randomStalkerValue = original.randomStalkerValue;
			clone.stalkingCount = original.stalkingCount;
			clone.stalkWatcherCount = original.stalkWatcherCount;
			clone.noGravity = original.noGravity;
			clone.teleportToVoid = original.teleportToVoid;
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
				clone.heartbeatIndicator = original.heartbeatIndicator;
				clone.hasSoulOrb = original.hasSoulOrb;
				clone.handheldBreak = original.handheldBreak;
				clone.weaverRobeCooldown = original.weaverRobeCooldown;
				clone.gatheringAmbience = original.gatheringAmbience;
				clone.pickedUpApostle = original.pickedUpApostle;
				clone.posYApostle = original.posYApostle;
				clone.attackedByAnimosity = original.attackedByAnimosity;
				clone.eyekinCooldown = original.eyekinCooldown;
				clone.eyekinDash = original.eyekinDash;
			}
			event.getEntity().setData(PLAYER_VARIABLES, clone);
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "the_deep_void_worldvars";

		public static WorldVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			WorldVariables data = new WorldVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof ServerLevel level)
				PacketDistributor.sendToPlayersInDimension(level, new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(new SavedData.Factory<>(WorldVariables::new, WorldVariables::load), DATA_NAME);
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
		public double weaverFightCount = 0;
		public boolean overwritten = false;
		public boolean surfaceOverwritten = false;
		public double apostleFightCount = 0;

		public static MapVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			MapVariables data = new MapVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			CultTemplePlaced = nbt.getBoolean("CultTemplePlaced");
			StalkerDespawned = nbt.getBoolean("StalkerDespawned");
			WeaverTemplePlaced = nbt.getBoolean("WeaverTemplePlaced");
			stalkerSpawnX = nbt.getDouble("stalkerSpawnX");
			stalkerSpawnZ = nbt.getDouble("stalkerSpawnZ");
			weaverFightCount = nbt.getDouble("weaverFightCount");
			overwritten = nbt.getBoolean("overwritten");
			surfaceOverwritten = nbt.getBoolean("surfaceOverwritten");
			apostleFightCount = nbt.getDouble("apostleFightCount");
		}

		@Override
		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			nbt.putBoolean("CultTemplePlaced", CultTemplePlaced);
			nbt.putBoolean("StalkerDespawned", StalkerDespawned);
			nbt.putBoolean("WeaverTemplePlaced", WeaverTemplePlaced);
			nbt.putDouble("stalkerSpawnX", stalkerSpawnX);
			nbt.putDouble("stalkerSpawnZ", stalkerSpawnZ);
			nbt.putDouble("weaverFightCount", weaverFightCount);
			nbt.putBoolean("overwritten", overwritten);
			nbt.putBoolean("surfaceOverwritten", surfaceOverwritten);
			nbt.putDouble("apostleFightCount", apostleFightCount);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				PacketDistributor.sendToAllPlayers(new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(new SavedData.Factory<>(MapVariables::new, MapVariables::load), DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public record SavedDataSyncMessage(int dataType, SavedData data) implements CustomPacketPayload {
		public static final Type<SavedDataSyncMessage> TYPE = new Type<>(new ResourceLocation(TheDeepVoidMod.MODID, "saved_data_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, SavedDataSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SavedDataSyncMessage message) -> {
			buffer.writeInt(message.dataType);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag(), buffer.registryAccess()));
		}, (RegistryFriendlyByteBuf buffer) -> {
			int dataType = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			SavedData data = null;
			if (nbt != null) {
				data = dataType == 0 ? new MapVariables() : new WorldVariables();
				if (data instanceof MapVariables mapVariables)
					mapVariables.read(nbt, buffer.registryAccess());
				else if (data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt, buffer.registryAccess());
			}
			return new SavedDataSyncMessage(dataType, data);
		});

		@Override
		public Type<SavedDataSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final SavedDataSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> {
					if (message.dataType == 0)
						MapVariables.clientSide.read(message.data.save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
					else
						WorldVariables.clientSide.read(message.data.save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {
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
		public double randomStalkerValue = 0;
		public double stalkingCount = 0;
		public double stalkWatcherCount = 0;
		public boolean noGravity = false;
		public double heartbeatIndicator = 0;
		public boolean hasSoulOrb = false;
		public double handheldBreak = 0;
		public boolean teleportToVoid = false;
		public double weaverRobeCooldown = 0;
		public double gatheringAmbience = 0;
		public boolean pickedUpApostle = false;
		public double posYApostle = 0;
		public boolean attackedByAnimosity = false;
		public double eyekinCooldown = 0;
		public double eyekinDash = 0;

		@Override
		public CompoundTag serializeNBT(HolderLookup.Provider lookupProvider) {
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
			nbt.putDouble("randomStalkerValue", randomStalkerValue);
			nbt.putDouble("stalkingCount", stalkingCount);
			nbt.putDouble("stalkWatcherCount", stalkWatcherCount);
			nbt.putBoolean("noGravity", noGravity);
			nbt.putDouble("heartbeatIndicator", heartbeatIndicator);
			nbt.putBoolean("hasSoulOrb", hasSoulOrb);
			nbt.putDouble("handheldBreak", handheldBreak);
			nbt.putBoolean("teleportToVoid", teleportToVoid);
			nbt.putDouble("weaverRobeCooldown", weaverRobeCooldown);
			nbt.putDouble("gatheringAmbience", gatheringAmbience);
			nbt.putBoolean("pickedUpApostle", pickedUpApostle);
			nbt.putDouble("posYApostle", posYApostle);
			nbt.putBoolean("attackedByAnimosity", attackedByAnimosity);
			nbt.putDouble("eyekinCooldown", eyekinCooldown);
			nbt.putDouble("eyekinDash", eyekinDash);
			return nbt;
		}

		@Override
		public void deserializeNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
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
			randomStalkerValue = nbt.getDouble("randomStalkerValue");
			stalkingCount = nbt.getDouble("stalkingCount");
			stalkWatcherCount = nbt.getDouble("stalkWatcherCount");
			noGravity = nbt.getBoolean("noGravity");
			heartbeatIndicator = nbt.getDouble("heartbeatIndicator");
			hasSoulOrb = nbt.getBoolean("hasSoulOrb");
			handheldBreak = nbt.getDouble("handheldBreak");
			teleportToVoid = nbt.getBoolean("teleportToVoid");
			weaverRobeCooldown = nbt.getDouble("weaverRobeCooldown");
			gatheringAmbience = nbt.getDouble("gatheringAmbience");
			pickedUpApostle = nbt.getBoolean("pickedUpApostle");
			posYApostle = nbt.getDouble("posYApostle");
			attackedByAnimosity = nbt.getBoolean("attackedByAnimosity");
			eyekinCooldown = nbt.getDouble("eyekinCooldown");
			eyekinDash = nbt.getDouble("eyekinDash");
		}

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				PacketDistributor.sendToPlayer(serverPlayer, new PlayerVariablesSyncMessage(this));
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(new ResourceLocation(TheDeepVoidMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec
				.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> buffer.writeNbt(message.data().serializeNBT(buffer.registryAccess())), (RegistryFriendlyByteBuf buffer) -> {
					PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables());
					message.data.deserializeNBT(buffer.registryAccess(), buffer.readNbt());
					return message;
				});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> context.player().getData(PLAYER_VARIABLES).deserializeNBT(context.player().registryAccess(), message.data.serializeNBT(context.player().registryAccess()))).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}
