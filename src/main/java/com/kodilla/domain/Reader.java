package com.kodilla.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "reader")
public class Reader {

    @Id
    @GeneratedValue
    @Column(name= "id")
    private Long id;

    @NotNull
    @Column(name= "first_name")
    private String firstName;

    @NotNull
    @Column(name= "last_name")
    private String lastName;

    @Column(name= "creation_date")
    private Date creationDate;

    public Reader(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
