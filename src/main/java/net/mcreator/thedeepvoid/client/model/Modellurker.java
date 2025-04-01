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

// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modellurker<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("the_deep_void", "modellurker"), "main");
	public final ModelPart spine;
	public final ModelPart head;

	public Modellurker(ModelPart root) {
		this.spine = root.getChild("spine");
		this.head = root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition spine = partdefinition.addOrReplaceChild("spine",
				CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -28.0F, -2.0F, 4.0F, 31.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(16, 11).addBox(0.0F, -28.0F, 2.0F, 0.0F, 27.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 63)
						.addBox(-6.0F, -24.0F, -2.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(52, 62).addBox(-6.0F, -24.0F, -6.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(26, 62)
						.addBox(-6.0F, -20.0F, -6.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(60, 62).addBox(-6.0F, -20.0F, -2.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(34, 62)
						.addBox(-5.0F, -16.0F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(66, 14).addBox(-5.0F, -16.0F, -5.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(14, 66)
						.addBox(-5.0F, -13.0F, -5.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(60, 14).addBox(-5.0F, -13.0F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(64, 40)
						.addBox(-5.0F, -10.0F, -5.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(30, 58).addBox(-5.0F, -10.0F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(16, 4)
						.addBox(4.0F, -10.0F, -5.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(26, 40).addBox(2.0F, -10.0F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(50, 0)
						.addBox(2.0F, -13.0F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(10, 55).addBox(4.0F, -13.0F, -5.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(52, 22)
						.addBox(2.0F, -16.0F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(9, 64).addBox(4.0F, -16.0F, -5.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(44, 60)
						.addBox(4.0F, -20.0F, -6.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(12, 0).addBox(2.0F, -20.0F, -2.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(60, 52)
						.addBox(4.0F, -24.0F, -6.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(42, 30).addBox(2.0F, -24.0F, -2.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(38, 64).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));
		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(60, 0).addBox(2.0F, -13.0F, -4.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(50, 2).addBox(6.0F, -13.0F, -10.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(56, 58)
						.addBox(2.0F, -9.0F, -4.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(48, 48).addBox(6.0F, -9.0F, -10.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(58, 48)
						.addBox(2.0F, -5.0F, -4.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(38, 46).addBox(6.0F, -5.0F, -10.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(16, 58)
						.addBox(2.0F, -1.0F, -4.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(42, 22).addBox(6.0F, -1.0F, -10.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(42, 56)
						.addBox(2.0F, 3.0F, -4.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(40, 0).addBox(6.0F, 3.0F, -10.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(60, 4)
						.addBox(-8.0F, 3.0F, -4.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(52, 24).addBox(-8.0F, 3.0F, -10.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(60, 10)
						.addBox(-8.0F, -1.0F, -4.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(32, 54).addBox(-8.0F, -1.0F, -10.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(14, 62)
						.addBox(-8.0F, -5.0F, -4.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(54, 32).addBox(-8.0F, -5.0F, -10.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(62, 22)
						.addBox(-8.0F, -9.0F, -4.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(54, 40).addBox(-8.0F, -9.0F, -10.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 55)
						.addBox(-8.0F, -13.0F, -10.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(62, 26).addBox(-8.0F, -13.0F, -4.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 30)
						.addBox(0.0F, -15.0F, 0.0F, 0.0F, 20.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(26, 16).addBox(-2.0F, -15.0F, -4.0F, 4.0F, 20.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.3927F, 0.0F, 0.0F));
		PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(64, 32).addBox(-1.0F, -2.9281F, -0.5838F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -20.0F, -8.0F, 0.6109F, 0.0F, 0.0F));
		PartDefinition cube_r3 = head.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(10, 38).addBox(0.0F, -11.0397F, 2.5144F, 0.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(22, 42).addBox(-2.0F, -11.0397F, -1.4856F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -21.0F, -9.0F, 1.2217F, 0.0F, 0.0F));
		PartDefinition true_head = head.addOrReplaceChild("true_head", CubeListBuilder.create(), PartPose.offset(0.0F, -25.0F, -19.0F));
		PartDefinition cube_r4 = true_head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(36, 34).addBox(0.0F, -3.2728F, -2.737F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0F, 2.0F, 1.8366F, 0.6548F, 0.3684F));
		PartDefinition cube_r5 = true_head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(42, 10).addBox(-6.0F, -3.2728F, -2.737F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0F, 2.0F, 1.8366F, -0.6548F, -0.3684F));
		PartDefinition cube_r6 = true_head.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(16, 0).addBox(-4.0F, -7.2747F, -3.8242F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.6144F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		spine.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
	}
}
