package org.hopto.delow.common;

public class RestResponse {

    private int status;
    private DefaultRestResponseBody responseBody;

    public RestResponse(int status, DefaultRestResponseBody responseBody) {
        this.status = status;
        this.responseBody = responseBody;
    }

    public int getStatus() {
        return status;
    }

    public DefaultRestResponseBody getResponseBody() {
        return responseBody;
    }

    public static RestResponse ok() {
        return new RestResponse(200, new DefaultRestResponseBody());
    }
}
