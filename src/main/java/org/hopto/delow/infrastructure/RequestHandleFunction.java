package org.hopto.delow.infrastructure;

import java.util.Map;

@FunctionalInterface
public interface RequestHandleFunction<T, U>{

    U apply(T requestBody, Map<String, String[]> queryParams, Map<String, String> pathParams);
}
