package com.example.lab1.models;

public class Book {
    private long id;
    private String title;
    private Author author;

    public long get_id() {
        return id;
    }

    public void set_id(long id) {
        this.id = id;
    }

    public String get_title() {
        return title;
    }

    public void set_title(String title) {
        this.title = title;
    }

    public Author get_author() {
        return author;
    }

    public void set_author(Author author) {
        this.author = author;
    }

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    public Book(long _id, String title) {
        this.id = _id;
        this.title = title;
    }
}
