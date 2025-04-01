// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelgravekeeper<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "gravekeeper"), "main");
	private final ModelPart left_leg;
	private final ModelPart left_arm;
	private final ModelPart right_arm;
	private final ModelPart right_leg;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart tiny_head1;
	private final ModelPart tiny_head2;
	private final ModelPart tiny_head3;
	private final ModelPart tiny_head4;

	public Modelgravekeeper(ModelPart root) {
		this.left_leg = root.getChild("left_leg");
		this.left_arm = root.getChild("left_arm");
		this.right_arm = root.getChild("right_arm");
		this.right_leg = root.getChild("right_leg");
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.tiny_head1 = root.getChild("tiny_head1");
		this.tiny_head2 = root.getChild("tiny_head2");
		this.tiny_head3 = root.getChild("tiny_head3");
		this.tiny_head4 = root.getChild("tiny_head4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg",
				CubeListBuilder.create().texOffs(50, 0)
						.addBox(-1.0F, 0.0F, -1.0F, 3.0F, 24.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(42, 58)
						.addBox(0.0F, 0.0F, -4.0F, 0.0F, 24.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(2.0F, 0.0F, 0.0F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm",
				CubeListBuilder.create().texOffs(12, 45)
						.addBox(0.0F, -1.0F, -1.0F, 3.0F, 24.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(22, 6)
						.addBox(1.0F, -1.0F, -5.0F, 0.0F, 28.0F, 11.0F, new CubeDeformation(0.0F)),
				PartPose.offset(5.0F, -13.0F, 2.0F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm",
				CubeListBuilder.create().texOffs(0, 45)
						.addBox(-3.0F, -1.0F, -1.0F, 3.0F, 24.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 6)
						.addBox(-1.0F, -1.0F, -5.0F, 0.0F, 28.0F, 11.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-5.0F, -13.0F, 2.0F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg",
				CubeListBuilder.create().texOffs(24, 45)
						.addBox(-2.0F, 0.0F, -1.0F, 3.0F, 24.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(36, 58)
						.addBox(0.0F, 0.0F, -4.0F, 0.0F, 24.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-2.0F, 0.0F, 0.0F));

		PartDefinition body = partdefinition
				.addOrReplaceChild("body",
						CubeListBuilder.create().texOffs(39, 40).addBox(-5.0F, -16.0F, -2.0F, 10.0F, 16.0F, 5.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(),
				PartPose.offset(0.0F, -14.0F, 1.0F));

		PartDefinition cube_r1 = head
				.addOrReplaceChild("cube_r1",
						CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -10.0F, -5.0F, 18.0F, 10.0F, 7.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition tiny_head1 = partdefinition.addOrReplaceChild("tiny_head1", CubeListBuilder.create(),
				PartPose.offset(3.0F, -9.0F, 0.0F));

		PartDefinition cube_r2 = tiny_head1.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(62, 0).addBox(-2.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 2.0F, 0.0F, 0.1309F, -0.1745F, 0.0F));

		PartDefinition tiny_head2 = partdefinition.addOrReplaceChild("tiny_head2", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-3.0F, -4.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r3 = tiny_head2.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(48, 61).addBox(-3.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 2.0F, 0.0F, 0.1309F, 0.1745F, 0.0F));

		PartDefinition tiny_head3 = partdefinition.addOrReplaceChild("tiny_head3", CubeListBuilder.create(),
				PartPose.offsetAndRotation(1.0F, -10.0F, 3.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r4 = tiny_head3.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(59, 22).addBox(-3.0F, -5.0F, -1.0F, 5.0F, 5.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 2.0F, 0.0F, -0.1309F, -0.1745F, 0.0F));

		PartDefinition tiny_head4 = partdefinition.addOrReplaceChild("tiny_head4", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-1.0F, -2.0F, 2.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r5 = tiny_head4.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(44, 27).addBox(-2.0F, -5.0F, -1.0F, 5.0F, 5.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 2.0F, 0.0F, -0.1309F, 0.1745F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tiny_head1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tiny_head2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tiny_head3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tiny_head4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.tiny_head2.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.tiny_head2.xRot = headPitch / (180F / (float) Math.PI);
		this.tiny_head1.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.tiny_head1.xRot = headPitch / (180F / (float) Math.PI);
		this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.right_arm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.tiny_head4.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.tiny_head4.xRot = headPitch / (180F / (float) Math.PI);
		this.left_arm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.tiny_head3.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.tiny_head3.xRot = headPitch / (180F / (float) Math.PI);
	}
}