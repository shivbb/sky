package com.sky.library.service;

import com.sky.library.exception.BookNotFoundException;
import com.sky.library.model.Book;
import com.sky.library.repo.IBookRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static java.lang.String.format;
import static java.util.Optional.of;

@Service
@Log4j2
public class BookService implements IBookService {

    @Autowired
    IBookRepository bookRepository;

    @Value("${message.invalid.ref}")
    private String msg_invalidRef;

    @Value("${message.book.ref.notfound}")
    private String msg_bookNotFound;


    @Override
    public Book retrieveBook(String bookReference) throws Exception {
        return getBook(bookReference);
    }


    @Override
    public String getBookSummary(String bookReference) {

        return getBook(bookReference).toString();
    }

    private Book getBook(String bookReference) {
        if (!BookValidator.isValid(of(bookReference))) {
            throw new IllegalArgumentException(msg_invalidRef);
        }
        Book byReference = bookRepository.findByReference(format("[%s]", bookReference));
        if (byReference == null) {
            throw new BookNotFoundException(format(msg_bookNotFound, bookReference));
        }
        return byReference;
    }

}
