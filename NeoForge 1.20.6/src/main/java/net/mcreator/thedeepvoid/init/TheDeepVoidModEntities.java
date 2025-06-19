
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedeepvoid.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.SpawnPlacementRegisterEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

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
import net.mcreator.thedeepvoid.entity.SeekerEntity;
import net.mcreator.thedeepvoid.entity.ScarecrowEntity;
import net.mcreator.thedeepvoid.entity.RottenLickerHookEntity;
import net.mcreator.thedeepvoid.entity.RottenDartProjectileEntity;
import net.mcreator.thedeepvoid.entity.RottenCultMemberEntity;
import net.mcreator.thedeepvoid.entity.RottenCorpseEntity;
import net.mcreator.thedeepvoid.entity.RotKnifeEntity;
import net.mcreator.thedeepvoid.entity.RootedEntity;
import net.mcreator.thedeepvoid.entity.RootedCloneEntity;
import net.mcreator.thedeepvoid.entity.RoamerEntity;
import net.mcreator.thedeepvoid.entity.RideableFlyingEyekinEntity;
import net.mcreator.thedeepvoid.entity.RideableEyekinEntity;
import net.mcreator.thedeepvoid.entity.PusBallProjectileEntity;
import net.mcreator.thedeepvoid.entity.PoisonKnifeEntity;
import net.mcreator.thedeepvoid.entity.OverseerPillarEntity;
import net.mcreator.thedeepvoid.entity.OverseerEntity;
import net.mcreator.thedeepvoid.entity.OverseerBigPillarEntity;
import net.mcreator.thedeepvoid.entity.NightmareEntity;
import net.mcreator.thedeepvoid.entity.MuzzledDeathVultureEntity;
import net.mcreator.thedeepvoid.entity.MultipleEyesEntity;
import net.mcreator.thedeepvoid.entity.MournerEntity;
import net.mcreator.thedeepvoid.entity.MotherBoneCrawlerEntity;
import net.mcreator.thedeepvoid.entity.MisanthropicHivemindEntity;
import net.mcreator.thedeepvoid.entity.LurkerEntity;
import net.mcreator.thedeepvoid.entity.LightEntity;
import net.mcreator.thedeepvoid.entity.LickerHookTongueEntity;
import net.mcreator.thedeepvoid.entity.LickerEntity;
import net.mcreator.thedeepvoid.entity.LavenditeShardProjEntity;
import net.mcreator.thedeepvoid.entity.IdlingApostleEntity;
import net.mcreator.thedeepvoid.entity.HiveBrainEntity;
import net.mcreator.thedeepvoid.entity.HandSpawnEntity;
import net.mcreator.thedeepvoid.entity.HallucinationEntity;
import net.mcreator.thedeepvoid.entity.GravekeeperEntity;
import net.mcreator.thedeepvoid.entity.GoreExpectoratorEntity;
import net.mcreator.thedeepvoid.entity.GooSpitterEntity;
import net.mcreator.thedeepvoid.entity.GoldenBloodshotEntity;
import net.mcreator.thedeepvoid.entity.GhostlyNightmareEntity;
import net.mcreator.thedeepvoid.entity.GhostEntity;
import net.mcreator.thedeepvoid.entity.FourEyesEntity;
import net.mcreator.thedeepvoid.entity.ForsakenEntity;
import net.mcreator.thedeepvoid.entity.FoolEaterEntity;
import net.mcreator.thedeepvoid.entity.FleshFangsEntity;
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
import net.mcreator.thedeepvoid.entity.BloodshotEntity;
import net.mcreator.thedeepvoid.entity.BloodSpitEntity;
import net.mcreator.thedeepvoid.entity.BigShadeArrowEntity;
import net.mcreator.thedeepvoid.entity.BigOverseerEntity;
import net.mcreator.thedeepvoid.entity.BigEyeEntity;
import net.mcreator.thedeepvoid.entity.BeholderEntity;
import net.mcreator.thedeepvoid.entity.BabyBoneCrawlerNeutralEntity;
import net.mcreator.thedeepvoid.entity.BabyBoneCrawlerEntity;
import net.mcreator.thedeepvoid.entity.ApostleOfCatastropheEntity;
import net.mcreator.thedeepvoid.entity.AmalgamEntity;
import net.mcreator.thedeepvoid.entity.AlphaBoneCrawlerEntity;
import net.mcreator.thedeepvoid.entity.AcidSpitEntity;
import net.mcreator.thedeepvoid.entity.AbductorEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class TheDeepVoidModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, TheDeepVoidMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<FallingCorpseEntity>> FALLING_CORPSE = register("falling_corpse",
			EntityType.Builder.<FallingCorpseEntity>of(FallingCorpseEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<BoneBallProjectileEntity>> BONE_BALL_PROJECTILE = register("bone_ball_projectile",
			EntityType.Builder.<BoneBallProjectileEntity>of(BoneBallProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<GhostlyNightmareEntity>> GHOSTLY_NIGHTMARE = register("ghostly_nightmare",
			EntityType.Builder.<GhostlyNightmareEntity>of(GhostlyNightmareEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(84).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<RottenDartProjectileEntity>> ROTTEN_DART_PROJECTILE = register("rotten_dart_projectile",
			EntityType.Builder.<RottenDartProjectileEntity>of(RottenDartProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<LickerHookTongueEntity>> LICKER_HOOK_TONGUE = register("licker_hook_tongue",
			EntityType.Builder.<LickerHookTongueEntity>of(LickerHookTongueEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<RottenLickerHookEntity>> ROTTEN_LICKER_HOOK = register("rotten_licker_hook",
			EntityType.Builder.<RottenLickerHookEntity>of(RottenLickerHookEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<PusBallProjectileEntity>> PUS_BALL_PROJECTILE = register("pus_ball_projectile",
			EntityType.Builder.<PusBallProjectileEntity>of(PusBallProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<FlareEntity>> FLARE = register("flare",
			EntityType.Builder.<FlareEntity>of(FlareEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<LightEntity>> LIGHT = register("light",
			EntityType.Builder.<LightEntity>of(LightEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.1f, 0.1f));
	public static final DeferredHolder<EntityType<?>, EntityType<LavenditeShardProjEntity>> LAVENDITE_SHARD_PROJ = register("lavendite_shard_proj",
			EntityType.Builder.<LavenditeShardProjEntity>of(LavenditeShardProjEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<DevourerHookTendrilEntity>> DEVOURER_HOOK_TENDRIL = register("devourer_hook_tendril",
			EntityType.Builder.<DevourerHookTendrilEntity>of(DevourerHookTendrilEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<AmalgamEntity>> AMALGAM = register("amalgam",
			EntityType.Builder.<AmalgamEntity>of(AmalgamEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(3f, 3f));
	public static final DeferredHolder<EntityType<?>, EntityType<TenebrisCultroEntity>> DARK_DAGGER = register("dark_dagger",
			EntityType.Builder.<TenebrisCultroEntity>of(TenebrisCultroEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<SulfurTntEntityEntity>> SULFUR_TNT_ENTITY = register("sulfur_tnt_entity",
			EntityType.Builder.<SulfurTntEntityEntity>of(SulfurTntEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3).fireImmune().sized(1f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<CathedralGhostEntity>> CATHEDRAL_GHOST = register("cathedral_ghost",
			EntityType.Builder.<CathedralGhostEntity>of(CathedralGhostEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<GhostEntity>> GHOST = register("ghost",
			EntityType.Builder.<GhostEntity>of(GhostEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<OverseerPillarEntity>> OVERSEER_PILLAR = register("overseer_pillar",
			EntityType.Builder.<OverseerPillarEntity>of(OverseerPillarEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(1f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<BuiltOverseerPillarEntity>> BUILT_OVERSEER_PILLAR = register("built_overseer_pillar",
			EntityType.Builder.<BuiltOverseerPillarEntity>of(BuiltOverseerPillarEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(1f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<DeathMawHiddenEntity>> DEATH_MAW_HIDDEN = register("death_maw_hidden",
			EntityType.Builder.<DeathMawHiddenEntity>of(DeathMawHiddenEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.6f, 0.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<SulfurBombProjEntity>> SULFUR_BOMB_PROJ = register("sulfur_bomb_proj",
			EntityType.Builder.<SulfurBombProjEntity>of(SulfurBombProjEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<ThrownSoulSeekerEntity>> THROWN_SOUL_SEEKER = register("thrown_soul_seeker",
			EntityType.Builder.<ThrownSoulSeekerEntity>of(ThrownSoulSeekerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3).fireImmune().sized(2f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<CharredSpikeEntity>> CHARRED_SPIKE = register("charred_spike",
			EntityType.Builder.<CharredSpikeEntity>of(CharredSpikeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<SummonedCharredSpikeEntity>> SUMMONED_CHARRED_SPIKE = register("summoned_charred_spike",
			EntityType.Builder.<SummonedCharredSpikeEntity>of(SummonedCharredSpikeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<ShadeArrowEntity>> SHADE_ARROW = register("shade_arrow",
			EntityType.Builder.<ShadeArrowEntity>of(ShadeArrowEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<BigShadeArrowEntity>> BIG_SHADE_ARROW = register("big_shade_arrow",
			EntityType.Builder.<BigShadeArrowEntity>of(BigShadeArrowEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<MournerEntity>> MOURNER = register("mourner",
			EntityType.Builder.<MournerEntity>of(MournerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(34).setUpdateInterval(3)

					.sized(0.6f, 2.4f));
	public static final DeferredHolder<EntityType<?>, EntityType<BoneCrawlerEntity>> BONE_CRAWLER = register("bone_crawler",
			EntityType.Builder.<BoneCrawlerEntity>of(BoneCrawlerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.8f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<FoolEaterEntity>> FOOL_EATER = register("fool_eater",
			EntityType.Builder.<FoolEaterEntity>of(FoolEaterEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1f, 5.6f));
	public static final DeferredHolder<EntityType<?>, EntityType<TamedBoneCrawlerEntity>> TAMED_BONE_CRAWLER = register("tamed_bone_crawler",
			EntityType.Builder.<TamedBoneCrawlerEntity>of(TamedBoneCrawlerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.8f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<HallucinationEntity>> HALLUCINATION = register("hallucination",
			EntityType.Builder.<HallucinationEntity>of(HallucinationEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<LurkerEntity>> LURKER = register("lurker",
			EntityType.Builder.<LurkerEntity>of(LurkerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.8f, 3.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<StalkerEntity>> STALKER = register("stalker",
			EntityType.Builder.<StalkerEntity>of(StalkerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(125).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<AbductorEntity>> ABDUCTOR = register("abductor",
			EntityType.Builder.<AbductorEntity>of(AbductorEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(70).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<VoidDwellerEntity>> VOID_DWELLER = register("void_dweller",
			EntityType.Builder.<VoidDwellerEntity>of(VoidDwellerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 3f));
	public static final DeferredHolder<EntityType<?>, EntityType<LickerEntity>> LICKER = register("licker",
			EntityType.Builder.<LickerEntity>of(LickerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<FleshCubeEntity>> FLESH_CUBE = register("flesh_cube",
			EntityType.Builder.<FleshCubeEntity>of(FleshCubeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.2f, 1.2f));
	public static final DeferredHolder<EntityType<?>, EntityType<SmallFleshCubeEntity>> SMALL_FLESH_CUBE = register("small_flesh_cube",
			EntityType.Builder.<SmallFleshCubeEntity>of(SmallFleshCubeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 0.6f));
	public static final DeferredHolder<EntityType<?>, EntityType<SporeSpewerEntity>> SPORE_SPEWER = register("spore_spewer",
			EntityType.Builder.<SporeSpewerEntity>of(SporeSpewerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<WandererEntity>> WANDERER = register("wanderer",
			EntityType.Builder.<WandererEntity>of(WandererEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.2f, 2.2f));
	public static final DeferredHolder<EntityType<?>, EntityType<GravekeeperEntity>> GRAVEKEEPER = register("gravekeeper",
			EntityType.Builder.<GravekeeperEntity>of(GravekeeperEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(66).setUpdateInterval(3)

					.sized(0.6f, 2.9f));
	public static final DeferredHolder<EntityType<?>, EntityType<GooSpitterEntity>> GOO_SPITTER = register("goo_spitter",
			EntityType.Builder.<GooSpitterEntity>of(GooSpitterEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.8f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<RoamerEntity>> ROAMER = register("roamer",
			EntityType.Builder.<RoamerEntity>of(RoamerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(2f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<MotherBoneCrawlerEntity>> MOTHER_BONE_CRAWLER = register("mother_bone_crawler",
			EntityType.Builder.<MotherBoneCrawlerEntity>of(MotherBoneCrawlerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(2f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<TamedMotherBoneCrawlerEntity>> TAMED_MOTHER_BONE_CRAWLER = register("tamed_mother_bone_crawler",
			EntityType.Builder.<TamedMotherBoneCrawlerEntity>of(TamedMotherBoneCrawlerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<AlphaBoneCrawlerEntity>> ALPHA_BONE_CRAWLER = register("alpha_bone_crawler",
			EntityType.Builder.<AlphaBoneCrawlerEntity>of(AlphaBoneCrawlerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.6f, 1.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<TamedAlphaBoneCrawlerEntity>> TAMED_ALPHA_BONE_CRAWLER = register("tamed_alpha_bone_crawler",
			EntityType.Builder.<TamedAlphaBoneCrawlerEntity>of(TamedAlphaBoneCrawlerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.6f, 1.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<BabyBoneCrawlerEntity>> BABY_BONE_CRAWLER = register("baby_bone_crawler",
			EntityType.Builder.<BabyBoneCrawlerEntity>of(BabyBoneCrawlerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.8f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<BabyBoneCrawlerNeutralEntity>> BABY_BONE_CRAWLER_NEUTRAL = register("baby_bone_crawler_neutral",
			EntityType.Builder.<BabyBoneCrawlerNeutralEntity>of(BabyBoneCrawlerNeutralEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.8f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<RottenCorpseEntity>> ROTTEN_CORPSE = register("rotten_corpse",
			EntityType.Builder.<RottenCorpseEntity>of(RottenCorpseEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<RottenCultMemberEntity>> ROTTEN_CULT_MEMBER = register("rotten_cult_member",
			EntityType.Builder.<RottenCultMemberEntity>of(RottenCultMemberEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<EyekinEntity>> EYEKIN = register("eyekin",
			EntityType.Builder.<EyekinEntity>of(EyekinEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(74).setUpdateInterval(3)

					.sized(2.2f, 3.2f));
	public static final DeferredHolder<EntityType<?>, EntityType<EyekinFlyingEntity>> EYEKIN_FLYING = register("eyekin_flying",
			EntityType.Builder.<EyekinFlyingEntity>of(EyekinFlyingEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(78).setUpdateInterval(3)

					.sized(3f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<SwarmerEntity>> SWARMER = register("swarmer",
			EntityType.Builder.<SwarmerEntity>of(SwarmerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<DeathMawEntity>> DEATH_MAW = register("death_maw",
			EntityType.Builder.<DeathMawEntity>of(DeathMawEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.6f, 2.1f));
	public static final DeferredHolder<EntityType<?>, EntityType<BeholderEntity>> BEHOLDER = register("beholder",
			EntityType.Builder.<BeholderEntity>of(BeholderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<EverhungerEntity>> EVERHUNGER = register("everhunger",
			EntityType.Builder.<EverhungerEntity>of(EverhungerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(78).setUpdateInterval(3)

					.sized(1f, 3.4f));
	public static final DeferredHolder<EntityType<?>, EntityType<DeathVultureEntity>> DEATH_VULTURE = register("death_vulture",
			EntityType.Builder.<DeathVultureEntity>of(DeathVultureEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(80).setUpdateInterval(3)

					.sized(0.9f, 1.9f));
	public static final DeferredHolder<EntityType<?>, EntityType<MuzzledDeathVultureEntity>> MUZZLED_DEATH_VULTURE = register("muzzled_death_vulture",
			EntityType.Builder.<MuzzledDeathVultureEntity>of(MuzzledDeathVultureEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(70).setUpdateInterval(3)

					.sized(0.9f, 1.9f));
	public static final DeferredHolder<EntityType<?>, EntityType<DevourerEntity>> DEVOURER = register("devourer",
			EntityType.Builder.<DevourerEntity>of(DevourerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.8f, 2.9f));
	public static final DeferredHolder<EntityType<?>, EntityType<RootedEntity>> ROOTED = register("rooted",
			EntityType.Builder.<RootedEntity>of(RootedEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.8f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<RootedCloneEntity>> ROOTED_CLONE = register("rooted_clone",
			EntityType.Builder.<RootedCloneEntity>of(RootedCloneEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.8f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<OverseerEntity>> OVERSEER = register("overseer",
			EntityType.Builder.<OverseerEntity>of(OverseerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(1f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<BuiltOverseerEntity>> BUILT_OVERSEER = register("built_overseer",
			EntityType.Builder.<BuiltOverseerEntity>of(BuiltOverseerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(1f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<ScarecrowEntity>> SCARECROW = register("scarecrow",
			EntityType.Builder.<ScarecrowEntity>of(ScarecrowEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(2.8f, 18f));
	public static final DeferredHolder<EntityType<?>, EntityType<NightmareEntity>> NIGHTMARE = register("nightmare",
			EntityType.Builder.<NightmareEntity>of(NightmareEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(84).setUpdateInterval(3).fireImmune().sized(0.8f, 1.9f));
	public static final DeferredHolder<EntityType<?>, EntityType<StalkerTreatThrownEntity>> STALKER_TREAT_THROWN = register("stalker_treat_thrown",
			EntityType.Builder.<StalkerTreatThrownEntity>of(StalkerTreatThrownEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<OverseerBigPillarEntity>> OVERSEER_BIG_PILLAR = register("overseer_big_pillar",
			EntityType.Builder.<OverseerBigPillarEntity>of(OverseerBigPillarEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(1f, 3f));
	public static final DeferredHolder<EntityType<?>, EntityType<BigOverseerEntity>> BIG_OVERSEER = register("big_overseer",
			EntityType.Builder.<BigOverseerEntity>of(BigOverseerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(1f, 3f));
	public static final DeferredHolder<EntityType<?>, EntityType<BuiltBigOverseerPillarEntity>> BUILT_BIG_OVERSEER_PILLAR = register("built_big_overseer_pillar",
			EntityType.Builder.<BuiltBigOverseerPillarEntity>of(BuiltBigOverseerPillarEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(1f, 3f));
	public static final DeferredHolder<EntityType<?>, EntityType<BuiltBigOverseerEntity>> BUILT_BIG_OVERSEER = register("built_big_overseer",
			EntityType.Builder.<BuiltBigOverseerEntity>of(BuiltBigOverseerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(1f, 3f));
	public static final DeferredHolder<EntityType<?>, EntityType<CentigazeEntity>> CENTIGAZE = register("centigaze",
			EntityType.Builder.<CentigazeEntity>of(CentigazeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(78).setUpdateInterval(3)

					.sized(2.4f, 0.9f));
	public static final DeferredHolder<EntityType<?>, EntityType<CentigazeHiddenEntity>> CENTIGAZE_HIDDEN = register("centigaze_hidden",
			EntityType.Builder.<CentigazeHiddenEntity>of(CentigazeHiddenEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(78).setUpdateInterval(3).fireImmune().sized(1.8f, 0.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<StalkingStalkerEntity>> STALKING_STALKER = register("stalking_stalker",
			EntityType.Builder.<StalkingStalkerEntity>of(StalkingStalkerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(125).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<ShadowEntity>> SHADOW = register("shadow",
			EntityType.Builder.<ShadowEntity>of(ShadowEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<WatchingStalkerEntity>> WATCHING_STALKER = register("watching_stalker",
			EntityType.Builder.<WatchingStalkerEntity>of(WatchingStalkerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(84).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<WeaverOfSoulsEntity>> WEAVER_OF_SOULS = register("weaver_of_souls",
			EntityType.Builder.<WeaverOfSoulsEntity>of(WeaverOfSoulsEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(78).setUpdateInterval(3).fireImmune().sized(2.8f, 2.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<HandSpawnEntity>> HAND_SPAWN = register("hand_spawn",
			EntityType.Builder.<HandSpawnEntity>of(HandSpawnEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3).fireImmune().sized(0.8f, 0.1f));
	public static final DeferredHolder<EntityType<?>, EntityType<ShadowHandEntity>> SHADOW_HAND = register("shadow_hand",
			EntityType.Builder.<ShadowHandEntity>of(ShadowHandEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.4f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<DamnedEntity>> DAMNED = register("damned",
			EntityType.Builder.<DamnedEntity>of(DamnedEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(65).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<CrossEyesEntity>> CROSS_EYES = register("cross_eyes",
			EntityType.Builder.<CrossEyesEntity>of(CrossEyesEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(65).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<BigEyeEntity>> BIG_EYE = register("big_eye",
			EntityType.Builder.<BigEyeEntity>of(BigEyeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(65).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<MultipleEyesEntity>> MULTIPLE_EYES = register("multiple_eyes",
			EntityType.Builder.<MultipleEyesEntity>of(MultipleEyesEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(65).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<FourEyesEntity>> FOUR_EYES = register("four_eyes",
			EntityType.Builder.<FourEyesEntity>of(FourEyesEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(65).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<SoulOrbEntity>> SOUL_ORB = register("soul_orb",
			EntityType.Builder.<SoulOrbEntity>of(SoulOrbEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<ChainedWeaverEntity>> CHAINED_WEAVER = register("chained_weaver",
			EntityType.Builder.<ChainedWeaverEntity>of(ChainedWeaverEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(2.8f, 2.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<DoomingTombstoneEntity>> DOOMING_TOMBSTONE = register("dooming_tombstone",
			EntityType.Builder.<DoomingTombstoneEntity>of(DoomingTombstoneEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<SummonedShadowHandEntity>> SUMMONED_SHADOW_HAND = register("summoned_shadow_hand",
			EntityType.Builder.<SummonedShadowHandEntity>of(SummonedShadowHandEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.4f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<ForsakenEntity>> FORSAKEN = register("forsaken",
			EntityType.Builder.<ForsakenEntity>of(ForsakenEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.6f, 2.4f));
	public static final DeferredHolder<EntityType<?>, EntityType<AcidSpitEntity>> ACID_SPIT = register("acid_spit",
			EntityType.Builder.<AcidSpitEntity>of(AcidSpitEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<SeekerEntity>> SEEKER = register("seeker",
			EntityType.Builder.<SeekerEntity>of(SeekerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<ApostleOfCatastropheEntity>> APOSTLE_OF_CATASTROPHE = register("apostle_of_catastrophe",
			EntityType.Builder.<ApostleOfCatastropheEntity>of(ApostleOfCatastropheEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(99).setUpdateInterval(3)

					.sized(0.9f, 3.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<PoisonKnifeEntity>> POISON_KNIFE = register("poison_knife",
			EntityType.Builder.<PoisonKnifeEntity>of(PoisonKnifeEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<RotKnifeEntity>> ROT_KNIFE = register("rot_knife",
			EntityType.Builder.<RotKnifeEntity>of(RotKnifeEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<IdlingApostleEntity>> IDLING_APOSTLE = register("idling_apostle",
			EntityType.Builder.<IdlingApostleEntity>of(IdlingApostleEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(99).setUpdateInterval(3).fireImmune().sized(0.9f, 3.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<BloodshotEntity>> BLOODSHOT = register("bloodshot",
			EntityType.Builder.<BloodshotEntity>of(BloodshotEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<GoldenBloodshotEntity>> GOLDEN_BLOODSHOT = register("golden_bloodshot",
			EntityType.Builder.<GoldenBloodshotEntity>of(GoldenBloodshotEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<MisanthropicHivemindEntity>> MISANTHROPIC_HIVEMIND = register("misanthropic_hivemind",
			EntityType.Builder.<MisanthropicHivemindEntity>of(MisanthropicHivemindEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(84).setUpdateInterval(3)

					.sized(1.8f, 3.4f));
	public static final DeferredHolder<EntityType<?>, EntityType<FleshFangsEntity>> FLESH_FANGS = register("flesh_fangs",
			EntityType.Builder.<FleshFangsEntity>of(FleshFangsEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<GoreExpectoratorEntity>> GORE_EXPECTORATOR = register("gore_expectorator",
			EntityType.Builder.<GoreExpectoratorEntity>of(GoreExpectoratorEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.4f, 5f));
	public static final DeferredHolder<EntityType<?>, EntityType<BloodSpitEntity>> BLOOD_SPIT = register("blood_spit",
			EntityType.Builder.<BloodSpitEntity>of(BloodSpitEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<HiveBrainEntity>> HIVE_BRAIN = register("hive_brain",
			EntityType.Builder.<HiveBrainEntity>of(HiveBrainEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3).fireImmune().sized(1f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<RideableEyekinEntity>> RIDEABLE_EYEKIN = register("rideable_eyekin",
			EntityType.Builder.<RideableEyekinEntity>of(RideableEyekinEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(74).setUpdateInterval(3)

					.sized(2.2f, 3.2f));
	public static final DeferredHolder<EntityType<?>, EntityType<RideableFlyingEyekinEntity>> RIDEABLE_FLYING_EYEKIN = register("rideable_flying_eyekin",
			EntityType.Builder.<RideableFlyingEyekinEntity>of(RideableFlyingEyekinEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(78).setUpdateInterval(3)

					.sized(3f, 1f));

	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(SpawnPlacementRegisterEvent event) {
		FallingCorpseEntity.init(event);
		GhostlyNightmareEntity.init(event);
		LightEntity.init(event);
		AmalgamEntity.init(event);
		SulfurTntEntityEntity.init(event);
		CathedralGhostEntity.init(event);
		GhostEntity.init(event);
		OverseerPillarEntity.init(event);
		BuiltOverseerPillarEntity.init(event);
		DeathMawHiddenEntity.init(event);
		ThrownSoulSeekerEntity.init(event);
		CharredSpikeEntity.init(event);
		SummonedCharredSpikeEntity.init(event);
		MournerEntity.init(event);
		BoneCrawlerEntity.init(event);
		FoolEaterEntity.init(event);
		TamedBoneCrawlerEntity.init(event);
		HallucinationEntity.init(event);
		LurkerEntity.init(event);
		StalkerEntity.init(event);
		AbductorEntity.init(event);
		VoidDwellerEntity.init(event);
		LickerEntity.init(event);
		FleshCubeEntity.init(event);
		SmallFleshCubeEntity.init(event);
		SporeSpewerEntity.init(event);
		WandererEntity.init(event);
		GravekeeperEntity.init(event);
		GooSpitterEntity.init(event);
		RoamerEntity.init(event);
		MotherBoneCrawlerEntity.init(event);
		TamedMotherBoneCrawlerEntity.init(event);
		AlphaBoneCrawlerEntity.init(event);
		TamedAlphaBoneCrawlerEntity.init(event);
		BabyBoneCrawlerEntity.init(event);
		BabyBoneCrawlerNeutralEntity.init(event);
		RottenCorpseEntity.init(event);
		RottenCultMemberEntity.init(event);
		EyekinEntity.init(event);
		EyekinFlyingEntity.init(event);
		SwarmerEntity.init(event);
		DeathMawEntity.init(event);
		BeholderEntity.init(event);
		EverhungerEntity.init(event);
		DeathVultureEntity.init(event);
		MuzzledDeathVultureEntity.init(event);
		DevourerEntity.init(event);
		RootedEntity.init(event);
		RootedCloneEntity.init(event);
		OverseerEntity.init(event);
		BuiltOverseerEntity.init(event);
		ScarecrowEntity.init(event);
		NightmareEntity.init(event);
		OverseerBigPillarEntity.init(event);
		BigOverseerEntity.init(event);
		BuiltBigOverseerPillarEntity.init(event);
		BuiltBigOverseerEntity.init(event);
		CentigazeEntity.init(event);
		CentigazeHiddenEntity.init(event);
		StalkingStalkerEntity.init(event);
		ShadowEntity.init(event);
		WatchingStalkerEntity.init(event);
		WeaverOfSoulsEntity.init(event);
		HandSpawnEntity.init(event);
		ShadowHandEntity.init(event);
		DamnedEntity.init(event);
		CrossEyesEntity.init(event);
		BigEyeEntity.init(event);
		MultipleEyesEntity.init(event);
		FourEyesEntity.init(event);
		SoulOrbEntity.init(event);
		ChainedWeaverEntity.init(event);
		DoomingTombstoneEntity.init(event);
		SummonedShadowHandEntity.init(event);
		ForsakenEntity.init(event);
		SeekerEntity.init(event);
		ApostleOfCatastropheEntity.init(event);
		IdlingApostleEntity.init(event);
		MisanthropicHivemindEntity.init(event);
		FleshFangsEntity.init(event);
		GoreExpectoratorEntity.init(event);
		HiveBrainEntity.init(event);
		RideableEyekinEntity.init(event);
		RideableFlyingEyekinEntity.init(event);
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
		event.put(CHARRED_SPIKE.get(), CharredSpikeEntity.createAttributes().build());
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
	}
}
