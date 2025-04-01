// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelbone_crawler_remodeled<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "bone_crawler_remodeled"), "main");
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart left_leg0;
	private final ModelPart left_leg2;
	private final ModelPart right_leg0;
	private final ModelPart right_leg2;
	private final ModelPart left_leg1;
	private final ModelPart right_leg1;

	public Modelbone_crawler_remodeled(ModelPart root) {
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.left_leg0 = root.getChild("left_leg0");
		this.left_leg2 = root.getChild("left_leg2");
		this.right_leg0 = root.getChild("right_leg0");
		this.right_leg2 = root.getChild("right_leg2");
		this.left_leg1 = root.getChild("left_leg1");
		this.right_leg1 = root.getChild("right_leg1");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 19)
						.addBox(-5.0F, -3.0F, 0.0F, 10.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)).texOffs(10, 0)
						.addBox(-5.0F, -3.1F, 2.0F, 5.0F, 0.0F, 19.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(0.0F, -3.1F, 2.0F, 5.0F, 0.0F, 19.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 22.0F, -6.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(34, 13)
						.addBox(-4.0F, -2.0F, -6.0F, 8.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(16, 44)
						.addBox(-3.0F, -2.5F, -11.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(1.0F, -2.5F, -11.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 22.0F, -6.0F));

		PartDefinition left_leg0 = partdefinition.addOrReplaceChild("left_leg0",
				CubeListBuilder.create().texOffs(0, 44).addBox(-8.0F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, 21.0F, -3.0F, -0.3876F, -0.3614F, 0.8571F));

		PartDefinition cube_r1 = left_leg0.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(39, 0).addBox(-12.0F, -1.0F, 0.0F, 13.0F, 3.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition left_leg2 = partdefinition.addOrReplaceChild("left_leg2",
				CubeListBuilder.create().texOffs(0, 44).addBox(-8.0F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, 21.0F, 3.0F, 0.3876F, 0.3614F, 0.8571F));

		PartDefinition cube_r2 = left_leg2.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(39, 0).addBox(-12.0F, -1.0F, 0.0F, 13.0F, 3.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition right_leg0 = partdefinition.addOrReplaceChild("right_leg0",
				CubeListBuilder.create().texOffs(0, 40).addBox(-1.0F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.0F, 21.0F, -3.0F, -0.3876F, 0.3614F, -0.8571F));

		PartDefinition cube_r3 = right_leg0
				.addOrReplaceChild("cube_r3",
						CubeListBuilder.create().texOffs(34, 28).addBox(-1.0F, -1.0F, 0.0F, 13.0F, 3.0F, 0.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition right_leg2 = partdefinition.addOrReplaceChild("right_leg2",
				CubeListBuilder.create().texOffs(0, 40).addBox(-1.0F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.0F, 21.0F, 3.0F, 0.3876F, -0.3614F, -0.8571F));

		PartDefinition cube_r4 = right_leg2
				.addOrReplaceChild("cube_r4",
						CubeListBuilder.create().texOffs(34, 28).addBox(-1.0F, -1.0F, 0.0F, 13.0F, 3.0F, 0.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition left_leg1 = partdefinition.addOrReplaceChild("left_leg1",
				CubeListBuilder.create().texOffs(42, 42).addBox(-8.0F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, 21.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r5 = left_leg1.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(26, 37).addBox(-12.0F, -1.0F, 0.0F, 13.0F, 3.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition right_leg1 = partdefinition.addOrReplaceChild("right_leg1",
				CubeListBuilder.create().texOffs(39, 3).addBox(-1.0F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.0F, 21.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r6 = right_leg1
				.addOrReplaceChild("cube_r6",
						CubeListBuilder.create().texOffs(34, 22).addBox(-1.0F, -1.0F, 0.0F, 13.0F, 3.0F, 0.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg0.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg0.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.right_leg1.yRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.right_leg2.yRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.right_leg0.yRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.left_leg0.yRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.left_leg1.yRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.left_leg2.yRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}