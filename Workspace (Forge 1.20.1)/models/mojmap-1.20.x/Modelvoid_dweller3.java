// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelvoid_dweller3<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "void_dweller3"), "main");
	private final ModelPart left_leg;
	private final ModelPart right_leg;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart right_arm;

	public Modelvoid_dweller3(ModelPart root) {
		this.left_leg = root.getChild("left_leg");
		this.right_leg = root.getChild("right_leg");
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.right_arm = root.getChild("right_arm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(12, 23)
				.addBox(-1.0F, 0.0F, -1.0F, 3.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(2.0F, 8.0F, -1.0F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 17)
				.addBox(-2.0F, 0.0F, -1.0F, 3.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-2.0F, 8.0F, -1.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(
				-4.0F, 0.0F, -1.0F, 8.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, -1.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(16, 11)
						.addBox(-3.0F, -8.0F, -2.5F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(52, 58)
						.addBox(-3.0F, -2.0F, -2.5F, 6.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(52, 62)
						.addBox(-3.0F, -2.0F, 3.5F, 6.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(52, 48)
						.addBox(-3.0F, -2.0F, -2.5F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(52, 43)
						.addBox(3.0F, -2.0F, -2.5F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -6.0F, -1.0F));

		PartDefinition cube_r1 = head
				.addOrReplaceChild("cube_r1",
						CubeListBuilder.create().texOffs(52, 0).addBox(-1.5F, -5.0F, -1.0F, 1.0F, 7.0F, 1.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(-1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r2 = head
				.addOrReplaceChild("cube_r2",
						CubeListBuilder.create().texOffs(60, 0).addBox(0.5F, -5.0F, -1.0F, 1.0F, 7.0F, 1.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(1.0F, 0.0F, 1.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm",
				CubeListBuilder.create().texOffs(34, 0)
						.addBox(-2.5F, 5.0F, -9.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 34)
						.addBox(-1.5F, 6.0F, -7.0F, 0.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-4.0F, -4.0F, -1.0F));

		PartDefinition cube_r3 = right_arm
				.addOrReplaceChild("cube_r3",
						CubeListBuilder.create().texOffs(30, 0).addBox(-6.0F, 1.8284F, -15.1421F, 1.0F, 8.0F, 1.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(4.0F, 4.0F, 1.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r4 = right_arm
				.addOrReplaceChild("cube_r4",
						CubeListBuilder.create().texOffs(24, 23).addBox(-7.0F, -2.7685F, -5.0675F, 3.0F, 12.0F, 3.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(4.0F, 4.0F, 1.0F, -1.0036F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}