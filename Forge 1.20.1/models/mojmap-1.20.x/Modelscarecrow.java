// Made with Blockbench 4.12.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelscarecrow<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "scarecrow"), "main");
	private final ModelPart left_leg;
	private final ModelPart right_leg;
	private final ModelPart left_arm;
	private final ModelPart right_arm;
	private final ModelPart body;
	private final ModelPart head;

	public Modelscarecrow(ModelPart root) {
		this.left_leg = root.getChild("left_leg");
		this.right_leg = root.getChild("right_leg");
		this.left_arm = root.getChild("left_arm");
		this.right_arm = root.getChild("right_arm");
		this.body = root.getChild("body");
		this.head = root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg",
				CubeListBuilder.create().texOffs(62, 73)
						.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 24.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 65)
						.addBox(0.0F, 0.0F, -8.0F, 0.0F, 24.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(14, 65)
						.addBox(0.0F, 0.0F, 1.0F, 0.0F, 24.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offset(2.0F, 0.0F, 0.0F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg",
				CubeListBuilder.create().texOffs(62, 73).mirror()
						.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 24.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(0, 65).mirror().addBox(0.0F, 0.0F, -8.0F, 0.0F, 24.0F, 7.0F, new CubeDeformation(0.0F))
						.mirror(false).texOffs(14, 65).mirror()
						.addBox(0.0F, 0.0F, 1.0F, 0.0F, 24.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-2.0F, 0.0F, 0.0F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm",
				CubeListBuilder.create().texOffs(70, 73)
						.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 24.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(60, 0)
						.addBox(0.0F, 0.0F, -8.0F, 0.0F, 35.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(0.0F, 0.0F, 1.0F, 0.0F, 35.0F, 30.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.0F, -20.0F, -6.0F, 0.0F, -1.5708F, -1.5708F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm",
				CubeListBuilder.create().texOffs(70, 73).mirror()
						.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 24.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(60, 0).mirror().addBox(0.0F, 0.0F, -8.0F, 0.0F, 35.0F, 9.0F, new CubeDeformation(0.0F))
						.mirror(false).texOffs(0, 0).mirror()
						.addBox(0.0F, 0.0F, 1.0F, 0.0F, 35.0F, 30.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-2.0F, -20.0F, -6.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(60, 44)
						.addBox(-4.0F, -25.0F, -2.0F, 8.0F, 25.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(78, 0)
						.addBox(4.0F, -19.0F, 0.0F, 4.0F, 19.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(78, 19)
						.addBox(-8.0F, -19.0F, 0.0F, 4.0F, 19.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(50, 73)
						.addBox(0.0F, -25.0F, 2.0F, 0.0F, 25.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.2608F, -0.0226F, 0.0843F));

		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(28, 65)
						.addBox(-3.0F, -17.0F, -2.0F, 7.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(78, 73)
						.addBox(1.0F, -17.0F, 2.0F, 0.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(2.0F, -23.0F, -7.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}