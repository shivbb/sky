package com.sky.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

import static java.lang.String.format;

@Data
@AllArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, unique = true)
    private String reference;

    @Column
    private String title;

    @Column
    private String summary;

    @Override
    public String toString() {
        return format("%s %s - %s", reference, title, summary);
    }
}
