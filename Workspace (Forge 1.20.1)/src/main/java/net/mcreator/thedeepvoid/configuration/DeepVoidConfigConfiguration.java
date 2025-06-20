package net.mcreator.thedeepvoid.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class DeepVoidConfigConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Boolean> PLACECULTTEMPLE;
	public static final ForgeConfigSpec.ConfigValue<Boolean> PLAYERSTELEPORTINVOID;
	public static final ForgeConfigSpec.ConfigValue<Boolean> PLAYERSTELEPORTINEND;
	public static final ForgeConfigSpec.ConfigValue<Double> TELEPORTHEIGHT;
	public static final ForgeConfigSpec.ConfigValue<Boolean> DEEPVOIDFOG;
	public static final ForgeConfigSpec.ConfigValue<Boolean> STOPACTIVEBLOCKGENERATION;
	public static final ForgeConfigSpec.ConfigValue<Boolean> OLDHOLESTRUCTURE;
	public static final ForgeConfigSpec.ConfigValue<Boolean> SPAWNABDUCTORS;
	public static final ForgeConfigSpec.ConfigValue<Boolean> SPAWNFALLINGCORPSE;
	public static final ForgeConfigSpec.ConfigValue<Boolean> PLACECORPSEONIMPACT;
	public static final ForgeConfigSpec.ConfigValue<Boolean> STALKERSPAWNS;
	public static final ForgeConfigSpec.ConfigValue<Boolean> STALKINGSTALKERSPAWNS;
	public static final ForgeConfigSpec.ConfigValue<Double> STALKERSPAWNTIMER;
	public static final ForgeConfigSpec.ConfigValue<Boolean> SEEKLIGHTWARNING;
	public static final ForgeConfigSpec.ConfigValue<Boolean> DESTROYLIGHTSOURCES;
	public static final ForgeConfigSpec.ConfigValue<Double> VOIDBLESSINGTIMER;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ALLOWOTHERWORLDTP;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ALLOWSOULLIGHT;
	public static final ForgeConfigSpec.ConfigValue<Boolean> PLAYERHALLUCINATES;
	public static final ForgeConfigSpec.ConfigValue<Boolean> STALKERBREAKSBLOCKS;
	public static final ForgeConfigSpec.ConfigValue<Boolean> DARKNESS;
	public static final ForgeConfigSpec.ConfigValue<Boolean> HELL;
	public static final ForgeConfigSpec.ConfigValue<Boolean> STALKED;
	public static final ForgeConfigSpec.ConfigValue<Boolean> CORPSERAIN;
	public static final ForgeConfigSpec.ConfigValue<Boolean> CREEPINGDARKNESS;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ENDLESSABYSS;
	public static final ForgeConfigSpec.ConfigValue<Boolean> PURGATORY;
	public static final ForgeConfigSpec.ConfigValue<Boolean> GIVETORCHES;
	public static final ForgeConfigSpec.ConfigValue<Boolean> OVERWRITEWITHSEPULCHER;
	public static final ForgeConfigSpec.ConfigValue<Boolean> OVERWRITEWITHTEMPLE;
	static {
		BUILDER.push("Generation&World");
		PLACECULTTEMPLE = BUILDER.comment("Whether the Cult Temple will be place at 0,0 or not").define("PlaceCultTemple", true);
		PLAYERSTELEPORTINVOID = BUILDER.comment("Whether Players will teleport to the Deep Void when jumping in the Void or not").define("PlayersTeleportInVoid", true);
		PLAYERSTELEPORTINEND = BUILDER.comment("Whether Players will teleport to the Deep Void when falling in the Void in the End or not (If PlayersTeleportInVoid is false, this will automatically be false)").define("PlayersTeleportInEnd", true);
		TELEPORTHEIGHT = BUILDER.comment("At which depth does the Player teleport to the dimension (Default -70)").define("TeleportHeight", (double) -70);
		DEEPVOIDFOG = BUILDER.comment("If the Deep Void should have fog or not").define("DeepVoidFog", true);
		STOPACTIVEBLOCKGENERATION = BUILDER.comment("If blocks under specific biomes should generate plants on top of them to make the cave biome (this depends on random tick speed). If the server lags a lot, set this to true")
				.define("StopActiveBlockGeneration", false);
		OLDHOLESTRUCTURE = BUILDER.comment("If the old structure with the hole to the void should generate in the overworld instead of the new version").define("OldHoleStructure", false);
		BUILDER.pop();
		BUILDER.push("Spawns");
		SPAWNABDUCTORS = BUILDER.comment("Whether Abductors will spawn in the Overworld or not").define("SpawnAbductors", true);
		SPAWNFALLINGCORPSE = BUILDER.comment("If corpses should fall from the sky in the Deep Void").define("SpawnFallingCorpse", true);
		PLACECORPSEONIMPACT = BUILDER.comment("If falling corpses should place a corpse on impact").define("PlaceCorpseOnImpact", false);
		STALKERSPAWNS = BUILDER.comment("If the Stalker should spawn or not").define("StalkerSpawns", true);
		STALKINGSTALKERSPAWNS = BUILDER.comment("If Stalking Stalkers should spawn or not").define("StalkingStalkerSpawns", true);
		STALKERSPAWNTIMER = BUILDER.comment("The time it takes for the Stalker to spawn in ticks (Default = 1,200 ticks)").define("StalkerSpawnTimer", (double) 1200);
		BUILDER.pop();
		BUILDER.push("Misc");
		SEEKLIGHTWARNING = BUILDER.comment("Whether the ''Seek Light'' warning should appear when the Stalker is close or not (Happens only one time)").define("SeekLightWarning", true);
		DESTROYLIGHTSOURCES = BUILDER.comment("Whether light sources should be destroyed in the Deep Void or not").define("DestroyLightSources", true);
		VOIDBLESSINGTIMER = BUILDER.comment("How long the Void Blessing effect should last when entering the Deep Void (In ticks)").define("VoidBlessingTimer", (double) 600);
		ALLOWOTHERWORLDTP = BUILDER.comment("Should players teleport to the Deep Void when falling in the void in any dimension").define("AllowOtherWorldTp", false);
		ALLOWSOULLIGHT = BUILDER.comment("Should Soul light sources not get destroyed").define("AllowSoulLight", false);
		PLAYERHALLUCINATES = BUILDER.comment("If players should hallucinate below y=1 or not").define("PlayerHallucinates", true);
		STALKERBREAKSBLOCKS = BUILDER.comment("Should the Stalker be able to break certain blocks").define("StalkerBreaksBlocks", true);
		DARKNESS = BUILDER.comment("If Darkness should attack the Player below y=0 while still keeping Hallucinate").define("Darkness", true);
		BUILDER.pop();
		BUILDER.push("Gameplay Changes");
		HELL = BUILDER.comment("When a player dies, they get sent to the Deep Void").define("Hell", false);
		STALKED = BUILDER.comment("The Stalker can spawn in the overworld").define("Stalked", false);
		CORPSERAIN = BUILDER.comment("Corpses fall from the sky in the overworld").define("CorpseRain", false);
		CREEPINGDARKNESS = BUILDER.comment("Darkness engulfs everything").define("CreepingDarkness", false);
		ENDLESSABYSS = BUILDER.comment("The player spawns in the Deep Void").define("EndlessAbyss", false);
		PURGATORY = BUILDER.comment("Like Hell, but when the player dies in the Deep Void, they stay in the Deep Void").define("Purgatory", false);
		GIVETORCHES = BUILDER.comment("If torches should be given to players that respawn in the Deep Void (through Hell or Purgatory)").define("GiveTorches", true);
		BUILDER.pop();
		BUILDER.push("Critical Changes");
		OVERWRITEWITHSEPULCHER = BUILDER.comment("If true, the old structure containing the Weaver Of Souls will be overwritten by the new one (this WILL destroy anything around it)").define("OverwriteWithSepulcher", false);
		OVERWRITEWITHTEMPLE = BUILDER.define("OverwriteWithTemple", false);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
