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
public class Modelfool_eater_rework<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("the_deep_void", "modelfool_eater_rework"), "main");
	public final ModelPart right_arm;
	public final ModelPart left_arm;
	public final ModelPart right_leg;
	public final ModelPart left_leg;
	public final ModelPart body;
	public final ModelPart head;

	public Modelfool_eater_rework(ModelPart root) {
		this.right_arm = root.getChild("right_arm");
		this.left_arm = root.getChild("left_arm");
		this.right_leg = root.getChild("right_leg");
		this.left_leg = root.getChild("left_leg");
		this.body = root.getChild("body");
		this.head = root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm",
				CubeListBuilder.create().texOffs(126, 108).addBox(-4.0F, -3.0F, -4.0F, 7.0F, 51.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(14, 0).mirror().addBox(-4.0F, -3.9289F, 3.0F, 7.0F, 52.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-15.0F, -94.0F, -5.0F, -0.6391F, 0.0345F, 0.0347F));
		PartDefinition cube_r1 = right_arm.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(14, 0).mirror().addBox(-3.0F, -1.9289F, -3.6493F, 7.0F, 65.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-1.0F, 53.0F, 4.0F, -0.6981F, 0.0F, 0.0F));
		PartDefinition cube_r2 = right_arm.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 36).addBox(-14.0F, -0.0245F, -24.3949F, 27.0F, 0.0F, 36.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 97.0F, -41.0F, -0.6981F, 0.0F, 0.0F));
		PartDefinition cube_r3 = right_arm.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(98, 108).addBox(-4.0F, -1.9289F, -3.6493F, 7.0F, 65.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 48.0F, -1.0F, -0.6981F, 0.0F, 0.0F));
		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(14, 0).mirror().addBox(-3.0F, -3.9289F, 3.0F, 7.0F, 52.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(126, 108).mirror()
				.addBox(-3.0F, -3.0F, -4.0F, 7.0F, 51.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(15.0F, -94.0F, -5.0F, -0.6391F, -0.0345F, -0.0347F));
		PartDefinition cube_r4 = left_arm.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 36).mirror().addBox(-13.0F, -0.0245F, -24.3949F, 27.0F, 0.0F, 36.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 97.0F, -41.0F, -0.6981F, 0.0F, 0.0F));
		PartDefinition cube_r5 = left_arm.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(14, 0).mirror().addBox(-3.0F, -1.9289F, -3.6493F, 7.0F, 65.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 53.0F, 4.0F, -0.6981F, 0.0F, 0.0F));
		PartDefinition cube_r6 = left_arm.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(98, 108).mirror().addBox(-3.0F, -1.9289F, -3.6493F, 7.0F, 65.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 48.0F, -1.0F, -0.6981F, 0.0F, 0.0F));
		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offsetAndRotation(-10.0F, -56.0F, 8.0F, 0.0869F, 0.0076F, 0.1312F));
		PartDefinition cube_r7 = right_leg.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(189, 73).mirror().addBox(0.0F, -47.0F, -3.0F, 0.0F, 36.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, -10.0F, -4.0F, 2.812F, 0.1311F, 0.1472F));
		PartDefinition cube_r8 = right_leg.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(189, 73).addBox(0.0F, -47.0F, -3.0F, 0.0F, 47.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 81.0F, -6.0F, 0.0016F, -0.0037F, -0.1304F));
		PartDefinition cube_r9 = right_leg.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(154, 0).addBox(-5.1383F, -38.8488F, 4.4611F, 7.0F, 39.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, 31.867F, -19.9505F, -0.3459F, 0.0376F, 0.1705F));
		PartDefinition cube_r10 = right_leg.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(28, 130).addBox(-4.5069F, 1.9908F, 4.9857F, 7.0F, 50.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-6.0F, 30.867F, -20.9505F, -0.001F, 0.0564F, -0.1236F));
		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offsetAndRotation(10.0F, -56.0F, 8.0F, 0.0869F, -0.0076F, -0.1312F));
		PartDefinition cube_r11 = left_leg.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(189, 73).addBox(0.0F, -47.0F, -3.0F, 0.0F, 36.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -10.0F, -4.0F, 2.812F, -0.1311F, -0.1472F));
		PartDefinition cube_r12 = left_leg.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(189, 73).addBox(0.0F, -47.0F, -3.0F, 0.0F, 47.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 82.0F, -6.0F, 0.0006F, -0.0039F, 0.1314F));
		PartDefinition cube_r13 = left_leg.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(154, 0).mirror().addBox(-1.8617F, -38.8488F, 4.4611F, 7.0F, 39.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(5.0F, 31.867F, -19.9505F, -0.3459F, -0.0376F, -0.1705F));
		PartDefinition cube_r14 = left_leg.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(28, 130).mirror().addBox(-2.4931F, 1.9908F, 4.9857F, 7.0F, 50.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(6.0F, 30.867F, -20.9505F, -0.001F, -0.0564F, 0.1236F));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -56.0F, 7.0F));
		PartDefinition cube_r15 = body.addOrReplaceChild("cube_r15",
				CubeListBuilder.create().texOffs(182, 66).addBox(0.0F, -47.0F, -3.0F, 0.0F, 47.0F, 15.0F, new CubeDeformation(0.0F)).texOffs(182, 66).addBox(6.0F, -47.0F, -3.0F, 0.0F, 47.0F, 15.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, -1.0F, 8.0F, 0.3491F, 0.0F, 0.0F));
		PartDefinition cube_r16 = body.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 72).addBox(-12.0F, -47.0F, -6.0F, 24.0F, 47.0F, 11.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 2.0F, 1.0F, 0.3491F, 0.0F, 0.0F));
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -98.0F, -10.0F));
		PartDefinition cube_r17 = head.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(167, 31).addBox(-9.0F, -7.5F, -18.7F, 18.0F, 11.0F, 18.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 8.0F, -6.0F, 0.2182F, 0.0F, 0.0F));
		PartDefinition cube_r18 = head.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(70, 72).addBox(-9.0F, -10.0F, -18.0F, 18.0F, 18.0F, 18.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -7.0F, -10.0F, 0.2182F, 0.0F, 0.0F));
		PartDefinition cube_r19 = head.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(154, 104).addBox(-4.0F, -19.0F, -5.0F, 6.0F, 19.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 0.0F, 4.0F, 1.0472F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}
