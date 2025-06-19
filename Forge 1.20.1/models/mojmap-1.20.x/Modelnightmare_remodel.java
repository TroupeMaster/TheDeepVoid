// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelnightmare_remodel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "nightmare_remodel"), "main");
	private final ModelPart left_leg;
	private final ModelPart right_leg;
	private final ModelPart body;
	private final ModelPart head1;
	private final ModelPart head2;
	private final ModelPart left_arm;
	private final ModelPart right_arm;

	public Modelnightmare_remodel(ModelPart root) {
		this.left_leg = root.getChild("left_leg");
		this.right_leg = root.getChild("right_leg");
		this.body = root.getChild("body");
		this.head1 = root.getChild("head1");
		this.head2 = root.getChild("head2");
		this.left_arm = root.getChild("left_arm");
		this.right_arm = root.getChild("right_arm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg",
				CubeListBuilder.create().texOffs(24, 44)
						.addBox(-1.5F, 0.0F, -1.5F, 4.0F, 21.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(60, 0)
						.addBox(0.5F, 0.0F, -5.5F, 0.0F, 21.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(2.0F, 3.0F, -1.0F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg",
				CubeListBuilder.create().texOffs(40, 44)
						.addBox(-2.5F, 0.0F, -1.5F, 4.0F, 21.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(64, 25)
						.addBox(-0.5F, 0.0F, 2.5F, 0.0F, 21.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-2.0F, 3.0F, -1.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 67)
						.addBox(0.0F, -3.0F, -3.0F, 6.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(12, 67)
						.addBox(-6.0F, -1.0F, -3.01F, 6.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(68, 9).addBox(1.0F, -15.0F, -0.6F, 4.0F, 7.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-6.0F, 0.0F, 0.0F, 0.3054F, 0.0F, 0.0436F));

		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(0, 49).addBox(-2.0F, -14.0F, -2.6F, 7.0F, 14.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.3054F, 0.0F, 0.0436F));

		PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(68, 0).addBox(-6.0F, -14.0F, -1.0F, 7.0F, 9.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(6.0F, -2.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(64, 50)
						.addBox(-1.0F, -14.0F, -3.0F, 0.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 30)
						.addBox(-5.0F, -14.0F, -8.0F, 7.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, -1.0F, 5.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition head1 = partdefinition.addOrReplaceChild("head1", CubeListBuilder.create(),
				PartPose.offset(-5.0F, -10.0F, -1.0F));

		PartDefinition cube_r5 = head1.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(24, 30).addBox(-4.0F, -7.0F, -4.0F, 7.0F, 7.0F, 7.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.0F, 1.0F, 0.1747F, -0.043F, -0.0076F));

		PartDefinition head2 = partdefinition.addOrReplaceChild("head2", CubeListBuilder.create(),
				PartPose.offset(3.0F, -10.0F, -6.0F));

		PartDefinition cube_r6 = head2.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(32, 14).addBox(-3.0F, -7.0F, -4.0F, 7.0F, 7.0F, 7.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.0F, 1.0F, 0.2657F, 0.1685F, 0.0456F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-0.6F, -2.0F, -2.0F, 4.0F, 26.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(56, 28)
						.addBox(3.4F, -2.0F, 0.0F, 4.0F, 26.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(7.0F, -7.0F, -4.0F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm",
				CubeListBuilder.create().texOffs(16, 0)
						.addBox(-3.4F, -2.0F, -2.0F, 4.0F, 26.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(56, 54)
						.addBox(-7.4F, -2.0F, 0.0F, 4.0F, 26.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-8.0F, -7.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.head1.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head1.xRot = headPitch / (180F / (float) Math.PI);
		this.head2.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head2.xRot = headPitch / (180F / (float) Math.PI);
	}
}