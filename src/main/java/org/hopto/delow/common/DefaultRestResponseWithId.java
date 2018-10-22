package org.hopto.delow.common;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class DefaultRestResponseWithId extends DefaultRestResponse {

    private long id;

    public DefaultRestResponseWithId(long id) {
        this.id = id;
    }
}
