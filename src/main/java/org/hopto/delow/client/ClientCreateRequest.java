package org.hopto.delow.client;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientCreateRequest {

    private String firstName;

    private String lastName;

    private String middleName;

    private String email;

    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate birthday;

    private String phoneNumber;

}
