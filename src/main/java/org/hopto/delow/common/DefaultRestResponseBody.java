package org.hopto.delow.common;

import lombok.Data;

@Data
public class DefaultRestResponseBody {

    private static final String DEFAULT_RESPONSE_MESSAGE = "";

    private int responseCode = 0;

    private String responseMessage = DEFAULT_RESPONSE_MESSAGE;

}
