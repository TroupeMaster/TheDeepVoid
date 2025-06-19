// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelferryman<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "ferryman"), "main");
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart left_arm;
	private final ModelPart right_arm;
	private final ModelPart lantern;

	public Modelferryman(ModelPart root) {
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.left_arm = root.getChild("left_arm");
		this.right_arm = root.getChild("right_arm");
		this.lantern = this.right_arm.getChild("lantern");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(),
				PartPose.offset(0.0F, -20.0F, -4.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(102, 42).addBox(-5.5F, -20.5F, -4.5F, 13.0F, 30.0F, 7.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 19.0F, 8.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(0, 129).addBox(-6.0F, -8.0F, -2.86F, 12.0F, 7.0F, 6.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 29.0F, 10.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition cube_r3 = body
				.addOrReplaceChild("cube_r3",
						CubeListBuilder.create().texOffs(16, 54).addBox(-6.0F, -20.0F, -3.0F, 12.0F, 23.0F, 6.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 19.0F, 7.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-6.0F, -11.0F, -9.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(90, 80)
						.addBox(-6.5F, -12.0F, -9.5F, 13.0F, 23.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(0, 24)
						.addBox(-6.0F, 1.0F, -9.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -19.0F, -4.0F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm",
				CubeListBuilder.create().texOffs(0, 48)
						.addBox(-2.0F, -2.0F, -2.0F, 4.0F, 32.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(52, 54)
						.addBox(0.0F, -2.0F, -6.0F, 0.0F, 32.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(8.0F, -18.0F, -2.0F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm",
				CubeListBuilder.create().texOffs(48, 0)
						.addBox(-2.0F, -2.0F, -2.0F, 4.0F, 32.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(80, 42)
						.addBox(0.0F, -2.0F, -6.0F, 0.0F, 32.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -18.0F, -2.0F, -1.0472F, 0.0F, 0.0F));

		PartDefinition lantern = right_arm.addOrReplaceChild("lantern",
				CubeListBuilder.create().texOffs(78, 112)
						.addBox(0.0F, 0.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(98, 121)
						.addBox(-2.0F, 4.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(103, 131)
						.addBox(0.0F, 6.0F, 3.0F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(95, 127)
						.addBox(0.0F, 6.0F, -5.0F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(138, 121)
						.addBox(3.0F, 6.0F, 0.0F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(111, 132)
						.addBox(-5.0F, 6.0F, 0.0F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(118, 129)
						.addBox(-3.0F, 6.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 28.0F, -1.0F, 1.0472F, 0.0F, 0.0F));

		PartDefinition cube_r4 = lantern
				.addOrReplaceChild("cube_r4",
						CubeListBuilder.create().texOffs(119, 116).addBox(0.0F, -4.0F, -2.0F, 0.0F, 4.0F, 4.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 142, 142);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
	}
}