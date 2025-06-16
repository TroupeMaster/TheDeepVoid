// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modeldeath_maw_hidden<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "death_maw_hidden"), "main");
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart left_leg1;
	private final ModelPart right_leg1;
	private final ModelPart left_leg2;
	private final ModelPart right_leg2;
	private final ModelPart left_arm;
	private final ModelPart right_arm;

	public Modeldeath_maw_hidden(ModelPart root) {
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.left_leg1 = root.getChild("left_leg1");
		this.right_leg1 = root.getChild("right_leg1");
		this.left_leg2 = root.getChild("left_leg2");
		this.right_leg2 = root.getChild("right_leg2");
		this.left_arm = root.getChild("left_arm");
		this.right_arm = root.getChild("right_arm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 88)
						.addBox(-11.0F, 50.0F, 1.0F, 22.0F, 3.0F, 32.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-17.0F, 35.0F, 0.0F, 34.0F, 15.0F, 34.0F, new CubeDeformation(0.0F)).texOffs(0, 49)
						.addBox(-14.0F, 24.0F, 3.0F, 28.0F, 11.0F, 28.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 3.0F, -17.0F));

		PartDefinition cube_r1 = body
				.addOrReplaceChild("cube_r1",
						CubeListBuilder.create().texOffs(96, 208).addBox(-2.0F, -13.0F, -2.0F, 4.0F, 10.0F, 4.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(8.0F, 43.0F, 4.0F, 1.1345F, 0.0F, 0.0F));

		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(160, 72).addBox(-2.0F, -13.0F, -2.0F, 4.0F, 10.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-9.0F, 41.0F, 4.0F, 1.1345F, 0.0F, 0.0F));

		PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(136, 152).addBox(-17.0F, -30.0F, 0.0F, 34.0F, 30.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 35.0F, 34.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(68, 152).addBox(-17.0F, -30.0F, 0.0F, 34.0F, 30.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 35.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r5 = body.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(0, 123).addBox(0.0F, -30.0F, -17.0F, 0.0F, 30.0F, 34.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(17.0F, 35.0F, 17.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition cube_r6 = body.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(108, 88).addBox(0.0F, -30.0F, -17.0F, 0.0F, 30.0F, 34.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-17.0F, 35.0F, 17.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(68, 182)
						.addBox(-15.0F, -11.0F, -13.0F, 12.0F, 14.0F, 12.0F, new CubeDeformation(0.0F))
						.texOffs(164, 182).addBox(-15.0F, 3.0F, -13.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
						.texOffs(116, 182).addBox(2.0F, -9.0F, -12.0F, 12.0F, 14.0F, 12.0F, new CubeDeformation(0.0F))
						.texOffs(112, 72).addBox(2.0F, 5.0F, -12.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 46.0F, -17.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition cube_r7 = head
				.addOrReplaceChild("cube_r7",
						CubeListBuilder.create().texOffs(194, 40).addBox(-5.0F, -2.0F, -11.0F, 10.0F, 1.0F, 12.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(8.0F, 5.0F, -1.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r8 = head
				.addOrReplaceChild("cube_r8",
						CubeListBuilder.create().texOffs(0, 187).addBox(-5.0F, -2.0F, -11.0F, 10.0F, 5.0F, 12.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(8.0F, 6.0F, -1.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r9 = head.addOrReplaceChild("cube_r9",
				CubeListBuilder.create().texOffs(194, 53).addBox(-5.0F, -2.0F, -11.0F, 10.0F, 1.0F, 12.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-9.0F, 3.0F, -2.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r10 = head.addOrReplaceChild("cube_r10",
				CubeListBuilder.create().texOffs(190, 23).addBox(-5.0F, -2.0F, -11.0F, 10.0F, 5.0F, 12.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-9.0F, 4.0F, -2.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition left_leg1 = partdefinition.addOrReplaceChild("left_leg1", CubeListBuilder.create()
				.texOffs(112, 208).addBox(14.0F, 10.0F, 0.0F, 9.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(15.0F, 14.0F, -9.0F));

		PartDefinition cube_r11 = left_leg1.addOrReplaceChild("cube_r11",
				CubeListBuilder.create().texOffs(68, 123).addBox(2.0F, 1.0F, 0.0F, 9.0F, 28.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(15.0F, 18.0F, 0.0F, 0.0F, 0.0F, -0.8727F));

		PartDefinition cube_r12 = left_leg1.addOrReplaceChild("cube_r12",
				CubeListBuilder.create().texOffs(204, 152).addBox(-1.833F, -1.6517F, -1.0F, 4.0F, 27.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(15.0F, 18.0F, 0.0F, 0.0F, 0.0F, -1.1345F));

		PartDefinition cube_r13 = left_leg1.addOrReplaceChild("cube_r13",
				CubeListBuilder.create().texOffs(44, 187).addBox(-2.0F, -27.0F, -2.0F, 4.0F, 27.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 36.0F, 0.0F, 0.0F, 0.0F, 0.6981F));

		PartDefinition right_leg1 = partdefinition.addOrReplaceChild("right_leg1", CubeListBuilder.create()
				.texOffs(212, 181).addBox(-23.0F, 10.0F, 0.0F, 9.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-15.0F, 14.0F, -9.0F));

		PartDefinition cube_r14 = right_leg1.addOrReplaceChild("cube_r14",
				CubeListBuilder.create().texOffs(0, 204).addBox(-12.0F, 1.0F, 0.0F, 9.0F, 28.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-14.0F, 18.0F, 0.0F, 0.0F, 0.0F, 0.8727F));

		PartDefinition cube_r15 = right_leg1.addOrReplaceChild("cube_r15",
				CubeListBuilder.create().texOffs(84, 208).addBox(-3.1329F, -1.3929F, -1.0F, 4.0F, 27.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-14.0F, 18.0F, 0.0F, 0.0F, 0.0F, 1.1345F));

		PartDefinition cube_r16 = right_leg1.addOrReplaceChild("cube_r16",
				CubeListBuilder.create().texOffs(180, 196).addBox(-2.0F, -27.0F, -2.0F, 4.0F, 27.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 36.0F, 0.0F, 0.0F, 0.0F, -0.6981F));

		PartDefinition left_leg2 = partdefinition.addOrReplaceChild("left_leg2", CubeListBuilder.create()
				.texOffs(130, 208).addBox(14.0F, 10.0F, 0.0F, 9.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(15.0F, 14.0F, 12.0F));

		PartDefinition cube_r17 = left_leg2.addOrReplaceChild("cube_r17",
				CubeListBuilder.create().texOffs(86, 123).addBox(2.0F, 1.0F, 0.0F, 9.0F, 28.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(15.0F, 18.0F, 0.0F, 0.0F, 0.0F, -0.8727F));

		PartDefinition cube_r18 = left_leg2.addOrReplaceChild("cube_r18",
				CubeListBuilder.create().texOffs(60, 208).addBox(-1.833F, -1.6517F, -1.0F, 4.0F, 27.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(15.0F, 18.0F, 0.0F, 0.0F, 0.0F, -1.1345F));

		PartDefinition cube_r19 = left_leg2.addOrReplaceChild("cube_r19",
				CubeListBuilder.create().texOffs(164, 196).addBox(-2.0F, -27.0F, -2.0F, 4.0F, 27.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 36.0F, 0.0F, 0.0F, 0.0F, 0.6981F));

		PartDefinition right_leg2 = partdefinition.addOrReplaceChild("right_leg2", CubeListBuilder.create()
				.texOffs(212, 190).addBox(-23.0F, 10.0F, 0.0F, 9.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-15.0F, 14.0F, 12.0F));

		PartDefinition cube_r20 = right_leg2.addOrReplaceChild("cube_r20",
				CubeListBuilder.create().texOffs(18, 204).addBox(-11.0F, 1.0F, 0.0F, 9.0F, 28.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-15.0F, 18.0F, 0.0F, 0.0F, 0.0F, 0.8727F));

		PartDefinition cube_r21 = right_leg2.addOrReplaceChild("cube_r21",
				CubeListBuilder.create().texOffs(72, 208).addBox(-2.167F, -1.6517F, -1.0F, 4.0F, 27.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-15.0F, 18.0F, 0.0F, 0.0F, 0.0F, 1.1345F));

		PartDefinition cube_r22 = right_leg2.addOrReplaceChild("cube_r22",
				CubeListBuilder.create().texOffs(196, 196).addBox(-2.0F, -27.0F, -2.0F, 4.0F, 27.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 36.0F, 0.0F, 0.0F, 0.0F, -0.6981F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm",
				CubeListBuilder.create().texOffs(176, 72).addBox(-2.0F, -2.9659F, -21.7412F, 4.0F, 4.0F, 23.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(15.0F, 46.0F, -12.0F, -0.2618F, -0.6109F, 0.0F));

		PartDefinition cube_r23 = left_arm.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(112, 49)
				.addBox(-3.1772F, 33.8074F, -49.9393F, 18.0F, 0.0F, 23.0F, new CubeDeformation(0.0F)).texOffs(136, 23)
				.addBox(3.8228F, 32.3074F, -29.9393F, 4.0F, 3.0F, 23.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -34.7733F, -10.6825F, 0.0F, 0.6981F, 0.0F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm",
				CubeListBuilder.create().texOffs(176, 99).addBox(-2.0F, -2.0F, -22.0F, 4.0F, 4.0F, 23.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-15.0F, 45.0F, -12.0F, -0.2618F, 0.6109F, 0.0F));

		PartDefinition cube_r24 = right_arm.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(136, 0)
				.addBox(-14.8228F, 33.8074F, -49.9393F, 18.0F, 0.0F, 23.0F, new CubeDeformation(0.0F)).texOffs(176, 126)
				.addBox(-7.8228F, 32.3074F, -29.9393F, 4.0F, 3.0F, 23.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -33.8074F, -10.9413F, 0.0F, -0.6981F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}