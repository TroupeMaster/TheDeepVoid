package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.init.TheDeepVoidModItems;
import net.sombrius.thedeepvoid.configuration.DeepVoidConfigConfiguration;

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
						(new AttributeModifier(UUID.fromString("91c6ac39-df93-477d-878a-3f8a1c0a3747"), "naginata_reach", ((double) DeepVoidConfigConfiguration.ONYXNAGINATAREACHADDITION.get()), AttributeModifier.Operation.ADDITION)));
			} else if (itemstack.getItem() == TheDeepVoidModItems.PENITENT_CROSS.get()) {
				_event.addModifier(ForgeMod.ENTITY_REACH.get(),
						(new AttributeModifier(UUID.fromString("1d949c6f-0aa0-4cb1-b4d1-0da21d149162"), "cross_reach", ((double) DeepVoidConfigConfiguration.PENITENTCROSSREACHADDITION.get()), AttributeModifier.Operation.ADDITION)));
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK, (new AttributeModifier(UUID.fromString("daa20447-a292-4a1f-be0b-5a1d395597bc"), "cross_knockback", 1.3, AttributeModifier.Operation.ADDITION)));
			} else if (itemstack.getItem() == TheDeepVoidModItems.SHANK.get()) {
				_event.addModifier(ForgeMod.ENTITY_REACH.get(), (new AttributeModifier(UUID.fromString("c06b46ef-d58e-4c6c-8731-a6cf6274b2c9"), "shank_reach", (-0.5), AttributeModifier.Operation.ADDITION)));
			} else if (itemstack.getItem() == TheDeepVoidModItems.EXECUTIONER_SWORD.get()) {
				_event.addModifier(ForgeMod.ENTITY_REACH.get(), (new AttributeModifier(UUID.fromString("91c3cc39-df93-477d-878a-3f8a1c0a3747"), "executioner_reach", 1, AttributeModifier.Operation.ADDITION)));
			} else if (itemstack.getItem() == TheDeepVoidModItems.STINGER.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED, (new AttributeModifier(UUID.fromString("3ebf6c26-26e9-4652-8ed1-054178166bea"), "stinger_speed", 1.4, AttributeModifier.Operation.ADDITION)));
			} else if (itemstack.getItem() == TheDeepVoidModItems.KNIVES_GLOVE.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED, (new AttributeModifier(UUID.fromString("77b8b253-e87d-4b69-a7eb-83208a542bda"), "knife_glove_speed", 0.4, AttributeModifier.Operation.ADDITION)));
			} else if (itemstack.is(ItemTags.create(new ResourceLocation("the_deep_void:dark_steel_tools")))) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK,
						(new AttributeModifier(UUID.fromString("582300b7-5e68-4807-a822-01bebd809fd3"), "dark_steel_tool_knockback", 1, AttributeModifier.Operation.ADDITION)));
			} else if (itemstack.is(ItemTags.create(new ResourceLocation("the_deep_void:scythes")))) {
				_event.addModifier(ForgeMod.ENTITY_REACH.get(),
						(new AttributeModifier(UUID.fromString("ebf794e9-482e-4e28-81b3-2f8d23258894"), "scythe_reach", ((double) DeepVoidConfigConfiguration.SCYTHESREACH.get()), AttributeModifier.Operation.ADDITION)));
			} else if (itemstack.getItem() == TheDeepVoidModItems.VOIDRIUM_BULWARK.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE, (new AttributeModifier(UUID.fromString("ea9dbfe9-9f46-4046-b57a-d47dbe387cca"), "bulwark_damage", 5, AttributeModifier.Operation.ADDITION)));
			} else if (itemstack.getItem() == TheDeepVoidModItems.ROT_TONGUE.get()) {
				_event.addModifier(ForgeMod.ENTITY_REACH.get(), (new AttributeModifier(UUID.fromString("113f833e-af9f-460e-b241-4d8f43a07a86"), "rotten_tongue_reach", 0.6, AttributeModifier.Operation.ADDITION)));
			} else if (itemstack.getItem() == TheDeepVoidModItems.ICHOR_GREATSWORD.get()) {
				_event.addModifier(ForgeMod.ENTITY_REACH.get(), (new AttributeModifier(UUID.fromString("35a80e0b-12f5-4144-ae1f-a97eb041cfa7"), "ichorgreatsword_reach", 0.6, AttributeModifier.Operation.ADDITION)));
			} else if (itemstack.getItem() == TheDeepVoidModItems.BLOODY_CHAINSAW.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK,
						(new AttributeModifier(UUID.fromString("500adec7-d9f3-4d82-8e04-35c74fcd939b"), "chainsaw_knockback", (-0.9), AttributeModifier.Operation.MULTIPLY_TOTAL)));
			} else if (itemstack.getItem() == TheDeepVoidModItems.JUDGEMENT.get()) {
				_event.addModifier(ForgeMod.ENTITY_REACH.get(), (new AttributeModifier(UUID.fromString("6d6c2b75-a398-4232-9e1c-1547c735cf8a"), "judgement_reach", 0.55, AttributeModifier.Operation.ADDITION)));
			} else if (itemstack.getItem() == TheDeepVoidModItems.VOID_MATTER_GREATSWORD.get()) {
				_event.addModifier(ForgeMod.ENTITY_REACH.get(), (new AttributeModifier(UUID.fromString("48f3899b-36d3-4114-bf7e-e331e1095109"), "greatsword_reach", 0.55, AttributeModifier.Operation.ADDITION)));
			} else if (itemstack.getItem() == TheDeepVoidModItems.CLAW_SCYTHE.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED, (new AttributeModifier(UUID.fromString("34336e81-e420-44ed-9b7c-5823ad725ae7"), "clawscythe_speed", (-0.8), AttributeModifier.Operation.ADDITION)));
			} else if (itemstack.getItem() == TheDeepVoidModItems.BALL_AND_CHAIN.get()) {
				_event.addModifier(ForgeMod.ENTITY_REACH.get(), (new AttributeModifier(UUID.fromString("5e859aad-6ca6-489d-89fe-aa1f057764a5"), "ball_and_chain_reach", (-5), AttributeModifier.Operation.ADDITION)));
			} else if (itemstack.getItem() == TheDeepVoidModItems.CEREMONIAL_DAGGER.get()) {
				_event.addModifier(ForgeMod.ENTITY_REACH.get(), (new AttributeModifier(UUID.fromString("c06f24ef-d58e-4c6c-8731-a6ca8764b269"), "ceremonial_reach", (-0.75), AttributeModifier.Operation.ADDITION)));
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE,
						(new AttributeModifier(UUID.fromString("e2bd140a-7c62-4aac-b997-e3dcb3e25846"), "ceremonial_damage", (itemstack.getOrCreateTag().getDouble("kills")), AttributeModifier.Operation.ADDITION)));
			}
		}
	}
}
