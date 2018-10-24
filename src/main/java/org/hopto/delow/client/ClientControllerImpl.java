package org.hopto.delow.client;

import org.apache.commons.lang3.NotImplementedException;
import org.hopto.delow.common.RestResponse;
import org.hopto.delow.common.RestResponseBodyWithId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.Map;

public class ClientControllerImpl implements ClientController {

    private final ClientService clientService;
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Inject
    public ClientControllerImpl(ClientService clientService) {
        this.clientService = clientService;
    }

    public RestResponse handleCreate(ClientCreateRequest request, Map<String, String[]> queryMap, Map<String, String> pathParams) {
        logger.info("Got request for user creation: {} {}", request.getFirstName(), request.getLastName());

        int client = clientService.createClient(request);
        RestResponseBodyWithId response = new RestResponseBodyWithId(client);
        return new RestResponse(200, response);
    }

    @Override
    public RestResponse handleUpdate(ClientCreateRequest request, Map<String, String[]> queryParams, Map<String, String> pathParams) {
        throw new NotImplementedException("");
    }

}
