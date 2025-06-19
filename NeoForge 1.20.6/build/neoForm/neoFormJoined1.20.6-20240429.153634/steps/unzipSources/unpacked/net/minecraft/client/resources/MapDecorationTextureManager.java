package net.minecraft.client.resources;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MapDecorationTextureManager extends TextureAtlasHolder {
    public MapDecorationTextureManager(TextureManager p_335745_) {
        super(p_335745_, new ResourceLocation("textures/atlas/map_decorations.png"), new ResourceLocation("map_decorations"));
    }

    public TextureAtlasSprite get(MapDecoration p_335945_) {
        return this.getSprite(p_335945_.getSpriteLocation());
    }
}
