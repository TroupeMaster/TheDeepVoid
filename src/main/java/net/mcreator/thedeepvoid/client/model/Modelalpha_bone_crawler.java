package net.mcreator.thedeepvoid.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.12.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelalpha_bone_crawler<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("the_deep_void", "modelalpha_bone_crawler"), "main");
	public final ModelPart body;
	public final ModelPart head;
	public final ModelPart left_leg1;
	public final ModelPart left_leg0;
	public final ModelPart right_leg0;
	public final ModelPart left_leg2;
	public final ModelPart right_leg2;
	public final ModelPart right_leg1;

	public Modelalpha_bone_crawler(ModelPart root) {
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.left_leg1 = root.getChild("left_leg1");
		this.left_leg0 = root.getChild("left_leg0");
		this.right_leg0 = root.getChild("right_leg0");
		this.left_leg2 = root.getChild("left_leg2");
		this.right_leg2 = root.getChild("right_leg2");
		this.right_leg1 = root.getChild("right_leg1");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 32).addBox(-8.0F, -4.0F, 0.0F, 16.0F, 7.0F, 22.0F, new CubeDeformation(0.0F)).texOffs(0, 86).addBox(-1.0F, -7.0F, 0.0F, 2.0F, 3.0F, 22.0F, new CubeDeformation(0.0F)).texOffs(76, 32)
						.addBox(0.0F, -15.0F, -3.0F, 0.0F, 11.0F, 28.0F, new CubeDeformation(0.0F)).texOffs(0, 61).addBox(-8.0F, 3.0F, 0.0F, 16.0F, 3.0F, 22.0F, new CubeDeformation(0.0F)).texOffs(84, 0)
						.addBox(-7.0F, 3.0F, 1.0F, 14.0F, 1.0F, 20.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(0.0F, -4.1F, 3.0F, 10.0F, 0.0F, 32.0F, new CubeDeformation(0.0F)).texOffs(0, 0).mirror()
						.addBox(-10.0F, -4.1F, 3.0F, 10.0F, 0.0F, 32.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(0.0F, 18.0F, -11.0F));
		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(48, 87).addBox(-7.0F, -3.0F, -10.0F, 14.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(76, 71).addBox(-11.0F, 0.0F, -16.0F, 22.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 18.0F, -11.0F));
		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(96, 87).mirror().addBox(-2.0F, -5.0F, -11.0F, 3.0F, 11.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-3.0F, 0.0F, -8.0F, 0.0F, -0.0873F, 0.0F));
		PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(96, 87).addBox(-1.0F, -5.0F, -11.0F, 3.0F, 11.0F, 13.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0F, 0.0F, -8.0F, 0.0F, 0.0873F, 0.0F));
		PartDefinition left_leg1 = partdefinition.addOrReplaceChild("left_leg1", CubeListBuilder.create().texOffs(74, 104).addBox(-2.4617F, -16.113F, -2.0F, 5.0F, 17.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(6.0F, 19.0F, 0.0F, 0.0F, 0.0F, 1.0908F));
		PartDefinition cube_r3 = left_leg1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(84, 21).addBox(-7.0F, -3.0F, 0.5F, 13.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.4617F, -9.113F, 0.0F, 0.0F, 0.0F, 1.5708F));
		PartDefinition cube_r4 = left_leg1.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(48, 104).addBox(-7.0F, -16.0F, 0.5F, 13.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 111).addBox(-1.0F, -11.0F, -1.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.4617F, -16.113F, 0.0F, 0.0F, 0.0F, 1.5708F));
		PartDefinition left_leg0 = partdefinition.addOrReplaceChild("left_leg0", CubeListBuilder.create().texOffs(74, 104).addBox(-2.4617F, -16.113F, -2.0F, 5.0F, 17.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(6.0F, 18.0F, -5.0F, 0.2657F, 0.1685F, 1.1364F));
		PartDefinition cube_r5 = left_leg0.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(84, 21).addBox(-7.0F, -3.0F, 0.5F, 13.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.4617F, -9.113F, 0.0F, 0.0F, 0.0F, 1.5708F));
		PartDefinition cube_r6 = left_leg0.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(48, 104).addBox(-7.0F, -16.0F, 0.5F, 13.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 111).addBox(-1.0F, -11.0F, -1.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.4617F, -16.113F, 0.0F, 0.0F, 0.0F, 1.5708F));
		PartDefinition right_leg0 = partdefinition.addOrReplaceChild("right_leg0", CubeListBuilder.create().texOffs(74, 104).mirror().addBox(-2.5383F, -16.113F, -2.0F, 5.0F, 17.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-6.0F, 18.0F, -5.0F, 0.2657F, -0.1685F, -1.1364F));
		PartDefinition cube_r7 = right_leg0.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(84, 21).mirror().addBox(-6.0F, -3.0F, 0.5F, 13.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(5.4617F, -9.113F, 0.0F, 0.0F, 0.0F, -1.5708F));
		PartDefinition cube_r8 = right_leg0.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(48, 104).mirror().addBox(-6.0F, -16.0F, 0.5F, 13.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 111).mirror()
				.addBox(-2.0F, -11.0F, -1.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.4617F, -16.113F, 0.0F, 0.0F, 0.0F, -1.5708F));
		PartDefinition left_leg2 = partdefinition.addOrReplaceChild("left_leg2", CubeListBuilder.create().texOffs(74, 104).addBox(-2.4617F, -16.113F, -3.0F, 5.0F, 17.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(6.0F, 18.0F, 6.0F, -0.2657F, -0.1685F, 1.1364F));
		PartDefinition cube_r9 = left_leg2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(84, 21).addBox(-7.0F, -3.0F, -0.5F, 13.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.4617F, -9.113F, 0.0F, 0.0F, 0.0F, 1.5708F));
		PartDefinition cube_r10 = left_leg2.addOrReplaceChild("cube_r10",
				CubeListBuilder.create().texOffs(48, 104).addBox(-7.0F, -16.0F, -0.5F, 13.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 111).addBox(-1.0F, -11.0F, -2.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.4617F, -16.113F, 0.0F, 0.0F, 0.0F, 1.5708F));
		PartDefinition right_leg2 = partdefinition.addOrReplaceChild("right_leg2", CubeListBuilder.create().texOffs(74, 104).mirror().addBox(-2.5383F, -16.113F, -3.0F, 5.0F, 17.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-6.0F, 18.0F, 6.0F, -0.2657F, 0.1685F, -1.1364F));
		PartDefinition cube_r11 = right_leg2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(84, 21).mirror().addBox(-6.0F, -3.0F, -0.5F, 13.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(5.4617F, -9.113F, 0.0F, 0.0F, 0.0F, -1.5708F));
		PartDefinition cube_r12 = right_leg2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(48, 104).mirror().addBox(-6.0F, -16.0F, -0.5F, 13.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 111).mirror()
				.addBox(-2.0F, -11.0F, -2.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.4617F, -16.113F, 0.0F, 0.0F, 0.0F, -1.5708F));
		PartDefinition right_leg1 = partdefinition.addOrReplaceChild("right_leg1", CubeListBuilder.create().texOffs(74, 104).mirror().addBox(-2.5383F, -16.113F, -2.0F, 5.0F, 17.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-6.0F, 19.0F, 0.0F, 0.0F, 0.0F, -1.0908F));
		PartDefinition cube_r13 = right_leg1.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(84, 21).mirror().addBox(-6.0F, -3.0F, 0.5F, 13.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(5.4617F, -9.113F, 0.0F, 0.0F, 0.0F, -1.5708F));
		PartDefinition cube_r14 = right_leg1.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(48, 104).mirror().addBox(-6.0F, -16.0F, 0.5F, 13.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 111).mirror()
				.addBox(-2.0F, -11.0F, -1.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.4617F, -16.113F, 0.0F, 0.0F, 0.0F, -1.5708F));
		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg0.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg0.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.right_leg1.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.right_leg2.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.right_leg0.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.left_leg0.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.left_leg1.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.left_leg2.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}
