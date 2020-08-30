package com.printing.devices.statistics.mapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.jetbrains.annotations.Nullable;

@FunctionalInterface
public interface BaseMapper<S, D> extends Function<S, D> {
    D map(@Nullable S source);

    default D apply(final S s) {
        return map(s);
    }

    default List<D> map(final List<S> sourceList) {
        if (sourceList == null) {
            return new ArrayList<>(0);
        }

        return sourceList.stream()
                .map(this::map)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
