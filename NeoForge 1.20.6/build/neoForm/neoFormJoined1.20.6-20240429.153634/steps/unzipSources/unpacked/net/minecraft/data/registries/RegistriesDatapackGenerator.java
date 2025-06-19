package net.minecraft.data.registries;

import com.google.gson.JsonElement;
import com.mojang.logging.LogUtils;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.Encoder;
import com.mojang.serialization.JsonOps;
import java.nio.file.Path;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.resources.ResourceKey;
import org.slf4j.Logger;

/**
 * @deprecated Forge: Use {@link net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider} instead
 */
@Deprecated
public class RegistriesDatapackGenerator implements DataProvider {
    private static final Logger LOGGER = LogUtils.getLogger();
    private final PackOutput output;
    private final CompletableFuture<HolderLookup.Provider> registries;
    private final java.util.function.Predicate<String> namespacePredicate;

    @Deprecated
    public RegistriesDatapackGenerator(PackOutput p_256643_, CompletableFuture<HolderLookup.Provider> p_255780_) {
        this(p_256643_, p_255780_, null);
    }

    public RegistriesDatapackGenerator(PackOutput p_256643_, CompletableFuture<HolderLookup.Provider> p_255780_, @org.jetbrains.annotations.Nullable java.util.Set<String> modIds) {
        this.namespacePredicate = modIds == null ? namespace -> true : modIds::contains;
        this.registries = p_255780_;
        this.output = p_256643_;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput p_255785_) {
        return this.registries
            .thenCompose(
                p_326736_ -> {
                    DynamicOps<JsonElement> dynamicops = p_326736_.createSerializationContext(JsonOps.INSTANCE);
                    return CompletableFuture.allOf(
                        net.neoforged.neoforge.registries.DataPackRegistriesHooks.getDataPackRegistriesWithDimensions()
                            .flatMap(
                                p_256552_ -> this.dumpRegistryCap(p_255785_, p_326736_, dynamicops, (RegistryDataLoader.RegistryData<?>)p_256552_).stream()
                            )
                            .toArray(CompletableFuture[]::new)
                    );
                }
            );
    }

    private <T> Optional<CompletableFuture<?>> dumpRegistryCap(
        CachedOutput p_256502_, HolderLookup.Provider p_256492_, DynamicOps<JsonElement> p_256000_, RegistryDataLoader.RegistryData<T> p_256449_
    ) {
        ResourceKey<? extends Registry<T>> resourcekey = p_256449_.key();
        return p_256492_.lookup(resourcekey)
            .map(
                p_255847_ -> {
                    PackOutput.PathProvider packoutput$pathprovider = this.output
                        .createPathProvider(PackOutput.Target.DATA_PACK, net.neoforged.neoforge.common.CommonHooks.prefixNamespace(resourcekey.location()));
                    return CompletableFuture.allOf(
                        p_255847_.listElements()
                            .filter(holder -> this.namespacePredicate.test(holder.key().location().getNamespace()))
                            .map(
                                p_256105_ -> dumpValue(
                                        packoutput$pathprovider.json(p_256105_.key().location()),
                                        p_256502_,
                                        p_256000_,
                                        p_256449_.elementCodec(),
                                        p_256105_.value()
                                    )
                            )
                            .toArray(CompletableFuture[]::new)
                    );
                }
            );
    }

    private static <E> CompletableFuture<?> dumpValue(
        Path p_255678_, CachedOutput p_256438_, DynamicOps<JsonElement> p_256127_, Encoder<E> p_255938_, E p_256590_
    ) {
        Optional<JsonElement> optional = p_255938_.encodeStart(p_256127_, p_256590_)
            .resultOrPartial(p_255999_ -> LOGGER.error("Couldn't serialize element {}: {}", p_255678_, p_255999_));
        return optional.isPresent() ? DataProvider.saveStable(p_256438_, optional.get(), p_255678_) : CompletableFuture.completedFuture(null);
    }

    @Override
    public String getName() {
        return "Registries";
    }
}
