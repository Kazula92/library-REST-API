package com.kodilla.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "readers")
public class Reader {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "reader")
    private List<BorrowingBooks> readersBorrowings = new ArrayList<>();

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
