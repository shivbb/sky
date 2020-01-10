package com.sky.library.repo;

import com.sky.library.model.Book;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

@Profile("run-with-repo")
public interface BookRepository extends JpaRepository<Book, Long>, IBookRepository {
    Book findByReference(String title);
}
