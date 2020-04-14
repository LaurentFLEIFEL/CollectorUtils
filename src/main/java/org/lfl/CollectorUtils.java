package org.lfl;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.lfl.ExceptionUtils.duplicateKeyException;

public final class CollectorUtils {

    public static <T> Collector<T, ?, List<T>> toListWithSize(int size) {
        return Collectors.toCollection(() -> new ArrayList<>(size));
    }

    public static <T> Collector<T, ?, Set<T>> toSetWithSize(int size) {
        return Collectors.toCollection(() -> new HashSet<>(size));
    }

    public static <T, K, U> Collector<T, ?, Map<K, U>> toMapWithSize(Function<? super T, ? extends K> keyMapper,
                                                                     Function<? super T, ? extends U> valueMapper,
                                                                     int size) {
        return Collectors.toMap(keyMapper, valueMapper, (u1, u2) -> {throw duplicateKeyException(u1, u2);}, () -> new HashMap<>(size));
    }
}
