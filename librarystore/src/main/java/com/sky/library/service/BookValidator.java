package com.sky.library.service;

import java.util.Optional;

public class BookValidator {
    private static String PREFIX = "BOOK-";

    public static boolean isValid(Optional<String> bookReference) {
        return bookReference.isPresent() && bookReference.get().startsWith(PREFIX);
    }
}
