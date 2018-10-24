package org.hopto.delow.common;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class RestResponseBodyWithId extends DefaultRestResponseBody {

    private long id;

    public RestResponseBodyWithId(long id) {
        this.id = id;
    }
}
