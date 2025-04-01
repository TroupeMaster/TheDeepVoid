
package net.mcreator.thedeepvoid.item;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.thedeepvoid.procedures.GrimScytheRightclickedProcedure;
import net.mcreator.thedeepvoid.procedures.GrimScytheLivingEntityIsHitWithToolProcedure;
import net.mcreator.thedeepvoid.procedures.GrimScytheHasItemGlowingEffectProcedure;
import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;

import java.util.List;

public class GrimScytheItem extends SwordItem {
	public GrimScytheItem() {
		super(new Tier() {
			public int getUses() {
				return 1561;
			}

			public float getSpeed() {
				return 8f;
			}

			public float getAttackDamageBonus() {
				return 6f;
			}

			public int getLevel() {
				return 3;
			}

			public int getEnchantmentValue() {
				return 10;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(TheDeepVoidModItems.GRIM_GEM.get()), new ItemStack(TheDeepVoidModItems.REFINED_ONYX.get()));
			}
		}, 3, -3f, new Item.Properties());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		GrimScytheLivingEntityIsHitWithToolProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, sourceentity);
		return retval;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		GrimScytheRightclickedProcedure.execute(world, entity, ar.getObject());
		return ar;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A79Each hit repeats itself, dealing 6 damage in a AOE and spawning additional XP orbs"));
		list.add(Component.literal("\u00A79Killing a foe fuels the scythe with their soul. At 5 souls, right click to throw the scythe. The thrown scythe steals the soul of foes and their lifeforce"));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return GrimScytheHasItemGlowingEffectProcedure.execute(itemstack);
	}
}
