// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelonlooker<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "onlooker"), "main");
	private final ModelPart left_leg;
	private final ModelPart right_leg;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart left_arm;
	private final ModelPart right_arm;

	public Modelonlooker(ModelPart root) {
		this.left_leg = root.getChild("left_leg");
		this.right_leg = root.getChild("right_leg");
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.left_arm = root.getChild("left_arm");
		this.right_arm = root.getChild("right_arm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(),
				PartPose.offset(4.0F, -20.0F, 1.0F));

		PartDefinition cube_r1 = left_leg.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(84, 0).addBox(-1.5F, -19.0F, -2.0F, 5.0F, 19.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 14.0F, -8.0F, -0.48F, 0.0F, 0.0F));

		PartDefinition cube_r2 = left_leg.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(60, 54).addBox(0.0F, 1.0F, -8.9F, 0.0F, 32.0F, 10.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 13.0F, -11.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r3 = left_leg.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(16, 83).addBox(-2.0F, 1.0F, -2.0F, 4.0F, 32.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 12.0F, -8.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(),
				PartPose.offset(-4.0F, -20.0F, 1.0F));

		PartDefinition cube_r4 = right_leg.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(64, 0).addBox(0.0F, 1.0F, -8.9F, 0.0F, 32.0F, 10.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 13.0F, -11.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r5 = right_leg
				.addOrReplaceChild("cube_r5",
						CubeListBuilder.create().texOffs(88, 24).addBox(-3.5F, -19.0F, -2.0F, 5.0F, 19.0F, 5.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(1.0F, 14.0F, -8.0F, -0.48F, 0.0F, 0.0F));

		PartDefinition cube_r6 = right_leg.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(32, 83).addBox(-2.0F, 1.0F, -2.0F, 4.0F, 32.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 12.0F, -8.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(),
				PartPose.offset(0.0F, -23.0F, 3.0F));

		PartDefinition cube_r7 = body
				.addOrReplaceChild("cube_r7",
						CubeListBuilder.create().texOffs(16, 54).addBox(-6.0F, -20.0F, -3.0F, 12.0F, 23.0F, 6.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-6.0F, -10.0F, -9.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(0, 24)
						.addBox(-6.0F, 2.0F, -9.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -43.0F, -4.0F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm",
				CubeListBuilder.create().texOffs(0, 48)
						.addBox(-2.0F, -2.0F, -2.0F, 4.0F, 50.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(52, 54)
						.addBox(0.0F, -2.0F, -6.0F, 0.0F, 50.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(8.0F, -41.0F, -2.0F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm",
				CubeListBuilder.create().texOffs(48, 0)
						.addBox(-2.0F, -2.0F, -2.0F, 4.0F, 50.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(80, 42)
						.addBox(0.0F, -2.0F, -6.0F, 0.0F, 50.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-8.0F, -41.0F, -2.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
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