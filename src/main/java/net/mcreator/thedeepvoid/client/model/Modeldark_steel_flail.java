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

// Made with Blockbench 5.1.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modeldark_steel_flail<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("the_deep_void", "modeldark_steel_flail"), "main");
	public final ModelPart flail;

	public Modeldark_steel_flail(ModelPart root) {
		this.flail = root.getChild("flail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition flail = partdefinition.addOrReplaceChild("flail",
				CubeListBuilder.create().texOffs(0, 40).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(80, 0).addBox(-10.0F, -10.0F, 4.0F, 20.0F, 20.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(80, 20)
						.addBox(-10.0F, -10.0F, -4.0F, 20.0F, 20.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-10.0F, -4.0F, -10.0F, 20.0F, 0.0F, 20.0F, new CubeDeformation(0.0F)).texOffs(0, 20)
						.addBox(-10.0F, 4.0F, -10.0F, 20.0F, 0.0F, 20.0F, new CubeDeformation(0.0F)).texOffs(64, 40).addBox(-4.0F, -10.0F, -10.0F, 0.0F, 20.0F, 20.0F, new CubeDeformation(0.0F)).texOffs(0, 72)
						.addBox(4.0F, -10.0F, -10.0F, 0.0F, 20.0F, 20.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 16.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		flail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
