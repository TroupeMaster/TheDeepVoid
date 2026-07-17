package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;
import net.mcreator.thedeepvoid.entity.FalseHydraEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class FalseHydraDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof FalseHydraEntity _datEntL0 && _datEntL0.getEntityData().get(FalseHydraEntity.DATA_dying)) == false) {
			if (entity instanceof FalseHydraEntity _datEntSetL)
				_datEntSetL.getEntityData().set(FalseHydraEntity.DATA_dying, true);
			if (entity instanceof FalseHydraEntity) {
				((FalseHydraEntity) entity).setAnimation("empty");
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:false_hydra_scream")), SoundSource.HOSTILE, 3, (float) 0.8);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:false_hydra_scream")), SoundSource.HOSTILE, 3, (float) 0.8, false);
				}
			}
			TheDeepVoidMod.queueServerWork(60, () -> {
				TheDeepVoidModVariables.MapVariables.get(world).hydraFightCount = TheDeepVoidModVariables.MapVariables.get(world).hydraFightCount + 1;
				TheDeepVoidModVariables.MapVariables.get(world).syncData(world);
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Player) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(TheDeepVoidModItems.FALSE_HYDRA_TREASURE_BAG.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							if (!(entityiterator instanceof ServerPlayer _plr6 && _plr6.level() instanceof ServerLevel
									&& _plr6.getAdvancements().getOrStartProgress(_plr6.server.getAdvancements().getAdvancement(new ResourceLocation("the_deep_void:copycat"))).isDone())) {
								if (entityiterator instanceof ServerPlayer _player) {
									Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("the_deep_void:copycat"));
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entityiterator instanceof LivingEntity _entity)
								_entity.removeEffect(TheDeepVoidModMobEffects.ADAPTIVE.get());
							if (entityiterator instanceof LivingEntity _entity)
								_entity.removeEffect(TheDeepVoidModMobEffects.DOMINATE.get());
							if (entityiterator instanceof LivingEntity _entity)
								_entity.removeEffect(TheDeepVoidModMobEffects.GLUTTONY.get());
							if (entityiterator instanceof LivingEntity _entity)
								_entity.removeEffect(TheDeepVoidModMobEffects.TERROR.get());
						}
					}
				}
			});
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"stopsound @a record the_deep_void:slaughter");
			TheDeepVoidMod.queueServerWork(20, () -> {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"stopsound @a record the_deep_void:slaughter");
			});
		}
	}
}
