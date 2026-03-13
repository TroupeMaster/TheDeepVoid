package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;

import java.util.Comparator;

public class VoidSickleSwingProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesOfClass(LivingEntity.class,
				AABB.ofSize(
						new Vec3((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
						20, 20, 20),
				e -> true).isEmpty()) {
			if (((Entity) world.getEntitiesOfClass(LivingEntity.class,
					AABB.ofSize(
							new Vec3((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
							20, 20, 20),
					e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
							(entity.level().clip(
									new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())))
					.findFirst().orElse(null)).getY() >= entity.getY() - 3
					&& ((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(
							new Vec3((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
							20, 20, 20), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())))
							.findFirst().orElse(null)).getY() <= entity.getY() + 3) {
				if (!(((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(
						new Vec3((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
						20, 20, 20), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())))
						.findFirst().orElse(null)) == entity)) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")), SoundSource.PLAYERS, 1, (float) 0.6);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")), SoundSource.PLAYERS, 1, (float) 0.6, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.BLACK_FLAME.get()), (entity.getX()), (entity.getY()), (entity.getZ()), 12, 0.1, 0.1, 0.1, 0.1);
					{
						Entity _ent = entity;
						_ent.teleportTo((((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())), 20,
								20, 20), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getX()),
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getY()),
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getZ())))
								.findFirst().orElse(null))
								.level()
								.clip(new ClipContext(((Entity) world.getEntitiesOfClass(LivingEntity.class,
										AABB.ofSize(new Vec3(
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getY()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ())),
												20, 20, 20),
										e -> true).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
											}
										}.compareDistOf(
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getY()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ())))
										.findFirst().orElse(null)).getEyePosition(1f),
										((Entity) world.getEntitiesOfClass(LivingEntity.class,
												AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														20, 20, 20),
												e -> true).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
													}
												}.compareDistOf(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())))
												.findFirst().orElse(null))
												.getEyePosition(
														1f)
												.add(((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														20, 20, 20), e -> true).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)).getViewVector(1f).scale((-1.5))),
										ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
										((Entity) world
												.getEntitiesOfClass(
														LivingEntity.class,
														AABB.ofSize(new Vec3(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())),
																20, 20, 20),
														e -> true)
												.stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
													}
												}.compareDistOf(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())))
												.findFirst().orElse(null))))
								.getBlockPos().getX()),
								(((Entity) world.getEntitiesOfClass(LivingEntity.class,
										AABB.ofSize(new Vec3(
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getY()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ())),
												20, 20, 20),
										e -> true).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
											}
										}.compareDistOf(
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
														entity)).getBlockPos().getY()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ())))
										.findFirst().orElse(null)).getY()),
								(((Entity) world.getEntitiesOfClass(LivingEntity.class,
										AABB.ofSize(new Vec3(
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getY()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ())),
												20, 20, 20),
										e -> true).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
											}
										}.compareDistOf(
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getY()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ())))
										.findFirst().orElse(null))
										.level().clip(
												new ClipContext(
														((Entity) world
																.getEntitiesOfClass(LivingEntity.class,
																		AABB.ofSize(
																				new Vec3(
																						(entity.level()
																								.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																										ClipContext.Fluid.NONE, entity))
																								.getBlockPos().getX()),
																						(entity.level()
																								.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																										ClipContext.Fluid.NONE, entity))
																								.getBlockPos().getY()),
																						(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																								ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
																				20, 20, 20),
																		e -> true)
																.stream().sorted(new Object() {
																	Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																		return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
																	}
																}.compareDistOf(
																		(entity.level()
																				.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																						entity))
																				.getBlockPos().getX()),
																		(entity.level()
																				.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																						entity))
																				.getBlockPos().getY()),
																		(entity.level()
																				.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																						entity))
																				.getBlockPos().getZ())))
																.findFirst().orElse(null)).getEyePosition(1f),
														((Entity) world
																.getEntitiesOfClass(LivingEntity.class,
																		AABB.ofSize(
																				new Vec3(
																						(entity.level()
																								.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																										ClipContext.Fluid.NONE, entity))
																								.getBlockPos().getX()),
																						(entity.level()
																								.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																										ClipContext.Fluid.NONE, entity))
																								.getBlockPos().getY()),
																						(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																								ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
																				20, 20, 20),
																		e -> true)
																.stream().sorted(new Object() {
																	Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																		return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
																	}
																}.compareDistOf(
																		(entity.level()
																				.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(
																						1f).add(
																								entity.getViewVector(1f).scale(8)),
																						ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																				.getBlockPos().getX()),
																		(entity.level()
																				.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																						entity))
																				.getBlockPos().getY()),
																		(entity.level()
																				.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																						entity))
																				.getBlockPos().getZ())))
																.findFirst().orElse(null))
																.getEyePosition(1f)
																.add(((Entity) world
																		.getEntitiesOfClass(LivingEntity.class,
																				AABB.ofSize(new Vec3(
																						(entity.level()
																								.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																										ClipContext.Fluid.NONE, entity))
																								.getBlockPos().getX()),
																						(entity.level()
																								.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																										ClipContext.Fluid.NONE, entity))
																								.getBlockPos().getY()),
																						(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																								ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
																						20, 20, 20),
																				e -> true)
																		.stream().sorted(new Object() {
																			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
																			}
																		}.compareDistOf(
																				(entity.level()
																						.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																								ClipContext.Fluid.NONE, entity))
																						.getBlockPos().getX()),
																				(entity.level()
																						.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																								ClipContext.Fluid.NONE, entity))
																						.getBlockPos().getY()),
																				(entity.level()
																						.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																								ClipContext.Fluid.NONE, entity))
																						.getBlockPos().getZ())))
																		.findFirst().orElse(null)).getViewVector(1f).scale((-1.5))),
														ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
														((Entity) world
																.getEntitiesOfClass(LivingEntity.class,
																		AABB.ofSize(
																				new Vec3(
																						(entity.level()
																								.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																										ClipContext.Fluid.NONE, entity))
																								.getBlockPos().getX()),
																						(entity.level()
																								.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																										ClipContext.Fluid.NONE, entity))
																								.getBlockPos().getY()),
																						(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																								ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
																				20, 20, 20),
																		e -> true)
																.stream().sorted(new Object() {
																	Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																		return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
																	}
																}.compareDistOf(
																		(entity.level()
																				.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																						entity))
																				.getBlockPos().getX()),
																		(entity.level()
																				.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																						entity))
																				.getBlockPos().getY()),
																		(entity.level().clip(
																				new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																				.getBlockPos().getZ())))
																.findFirst().orElse(null))))
										.getBlockPos().getZ()));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection
									.teleport(
											(((Entity) world
													.getEntitiesOfClass(LivingEntity.class,
															AABB.ofSize(
																	new Vec3(
																			(entity.level()
																					.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																							entity))
																					.getBlockPos().getX()),
																			(entity.level()
																					.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																							entity))
																					.getBlockPos().getY()),
																			(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																					ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
																	20, 20, 20),
															e -> true)
													.stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
														}
													}.compareDistOf(
															(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()),
															(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getY()),
															(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ())))
													.findFirst().orElse(null))
													.level().clip(
															new ClipContext(
																	((Entity) world
																			.getEntitiesOfClass(LivingEntity.class,
																					AABB.ofSize(new Vec3(
																							(entity.level()
																									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																											ClipContext.Fluid.NONE, entity))
																									.getBlockPos().getX()),
																							(entity.level()
																									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																											ClipContext.Fluid.NONE, entity))
																									.getBlockPos().getY()),
																							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																									ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
																							20, 20, 20),
																					e -> true)
																			.stream().sorted(new Object() {
																				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
																				}
																			}.compareDistOf(
																					(entity.level()
																							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																									ClipContext.Fluid.NONE, entity))
																							.getBlockPos().getX()),
																					(entity.level()
																							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																									ClipContext.Fluid.NONE, entity))
																							.getBlockPos().getY()),
																					(entity.level()
																							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																									ClipContext.Fluid.NONE, entity))
																							.getBlockPos().getZ())))
																			.findFirst().orElse(null)).getEyePosition(1f),
																	((Entity) world
																			.getEntitiesOfClass(LivingEntity.class,
																					AABB.ofSize(new Vec3(
																							(entity.level()
																									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																											ClipContext.Fluid.NONE, entity))
																									.getBlockPos().getX()),
																							(entity.level()
																									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																											ClipContext.Fluid.NONE, entity))
																									.getBlockPos().getY()),
																							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																									ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
																							20, 20, 20),
																					e -> true)
																			.stream().sorted(new Object() {
																				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
																				}
																			}.compareDistOf(
																					(entity.level()
																							.clip(new ClipContext(
																									entity.getEyePosition(1f), entity.getEyePosition(1f)
																											.add(entity.getViewVector(1f).scale(8)),
																									ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																							.getBlockPos().getX()),
																					(entity.level()
																							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																									ClipContext.Fluid.NONE, entity))
																							.getBlockPos().getY()),
																					(entity.level()
																							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																									ClipContext.Fluid.NONE, entity))
																							.getBlockPos().getZ())))
																			.findFirst().orElse(null))
																			.getEyePosition(1f)
																			.add(((Entity) world
																					.getEntitiesOfClass(LivingEntity.class,
																							AABB.ofSize(new Vec3(
																									(entity.level()
																											.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																													ClipContext.Fluid.NONE, entity))
																											.getBlockPos().getX()),
																									(entity.level()
																											.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																													ClipContext.Fluid.NONE, entity))
																											.getBlockPos().getY()),
																									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)),
																											ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
																									20, 20, 20),
																							e -> true)
																					.stream().sorted(new Object() {
																						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
																						}
																					}.compareDistOf(
																							(entity.level()
																									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																											ClipContext.Fluid.NONE, entity))
																									.getBlockPos().getX()),
																							(entity.level()
																									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																											ClipContext.Fluid.NONE, entity))
																									.getBlockPos().getY()),
																							(entity.level()
																									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																											ClipContext.Fluid.NONE, entity))
																									.getBlockPos().getZ())))
																					.findFirst().orElse(null)).getViewVector(1f).scale((-1.5))),
																	ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																	((Entity) world
																			.getEntitiesOfClass(LivingEntity.class,
																					AABB.ofSize(new Vec3(
																							(entity.level()
																									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																											ClipContext.Fluid.NONE, entity))
																									.getBlockPos().getX()),
																							(entity.level()
																									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																											ClipContext.Fluid.NONE, entity))
																									.getBlockPos().getY()),
																							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																									ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
																							20, 20, 20),
																					e -> true)
																			.stream().sorted(new Object() {
																				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
																				}
																			}.compareDistOf(
																					(entity.level()
																							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																									ClipContext.Fluid.NONE, entity))
																							.getBlockPos().getX()),
																					(entity.level()
																							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																									ClipContext.Fluid.NONE, entity))
																							.getBlockPos().getY()),
																					(entity.level()
																							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																									ClipContext.Fluid.NONE, entity))
																							.getBlockPos().getZ())))
																			.findFirst().orElse(null))))
													.getBlockPos().getX()),
											(((Entity) world
													.getEntitiesOfClass(LivingEntity.class,
															AABB.ofSize(
																	new Vec3(
																			(entity.level()
																					.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																							entity))
																					.getBlockPos().getX()),
																			(entity.level()
																					.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																							entity))
																					.getBlockPos().getY()),
																			(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																					ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
																	20, 20, 20),
															e -> true)
													.stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
														}
													}.compareDistOf(
															(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()),
															(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getY()),
															(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ())))
													.findFirst().orElse(null)).getY()),
											(((Entity) world
													.getEntitiesOfClass(LivingEntity.class,
															AABB.ofSize(new Vec3(
																	(entity.level()
																			.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																					entity))
																			.getBlockPos().getX()),
																	(entity.level()
																			.clip(new ClipContext(
																					entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getY()),
																	(entity.level().clip(
																			new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getZ())),
																	20, 20, 20),
															e -> true)
													.stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
														}
													}.compareDistOf(
															(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()),
															(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getY()),
															(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ())))
													.findFirst().orElse(null))
													.level().clip(
															new ClipContext(
																	((Entity) world
																			.getEntitiesOfClass(LivingEntity.class,
																					AABB.ofSize(new Vec3(
																							(entity.level()
																									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																											ClipContext.Fluid.NONE, entity))
																									.getBlockPos().getX()),
																							(entity.level()
																									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																											ClipContext.Fluid.NONE, entity))
																									.getBlockPos().getY()),
																							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																									ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
																							20, 20, 20),
																					e -> true)
																			.stream().sorted(new Object() {
																				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
																				}
																			}.compareDistOf(
																					(entity.level()
																							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																									ClipContext.Fluid.NONE, entity))
																							.getBlockPos().getX()),
																					(entity.level()
																							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																									ClipContext.Fluid.NONE, entity))
																							.getBlockPos().getY()),
																					(entity.level()
																							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																									ClipContext.Fluid.NONE, entity))
																							.getBlockPos().getZ())))
																			.findFirst().orElse(null)).getEyePosition(1f),
																	((Entity) world
																			.getEntitiesOfClass(LivingEntity.class,
																					AABB.ofSize(new Vec3(
																							(entity.level()
																									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																											ClipContext.Fluid.NONE, entity))
																									.getBlockPos().getX()),
																							(entity.level()
																									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																											ClipContext.Fluid.NONE, entity))
																									.getBlockPos().getY()),
																							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																									ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
																							20, 20, 20),
																					e -> true)
																			.stream().sorted(new Object() {
																				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
																				}
																			}.compareDistOf(
																					(entity.level()
																							.clip(new ClipContext(
																									entity.getEyePosition(1f), entity.getEyePosition(1f)
																											.add(entity.getViewVector(1f).scale(8)),
																									ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																							.getBlockPos().getX()),
																					(entity.level()
																							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																									ClipContext.Fluid.NONE, entity))
																							.getBlockPos().getY()),
																					(entity.level()
																							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																									ClipContext.Fluid.NONE, entity))
																							.getBlockPos().getZ())))
																			.findFirst().orElse(null))
																			.getEyePosition(1f)
																			.add(((Entity) world
																					.getEntitiesOfClass(LivingEntity.class,
																							AABB.ofSize(new Vec3(
																									(entity.level()
																											.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																													ClipContext.Fluid.NONE, entity))
																											.getBlockPos().getX()),
																									(entity.level()
																											.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																													ClipContext.Fluid.NONE, entity))
																											.getBlockPos().getY()),
																									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)),
																											ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
																									20, 20, 20),
																							e -> true)
																					.stream().sorted(new Object() {
																						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
																						}
																					}.compareDistOf(
																							(entity.level()
																									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																											ClipContext.Fluid.NONE, entity))
																									.getBlockPos().getX()),
																							(entity.level()
																									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																											ClipContext.Fluid.NONE, entity))
																									.getBlockPos().getY()),
																							(entity.level()
																									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																											ClipContext.Fluid.NONE, entity))
																									.getBlockPos().getZ())))
																					.findFirst().orElse(null)).getViewVector(1f).scale((-1.5))),
																	ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																	((Entity) world
																			.getEntitiesOfClass(LivingEntity.class,
																					AABB.ofSize(new Vec3(
																							(entity.level()
																									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																											ClipContext.Fluid.NONE, entity))
																									.getBlockPos().getX()),
																							(entity.level()
																									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																											ClipContext.Fluid.NONE, entity))
																									.getBlockPos().getY()),
																							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																									ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
																							20, 20, 20),
																					e -> true)
																			.stream().sorted(new Object() {
																				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
																				}
																			}.compareDistOf(
																					(entity.level()
																							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																									ClipContext.Fluid.NONE, entity))
																							.getBlockPos().getX()),
																					(entity.level()
																							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																									ClipContext.Fluid.NONE, entity))
																							.getBlockPos().getY()),
																					(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER,
																							ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())))
																			.findFirst().orElse(null))))
													.getBlockPos().getZ()),
											_ent.getYRot(), _ent.getXRot());
					}
					entity.lookAt(EntityAnchorArgument.Anchor.EYES,
							new Vec3(
									(((Entity) world
											.getEntitiesOfClass(LivingEntity.class,
													AABB.ofSize(
															new Vec3(
																	(entity.level()
																			.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																					entity))
																			.getBlockPos().getX()),
																	(entity.level()
																			.clip(new ClipContext(
																					entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getY()),
																	(entity.level().clip(
																			new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getZ())),
															20, 20, 20),
													e -> true)
											.stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
												}
											}.compareDistOf(
													(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getX()),
													(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getY()),
													(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getZ())))
											.findFirst().orElse(null)).getX()),
									(((Entity) world
											.getEntitiesOfClass(LivingEntity.class,
													AABB.ofSize(
															new Vec3(
																	(entity.level()
																			.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																					entity))
																			.getBlockPos().getX()),
																	(entity.level()
																			.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																					entity))
																			.getBlockPos().getY()),
																	(entity.level().clip(
																			new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getZ())),
															20, 20, 20),
													e -> true)
											.stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
												}
											}.compareDistOf(
													(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getX()),
													(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getY()),
													(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getZ())))
											.findFirst().orElse(null)).getY() + 1.6),
									(((Entity) world
											.getEntitiesOfClass(LivingEntity.class,
													AABB.ofSize(
															new Vec3(
																	(entity.level()
																			.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																					entity))
																			.getBlockPos().getX()),
																	(entity.level()
																			.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																					entity))
																			.getBlockPos().getY()),
																	(entity.level().clip(
																			new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getZ())),
															20, 20, 20),
													e -> true)
											.stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
												}
											}.compareDistOf(
													(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getX()),
													(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getY()),
													(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getZ())))
											.findFirst().orElse(null)).getZ())));
				}
			}
		}
	}
}
