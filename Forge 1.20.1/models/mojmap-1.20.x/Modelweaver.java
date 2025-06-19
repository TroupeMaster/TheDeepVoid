// Made with Blockbench 4.12.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelweaver<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "weaver"), "main");
	private final ModelPart Head;
	private final ModelPart Body;
	private final ModelPart Cape;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart Sword;
	private final ModelPart LeftLeg;
	private final ModelPart RightLeg;

	public Modelweaver(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Body = root.getChild("Body");
		this.Cape = this.Body.getChild("Cape");
		this.LeftArm = root.getChild("LeftArm");
		this.RightArm = root.getChild("RightArm");
		this.Sword = this.RightArm.getChild("Sword");
		this.LeftLeg = root.getChild("LeftLeg");
		this.RightLeg = root.getChild("RightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(20, 52)
						.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 22)
						.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 15.0F, 8.0F, new CubeDeformation(0.5F)),
				PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body",
				CubeListBuilder.create().texOffs(52, 52)
						.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(32, 22)
						.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 26.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition Cape = Body.addOrReplaceChild("Cape", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 2.0F));

		PartDefinition cape_r1 = Cape
				.addOrReplaceChild("cape_r1",
						CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -1.0F, 0.0F, 8.0F, 1.0F, 21.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5272F, 0.0F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm",
				CubeListBuilder.create().texOffs(20, 68)
						.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 45)
						.addBox(1.0F, -6.0F, -2.0F, 0.0F, 24.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(56, 22)
						.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 20.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offsetAndRotation(5.0F, -4.0F, 0.0F, -1.157F, 0.3499F, 0.1683F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(20, 68)
				.mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 45).mirror().addBox(-1.0F, -6.0F, -2.0F, 0.0F, 24.0F, 10.0F, new CubeDeformation(0.0F))
				.mirror(false).texOffs(56, 22).mirror()
				.addBox(-3.0F, -2.0F, -2.0F, 4.0F, 20.0F, 4.0F, new CubeDeformation(0.25F)).mirror(false),
				PartPose.offsetAndRotation(-5.0F, -4.0F, 0.0F, -0.4749F, -0.2895F, -0.3311F));

		PartDefinition Sword = RightArm.addOrReplaceChild("Sword", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-1.0F, -3.0F, 5.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r1 = Sword.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(-28, 92).addBox(0.0F, -0.5F, -28.0F, 28.0F, 0.0F, 28.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-13.0F, 1.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg",
				CubeListBuilder.create().texOffs(58, 0)
						.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(36, 68)
						.addBox(0.0F, 0.0F, 2.0F, 0.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.9F, 8.0F, 0.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg",
				CubeListBuilder.create().texOffs(58, 0).mirror()
						.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(36, 68).mirror().addBox(0.0F, 0.0F, 2.0F, 0.0F, 16.0F, 6.0F, new CubeDeformation(0.0F))
						.mirror(false),
				PartPose.offset(-1.9F, 8.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.LeftLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
		this.RightLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}