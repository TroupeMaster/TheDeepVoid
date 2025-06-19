package net.minecraft.data.info;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.JsonOps;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.TypedDataComponent;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceLocation;

public class ItemListReport implements DataProvider {
    private final PackOutput output;
    private final CompletableFuture<HolderLookup.Provider> registries;

    public ItemListReport(PackOutput p_331079_, CompletableFuture<HolderLookup.Provider> p_330936_) {
        this.output = p_331079_;
        this.registries = p_330936_;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput p_330682_) {
        Path path = this.output.getOutputFolder(PackOutput.Target.REPORTS).resolve("items.json");
        return this.registries.thenCompose(p_330267_ -> {
            JsonObject jsonobject = new JsonObject();
            RegistryOps<JsonElement> registryops = p_330267_.createSerializationContext(JsonOps.INSTANCE);
            p_330267_.lookupOrThrow(Registries.ITEM).listElements().forEach(p_331576_ -> {
                JsonObject jsonobject1 = new JsonObject();
                JsonArray jsonarray = new JsonArray();
                p_331576_.value().components().forEach(p_330888_ -> jsonarray.add(dumpComponent((TypedDataComponent<?>)p_330888_, registryops)));
                jsonobject1.add("components", jsonarray);
                jsonobject.add(p_331576_.getRegisteredName(), jsonobject1);
            });
            return DataProvider.saveStable(p_330682_, jsonobject, path);
        });
    }

    private static <T> JsonElement dumpComponent(TypedDataComponent<T> p_330424_, DynamicOps<JsonElement> p_332057_) {
        ResourceLocation resourcelocation = BuiltInRegistries.DATA_COMPONENT_TYPE.getKey(p_330424_.type());
        JsonElement jsonelement = p_330424_.encodeValue(p_332057_)
            .getOrThrow(p_339362_ -> new IllegalStateException("Failed to serialize component " + resourcelocation + ": " + p_339362_));
        JsonObject jsonobject = new JsonObject();
        jsonobject.addProperty("type", resourcelocation.toString());
        jsonobject.add("value", jsonelement);
        return jsonobject;
    }

    @Override
    public final String getName() {
        return "Item List";
    }
}
