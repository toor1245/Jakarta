package com.example.lab1.services;

import com.example.lab1.view_models.BookViewModel;
import jakarta.ejb.Singleton;

import java.util.ArrayList;

@Singleton
public class BookService {
    private static int _id;
    public static final ArrayList<BookViewModel> books = new ArrayList<>();

    public BookViewModel getById(int id) {
        for (BookViewModel current : books) {
            if (id == current.get_id()) {
                return current;
            }
        }
        return null;
    }

    public void add(BookViewModel book) {
        book.set_id(_id++);
        books.add(book);
    }

    public void remove(int id) {
        for (int i = 0; i < books.size(); i++) {
            if (id == books.get(i).get_id()) {
                books.remove(i);
                break;
            }
        }
    }

    public void update(int id, BookViewModel book) {
        for (BookViewModel current : books) {
            if (id == current.get_id()) {
                current.set_title(book.get_title());
                current.set_author(book.get_author());
                break;
            }
        }
    }

    public ArrayList<BookViewModel> getBooks() {
        return books;
    }

    public BookViewModel findByTitle(String title) {
        for (BookViewModel current : books) {
            if (current.get_title().equals(title)) {
                return current;
            }
        }
        return null;
    }

    public ArrayList<BookViewModel> findByKeyword(String keyword) {
        ArrayList<BookViewModel> booksByKeyword = new ArrayList<>();
        for (BookViewModel current : books) {
            if (current.get_title().contains(keyword)) {
                booksByKeyword.add(current);
            }
        }
        return booksByKeyword;
    }

    public BookViewModel findByAuthor(String author) {
        for (BookViewModel current : books) {
            if (current.get_author().get_fullName().contains(author)) {
                return current;
            }
        }
        return null;
    }
}
