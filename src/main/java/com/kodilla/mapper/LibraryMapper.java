package com.kodilla.mapper;

import com.kodilla.domain.Book;
import com.kodilla.domain.BorrowingBooks;
import com.kodilla.domain.Item;
import com.kodilla.domain.Reader;
import com.kodilla.dto.BookDto;
import com.kodilla.dto.BorrowingBooksDto;
import com.kodilla.dto.ItemDto;
import com.kodilla.dto.ReaderDto;
import org.springframework.stereotype.Service;


@Service
public class LibraryMapper {

    public Book mapToBook (final BookDto bookDto) {
        return new Book(
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getPublicationYear()
        );
    }

    public BookDto mapToBookDto (final Book book) {
        return new BookDto(
                book.getTitle(),
                book.getAuthor(),
                book.getPublicationYear()
        );
    }

    public ItemDto mapToItemDto (final Item item) {
        return new ItemDto(
                item.getBook().getId(),
                item.getItemId(),
                item.getStatus()
        );
    }

    public Reader mapToReader (final ReaderDto readerDto) {
        return new Reader(
                readerDto.getFirstName(),
                readerDto.getLastName()
        );
    }

    public ReaderDto mapToReaderDto (final Reader reader) {
        return new ReaderDto(
                reader.getFirstName(),
                reader.getLastName(),
                reader.getCreationDate()
        );
    }

    public BorrowingBooksDto mapToBorrowingBooksDto (final BorrowingBooks borrowingBooks) {
        return new BorrowingBooksDto(
                borrowingBooks.getReader().getId(),
                borrowingBooks.getItem().getItemId(),
                borrowingBooks.getId(),
                borrowingBooks.isPaymentDamage()
        );
    }

}
