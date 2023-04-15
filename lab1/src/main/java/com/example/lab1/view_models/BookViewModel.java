package com.example.lab1.view_models;

public class BookViewModel {
    private long id;
    private String title;
    private AuthorViewModel author;

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

    public AuthorViewModel get_author() {
        return author;
    }

    public void set_author(AuthorViewModel author) {
        this.author = author;
    }

    public BookViewModel(String title, AuthorViewModel author) {
        this.title = title;
        this.author = author;
    }

    public BookViewModel(long _id, String title) {
        this.id = _id;
        this.title = title;
    }
}
