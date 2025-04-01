// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelstalker_new<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "stalker_new"), "main");
	private final ModelPart left_leg;
	private final ModelPart right_leg;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart right_arm;
	private final ModelPart left_arm;

	public Modelstalker_new(ModelPart root) {
		this.left_leg = root.getChild("left_leg");
		this.right_leg = root.getChild("right_leg");
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.right_arm = root.getChild("right_arm");
		this.left_arm = root.getChild("left_arm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(),
				PartPose.offset(2.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = left_leg.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(0, 41).addBox(-1.0F, -9.6825F, 4.8987F, 2.0F, 11.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 10.0F, -3.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r2 = left_leg.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(10, 28).addBox(-1.0F, -15.0F, -1.0F, 2.0F, 16.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(),
				PartPose.offset(-2.0F, 0.0F, 0.0F));

		PartDefinition cube_r3 = right_leg.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(40, 30).addBox(-1.0F, -9.6825F, 4.8987F, 2.0F, 11.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 10.0F, -3.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r4 = right_leg.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(24, 18).addBox(-1.0F, -15.0F, -1.0F, 2.0F, 16.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(),
				PartPose.offset(0.0F, -13.0F, -2.0F));

		PartDefinition cube_r5 = body.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(22, 0).addBox(0.0F, -6.7439F, -5.0723F, 0.0F, 13.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0F, 7.0F, 0.0F, 0.212F, 0.6003F, 0.121F));

		PartDefinition cube_r6 = body.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(0, 23).addBox(0.0F, -6.7439F, -5.0723F, 0.0F, 13.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0F, 7.0F, 0.0F, 0.212F, -0.6003F, -0.121F));

		PartDefinition cube_r7 = body
				.addOrReplaceChild("cube_r7",
						CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -13.0F, -1.0F, 8.0F, 13.0F, 3.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 13.0F, 2.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(),
				PartPose.offset(0.0F, -13.0F, -2.0F));

		PartDefinition cube_r8 = head.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(0, 14)
						.addBox(1.0F, -3.8502F, -3.2878F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(18, 14)
						.addBox(-1.0F, -3.8502F, -3.2878F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(26, 43)
						.addBox(-1.0F, -3.8502F, -1.2878F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 16)
						.addBox(-3.0F, -9.8502F, -5.2878F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(),
				PartPose.offset(-4.0F, -12.0F, -2.0F));

		PartDefinition cube_r9 = right_arm.addOrReplaceChild("cube_r9",
				CubeListBuilder.create().texOffs(0, 48).addBox(0.0F, -5.0F, -9.0F, 0.0F, 5.0F, 11.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 5.0F, -12.0F, 1.0036F, 0.0F, 0.0F));

		PartDefinition cube_r10 = right_arm.addOrReplaceChild("cube_r10",
				CubeListBuilder.create().texOffs(32, 13)
						.addBox(0.0F, 0.1235F, 0.8362F, 0.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(40, 0)
						.addBox(-1.0F, 0.1235F, -1.1638F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 12.0F, -1.0F, -2.138F, 0.0F, 0.0F));

		PartDefinition cube_r11 = right_arm
				.addOrReplaceChild("cube_r11",
						CubeListBuilder.create().texOffs(40, 15).addBox(-2.0F, -0.835F, -1.1142F, 2.0F, 13.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(),
				PartPose.offset(4.0F, -12.0F, -2.0F));

		PartDefinition cube_r12 = left_arm.addOrReplaceChild("cube_r12",
				CubeListBuilder.create().texOffs(42, 48).addBox(0.0F, -5.0F, -9.0F, 0.0F, 5.0F, 11.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 5.0F, -12.0F, 0.9599F, 0.0F, 0.0F));

		PartDefinition cube_r13 = left_arm.addOrReplaceChild("cube_r13",
				CubeListBuilder.create().texOffs(32, 0)
						.addBox(0.0F, 0.1235F, 0.8362F, 0.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(32, 30)
						.addBox(-1.0F, 0.1235F, -1.1638F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 12.0F, -1.0F, -2.138F, 0.0F, 0.0F));

		PartDefinition cube_r14 = left_arm
				.addOrReplaceChild("cube_r14",
						CubeListBuilder.create().texOffs(18, 34).addBox(-2.0F, -0.835F, -1.1142F, 2.0F, 13.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

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
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}