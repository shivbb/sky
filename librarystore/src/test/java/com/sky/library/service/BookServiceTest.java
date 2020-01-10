package com.sky.library.service;


import com.sky.library.BaseTest;
import com.sky.library.exception.BookNotFoundException;
import com.sky.library.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookServiceTest extends BaseTest {

    public static final String BOOK_999 = "BOOK-999";
    @Autowired
    IBookService iBookService;
    private String msg_invalid_book_ref = "Book reference must begin with 'BOOK-'";
    private String msg_book_not_found = "Book with reference '%s' is not found";

    @Test
    public void test_retrieveBook_with_invalid_text() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            iBookService.retrieveBook("INVALID-TEXT");
        });
        assertTrue(exception.getMessage().contains(msg_invalid_book_ref));

    }

    @Test
    public void test_retrieveBook_which_throws_BookNotFoundException() {
        Exception exception = assertThrows(BookNotFoundException.class, () -> {
            iBookService.retrieveBook(BOOK_999);
        });
        assertTrue(exception.getMessage().contains(format(msg_book_not_found, BOOK_999)));
    }

    @Test
    public void test_retrieveBook() throws Exception {
        Book book = iBookService.retrieveBook("BOOK-GRUFF472");
        assertEquals(book.getReference(), "[BOOK-GRUFF472]");
        assertEquals(book.getTitle(), "The Gruffalo");
    }

    @Test
    public void test_getBookSummary_with_invalid_text() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            iBookService.retrieveBook("INVALID-TEXT");
        });
        assertTrue(exception.getMessage().contains(msg_invalid_book_ref));

    }

    @Test
    public void test_getBookSummary_which_throws_BookNotFoundException() {
        Exception exception = assertThrows(BookNotFoundException.class, () -> {
            iBookService.retrieveBook(BOOK_999);
        });
        assertTrue(exception.getMessage().contains(format(msg_book_not_found, BOOK_999)));
    }

    @Test
    public void test_getBookSummary() throws Exception {

        assertEquals(iBookService.getBookSummary("BOOK-GRUFF472"), "[BOOK-GRUFF472] The Gruffalo - A mouse taking a walk in the woods.");
        assertEquals(iBookService.getBookSummary("BOOK-POOH222"), "[BOOK-POOH222] Winnie The Pooh - In this first volume, we meet all the friends.");
        assertEquals(iBookService.getBookSummary("BOOK-WILL987"), "[BOOK-WILL987] The Wind In The Willows - With the arrival of spring and fine weather outside.");

    }
}
