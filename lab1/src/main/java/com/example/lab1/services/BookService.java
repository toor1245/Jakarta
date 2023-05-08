package com.example.lab1.services;

import com.example.lab1.models.Book;
import jakarta.ejb.Singleton;

import java.util.ArrayList;

@Singleton
public class BookService {
    private int _id;
    public ArrayList<Book> _books = new ArrayList<>();

    public Book getById(int id) {
        for (Book current : _books) {
            if (id == current.get_id()) {
                return current;
            }
        }
        return null;
    }

    public void add(Book book) {
        book.set_id(_id++);
        _books.add(book);
    }

    public void remove(int id) {
        for (int i = 0; i < _books.size(); i++) {
            if (id == _books.get(i).get_id()) {
                _books.remove(i);
                break;
            }
        }
    }

    public void update(int id, Book book) {
        for (Book current : _books) {
            if (id == current.get_id()) {
                current.set_title(book.get_title());
                current.set_author(book.get_author());
                break;
            }
        }
    }

    public ArrayList<Book> get_books() {
        return _books;
    }

    public ArrayList<Book> findByTitle(String title) {
        ArrayList<Book> booksByTitle = new ArrayList<>();
        for (Book current : _books) {
            if (current.get_title().equals(title)) {
                booksByTitle.add(current);
            }
        }
        return booksByTitle;
    }

    public ArrayList<Book> findByKeyword(String keyword) {
        ArrayList<Book> booksByKeyword = new ArrayList<>();
        for (Book current : _books) {
            if (current.get_title().contains(keyword)) {
                booksByKeyword.add(current);
            }
        }
        return booksByKeyword;
    }

    public ArrayList<Book> findByAuthor(String author) {
        ArrayList<Book> booksByAuthor = new ArrayList<>();
        for (Book current : _books) {
            if (current.get_author().get_fullName().contains(author)) {
                booksByAuthor.add(current);
            }
        }
        return booksByAuthor;
    }
}
