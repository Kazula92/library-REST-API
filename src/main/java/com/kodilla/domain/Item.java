package com.kodilla.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "item")
public class Item {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name= "book_id")
    private Book book;

    @Id
    @GeneratedValue
    @Column(name= "id")
    private Long itemId;

    @Enumerated
    @Column(name= "status")
    private Status status;

    public Item(Book book) {
        this.book = book;
        this.status = Status.AVAILABLE;
    }
}
