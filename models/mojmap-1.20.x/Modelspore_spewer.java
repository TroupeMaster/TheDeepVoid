// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelspore_spewer<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "spore_spewer"), "main");
	private final ModelPart left_leg1;
	private final ModelPart right_leg1;
	private final ModelPart left_leg2;
	private final ModelPart right_leg2;
	private final ModelPart body;
	private final ModelPart head;

	public Modelspore_spewer(ModelPart root) {
		this.left_leg1 = root.getChild("left_leg1");
		this.right_leg1 = root.getChild("right_leg1");
		this.left_leg2 = root.getChild("left_leg2");
		this.right_leg2 = root.getChild("right_leg2");
		this.body = root.getChild("body");
		this.head = root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition left_leg1 = partdefinition.addOrReplaceChild("left_leg1", CubeListBuilder.create(),
				PartPose.offset(0.0F, 14.0F, 0.0F));

		PartDefinition cube_r1 = left_leg1.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(24, 23)
						.addBox(-5.0F, -2.0F, -7.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(32, 41)
						.addBox(0.0F, 0.0F, -6.0F, 2.0F, 14.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(16, 30)
						.addBox(2.0F, 0.0F, -7.0F, 2.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(8.0F, -1.0F, 1.0F, -0.3408F, 0.6219F, -0.5468F));

		PartDefinition right_leg1 = partdefinition.addOrReplaceChild("right_leg1", CubeListBuilder.create(),
				PartPose.offset(0.0F, 14.0F, 0.0F));

		PartDefinition cube_r2 = right_leg1.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(24, 0)
						.addBox(-4.0F, -2.0F, -7.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(36, 27)
						.addBox(-2.0F, 0.0F, -6.0F, 2.0F, 14.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 30)
						.addBox(-4.0F, 0.0F, -7.0F, 2.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -1.0F, 1.0F, -0.3408F, -0.6219F, 0.5468F));

		PartDefinition left_leg2 = partdefinition.addOrReplaceChild("left_leg2", CubeListBuilder.create(),
				PartPose.offset(0.0F, 14.0F, 0.0F));

		PartDefinition cube_r3 = left_leg2.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(24, 4)
						.addBox(-5.0F, -2.0F, 5.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(40, 27)
						.addBox(0.0F, 0.0F, 6.0F, 2.0F, 14.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(8, 30)
						.addBox(2.0F, 0.0F, 5.0F, 2.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(8.0F, -1.0F, -1.0F, 0.3408F, -0.6219F, -0.5468F));

		PartDefinition right_leg2 = partdefinition.addOrReplaceChild("right_leg2", CubeListBuilder.create(),
				PartPose.offset(0.0F, 14.0F, 0.0F));

		PartDefinition cube_r4 = right_leg2.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(18, 19)
						.addBox(-4.0F, -2.0F, 5.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(32, 27)
						.addBox(-2.0F, 0.0F, 6.0F, 2.0F, 14.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(24, 27)
						.addBox(-4.0F, 0.0F, 5.0F, 2.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -1.0F, -1.0F, 0.3408F, 0.6219F, 0.5468F));

		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 19)
						.addBox(-3.0F, -13.0F, -3.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 46)
						.addBox(-2.0F, -8.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(32, 8)
						.addBox(-2.0F, -14.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-4.0F, -25.0F, -4.0F, 8.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		left_leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.right_leg1.zRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.right_leg2.zRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.left_leg1.zRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.left_leg2.zRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
	}
}