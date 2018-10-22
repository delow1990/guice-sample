package org.hopto.delow.infrastructure;

import java.util.Set;
import java.util.function.BiFunction;

public interface RequestHandleFunction<T, U> extends BiFunction<T, Set<String>, U> {

    @Override
    U apply(T requestBody, Set<String> queryParams);
}
