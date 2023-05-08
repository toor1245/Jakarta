package com.example.lab1.accessors;

import com.example.lab1.commands.ServletCommand;
import com.example.lab1.commands.book.FindByAuthorCommand;
import com.example.lab1.commands.book.FindByKeywordCommand;
import com.example.lab1.commands.book.FindByTitleCommand;
import com.example.lab1.commands.book.ViewBooksCommand;
import com.example.lab1.commands.book_manage.*;
import com.example.lab1.services.BookService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class BookCommandAccessor extends HttpCommandAccessor {
    @EJB
    private BookService _bookService;

    @PostConstruct
    public void init() {
        this.registerHttpGetCommand(ServletCommand.BOOK_VIEW, new ViewBooksCommand(_bookService));
        this.registerHttpGetCommand(ServletCommand.BOOK_FIND_BY_TITLE, new FindByTitleCommand(_bookService));
        this.registerHttpGetCommand(ServletCommand.BOOK_FIND_BY_AUTHOR, new FindByAuthorCommand(_bookService));
        this.registerHttpGetCommand(ServletCommand.BOOK_FIND_BY_KEYWORD, new FindByKeywordCommand(_bookService));
        this.registerHttpGetCommand(ServletCommand.BOOK_MANAGE, new ViewBookManageCommand(_bookService));
        this.registerHttpGetCommand(ServletCommand.BOOK_VIEW_UPDATE, new ViewUpdateBookCommand(_bookService));
        this.registerHttpPostCommand(ServletCommand.BOOK_CREATE, new CreateBookCommand(_bookService));
        this.registerHttpPostCommand(ServletCommand.BOOK_UPDATE, new UpdateBookCommand(_bookService));
        this.registerHttpGetCommand(ServletCommand.BOOK_DELETE, new DeleteBookCommand(_bookService));
    }
}
