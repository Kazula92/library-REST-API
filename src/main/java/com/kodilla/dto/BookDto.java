package com.kodilla.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class BookDto {

    private Long id;
    private String title;
    private String author;
    private int publicationYear;

    public BookDto(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }
}
