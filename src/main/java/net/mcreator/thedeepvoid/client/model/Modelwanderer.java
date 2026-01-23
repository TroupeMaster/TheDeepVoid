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

// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelwanderer<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("the_deep_void", "modelwanderer"), "main");
	public final ModelPart right_leg;
	public final ModelPart left_leg;
	public final ModelPart body;
	public final ModelPart head;
	public final ModelPart neck;
	public final ModelPart left_arm;
	public final ModelPart right_arm;

	public Modelwanderer(ModelPart root) {
		this.right_leg = root.getChild("right_leg");
		this.left_leg = root.getChild("left_leg");
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.neck = root.getChild("neck");
		this.left_arm = root.getChild("left_arm");
		this.right_arm = root.getChild("right_arm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 78).addBox(-2.7F, 16.0F, -5.5F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, -1.0F));
		PartDefinition cube_r1 = right_leg.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(16, 78).addBox(-2.2F, -1.0F, -1.8F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 8.0F, -6.0F, 0.3054F, 0.0F, 0.0F));
		PartDefinition cube_r2 = right_leg.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(76, 65).addBox(-1.7F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, -0.6545F, 0.0F, 0.0F));
		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(77, 16).addBox(-1.3F, 16.0F, -5.5F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, -1.0F));
		PartDefinition cube_r3 = left_leg.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 55).addBox(-0.8F, -1.0F, -1.8F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 8.0F, -6.0F, 0.3054F, 0.0F, 0.0F));
		PartDefinition cube_r4 = left_leg.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(35, 0).addBox(-2.3F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, -0.6545F, 0.0F, 0.0F));
		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(50, 28).addBox(-5.0F, -22.0F, -3.0F, 10.0F, 22.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(36, 59).addBox(0.0F, -22.0F, 2.0F, 0.0F, 22.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.1745F, 0.0F, 0.0F));
		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(57, 0).addBox(-4.0F, -1.0F, -20.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(81, 0).addBox(-4.0F, 7.0F, -12.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(80, 42)
						.addBox(-4.0F, 7.0F, -20.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(61, 11).addBox(-4.0F, 7.0F, -20.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 6)
						.addBox(4.0F, 7.0F, -20.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -25.0F, -24.0F));
		PartDefinition cube_r5 = head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(35, 6).addBox(0.0F, -4.0F, -13.0F, 0.0F, 4.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.2182F, 0.0F, 0.0F));
		PartDefinition cube_r6 = head.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(23, 45).addBox(1.5F, -4.0F, -12.0F, 0.0F, 11.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(51, 45).addBox(-1.5F, -4.0F, -12.0F, 0.0F, 11.0F, 13.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.2182F, 0.0F, 0.0F));
		PartDefinition cube_r7 = head.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 55).addBox(-2.0F, -4.0F, -13.0F, 4.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.2182F, 0.0F, 0.0F));
		PartDefinition neck = partdefinition.addOrReplaceChild("neck", CubeListBuilder.create(), PartPose.offset(0.0F, -18.0F, -5.0F));
		PartDefinition cube_r8 = neck.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 28).addBox(0.0F, -5.0F, -19.0F, 0.0F, 5.0F, 22.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.0F, -1.0F, -0.3491F, 0.0F, 0.0F));
		PartDefinition cube_r9 = neck.addOrReplaceChild("cube_r9",
				CubeListBuilder.create().texOffs(0, 6).addBox(3.5F, -6.0F, -19.0F, 0.0F, 11.0F, 22.0F, new CubeDeformation(0.0F)).texOffs(0, 17).addBox(-1.5F, -6.0F, -19.0F, 0.0F, 11.0F, 22.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 7.0F, -4.0F, -0.3491F, 0.0F, 0.0F));
		PartDefinition cube_r10 = neck.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -5.0F, -20.0F, 6.0F, 5.0F, 23.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 2.0F, -2.0F, -0.3491F, 0.0F, 0.0F));
		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm",
				CubeListBuilder.create().texOffs(28, 39).addBox(0.0F, -1.0F, -15.0F, 3.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(80, 28).addBox(1.0F, -10.0F, -15.0F, 1.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(56, 69)
						.addBox(1.0F, -10.0F, -24.0F, 1.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(18, 64).addBox(1.5F, -5.0F, -24.0F, 0.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.0F, -17.0F, -4.0F, 1.309F, 0.0F, 0.0F));
		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm",
				CubeListBuilder.create().texOffs(35, 0).addBox(-3.0F, -1.0F, -15.0F, 3.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(78, 50).addBox(-2.0F, -10.0F, -15.0F, 1.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-2.0F, -10.0F, -24.0F, 1.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 64).addBox(-1.5F, -5.0F, -24.0F, 0.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, -17.0F, -4.0F, 1.309F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		neck.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}
