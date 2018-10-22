package org.hopto.delow.client;

public class ClientServiceImpl implements ClientService {

    private int i = 0;

    @Override
    public int createClient(ClientCreateRequest requestBody) {
        return ++i;
    }
}
