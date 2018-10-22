package org.hopto.delow.client;

import com.fasterxml.jackson.databind.ObjectReader;
import lombok.Data;
import org.hopto.delow.infrastructure.RequestHandleFunction;
import org.hopto.delow.infrastructure.RequestHandlerAdapter;
import org.hopto.delow.common.RestResponse;
import org.junit.jupiter.api.Test;
import spark.Request;
import spark.Response;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RequestHandlerAdapterTest {

    @Test
    void doTest() throws Exception {

        ObjectReader reader = mock(ObjectReader.class);
        when(reader.readValue(any(byte[].class))).thenReturn(new RequestBody());
//        ObjectReader reader = new ObjectMapper().readerFor(RequestBody.class);
//        byte[] bodyAsBytes = "{\"field\": \"someField\"}".getBytes(StandardCharsets.UTF_8);
        Request request = mock(Request.class);
//        when(request.bodyAsBytes()).thenReturn(bodyAsBytes);
        Response response = mock(Response.class);

        RequestHandleFunction<RequestBody, RestResponse> handleFunction = mock(RequestHandleFunction.class);
        RestResponse restResponse = new RestResponse(200, new ResponseBody());
        when(handleFunction.apply(any(), any())).thenReturn(restResponse);

        RequestHandlerAdapter<RequestBody> adapter = new RequestHandlerAdapter<>(handleFunction, reader);

        Object handle = adapter.handle(request, response);

        assertNotNull(handle);
        assertTrue(handle instanceof ResponseBody);

    }

    @Data
    private static class RequestBody {

        private String field;

    }

    private static class ResponseBody {
    }

}
