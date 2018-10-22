package org.hopto.delow.common;

public class RestResponse {

    private int status;
    private Object responseBody;


    public RestResponse(int status, Object responseBody) {
        this.status = status;
        this.responseBody = responseBody;
    }

    public RestResponse(int status) {
        this(status, "");
    }

    public int getStatus() {
        return status;
    }

    public Object getResponseBody() {
        return responseBody;
    }
}
