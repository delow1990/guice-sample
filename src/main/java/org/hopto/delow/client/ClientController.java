package org.hopto.delow.client;

import org.hopto.delow.common.RestResponse;

import java.util.Set;

public interface ClientController {

    RestResponse handlePost(ClientCreateRequest request, Set<String> strings);
}
