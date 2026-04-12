
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedeepvoid.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TheDeepVoidModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> SPAWN_HOLE_STRUCTURE = GameRules.register("spawnHoleStructure", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> GIVE_WIKI_BOOK = GameRules.register("giveWikiBook", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> WANDERER_PATHFIND = GameRules.register("wandererPathfind", GameRules.Category.MOBS, GameRules.BooleanValue.create(true));
}
