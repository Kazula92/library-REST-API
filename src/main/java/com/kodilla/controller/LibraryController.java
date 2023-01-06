package com.kodilla.controller;

import com.kodilla.dto.BookDto;
import com.kodilla.dto.BorrowingBooksDto;
import com.kodilla.dto.ItemDto;
import com.kodilla.dto.ReaderDto;
import com.kodilla.mapper.LibraryMapper;
import com.kodilla.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/tasks")
@RequiredArgsConstructor
public class LibraryController {

    private final LibraryMapper libraryMapper;
    private final DbService dbService;

    @RequestMapping(method = RequestMethod.POST, value = "createBook", consumes = APPLICATION_JSON_VALUE)
    public BookDto createBook(@RequestBody BookDto bookDto) {
        return dbService.saveBook(bookDto);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createReader", consumes = APPLICATION_JSON_VALUE)
    public ReaderDto createReader(@RequestBody ReaderDto readerDto) {
        return dbService.saveReader(readerDto);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createItem", consumes = APPLICATION_JSON_VALUE)
    public ItemDto createItem(@RequestBody ItemDto itemDto) {
        return dbService.saveItem(itemDto);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBorrowing", consumes = APPLICATION_JSON_VALUE)
    public BorrowingBooksDto createBorrowing(@RequestBody BorrowingBooksDto borrowingBooksDto) {
        return dbService.saveBorrowingBooks(borrowingBooksDto);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateStatus")
    public ItemDto updateStatus(@RequestBody ItemDto itemDto) {
        return dbService.updateStatus(itemDto);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "returnBook")
    public BorrowingBooksDto returnBook(@RequestBody BorrowingBooksDto borrowingBooksDto) {
        return dbService.returnBook(borrowingBooksDto);
    }

}
