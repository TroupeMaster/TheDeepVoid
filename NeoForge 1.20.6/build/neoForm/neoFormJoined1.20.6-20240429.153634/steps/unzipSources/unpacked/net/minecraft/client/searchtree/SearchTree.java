package net.minecraft.client.searchtree;

import java.util.List;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public interface SearchTree<T> {
    List<T> search(String p_119955_);
}
