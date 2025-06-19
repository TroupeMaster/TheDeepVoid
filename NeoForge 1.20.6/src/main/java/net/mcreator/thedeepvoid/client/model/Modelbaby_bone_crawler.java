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

// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelbaby_bone_crawler<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("the_deep_void", "modelbaby_bone_crawler"), "main");
	public final ModelPart body;
	public final ModelPart head;
	public final ModelPart left_leg0;
	public final ModelPart right_leg0;
	public final ModelPart left_leg2;
	public final ModelPart right_leg2;
	public final ModelPart left_leg1;
	public final ModelPart right_leg1;

	public Modelbaby_bone_crawler(ModelPart root) {
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.left_leg0 = root.getChild("left_leg0");
		this.right_leg0 = root.getChild("right_leg0");
		this.left_leg2 = root.getChild("left_leg2");
		this.right_leg2 = root.getChild("right_leg2");
		this.left_leg1 = root.getChild("left_leg1");
		this.right_leg1 = root.getChild("right_leg1");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -3.0F, 0.0F, 8.0F, 4.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, -6.0F));
		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 17).addBox(-4.0F, -2.0F, -5.0F, 8.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 25).addBox(-4.0F, -2.0F, -10.0F, 8.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 22.0F, -6.0F));
		PartDefinition left_leg0 = partdefinition.addOrReplaceChild("left_leg0",
				CubeListBuilder.create().texOffs(0, 33).addBox(0.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(26, 17).addBox(4.0F, -2.0F, 0.0F, 10.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0F, 21.0F, -2.0F, 0.0F, 0.3054F, 0.1745F));
		PartDefinition right_leg0 = partdefinition.addOrReplaceChild("right_leg0",
				CubeListBuilder.create().texOffs(0, 37).addBox(-7.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(26, 26).addBox(-14.0F, -2.0F, 0.0F, 10.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, 21.0F, -2.0F, 0.0F, -0.3054F, -0.1745F));
		PartDefinition left_leg2 = partdefinition.addOrReplaceChild("left_leg2",
				CubeListBuilder.create().texOffs(36, 35).addBox(0.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(26, 23).addBox(4.0F, -2.0F, 0.0F, 10.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0F, 21.0F, 4.0F, 0.0F, -0.3054F, 0.1745F));
		PartDefinition right_leg2 = partdefinition.addOrReplaceChild("right_leg2",
				CubeListBuilder.create().texOffs(18, 39).addBox(-7.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(26, 29).addBox(-14.0F, -2.0F, 0.0F, 10.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, 21.0F, 4.0F, 0.0F, 0.3054F, -0.1745F));
		PartDefinition left_leg1 = partdefinition.addOrReplaceChild("left_leg1",
				CubeListBuilder.create().texOffs(18, 35).addBox(0.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(26, 20).addBox(4.0F, -2.0F, 0.0F, 10.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0F, 21.0F, 1.0F, 0.0F, 0.0F, 0.1745F));
		PartDefinition right_leg1 = partdefinition.addOrReplaceChild("right_leg1",
				CubeListBuilder.create().texOffs(36, 39).addBox(-7.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(26, 32).addBox(-14.0F, -2.0F, 0.0F, 10.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, 21.0F, 1.0F, 0.0F, 0.0F, -0.1745F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg0.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg0.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.right_leg1.yRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.right_leg2.yRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.right_leg0.yRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.left_leg0.yRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.left_leg1.yRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.left_leg2.yRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}
