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

// Made with Blockbench 4.11.0
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelroamer<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("the_deep_void", "modelroamer"), "main");
	public final ModelPart left_leg_front;
	public final ModelPart left_leg_back;
	public final ModelPart right_leg_back;
	public final ModelPart right_leg_front;
	public final ModelPart body;
	public final ModelPart neck;
	public final ModelPart head;

	public Modelroamer(ModelPart root) {
		this.left_leg_front = root.getChild("left_leg_front");
		this.left_leg_back = root.getChild("left_leg_back");
		this.right_leg_back = root.getChild("right_leg_back");
		this.right_leg_front = root.getChild("right_leg_front");
		this.body = root.getChild("body");
		this.neck = root.getChild("neck");
		this.head = root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition left_leg_front = partdefinition.addOrReplaceChild("left_leg_front", CubeListBuilder.create().texOffs(176, 150).addBox(-1.0F, 14.7011F, -29.3251F, 0.0F, 40.0F, 28.0F, new CubeDeformation(0.0F)),
				PartPose.offset(16.0F, -25.0F, -10.0F));
		PartDefinition cube_r1 = left_leg_front.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(258, 61).addBox(-4.0F, -31.0F, -4.0F, 6.0F, 33.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 26.0F, -17.0F, -0.2618F, 0.0F, 0.0F));
		PartDefinition left_leg_back = partdefinition.addOrReplaceChild("left_leg_back", CubeListBuilder.create().texOffs(56, 216).addBox(1.0F, 14.7011F, -5.6749F, 0.0F, 40.0F, 28.0F, new CubeDeformation(0.0F)),
				PartPose.offset(14.0F, -25.0F, 17.0F));
		PartDefinition cube_r2 = left_leg_back.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(216, 256).addBox(-4.0F, -31.0F, -4.0F, 6.0F, 34.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 26.0F, 7.0F, 0.6109F, 0.0F, 0.0F));
		PartDefinition right_leg_back = partdefinition.addOrReplaceChild("right_leg_back", CubeListBuilder.create().texOffs(112, 216).addBox(-1.0F, 14.7011F, -5.6749F, 0.0F, 40.0F, 28.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-14.0F, -25.0F, 17.0F));
		PartDefinition cube_r3 = right_leg_back.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(244, 256).addBox(-2.0F, -31.0F, -4.0F, 6.0F, 34.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 26.0F, 7.0F, 0.6109F, 0.0F, 0.0F));
		PartDefinition right_leg_front = partdefinition.addOrReplaceChild("right_leg_front", CubeListBuilder.create().texOffs(0, 206).addBox(1.0F, 14.7011F, -29.3251F, 0.0F, 40.0F, 28.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-16.0F, -25.0F, -10.0F));
		PartDefinition cube_r4 = right_leg_front.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(258, 102).addBox(-2.0F, -31.0F, -4.0F, 6.0F, 33.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 26.0F, -17.0F, -0.2618F, 0.0F, 0.0F));
		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -57.0F, -28.0F, 24.0F, 18.0F, 44.0F, new CubeDeformation(0.0F)).texOffs(136, 0).addBox(0.0F, -75.0F, -28.0F, 0.0F, 18.0F, 44.0F, new CubeDeformation(0.0F)).texOffs(0, 62)
						.addBox(0.0F, -65.0F, 16.0F, 0.0F, 21.0F, 57.0F, new CubeDeformation(0.0F)).texOffs(114, 62).addBox(-14.0F, -59.0F, -28.0F, 28.0F, 0.0F, 44.0F, new CubeDeformation(0.0F)).texOffs(0, 140)
						.addBox(-14.0F, -59.0F, -28.0F, 0.0F, 22.0F, 44.0F, new CubeDeformation(0.0F)).texOffs(88, 150).addBox(14.0F, -59.0F, -28.0F, 0.0F, 22.0F, 44.0F, new CubeDeformation(0.0F)).texOffs(234, 204)
						.addBox(-4.0F, -45.0F, 37.0F, 8.0F, 6.0F, 20.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r5 = body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(168, 251).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -42.0F, 57.0F, 0.2618F, 0.0F, 0.0F));
		PartDefinition cube_r6 = body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(232, 178).addBox(-6.0F, -5.0F, -3.0F, 12.0F, 10.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -44.0F, 27.0F, -0.2182F, 0.0F, 0.0F));
		PartDefinition cube_r7 = body.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(224, 32).addBox(-8.0F, -7.0F, -4.0F, 16.0F, 14.0F, 15.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -48.0F, 16.0F, -0.4363F, 0.0F, 0.0F));
		PartDefinition neck = partdefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(234, 230).addBox(-7.0F, -7.0F, -9.0F, 14.0F, 14.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, -28.0F));
		PartDefinition cube_r8 = neck.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(168, 218).addBox(-6.0F, -6.0F, -18.0F, 12.0F, 12.0F, 21.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -9.0F, 0.3054F, 0.0F, 0.0F));
		PartDefinition cube_r9 = neck.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(232, 150).addBox(-5.0F, -5.0F, -18.0F, 10.0F, 9.0F, 19.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 6.0F, -24.0F, 0.7418F, 0.0F, 0.0F));
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(224, 0).addBox(-8.0F, -4.0F, -13.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, -63.0F));
		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		left_leg_front.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg_back.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg_back.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg_front.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		neck.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.left_leg_front.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.left_leg_back.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.right_leg_back.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.right_leg_front.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}
