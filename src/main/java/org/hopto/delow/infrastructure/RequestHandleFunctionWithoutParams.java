package org.hopto.delow.infrastructure;


public interface RequestHandleFunctionWithoutParams<T, U> extends RequestHandleFunction<T, U> {

    default U apply(T requestBody) {
        return this.apply(requestBody, null, null);
    }
}
