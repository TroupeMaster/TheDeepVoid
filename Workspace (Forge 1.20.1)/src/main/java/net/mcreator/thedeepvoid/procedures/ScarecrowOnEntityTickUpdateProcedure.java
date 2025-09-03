package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;
import net.mcreator.thedeepvoid.entity.SwarmerEntity;
import net.mcreator.thedeepvoid.entity.EyekinFlyingEntity;
import net.mcreator.thedeepvoid.entity.EyekinEntity;

import java.util.List;
import java.util.Comparator;

public class ScarecrowOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double distance = 0;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if (!world.getEntitiesOfClass(SwarmerEntity.class, AABB.ofSize(new Vec3(x, y, z), 80, 80, 80), e -> true).isEmpty() || !world.getEntitiesOfClass(EyekinEntity.class, AABB.ofSize(new Vec3(x, y, z), 80, 80, 80), e -> true).isEmpty()
					|| !world.getEntitiesOfClass(EyekinFlyingEntity.class, AABB.ofSize(new Vec3(x, y, z), 80, 80, 80), e -> true).isEmpty()) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(80 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof SwarmerEntity || entityiterator instanceof EyekinEntity || entityiterator instanceof EyekinFlyingEntity) {
							if ((entityiterator instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) {
								if (entityiterator instanceof Mob _entity && (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _ent)
									_entity.setTarget(_ent);
							}
						}
					}
				}
			}
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).isEmpty()) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayer _serverPlayer) {
								return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
							} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
								return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
										&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entityiterator)) && !(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayer _serverPlayer) {
								return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
							} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
								return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
										&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
							}
							return false;
						}
					}.checkGamemode(entityiterator))) {
						if (!((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.BLOODY_RIB_CAGE_CHESTPLATE.get())) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.FIXATION.get(), 5, 0, false, false));
							entity.getPersistentData().putDouble("deep_void:crowCall", (entity.getPersistentData().getDouble("deep_void:crowCall") + 1));
						}
					}
				}
			}
		}
		if (entity.getPersistentData().getDouble("deep_void:crowCall") >= 5) {
			entity.getPersistentData().putDouble("deep_void:crowCall", (Mth.nextInt(RandomSource.create(), 0, 2)));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -15, 15), y + Mth.nextInt(RandomSource.create(), -2, 2), z + Mth.nextInt(RandomSource.create(), -15, 15)),
							ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:crow_call")), SoundSource.AMBIENT, 2, (float) Mth.nextDouble(RandomSource.create(), 1, 1.1));
				} else {
					_level.playLocalSound((x + Mth.nextInt(RandomSource.create(), -15, 15)), (y + Mth.nextInt(RandomSource.create(), -2, 2)), (z + Mth.nextInt(RandomSource.create(), -15, 15)),
							ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:crow_call")), SoundSource.AMBIENT, 2, (float) Mth.nextDouble(RandomSource.create(), 1, 1.1), false);
				}
			}
		}
	}
}
