
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedeepvoid.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.XrayEntity;
import net.mcreator.thedeepvoid.entity.XpFlareShotEntity;
import net.mcreator.thedeepvoid.entity.WeaverOfSoulsEntity;
import net.mcreator.thedeepvoid.entity.WatchingStalkerEntity;
import net.mcreator.thedeepvoid.entity.WandererEntity;
import net.mcreator.thedeepvoid.entity.VoidriumFlareShotEntity;
import net.mcreator.thedeepvoid.entity.VoidbornTentaclesEntity;
import net.mcreator.thedeepvoid.entity.VoidbornEntity;
import net.mcreator.thedeepvoid.entity.VoidTentacleEntity;
import net.mcreator.thedeepvoid.entity.VoidPelletEntity;
import net.mcreator.thedeepvoid.entity.VoidDwellerEntity;
import net.mcreator.thedeepvoid.entity.ThumperEntityEntity;
import net.mcreator.thedeepvoid.entity.TenebrisCultroEntity;
import net.mcreator.thedeepvoid.entity.TamedMotherBoneCrawlerEntity;
import net.mcreator.thedeepvoid.entity.TamedBoneCrawlerEntity;
import net.mcreator.thedeepvoid.entity.TamedAlphaBoneCrawlerEntity;
import net.mcreator.thedeepvoid.entity.SwarmerEntity;
import net.mcreator.thedeepvoid.entity.SummonedShadowHandEntity;
import net.mcreator.thedeepvoid.entity.SummonedHiveFangsEntity;
import net.mcreator.thedeepvoid.entity.SummonedDevourerEntity;
import net.mcreator.thedeepvoid.entity.SulfurTntEntityEntity;
import net.mcreator.thedeepvoid.entity.SulfurFlareShotEntity;
import net.mcreator.thedeepvoid.entity.SulfurBombProjEntity;
import net.mcreator.thedeepvoid.entity.StalkerTreatThrownEntity;
import net.mcreator.thedeepvoid.entity.StalkerEntity;
import net.mcreator.thedeepvoid.entity.SporeSpewerEntity;
import net.mcreator.thedeepvoid.entity.SpiteArrowEntity;
import net.mcreator.thedeepvoid.entity.SpawnBoneSpikesEntity;
import net.mcreator.thedeepvoid.entity.SoulOrbEntity;
import net.mcreator.thedeepvoid.entity.SoulHookEntity;
import net.mcreator.thedeepvoid.entity.SoulFusedShotEntity;
import net.mcreator.thedeepvoid.entity.SmallFleshCubeEntity;
import net.mcreator.thedeepvoid.entity.SleepingPrimordialCrawlerEntity;
import net.mcreator.thedeepvoid.entity.SkullSmasherEntity;
import net.mcreator.thedeepvoid.entity.ShankPrisonerEntity;
import net.mcreator.thedeepvoid.entity.ShadowHandEntity;
import net.mcreator.thedeepvoid.entity.ShadowArrowEntity;
import net.mcreator.thedeepvoid.entity.ShadeArrowEntity;
import net.mcreator.thedeepvoid.entity.SeekerEntity;
import net.mcreator.thedeepvoid.entity.ScarecrowEntity;
import net.mcreator.thedeepvoid.entity.SawThrowerEntity;
import net.mcreator.thedeepvoid.entity.RottenDartProjectileEntity;
import net.mcreator.thedeepvoid.entity.RottenCultMemberEntity;
import net.mcreator.thedeepvoid.entity.RottenCorpseEntity;
import net.mcreator.thedeepvoid.entity.RotKnifeEntity;
import net.mcreator.thedeepvoid.entity.RootedEntity;
import net.mcreator.thedeepvoid.entity.RootedCloneEntity;
import net.mcreator.thedeepvoid.entity.RoamerEntity;
import net.mcreator.thedeepvoid.entity.RideableFlyingEyekinEntity;
import net.mcreator.thedeepvoid.entity.RideableEyekinEntity;
import net.mcreator.thedeepvoid.entity.RedFlareShotEntity;
import net.mcreator.thedeepvoid.entity.PusBallProjectileEntity;
import net.mcreator.thedeepvoid.entity.PrisonerEntity;
import net.mcreator.thedeepvoid.entity.PrisonGuardEntity;
import net.mcreator.thedeepvoid.entity.PrimordialBoneCrawlerEntity;
import net.mcreator.thedeepvoid.entity.PreserverEntity;
import net.mcreator.thedeepvoid.entity.PoisonKnifeEntity;
import net.mcreator.thedeepvoid.entity.PlayerCageEntity;
import net.mcreator.thedeepvoid.entity.PerilBulletEntity;
import net.mcreator.thedeepvoid.entity.PenitentEntity;
import net.mcreator.thedeepvoid.entity.OverseerPillarEntity;
import net.mcreator.thedeepvoid.entity.OverseerEntity;
import net.mcreator.thedeepvoid.entity.OverseerBigPillarEntity;
import net.mcreator.thedeepvoid.entity.NeedlefishProjEntity;
import net.mcreator.thedeepvoid.entity.MuzzledDeathVultureEntity;
import net.mcreator.thedeepvoid.entity.MultipleEyesEntity;
import net.mcreator.thedeepvoid.entity.MournerEntity;
import net.mcreator.thedeepvoid.entity.MotherBoneCrawlerEntity;
import net.mcreator.thedeepvoid.entity.MisanthropicHivemindEntity;
import net.mcreator.thedeepvoid.entity.MimickingShadowEntity;
import net.mcreator.thedeepvoid.entity.MimicEntity;
import net.mcreator.thedeepvoid.entity.MaskedHunterEntity;
import net.mcreator.thedeepvoid.entity.MarrowRootsSpawnEntity;
import net.mcreator.thedeepvoid.entity.MarrowRootsEntity;
import net.mcreator.thedeepvoid.entity.MaggotEntity;
import net.mcreator.thedeepvoid.entity.LurkerEntity;
import net.mcreator.thedeepvoid.entity.LightEntity;
import net.mcreator.thedeepvoid.entity.LickerEntity;
import net.mcreator.thedeepvoid.entity.LavenditeShardProjEntity;
import net.mcreator.thedeepvoid.entity.LastingShadowHandEntity;
import net.mcreator.thedeepvoid.entity.IdlingApostleEntity;
import net.mcreator.thedeepvoid.entity.IchorSpitEntity;
import net.mcreator.thedeepvoid.entity.HookEntity;
import net.mcreator.thedeepvoid.entity.HookEndEntity;
import net.mcreator.thedeepvoid.entity.HollowedEntity;
import net.mcreator.thedeepvoid.entity.HivemindTentaclesEntity;
import net.mcreator.thedeepvoid.entity.HiveWatcherEntity;
import net.mcreator.thedeepvoid.entity.HiveFangsEntity;
import net.mcreator.thedeepvoid.entity.HiveBrainEntity;
import net.mcreator.thedeepvoid.entity.HandSpawnEntity;
import net.mcreator.thedeepvoid.entity.GrimHookEntity;
import net.mcreator.thedeepvoid.entity.GreaterXpBottleEntity;
import net.mcreator.thedeepvoid.entity.GravekeeperEntity;
import net.mcreator.thedeepvoid.entity.GoreLurkerEntity;
import net.mcreator.thedeepvoid.entity.GoreExpectoratorEntity;
import net.mcreator.thedeepvoid.entity.GooSpitterEntity;
import net.mcreator.thedeepvoid.entity.GooBlockEntity;
import net.mcreator.thedeepvoid.entity.GoldenRotArrowEntity;
import net.mcreator.thedeepvoid.entity.GoldenFlareShotEntity;
import net.mcreator.thedeepvoid.entity.GoldenBloodshotEntity;
import net.mcreator.thedeepvoid.entity.GiantShadowHandEntity;
import net.mcreator.thedeepvoid.entity.GiantBoneSpikeEntity;
import net.mcreator.thedeepvoid.entity.GiantBoneCrawlerEggEntity;
import net.mcreator.thedeepvoid.entity.GhostlyNightmareEntity;
import net.mcreator.thedeepvoid.entity.GhostEntity;
import net.mcreator.thedeepvoid.entity.GaolerEntity;
import net.mcreator.thedeepvoid.entity.FourEyesEntity;
import net.mcreator.thedeepvoid.entity.ForsakenEntity;
import net.mcreator.thedeepvoid.entity.FoolEaterEntity;
import net.mcreator.thedeepvoid.entity.FleshWormEntity;
import net.mcreator.thedeepvoid.entity.FleshLampreyEntity;
import net.mcreator.thedeepvoid.entity.FleshFlareShotEntity;
import net.mcreator.thedeepvoid.entity.FleshFangsEntity;
import net.mcreator.thedeepvoid.entity.FleshCubeEntity;
import net.mcreator.thedeepvoid.entity.FleshArrowEntity;
import net.mcreator.thedeepvoid.entity.FlareEntity;
import net.mcreator.thedeepvoid.entity.FallingCorpseEntity;
import net.mcreator.thedeepvoid.entity.EyekinFlyingEntity;
import net.mcreator.thedeepvoid.entity.EyekinEntity;
import net.mcreator.thedeepvoid.entity.EyeOfTheWatcherEntity;
import net.mcreator.thedeepvoid.entity.EverhungerEntity;
import net.mcreator.thedeepvoid.entity.ElderMimicEntity;
import net.mcreator.thedeepvoid.entity.DoomingTombstoneEntity;
import net.mcreator.thedeepvoid.entity.DevourerEntity;
import net.mcreator.thedeepvoid.entity.DeathVultureEntity;
import net.mcreator.thedeepvoid.entity.DeathMawHiddenEntity;
import net.mcreator.thedeepvoid.entity.DeathMawEntity;
import net.mcreator.thedeepvoid.entity.DarkSteelSawEntity;
import net.mcreator.thedeepvoid.entity.DarkDaggerEntity;
import net.mcreator.thedeepvoid.entity.DamnedEntity;
import net.mcreator.thedeepvoid.entity.CrossEyesEntity;
import net.mcreator.thedeepvoid.entity.ChainedWeaverEntity;
import net.mcreator.thedeepvoid.entity.CentigazeHiddenEntity;
import net.mcreator.thedeepvoid.entity.CentigazeEntity;
import net.mcreator.thedeepvoid.entity.CathedralGhostEntity;
import net.mcreator.thedeepvoid.entity.BuiltOverseerPillarEntity;
import net.mcreator.thedeepvoid.entity.BuiltOverseerEntity;
import net.mcreator.thedeepvoid.entity.BuiltBigOverseerPillarEntity;
import net.mcreator.thedeepvoid.entity.BuiltBigOverseerEntity;
import net.mcreator.thedeepvoid.entity.BrightFlareShotEntity;
import net.mcreator.thedeepvoid.entity.BoneSawEntity;
import net.mcreator.thedeepvoid.entity.BoneCrawlerEntity;
import net.mcreator.thedeepvoid.entity.BoneCageEntity;
import net.mcreator.thedeepvoid.entity.BoneCageClosedEntity;
import net.mcreator.thedeepvoid.entity.BoneBlockadeEntity;
import net.mcreator.thedeepvoid.entity.BoneBallProjectileEntity;
import net.mcreator.thedeepvoid.entity.BogWalkerEntity;
import net.mcreator.thedeepvoid.entity.BloodshotEntity;
import net.mcreator.thedeepvoid.entity.BloodSpitEntity;
import net.mcreator.thedeepvoid.entity.BloodSpikeEntity;
import net.mcreator.thedeepvoid.entity.BlackFlyEntity;
import net.mcreator.thedeepvoid.entity.BigShadeArrowEntity;
import net.mcreator.thedeepvoid.entity.BigOverseerEntity;
import net.mcreator.thedeepvoid.entity.BigEyeEntity;
import net.mcreator.thedeepvoid.entity.BeholderEntity;
import net.mcreator.thedeepvoid.entity.BabyBoneCrawlerNeutralEntity;
import net.mcreator.thedeepvoid.entity.BabyBoneCrawlerEntity;
import net.mcreator.thedeepvoid.entity.ApostleOfCatastropheEntity;
import net.mcreator.thedeepvoid.entity.AmbrosiaSpitEntity;
import net.mcreator.thedeepvoid.entity.AmalgamEntity;
import net.mcreator.thedeepvoid.entity.AlphaBoneCrawlerEntity;
import net.mcreator.thedeepvoid.entity.AcidSpitEntity;
import net.mcreator.thedeepvoid.entity.AbductorEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TheDeepVoidModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TheDeepVoidMod.MODID);
	public static final RegistryObject<EntityType<FallingCorpseEntity>> FALLING_CORPSE = register("falling_corpse", EntityType.Builder.<FallingCorpseEntity>of(FallingCorpseEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FallingCorpseEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BoneBallProjectileEntity>> BONE_BALL_PROJECTILE = register("bone_ball_projectile", EntityType.Builder.<BoneBallProjectileEntity>of(BoneBallProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(BoneBallProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<GhostlyNightmareEntity>> GHOSTLY_NIGHTMARE = register("ghostly_nightmare", EntityType.Builder.<GhostlyNightmareEntity>of(GhostlyNightmareEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(84).setUpdateInterval(3).setCustomClientFactory(GhostlyNightmareEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<RottenDartProjectileEntity>> ROTTEN_DART_PROJECTILE = register("rotten_dart_projectile", EntityType.Builder.<RottenDartProjectileEntity>of(RottenDartProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(RottenDartProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<PusBallProjectileEntity>> PUS_BALL_PROJECTILE = register("pus_ball_projectile", EntityType.Builder.<PusBallProjectileEntity>of(PusBallProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(PusBallProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FlareEntity>> FLARE = register("flare",
			EntityType.Builder.<FlareEntity>of(FlareEntity::new, MobCategory.MISC).setCustomClientFactory(FlareEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<LightEntity>> LIGHT = register("light",
			EntityType.Builder.<LightEntity>of(LightEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LightEntity::new).fireImmune().sized(0.1f, 0.1f));
	public static final RegistryObject<EntityType<LavenditeShardProjEntity>> LAVENDITE_SHARD_PROJ = register("lavendite_shard_proj", EntityType.Builder.<LavenditeShardProjEntity>of(LavenditeShardProjEntity::new, MobCategory.MISC)
			.setCustomClientFactory(LavenditeShardProjEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<AmalgamEntity>> AMALGAM = register("amalgam",
			EntityType.Builder.<AmalgamEntity>of(AmalgamEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AmalgamEntity::new)

					.sized(3f, 3f));
	public static final RegistryObject<EntityType<TenebrisCultroEntity>> DARK_KNIFE = register("dark_knife",
			EntityType.Builder.<TenebrisCultroEntity>of(TenebrisCultroEntity::new, MobCategory.MISC).setCustomClientFactory(TenebrisCultroEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SulfurTntEntityEntity>> SULFUR_TNT_ENTITY = register("sulfur_tnt_entity", EntityType.Builder.<SulfurTntEntityEntity>of(SulfurTntEntityEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3).setCustomClientFactory(SulfurTntEntityEntity::new).fireImmune().sized(1f, 1f));
	public static final RegistryObject<EntityType<CathedralGhostEntity>> CATHEDRAL_GHOST = register("cathedral_ghost", EntityType.Builder.<CathedralGhostEntity>of(CathedralGhostEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(1).setUpdateInterval(3).setCustomClientFactory(CathedralGhostEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<GhostEntity>> GHOST = register("ghost",
			EntityType.Builder.<GhostEntity>of(GhostEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GhostEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<OverseerPillarEntity>> OVERSEER_PILLAR = register("overseer_pillar", EntityType.Builder.<OverseerPillarEntity>of(OverseerPillarEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(OverseerPillarEntity::new).fireImmune().sized(1f, 2f));
	public static final RegistryObject<EntityType<BuiltOverseerPillarEntity>> BUILT_OVERSEER_PILLAR = register("built_overseer_pillar", EntityType.Builder.<BuiltOverseerPillarEntity>of(BuiltOverseerPillarEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BuiltOverseerPillarEntity::new).fireImmune().sized(1f, 2f));
	public static final RegistryObject<EntityType<DeathMawHiddenEntity>> DEATH_MAW_HIDDEN = register("death_maw_hidden",
			EntityType.Builder.<DeathMawHiddenEntity>of(DeathMawHiddenEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DeathMawHiddenEntity::new)

					.sized(1.6f, 0.8f));
	public static final RegistryObject<EntityType<SulfurBombProjEntity>> SULFUR_BOMB_PROJ = register("sulfur_bomb_proj",
			EntityType.Builder.<SulfurBombProjEntity>of(SulfurBombProjEntity::new, MobCategory.MISC).setCustomClientFactory(SulfurBombProjEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ShadeArrowEntity>> SHADE_ARROW = register("shade_arrow",
			EntityType.Builder.<ShadeArrowEntity>of(ShadeArrowEntity::new, MobCategory.MISC).setCustomClientFactory(ShadeArrowEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<BigShadeArrowEntity>> BIG_SHADE_ARROW = register("big_shade_arrow",
			EntityType.Builder.<BigShadeArrowEntity>of(BigShadeArrowEntity::new, MobCategory.MISC).setCustomClientFactory(BigShadeArrowEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MournerEntity>> MOURNER = register("mourner",
			EntityType.Builder.<MournerEntity>of(MournerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(34).setUpdateInterval(3).setCustomClientFactory(MournerEntity::new)

					.sized(0.6f, 2.4f));
	public static final RegistryObject<EntityType<BoneCrawlerEntity>> BONE_CRAWLER = register("bone_crawler",
			EntityType.Builder.<BoneCrawlerEntity>of(BoneCrawlerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BoneCrawlerEntity::new)

					.sized(1.1f, 0.7f));
	public static final RegistryObject<EntityType<FoolEaterEntity>> FOOL_EATER = register("fool_eater",
			EntityType.Builder.<FoolEaterEntity>of(FoolEaterEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FoolEaterEntity::new)

					.sized(1f, 5.6f));
	public static final RegistryObject<EntityType<TamedBoneCrawlerEntity>> TAMED_BONE_CRAWLER = register("tamed_bone_crawler",
			EntityType.Builder.<TamedBoneCrawlerEntity>of(TamedBoneCrawlerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TamedBoneCrawlerEntity::new)

					.sized(0.8f, 0.5f));
	public static final RegistryObject<EntityType<LurkerEntity>> LURKER = register("lurker",
			EntityType.Builder.<LurkerEntity>of(LurkerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LurkerEntity::new)

					.sized(0.8f, 3.5f));
	public static final RegistryObject<EntityType<StalkerEntity>> STALKER = register("stalker",
			EntityType.Builder.<StalkerEntity>of(StalkerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(125).setUpdateInterval(3).setCustomClientFactory(StalkerEntity::new).fireImmune().sized(0.6f, 3.3f));
	public static final RegistryObject<EntityType<AbductorEntity>> ABDUCTOR = register("abductor",
			EntityType.Builder.<AbductorEntity>of(AbductorEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(70).setUpdateInterval(3).setCustomClientFactory(AbductorEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<VoidDwellerEntity>> VOID_DWELLER = register("void_dweller",
			EntityType.Builder.<VoidDwellerEntity>of(VoidDwellerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(VoidDwellerEntity::new)

					.sized(0.6f, 3f));
	public static final RegistryObject<EntityType<LickerEntity>> LICKER = register("licker",
			EntityType.Builder.<LickerEntity>of(LickerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LickerEntity::new)

					.sized(0.6f, 1f));
	public static final RegistryObject<EntityType<FleshCubeEntity>> FLESH_CUBE = register("flesh_cube",
			EntityType.Builder.<FleshCubeEntity>of(FleshCubeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FleshCubeEntity::new)

					.sized(1.2f, 1.2f));
	public static final RegistryObject<EntityType<SmallFleshCubeEntity>> SMALL_FLESH_CUBE = register("small_flesh_cube",
			EntityType.Builder.<SmallFleshCubeEntity>of(SmallFleshCubeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SmallFleshCubeEntity::new)

					.sized(0.6f, 0.6f));
	public static final RegistryObject<EntityType<SporeSpewerEntity>> SPORE_SPEWER = register("spore_spewer",
			EntityType.Builder.<SporeSpewerEntity>of(SporeSpewerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SporeSpewerEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<WandererEntity>> WANDERER = register("wanderer",
			EntityType.Builder.<WandererEntity>of(WandererEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(WandererEntity::new)

					.sized(1.2f, 2.2f));
	public static final RegistryObject<EntityType<GravekeeperEntity>> GRAVEKEEPER = register("gravekeeper",
			EntityType.Builder.<GravekeeperEntity>of(GravekeeperEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(66).setUpdateInterval(3).setCustomClientFactory(GravekeeperEntity::new)

					.sized(0.6f, 2.9f));
	public static final RegistryObject<EntityType<GooSpitterEntity>> GOO_SPITTER = register("goo_spitter",
			EntityType.Builder.<GooSpitterEntity>of(GooSpitterEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GooSpitterEntity::new)

					.sized(0.8f, 0.5f));
	public static final RegistryObject<EntityType<RoamerEntity>> ROAMER = register("roamer",
			EntityType.Builder.<RoamerEntity>of(RoamerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RoamerEntity::new)

					.sized(2f, 1.8f));
	public static final RegistryObject<EntityType<MotherBoneCrawlerEntity>> MOTHER_BONE_CRAWLER = register("mother_bone_crawler",
			EntityType.Builder.<MotherBoneCrawlerEntity>of(MotherBoneCrawlerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MotherBoneCrawlerEntity::new)

					.sized(2f, 2f));
	public static final RegistryObject<EntityType<TamedMotherBoneCrawlerEntity>> TAMED_MOTHER_BONE_CRAWLER = register("tamed_mother_bone_crawler",
			EntityType.Builder.<TamedMotherBoneCrawlerEntity>of(TamedMotherBoneCrawlerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(TamedMotherBoneCrawlerEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<AlphaBoneCrawlerEntity>> ALPHA_BONE_CRAWLER = register("alpha_bone_crawler",
			EntityType.Builder.<AlphaBoneCrawlerEntity>of(AlphaBoneCrawlerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AlphaBoneCrawlerEntity::new)

					.sized(1.6f, 1.5f));
	public static final RegistryObject<EntityType<TamedAlphaBoneCrawlerEntity>> TAMED_ALPHA_BONE_CRAWLER = register("tamed_alpha_bone_crawler",
			EntityType.Builder.<TamedAlphaBoneCrawlerEntity>of(TamedAlphaBoneCrawlerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(TamedAlphaBoneCrawlerEntity::new)

					.sized(1.6f, 1.5f));
	public static final RegistryObject<EntityType<BabyBoneCrawlerEntity>> BABY_BONE_CRAWLER = register("baby_bone_crawler",
			EntityType.Builder.<BabyBoneCrawlerEntity>of(BabyBoneCrawlerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BabyBoneCrawlerEntity::new)

					.sized(0.8f, 0.5f));
	public static final RegistryObject<EntityType<BabyBoneCrawlerNeutralEntity>> BABY_BONE_CRAWLER_NEUTRAL = register("baby_bone_crawler_neutral",
			EntityType.Builder.<BabyBoneCrawlerNeutralEntity>of(BabyBoneCrawlerNeutralEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(BabyBoneCrawlerNeutralEntity::new)

					.sized(0.8f, 0.5f));
	public static final RegistryObject<EntityType<RottenCorpseEntity>> ROTTEN_CORPSE = register("rotten_corpse",
			EntityType.Builder.<RottenCorpseEntity>of(RottenCorpseEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RottenCorpseEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<RottenCultMemberEntity>> ROTTEN_CULT_MEMBER = register("rotten_cult_member",
			EntityType.Builder.<RottenCultMemberEntity>of(RottenCultMemberEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RottenCultMemberEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<EyekinEntity>> EYEKIN = register("eyekin",
			EntityType.Builder.<EyekinEntity>of(EyekinEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(74).setUpdateInterval(3).setCustomClientFactory(EyekinEntity::new)

					.sized(2.2f, 3.2f));
	public static final RegistryObject<EntityType<EyekinFlyingEntity>> EYEKIN_FLYING = register("eyekin_flying",
			EntityType.Builder.<EyekinFlyingEntity>of(EyekinFlyingEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(78).setUpdateInterval(3).setCustomClientFactory(EyekinFlyingEntity::new)

					.sized(3f, 1f));
	public static final RegistryObject<EntityType<SwarmerEntity>> SWARMER = register("swarmer",
			EntityType.Builder.<SwarmerEntity>of(SwarmerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SwarmerEntity::new)

					.sized(1f, 1f));
	public static final RegistryObject<EntityType<DeathMawEntity>> DEATH_MAW = register("death_maw",
			EntityType.Builder.<DeathMawEntity>of(DeathMawEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DeathMawEntity::new)

					.sized(2.4f, 2.1f));
	public static final RegistryObject<EntityType<BeholderEntity>> BEHOLDER = register("beholder",
			EntityType.Builder.<BeholderEntity>of(BeholderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BeholderEntity::new)

					.sized(0.6f, 1.5f));
	public static final RegistryObject<EntityType<EverhungerEntity>> EVERHUNGER = register("everhunger",
			EntityType.Builder.<EverhungerEntity>of(EverhungerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(78).setUpdateInterval(3).setCustomClientFactory(EverhungerEntity::new)

					.sized(1f, 3.4f));
	public static final RegistryObject<EntityType<DeathVultureEntity>> DEATH_VULTURE = register("death_vulture",
			EntityType.Builder.<DeathVultureEntity>of(DeathVultureEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(80).setUpdateInterval(3).setCustomClientFactory(DeathVultureEntity::new)

					.sized(0.9f, 1.9f));
	public static final RegistryObject<EntityType<MuzzledDeathVultureEntity>> MUZZLED_DEATH_VULTURE = register("muzzled_death_vulture",
			EntityType.Builder.<MuzzledDeathVultureEntity>of(MuzzledDeathVultureEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(70).setUpdateInterval(3).setCustomClientFactory(MuzzledDeathVultureEntity::new)

					.sized(0.9f, 1.9f));
	public static final RegistryObject<EntityType<DevourerEntity>> DEVOURER = register("devourer",
			EntityType.Builder.<DevourerEntity>of(DevourerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DevourerEntity::new).fireImmune().sized(0.8f, 2.9f));
	public static final RegistryObject<EntityType<RootedEntity>> ROOTED = register("rooted",
			EntityType.Builder.<RootedEntity>of(RootedEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RootedEntity::new)

					.sized(0.8f, 2f));
	public static final RegistryObject<EntityType<RootedCloneEntity>> ROOTED_CLONE = register("rooted_clone",
			EntityType.Builder.<RootedCloneEntity>of(RootedCloneEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RootedCloneEntity::new)

					.sized(0.8f, 2f));
	public static final RegistryObject<EntityType<OverseerEntity>> OVERSEER = register("overseer",
			EntityType.Builder.<OverseerEntity>of(OverseerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(OverseerEntity::new).fireImmune().sized(1f, 2f));
	public static final RegistryObject<EntityType<BuiltOverseerEntity>> BUILT_OVERSEER = register("built_overseer", EntityType.Builder.<BuiltOverseerEntity>of(BuiltOverseerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BuiltOverseerEntity::new).fireImmune().sized(1f, 2f));
	public static final RegistryObject<EntityType<ScarecrowEntity>> SCARECROW = register("scarecrow",
			EntityType.Builder.<ScarecrowEntity>of(ScarecrowEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ScarecrowEntity::new)

					.sized(2.8f, 18f));
	public static final RegistryObject<EntityType<StalkerTreatThrownEntity>> STALKER_TREAT_THROWN = register("stalker_treat_thrown", EntityType.Builder.<StalkerTreatThrownEntity>of(StalkerTreatThrownEntity::new, MobCategory.MISC)
			.setCustomClientFactory(StalkerTreatThrownEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<OverseerBigPillarEntity>> OVERSEER_BIG_PILLAR = register("overseer_big_pillar", EntityType.Builder.<OverseerBigPillarEntity>of(OverseerBigPillarEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(OverseerBigPillarEntity::new).fireImmune().sized(1f, 3f));
	public static final RegistryObject<EntityType<BigOverseerEntity>> BIG_OVERSEER = register("big_overseer", EntityType.Builder.<BigOverseerEntity>of(BigOverseerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BigOverseerEntity::new).fireImmune().sized(1f, 3f));
	public static final RegistryObject<EntityType<BuiltBigOverseerPillarEntity>> BUILT_BIG_OVERSEER_PILLAR = register("built_big_overseer_pillar",
			EntityType.Builder.<BuiltBigOverseerPillarEntity>of(BuiltBigOverseerPillarEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(BuiltBigOverseerPillarEntity::new).fireImmune().sized(1f, 3f));
	public static final RegistryObject<EntityType<BuiltBigOverseerEntity>> BUILT_BIG_OVERSEER = register("built_big_overseer", EntityType.Builder.<BuiltBigOverseerEntity>of(BuiltBigOverseerEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BuiltBigOverseerEntity::new).fireImmune().sized(1f, 3f));
	public static final RegistryObject<EntityType<CentigazeEntity>> CENTIGAZE = register("centigaze",
			EntityType.Builder.<CentigazeEntity>of(CentigazeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(78).setUpdateInterval(3).setCustomClientFactory(CentigazeEntity::new)

					.sized(2.4f, 0.9f));
	public static final RegistryObject<EntityType<CentigazeHiddenEntity>> CENTIGAZE_HIDDEN = register("centigaze_hidden", EntityType.Builder.<CentigazeHiddenEntity>of(CentigazeHiddenEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(78).setUpdateInterval(3).setCustomClientFactory(CentigazeHiddenEntity::new).fireImmune().sized(1.8f, 0.8f));
	public static final RegistryObject<EntityType<WatchingStalkerEntity>> WATCHING_STALKER = register("watching_stalker", EntityType.Builder.<WatchingStalkerEntity>of(WatchingStalkerEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(84).setUpdateInterval(3).setCustomClientFactory(WatchingStalkerEntity::new).fireImmune().sized(0.6f, 3.3f));
	public static final RegistryObject<EntityType<WeaverOfSoulsEntity>> WEAVER_OF_SOULS = register("weaver_of_souls", EntityType.Builder.<WeaverOfSoulsEntity>of(WeaverOfSoulsEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(78).setUpdateInterval(3).setCustomClientFactory(WeaverOfSoulsEntity::new).fireImmune().sized(2.8f, 2.8f));
	public static final RegistryObject<EntityType<HandSpawnEntity>> HAND_SPAWN = register("hand_spawn",
			EntityType.Builder.<HandSpawnEntity>of(HandSpawnEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3).setCustomClientFactory(HandSpawnEntity::new).fireImmune().sized(0.8f, 0.1f));
	public static final RegistryObject<EntityType<ShadowHandEntity>> SHADOW_HAND = register("shadow_hand", EntityType.Builder.<ShadowHandEntity>of(ShadowHandEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(ShadowHandEntity::new).fireImmune().sized(0.4f, 1.8f));
	public static final RegistryObject<EntityType<DamnedEntity>> DAMNED = register("damned",
			EntityType.Builder.<DamnedEntity>of(DamnedEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(65).setUpdateInterval(3).setCustomClientFactory(DamnedEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<CrossEyesEntity>> CROSS_EYES = register("cross_eyes",
			EntityType.Builder.<CrossEyesEntity>of(CrossEyesEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(65).setUpdateInterval(3).setCustomClientFactory(CrossEyesEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BigEyeEntity>> BIG_EYE = register("big_eye",
			EntityType.Builder.<BigEyeEntity>of(BigEyeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(65).setUpdateInterval(3).setCustomClientFactory(BigEyeEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<MultipleEyesEntity>> MULTIPLE_EYES = register("multiple_eyes",
			EntityType.Builder.<MultipleEyesEntity>of(MultipleEyesEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(65).setUpdateInterval(3).setCustomClientFactory(MultipleEyesEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<FourEyesEntity>> FOUR_EYES = register("four_eyes",
			EntityType.Builder.<FourEyesEntity>of(FourEyesEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(65).setUpdateInterval(3).setCustomClientFactory(FourEyesEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SoulOrbEntity>> SOUL_ORB = register("soul_orb",
			EntityType.Builder.<SoulOrbEntity>of(SoulOrbEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3).setCustomClientFactory(SoulOrbEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ChainedWeaverEntity>> CHAINED_WEAVER = register("chained_weaver", EntityType.Builder.<ChainedWeaverEntity>of(ChainedWeaverEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(99).setUpdateInterval(3).setCustomClientFactory(ChainedWeaverEntity::new).fireImmune().sized(2.8f, 2.8f));
	public static final RegistryObject<EntityType<DoomingTombstoneEntity>> DOOMING_TOMBSTONE = register("dooming_tombstone", EntityType.Builder.<DoomingTombstoneEntity>of(DoomingTombstoneEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3).setCustomClientFactory(DoomingTombstoneEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SummonedShadowHandEntity>> SUMMONED_SHADOW_HAND = register("summoned_shadow_hand", EntityType.Builder.<SummonedShadowHandEntity>of(SummonedShadowHandEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SummonedShadowHandEntity::new).fireImmune().sized(0.4f, 1.8f));
	public static final RegistryObject<EntityType<ForsakenEntity>> FORSAKEN = register("forsaken",
			EntityType.Builder.<ForsakenEntity>of(ForsakenEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ForsakenEntity::new)

					.sized(1.6f, 2.4f));
	public static final RegistryObject<EntityType<AcidSpitEntity>> ACID_SPIT = register("acid_spit",
			EntityType.Builder.<AcidSpitEntity>of(AcidSpitEntity::new, MobCategory.MISC).setCustomClientFactory(AcidSpitEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SeekerEntity>> SEEKER = register("seeker",
			EntityType.Builder.<SeekerEntity>of(SeekerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SeekerEntity::new)

					.sized(1f, 1f));
	public static final RegistryObject<EntityType<ApostleOfCatastropheEntity>> APOSTLE_OF_CATASTROPHE = register("apostle_of_catastrophe",
			EntityType.Builder.<ApostleOfCatastropheEntity>of(ApostleOfCatastropheEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(99).setUpdateInterval(3)
					.setCustomClientFactory(ApostleOfCatastropheEntity::new)

					.sized(0.9f, 3.8f));
	public static final RegistryObject<EntityType<PoisonKnifeEntity>> POISON_KNIFE = register("poison_knife",
			EntityType.Builder.<PoisonKnifeEntity>of(PoisonKnifeEntity::new, MobCategory.MISC).setCustomClientFactory(PoisonKnifeEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<RotKnifeEntity>> ROT_KNIFE = register("rot_knife",
			EntityType.Builder.<RotKnifeEntity>of(RotKnifeEntity::new, MobCategory.MISC).setCustomClientFactory(RotKnifeEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<IdlingApostleEntity>> IDLING_APOSTLE = register("idling_apostle", EntityType.Builder.<IdlingApostleEntity>of(IdlingApostleEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(8000).setUpdateInterval(3).setCustomClientFactory(IdlingApostleEntity::new).fireImmune().sized(0.9f, 3.8f));
	public static final RegistryObject<EntityType<BloodshotEntity>> BLOODSHOT = register("bloodshot",
			EntityType.Builder.<BloodshotEntity>of(BloodshotEntity::new, MobCategory.MISC).setCustomClientFactory(BloodshotEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<GoldenBloodshotEntity>> GOLDEN_BLOODSHOT = register("golden_bloodshot", EntityType.Builder.<GoldenBloodshotEntity>of(GoldenBloodshotEntity::new, MobCategory.MISC)
			.setCustomClientFactory(GoldenBloodshotEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MisanthropicHivemindEntity>> MISANTHROPIC_HIVEMIND = register("misanthropic_hivemind",
			EntityType.Builder.<MisanthropicHivemindEntity>of(MisanthropicHivemindEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(84).setUpdateInterval(3)
					.setCustomClientFactory(MisanthropicHivemindEntity::new)

					.sized(1.8f, 3.4f));
	public static final RegistryObject<EntityType<FleshFangsEntity>> FLESH_FANGS = register("flesh_fangs",
			EntityType.Builder.<FleshFangsEntity>of(FleshFangsEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FleshFangsEntity::new)

					.sized(1f, 1f));
	public static final RegistryObject<EntityType<GoreExpectoratorEntity>> GORE_EXPECTORATOR = register("gore_expectorator",
			EntityType.Builder.<GoreExpectoratorEntity>of(GoreExpectoratorEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GoreExpectoratorEntity::new)

					.sized(1.4f, 5f));
	public static final RegistryObject<EntityType<BloodSpitEntity>> BLOOD_SPIT = register("blood_spit",
			EntityType.Builder.<BloodSpitEntity>of(BloodSpitEntity::new, MobCategory.MISC).setCustomClientFactory(BloodSpitEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<HiveBrainEntity>> HIVE_BRAIN = register("hive_brain",
			EntityType.Builder.<HiveBrainEntity>of(HiveBrainEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(99).setUpdateInterval(3).setCustomClientFactory(HiveBrainEntity::new).fireImmune().sized(1f, 1f));
	public static final RegistryObject<EntityType<RideableEyekinEntity>> RIDEABLE_EYEKIN = register("rideable_eyekin",
			EntityType.Builder.<RideableEyekinEntity>of(RideableEyekinEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(74).setUpdateInterval(3).setCustomClientFactory(RideableEyekinEntity::new)

					.sized(2.2f, 3.2f));
	public static final RegistryObject<EntityType<RideableFlyingEyekinEntity>> RIDEABLE_FLYING_EYEKIN = register("rideable_flying_eyekin",
			EntityType.Builder.<RideableFlyingEyekinEntity>of(RideableFlyingEyekinEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(78).setUpdateInterval(3)
					.setCustomClientFactory(RideableFlyingEyekinEntity::new)

					.sized(3f, 1f));
	public static final RegistryObject<EntityType<GooBlockEntity>> GOO_BLOCK = register("goo_block",
			EntityType.Builder.<GooBlockEntity>of(GooBlockEntity::new, MobCategory.MISC).setCustomClientFactory(GooBlockEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SleepingPrimordialCrawlerEntity>> SLEEPING_PRIMORDIAL_CRAWLER = register("sleeping_primordial_crawler",
			EntityType.Builder.<SleepingPrimordialCrawlerEntity>of(SleepingPrimordialCrawlerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(99).setUpdateInterval(3)
					.setCustomClientFactory(SleepingPrimordialCrawlerEntity::new).fireImmune().sized(3.8f, 3.4f));
	public static final RegistryObject<EntityType<HookEntity>> HOOK = register("hook",
			EntityType.Builder.<HookEntity>of(HookEntity::new, MobCategory.MISC).setCustomClientFactory(HookEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<HookEndEntity>> HOOK_END = register("hook_end",
			EntityType.Builder.<HookEndEntity>of(HookEndEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3).setCustomClientFactory(HookEndEntity::new).fireImmune().sized(0.1f, 0.1f));
	public static final RegistryObject<EntityType<GrimHookEntity>> GRIM_HOOK = register("grim_hook",
			EntityType.Builder.<GrimHookEntity>of(GrimHookEntity::new, MobCategory.MISC).setCustomClientFactory(GrimHookEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SoulHookEntity>> SOUL_HOOK = register("soul_hook",
			EntityType.Builder.<SoulHookEntity>of(SoulHookEntity::new, MobCategory.MISC).setCustomClientFactory(SoulHookEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<PreserverEntity>> PRESERVER = register("preserver",
			EntityType.Builder.<PreserverEntity>of(PreserverEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PreserverEntity::new)

					.sized(0.9f, 1.4f));
	public static final RegistryObject<EntityType<LastingShadowHandEntity>> LASTING_SHADOW_HAND = register("lasting_shadow_hand", EntityType.Builder.<LastingShadowHandEntity>of(LastingShadowHandEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LastingShadowHandEntity::new).fireImmune().sized(0.8f, 2.8f));
	public static final RegistryObject<EntityType<GiantBoneCrawlerEggEntity>> GIANT_BONE_CRAWLER_EGG = register("giant_bone_crawler_egg", EntityType.Builder.<GiantBoneCrawlerEggEntity>of(GiantBoneCrawlerEggEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(99).setUpdateInterval(3).setCustomClientFactory(GiantBoneCrawlerEggEntity::new).fireImmune().sized(2.3f, 3f));
	public static final RegistryObject<EntityType<VoidTentacleEntity>> VOID_TENTACLE = register("void_tentacle", EntityType.Builder.<VoidTentacleEntity>of(VoidTentacleEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(VoidTentacleEntity::new).fireImmune().sized(0.8f, 5f));
	public static final RegistryObject<EntityType<SummonedDevourerEntity>> SUMMONED_DEVOURER = register("summoned_devourer", EntityType.Builder.<SummonedDevourerEntity>of(SummonedDevourerEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SummonedDevourerEntity::new).fireImmune().sized(0.8f, 2.9f));
	public static final RegistryObject<EntityType<MaskedHunterEntity>> MASKED_HUNTER = register("masked_hunter",
			EntityType.Builder.<MaskedHunterEntity>of(MaskedHunterEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(84).setUpdateInterval(3).setCustomClientFactory(MaskedHunterEntity::new)

					.sized(1.95f, 1.95f));
	public static final RegistryObject<EntityType<BoneCageEntity>> BONE_CAGE = register("bone_cage",
			EntityType.Builder.<BoneCageEntity>of(BoneCageEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3).setCustomClientFactory(BoneCageEntity::new)

					.sized(0.9f, 0.1f));
	public static final RegistryObject<EntityType<BoneCageClosedEntity>> BONE_CAGE_CLOSED = register("bone_cage_closed",
			EntityType.Builder.<BoneCageClosedEntity>of(BoneCageClosedEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3).setCustomClientFactory(BoneCageClosedEntity::new)

					.sized(0.9f, 1.8f));
	public static final RegistryObject<EntityType<GiantBoneSpikeEntity>> GIANT_BONE_SPIKE = register("giant_bone_spike", EntityType.Builder.<GiantBoneSpikeEntity>of(GiantBoneSpikeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(1).setUpdateInterval(3).setCustomClientFactory(GiantBoneSpikeEntity::new).fireImmune().sized(0.6f, 1.4f));
	public static final RegistryObject<EntityType<BoneSawEntity>> BONE_SAW = register("bone_saw",
			EntityType.Builder.<BoneSawEntity>of(BoneSawEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BoneSawEntity::new).fireImmune().sized(1f, 1.6f));
	public static final RegistryObject<EntityType<MimicEntity>> MIMIC = register("mimic",
			EntityType.Builder.<MimicEntity>of(MimicEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MimicEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SawThrowerEntity>> SAW_THROWER = register("saw_thrower",
			EntityType.Builder.<SawThrowerEntity>of(SawThrowerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SawThrowerEntity::new)

					.sized(0.8f, 1.8f));
	public static final RegistryObject<EntityType<SkullSmasherEntity>> SKULL_SMASHER = register("skull_smasher",
			EntityType.Builder.<SkullSmasherEntity>of(SkullSmasherEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SkullSmasherEntity::new)

					.sized(0.8f, 1.8f));
	public static final RegistryObject<EntityType<ElderMimicEntity>> ELDER_MIMIC = register("elder_mimic",
			EntityType.Builder.<ElderMimicEntity>of(ElderMimicEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(80).setUpdateInterval(3).setCustomClientFactory(ElderMimicEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ShadowArrowEntity>> SHADOW_ARROW = register("shadow_arrow",
			EntityType.Builder.<ShadowArrowEntity>of(ShadowArrowEntity::new, MobCategory.MISC).setCustomClientFactory(ShadowArrowEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<BogWalkerEntity>> BOG_WALKER = register("bog_walker",
			EntityType.Builder.<BogWalkerEntity>of(BogWalkerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BogWalkerEntity::new).fireImmune().sized(1.8f, 7f));
	public static final RegistryObject<EntityType<PrimordialBoneCrawlerEntity>> PRIMORDIAL_BONE_CRAWLER = register("primordial_bone_crawler",
			EntityType.Builder.<PrimordialBoneCrawlerEntity>of(PrimordialBoneCrawlerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(84).setUpdateInterval(3)
					.setCustomClientFactory(PrimordialBoneCrawlerEntity::new)

					.sized(3.8f, 3.4f));
	public static final RegistryObject<EntityType<SoulFusedShotEntity>> SOUL_FUSED_SHOT = register("soul_fused_shot",
			EntityType.Builder.<SoulFusedShotEntity>of(SoulFusedShotEntity::new, MobCategory.MISC).setCustomClientFactory(SoulFusedShotEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<HivemindTentaclesEntity>> HIVEMIND_TENTACLES = register("hivemind_tentacles",
			EntityType.Builder.<HivemindTentaclesEntity>of(HivemindTentaclesEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3).setCustomClientFactory(HivemindTentaclesEntity::new)

					.sized(2f, 3.6f));
	public static final RegistryObject<EntityType<PenitentEntity>> PENITENT = register("penitent",
			EntityType.Builder.<PenitentEntity>of(PenitentEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(70).setUpdateInterval(3).setCustomClientFactory(PenitentEntity::new)

					.sized(0.8f, 2.6f));
	public static final RegistryObject<EntityType<GaolerEntity>> GAOLER = register("gaoler",
			EntityType.Builder.<GaolerEntity>of(GaolerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(70).setUpdateInterval(3).setCustomClientFactory(GaolerEntity::new)

					.sized(0.8f, 2.6f));
	public static final RegistryObject<EntityType<PlayerCageEntity>> PLAYER_CAGE = register("player_cage", EntityType.Builder.<PlayerCageEntity>of(PlayerCageEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(1)
			.setUpdateInterval(3).setCustomClientFactory(PlayerCageEntity::new).fireImmune().sized(0.9f, 1.9f));
	public static final RegistryObject<EntityType<MimickingShadowEntity>> MIMICKING_SHADOW = register("mimicking_shadow",
			EntityType.Builder.<MimickingShadowEntity>of(MimickingShadowEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MimickingShadowEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SpiteArrowEntity>> SPITE_ARROW = register("spite_arrow",
			EntityType.Builder.<SpiteArrowEntity>of(SpiteArrowEntity::new, MobCategory.MISC).setCustomClientFactory(SpiteArrowEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<GreaterXpBottleEntity>> GREATER_XP_BOTTLE = register("greater_xp_bottle", EntityType.Builder.<GreaterXpBottleEntity>of(GreaterXpBottleEntity::new, MobCategory.MISC)
			.setCustomClientFactory(GreaterXpBottleEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<PrisonerEntity>> PRISONER = register("prisoner",
			EntityType.Builder.<PrisonerEntity>of(PrisonerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PrisonerEntity::new)

					.sized(0.6f, 1.9f));
	public static final RegistryObject<EntityType<DarkSteelSawEntity>> DARK_STEEL_SAW = register("dark_steel_saw", EntityType.Builder.<DarkSteelSawEntity>of(DarkSteelSawEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(1).setUpdateInterval(3).setCustomClientFactory(DarkSteelSawEntity::new).fireImmune().sized(0.1f, 0.6f));
	public static final RegistryObject<EntityType<PrisonGuardEntity>> PRISON_GUARD = register("prison_guard",
			EntityType.Builder.<PrisonGuardEntity>of(PrisonGuardEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PrisonGuardEntity::new)

					.sized(0.8f, 2.6f));
	public static final RegistryObject<EntityType<ShankPrisonerEntity>> SHANK_PRISONER = register("shank_prisoner",
			EntityType.Builder.<ShankPrisonerEntity>of(ShankPrisonerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ShankPrisonerEntity::new)

					.sized(0.6f, 1.9f));
	public static final RegistryObject<EntityType<GiantShadowHandEntity>> GIANT_SHADOW_HAND = register("giant_shadow_hand", EntityType.Builder.<GiantShadowHandEntity>of(GiantShadowHandEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GiantShadowHandEntity::new).fireImmune().sized(0.1f, 0.1f));
	public static final RegistryObject<EntityType<DarkDaggerEntity>> DARK_DAGGER = register("dark_dagger",
			EntityType.Builder.<DarkDaggerEntity>of(DarkDaggerEntity::new, MobCategory.MISC).setCustomClientFactory(DarkDaggerEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<HiveWatcherEntity>> HIVE_WATCHER = register("hive_watcher",
			EntityType.Builder.<HiveWatcherEntity>of(HiveWatcherEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(78).setUpdateInterval(3).setCustomClientFactory(HiveWatcherEntity::new)

					.sized(5f, 3f));
	public static final RegistryObject<EntityType<AmbrosiaSpitEntity>> AMBROSIA_SPIT = register("ambrosia_spit",
			EntityType.Builder.<AmbrosiaSpitEntity>of(AmbrosiaSpitEntity::new, MobCategory.MISC).setCustomClientFactory(AmbrosiaSpitEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<EyeOfTheWatcherEntity>> EYE_OF_THE_WATCHER = register("eye_of_the_watcher", EntityType.Builder.<EyeOfTheWatcherEntity>of(EyeOfTheWatcherEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(99).setUpdateInterval(3).setCustomClientFactory(EyeOfTheWatcherEntity::new).fireImmune().sized(1f, 1f));
	public static final RegistryObject<EntityType<IchorSpitEntity>> ICHOR_SPIT = register("ichor_spit",
			EntityType.Builder.<IchorSpitEntity>of(IchorSpitEntity::new, MobCategory.MISC).setCustomClientFactory(IchorSpitEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FleshWormEntity>> FLESH_WORM = register("flesh_worm",
			EntityType.Builder.<FleshWormEntity>of(FleshWormEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(80).setUpdateInterval(3).setCustomClientFactory(FleshWormEntity::new)

					.sized(2f, 8f));
	public static final RegistryObject<EntityType<ThumperEntityEntity>> THUMPER_ENTITY = register("thumper_entity", EntityType.Builder.<ThumperEntityEntity>of(ThumperEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ThumperEntityEntity::new).fireImmune().sized(1f, 1f));
	public static final RegistryObject<EntityType<BoneBlockadeEntity>> BONE_BLOCKADE = register("bone_blockade", EntityType.Builder.<BoneBlockadeEntity>of(BoneBlockadeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BoneBlockadeEntity::new).fireImmune().sized(1f, 3f));
	public static final RegistryObject<EntityType<FleshArrowEntity>> FLESH_ARROW = register("flesh_arrow",
			EntityType.Builder.<FleshArrowEntity>of(FleshArrowEntity::new, MobCategory.MISC).setCustomClientFactory(FleshArrowEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<BloodSpikeEntity>> BLOOD_SPIKE = register("blood_spike",
			EntityType.Builder.<BloodSpikeEntity>of(BloodSpikeEntity::new, MobCategory.MISC).setCustomClientFactory(BloodSpikeEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SpawnBoneSpikesEntity>> SPAWN_BONE_SPIKES = register("spawn_bone_spikes", EntityType.Builder.<SpawnBoneSpikesEntity>of(SpawnBoneSpikesEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SpawnBoneSpikesEntity::new).fireImmune().sized(0.1f, 0.1f));
	public static final RegistryObject<EntityType<NeedlefishProjEntity>> NEEDLEFISH_PROJ = register("needlefish_proj",
			EntityType.Builder.<NeedlefishProjEntity>of(NeedlefishProjEntity::new, MobCategory.MISC).setCustomClientFactory(NeedlefishProjEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FleshLampreyEntity>> FLESH_LAMPREY = register("flesh_lamprey",
			EntityType.Builder.<FleshLampreyEntity>of(FleshLampreyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FleshLampreyEntity::new)

					.sized(1.8f, 1f));
	public static final RegistryObject<EntityType<MaggotEntity>> MAGGOT = register("maggot",
			EntityType.Builder.<MaggotEntity>of(MaggotEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MaggotEntity::new)

					.sized(0.7f, 0.7f));
	public static final RegistryObject<EntityType<BlackFlyEntity>> BLACK_FLY = register("black_fly",
			EntityType.Builder.<BlackFlyEntity>of(BlackFlyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BlackFlyEntity::new)

					.sized(0.8f, 0.8f));
	public static final RegistryObject<EntityType<HiveFangsEntity>> HIVE_FANGS = register("hive_fangs",
			EntityType.Builder.<HiveFangsEntity>of(HiveFangsEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HiveFangsEntity::new).fireImmune().sized(1.4f, 2f));
	public static final RegistryObject<EntityType<SummonedHiveFangsEntity>> SUMMONED_HIVE_FANGS = register("summoned_hive_fangs", EntityType.Builder.<SummonedHiveFangsEntity>of(SummonedHiveFangsEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SummonedHiveFangsEntity::new).fireImmune().sized(1.4f, 2f));
	public static final RegistryObject<EntityType<VoidbornEntity>> VOIDBORN = register("voidborn",
			EntityType.Builder.<VoidbornEntity>of(VoidbornEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(78).setUpdateInterval(3).setCustomClientFactory(VoidbornEntity::new).fireImmune().sized(0.6f, 3f));
	public static final RegistryObject<EntityType<VoidbornTentaclesEntity>> VOIDBORN_TENTACLES = register("voidborn_tentacles", EntityType.Builder.<VoidbornTentaclesEntity>of(VoidbornTentaclesEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(VoidbornTentaclesEntity::new).fireImmune().sized(1f, 1f));
	public static final RegistryObject<EntityType<VoidPelletEntity>> VOID_PELLET = register("void_pellet",
			EntityType.Builder.<VoidPelletEntity>of(VoidPelletEntity::new, MobCategory.MISC).setCustomClientFactory(VoidPelletEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<GoldenRotArrowEntity>> GOLDEN_ROT_ARROW = register("golden_rot_arrow",
			EntityType.Builder.<GoldenRotArrowEntity>of(GoldenRotArrowEntity::new, MobCategory.MISC).setCustomClientFactory(GoldenRotArrowEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<GoreLurkerEntity>> GORE_LURKER = register("gore_lurker",
			EntityType.Builder.<GoreLurkerEntity>of(GoreLurkerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GoreLurkerEntity::new)

					.sized(2.8f, 2.8f));
	public static final RegistryObject<EntityType<HollowedEntity>> HOLLOWED = register("hollowed",
			EntityType.Builder.<HollowedEntity>of(HollowedEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HollowedEntity::new)

					.sized(1.2f, 4.5f));
	public static final RegistryObject<EntityType<MarrowRootsEntity>> MARROW_ROOTS = register("marrow_roots", EntityType.Builder.<MarrowRootsEntity>of(MarrowRootsEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MarrowRootsEntity::new).fireImmune().sized(0.8f, 1.4f));
	public static final RegistryObject<EntityType<MarrowRootsSpawnEntity>> MARROW_ROOTS_SPAWN = register("marrow_roots_spawn", EntityType.Builder.<MarrowRootsSpawnEntity>of(MarrowRootsSpawnEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MarrowRootsSpawnEntity::new).fireImmune().sized(0.1f, 0.1f));
	public static final RegistryObject<EntityType<RedFlareShotEntity>> RED_FLARE_SHOT = register("red_flare_shot",
			EntityType.Builder.<RedFlareShotEntity>of(RedFlareShotEntity::new, MobCategory.MISC).setCustomClientFactory(RedFlareShotEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<BrightFlareShotEntity>> BRIGHT_FLARE_SHOT = register("bright_flare_shot", EntityType.Builder.<BrightFlareShotEntity>of(BrightFlareShotEntity::new, MobCategory.MISC)
			.setCustomClientFactory(BrightFlareShotEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<XpFlareShotEntity>> XP_FLARE_SHOT = register("xp_flare_shot",
			EntityType.Builder.<XpFlareShotEntity>of(XpFlareShotEntity::new, MobCategory.MISC).setCustomClientFactory(XpFlareShotEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<GoldenFlareShotEntity>> GOLDEN_FLARE_SHOT = register("golden_flare_shot", EntityType.Builder.<GoldenFlareShotEntity>of(GoldenFlareShotEntity::new, MobCategory.MISC)
			.setCustomClientFactory(GoldenFlareShotEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SulfurFlareShotEntity>> SULFUR_FLARE_SHOT = register("sulfur_flare_shot", EntityType.Builder.<SulfurFlareShotEntity>of(SulfurFlareShotEntity::new, MobCategory.MISC)
			.setCustomClientFactory(SulfurFlareShotEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<XrayEntity>> XRAY = register("xray",
			EntityType.Builder.<XrayEntity>of(XrayEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(XrayEntity::new).fireImmune().sized(0.9f, 0.9f));
	public static final RegistryObject<EntityType<VoidriumFlareShotEntity>> VOIDRIUM_FLARE_SHOT = register("voidrium_flare_shot", EntityType.Builder.<VoidriumFlareShotEntity>of(VoidriumFlareShotEntity::new, MobCategory.MISC)
			.setCustomClientFactory(VoidriumFlareShotEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FleshFlareShotEntity>> FLESH_FLARE_SHOT = register("flesh_flare_shot",
			EntityType.Builder.<FleshFlareShotEntity>of(FleshFlareShotEntity::new, MobCategory.MISC).setCustomClientFactory(FleshFlareShotEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<PerilBulletEntity>> PERIL_BULLET = register("peril_bullet",
			EntityType.Builder.<PerilBulletEntity>of(PerilBulletEntity::new, MobCategory.MISC).setCustomClientFactory(PerilBulletEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			FallingCorpseEntity.init();
			GhostlyNightmareEntity.init();
			LightEntity.init();
			AmalgamEntity.init();
			SulfurTntEntityEntity.init();
			CathedralGhostEntity.init();
			GhostEntity.init();
			OverseerPillarEntity.init();
			BuiltOverseerPillarEntity.init();
			DeathMawHiddenEntity.init();
			MournerEntity.init();
			BoneCrawlerEntity.init();
			FoolEaterEntity.init();
			TamedBoneCrawlerEntity.init();
			LurkerEntity.init();
			StalkerEntity.init();
			AbductorEntity.init();
			VoidDwellerEntity.init();
			LickerEntity.init();
			FleshCubeEntity.init();
			SmallFleshCubeEntity.init();
			SporeSpewerEntity.init();
			WandererEntity.init();
			GravekeeperEntity.init();
			GooSpitterEntity.init();
			RoamerEntity.init();
			MotherBoneCrawlerEntity.init();
			TamedMotherBoneCrawlerEntity.init();
			AlphaBoneCrawlerEntity.init();
			TamedAlphaBoneCrawlerEntity.init();
			BabyBoneCrawlerEntity.init();
			BabyBoneCrawlerNeutralEntity.init();
			RottenCorpseEntity.init();
			RottenCultMemberEntity.init();
			EyekinEntity.init();
			EyekinFlyingEntity.init();
			SwarmerEntity.init();
			DeathMawEntity.init();
			BeholderEntity.init();
			EverhungerEntity.init();
			DeathVultureEntity.init();
			MuzzledDeathVultureEntity.init();
			DevourerEntity.init();
			RootedEntity.init();
			RootedCloneEntity.init();
			OverseerEntity.init();
			BuiltOverseerEntity.init();
			ScarecrowEntity.init();
			OverseerBigPillarEntity.init();
			BigOverseerEntity.init();
			BuiltBigOverseerPillarEntity.init();
			BuiltBigOverseerEntity.init();
			CentigazeEntity.init();
			CentigazeHiddenEntity.init();
			WatchingStalkerEntity.init();
			WeaverOfSoulsEntity.init();
			HandSpawnEntity.init();
			ShadowHandEntity.init();
			DamnedEntity.init();
			CrossEyesEntity.init();
			BigEyeEntity.init();
			MultipleEyesEntity.init();
			FourEyesEntity.init();
			SoulOrbEntity.init();
			ChainedWeaverEntity.init();
			DoomingTombstoneEntity.init();
			SummonedShadowHandEntity.init();
			ForsakenEntity.init();
			SeekerEntity.init();
			ApostleOfCatastropheEntity.init();
			IdlingApostleEntity.init();
			MisanthropicHivemindEntity.init();
			FleshFangsEntity.init();
			GoreExpectoratorEntity.init();
			HiveBrainEntity.init();
			RideableEyekinEntity.init();
			RideableFlyingEyekinEntity.init();
			SleepingPrimordialCrawlerEntity.init();
			HookEndEntity.init();
			PreserverEntity.init();
			LastingShadowHandEntity.init();
			GiantBoneCrawlerEggEntity.init();
			VoidTentacleEntity.init();
			SummonedDevourerEntity.init();
			MaskedHunterEntity.init();
			BoneCageEntity.init();
			BoneCageClosedEntity.init();
			GiantBoneSpikeEntity.init();
			BoneSawEntity.init();
			MimicEntity.init();
			SawThrowerEntity.init();
			SkullSmasherEntity.init();
			ElderMimicEntity.init();
			BogWalkerEntity.init();
			PrimordialBoneCrawlerEntity.init();
			HivemindTentaclesEntity.init();
			PenitentEntity.init();
			GaolerEntity.init();
			PlayerCageEntity.init();
			MimickingShadowEntity.init();
			PrisonerEntity.init();
			DarkSteelSawEntity.init();
			PrisonGuardEntity.init();
			ShankPrisonerEntity.init();
			GiantShadowHandEntity.init();
			HiveWatcherEntity.init();
			EyeOfTheWatcherEntity.init();
			FleshWormEntity.init();
			ThumperEntityEntity.init();
			BoneBlockadeEntity.init();
			SpawnBoneSpikesEntity.init();
			FleshLampreyEntity.init();
			MaggotEntity.init();
			BlackFlyEntity.init();
			HiveFangsEntity.init();
			SummonedHiveFangsEntity.init();
			VoidbornEntity.init();
			VoidbornTentaclesEntity.init();
			GoreLurkerEntity.init();
			HollowedEntity.init();
			MarrowRootsEntity.init();
			MarrowRootsSpawnEntity.init();
			XrayEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(FALLING_CORPSE.get(), FallingCorpseEntity.createAttributes().build());
		event.put(GHOSTLY_NIGHTMARE.get(), GhostlyNightmareEntity.createAttributes().build());
		event.put(LIGHT.get(), LightEntity.createAttributes().build());
		event.put(AMALGAM.get(), AmalgamEntity.createAttributes().build());
		event.put(SULFUR_TNT_ENTITY.get(), SulfurTntEntityEntity.createAttributes().build());
		event.put(CATHEDRAL_GHOST.get(), CathedralGhostEntity.createAttributes().build());
		event.put(GHOST.get(), GhostEntity.createAttributes().build());
		event.put(OVERSEER_PILLAR.get(), OverseerPillarEntity.createAttributes().build());
		event.put(BUILT_OVERSEER_PILLAR.get(), BuiltOverseerPillarEntity.createAttributes().build());
		event.put(DEATH_MAW_HIDDEN.get(), DeathMawHiddenEntity.createAttributes().build());
		event.put(MOURNER.get(), MournerEntity.createAttributes().build());
		event.put(BONE_CRAWLER.get(), BoneCrawlerEntity.createAttributes().build());
		event.put(FOOL_EATER.get(), FoolEaterEntity.createAttributes().build());
		event.put(TAMED_BONE_CRAWLER.get(), TamedBoneCrawlerEntity.createAttributes().build());
		event.put(LURKER.get(), LurkerEntity.createAttributes().build());
		event.put(STALKER.get(), StalkerEntity.createAttributes().build());
		event.put(ABDUCTOR.get(), AbductorEntity.createAttributes().build());
		event.put(VOID_DWELLER.get(), VoidDwellerEntity.createAttributes().build());
		event.put(LICKER.get(), LickerEntity.createAttributes().build());
		event.put(FLESH_CUBE.get(), FleshCubeEntity.createAttributes().build());
		event.put(SMALL_FLESH_CUBE.get(), SmallFleshCubeEntity.createAttributes().build());
		event.put(SPORE_SPEWER.get(), SporeSpewerEntity.createAttributes().build());
		event.put(WANDERER.get(), WandererEntity.createAttributes().build());
		event.put(GRAVEKEEPER.get(), GravekeeperEntity.createAttributes().build());
		event.put(GOO_SPITTER.get(), GooSpitterEntity.createAttributes().build());
		event.put(ROAMER.get(), RoamerEntity.createAttributes().build());
		event.put(MOTHER_BONE_CRAWLER.get(), MotherBoneCrawlerEntity.createAttributes().build());
		event.put(TAMED_MOTHER_BONE_CRAWLER.get(), TamedMotherBoneCrawlerEntity.createAttributes().build());
		event.put(ALPHA_BONE_CRAWLER.get(), AlphaBoneCrawlerEntity.createAttributes().build());
		event.put(TAMED_ALPHA_BONE_CRAWLER.get(), TamedAlphaBoneCrawlerEntity.createAttributes().build());
		event.put(BABY_BONE_CRAWLER.get(), BabyBoneCrawlerEntity.createAttributes().build());
		event.put(BABY_BONE_CRAWLER_NEUTRAL.get(), BabyBoneCrawlerNeutralEntity.createAttributes().build());
		event.put(ROTTEN_CORPSE.get(), RottenCorpseEntity.createAttributes().build());
		event.put(ROTTEN_CULT_MEMBER.get(), RottenCultMemberEntity.createAttributes().build());
		event.put(EYEKIN.get(), EyekinEntity.createAttributes().build());
		event.put(EYEKIN_FLYING.get(), EyekinFlyingEntity.createAttributes().build());
		event.put(SWARMER.get(), SwarmerEntity.createAttributes().build());
		event.put(DEATH_MAW.get(), DeathMawEntity.createAttributes().build());
		event.put(BEHOLDER.get(), BeholderEntity.createAttributes().build());
		event.put(EVERHUNGER.get(), EverhungerEntity.createAttributes().build());
		event.put(DEATH_VULTURE.get(), DeathVultureEntity.createAttributes().build());
		event.put(MUZZLED_DEATH_VULTURE.get(), MuzzledDeathVultureEntity.createAttributes().build());
		event.put(DEVOURER.get(), DevourerEntity.createAttributes().build());
		event.put(ROOTED.get(), RootedEntity.createAttributes().build());
		event.put(ROOTED_CLONE.get(), RootedCloneEntity.createAttributes().build());
		event.put(OVERSEER.get(), OverseerEntity.createAttributes().build());
		event.put(BUILT_OVERSEER.get(), BuiltOverseerEntity.createAttributes().build());
		event.put(SCARECROW.get(), ScarecrowEntity.createAttributes().build());
		event.put(OVERSEER_BIG_PILLAR.get(), OverseerBigPillarEntity.createAttributes().build());
		event.put(BIG_OVERSEER.get(), BigOverseerEntity.createAttributes().build());
		event.put(BUILT_BIG_OVERSEER_PILLAR.get(), BuiltBigOverseerPillarEntity.createAttributes().build());
		event.put(BUILT_BIG_OVERSEER.get(), BuiltBigOverseerEntity.createAttributes().build());
		event.put(CENTIGAZE.get(), CentigazeEntity.createAttributes().build());
		event.put(CENTIGAZE_HIDDEN.get(), CentigazeHiddenEntity.createAttributes().build());
		event.put(WATCHING_STALKER.get(), WatchingStalkerEntity.createAttributes().build());
		event.put(WEAVER_OF_SOULS.get(), WeaverOfSoulsEntity.createAttributes().build());
		event.put(HAND_SPAWN.get(), HandSpawnEntity.createAttributes().build());
		event.put(SHADOW_HAND.get(), ShadowHandEntity.createAttributes().build());
		event.put(DAMNED.get(), DamnedEntity.createAttributes().build());
		event.put(CROSS_EYES.get(), CrossEyesEntity.createAttributes().build());
		event.put(BIG_EYE.get(), BigEyeEntity.createAttributes().build());
		event.put(MULTIPLE_EYES.get(), MultipleEyesEntity.createAttributes().build());
		event.put(FOUR_EYES.get(), FourEyesEntity.createAttributes().build());
		event.put(SOUL_ORB.get(), SoulOrbEntity.createAttributes().build());
		event.put(CHAINED_WEAVER.get(), ChainedWeaverEntity.createAttributes().build());
		event.put(DOOMING_TOMBSTONE.get(), DoomingTombstoneEntity.createAttributes().build());
		event.put(SUMMONED_SHADOW_HAND.get(), SummonedShadowHandEntity.createAttributes().build());
		event.put(FORSAKEN.get(), ForsakenEntity.createAttributes().build());
		event.put(SEEKER.get(), SeekerEntity.createAttributes().build());
		event.put(APOSTLE_OF_CATASTROPHE.get(), ApostleOfCatastropheEntity.createAttributes().build());
		event.put(IDLING_APOSTLE.get(), IdlingApostleEntity.createAttributes().build());
		event.put(MISANTHROPIC_HIVEMIND.get(), MisanthropicHivemindEntity.createAttributes().build());
		event.put(FLESH_FANGS.get(), FleshFangsEntity.createAttributes().build());
		event.put(GORE_EXPECTORATOR.get(), GoreExpectoratorEntity.createAttributes().build());
		event.put(HIVE_BRAIN.get(), HiveBrainEntity.createAttributes().build());
		event.put(RIDEABLE_EYEKIN.get(), RideableEyekinEntity.createAttributes().build());
		event.put(RIDEABLE_FLYING_EYEKIN.get(), RideableFlyingEyekinEntity.createAttributes().build());
		event.put(SLEEPING_PRIMORDIAL_CRAWLER.get(), SleepingPrimordialCrawlerEntity.createAttributes().build());
		event.put(HOOK_END.get(), HookEndEntity.createAttributes().build());
		event.put(PRESERVER.get(), PreserverEntity.createAttributes().build());
		event.put(LASTING_SHADOW_HAND.get(), LastingShadowHandEntity.createAttributes().build());
		event.put(GIANT_BONE_CRAWLER_EGG.get(), GiantBoneCrawlerEggEntity.createAttributes().build());
		event.put(VOID_TENTACLE.get(), VoidTentacleEntity.createAttributes().build());
		event.put(SUMMONED_DEVOURER.get(), SummonedDevourerEntity.createAttributes().build());
		event.put(MASKED_HUNTER.get(), MaskedHunterEntity.createAttributes().build());
		event.put(BONE_CAGE.get(), BoneCageEntity.createAttributes().build());
		event.put(BONE_CAGE_CLOSED.get(), BoneCageClosedEntity.createAttributes().build());
		event.put(GIANT_BONE_SPIKE.get(), GiantBoneSpikeEntity.createAttributes().build());
		event.put(BONE_SAW.get(), BoneSawEntity.createAttributes().build());
		event.put(MIMIC.get(), MimicEntity.createAttributes().build());
		event.put(SAW_THROWER.get(), SawThrowerEntity.createAttributes().build());
		event.put(SKULL_SMASHER.get(), SkullSmasherEntity.createAttributes().build());
		event.put(ELDER_MIMIC.get(), ElderMimicEntity.createAttributes().build());
		event.put(BOG_WALKER.get(), BogWalkerEntity.createAttributes().build());
		event.put(PRIMORDIAL_BONE_CRAWLER.get(), PrimordialBoneCrawlerEntity.createAttributes().build());
		event.put(HIVEMIND_TENTACLES.get(), HivemindTentaclesEntity.createAttributes().build());
		event.put(PENITENT.get(), PenitentEntity.createAttributes().build());
		event.put(GAOLER.get(), GaolerEntity.createAttributes().build());
		event.put(PLAYER_CAGE.get(), PlayerCageEntity.createAttributes().build());
		event.put(MIMICKING_SHADOW.get(), MimickingShadowEntity.createAttributes().build());
		event.put(PRISONER.get(), PrisonerEntity.createAttributes().build());
		event.put(DARK_STEEL_SAW.get(), DarkSteelSawEntity.createAttributes().build());
		event.put(PRISON_GUARD.get(), PrisonGuardEntity.createAttributes().build());
		event.put(SHANK_PRISONER.get(), ShankPrisonerEntity.createAttributes().build());
		event.put(GIANT_SHADOW_HAND.get(), GiantShadowHandEntity.createAttributes().build());
		event.put(HIVE_WATCHER.get(), HiveWatcherEntity.createAttributes().build());
		event.put(EYE_OF_THE_WATCHER.get(), EyeOfTheWatcherEntity.createAttributes().build());
		event.put(FLESH_WORM.get(), FleshWormEntity.createAttributes().build());
		event.put(THUMPER_ENTITY.get(), ThumperEntityEntity.createAttributes().build());
		event.put(BONE_BLOCKADE.get(), BoneBlockadeEntity.createAttributes().build());
		event.put(SPAWN_BONE_SPIKES.get(), SpawnBoneSpikesEntity.createAttributes().build());
		event.put(FLESH_LAMPREY.get(), FleshLampreyEntity.createAttributes().build());
		event.put(MAGGOT.get(), MaggotEntity.createAttributes().build());
		event.put(BLACK_FLY.get(), BlackFlyEntity.createAttributes().build());
		event.put(HIVE_FANGS.get(), HiveFangsEntity.createAttributes().build());
		event.put(SUMMONED_HIVE_FANGS.get(), SummonedHiveFangsEntity.createAttributes().build());
		event.put(VOIDBORN.get(), VoidbornEntity.createAttributes().build());
		event.put(VOIDBORN_TENTACLES.get(), VoidbornTentaclesEntity.createAttributes().build());
		event.put(GORE_LURKER.get(), GoreLurkerEntity.createAttributes().build());
		event.put(HOLLOWED.get(), HollowedEntity.createAttributes().build());
		event.put(MARROW_ROOTS.get(), MarrowRootsEntity.createAttributes().build());
		event.put(MARROW_ROOTS_SPAWN.get(), MarrowRootsSpawnEntity.createAttributes().build());
		event.put(XRAY.get(), XrayEntity.createAttributes().build());
	}
}
