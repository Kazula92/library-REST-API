package com.kodilla.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ReaderDto {

    private String firstName;
    private String lastName;
    private Date creationDate;
}
