package com.kodilla.repository;

import com.kodilla.domain.Book;
import com.kodilla.domain.BorrowingBooks;
import com.kodilla.domain.Item;
import com.kodilla.domain.Reader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LibraryRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BorrowingBooksRepository borrowingBooksRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ReaderRepository readerRepository;

    @Test
    void testBookRepository() {
        //Given
        Book book= new Book("Title1", "Author1", 1994);

        //When
        bookRepository.save(book);
        long id= book.getId();

        //Then
        assertEquals(0, id);

        //CleanUp
        bookRepository.delete(book);
    }

    @Test
    void testItemRepository() {
        //Given
        Book book= new Book("Title1", "Author1", 1994);
        Item item= new Item(book);

        //When
        itemRepository.save(item);
        long id= item.getItemId();

        //Then
        assertEquals(0, id);

        //CleanUp
        itemRepository.delete(item);
    }

    @Test
    void testReaderRepository() {
        //Given
        Reader reader= new Reader("Andrzej", "Sapkowski");

        //When
        readerRepository.save(reader);
        long id= reader.getId();

        //Then
        assertEquals(0, id);

        //CleanUp
        readerRepository.delete(reader);
    }

    @Test
    void testBorrowingBooksRepository() {
        //Given
        Book bookA= new Book("TitleA", "AuthorA", 2000);
        Book bookB= new Book ("TitleB", "AuthorB", 2002);
        Book bookC= new Book("TitleC", "AuthorC", 2005);
        Item itemA= new Item(bookA);
        Item itemB= new Item(bookB);
        Item itemC= new Item(bookC);
        Reader readerX= new Reader("Xavier", "Borion");
        Reader readerY= new Reader("Andrzej", "Sapkowski");
        BorrowingBooks borrowingBooks1= new BorrowingBooks(readerX, itemA);
        BorrowingBooks borrowingBooks2= new BorrowingBooks(readerX, itemB);
        BorrowingBooks borrowingBooks3= new BorrowingBooks(readerY, itemC);
        readerX.getReadersBorrowings().add(borrowingBooks1);
        readerX.getReadersBorrowings().add(borrowingBooks2);
        readerY.getReadersBorrowings().add(borrowingBooks3);

        //When
        borrowingBooksRepository.save(borrowingBooks1);
        long id1= borrowingBooks1.getId();
        borrowingBooksRepository.save(borrowingBooks2);
        long id2= borrowingBooks2.getId();
        borrowingBooksRepository.save(borrowingBooks3);
        long id3= borrowingBooks3.getId();

        //Then
        assertEquals(0, id1);
        assertEquals(0, id2);
        assertEquals(0, id3);

        //CleanUp
        borrowingBooksRepository.delete(borrowingBooks1);
        borrowingBooksRepository.delete(borrowingBooks2);
        borrowingBooksRepository.delete(borrowingBooks3);
    }
}
