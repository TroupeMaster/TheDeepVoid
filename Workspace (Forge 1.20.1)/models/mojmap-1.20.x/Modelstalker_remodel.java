// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelstalker_remodel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "stalker_remodel"), "main");
	private final ModelPart left_leg;
	private final ModelPart right_leg;
	private final ModelPart body;
	private final ModelPart left_arm;
	private final ModelPart right_arm;
	private final ModelPart head;

	public Modelstalker_remodel(ModelPart root) {
		this.left_leg = root.getChild("left_leg");
		this.right_leg = root.getChild("right_leg");
		this.body = root.getChild("body");
		this.left_arm = root.getChild("left_arm");
		this.right_arm = root.getChild("right_arm");
		this.head = root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 75)
				.addBox(0.0F, 19.0F, -6.0F, 0.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offset(2.0F, -2.0F, 0.0F));

		PartDefinition cube_r1 = left_leg
				.addOrReplaceChild("cube_r1",
						CubeListBuilder.create().texOffs(76, 81).addBox(0.0F, -12.05F, -0.18F, 0.0F, 12.0F, 4.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 11.0F, 4.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r2 = left_leg
				.addOrReplaceChild("cube_r2",
						CubeListBuilder.create().texOffs(84, 80).addBox(-1.0F, -12.05F, -0.18F, 2.0F, 12.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 11.0F, 2.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r3 = left_leg.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(80, 28).addBox(-1.0F, -16.0F, -1.025F, 2.0F, 16.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 26.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create()
				.texOffs(68, 66).addBox(0.0F, 19.0F, -6.0F, 0.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-2.0F, -2.0F, 0.0F));

		PartDefinition cube_r4 = right_leg
				.addOrReplaceChild("cube_r4",
						CubeListBuilder.create().texOffs(68, 81).addBox(0.0F, -12.05F, -0.18F, 0.0F, 12.0F, 4.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 11.0F, 4.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r5 = right_leg
				.addOrReplaceChild("cube_r5",
						CubeListBuilder.create().texOffs(54, 85).addBox(-1.0F, -12.05F, -0.18F, 2.0F, 12.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 11.0F, 2.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r6 = right_leg.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(80, 46).addBox(-1.0F, -16.0F, -1.025F, 2.0F, 16.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 26.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(56, 28)
						.addBox(-3.5F, -13.0F, -1.4F, 7.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(58, 68)
						.addBox(0.0F, -13.0F, 1.6F, 0.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r7 = body.addOrReplaceChild("cube_r7",
				CubeListBuilder.create().texOffs(44, 75).addBox(0.0F, -7.0F, -5.0F, 0.0F, 13.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.5F, -6.0F, -1.4F, 0.0F, 0.5934F, 0.0F));

		PartDefinition cube_r8 = body.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(34, 75).addBox(0.0F, -7.0F, -5.0F, 0.0F, 13.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.5F, -6.0F, -1.4F, 0.0F, -0.5934F, 0.0F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(),
				PartPose.offsetAndRotation(4.0F, -12.0F, -2.0F, 0.0F, -0.0873F, 0.0F));

		PartDefinition cube_r9 = left_arm.addOrReplaceChild("cube_r9",
				CubeListBuilder.create().texOffs(28, 0).addBox(-0.5F, -8.0F, -12.0F, 0.0F, 11.0F, 14.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 11.0F, -10.0F, 0.1135F, -0.0653F, 0.5199F));

		PartDefinition cube_r10 = left_arm.addOrReplaceChild("cube_r10",
				CubeListBuilder.create().texOffs(0, 25).addBox(0.5F, -8.0F, -12.0F, 0.0F, 11.0F, 14.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 11.0F, -10.0F, 0.1135F, 0.0653F, -0.5199F));

		PartDefinition cube_r11 = left_arm.addOrReplaceChild("cube_r11",
				CubeListBuilder.create().texOffs(0, 0).addBox(0.5F, -8.0F, -12.0F, 0.0F, 11.0F, 14.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 11.0F, -10.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition cube_r12 = left_arm.addOrReplaceChild("cube_r12",
				CubeListBuilder.create().texOffs(42, -8).addBox(0.0F, -1.0F, -12.08F, 0.0F, 3.0F, 12.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5F, 14.0F, -1.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r13 = left_arm.addOrReplaceChild("cube_r13",
				CubeListBuilder.create().texOffs(56, 0).addBox(-1.0F, -1.0F, -12.08F, 2.0F, 2.0F, 12.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5F, 12.0F, -1.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r14 = left_arm
				.addOrReplaceChild("cube_r14",
						CubeListBuilder.create().texOffs(14, 75).addBox(0.5F, -1.0F, -1.0F, 0.0F, 14.0F, 5.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r15 = left_arm
				.addOrReplaceChild("cube_r15",
						CubeListBuilder.create().texOffs(82, 64).addBox(-0.5F, -1.0F, -1.0F, 2.0F, 14.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-4.0F, -12.0F, -2.0F, 0.0F, 0.0873F, 0.0F));

		PartDefinition cube_r16 = right_arm.addOrReplaceChild("cube_r16",
				CubeListBuilder.create().texOffs(28, 50).addBox(0.5F, -8.0F, -12.0F, 0.0F, 11.0F, 14.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 11.0F, -10.0F, 0.1135F, 0.0653F, -0.5199F));

		PartDefinition cube_r17 = right_arm.addOrReplaceChild("cube_r17",
				CubeListBuilder.create().texOffs(0, 50).addBox(-0.5F, -8.0F, -12.0F, 0.0F, 11.0F, 14.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 11.0F, -10.0F, 0.1135F, -0.0653F, 0.5199F));

		PartDefinition cube_r18 = right_arm.addOrReplaceChild("cube_r18",
				CubeListBuilder.create().texOffs(28, 25).addBox(-0.5F, -8.0F, -12.0F, 0.0F, 11.0F, 14.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 11.0F, -10.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition cube_r19 = right_arm.addOrReplaceChild("cube_r19",
				CubeListBuilder.create().texOffs(42, -12).addBox(0.0F, -1.0F, -12.08F, 0.0F, 3.0F, 12.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, 14.0F, -1.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r20 = right_arm.addOrReplaceChild("cube_r20",
				CubeListBuilder.create().texOffs(56, 14).addBox(-1.0F, -1.0F, -12.08F, 2.0F, 2.0F, 12.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, 12.0F, -1.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r21 = right_arm
				.addOrReplaceChild("cube_r21",
						CubeListBuilder.create().texOffs(24, 75).addBox(-0.5F, -1.0F, -1.0F, 0.0F, 14.0F, 5.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r22 = right_arm
				.addOrReplaceChild("cube_r22",
						CubeListBuilder.create().texOffs(84, 0).addBox(-1.5F, -1.0F, -1.0F, 2.0F, 14.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(),
				PartPose.offset(0.0F, -14.0F, -3.0F));

		PartDefinition cube_r23 = head.addOrReplaceChild("cube_r23",
				CubeListBuilder.create().texOffs(56, 56).addBox(-3.0F, 0.7F, -5.42F, 6.0F, 4.0F, 6.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -5.0F, -2.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r24 = head
				.addOrReplaceChild("cube_r24",
						CubeListBuilder.create().texOffs(56, 44).addBox(-3.0F, -7.15F, -6.65F, 6.0F, 6.0F, 6.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r25 = head.addOrReplaceChild("cube_r25",
				CubeListBuilder.create().texOffs(84, 16)
						.addBox(0.0F, -6.0F, 1.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(88, 34)
						.addBox(1.0F, -6.0F, -4.0F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(62, 85)
						.addBox(-1.0F, -6.0F, -4.0F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(88, 26)
						.addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.0F, 1.0F, 0.5236F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
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