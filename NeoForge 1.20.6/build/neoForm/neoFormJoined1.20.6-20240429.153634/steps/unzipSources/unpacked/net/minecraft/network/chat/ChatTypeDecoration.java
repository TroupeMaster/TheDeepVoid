package net.minecraft.network.chat;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.serialization.codecs.RecordCodecBuilder.Instance;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.util.StringRepresentable;

public record ChatTypeDecoration(String translationKey, List<ChatTypeDecoration.Parameter> parameters, Style style) {
    public static final Codec<ChatTypeDecoration> CODEC = RecordCodecBuilder.create(
        p_304159_ -> p_304159_.group(
                    Codec.STRING.fieldOf("translation_key").forGetter(ChatTypeDecoration::translationKey),
                    ChatTypeDecoration.Parameter.CODEC.listOf().fieldOf("parameters").forGetter(ChatTypeDecoration::parameters),
                    Style.Serializer.CODEC.optionalFieldOf("style", Style.EMPTY).forGetter(ChatTypeDecoration::style)
                )
                .apply(p_304159_, ChatTypeDecoration::new)
    );

    public static ChatTypeDecoration withSender(String p_239223_) {
        return new ChatTypeDecoration(p_239223_, List.of(ChatTypeDecoration.Parameter.SENDER, ChatTypeDecoration.Parameter.CONTENT), Style.EMPTY);
    }

    public static ChatTypeDecoration incomingDirectMessage(String p_239425_) {
        Style style = Style.EMPTY.withColor(ChatFormatting.GRAY).withItalic(true);
        return new ChatTypeDecoration(p_239425_, List.of(ChatTypeDecoration.Parameter.SENDER, ChatTypeDecoration.Parameter.CONTENT), style);
    }

    public static ChatTypeDecoration outgoingDirectMessage(String p_240772_) {
        Style style = Style.EMPTY.withColor(ChatFormatting.GRAY).withItalic(true);
        return new ChatTypeDecoration(p_240772_, List.of(ChatTypeDecoration.Parameter.TARGET, ChatTypeDecoration.Parameter.CONTENT), style);
    }

    public static ChatTypeDecoration teamMessage(String p_239095_) {
        return new ChatTypeDecoration(
            p_239095_, List.of(ChatTypeDecoration.Parameter.TARGET, ChatTypeDecoration.Parameter.SENDER, ChatTypeDecoration.Parameter.CONTENT), Style.EMPTY
        );
    }

    public Component decorate(Component p_241301_, ChatType.Bound p_241391_) {
        Object[] aobject = this.resolveParameters(p_241301_, p_241391_);
        return Component.translatable(this.translationKey, aobject).withStyle(this.style);
    }

    private Component[] resolveParameters(Component p_241365_, ChatType.Bound p_241559_) {
        Component[] acomponent = new Component[this.parameters.size()];

        for (int i = 0; i < acomponent.length; i++) {
            ChatTypeDecoration.Parameter chattypedecoration$parameter = this.parameters.get(i);
            acomponent[i] = chattypedecoration$parameter.select(p_241365_, p_241559_);
        }

        return acomponent;
    }

    public static enum Parameter implements StringRepresentable {
        SENDER("sender", (p_241238_, p_241239_) -> p_241239_.name()),
        TARGET("target", (p_321399_, p_321400_) -> p_321400_.targetName().orElse(CommonComponents.EMPTY)),
        CONTENT("content", (p_239974_, p_241427_) -> p_239974_);

        public static final Codec<ChatTypeDecoration.Parameter> CODEC = StringRepresentable.fromEnum(ChatTypeDecoration.Parameter::values);
        private final String name;
        private final ChatTypeDecoration.Parameter.Selector selector;

        private Parameter(String p_239588_, ChatTypeDecoration.Parameter.Selector p_239589_) {
            this.name = p_239588_;
            this.selector = p_239589_;
        }

        public Component select(Component p_241369_, ChatType.Bound p_241509_) {
            return this.selector.select(p_241369_, p_241509_);
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }

        public interface Selector {
            Component select(Component p_239620_, ChatType.Bound p_241499_);
        }
    }
}
