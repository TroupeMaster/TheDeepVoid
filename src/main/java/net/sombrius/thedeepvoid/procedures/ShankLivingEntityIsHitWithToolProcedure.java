package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.init.TheDeepVoidModItems;
import net.sombrius.thedeepvoid.entity.PrisonGuardEntity;
import net.sombrius.thedeepvoid.entity.ManiacEntity;
import net.sombrius.thedeepvoid.entity.GaolerEntity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicReference;
import java.util.List;
import java.util.Comparator;

public class ShankLivingEntityIsHitWithToolProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		double maxCoin = 0;
		if (entity instanceof Player && sourceentity instanceof Player && (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TheDeepVoidModItems.DARK_STEEL_COIN.get())) : false)) {
			{
				AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
				entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
				if (_iitemhandlerref.get() != null) {
					for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
						ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
						if (itemstackiterator.getItem() == TheDeepVoidModItems.DARK_STEEL_COIN.get()) {
							maxCoin = maxCoin + itemstackiterator.getCount();
						}
					}
				}
			}
			itemstack.getOrCreateTag().putDouble("coin", (Mth.nextInt(RandomSource.create(), 0, (int) (maxCoin >= 16 ? 16 : maxCoin))));
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(TheDeepVoidModItems.DARK_STEEL_COIN.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) itemstack.getOrCreateTag().getDouble("coin"), _player.inventoryMenu.getCraftSlots());
			}
			if (itemstack.getOrCreateTag().getDouble("coin") > 0) {
				for (int index0 = 0; index0 < (int) itemstack.getOrCreateTag().getDouble("coin"); index0++) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(TheDeepVoidModItems.DARK_STEEL_COIN.get()));
						entityToSpawn.setPickUpDelay(10);
						entityToSpawn.setUnlimitedLifetime();
						_level.addFreshEntity(entityToSpawn);
					}
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.DARK_STEEL_COIN.get()) {
								entityiterator.setDeltaMovement(new Vec3((Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), 0.1, (Mth.nextDouble(RandomSource.create(), -0.1, 0.1))));
							}
						}
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:shank_steal_coins")), SoundSource.PLAYERS, (float) 0.7,
								(float) Mth.nextDouble(RandomSource.create(), 1, 1.06));
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:shank_steal_coins")), SoundSource.PLAYERS, (float) 0.7, (float) Mth.nextDouble(RandomSource.create(), 1, 1.06), false);
					}
				}
			}
		} else if ((entity instanceof PrisonGuardEntity || entity instanceof GaolerEntity || entity instanceof ManiacEntity) && sourceentity instanceof Player) {
			itemstack.getOrCreateTag().putDouble("coin", (Mth.nextInt(RandomSource.create(), 0, 2)));
			if (itemstack.getOrCreateTag().getDouble("coin") > 0) {
				for (int index1 = 0; index1 < (int) itemstack.getOrCreateTag().getDouble("coin"); index1++) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(TheDeepVoidModItems.DARK_STEEL_COIN.get()));
						entityToSpawn.setPickUpDelay(10);
						entityToSpawn.setUnlimitedLifetime();
						_level.addFreshEntity(entityToSpawn);
					}
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.DARK_STEEL_COIN.get()) {
								entityiterator.setDeltaMovement(new Vec3((Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), 0.1, (Mth.nextDouble(RandomSource.create(), -0.1, 0.1))));
							}
						}
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:shank_steal_coins")), SoundSource.PLAYERS, (float) 0.7,
								(float) Mth.nextDouble(RandomSource.create(), 1, 1.06));
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:shank_steal_coins")), SoundSource.PLAYERS, (float) 0.7, (float) Mth.nextDouble(RandomSource.create(), 1, 1.06), false);
					}
				}
			}
		}
	}
}
