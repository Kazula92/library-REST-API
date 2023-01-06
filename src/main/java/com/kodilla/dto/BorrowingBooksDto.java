package com.kodilla.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class BorrowingBooksDto {

    private Long borrowingBooksId;
    private Long itemId;
    private Long readerId;
    private boolean paymentDamage;
}
