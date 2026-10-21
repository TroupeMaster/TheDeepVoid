package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.init.TheDeepVoidModItems;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.ItemAttributeModifierEvent;
import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlot;

import javax.annotation.Nullable;

import java.util.UUID;

@Mod.EventBusSubscriber
public class SetArmorAttributesProcedure {
	@SubscribeEvent
	public static void addAttributeModifier(ItemAttributeModifierEvent event) {
		execute(event, event.getItemStack());
	}

	public static void execute(ItemStack itemstack) {
		execute(null, itemstack);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack) {
		if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.HEAD) {
			if (itemstack.getItem() == TheDeepVoidModItems.BLOODSTONE_ARMOR_HELMET.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH,
						(new AttributeModifier(UUID.fromString("aa5c1f7d-57c5-4cf4-bc5a-a33220af9855"), "bloodstone_helmet_health", (-1), AttributeModifier.Operation.ADDITION)));
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED,
						(new AttributeModifier(UUID.fromString("e3e28def-8ac7-4786-bf1b-9c40b2adbe13"), "bloodstone_helmet_speed", 0.1, AttributeModifier.Operation.MULTIPLY_BASE)));
			} else if (itemstack.getItem() == TheDeepVoidModItems.VULTURE_HELMET.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED,
						(new AttributeModifier(UUID.fromString("20becca3-d644-43ef-8598-24659f89f3b3"), "vulture_mask_speed", 0.05, AttributeModifier.Operation.MULTIPLY_BASE)));
			} else if (itemstack.getItem() == TheDeepVoidModItems.DARK_STEEL_BISMUTH_NETHERITE_HELMET.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED,
						(new AttributeModifier(UUID.fromString("02a154be-a982-4399-bdbf-47feb640e42f"), "bismuth_helmet_speed", (-0.05), AttributeModifier.Operation.MULTIPLY_BASE)));
			} else if (itemstack.getItem() == TheDeepVoidModItems.GILDED_HELMET.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH, (new AttributeModifier(UUID.fromString("78b47ea4-b067-4e03-9b9a-66fb374edaa7"), "gilded_helmet_health", 3, AttributeModifier.Operation.ADDITION)));
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED,
						(new AttributeModifier(UUID.fromString("e3e28def-5bc7-4786-bf1b-9c10b2afbe13"), "gilded_helmet_speed", 0.05, AttributeModifier.Operation.MULTIPLY_BASE)));
			}
		}
		if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.CHEST) {
			if (itemstack.getItem() == TheDeepVoidModItems.BLOODSTONE_ARMOR_CHESTPLATE.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH,
						(new AttributeModifier(UUID.fromString("a9a9f5bc-1598-48bf-b126-576cd3e43583"), "bloodstone_chestplate_health", (-1), AttributeModifier.Operation.ADDITION)));
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED,
						(new AttributeModifier(UUID.fromString("3d44d829-1981-4ce1-ad8d-0b61f55544e3"), "bloodstone_chestplate_speed", 0.1, AttributeModifier.Operation.MULTIPLY_BASE)));
			} else if (itemstack.getItem() == TheDeepVoidModItems.VULTURE_CHESTPLATE.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED,
						(new AttributeModifier(UUID.fromString("c3ec1923-603c-48b7-838d-b45534890f9b"), "vulture_chestplate_speed", 0.05, AttributeModifier.Operation.MULTIPLY_BASE)));
			} else if (itemstack.getItem() == TheDeepVoidModItems.DARK_STEEL_BISMUTH_NETHERITE_CHESTPLATE.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED,
						(new AttributeModifier(UUID.fromString("337de984-8c20-47fe-aaa5-8d7ff1f8db59"), "bismuth_chestplate_speed", (-0.05), AttributeModifier.Operation.MULTIPLY_BASE)));
			} else if (itemstack.getItem() == TheDeepVoidModItems.GILDED_CHESTPLATE.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH, (new AttributeModifier(UUID.fromString("247c69d1-0a0d-412c-b4f8-73176496ce4a"), "gilded_chestplate_health", 8, AttributeModifier.Operation.ADDITION)));
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED,
						(new AttributeModifier(UUID.fromString("e3e27def-5cc7-4786-bf1b-9c10b5acbe13"), "gilded_chestplate_speed", 0.05, AttributeModifier.Operation.MULTIPLY_BASE)));
			}
		}
		if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.LEGS) {
			if (itemstack.getItem() == TheDeepVoidModItems.BLOODSTONE_ARMOR_LEGGINGS.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH,
						(new AttributeModifier(UUID.fromString("086d99dd-744f-4f1b-b221-0498a2e55ae2"), "bloodstone_leggings_health", (-1), AttributeModifier.Operation.ADDITION)));
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED,
						(new AttributeModifier(UUID.fromString("01d34c3f-48cc-4963-ae79-18fd27890ea1"), "bloodstone_leggings_speed", 0.1, AttributeModifier.Operation.MULTIPLY_BASE)));
			} else if (itemstack.getItem() == TheDeepVoidModItems.VULTURE_LEGGINGS.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED,
						(new AttributeModifier(UUID.fromString("56a76483-c4d7-4dc0-9c35-0387fc9b134d"), "vulture_leggings_speed", 0.05, AttributeModifier.Operation.MULTIPLY_BASE)));
			} else if (itemstack.getItem() == TheDeepVoidModItems.DARK_STEEL_BISMUTH_NETHERITE_LEGGINGS.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED,
						(new AttributeModifier(UUID.fromString("0294bfa7-a54b-40e6-b2ad-16284859dbaf"), "bismuth_leggings_speed", (-0.05), AttributeModifier.Operation.MULTIPLY_BASE)));
			} else if (itemstack.getItem() == TheDeepVoidModItems.GILDED_LEGGINGS.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH, (new AttributeModifier(UUID.fromString("904045a0-b5e2-4166-8573-49cb2c5ea8c3"), "gilded_leggings_health", 6, AttributeModifier.Operation.ADDITION)));
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED,
						(new AttributeModifier(UUID.fromString("e3e27def-5bf9-4786-bf1b-9c12b5acbe15"), "gilded_leggings_speed", 0.05, AttributeModifier.Operation.MULTIPLY_BASE)));
			}
		}
		if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.FEET) {
			if (itemstack.getItem() == TheDeepVoidModItems.BLOODSTONE_ARMOR_BOOTS.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH,
						(new AttributeModifier(UUID.fromString("d6e38656-aace-4147-bf0e-0a95c42bb0f1"), "bloodstone_boots_health", (-1), AttributeModifier.Operation.ADDITION)));
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED,
						(new AttributeModifier(UUID.fromString("5efe39a4-375f-4a75-a4f6-55d7f2aaf10f"), "bloodstone_boots_speed", 0.1, AttributeModifier.Operation.MULTIPLY_BASE)));
			} else if (itemstack.getItem() == TheDeepVoidModItems.HUNTERS_BOOTS.get()) {
				_event.addModifier(ForgeMod.STEP_HEIGHT_ADDITION.get(), (new AttributeModifier(UUID.fromString("905f3797-a937-48a0-89e0-7492943a9219"), "hunter_step_height", 0.4, AttributeModifier.Operation.ADDITION)));
			} else if (itemstack.getItem() == TheDeepVoidModItems.VULTURE_BOOTS.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED,
						(new AttributeModifier(UUID.fromString("f43fe2fd-417c-4108-8c72-91aa179184f2"), "vulture_boots_speed", 0.05, AttributeModifier.Operation.MULTIPLY_BASE)));
			} else if (itemstack.getItem() == TheDeepVoidModItems.DARK_STEEL_BISMUTH_NETHERITE_BOOTS.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED,
						(new AttributeModifier(UUID.fromString("7cf3def5-b317-48c4-9958-9cd0e57bb6a7"), "bismuth_boots_speed", (-0.05), AttributeModifier.Operation.MULTIPLY_BASE)));
			} else if (itemstack.getItem() == TheDeepVoidModItems.GILDED_BOOTS.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH, (new AttributeModifier(UUID.fromString("c3d42de2-7c59-46fc-923f-bd8fa9399c44"), "gilded_boots_health", 3, AttributeModifier.Operation.ADDITION)));
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED,
						(new AttributeModifier(UUID.fromString("e3e22cbf-5bf9-4786-bf1b-7c12b6acbe21"), "gilded_boots_speed", 0.05, AttributeModifier.Operation.MULTIPLY_BASE)));
			}
		}
	}
}
