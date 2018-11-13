package org.hopto.delow.infrastructure;

import com.fasterxml.jackson.databind.ObjectReader;
import org.hopto.delow.common.DefaultRestResponseBody;
import org.hopto.delow.common.RestResponse;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class RestPostRequestHandlerAdapter<T> implements Route {

    private final BiFunction<T, Map<String, String>, RestResponse> function;

    private final ObjectReader objectReader;

    public RestPostRequestHandlerAdapter(BiFunction<T, Map<String, String>, RestResponse> function, ObjectReader objectReader) {
        this.function = function;
        this.objectReader = objectReader;
    }

    public RestPostRequestHandlerAdapter(Function<T, RestResponse> function, ObjectReader objectReader) {
        this.function = (t, stringStringMap) -> function.apply(t);
        this.objectReader = objectReader;
    }

    @Override
    public DefaultRestResponseBody handle(Request request, Response response) throws Exception {

        T o = objectReader.readValue(request.bodyAsBytes());

        RestResponse r = function.apply(o, request.params());

        response.status(r.getStatus());
        response.type("application/json; charset=utf-8");
        return r.getResponseBody();
    }

}
