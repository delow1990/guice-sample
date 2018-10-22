package org.hopto.delow.client;

import org.hopto.delow.common.DefaultRestResponseWithId;
import org.hopto.delow.common.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.Set;

public class ClientControllerImpl implements ClientController {

    private final ClientService clientService;
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Inject
    public ClientControllerImpl(ClientService clientService) {
        this.clientService = clientService;
    }

    public RestResponse handlePost(ClientCreateRequest request, Set<String> strings) {
        logger.info("Got request for user creation: {} {}", request.getFirstName(), request.getLastName());

        int client = clientService.createClient(request);
        DefaultRestResponseWithId response = new DefaultRestResponseWithId(client);
        return new RestResponse(200, response);
    }

}
