package com.kodilla.service;

import com.kodilla.domain.*;
import com.kodilla.dto.BookDto;
import com.kodilla.dto.BorrowingBooksDto;
import com.kodilla.dto.ItemDto;
import com.kodilla.dto.ReaderDto;
import com.kodilla.mapper.LibraryMapper;
import com.kodilla.repository.BookRepository;
import com.kodilla.repository.BorrowingBooksRepository;
import com.kodilla.repository.ItemRepository;
import com.kodilla.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DbService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ReaderRepository readerRepository;
    @Autowired
    private BorrowingBooksRepository borrowingBooksRepository;
    @Autowired
    private LibraryMapper libraryMapper;

    public BookDto saveBook (final BookDto bookDto) {
        Book book= libraryMapper.mapToBook(bookDto);
        bookRepository.save(book);
        return libraryMapper.mapToBookDto(book);
    }

    public ItemDto saveItem (final ItemDto itemDto) {
        Book book = getBookById(itemDto.getBookId());
        Item item = new Item(book);
        itemRepository.save(item);
        return libraryMapper.mapToItemDto(item);
    }

    public ItemDto updateStatus (final ItemDto itemDto) {
        Item item= getItemById(itemDto.getItemId());
        Book book= getBookById(itemDto.getBookId());
        Status status= itemDto.getStatus();
        item.setStatus(status);
        item.setBook(book);
        itemRepository.save(item);
        return libraryMapper.mapToItemDto(item);
    }

    public ReaderDto saveReader (final ReaderDto readerDto) {
        Reader reader= libraryMapper.mapToReader(readerDto);
        readerRepository.save(reader);
        return libraryMapper.mapToReaderDto(reader);
    }

    public BorrowingBooksDto saveBorrowingBooks (final BorrowingBooksDto borrowingBooksDto) {
        Reader reader= getReaderById(borrowingBooksDto.getReaderId());
        Item item= getItemById(borrowingBooksDto.getItemId());
        BorrowingBooks borrowingBooks= new BorrowingBooks(reader, item);
        borrowingBooks.setDateOfBorrowing(new Date());
        borrowingBooksRepository.save(borrowingBooks);
        return libraryMapper.mapToBorrowingBooksDto(borrowingBooks);
    }

    public BorrowingBooksDto returnBook (final BorrowingBooksDto borrowingBooksDto) {
        BorrowingBooks borrowingBooks= getBorrowingBooksById(borrowingBooksDto.getBorrowingBooksId());
        borrowingBooks.setDateOfReturn(new Date());
        if (borrowingBooksDto.isPaymentDamage()) {
            borrowingBooks.getItem().setStatus(Status.AVAILABLE);
            borrowingBooks.setPaymentDamage(true);
        }
        borrowingBooksRepository.save(borrowingBooks);
        return libraryMapper.mapToBorrowingBooksDto(borrowingBooks);
    }

    public Book getBookById(final Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Reader getReaderById(final Long id) {
        return readerRepository.findById(id).orElse(null);
    }

    public Item getItemById(final Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public BorrowingBooks getBorrowingBooksById(final Long id) {
        return borrowingBooksRepository.findById(id).orElse(null);
    }
}
