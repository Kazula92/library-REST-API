package com.kodilla.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {

    @OneToMany(targetEntity = Item.class, mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Item> items = new ArrayList<>();

    @Id
    @GeneratedValue
    @Column(name= "id")
    private Long id;

    @NotNull
    @Column(name= "title")
    private String title;

    @NotNull
    @Column(name= "author")
    private String author;

    @NotNull
    @Column(name= "publication year")
    private int publicationYear;

    public Book(@NotNull String title, @NotNull String author, @NotNull int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }
}
