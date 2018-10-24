package org.hopto.delow;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.hopto.delow.client.ClientController;
import org.hopto.delow.client.ClientCreateRequest;
import org.hopto.delow.configuration.ClientModule;
import org.hopto.delow.configuration.InfrastructureModule;
import org.hopto.delow.infrastructure.RequestHandlerAdapter;

import static spark.Spark.post;

public class Application {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new InfrastructureModule(), new ClientModule());

        ClientController clientController = injector.getInstance(ClientController.class);

        ObjectMapper mapper = injector.getInstance(ObjectMapper.class);

        ObjectWriter writer = injector.getInstance(ObjectWriter.class);

        RequestHandlerAdapter<ClientCreateRequest> clientCreateAdapter = new RequestHandlerAdapter<>(clientController::handleCreate, mapper.readerFor(ClientCreateRequest.class));

        post("/client", clientCreateAdapter, writer::writeValueAsString);

    }

}
