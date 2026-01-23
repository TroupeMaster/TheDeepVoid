package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class CrawlerTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double randomX = 0;
		double randomZ = 0;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0 && entity.getPersistentData().getBoolean("deep_void:digging") == false) {
			entity.getPersistentData().putDouble("deep_void:attackChance", (entity.getPersistentData().getDouble("deep_void:attackChance") + 1));
		}
		if (entity.getPersistentData().getDouble("deep_void:attackChance") == 60) {
			PrimordialCrawlerSlamProcedure.execute(world, entity);
		}
		if (entity.getPersistentData().getDouble("deep_void:attackChance") == 180) {
			PrimordialCrawlerSpitProcedure.execute(world, entity);
		}
		if (entity.getPersistentData().getDouble("deep_void:attackChance") == 260) {
			PrimordialCrawlerDigProcedure.execute(world, x, y, z, entity);
		}
		if (entity.getPersistentData().getDouble("deep_void:attackChance") == 330) {
			PrimordialCrawlerDashProcedure.execute(world, x, y, z, entity);
		}
		if (entity.getPersistentData().getDouble("deep_void:attackChance") == 370) {
			entity.getPersistentData().putDouble("deep_void:attackChance", 0);
		}
		if (entity.getPersistentData().getBoolean("deep_void:digging") == true) {
			PrimordialCrawlerWhileDiggingProcedure.execute(world, x, y, z, entity);
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() < entity.getY() && (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() == entity.getX()
					&& (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() == entity.getZ()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:mother_crawler_ambient")), SoundSource.HOSTILE, 2,
								(float) 0.4);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:mother_crawler_ambient")), SoundSource.HOSTILE, 2, (float) 0.4, false);
					}
				}
				world.levelEvent(2001, BlockPos.containing((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX(), (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY(),
						(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()), Block.getId(TheDeepVoidModBlocks.BLOCK_OF_GOO.get().defaultBlockState()));
				TheDeepVoidMod.queueServerWork(10, () -> {
					{
						Entity _ent = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null);
						_ent.teleportTo((entity.getX()), (entity.getY()), (entity.getZ()));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport((entity.getX()), (entity.getY()), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
					}
				});
			}
		}
		WeaverBossMusicProcedure.execute(world, x, y, z, entity);
		if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 80, 80, 80), e -> true).isEmpty())) {
			if (!entity.level().isClientSide())
				entity.discard();
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TheDeepVoidModEntities.SLEEPING_PRIMORDIAL_CRAWLER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"stopsound @a record the_deep_void:the_haunt");
			TheDeepVoidMod.queueServerWork(20, () -> {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"stopsound @a record the_deep_void:the_haunt");
			});
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).isEmpty()) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.WEAVER_CURSE.get(), 5, 0, false, false));
					}
				}
			}
		}
	}
}
