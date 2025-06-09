package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;

public class AnxietyRisingProcedureProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("the_deep_void:deep_void")) && !(entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(TheDeepVoidModMobEffects.VOID_BLESSING.get()))
				&& !(entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(TheDeepVoidModMobEffects.HALLUCINATE.get())) && !(new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayer _serverPlayer) {
							return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
						} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
							return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
									&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
						}
						return false;
					}
				}.checkGamemode(entity)) && !world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("the_deep_void:stalker_safe"))) && world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) <= 1
				&& world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) > 0) {
			return true;
		}
		return false;
	}
}
