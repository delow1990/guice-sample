package org.hopto.delow.configuration;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import org.hopto.delow.client.ClientController;
import org.hopto.delow.client.ClientControllerImpl;
import org.hopto.delow.client.ClientService;
import org.hopto.delow.client.ClientServiceImpl;

public class ClientModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ClientController.class).to(ClientControllerImpl.class).in(Scopes.SINGLETON);
        bind(ClientService.class).to(ClientServiceImpl.class).in(Scopes.SINGLETON);
    }

}
