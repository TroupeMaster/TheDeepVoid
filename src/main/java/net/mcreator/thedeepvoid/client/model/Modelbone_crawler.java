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

// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelbone_crawler<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("the_deep_void", "modelbone_crawler"), "main");
	public final ModelPart body;
	public final ModelPart head;
	public final ModelPart leg_left_last;
	public final ModelPart leg_left_middle;
	public final ModelPart leg_left_front;
	public final ModelPart leg_right_last;
	public final ModelPart leg_right_middle;
	public final ModelPart leg_right_front;

	public Modelbone_crawler(ModelPart root) {
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.leg_left_last = root.getChild("leg_left_last");
		this.leg_left_middle = root.getChild("leg_left_middle");
		this.leg_left_front = root.getChild("leg_left_front");
		this.leg_right_last = root.getChild("leg_right_last");
		this.leg_right_middle = root.getChild("leg_right_middle");
		this.leg_right_front = root.getChild("leg_right_front");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(23, 21).addBox(-4.0F, -1.0F, -3.0F, 8.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, 0.0F));
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(34, 0).addBox(-4.0F, -1.0F, -5.0F, 8.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, -3.0F));
		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 34).addBox(-8.0F, -8.0F, 0.0F, 16.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -5.0F, 0.8727F, 0.0F, 0.0F));
		PartDefinition leg_left_last = partdefinition.addOrReplaceChild("leg_left_last", CubeListBuilder.create().texOffs(12, 28).addBox(0.0F, 0.0F, -2.0F, 9.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0F, 23.0F, 6.0F, 0.0F, 0.0F, 0.0873F));
		PartDefinition leg_left_middle = partdefinition.addOrReplaceChild("leg_left_middle", CubeListBuilder.create().texOffs(12, 28).addBox(0.0F, 0.0F, -2.0F, 9.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0F, 23.0F, 2.0F, 0.0F, 0.0F, 0.0873F));
		PartDefinition leg_left_front = partdefinition.addOrReplaceChild("leg_left_front", CubeListBuilder.create().texOffs(12, 28).addBox(0.0F, 0.0F, -2.0F, 9.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0F, 23.0F, -2.0F, 0.0F, 0.0F, 0.0873F));
		PartDefinition leg_right_last = partdefinition.addOrReplaceChild("leg_right_last", CubeListBuilder.create().texOffs(12, 12).addBox(-9.0F, 0.0F, -2.0F, 9.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0F, 23.0F, 6.0F, 0.0F, 0.0F, -0.0873F));
		PartDefinition leg_right_middle = partdefinition.addOrReplaceChild("leg_right_middle", CubeListBuilder.create().texOffs(12, 12).addBox(-9.0F, 0.0F, -2.0F, 9.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0F, 23.0F, 2.0F, 0.0F, 0.0F, -0.0873F));
		PartDefinition leg_right_front = partdefinition.addOrReplaceChild("leg_right_front", CubeListBuilder.create().texOffs(12, 12).addBox(-9.0F, 0.0F, -2.0F, 9.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0F, 23.0F, -2.0F, 0.0F, 0.0F, -0.0873F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg_left_last.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg_left_middle.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg_left_front.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg_right_last.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg_right_middle.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg_right_front.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.leg_left_middle.yRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.leg_right_front.yRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.leg_right_last.yRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.leg_left_front.yRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.leg_right_middle.yRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.leg_left_last.yRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}
