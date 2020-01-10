package com.sky.library.repo;


import com.sky.library.model.Book;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * This stub returns static data of the Account Info
 */
@Profile("run-with-stub")
@Component
@Log4j2
public class BookRepositoryStub implements IBookRepository {
    private Map<String, Book> booksMap = new HashMap<String, Book>();
    private AtomicInteger idGenerator = new AtomicInteger(0);

    /**
     * Initializes books map
     */

    @PostConstruct
    public void init() {

        List<Book> books = Arrays.asList(
                new Book(idGenerator.incrementAndGet(), "[BOOK-GRUFF472]", "The Gruffalo", "A mouse taking a walk in the woods."),
                new Book(idGenerator.incrementAndGet(), "[BOOK-POOH222]", "Winnie The Pooh", "In this first volume, we meet all the friends."),
                new Book(idGenerator.incrementAndGet(), "[BOOK-WILL987]", "The Wind In The Willows", "With the arrival of spring and fine weather outside.")
        );
        log.info("Initialising BookRepositoryStub");
        this.booksMap = books.stream().collect(
                Collectors.toMap(book -> book.getReference(), book -> book));
    }


    @Override
    public Book findByReference(String reference) {
        return booksMap.get(reference);
    }
}