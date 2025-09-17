// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelhunter_mask<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "hunter_mask"), "main");
	private final ModelPart Head;

	public Modelhunter_mask(ModelPart root) {
		this.Head = root.getChild("Head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(0, 24)
						.addBox(-4.0F, -8.0F, -5.0F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 14)
						.addBox(4.1F, -5.0F, -5.0F, 0.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(18, 14)
						.addBox(-4.1F, -5.0F, -5.0F, 0.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(18, 24)
						.addBox(-4.0F, -5.0F, 4.1F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-15.0F, -19.0F, -4.0F, 30.0F, 14.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
	}
}