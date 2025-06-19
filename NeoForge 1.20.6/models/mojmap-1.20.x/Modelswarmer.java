// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelswarmer<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "swarmer"), "main");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart left_wing;
	private final ModelPart right_wing;

	public Modelswarmer(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.left_wing = root.getChild("left_wing");
		this.right_wing = root.getChild("right_wing");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 17).addBox(
				-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 33)
						.addBox(-2.0F, 1.0F, 6.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(44, 44)
						.addBox(0.0F, -4.0F, 6.0F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 16.0F, 0.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(0, 45)
						.addBox(0.0F, -6.0F, 0.0F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(44, 33)
						.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 3.0F, 12.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(24, 33)
						.addBox(0.0F, -8.0F, 0.0F, 0.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(32, 17)
						.addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, -2.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition left_wing = partdefinition.addOrReplaceChild("left_wing", CubeListBuilder.create(),
				PartPose.offset(3.0F, 16.0F, 1.0F));

		PartDefinition cube_r3 = left_wing
				.addOrReplaceChild("cube_r3",
						CubeListBuilder.create().texOffs(2, 2).addBox(-1.0F, 0.0F, -10.0F, 20.0F, 0.0F, 15.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition right_wing = partdefinition.addOrReplaceChild("right_wing", CubeListBuilder.create(),
				PartPose.offset(-3.0F, 16.0F, 1.0F));

		PartDefinition cube_r4 = right_wing.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(2, 2).mirror()
						.addBox(-19.0F, 0.0F, -10.0F, 20.0F, 0.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-1.0F, 0.0F, 1.0F, 0.0F, 0.0F, -0.0873F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.right_wing.zRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.left_wing.zRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
	}
}