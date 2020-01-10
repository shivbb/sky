package com.sky.library.repo;

import com.sky.library.model.Book;

public interface IBookRepository {
    Book findByReference(String reference);
}
