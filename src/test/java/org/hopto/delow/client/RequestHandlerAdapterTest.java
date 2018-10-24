package org.hopto.delow.client;

import com.fasterxml.jackson.databind.ObjectReader;
import lombok.Data;
import org.hopto.delow.common.DefaultRestResponseBody;
import org.hopto.delow.infrastructure.RequestHandleFunction;
import org.hopto.delow.infrastructure.RequestHandlerAdapter;
import org.hopto.delow.common.RestResponse;
import org.junit.jupiter.api.Test;
import spark.QueryParamsMap;
import spark.Request;
import spark.Response;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RequestHandlerAdapterTest {

    @Test
    void doTest() throws Exception {

        //Init mocks...
        RequestHandleFunction<RequestBody, RestResponse> handleFunction = mock(RequestHandleFunction.class);
        RestResponse restResponse = RestResponse.ok();
        when(handleFunction.apply(any(), any(), any())).thenReturn(restResponse);

        ObjectReader reader = mock(ObjectReader.class);

        Request request = mock(Request.class);
        QueryParamsMap queryParamsMap = mock(QueryParamsMap.class);
        when(request.queryMap()).thenReturn(queryParamsMap);

        Response response = mock(Response.class);

        //Create and test adapter
        RequestHandlerAdapter<RequestBody> adapter = new RequestHandlerAdapter<>(handleFunction, reader);
        DefaultRestResponseBody responseBody = adapter.handle(request, response);

        //Check
        assertNotNull(responseBody);

    }

    private static class RequestBody {
    }

}
