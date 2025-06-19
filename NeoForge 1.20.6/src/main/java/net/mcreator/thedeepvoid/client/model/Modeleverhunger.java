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

// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modeleverhunger<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("the_deep_void", "modeleverhunger"), "main");
	public final ModelPart left_leg;
	public final ModelPart right_leg;
	public final ModelPart body;
	public final ModelPart head;
	public final ModelPart left_arm;
	public final ModelPart right_arm;

	public Modeleverhunger(ModelPart root) {
		this.left_leg = root.getChild("left_leg");
		this.right_leg = root.getChild("right_leg");
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.left_arm = root.getChild("left_arm");
		this.right_arm = root.getChild("right_arm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(90, 0).addBox(-2.0F, -1.0F, -3.0F, 4.0F, 28.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -3.0F, 2.0F));
		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(90, 33).addBox(-2.0F, -1.0F, -3.0F, 4.0F, 28.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -3.0F, 2.0F));
		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(48, 97).addBox(-1.0F, -17.0F, -2.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(0, 28).addBox(0.0F, -21.0F, -4.0F, 0.0F, 21.0F, 15.0F, new CubeDeformation(0.0F)).texOffs(66, 97)
						.addBox(-1.0F, -12.0F, -1.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(84, 99).addBox(-1.0F, -7.0F, 0.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -3.0F, 2.0F));
		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 64).addBox(0.0F, -9.0F, -3.0F, 0.0F, 21.0F, 15.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, -12.0F, -2.0F, 0.0F, -1.2217F, 0.0F));
		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(60, 36).addBox(0.0F, -9.0F, -3.0F, 0.0F, 21.0F, 15.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, -12.0F, -2.0F, 0.0F, 1.2217F, 0.0F));
		PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(60, 0).addBox(0.0F, -9.0F, -3.0F, 0.0F, 21.0F, 15.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, -12.0F, -1.0F, 0.0F, 0.5236F, 0.0F));
		PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(30, 28).addBox(0.0F, -9.0F, -3.0F, 0.0F, 21.0F, 15.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, -12.0F, -1.0F, 0.0F, -0.5236F, 0.0F));
		PartDefinition cube_r5 = body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -21.0F, -2.0F, 12.0F, 21.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.0F, -2.0F, 0.2618F, 0.0F, 0.0F));
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -19.0F, -6.0F));
		PartDefinition cube_r6 = head.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(62, 72).addBox(-4.0F, -9.0F, -4.0F, 8.0F, 17.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, 5.0F, -2.0F, 0.4363F, 0.3054F, 0.0F));
		PartDefinition cube_r7 = head.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(30, 72).addBox(-4.0F, -9.0F, -4.0F, 8.0F, 17.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0F, 2.0F, -2.0F, -0.0873F, -0.3054F, 0.0F));
		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm",
				CubeListBuilder.create().texOffs(94, 66).addBox(0.0F, -5.0F, -3.0F, 4.0F, 28.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(38, 0).addBox(4.0F, -5.0F, -1.0F, 4.0F, 28.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(6.0F, -19.0F, -2.0F));
		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm",
				CubeListBuilder.create().texOffs(30, 97).addBox(-4.0F, -5.0F, -3.0F, 4.0F, 28.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(46, 0).addBox(-8.0F, -5.0F, -1.0F, 4.0F, 28.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-6.0F, -19.0F, -2.0F));
		return LayerDefinition.create(meshdefinition, 144, 144);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.right_arm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.left_arm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
	}
}
