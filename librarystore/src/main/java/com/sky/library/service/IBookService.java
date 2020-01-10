package com.sky.library.service;

import com.sky.library.model.Book;

public interface IBookService {

    Book retrieveBook(String bookReference) throws Exception;

    String getBookSummary(String s);
}
