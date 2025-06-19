package net.minecraft.gametest.framework;

import com.google.common.collect.Lists;
import com.google.common.collect.Streams;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import net.minecraft.server.level.ServerLevel;

public class GameTestBatchFactory {
    private static final int MAX_TESTS_PER_BATCH = 50;

    public static Collection<GameTestBatch> fromTestFunction(Collection<TestFunction> p_320519_, ServerLevel p_319999_) {
        Map<String, List<TestFunction>> map = p_320519_.stream().collect(Collectors.groupingBy(TestFunction::batchName));
        return map.entrySet()
            .stream()
            .flatMap(
                p_325551_ -> {
                    String s = p_325551_.getKey();
                    List<TestFunction> list = p_325551_.getValue();
                    return Streams.mapWithIndex(
                        Lists.partition(list, 50).stream(),
                        (p_325548_, p_325549_) -> toGameTestBatch(
                                p_325548_.stream().map(p_320787_ -> toGameTestInfo(p_320787_, 0, p_319999_)).toList(), s, p_325549_
                            )
                    );
                }
            )
            .toList();
    }

    public static GameTestInfo toGameTestInfo(TestFunction p_320432_, int p_320796_, ServerLevel p_320136_) {
        return new GameTestInfo(p_320432_, StructureUtils.getRotationForRotationSteps(p_320796_), p_320136_, RetryOptions.noRetries());
    }

    public static GameTestRunner.GameTestBatcher fromGameTestInfo() {
        return p_325541_ -> {
            Map<String, List<GameTestInfo>> map = p_325541_.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(p_320634_ -> p_320634_.getTestFunction().batchName()));
            return map.entrySet()
                .stream()
                .flatMap(
                    p_325545_ -> {
                        String s = p_325545_.getKey();
                        List<GameTestInfo> list = p_325545_.getValue();
                        return Streams.mapWithIndex(
                            Lists.partition(list, 50).stream(), (p_325543_, p_325544_) -> toGameTestBatch(List.copyOf(p_325543_), s, p_325544_)
                        );
                    }
                )
                .toList();
        };
    }

    private static GameTestBatch toGameTestBatch(List<GameTestInfo> p_320150_, String p_320417_, long p_326505_) {
        Consumer<ServerLevel> consumer = GameTestRegistry.getBeforeBatchFunction(p_320417_);
        Consumer<ServerLevel> consumer1 = GameTestRegistry.getAfterBatchFunction(p_320417_);
        return new GameTestBatch(p_320417_ + ":" + p_326505_, p_320150_, consumer, consumer1);
    }
}
