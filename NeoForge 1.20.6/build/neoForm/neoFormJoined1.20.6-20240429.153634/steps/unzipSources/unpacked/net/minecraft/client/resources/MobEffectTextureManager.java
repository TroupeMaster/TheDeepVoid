package net.minecraft.client.resources;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.flag.FeatureFlags;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MobEffectTextureManager extends TextureAtlasHolder {
    public MobEffectTextureManager(TextureManager p_118730_) {
        super(p_118730_, new ResourceLocation("textures/atlas/mob_effects.png"), new ResourceLocation("mob_effects"));
    }

    public TextureAtlasSprite get(Holder<MobEffect> p_316705_) {
        if (p_316705_ == MobEffects.BAD_OMEN) {
            ClientLevel clientlevel = Minecraft.getInstance().level;
            if (clientlevel != null && clientlevel.enabledFeatures().contains(FeatureFlags.UPDATE_1_21)) {
                return this.getSprite(new ResourceLocation("bad_omen_121"));
            }
        }

        return this.getSprite(p_316705_.unwrapKey().map(ResourceKey::location).orElseGet(MissingTextureAtlasSprite::getLocation));
    }
}
