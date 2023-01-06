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
@Table(name = "borrowing")
public class BorrowingBooks {

    @Id
    @GeneratedValue
    @Column(name= "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Reader.class)
    @JoinColumn(name= "reader_id")
    private Reader reader;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "item_id")
    private Item item;

    @NotNull
    @JoinColumn(name= "Date of borrowing")
    private Date dateOfBorrowing;

    @JoinColumn(name= "Date of return")
    private Date dateOfReturn;

    @JoinColumn(name= "Payment for damage")
    private boolean paymentDamage;

    public BorrowingBooks(Reader reader, Item item) {
        this.reader = reader;
        this.item = item;
        this.dateOfBorrowing = new Date();
        this.dateOfReturn= null;
        this.paymentDamage = false;
    }
}
