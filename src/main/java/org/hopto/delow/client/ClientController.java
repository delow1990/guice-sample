package org.hopto.delow.client;

import org.hopto.delow.common.RestResponse;

import java.util.Map;

public interface ClientController {

    RestResponse handleCreate(ClientCreateRequest request, Map<String, String[]> queryParams, Map<String, String> pathParams);

    RestResponse handleUpdate(ClientCreateRequest request, Map<String, String[]> queryParams, Map<String, String> pathParams);


}
