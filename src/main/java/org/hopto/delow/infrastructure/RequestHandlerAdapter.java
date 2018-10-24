package org.hopto.delow.infrastructure;

import com.fasterxml.jackson.databind.ObjectReader;
import org.hopto.delow.common.DefaultRestResponseBody;
import org.hopto.delow.common.RestResponse;
import spark.Request;
import spark.Response;
import spark.Route;

public class RequestHandlerAdapter<T> implements Route {

    private final RequestHandleFunction<T, RestResponse> function;

    private final ObjectReader objectReader;

    public RequestHandlerAdapter(RequestHandleFunction<T, RestResponse> function, ObjectReader objectReader) {
        this.function = function;
        this.objectReader = objectReader;
    }

    @Override
    public DefaultRestResponseBody handle(Request request, Response response) throws Exception {

        T o = objectReader.readValue(request.bodyAsBytes());

        RestResponse r = function.apply(o, request.queryMap().toMap(), request.params());

        response.status(r.getStatus());
        response.type("application/json; charset=utf-8");
        return r.getResponseBody();
    }

}
