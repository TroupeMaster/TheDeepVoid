// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelthe_nightmare<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "the_nightmare"), "main");
	private final ModelPart left_leg;
	private final ModelPart right_leg;
	private final ModelPart body;
	private final ModelPart right_arm;
	private final ModelPart left_arm;
	private final ModelPart head;

	public Modelthe_nightmare(ModelPart root) {
		this.left_leg = root.getChild("left_leg");
		this.right_leg = root.getChild("right_leg");
		this.body = root.getChild("body");
		this.right_arm = root.getChild("right_arm");
		this.left_arm = root.getChild("left_arm");
		this.head = root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(),
				PartPose.offset(3.0F, 3.0F, 1.0F));

		PartDefinition cube_r1 = left_leg.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(60, 26).addBox(1.0F, -21.0F, -2.0F, 5.0F, 21.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, 21.0F, -1.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(),
				PartPose.offset(-3.0F, 3.0F, 1.0F));

		PartDefinition cube_r2 = right_leg.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(49, 0).addBox(-16.0F, -21.0F, -2.0F, 5.0F, 21.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-7.0F, 21.0F, -1.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(),
				PartPose.offset(0.0F, -15.0F, 1.0F));

		PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(20, 34)
						.addBox(0.0F, -38.0F, -13.0F, 0.0F, 23.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-6.0F, -33.0F, -3.0F, 12.0F, 18.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 34.0F, -1.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(),
				PartPose.offset(6.0F, -13.0F, 1.0F));

		PartDefinition cube_r4 = right_arm.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(60, 52).addBox(11.0F, -9.0F, 0.0F, 5.0F, 11.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-6.0F, 26.0F, -1.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r5 = right_arm.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(0, 60)
						.addBox(8.0F, -22.0F, -7.0F, 0.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(10, 60)
						.addBox(8.0F, -33.0F, 3.0F, 0.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 25)
						.addBox(6.0F, -33.0F, -2.0F, 5.0F, 35.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-6.0F, 32.0F, -1.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(),
				PartPose.offset(-6.0F, -13.0F, 1.0F));

		PartDefinition cube_r6 = left_arm.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(60, 63)
						.addBox(-16.0F, -33.0F, 0.0F, 5.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(38, 0)
						.addBox(-9.0F, -28.0F, -7.0F, 0.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(38, 11)
						.addBox(-9.0F, -20.0F, 3.0F, 0.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(40, 44)
						.addBox(-11.0F, -33.0F, -2.0F, 5.0F, 22.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(6.0F, 32.0F, -1.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(),
				PartPose.offset(0.0F, -15.0F, 1.0F));

		PartDefinition cube_r7 = head.addOrReplaceChild("cube_r7",
				CubeListBuilder.create().texOffs(20, 25).addBox(-5.0F, -43.0F, -4.0F, 10.0F, 10.0F, 9.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 34.0F, -1.0F, -3.1416F, 0.0F, 3.1416F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
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