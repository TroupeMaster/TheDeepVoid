// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelamalgam_newer<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "amalgam_newer"), "main");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart front_left_arm;
	private final ModelPart back_left_leg;
	private final ModelPart back_right_leg;
	private final ModelPart front_right_arm;

	public Modelamalgam_newer(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.front_left_arm = root.getChild("front_left_arm");
		this.back_left_leg = root.getChild("back_left_leg");
		this.back_right_leg = root.getChild("back_right_leg");
		this.front_right_arm = root.getChild("front_right_arm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(81, 83)
						.addBox(-12.0F, -10.0F, -24.0F, 24.0F, 10.0F, 24.0F, new CubeDeformation(0.0F)).texOffs(112, 7)
						.addBox(-12.0F, 0.0F, -24.0F, 0.0F, 10.0F, 24.0F, new CubeDeformation(0.0F)).texOffs(88, 93)
						.addBox(12.0F, 0.0F, -24.0F, 0.0F, 10.0F, 24.0F, new CubeDeformation(0.0F)).texOffs(27, 169)
						.addBox(-12.0F, 0.0F, -24.0F, 24.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(103, 4)
						.addBox(-11.0F, 14.0F, -23.0F, 22.0F, 4.0F, 23.0F, new CubeDeformation(0.0F)).texOffs(35, 123)
						.addBox(-11.0F, 0.0F, -23.0F, 22.0F, 14.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 59)
						.addBox(11.0F, 0.0F, -23.0F, 0.0F, 14.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(0, 45)
						.addBox(-11.0F, 0.0F, -23.0F, 0.0F, 14.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(135, 41)
						.addBox(-11.0F, -6.0F, -6.0F, 22.0F, 20.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(75, 169)
						.addBox(-11.0F, -6.0F, -12.0F, 1.0F, 20.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 84)
						.addBox(10.0F, -6.0F, -12.0F, 1.0F, 20.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -2.0F, -11.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(162, 138)
						.addBox(-8.0F, -6.0F, 0.0F, 16.0F, 16.0F, 40.0F, new CubeDeformation(0.0F)).texOffs(121, 174)
						.addBox(0.0F, -20.0F, 0.0F, 0.0F, 13.0F, 40.0F, new CubeDeformation(0.0F)).texOffs(189, 81)
						.addBox(-2.0F, -9.0F, 0.0F, 4.0F, 3.0F, 30.0F, new CubeDeformation(0.0F)).texOffs(18, 2)
						.addBox(-2.0F, -8.0F, 30.0F, 4.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(0, 13)
						.addBox(-2.0F, -7.0F, 37.0F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(41, 172)
						.addBox(10.0F, -8.0F, 0.0F, 0.0F, 20.0F, 40.0F, new CubeDeformation(0.0F)).texOffs(129, 154)
						.addBox(-10.0F, -8.0F, 0.0F, 0.0F, 20.0F, 40.0F, new CubeDeformation(0.0F)).texOffs(49, 172)
						.addBox(-10.0F, 12.0F, 0.0F, 20.0F, 0.0F, 40.0F, new CubeDeformation(0.0F)).texOffs(161, 41)
						.addBox(-10.0F, -8.0F, 0.0F, 20.0F, 0.0F, 40.0F, new CubeDeformation(0.0F)).texOffs(193, 0)
						.addBox(-6.0F, -4.0F, 38.0F, 12.0F, 12.0F, 19.0F, new CubeDeformation(0.0F)).texOffs(195, 110)
						.addBox(0.0F, -12.0F, 40.0F, 0.0F, 8.0F, 17.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, -11.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(234, 114)
						.addBox(-1.0F, -2.645F, -1.5602F, 2.0F, 6.0F, 19.0F, new CubeDeformation(0.0F)).texOffs(35, 120)
						.addBox(0.0F, -10.345F, 0.4398F, 0.0F, 8.0F, 17.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -4.0F, 90.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(41, 179)
				.addBox(-2.0F, -4.0088F, -1.1042F, 4.0F, 8.0F, 19.0F, new CubeDeformation(0.0F)).texOffs(88, 110)
				.addBox(0.0F, -11.8088F, 0.8958F, 0.0F, 8.0F, 17.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.0F, 73.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(227, 62)
						.addBox(-4.0F, -5.1F, -2.0F, 8.0F, 10.0F, 19.0F, new CubeDeformation(0.0F)).texOffs(161, 110)
						.addBox(0.0F, -13.0F, 0.0F, 0.0F, 8.0F, 17.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 3.0F, 57.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition front_left_arm = partdefinition.addOrReplaceChild("front_left_arm", CubeListBuilder.create(),
				PartPose.offsetAndRotation(8.0F, 1.0F, 4.0F, 0.0F, -0.1745F, 0.0F));

		PartDefinition cube_r4 = front_left_arm.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(0, 83).addBox(-1.5002F, -0.5687F, -11.5586F, 27.0F, 0.0F, 27.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(9.0F, 18.0F, -32.0F, 1.5538F, 1.4603F, 1.61F));

		PartDefinition cube_r5 = front_left_arm.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(113, 162).addBox(-2.5002F, -2.5687F, -2.5586F, 28.0F, 5.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(12.0F, 3.0F, -18.0F, 1.5676F, 0.9367F, 1.6243F));

		PartDefinition cube_r6 = front_left_arm.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(47, 155).addBox(-7.0F, -4.0F, -3.0F, 26.0F, 7.0F, 7.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 1.0F, -4.0F, 0.1035F, 0.8681F, 0.1353F));

		PartDefinition back_left_leg = partdefinition.addOrReplaceChild("back_left_leg", CubeListBuilder.create(),
				PartPose.offsetAndRotation(8.0F, -1.0F, 17.0F, 0.6868F, 0.0569F, 0.2728F));

		PartDefinition cube_r7 = back_left_leg.addOrReplaceChild("cube_r7",
				CubeListBuilder.create().texOffs(0, 56).addBox(-4.7464F, -0.3432F, -11.9852F, 27.0F, 0.0F, 27.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(22.0F, 22.0F, 3.0F, -1.8724F, -0.8226F, 1.4633F));

		PartDefinition cube_r8 = back_left_leg.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(160, 31).addBox(-3.4248F, -2.0618F, -3.3838F, 28.0F, 5.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(11.0F, 4.0F, 15.0F, -1.7975F, 0.4531F, 1.1385F));

		PartDefinition cube_r9 = back_left_leg.addOrReplaceChild("cube_r9",
				CubeListBuilder.create().texOffs(111, 148).addBox(-7.0F, -4.0F, -4.0F, 26.0F, 7.0F, 7.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 1.0F, 4.0F, -0.1035F, -0.8681F, 0.1353F));

		PartDefinition back_right_leg = partdefinition.addOrReplaceChild("back_right_leg", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-8.0F, -1.0F, 17.0F, 0.6868F, -0.0569F, -0.2728F));

		PartDefinition cube_r10 = back_right_leg.addOrReplaceChild("cube_r10",
				CubeListBuilder.create().texOffs(0, 56).mirror()
						.addBox(-22.2536F, -0.3432F, -11.9852F, 27.0F, 0.0F, 27.0F, new CubeDeformation(0.0F))
						.mirror(false),
				PartPose.offsetAndRotation(-22.0F, 22.0F, 3.0F, -1.8724F, 0.8226F, -1.4633F));

		PartDefinition cube_r11 = back_right_leg.addOrReplaceChild("cube_r11",
				CubeListBuilder.create().texOffs(160, 31).mirror()
						.addBox(-24.5752F, -2.0618F, -3.3838F, 28.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
						.mirror(false),
				PartPose.offsetAndRotation(-11.0F, 4.0F, 15.0F, -1.7975F, -0.4531F, -1.1385F));

		PartDefinition cube_r12 = back_right_leg.addOrReplaceChild("cube_r12",
				CubeListBuilder.create().texOffs(111, 148).mirror()
						.addBox(-19.0F, -4.0F, -4.0F, 26.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-1.0F, 1.0F, 4.0F, -0.1035F, 0.8681F, -0.1353F));

		PartDefinition front_right_arm = partdefinition.addOrReplaceChild("front_right_arm", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-8.0F, 1.0F, 4.0F, 0.0F, 0.1745F, 0.0F));

		PartDefinition cube_r13 = front_right_arm.addOrReplaceChild("cube_r13",
				CubeListBuilder.create().texOffs(54, 56).addBox(-25.4998F, -0.5687F, -11.5586F, 27.0F, 0.0F, 27.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-9.0F, 18.0F, -32.0F, 1.5538F, -1.4603F, -1.61F));

		PartDefinition cube_r14 = front_right_arm.addOrReplaceChild("cube_r14",
				CubeListBuilder.create().texOffs(161, 117).addBox(-25.4998F, -2.5687F, -2.5586F, 28.0F, 5.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-12.0F, 3.0F, -18.0F, 1.5676F, -0.9367F, -1.6243F));

		PartDefinition cube_r15 = front_right_arm.addOrReplaceChild("cube_r15",
				CubeListBuilder.create().texOffs(153, 81).addBox(-19.0F, -4.0F, -3.0F, 26.0F, 7.0F, 7.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 1.0F, -4.0F, 0.1035F, -0.8681F, -0.1353F));

		return LayerDefinition.create(meshdefinition, 290, 290);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		front_left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		back_left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		back_right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		front_right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.back_right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.front_right_arm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.front_left_arm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.back_left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}