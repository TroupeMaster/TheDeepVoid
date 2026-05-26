package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.ItemAttributeModifierEvent;
import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

import javax.annotation.Nullable;

import java.util.UUID;

@Mod.EventBusSubscriber
public class SetItemAttributesProcedure {
	@SubscribeEvent
	public static void addAttributeModifier(ItemAttributeModifierEvent event) {
		execute(event, event.getItemStack());
	}

	public static void execute(ItemStack itemstack) {
		execute(null, itemstack);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack) {
		if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.MAINHAND) {
			if (itemstack.getItem() == TheDeepVoidModItems.ONYX_NAGINATA.get() || itemstack.getItem() == TheDeepVoidModItems.DARK_STEEL_NAGINATA.get()) {
				_event.addModifier(ForgeMod.ENTITY_REACH.get(),
						(new AttributeModifier(UUID.fromString("c2d764d5-1e7e-4f13-8e8a-5a6d073a2b9d"), "naginataReach", ((double) DeepVoidConfigConfiguration.ONYXNAGINATAREACHADDITION.get()), AttributeModifier.Operation.ADDITION)));
			}
			if (itemstack.getItem() == TheDeepVoidModItems.PENITENT_CROSS.get()) {
				_event.addModifier(ForgeMod.ENTITY_REACH.get(),
						(new AttributeModifier(UUID.fromString("1d949c6f-0aa0-4cb1-b4d1-0da21d149162"), "crossReach", ((double) DeepVoidConfigConfiguration.PENITENTCROSSREACHADDITION.get()), AttributeModifier.Operation.ADDITION)));
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK, (new AttributeModifier(UUID.fromString("daa20447-a292-4a1f-be0b-5a1d395597bc"), "crossKnockback", 1.3, AttributeModifier.Operation.ADDITION)));
			}
			if (itemstack.getItem() == TheDeepVoidModItems.EXECUTIONER_SWORD.get()) {
				_event.addModifier(ForgeMod.ENTITY_REACH.get(), (new AttributeModifier(UUID.fromString("91c3cc39-df93-477d-878a-3f8a1c0a3747"), "executionerReach", 1, AttributeModifier.Operation.ADDITION)));
			}
			if (itemstack.getItem() == TheDeepVoidModItems.STINGER.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED, (new AttributeModifier(UUID.fromString("3ebf6c26-26e9-4652-8ed1-054178166bea"), "stingerSpeed", 1.4, AttributeModifier.Operation.ADDITION)));
			}
			if (itemstack.getItem() == TheDeepVoidModItems.KNIVES_GLOVE.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED, (new AttributeModifier(UUID.fromString("77b8b253-e87d-4b69-a7eb-83208a542bda"), "knifeGloveSpeed", 0.4, AttributeModifier.Operation.ADDITION)));
			}
			if (itemstack.is(ItemTags.create(new ResourceLocation("the_deep_void:dark_steel_tools")))) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK,
						(new AttributeModifier(UUID.fromString("582300b7-5e68-4807-a822-01bebd809fd3"), "darkSteelTool_knockback", 1, AttributeModifier.Operation.ADDITION)));
			}
			if (itemstack.is(ItemTags.create(new ResourceLocation("the_deep_void:scythes")))) {
				_event.addModifier(ForgeMod.ENTITY_REACH.get(),
						(new AttributeModifier(UUID.fromString("ebf794e9-482e-4e28-81b3-2f8d23258894"), "scytheReach", ((double) DeepVoidConfigConfiguration.SCYTHESREACH.get()), AttributeModifier.Operation.ADDITION)));
			}
			if (itemstack.getItem() == TheDeepVoidModItems.VOIDRIUM_BULWARK.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE, (new AttributeModifier(UUID.fromString("ea9dbfe9-9f46-4046-b57a-d47dbe387cca"), "bulwarkDamage", 5, AttributeModifier.Operation.ADDITION)));
			}
			if (itemstack.getItem() == TheDeepVoidModItems.ROT_TONGUE.get()) {
				_event.addModifier(ForgeMod.ENTITY_REACH.get(), (new AttributeModifier(UUID.fromString("113f833e-af9f-460e-b241-4d8f43a07a86"), "rottenTongue_reach", 0.6, AttributeModifier.Operation.ADDITION)));
			}
			if (itemstack.getItem() == TheDeepVoidModItems.BLOODY_CHAINSAW.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK,
						(new AttributeModifier(UUID.fromString("500adec7-d9f3-4d82-8e04-35c74fcd939b"), "chainsaw_knockback", (-0.9), AttributeModifier.Operation.MULTIPLY_TOTAL)));
			}
			if (itemstack.getItem() == TheDeepVoidModItems.JUDGEMENT.get()) {
				_event.addModifier(ForgeMod.ENTITY_REACH.get(), (new AttributeModifier(UUID.fromString("6d6c2b75-a398-4232-9e1c-1547c735cf8a"), "judgement_reach", 0.55, AttributeModifier.Operation.ADDITION)));
			}
			if (itemstack.getItem() == TheDeepVoidModItems.VOID_MATTER_GREATSWORD.get()) {
				_event.addModifier(ForgeMod.ENTITY_REACH.get(), (new AttributeModifier(UUID.fromString("48f3899b-36d3-4114-bf7e-e331e1095109"), "greatsword_reach", 0.55, AttributeModifier.Operation.ADDITION)));
			}
			if (itemstack.getItem() == TheDeepVoidModItems.CLAW_SCYTHE.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED, (new AttributeModifier(UUID.fromString("34336e81-e420-44ed-9b7c-5823ad725ae7"), "clawscytheSpeed", (-0.8), AttributeModifier.Operation.ADDITION)));
			}
			if (itemstack.getItem() == TheDeepVoidModItems.CEREMONIAL_DAGGER.get()) {
				_event.addModifier(ForgeMod.ENTITY_REACH.get(), (new AttributeModifier(UUID.fromString("c06f24ef-d58e-4c6c-8731-a6ca8764b269"), "ceremonial_reach", (-0.5), AttributeModifier.Operation.ADDITION)));
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE,
						(new AttributeModifier(UUID.fromString("e2bd140a-7c62-4aac-b997-e3dcb3e25846"), "ceremonial_damage", (itemstack.getOrCreateTag().getDouble("kills")), AttributeModifier.Operation.ADDITION)));
			}
		}
		if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.HEAD) {
			if (itemstack.getItem() == TheDeepVoidModItems.BLOODSTONE_ARMOR_HELMET.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH,
						(new AttributeModifier(UUID.fromString("aa5c1f7d-57c5-4cf4-bc5a-a33220af9855"), "bloodstoneHelmetHealth", (-1), AttributeModifier.Operation.ADDITION)));
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED,
						(new AttributeModifier(UUID.fromString("e3e28def-8ac7-4786-bf1b-9c40b2adbe13"), "bloodstoneHelmetSpeed", 0.1, AttributeModifier.Operation.MULTIPLY_BASE)));
			}
			if (itemstack.getItem() == TheDeepVoidModItems.VULTURE_HELMET.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED,
						(new AttributeModifier(UUID.fromString("20becca3-d644-43ef-8598-24659f89f3b3"), "vultureMaskSpeed", 0.05, AttributeModifier.Operation.MULTIPLY_BASE)));
			}
		}
		if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.CHEST) {
			if (itemstack.getItem() == TheDeepVoidModItems.BLOODSTONE_ARMOR_CHESTPLATE.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH,
						(new AttributeModifier(UUID.fromString("a9a9f5bc-1598-48bf-b126-576cd3e43583"), "bloodstoneChestplateHealth", (-1), AttributeModifier.Operation.ADDITION)));
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED,
						(new AttributeModifier(UUID.fromString("3d44d829-1981-4ce1-ad8d-0b61f55544e3"), "bloodstoneChestplateSpeed", 0.1, AttributeModifier.Operation.MULTIPLY_BASE)));
			}
			if (itemstack.getItem() == TheDeepVoidModItems.VULTURE_CHESTPLATE.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED,
						(new AttributeModifier(UUID.fromString("c3ec1923-603c-48b7-838d-b45534890f9b"), "vultureChestplateSpeed", 0.05, AttributeModifier.Operation.MULTIPLY_BASE)));
			}
		}
		if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.LEGS) {
			if (itemstack.getItem() == TheDeepVoidModItems.BLOODSTONE_ARMOR_LEGGINGS.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH,
						(new AttributeModifier(UUID.fromString("086d99dd-744f-4f1b-b221-0498a2e55ae2"), "bloodstoneLeggingsHealth", (-1), AttributeModifier.Operation.ADDITION)));
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED,
						(new AttributeModifier(UUID.fromString("01d34c3f-48cc-4963-ae79-18fd27890ea1"), "bloodstoneLeggingsSpeed", 0.1, AttributeModifier.Operation.MULTIPLY_BASE)));
			}
			if (itemstack.getItem() == TheDeepVoidModItems.VULTURE_LEGGINGS.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED,
						(new AttributeModifier(UUID.fromString("56a76483-c4d7-4dc0-9c35-0387fc9b134d"), "vultureLeggingsSpeed", 0.05, AttributeModifier.Operation.MULTIPLY_BASE)));
			}
		}
		if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.FEET) {
			if (itemstack.getItem() == TheDeepVoidModItems.BLOODSTONE_ARMOR_BOOTS.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH, (new AttributeModifier(UUID.fromString("d6e38656-aace-4147-bf0e-0a95c42bb0f1"), "bloodstoneBootsHealth", (-1), AttributeModifier.Operation.ADDITION)));
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED,
						(new AttributeModifier(UUID.fromString("5efe39a4-375f-4a75-a4f6-55d7f2aaf10f"), "bloodstoneBootsSpeed", 0.1, AttributeModifier.Operation.MULTIPLY_BASE)));
			}
			if (itemstack.getItem() == TheDeepVoidModItems.HUNTERS_BOOTS.get()) {
				_event.addModifier(ForgeMod.STEP_HEIGHT_ADDITION.get(), (new AttributeModifier(UUID.fromString("905f3797-a937-48a0-89e0-7492943a9219"), "hunterStepHeight", 0.4, AttributeModifier.Operation.ADDITION)));
			}
			if (itemstack.getItem() == TheDeepVoidModItems.VULTURE_BOOTS.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED,
						(new AttributeModifier(UUID.fromString("f43fe2fd-417c-4108-8c72-91aa179184f2"), "vultureBootsSpeed", 0.05, AttributeModifier.Operation.MULTIPLY_BASE)));
			}
		}
	}
}
