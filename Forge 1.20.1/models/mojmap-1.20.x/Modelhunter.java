// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelhunter<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "hunter"), "main");
	private final ModelPart body;
	private final ModelPart tail;
	private final ModelPart bone2;
	private final ModelPart bone3;
	private final ModelPart head;
	private final ModelPart left_leg1;
	private final ModelPart right_leg1;
	private final ModelPart right_leg2;
	private final ModelPart left_leg2;

	public Modelhunter(ModelPart root) {
		this.body = root.getChild("body");
		this.tail = root.getChild("tail");
		this.bone2 = this.tail.getChild("bone2");
		this.bone3 = this.bone2.getChild("bone3");
		this.head = root.getChild("head");
		this.left_leg1 = root.getChild("left_leg1");
		this.right_leg1 = root.getChild("right_leg1");
		this.right_leg2 = root.getChild("right_leg2");
		this.left_leg2 = root.getChild("left_leg2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-7.0F, -5.0F, 0.0F, 14.0F, 10.0F, 27.0F, new CubeDeformation(0.0F)).texOffs(54, 74)
						.addBox(-12.0F, 0.0F, 0.0F, 5.0F, 0.0F, 27.0F, new CubeDeformation(0.0F)).texOffs(82, 0)
						.addBox(7.0F, 0.0F, 0.0F, 5.0F, 0.0F, 27.0F, new CubeDeformation(0.0F)).texOffs(0, 37)
						.addBox(-7.0F, 5.0F, 0.0F, 14.0F, 5.0F, 27.0F, new CubeDeformation(0.0F)).texOffs(0, 74)
						.addBox(0.0F, -15.0F, 0.0F, 0.0F, 10.0F, 27.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 1.0F, -13.0F));

		PartDefinition tail = partdefinition.addOrReplaceChild("tail",
				CubeListBuilder.create().texOffs(82, 50).addBox(-5.0F, -3.5774F, -0.9063F, 10.0F, 7.0F, 11.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.0F, 13.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition bone2 = tail.addOrReplaceChild("bone2",
				CubeListBuilder.create().texOffs(118, 68).addBox(-3.0F, -2.0F, 0.0F, 6.0F, 4.0F, 11.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.4226F, 9.0937F, 0.3491F, 0.0F, 0.0F));

		PartDefinition bone3 = bone2
				.addOrReplaceChild("bone3",
						CubeListBuilder.create().texOffs(124, 50).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 12.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 11.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(132, 98)
						.addBox(-4.0F, -4.0F, -5.0F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(16, 141)
						.addBox(0.0F, -10.0F, -5.0F, 0.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(146, 0)
						.addBox(-3.0F, 0.0F, -23.0F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(132, 109)
						.addBox(-5.0F, -2.0F, -25.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(126, 131)
						.addBox(-5.0F, -2.0F, -29.0F, 10.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(82, 27)
						.addBox(-11.5F, -9.0F, -25.0F, 23.0F, 23.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 2.0F, -12.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(49, 75).addBox(-4.0F, -5.0F, -5.0F, 8.0F, 12.0F, 6.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 6.0F, -26.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(146, 8)
						.addBox(0.0F, -5.3386F, -7.235F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(132, 121)
						.addBox(-2.0F, -1.3386F, -7.235F, 4.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 3.0F, -14.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition cube_r3 = head.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(26, 132)
						.addBox(0.0F, -7.0F, -11.0F, 0.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(118, 83)
						.addBox(-3.0F, -2.0F, -11.0F, 6.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, -4.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition left_leg1 = partdefinition.addOrReplaceChild("left_leg1", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-7.0F, 5.0F, -7.0F, 0.0F, -0.3491F, 0.0F));

		PartDefinition cube_r4 = left_leg1.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(54, 101).addBox(4.8312F, -25.324F, 0.0F, 13.0F, 30.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-10.0F, 6.0F, 0.0F, 0.0F, 0.0F, -2.4871F));

		PartDefinition cube_r5 = left_leg1.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(0, 141).addBox(-0.6445F, -13.8504F, -2.0F, 4.0F, 16.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-10.0F, 6.0F, 0.0F, 0.0F, 0.0F, -0.9163F));

		PartDefinition cube_r6 = left_leg1.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(26, 111).addBox(-2.134F, -14.5F, -3.0F, 6.0F, 15.0F, 6.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0F, -1.0F, 0.0F, 0.0F, 0.0F, -2.0944F));

		PartDefinition right_leg1 = partdefinition.addOrReplaceChild("right_leg1", CubeListBuilder.create(),
				PartPose.offsetAndRotation(7.0F, 5.0F, -7.0F, 0.0F, 0.3491F, 0.0F));

		PartDefinition cube_r7 = right_leg1.addOrReplaceChild(
				"cube_r7", CubeListBuilder.create().texOffs(106, 101).addBox(-17.8312F, -25.324F, 0.0F, 13.0F, 30.0F,
						0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(10.0F, 6.0F, 0.0F, 0.0F, 0.0F, 2.4871F));

		PartDefinition cube_r8 = right_leg1.addOrReplaceChild(
				"cube_r8", CubeListBuilder.create().texOffs(114, 145).addBox(-3.3555F, -13.8504F, -2.0F, 4.0F, 16.0F,
						4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(10.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.9163F));

		PartDefinition cube_r9 = right_leg1.addOrReplaceChild("cube_r9",
				CubeListBuilder.create().texOffs(50, 131).addBox(-3.866F, -14.5F, -3.0F, 6.0F, 15.0F, 6.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, -1.0F, 0.0F, 0.0F, 0.0F, 2.0944F));

		PartDefinition right_leg2 = partdefinition.addOrReplaceChild("right_leg2", CubeListBuilder.create(),
				PartPose.offsetAndRotation(7.0F, 5.0F, 7.0F, 0.0F, -0.3491F, 0.0F));

		PartDefinition cube_r10 = right_leg2.addOrReplaceChild(
				"cube_r10", CubeListBuilder.create().texOffs(0, 111).addBox(-17.8312F, -25.324F, 0.0F, 13.0F, 30.0F,
						0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(10.0F, 6.0F, 0.0F, 0.0F, 0.0F, 2.4871F));

		PartDefinition cube_r11 = right_leg2.addOrReplaceChild(
				"cube_r11", CubeListBuilder.create().texOffs(130, 145).addBox(-3.3555F, -13.8504F, -2.0F, 4.0F, 16.0F,
						4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(10.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.9163F));

		PartDefinition cube_r12 = right_leg2.addOrReplaceChild("cube_r12",
				CubeListBuilder.create().texOffs(74, 131).addBox(-3.866F, -14.5F, -3.0F, 6.0F, 15.0F, 6.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, -1.0F, 0.0F, 0.0F, 0.0F, 2.0944F));

		PartDefinition left_leg2 = partdefinition.addOrReplaceChild("left_leg2", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-7.0F, 5.0F, 7.0F, 0.0F, 0.3491F, 0.0F));

		PartDefinition cube_r13 = left_leg2.addOrReplaceChild("cube_r13",
				CubeListBuilder.create().texOffs(80, 101).addBox(4.8312F, -25.324F, 0.0F, 13.0F, 30.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-10.0F, 6.0F, 0.0F, 0.0F, 0.0F, -2.4871F));

		PartDefinition cube_r14 = left_leg2.addOrReplaceChild("cube_r14",
				CubeListBuilder.create().texOffs(98, 145).addBox(-0.6445F, -13.8504F, -2.0F, 4.0F, 16.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-10.0F, 6.0F, 0.0F, 0.0F, 0.0F, -0.9163F));

		PartDefinition cube_r15 = left_leg2.addOrReplaceChild("cube_r15",
				CubeListBuilder.create().texOffs(128, 27).addBox(-2.134F, -14.5F, -3.0F, 6.0F, 15.0F, 6.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0F, -1.0F, 0.0F, 0.0F, 0.0F, -2.0944F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.right_leg1.zRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.right_leg2.zRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.left_leg1.zRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.left_leg2.zRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
	}
}