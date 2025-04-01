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

// Made with Blockbench 4.12.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelamalgam_rework<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("the_deep_void", "modelamalgam_rework"), "main");
	public final ModelPart body;
	public final ModelPart left_leg_front;
	public final ModelPart bone;
	public final ModelPart bone2;
	public final ModelPart right_leg_front;
	public final ModelPart bone7;
	public final ModelPart bone8;
	public final ModelPart right_leg_back;
	public final ModelPart bone9;
	public final ModelPart bone10;
	public final ModelPart left_leg_back;
	public final ModelPart bone5;
	public final ModelPart bone6;
	public final ModelPart left_arm;
	public final ModelPart bone3;
	public final ModelPart bone4;
	public final ModelPart right_arm;
	public final ModelPart bone11;
	public final ModelPart bone12;

	public Modelamalgam_rework(ModelPart root) {
		this.body = root.getChild("body");
		this.left_leg_front = root.getChild("left_leg_front");
		this.bone = this.left_leg_front.getChild("bone");
		this.bone2 = this.bone.getChild("bone2");
		this.right_leg_front = root.getChild("right_leg_front");
		this.bone7 = this.right_leg_front.getChild("bone7");
		this.bone8 = this.bone7.getChild("bone8");
		this.right_leg_back = root.getChild("right_leg_back");
		this.bone9 = this.right_leg_back.getChild("bone9");
		this.bone10 = this.bone9.getChild("bone10");
		this.left_leg_back = root.getChild("left_leg_back");
		this.bone5 = this.left_leg_back.getChild("bone5");
		this.bone6 = this.bone5.getChild("bone6");
		this.left_arm = root.getChild("left_arm");
		this.bone3 = this.left_arm.getChild("bone3");
		this.bone4 = this.bone3.getChild("bone4");
		this.right_arm = root.getChild("right_arm");
		this.bone11 = this.right_arm.getChild("bone11");
		this.bone12 = this.bone11.getChild("bone12");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 0).addBox(-16.0F, -31.0F, -16.0F, 32.0F, 32.0F, 32.0F, new CubeDeformation(0.0F)).texOffs(0, 64).addBox(-16.0F, 1.0F, -16.0F, 32.0F, 19.0F, 32.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -3.0F, 0.0F));
		PartDefinition left_leg_front = partdefinition.addOrReplaceChild("left_leg_front", CubeListBuilder.create().texOffs(0, 115).addBox(-6.0F, -2.0F, -6.0F, 12.0F, 25.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-13.0F, -27.0F, -6.0F, -0.552F, 0.3144F, 1.9151F));
		PartDefinition bone = left_leg_front.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(48, 115).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 45.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(128, 0).addBox(4.0F, -1.0F, 0.0F, 16.0F, 45.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 19.0F, 0.0F, 0.1745F, 0.0F, -1.309F));
		PartDefinition bone2 = bone.addOrReplaceChild("bone2",
				CubeListBuilder.create().texOffs(0, 152).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 30.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(128, 117).addBox(2.0F, -1.0F, 0.0F, 18.0F, 30.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 43.0F, 0.0F, 0.0F, 0.1745F, -0.7418F));
		PartDefinition right_leg_front = partdefinition.addOrReplaceChild("right_leg_front", CubeListBuilder.create().texOffs(0, 115).mirror().addBox(-6.0F, -2.0F, -6.0F, 12.0F, 25.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(13.0F, -27.0F, -6.0F, -0.552F, -0.3144F, -1.9151F));
		PartDefinition bone7 = right_leg_front.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(48, 115).mirror().addBox(-4.0F, -1.0F, -4.0F, 8.0F, 45.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(128, 0).mirror()
				.addBox(-20.0F, -1.0F, 0.0F, 16.0F, 45.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 19.0F, 0.0F, 0.1745F, 0.0F, 1.309F));
		PartDefinition bone8 = bone7.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(0, 152).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 30.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(128, 117).mirror()
				.addBox(-20.0F, -1.0F, 0.0F, 18.0F, 30.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 43.0F, 0.0F, 0.0F, -0.1745F, 0.7418F));
		PartDefinition right_leg_back = partdefinition.addOrReplaceChild("right_leg_back", CubeListBuilder.create().texOffs(0, 115).mirror().addBox(-6.0F, -2.0F, -6.0F, 12.0F, 25.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(13.0F, -27.0F, 6.0F, 0.552F, 0.3144F, -1.9151F));
		PartDefinition bone9 = right_leg_back.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(48, 115).mirror().addBox(-4.0F, -1.0F, -4.0F, 8.0F, 45.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(128, 0).mirror()
				.addBox(-20.0F, -1.0F, 0.0F, 16.0F, 45.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 19.0F, 0.0F, -0.1745F, 0.0F, 1.309F));
		PartDefinition bone10 = bone9.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(0, 152).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 30.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(128, 117).mirror()
				.addBox(-20.0F, -1.0F, 0.0F, 18.0F, 30.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 43.0F, 0.0F, 0.0F, 0.1745F, 0.7418F));
		PartDefinition left_leg_back = partdefinition.addOrReplaceChild("left_leg_back", CubeListBuilder.create().texOffs(0, 115).addBox(-6.0F, -2.0F, -6.0F, 12.0F, 25.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-13.0F, -27.0F, 6.0F, 0.552F, -0.3144F, 1.9151F));
		PartDefinition bone5 = left_leg_back.addOrReplaceChild("bone5",
				CubeListBuilder.create().texOffs(48, 115).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 45.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(128, 0).addBox(4.0F, -1.0F, 0.0F, 16.0F, 45.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 19.0F, 0.0F, -0.1745F, 0.0F, -1.309F));
		PartDefinition bone6 = bone5.addOrReplaceChild("bone6",
				CubeListBuilder.create().texOffs(0, 152).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 30.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(128, 117).addBox(2.0F, -1.0F, 0.0F, 18.0F, 30.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 43.0F, 0.0F, 0.0F, -0.1745F, -0.7418F));
		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(80, 115).addBox(-6.0F, -2.0F, -6.0F, 12.0F, 25.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-11.0F, -12.0F, 8.0F, -1.2841F, 0.5619F, 0.0731F));
		PartDefinition bone3 = left_arm.addOrReplaceChild("bone3",
				CubeListBuilder.create().texOffs(128, 45).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 34.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(128, 147).addBox(4.0F, -1.0F, 0.0F, 16.0F, 34.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 22.0F, 0.0F, -0.1309F, 0.0F, -0.2182F));
		PartDefinition bone4 = bone3.addOrReplaceChild("bone4",
				CubeListBuilder.create().texOffs(16, 152).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 23.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(128, 87).addBox(-2.0F, -1.0F, 0.0F, 22.0F, 30.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 33.0F, 0.0F, -0.0436F, 0.0F, -0.2182F));
		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(80, 115).mirror().addBox(-6.0F, -2.0F, -6.0F, 12.0F, 25.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(11.0F, -12.0F, 8.0F, -1.2841F, -0.5619F, -0.0731F));
		PartDefinition bone11 = right_arm.addOrReplaceChild("bone11", CubeListBuilder.create().texOffs(128, 45).mirror().addBox(-4.0F, -1.0F, -4.0F, 8.0F, 34.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(128, 147).mirror()
				.addBox(-20.0F, -1.0F, 0.0F, 16.0F, 34.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 22.0F, 0.0F, -0.1309F, 0.0F, 0.2182F));
		PartDefinition bone12 = bone11.addOrReplaceChild("bone12", CubeListBuilder.create().texOffs(16, 152).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 23.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(128, 87).mirror()
				.addBox(-20.0F, -1.0F, 0.0F, 22.0F, 30.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 33.0F, 0.0F, -0.0436F, 0.0F, 0.2182F));
		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg_front.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg_front.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg_back.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg_back.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.right_leg_back.yRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.right_leg_front.yRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.left_leg_front.yRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.left_leg_back.yRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
	}
}
