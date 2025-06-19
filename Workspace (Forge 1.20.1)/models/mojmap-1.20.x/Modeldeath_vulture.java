// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modeldeath_vulture<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "death_vulture"), "main");
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart left_wing;
	private final ModelPart right_wing;
	private final ModelPart tiny_arm_left;
	private final ModelPart tiny_arm_right;
	private final ModelPart left_leg;
	private final ModelPart right_leg;

	public Modeldeath_vulture(ModelPart root) {
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.left_wing = root.getChild("left_wing");
		this.right_wing = root.getChild("right_wing");
		this.tiny_arm_left = root.getChild("tiny_arm_left");
		this.tiny_arm_right = root.getChild("tiny_arm_right");
		this.left_leg = root.getChild("left_leg");
		this.right_leg = root.getChild("right_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(86, 68)
						.addBox(0.0F, -20.0F, 5.0F, 0.0F, 20.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(38, 0)
						.addBox(-5.0F, -19.0F, -4.0F, 10.0F, 18.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 38)
						.addBox(-6.0F, -20.0F, -5.0F, 12.0F, 20.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -14.0F, 6.0F, 0.8727F, 0.0F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(),
				PartPose.offset(0.0F, -3.0F, -8.0F));

		PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(72, 26)
						.addBox(0.0F, -10.0F, -32.0F, 0.0F, 7.0F, 15.0F, new CubeDeformation(0.0F)).texOffs(0, 68)
						.addBox(-1.0F, -3.0F, -32.0F, 2.0F, 3.0F, 15.0F, new CubeDeformation(0.0F)).texOffs(16, 101)
						.addBox(0.0F, -10.0F, -17.0F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(102, 17)
						.addBox(-1.0F, -5.0F, -17.0F, 2.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 86)
						.addBox(-3.0F, 0.0F, -9.0F, 6.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(74, 0)
						.addBox(-3.0F, -7.0F, -9.0F, 6.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -6.0F, -13.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r3 = head.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(0, 101).addBox(-2.0F, -10.3F, -3.5F, 4.0F, 13.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 2.0F, -11.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r4 = head.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(54, 95)
						.addBox(0.0F, -10.0F, 1.0F, 0.0F, 13.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(88, 96)
						.addBox(-2.0F, -10.0F, -3.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, -1.0F, 1.8326F, 0.0F, 0.0F));

		PartDefinition left_wing = partdefinition.addOrReplaceChild("left_wing", CubeListBuilder.create(),
				PartPose.offsetAndRotation(6.0F, 0.0F, -8.0F, -0.0465F, 0.2577F, -0.1806F));

		PartDefinition cube_r5 = left_wing.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(34, 79)
						.addBox(-1.0F, -11.0F, 25.0F, 0.0F, 21.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(44, 26)
						.addBox(-1.0F, -11.0F, 12.0F, 1.0F, 21.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-1.0F, -11.0F, -5.0F, 2.0F, 21.0F, 17.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 1.0F, 0.0F, -0.48F, 0.0F, 0.0F));

		PartDefinition right_wing = partdefinition.addOrReplaceChild("right_wing", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-6.0F, 0.0F, -8.0F, -0.0465F, -0.2577F, 0.1806F));

		PartDefinition cube_r6 = right_wing.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(34, 79)
				.mirror().addBox(1.0F, -11.0F, 25.0F, 0.0F, 21.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(44, 26).mirror().addBox(0.0F, -11.0F, 12.0F, 1.0F, 21.0F, 13.0F, new CubeDeformation(0.0F))
				.mirror(false).texOffs(0, 0).mirror()
				.addBox(-1.0F, -11.0F, -5.0F, 2.0F, 21.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-1.0F, 1.0F, 0.0F, -0.48F, 0.0F, 0.0F));

		PartDefinition tiny_arm_left = partdefinition.addOrReplaceChild("tiny_arm_left",
				CubeListBuilder.create().texOffs(104, 80)
						.addBox(-1.0F, 0.0F, 14.0F, 2.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(74, 96)
						.addBox(0.0F, -2.0F, 16.0F, 0.0F, 19.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(44, 60)
						.addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 17.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(6.0F, 0.0F, -7.0F, -2.101F, -0.151F, 0.0879F));

		PartDefinition cube_r7 = tiny_arm_left.addOrReplaceChild("cube_r7",
				CubeListBuilder.create().texOffs(102, 30).addBox(-4.0F, -1.0F, 0.0F, 8.0F, 12.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 17.0F, 15.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition tiny_arm_right = partdefinition.addOrReplaceChild("tiny_arm_right", CubeListBuilder.create()
				.texOffs(104, 80).mirror().addBox(-1.0F, 0.0F, 14.0F, 2.0F, 17.0F, 2.0F, new CubeDeformation(0.0F))
				.mirror(false).texOffs(74, 96).mirror()
				.addBox(0.0F, -2.0F, 16.0F, 0.0F, 19.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(44, 60)
				.mirror().addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-6.0F, 0.0F, -7.0F, -2.101F, 0.151F, -0.0879F));

		PartDefinition cube_r8 = tiny_arm_right.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(102, 30).mirror()
						.addBox(-4.0F, -1.0F, 0.0F, 8.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 17.0F, 15.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(),
				PartPose.offsetAndRotation(6.0F, 8.0F, 3.0F, 0.0F, 0.0436F, 0.0F));

		PartDefinition cube_r9 = left_leg.addOrReplaceChild("cube_r9",
				CubeListBuilder.create().texOffs(102, 68).addBox(-6.6589F, 0.3217F, -0.942F, 8.0F, 12.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.6589F, 14.6783F, -6.058F, -1.2915F, 0.0F, 0.0F));

		PartDefinition cube_r10 = left_leg.addOrReplaceChild("cube_r10",
				CubeListBuilder.create().texOffs(82, 48).addBox(0.3411F, -5.2783F, -7.542F, 0.0F, 6.0F, 14.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.3411F, 5.6783F, -4.058F, -2.5307F, 0.0F, 0.0F));

		PartDefinition cube_r11 = left_leg.addOrReplaceChild("cube_r11",
				CubeListBuilder.create().texOffs(34, 68).addBox(-1.6589F, -7.3783F, -1.842F, 2.0F, 8.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.6589F, 8.6783F, -12.058F, -2.5307F, 0.0F, 0.0F));

		PartDefinition cube_r12 = left_leg.addOrReplaceChild("cube_r12",
				CubeListBuilder.create().texOffs(54, 79).addBox(-0.6589F, -0.6783F, -13.942F, 2.0F, 2.0F, 14.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.3411F, -0.3217F, 0.942F, 0.6109F, 0.0F, 0.0F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-6.0F, 8.0F, 3.0F, 0.0F, -0.0436F, 0.0F));

		PartDefinition cube_r13 = right_leg.addOrReplaceChild("cube_r13",
				CubeListBuilder.create().texOffs(102, 68).mirror()
						.addBox(-1.3411F, 0.3217F, -0.942F, 8.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-2.6589F, 14.6783F, -6.058F, -1.2915F, 0.0F, 0.0F));

		PartDefinition cube_r14 = right_leg.addOrReplaceChild("cube_r14",
				CubeListBuilder.create().texOffs(82, 48).mirror()
						.addBox(-0.3411F, -5.2783F, -7.542F, 0.0F, 6.0F, 14.0F, new CubeDeformation(0.0F))
						.mirror(false),
				PartPose.offsetAndRotation(0.3411F, 5.6783F, -4.058F, -2.5307F, 0.0F, 0.0F));

		PartDefinition cube_r15 = right_leg.addOrReplaceChild("cube_r15",
				CubeListBuilder.create().texOffs(34, 68).mirror()
						.addBox(-0.3411F, -7.3783F, -1.842F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-0.6589F, 8.6783F, -12.058F, -2.5307F, 0.0F, 0.0F));

		PartDefinition cube_r16 = right_leg.addOrReplaceChild("cube_r16",
				CubeListBuilder.create().texOffs(54, 79).mirror()
						.addBox(-1.3411F, -0.6783F, -13.942F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
						.mirror(false),
				PartPose.offsetAndRotation(0.3411F, -0.3217F, 0.942F, 0.6109F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tiny_arm_left.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tiny_arm_right.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}