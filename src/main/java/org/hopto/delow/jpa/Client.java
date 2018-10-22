package org.hopto.delow.jpa;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Client")
@Data
public class Client {

    @Id
    @GeneratedValue(generator = "clientIdSequence")
    @SequenceGenerator(name = "clientIdSequence", initialValue = 50)
    long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String middleName;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private LocalDate birthday;

    @Column
    private String phoneNumber;

    @Column
//    @Email
    private String email;

    @Column(nullable = false)
    private boolean active = true;

}
