package org.hopto.delow.client;

import com.fasterxml.jackson.databind.ObjectReader;
import org.hopto.delow.common.DefaultRestResponseWithId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import spark.Request;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class TestClientController {

    @Mock
    private ClientService service;

    @Mock
    private ObjectReader objectReader;

    @InjectMocks
    private ClientControllerImpl controller;

    @Test
    void testClientController() throws IOException {

        int createdClientId = 1;
        ClientCreateRequest clientCreateRequest = new ClientCreateRequest();

        when(objectReader.readValue(any(byte[].class))).thenReturn(clientCreateRequest);
        when(service.createClient(any(ClientCreateRequest.class))).thenReturn(createdClientId);

//        ClientCreateRequest request = new ClientCreateRequest();


//        DefaultRestResponseWithId defaultRestResponse = controller.handlePost(request);
//        assertEquals(defaultRestResponse.getResponseCode(), 0);
//        assertEquals(defaultRestResponse.getId(), createdClientId);
    }


}
