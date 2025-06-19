package net.minecraft.world.damagesource;

import com.mojang.serialization.Codec;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.StringRepresentable;

public enum DamageEffects implements StringRepresentable, net.neoforged.neoforge.common.IExtensibleEnum {
    HURT("hurt", SoundEvents.PLAYER_HURT),
    THORNS("thorns", SoundEvents.THORNS_HIT),
    DROWNING("drowning", SoundEvents.PLAYER_HURT_DROWN),
    BURNING("burning", SoundEvents.PLAYER_HURT_ON_FIRE),
    POKING("poking", SoundEvents.PLAYER_HURT_SWEET_BERRY_BUSH),
    FREEZING("freezing", SoundEvents.PLAYER_HURT_FREEZE);

    public static final Codec<DamageEffects> CODEC = Codec.lazyInitialized(() -> StringRepresentable.fromEnum(DamageEffects::values));
    private final String id;
    @Deprecated // Neo: Always set to null. Use the getter.
    private final SoundEvent sound;

    private DamageEffects(String p_270875_, SoundEvent p_270383_) {
        this(p_270875_, () -> p_270383_);
    }

    @Override
    public String getSerializedName() {
        return this.id;
    }

    public SoundEvent sound() {
        return this.soundSupplier.get();
    }

    private final java.util.function.Supplier<SoundEvent> soundSupplier;

    private DamageEffects(String id, java.util.function.Supplier<SoundEvent> sound) {
        this.id = id;
        this.soundSupplier = sound;
        this.sound = null;
    }

    /**
     * Creates a new DamageEffects with the specified ID and sound.<br>
     * Example usage:
     * <code><pre>
     * public static final DamageEffects ELECTRIFYING = DamageEffects.create("MYMOD_ELECTRIFYING", "mymod:electrifying", MySounds.ELECTRIFYING);
     * </pre></code>
     * @param name The {@linkplain Enum#name() true enum name}. Prefix this with your modid.
     * @param id The {@linkplain StringRepresentable#getSerializedName() serialized name}. Prefix this with your modid and `:`
     * @param sound The sound event that will play when a damage type with this effect deals damage to a player.
     * @return A newly created DamageEffects. Store this result in a static final field.
     * @apiNote This method must be called as early as possible, as if {@link #CODEC} is resolved before this is called, it will be unusable.
     */
    public static DamageEffects create(String name, String id, java.util.function.Supplier<SoundEvent> sound) {
        throw new IllegalStateException("Enum not extended");
    }
}
