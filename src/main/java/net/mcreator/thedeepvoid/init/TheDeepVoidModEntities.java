
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

import net.mcreator.thedeepvoid.entity.WeaverOfSoulsEntity;
import net.mcreator.thedeepvoid.entity.WatchingStalkerEntity;
import net.mcreator.thedeepvoid.entity.WandererEntity;
import net.mcreator.thedeepvoid.entity.VoidDwellerEntity;
import net.mcreator.thedeepvoid.entity.ThrownSoulSeekerEntity;
import net.mcreator.thedeepvoid.entity.TenebrisCultroEntity;
import net.mcreator.thedeepvoid.entity.TamedMotherBoneCrawlerEntity;
import net.mcreator.thedeepvoid.entity.TamedBoneCrawlerEntity;
import net.mcreator.thedeepvoid.entity.TamedAlphaBoneCrawlerEntity;
import net.mcreator.thedeepvoid.entity.SwarmerEntity;
import net.mcreator.thedeepvoid.entity.SummonedShadowHandEntity;
import net.mcreator.thedeepvoid.entity.SummonedCharredSpikeEntity;
import net.mcreator.thedeepvoid.entity.SulfurTntEntityEntity;
import net.mcreator.thedeepvoid.entity.SulfurBombProjEntity;
import net.mcreator.thedeepvoid.entity.StalkingStalkerEntity;
import net.mcreator.thedeepvoid.entity.StalkerTreatThrownEntity;
import net.mcreator.thedeepvoid.entity.StalkerEntity;
import net.mcreator.thedeepvoid.entity.SporeSpewerEntity;
import net.mcreator.thedeepvoid.entity.SoulOrbEntity;
import net.mcreator.thedeepvoid.entity.SmallFleshCubeEntity;
import net.mcreator.thedeepvoid.entity.ShadowHandEntity;
import net.mcreator.thedeepvoid.entity.ShadowEntity;
import net.mcreator.thedeepvoid.entity.ShadeArrowEntity;
import net.mcreator.thedeepvoid.entity.ScarecrowEntity;
import net.mcreator.thedeepvoid.entity.RottenLickerHookEntity;
import net.mcreator.thedeepvoid.entity.RottenDartProjectileEntity;
import net.mcreator.thedeepvoid.entity.RottenCultMemberEntity;
import net.mcreator.thedeepvoid.entity.RottenCorpseEntity;
import net.mcreator.thedeepvoid.entity.RootedEntity;
import net.mcreator.thedeepvoid.entity.RootedCloneEntity;
import net.mcreator.thedeepvoid.entity.RoamerEntity;
import net.mcreator.thedeepvoid.entity.PusBallProjectileEntity;
import net.mcreator.thedeepvoid.entity.OverseerPillarEntity;
import net.mcreator.thedeepvoid.entity.OverseerEntity;
import net.mcreator.thedeepvoid.entity.OverseerBigPillarEntity;
import net.mcreator.thedeepvoid.entity.NightmareEntity;
import net.mcreator.thedeepvoid.entity.MuzzledDeathVultureEntity;
import net.mcreator.thedeepvoid.entity.MultipleEyesEntity;
import net.mcreator.thedeepvoid.entity.MrordyygothreEntity;
import net.mcreator.thedeepvoid.entity.MournerEntity;
import net.mcreator.thedeepvoid.entity.MotherBoneCrawlerEntity;
import net.mcreator.thedeepvoid.entity.LurkerEntity;
import net.mcreator.thedeepvoid.entity.LightEntity;
import net.mcreator.thedeepvoid.entity.LickerHookTongueEntity;
import net.mcreator.thedeepvoid.entity.LickerEntity;
import net.mcreator.thedeepvoid.entity.LavenditeShardProjEntity;
import net.mcreator.thedeepvoid.entity.HandSpawnEntity;
import net.mcreator.thedeepvoid.entity.HallucinationEntity;
import net.mcreator.thedeepvoid.entity.GravekeeperEntity;
import net.mcreator.thedeepvoid.entity.GooSpitterEntity;
import net.mcreator.thedeepvoid.entity.GhostlyNightmareEntity;
import net.mcreator.thedeepvoid.entity.GhostEntity;
import net.mcreator.thedeepvoid.entity.FourEyesEntity;
import net.mcreator.thedeepvoid.entity.FoolEaterEntity;
import net.mcreator.thedeepvoid.entity.FleshCubeEntity;
import net.mcreator.thedeepvoid.entity.FlareEntity;
import net.mcreator.thedeepvoid.entity.FallingCorpseEntity;
import net.mcreator.thedeepvoid.entity.EyekinFlyingEntity;
import net.mcreator.thedeepvoid.entity.EyekinEntity;
import net.mcreator.thedeepvoid.entity.EverhungerEntity;
import net.mcreator.thedeepvoid.entity.DoomingTombstoneEntity;
import net.mcreator.thedeepvoid.entity.DevourerHookTendrilEntity;
import net.mcreator.thedeepvoid.entity.DevourerEntity;
import net.mcreator.thedeepvoid.entity.DeathVultureEntity;
import net.mcreator.thedeepvoid.entity.DeathMawHiddenEntity;
import net.mcreator.thedeepvoid.entity.DeathMawEntity;
import net.mcreator.thedeepvoid.entity.DamnedEntity;
import net.mcreator.thedeepvoid.entity.CrossEyesEntity;
import net.mcreator.thedeepvoid.entity.CharredSpikeEntity;
import net.mcreator.thedeepvoid.entity.ChainedWeaverEntity;
import net.mcreator.thedeepvoid.entity.CentigazeHiddenEntity;
import net.mcreator.thedeepvoid.entity.CentigazeEntity;
import net.mcreator.thedeepvoid.entity.CathedralGhostEntity;
import net.mcreator.thedeepvoid.entity.BuiltOverseerPillarEntity;
import net.mcreator.thedeepvoid.entity.BuiltOverseerEntity;
import net.mcreator.thedeepvoid.entity.BuiltBigOverseerPillarEntity;
import net.mcreator.thedeepvoid.entity.BuiltBigOverseerEntity;
import net.mcreator.thedeepvoid.entity.BoneCrawlerEntity;
import net.mcreator.thedeepvoid.entity.BoneBallProjectileEntity;
import net.mcreator.thedeepvoid.entity.BlindProphetEntity;
import net.mcreator.thedeepvoid.entity.BigShadeArrowEntity;
import net.mcreator.thedeepvoid.entity.BigOverseerEntity;
import net.mcreator.thedeepvoid.entity.BigEyeEntity;
import net.mcreator.thedeepvoid.entity.BeholderEntity;
import net.mcreator.thedeepvoid.entity.BabyBoneCrawlerNeutralEntity;
import net.mcreator.thedeepvoid.entity.BabyBoneCrawlerEntity;
import net.mcreator.thedeepvoid.entity.AmalgamEntity;
import net.mcreator.thedeepvoid.entity.AlphaBoneCrawlerEntity;
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
	public static final RegistryObject<EntityType<LickerHookTongueEntity>> LICKER_HOOK_TONGUE = register("licker_hook_tongue", EntityType.Builder.<LickerHookTongueEntity>of(LickerHookTongueEntity::new, MobCategory.MISC)
			.setCustomClientFactory(LickerHookTongueEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<RottenLickerHookEntity>> ROTTEN_LICKER_HOOK = register("rotten_licker_hook", EntityType.Builder.<RottenLickerHookEntity>of(RottenLickerHookEntity::new, MobCategory.MISC)
			.setCustomClientFactory(RottenLickerHookEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<PusBallProjectileEntity>> PUS_BALL_PROJECTILE = register("pus_ball_projectile", EntityType.Builder.<PusBallProjectileEntity>of(PusBallProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(PusBallProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FlareEntity>> FLARE = register("flare",
			EntityType.Builder.<FlareEntity>of(FlareEntity::new, MobCategory.MISC).setCustomClientFactory(FlareEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<LightEntity>> LIGHT = register("light",
			EntityType.Builder.<LightEntity>of(LightEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LightEntity::new).fireImmune().sized(0.1f, 0.1f));
	public static final RegistryObject<EntityType<LavenditeShardProjEntity>> LAVENDITE_SHARD_PROJ = register("lavendite_shard_proj", EntityType.Builder.<LavenditeShardProjEntity>of(LavenditeShardProjEntity::new, MobCategory.MISC)
			.setCustomClientFactory(LavenditeShardProjEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<DevourerHookTendrilEntity>> DEVOURER_HOOK_TENDRIL = register("devourer_hook_tendril", EntityType.Builder.<DevourerHookTendrilEntity>of(DevourerHookTendrilEntity::new, MobCategory.MISC)
			.setCustomClientFactory(DevourerHookTendrilEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<AmalgamEntity>> AMALGAM = register("amalgam",
			EntityType.Builder.<AmalgamEntity>of(AmalgamEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AmalgamEntity::new)

					.sized(1f, 2f));
	public static final RegistryObject<EntityType<TenebrisCultroEntity>> DARK_DAGGER = register("dark_dagger",
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
	public static final RegistryObject<EntityType<ThrownSoulSeekerEntity>> THROWN_SOUL_SEEKER = register("thrown_soul_seeker", EntityType.Builder.<ThrownSoulSeekerEntity>of(ThrownSoulSeekerEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3).setCustomClientFactory(ThrownSoulSeekerEntity::new).fireImmune().sized(2f, 0.5f));
	public static final RegistryObject<EntityType<MrordyygothreEntity>> MRORDYYGOTHRE = register("mrordyygothre",
			EntityType.Builder.<MrordyygothreEntity>of(MrordyygothreEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(78).setUpdateInterval(3).setCustomClientFactory(MrordyygothreEntity::new)

					.sized(0.6f, 2f));
	public static final RegistryObject<EntityType<CharredSpikeEntity>> CHARRED_SPIKE = register("charred_spike", EntityType.Builder.<CharredSpikeEntity>of(CharredSpikeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(1).setUpdateInterval(3).setCustomClientFactory(CharredSpikeEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BlindProphetEntity>> BLIND_PROPHET = register("blind_prophet",
			EntityType.Builder.<BlindProphetEntity>of(BlindProphetEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(78).setUpdateInterval(3).setCustomClientFactory(BlindProphetEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SummonedCharredSpikeEntity>> SUMMONED_CHARRED_SPIKE = register("summoned_charred_spike", EntityType.Builder.<SummonedCharredSpikeEntity>of(SummonedCharredSpikeEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3).setCustomClientFactory(SummonedCharredSpikeEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ShadeArrowEntity>> SHADE_ARROW = register("shade_arrow",
			EntityType.Builder.<ShadeArrowEntity>of(ShadeArrowEntity::new, MobCategory.MISC).setCustomClientFactory(ShadeArrowEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<BigShadeArrowEntity>> BIG_SHADE_ARROW = register("big_shade_arrow",
			EntityType.Builder.<BigShadeArrowEntity>of(BigShadeArrowEntity::new, MobCategory.MISC).setCustomClientFactory(BigShadeArrowEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MournerEntity>> MOURNER = register("mourner",
			EntityType.Builder.<MournerEntity>of(MournerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(34).setUpdateInterval(3).setCustomClientFactory(MournerEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BoneCrawlerEntity>> BONE_CRAWLER = register("bone_crawler",
			EntityType.Builder.<BoneCrawlerEntity>of(BoneCrawlerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BoneCrawlerEntity::new)

					.sized(0.8f, 0.5f));
	public static final RegistryObject<EntityType<FoolEaterEntity>> FOOL_EATER = register("fool_eater",
			EntityType.Builder.<FoolEaterEntity>of(FoolEaterEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FoolEaterEntity::new)

					.sized(1f, 4f));
	public static final RegistryObject<EntityType<TamedBoneCrawlerEntity>> TAMED_BONE_CRAWLER = register("tamed_bone_crawler",
			EntityType.Builder.<TamedBoneCrawlerEntity>of(TamedBoneCrawlerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TamedBoneCrawlerEntity::new)

					.sized(0.8f, 0.5f));
	public static final RegistryObject<EntityType<HallucinationEntity>> HALLUCINATION = register("hallucination", EntityType.Builder.<HallucinationEntity>of(HallucinationEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HallucinationEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<LurkerEntity>> LURKER = register("lurker",
			EntityType.Builder.<LurkerEntity>of(LurkerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LurkerEntity::new)

					.sized(0.6f, 2.4f));
	public static final RegistryObject<EntityType<StalkerEntity>> STALKER = register("stalker",
			EntityType.Builder.<StalkerEntity>of(StalkerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(125).setUpdateInterval(3).setCustomClientFactory(StalkerEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<AbductorEntity>> ABDUCTOR = register("abductor",
			EntityType.Builder.<AbductorEntity>of(AbductorEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(70).setUpdateInterval(3).setCustomClientFactory(AbductorEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<VoidDwellerEntity>> VOID_DWELLER = register("void_dweller",
			EntityType.Builder.<VoidDwellerEntity>of(VoidDwellerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(VoidDwellerEntity::new)

					.sized(0.6f, 2.4f));
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

					.sized(0.6f, 2.6f));
	public static final RegistryObject<EntityType<GooSpitterEntity>> GOO_SPITTER = register("goo_spitter",
			EntityType.Builder.<GooSpitterEntity>of(GooSpitterEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GooSpitterEntity::new)

					.sized(0.8f, 0.5f));
	public static final RegistryObject<EntityType<RoamerEntity>> ROAMER = register("roamer",
			EntityType.Builder.<RoamerEntity>of(RoamerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RoamerEntity::new)

					.sized(2f, 1.4f));
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

					.sized(1.8f, 2.4f));
	public static final RegistryObject<EntityType<EyekinFlyingEntity>> EYEKIN_FLYING = register("eyekin_flying",
			EntityType.Builder.<EyekinFlyingEntity>of(EyekinFlyingEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(78).setUpdateInterval(3).setCustomClientFactory(EyekinFlyingEntity::new)

					.sized(3f, 1f));
	public static final RegistryObject<EntityType<SwarmerEntity>> SWARMER = register("swarmer",
			EntityType.Builder.<SwarmerEntity>of(SwarmerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SwarmerEntity::new)

					.sized(1f, 1f));
	public static final RegistryObject<EntityType<DeathMawEntity>> DEATH_MAW = register("death_maw",
			EntityType.Builder.<DeathMawEntity>of(DeathMawEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DeathMawEntity::new)

					.sized(1.6f, 1.8f));
	public static final RegistryObject<EntityType<BeholderEntity>> BEHOLDER = register("beholder",
			EntityType.Builder.<BeholderEntity>of(BeholderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BeholderEntity::new)

					.sized(0.6f, 1.5f));
	public static final RegistryObject<EntityType<EverhungerEntity>> EVERHUNGER = register("everhunger",
			EntityType.Builder.<EverhungerEntity>of(EverhungerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(78).setUpdateInterval(3).setCustomClientFactory(EverhungerEntity::new)

					.sized(0.8f, 2f));
	public static final RegistryObject<EntityType<DeathVultureEntity>> DEATH_VULTURE = register("death_vulture",
			EntityType.Builder.<DeathVultureEntity>of(DeathVultureEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(80).setUpdateInterval(3).setCustomClientFactory(DeathVultureEntity::new)

					.sized(0.7f, 1.8f));
	public static final RegistryObject<EntityType<MuzzledDeathVultureEntity>> MUZZLED_DEATH_VULTURE = register("muzzled_death_vulture",
			EntityType.Builder.<MuzzledDeathVultureEntity>of(MuzzledDeathVultureEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(70).setUpdateInterval(3).setCustomClientFactory(MuzzledDeathVultureEntity::new)

					.sized(1f, 1.8f));
	public static final RegistryObject<EntityType<DevourerEntity>> DEVOURER = register("devourer",
			EntityType.Builder.<DevourerEntity>of(DevourerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DevourerEntity::new).fireImmune().sized(0.6f, 2.4f));
	public static final RegistryObject<EntityType<RootedEntity>> ROOTED = register("rooted",
			EntityType.Builder.<RootedEntity>of(RootedEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RootedEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<RootedCloneEntity>> ROOTED_CLONE = register("rooted_clone",
			EntityType.Builder.<RootedCloneEntity>of(RootedCloneEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RootedCloneEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<OverseerEntity>> OVERSEER = register("overseer",
			EntityType.Builder.<OverseerEntity>of(OverseerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(OverseerEntity::new).fireImmune().sized(1f, 2f));
	public static final RegistryObject<EntityType<BuiltOverseerEntity>> BUILT_OVERSEER = register("built_overseer", EntityType.Builder.<BuiltOverseerEntity>of(BuiltOverseerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BuiltOverseerEntity::new).fireImmune().sized(1f, 2f));
	public static final RegistryObject<EntityType<ScarecrowEntity>> SCARECROW = register("scarecrow",
			EntityType.Builder.<ScarecrowEntity>of(ScarecrowEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ScarecrowEntity::new)

					.sized(1.2f, 6f));
	public static final RegistryObject<EntityType<NightmareEntity>> NIGHTMARE = register("nightmare", EntityType.Builder.<NightmareEntity>of(NightmareEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(84)
			.setUpdateInterval(3).setCustomClientFactory(NightmareEntity::new).fireImmune().sized(0.6f, 1.8f));
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

					.sized(1.8f, 0.8f));
	public static final RegistryObject<EntityType<CentigazeHiddenEntity>> CENTIGAZE_HIDDEN = register("centigaze_hidden", EntityType.Builder.<CentigazeHiddenEntity>of(CentigazeHiddenEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(78).setUpdateInterval(3).setCustomClientFactory(CentigazeHiddenEntity::new).fireImmune().sized(1.8f, 0.8f));
	public static final RegistryObject<EntityType<StalkingStalkerEntity>> STALKING_STALKER = register("stalking_stalker", EntityType.Builder.<StalkingStalkerEntity>of(StalkingStalkerEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(125).setUpdateInterval(3).setCustomClientFactory(StalkingStalkerEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ShadowEntity>> SHADOW = register("shadow",
			EntityType.Builder.<ShadowEntity>of(ShadowEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ShadowEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<WatchingStalkerEntity>> WATCHING_STALKER = register("watching_stalker", EntityType.Builder.<WatchingStalkerEntity>of(WatchingStalkerEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(84).setUpdateInterval(3).setCustomClientFactory(WatchingStalkerEntity::new).fireImmune().sized(0.6f, 1.8f));
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

					.sized(0.8f, 0.8f));
	public static final RegistryObject<EntityType<ChainedWeaverEntity>> CHAINED_WEAVER = register("chained_weaver", EntityType.Builder.<ChainedWeaverEntity>of(ChainedWeaverEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ChainedWeaverEntity::new).fireImmune().sized(2.8f, 2.8f));
	public static final RegistryObject<EntityType<DoomingTombstoneEntity>> DOOMING_TOMBSTONE = register("dooming_tombstone", EntityType.Builder.<DoomingTombstoneEntity>of(DoomingTombstoneEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3).setCustomClientFactory(DoomingTombstoneEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SummonedShadowHandEntity>> SUMMONED_SHADOW_HAND = register("summoned_shadow_hand", EntityType.Builder.<SummonedShadowHandEntity>of(SummonedShadowHandEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SummonedShadowHandEntity::new).fireImmune().sized(0.4f, 1.8f));

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
			ThrownSoulSeekerEntity.init();
			MrordyygothreEntity.init();
			CharredSpikeEntity.init();
			BlindProphetEntity.init();
			SummonedCharredSpikeEntity.init();
			MournerEntity.init();
			BoneCrawlerEntity.init();
			FoolEaterEntity.init();
			TamedBoneCrawlerEntity.init();
			HallucinationEntity.init();
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
			NightmareEntity.init();
			OverseerBigPillarEntity.init();
			BigOverseerEntity.init();
			BuiltBigOverseerPillarEntity.init();
			BuiltBigOverseerEntity.init();
			CentigazeEntity.init();
			CentigazeHiddenEntity.init();
			StalkingStalkerEntity.init();
			ShadowEntity.init();
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
		event.put(THROWN_SOUL_SEEKER.get(), ThrownSoulSeekerEntity.createAttributes().build());
		event.put(MRORDYYGOTHRE.get(), MrordyygothreEntity.createAttributes().build());
		event.put(CHARRED_SPIKE.get(), CharredSpikeEntity.createAttributes().build());
		event.put(BLIND_PROPHET.get(), BlindProphetEntity.createAttributes().build());
		event.put(SUMMONED_CHARRED_SPIKE.get(), SummonedCharredSpikeEntity.createAttributes().build());
		event.put(MOURNER.get(), MournerEntity.createAttributes().build());
		event.put(BONE_CRAWLER.get(), BoneCrawlerEntity.createAttributes().build());
		event.put(FOOL_EATER.get(), FoolEaterEntity.createAttributes().build());
		event.put(TAMED_BONE_CRAWLER.get(), TamedBoneCrawlerEntity.createAttributes().build());
		event.put(HALLUCINATION.get(), HallucinationEntity.createAttributes().build());
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
		event.put(NIGHTMARE.get(), NightmareEntity.createAttributes().build());
		event.put(OVERSEER_BIG_PILLAR.get(), OverseerBigPillarEntity.createAttributes().build());
		event.put(BIG_OVERSEER.get(), BigOverseerEntity.createAttributes().build());
		event.put(BUILT_BIG_OVERSEER_PILLAR.get(), BuiltBigOverseerPillarEntity.createAttributes().build());
		event.put(BUILT_BIG_OVERSEER.get(), BuiltBigOverseerEntity.createAttributes().build());
		event.put(CENTIGAZE.get(), CentigazeEntity.createAttributes().build());
		event.put(CENTIGAZE_HIDDEN.get(), CentigazeHiddenEntity.createAttributes().build());
		event.put(STALKING_STALKER.get(), StalkingStalkerEntity.createAttributes().build());
		event.put(SHADOW.get(), ShadowEntity.createAttributes().build());
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
	}
}
