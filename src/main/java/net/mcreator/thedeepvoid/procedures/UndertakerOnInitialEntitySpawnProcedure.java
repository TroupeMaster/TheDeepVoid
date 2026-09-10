package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;
import net.mcreator.thedeepvoid.entity.UndertakerEntity;

public class UndertakerOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		String temp = "";
		double rndConvert = 0;
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:grim_canopy")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:watching_undergrowth"))) {
			if (entity instanceof UndertakerEntity animatable)
				animatable.setTexture("undertaker_shot");
		} //Roll the first trade
		for (int index0 = 0; index0 < 16; index0++) {
			temp = ForgeRegistries.ITEMS.getKey((ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation("the_deep_void:undertaker_void_misc"))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).toString();
			if (!(ForgeRegistries.ITEMS.getValue(new ResourceLocation((temp).toLowerCase(java.util.Locale.ENGLISH))) == ItemStack.EMPTY.getItem())) {
				entity.getPersistentData().putString("firstTrade", temp);
				if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((temp).toLowerCase(java.util.Locale.ENGLISH)))).isStackable()) {
					entity.getPersistentData().putDouble("firstTradeQut", (Mth.nextInt(RandomSource.create(), 2, 16)));
				} else {
					entity.getPersistentData().putDouble("firstTradeQut", 1);
				}
				break;
			}
		}
		entity.getPersistentData().putDouble("firstTradePrice", (TheDeepVoidModVariables.MapVariables.get(world).undertakerKilled == true ? Mth.nextInt(RandomSource.create(), 6, 10) : Mth.nextInt(RandomSource.create(), 2, 6)));//Roll the second and third trade
		for (int index1 = 0; index1 < 16; index1++) {
			temp = ForgeRegistries.ITEMS.getKey((ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation("the_deep_void:undertaker_void_goods"))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).toString();
			if (!(ForgeRegistries.ITEMS.getValue(new ResourceLocation((temp).toLowerCase(java.util.Locale.ENGLISH))) == ItemStack.EMPTY.getItem())) {
				entity.getPersistentData().putString("secondTrade", temp);
				if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((temp).toLowerCase(java.util.Locale.ENGLISH)))).isStackable()) {
					entity.getPersistentData().putDouble("secondTradeQut", (Mth.nextInt(RandomSource.create(), 1, 12)));
				} else {
					entity.getPersistentData().putDouble("secondTradeQut", 1);
				}
				break;
			}
		}
		for (int index2 = 0; index2 < 16; index2++) {
			temp = ForgeRegistries.ITEMS.getKey((ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation("the_deep_void:undertaker_void_goods"))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).toString();
			if (!(ForgeRegistries.ITEMS.getValue(new ResourceLocation((temp).toLowerCase(java.util.Locale.ENGLISH))) == ItemStack.EMPTY.getItem())
					&& !(ForgeRegistries.ITEMS.getValue(new ResourceLocation((temp).toLowerCase(java.util.Locale.ENGLISH))) == ForgeRegistries.ITEMS
							.getValue(new ResourceLocation(((entity.getPersistentData().getString("secondTrade"))).toLowerCase(java.util.Locale.ENGLISH))))) {
				entity.getPersistentData().putString("thirdTrade", temp);
				if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((temp).toLowerCase(java.util.Locale.ENGLISH)))).isStackable()) {
					entity.getPersistentData().putDouble("thirdTradeQut", (Mth.nextInt(RandomSource.create(), 1, 6)));
				} else {
					entity.getPersistentData().putDouble("thirdTradeQut", 1);
				}
				break;
			}
		}
		entity.getPersistentData().putDouble("secondTradePrice", (TheDeepVoidModVariables.MapVariables.get(world).undertakerKilled == true ? Mth.nextInt(RandomSource.create(), 7, 12) : Mth.nextInt(RandomSource.create(), 3, 8)));
		entity.getPersistentData().putDouble("thirdTradePrice", (TheDeepVoidModVariables.MapVariables.get(world).undertakerKilled == true ? Mth.nextInt(RandomSource.create(), 9, 17) : Mth.nextInt(RandomSource.create(), 5, 12)));//Roll the fourth trade
		for (int index3 = 0; index3 < 16; index3++) {
			temp = ForgeRegistries.ITEMS.getKey((ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation("the_deep_void:undertaker_valuables"))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).toString();
			if (!(ForgeRegistries.ITEMS.getValue(new ResourceLocation((temp).toLowerCase(java.util.Locale.ENGLISH))) == ItemStack.EMPTY.getItem())) {
				entity.getPersistentData().putString("fourthTrade", temp);
				if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((temp).toLowerCase(java.util.Locale.ENGLISH)))).isStackable()) {
					entity.getPersistentData().putDouble("fourthTradeQut", (Mth.nextInt(RandomSource.create(), 1, 4)));
				} else {
					entity.getPersistentData().putDouble("fourthTradeQut", 1);
				}
				break;
			}
		}
		entity.getPersistentData().putDouble("fourthTradePrice", (TheDeepVoidModVariables.MapVariables.get(world).undertakerKilled == true ? Mth.nextInt(RandomSource.create(), 52, 64) : Mth.nextInt(RandomSource.create(), 24, 32)));//Roll the potion trade
		for (int index4 = 0; index4 < 16; index4++) {
			temp = ForgeRegistries.ITEMS.getKey((ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation("the_deep_void:undertaker_potions"))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).toString();
			if (!(ForgeRegistries.ITEMS.getValue(new ResourceLocation((temp).toLowerCase(java.util.Locale.ENGLISH))) == ItemStack.EMPTY.getItem())) {
				entity.getPersistentData().putString("potionTrade", temp);
				if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((temp).toLowerCase(java.util.Locale.ENGLISH)))).isStackable()) {
					entity.getPersistentData().putDouble("potionTradeQut", (Mth.nextInt(RandomSource.create(), 1, 4)));
				} else {
					entity.getPersistentData().putDouble("potionTradeQut", 1);
				}
				break;
			}
		}
		entity.getPersistentData().putDouble("potionTradePrice", (TheDeepVoidModVariables.MapVariables.get(world).undertakerKilled == true ? Mth.nextInt(RandomSource.create(), 14, 28) : Mth.nextInt(RandomSource.create(), 7, 14)));//Set the conversion trade
		rndConvert = TheDeepVoidModVariables.MapVariables.get(world).undertakerKilled == true ? 1 : Mth.nextInt(RandomSource.create(), 2, 12);
		entity.getPersistentData().putString("conversion", (ForgeRegistries.ITEMS.getKey(TheDeepVoidModItems.DARK_STEEL_COIN.get()).toString()));
		entity.getPersistentData().putDouble("conversionQut", rndConvert);
		entity.getPersistentData().putDouble("conversionPrice", rndConvert);
	}
}
