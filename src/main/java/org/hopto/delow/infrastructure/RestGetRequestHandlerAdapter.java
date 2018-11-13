package org.hopto.delow.infrastructure;

import org.hopto.delow.common.DefaultRestResponseBody;
import org.hopto.delow.common.RestResponse;
import spark.QueryParamsMap;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class RestGetRequestHandlerAdapter implements Route {

    private final BiFunction<Map<String, String>, Map<String, String[]>, RestResponse> function;

    public RestGetRequestHandlerAdapter(BiFunction<Map<String, String>, Map<String, String[]>, RestResponse> function) {
        this.function = function;
    }

    public RestGetRequestHandlerAdapter(Function<Map<String, String>, RestResponse> function) {
        this.function = (pathParams, queryParams) -> function.apply(pathParams);
    }

    @Override
    public DefaultRestResponseBody handle(Request request, Response response) throws Exception {

        RestResponse r = function.apply(request.params(), request.queryMap().toMap());

        response.status(r.getStatus());
        response.type("application/json; charset=utf-8");
        return r.getResponseBody();
    }
}
