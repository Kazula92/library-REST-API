package com.kodilla.dto;

import com.kodilla.domain.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class ItemDto {

    private Long bookId;
    private Long itemId;
    private Status status;
}
