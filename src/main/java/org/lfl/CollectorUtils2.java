package org.lfl;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.factory.Maps;
import org.eclipse.collections.api.factory.Sets;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.set.MutableSet;

import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.lfl.ExceptionUtils.duplicateKeyException;

public class CollectorUtils2 {

    public static <T> Collector<T, ?, MutableList<T>> toListWithSize(int size) {
        return Collectors.toCollection(() -> Lists.mutable.ofInitialCapacity(size));
    }

    public static <T> Collector<T, ?, MutableSet<T>> toSetWithSize(int size) {
        return Collectors.toCollection(() -> Sets.mutable.ofInitialCapacity(size));
    }

    public static <T, K, U> Collector<T, ?, MutableMap<K, U>> toMapWithSize(Function<? super T, ? extends K> keyMapper,
                                                                            Function<? super T, ? extends U> valueMapper,
                                                                            int size) {
        return Collectors.toMap(keyMapper, valueMapper, (u1, u2) -> {throw duplicateKeyException(u1, u2);}, () -> Maps.mutable.ofInitialCapacity(size));
    }
}
