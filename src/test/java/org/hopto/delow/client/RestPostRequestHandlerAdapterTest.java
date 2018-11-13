package org.hopto.delow.client;

import com.fasterxml.jackson.databind.ObjectReader;
import org.hopto.delow.common.DefaultRestResponseBody;
import org.hopto.delow.common.RestResponse;
import org.hopto.delow.infrastructure.RestPostRequestHandlerAdapter;
import org.junit.jupiter.api.Test;
import spark.Request;
import spark.Response;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RestPostRequestHandlerAdapterTest {

    @Test
    void restPostRequestHandlerAdapterBiFunctionTest() throws Exception {

        //Init mocks...
//        RequestHandleFunctionWithoutParams<RequestBody, RestResponse> handleFunction = mock(RequestHandleFunctionWithoutParams.class);
        RestResponse restResponse = RestResponse.ok();

        BiFunction<RequestBody, Map<String, String>, RestResponse> biFunction = mock(BiFunction.class);
        when(biFunction.apply(any(), any())).thenReturn(restResponse);

//        Function<RequestBody, RestResponse> function = mock(Function.class);
//        when(function.apply(any())).thenReturn(restResponse);

        ObjectReader reader = mock(ObjectReader.class);

        Request request = mock(Request.class);
//        QueryParamsMap queryParamsMap = mock(QueryParamsMap.class);
//        when(request.queryMap()).thenReturn(queryParamsMap);

        Response response = mock(Response.class);

        //Create and test adapter
        RestPostRequestHandlerAdapter<RequestBody> biAdapter = new RestPostRequestHandlerAdapter<>(biFunction, reader);
        DefaultRestResponseBody responseBody = biAdapter.handle(request, response);

        //Check
        assertNotNull(responseBody);

    }

    @Test
    void restPostRequestHandlerAdapterFunctionTest() throws Exception {

        //Init mocks...
        RestResponse restResponse = RestResponse.ok();

        Function<RequestBody, RestResponse> function = mock(Function.class);
        when(function.apply(any())).thenReturn(restResponse);

        ObjectReader reader = mock(ObjectReader.class);

        Request request = mock(Request.class);
        Response response = mock(Response.class);

        //Create and test adapter
        RestPostRequestHandlerAdapter<RequestBody> biAdapter = new RestPostRequestHandlerAdapter<>(function, reader);
        DefaultRestResponseBody responseBody = biAdapter.handle(request, response);

        //Check
        assertNotNull(responseBody);

    }



    private static class RequestBody {
    }

}
