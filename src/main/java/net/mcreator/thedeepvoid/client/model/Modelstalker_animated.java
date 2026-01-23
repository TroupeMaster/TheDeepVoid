package net.mcreator.thedeepvoid.client.model;

import net.minecraft.world.entity.Entity;
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

// Made with Blockbench 4.12.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelstalker_animated<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("the_deep_void", "modelstalker_animated"), "main");
	public final ModelPart main;
	public final ModelPart left_leg;
	public final ModelPart lowerLegLeft;
	public final ModelPart right_leg;
	public final ModelPart lowerLegLeg;
	public final ModelPart body;
	public final ModelPart left_arm;
	public final ModelPart lowerLeftArm;
	public final ModelPart left_claw0;
	public final ModelPart left_claw1;
	public final ModelPart left_claw2;
	public final ModelPart right_arm;
	public final ModelPart lowerRightArm;
	public final ModelPart right_claw3;
	public final ModelPart right_claw4;
	public final ModelPart right_claw5;
	public final ModelPart headPart;
	public final ModelPart neck;
	public final ModelPart head;

	public Modelstalker_animated(ModelPart root) {
		this.main = root.getChild("main");
		this.left_leg = this.main.getChild("left_leg");
		this.lowerLegLeft = this.left_leg.getChild("lowerLegLeft");
		this.right_leg = this.main.getChild("right_leg");
		this.lowerLegLeg = this.right_leg.getChild("lowerLegLeg");
		this.body = this.main.getChild("body");
		this.left_arm = this.body.getChild("left_arm");
		this.lowerLeftArm = this.left_arm.getChild("lowerLeftArm");
		this.left_claw0 = this.lowerLeftArm.getChild("left_claw0");
		this.left_claw1 = this.lowerLeftArm.getChild("left_claw1");
		this.left_claw2 = this.lowerLeftArm.getChild("left_claw2");
		this.right_arm = this.body.getChild("right_arm");
		this.lowerRightArm = this.right_arm.getChild("lowerRightArm");
		this.right_claw3 = this.lowerRightArm.getChild("right_claw3");
		this.right_claw4 = this.lowerRightArm.getChild("right_claw4");
		this.right_claw5 = this.lowerRightArm.getChild("right_claw5");
		this.headPart = this.body.getChild("headPart");
		this.neck = this.headPart.getChild("neck");
		this.head = this.neck.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, 0.0F));
		PartDefinition left_leg = main.addOrReplaceChild("left_leg",
				CubeListBuilder.create().texOffs(38, 46).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 45).addBox(0.0F, 0.0F, 1.0F, 0.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(2.0F, 0.0F, 0.0F));
		PartDefinition lowerLegLeft = left_leg.addOrReplaceChild("lowerLegLeft",
				CubeListBuilder.create().texOffs(46, 46).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(48, 34).addBox(1.0F, 0.0F, -4.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(56, 22)
						.addBox(-1.0F, 0.0F, -4.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(38, 9).addBox(0.0F, 9.0F, -6.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(54, 47)
						.addBox(0.0F, 9.0F, 1.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 13.0F, 0.0F));
		PartDefinition cube_r1 = lowerLegLeft.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(38, 9).mirror().addBox(-1.0F, -4.0F, -3.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 13.0F, -3.0F, 0.0F, 0.2793F, 0.0F));
		PartDefinition cube_r2 = lowerLegLeft.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(38, 9).addBox(1.0F, -4.0F, -3.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 13.0F, -3.0F, 0.0F, -0.2793F, 0.0F));
		PartDefinition right_leg = main.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(38, 46).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 45).mirror()
				.addBox(0.0F, 0.0F, 1.0F, 0.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 0.0F, 0.0F));
		PartDefinition lowerLegLeg = right_leg.addOrReplaceChild("lowerLegLeg",
				CubeListBuilder.create().texOffs(46, 46).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(48, 34).mirror().addBox(-1.0F, 0.0F, -4.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
						.mirror(false).texOffs(56, 22).mirror().addBox(1.0F, 0.0F, -4.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(38, 9).mirror().addBox(0.0F, 9.0F, -6.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
						.mirror(false).texOffs(54, 47).mirror().addBox(0.0F, 9.0F, 1.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(0.0F, 13.0F, 0.0F));
		PartDefinition cube_r3 = lowerLegLeg.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(38, 9).addBox(1.0F, -4.0F, -3.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 13.0F, -3.0F, 0.0F, -0.2793F, 0.0F));
		PartDefinition cube_r4 = lowerLegLeg.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(38, 9).mirror().addBox(-1.0F, -4.0F, -3.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 13.0F, -3.0F, 0.0F, 0.2793F, 0.0F));
		PartDefinition body = main.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(3, 19).addBox(-3.5F, -13.0F, -1.5F, 7.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(30, 46).addBox(0.0F, -13.0F, 1.5F, 0.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(54, 4)
						.addBox(-2.5F, -11.0F, 1.5F, 0.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(54, 34).addBox(2.5F, -11.0F, 1.5F, 0.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition cube_r5 = body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(20, 46).addBox(0.0F, -6.0F, -5.0F, 0.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.5F, -7.0F, -1.5F, 0.0F, -0.5934F, 0.0F));
		PartDefinition cube_r6 = body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(10, 45).addBox(0.0F, -6.0F, -5.0F, 0.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.5F, -7.0F, -1.5F, 0.0F, 0.5934F, 0.0F));
		PartDefinition left_arm = body.addOrReplaceChild("left_arm",
				CubeListBuilder.create().texOffs(24, 22).addBox(0.0F, -1.0F, -1.0F, 14.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(24, 18).addBox(0.0F, 0.0F, -5.0F, 14.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.5F, -11.0F, 0.0F));
		PartDefinition lowerLeftArm = left_arm.addOrReplaceChild("lowerLeftArm", CubeListBuilder.create().texOffs(38, 0).addBox(0.0F, -1.0F, -1.0F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(24, 26)
				.addBox(0.0F, 1.0F, -5.0F, 12.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(24, 30).addBox(0.0F, -1.0F, -5.0F, 12.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(14.0F, 0.0F, 0.0F));
		PartDefinition left_claw0 = lowerLeftArm.addOrReplaceChild("left_claw0", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, -3.0F, 13.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(12.0F, 0.0F, 0.0F));
		PartDefinition left_claw1 = lowerLeftArm.addOrReplaceChild("left_claw1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, -3.0F, 13.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(12.0F, 0.0F, 0.0F, 0.0873F, 0.0F, -0.1745F));
		PartDefinition left_claw2 = lowerLeftArm.addOrReplaceChild("left_claw2", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, -3.0F, 13.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(12.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.1745F));
		PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(24, 22).mirror().addBox(-14.0F, -1.0F, -1.0F, 14.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(24, 18).mirror()
				.addBox(-14.0F, 0.0F, -5.0F, 14.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.5F, -11.0F, 0.0F));
		PartDefinition lowerRightArm = right_arm.addOrReplaceChild("lowerRightArm",
				CubeListBuilder.create().texOffs(38, 0).mirror().addBox(-12.0F, -1.0F, -1.0F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(24, 26).mirror()
						.addBox(-12.0F, 1.0F, -5.0F, 12.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(24, 30).mirror().addBox(-12.0F, -1.0F, -5.0F, 12.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-14.0F, 0.0F, 0.0F));
		PartDefinition right_claw3 = lowerRightArm.addOrReplaceChild("right_claw3", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-11.0F, 0.0F, -3.0F, 13.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-12.0F, 0.0F, 0.0F));
		PartDefinition right_claw4 = lowerRightArm.addOrReplaceChild("right_claw4", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-11.0F, 0.0F, -3.0F, 13.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-12.0F, 0.0F, 0.0F, 0.0873F, 0.0F, 0.1745F));
		PartDefinition right_claw5 = lowerRightArm.addOrReplaceChild("right_claw5", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-11.0F, 0.0F, -3.0F, 13.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-12.0F, 0.0F, 0.0F, -0.0873F, 0.0F, -0.1745F));
		PartDefinition headPart = body.addOrReplaceChild("headPart", CubeListBuilder.create(), PartPose.offset(0.0F, -13.0F, 0.0F));
		PartDefinition neck = headPart.addOrReplaceChild("neck",
				CubeListBuilder.create().texOffs(54, 55).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(28, 66).addBox(0.0F, -5.0F, 1.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(38, 61)
						.addBox(1.0F, -5.0F, -4.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(44, 61).addBox(-1.0F, -5.0F, -4.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(24, 34).addBox(-3.0F, -6.0F, -5.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 35)
				.addBox(-3.0F, 0.0F, -5.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(38, 4).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
