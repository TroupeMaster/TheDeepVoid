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

// Made with Blockbench 4.12.0
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modeltamed_mother_bone_crawler<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("the_deep_void", "modeltamed_mother_bone_crawler"), "main");
	public final ModelPart body;
	public final ModelPart head;
	public final ModelPart left_leg0;
	public final ModelPart right_leg0;
	public final ModelPart left_leg2;
	public final ModelPart right_leg2;
	public final ModelPart left_leg1;
	public final ModelPart right_leg1;

	public Modeltamed_mother_bone_crawler(ModelPart root) {
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
		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -6.0F, -1.0F, 18.0F, 8.0F, 31.0F, new CubeDeformation(0.0F)).texOffs(90, 77).addBox(-8.0F, 2.0F, 0.0F, 16.0F, 3.0F, 29.0F, new CubeDeformation(0.0F)).texOffs(0, 77)
						.addBox(-8.0F, 5.0F, 0.0F, 16.0F, 6.0F, 29.0F, new CubeDeformation(0.0F)).texOffs(0, 39).addBox(-11.0F, -6.1F, 4.0F, 11.0F, 0.0F, 38.0F, new CubeDeformation(0.0F)).texOffs(0, 39).mirror()
						.addBox(0.0F, -6.1F, 4.0F, 11.0F, 0.0F, 38.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(0.0F, 6.0F, -13.0F));
		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(98, 0).addBox(-8.0F, -3.0F, -12.0F, 16.0F, 7.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(98, 19).addBox(-8.0F, 4.0F, -12.0F, 16.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(98, 35)
						.addBox(-7.0F, -5.0F, -23.0F, 6.0F, 11.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(98, 35).mirror().addBox(1.0F, -5.0F, -23.0F, 6.0F, 11.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(0.0F, 6.0F, -13.0F));
		PartDefinition left_leg0 = partdefinition.addOrReplaceChild("left_leg0", CubeListBuilder.create(), PartPose.offsetAndRotation(8.0F, 5.0F, -2.0F, 0.0F, 0.2618F, -0.1309F));
		PartDefinition cube_r1 = left_leg0.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(70, 112).addBox(-1.0F, -8.0F, -1.0F, 5.0F, 19.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(19.0F, 13.0F, 0.0F, 0.0F, 0.0F, 0.1745F));
		PartDefinition cube_r2 = left_leg0.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(98, 73).addBox(0.0F, -1.0F, 0.0F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(15.0F, -7.0F, 0.0F, 0.0F, 0.0F, 1.3526F));
		PartDefinition cube_r3 = left_leg0.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(98, 67).addBox(0.0F, -1.0F, -2.5F, 20.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(17.0F, -8.0F, 1.0F, 0.0F, 0.0F, 1.3526F));
		PartDefinition cube_r4 = left_leg0.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 112).addBox(-1.0F, -2.0F, 0.0F, 21.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 3.0F, 0.0F, 0.0F, 0.0F, -0.3927F));
		PartDefinition cube_r5 = left_leg0.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(98, 59).addBox(-1.0F, -2.0F, -2.0F, 21.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));
		PartDefinition right_leg0 = partdefinition.addOrReplaceChild("right_leg0", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.0F, 5.0F, -2.0F, 0.0F, -0.2618F, 0.1309F));
		PartDefinition cube_r6 = right_leg0.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(70, 112).mirror().addBox(-4.0F, -8.0F, -1.0F, 5.0F, 19.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-19.0F, 13.0F, 0.0F, 0.0F, 0.0F, -0.1745F));
		PartDefinition cube_r7 = right_leg0.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(98, 73).mirror().addBox(-20.0F, -1.0F, 0.0F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-15.0F, -7.0F, 0.0F, 0.0F, 0.0F, -1.3526F));
		PartDefinition cube_r8 = right_leg0.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(98, 67).mirror().addBox(-20.0F, -1.0F, -2.5F, 20.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-17.0F, -8.0F, 1.0F, 0.0F, 0.0F, -1.3526F));
		PartDefinition cube_r9 = right_leg0.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 112).mirror().addBox(-20.0F, -2.0F, 0.0F, 21.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-1.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.3927F));
		PartDefinition cube_r10 = right_leg0.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(98, 59).mirror().addBox(-20.0F, -2.0F, -2.0F, 21.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));
		PartDefinition left_leg2 = partdefinition.addOrReplaceChild("left_leg2", CubeListBuilder.create(), PartPose.offsetAndRotation(8.0F, 5.0F, 10.0F, 0.0F, -0.2618F, -0.1309F));
		PartDefinition cube_r11 = left_leg2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(70, 112).addBox(-1.0F, -8.0F, -1.0F, 5.0F, 19.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(19.0F, 13.0F, 0.0F, 0.0F, 0.0F, 0.1745F));
		PartDefinition cube_r12 = left_leg2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(98, 73).addBox(0.0F, -1.0F, 0.0F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(15.0F, -7.0F, 0.0F, 0.0F, 0.0F, 1.3526F));
		PartDefinition cube_r13 = left_leg2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(98, 67).addBox(0.0F, -1.0F, -0.5F, 20.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(17.0F, -8.0F, -1.0F, 0.0F, 0.0F, 1.3526F));
		PartDefinition cube_r14 = left_leg2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 112).addBox(-1.0F, -2.0F, 0.0F, 21.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 3.0F, 0.0F, 0.0F, 0.0F, -0.3927F));
		PartDefinition cube_r15 = left_leg2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(98, 59).addBox(-1.0F, -2.0F, -2.0F, 21.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));
		PartDefinition right_leg2 = partdefinition.addOrReplaceChild("right_leg2", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.0F, 5.0F, 10.0F, 0.0F, 0.2618F, 0.1309F));
		PartDefinition cube_r16 = right_leg2.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(70, 112).mirror().addBox(-4.0F, -8.0F, -1.0F, 5.0F, 19.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-19.0F, 13.0F, 0.0F, 0.0F, 0.0F, -0.1745F));
		PartDefinition cube_r17 = right_leg2.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(98, 73).mirror().addBox(-20.0F, -1.0F, 0.0F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-15.0F, -7.0F, 0.0F, 0.0F, 0.0F, -1.3526F));
		PartDefinition cube_r18 = right_leg2.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(98, 67).mirror().addBox(-20.0F, -1.0F, -0.5F, 20.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-17.0F, -8.0F, -1.0F, 0.0F, 0.0F, -1.3526F));
		PartDefinition cube_r19 = right_leg2.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 112).mirror().addBox(-20.0F, -2.0F, 0.0F, 21.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-1.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.3927F));
		PartDefinition cube_r20 = right_leg2.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(98, 59).mirror().addBox(-20.0F, -2.0F, -2.0F, 21.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));
		PartDefinition left_leg1 = partdefinition.addOrReplaceChild("left_leg1", CubeListBuilder.create(), PartPose.offsetAndRotation(8.0F, 5.0F, 4.0F, 0.0F, 0.0F, -0.1309F));
		PartDefinition cube_r21 = left_leg1.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(70, 112).addBox(-1.0F, -8.0F, -1.0F, 5.0F, 19.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(19.0F, 13.0F, 0.0F, 0.0F, 0.0F, 0.1745F));
		PartDefinition cube_r22 = left_leg1.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(98, 73).addBox(0.0F, -1.0F, 0.0F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(15.0F, -7.0F, 0.0F, 0.0F, 0.0F, 1.3526F));
		PartDefinition cube_r23 = left_leg1.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(98, 67).addBox(0.0F, -1.0F, -2.5F, 20.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(17.0F, -8.0F, 1.0F, 0.0F, 0.0F, 1.3526F));
		PartDefinition cube_r24 = left_leg1.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(0, 112).addBox(-1.0F, -2.0F, 0.0F, 21.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 3.0F, 0.0F, 0.0F, 0.0F, -0.3927F));
		PartDefinition cube_r25 = left_leg1.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(98, 59).addBox(-1.0F, -2.0F, -2.0F, 21.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));
		PartDefinition right_leg1 = partdefinition.addOrReplaceChild("right_leg1", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.0F, 5.0F, 4.0F, 0.0F, 0.0F, 0.1309F));
		PartDefinition cube_r26 = right_leg1.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(70, 112).mirror().addBox(-4.0F, -8.0F, -1.0F, 5.0F, 19.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-19.0F, 13.0F, 0.0F, 0.0F, 0.0F, -0.1745F));
		PartDefinition cube_r27 = right_leg1.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(98, 73).mirror().addBox(-20.0F, -1.0F, 0.0F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-15.0F, -7.0F, 0.0F, 0.0F, 0.0F, -1.3526F));
		PartDefinition cube_r28 = right_leg1.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(98, 67).mirror().addBox(-20.0F, -1.0F, -2.5F, 20.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-17.0F, -8.0F, 1.0F, 0.0F, 0.0F, -1.3526F));
		PartDefinition cube_r29 = right_leg1.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(0, 112).mirror().addBox(-20.0F, -2.0F, 0.0F, 21.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-1.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.3927F));
		PartDefinition cube_r30 = right_leg1.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(98, 59).mirror().addBox(-20.0F, -2.0F, -2.0F, 21.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));
		return LayerDefinition.create(meshdefinition, 256, 256);
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
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.right_leg1.zRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.right_leg2.zRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.right_leg0.zRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.left_leg0.zRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.left_leg1.zRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.left_leg2.zRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}
