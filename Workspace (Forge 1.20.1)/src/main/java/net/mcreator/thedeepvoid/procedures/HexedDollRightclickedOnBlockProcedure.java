package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;
import net.mcreator.thedeepvoid.entity.WeaverOfSoulsEntity;
import net.mcreator.thedeepvoid.entity.ChainedWeaverEntity;

import java.util.List;
import java.util.Comparator;

public class HexedDollRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.SOUL_CONTAINER.get()) {
			if (!(!world.getEntitiesOfClass(WeaverOfSoulsEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty())
					&& !(!world.getEntitiesOfClass(ChainedWeaverEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty())) {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 600);
				itemstack.shrink(1);
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheDeepVoidModEntities.CHAINED_WEAVER.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SCULK_SOUL, x, y, z, 20, 1, 0.4, 1, 0.1);
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).isEmpty()) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof Player) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.weaver_of_souls.respawn").getString())), false);
							}
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, 1, (float) 0.8);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, 1, (float) 0.8, false);
						}
					}
				}
			} else {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 10);
			}
		}
	}
}
