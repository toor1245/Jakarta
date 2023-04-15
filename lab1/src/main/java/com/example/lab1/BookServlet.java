package com.example.lab1;

import com.example.lab1.commands.ICommand;
import com.example.lab1.commands.ServletCommand;
import com.example.lab1.commands.book_manage.*;
import com.example.lab1.commands.book.FindByAuthorCommand;
import com.example.lab1.commands.book.FindByKeywordCommand;
import com.example.lab1.commands.book.FindByTitleCommand;
import com.example.lab1.commands.book.ViewBooksCommand;
import com.example.lab1.services.BookService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "bookServlet", value = {
        ServletCommand.BOOK_VIEW,
        ServletCommand.BOOK_FIND_BY_AUTHOR,
        ServletCommand.BOOK_FIND_BY_TITLE,
        ServletCommand.BOOK_FIND_BY_KEYWORD,
        ServletCommand.BOOK_CREATE,
        ServletCommand.BOOK_UPDATE,
        ServletCommand.BOOK_DELETE,
        ServletCommand.BOOK_MANAGE,
        ServletCommand.BOOK_VIEW_UPDATE
})
public class BookServlet extends HttpServlet {
    private final BookService _bookService = new BookService();
    private Map<String, ICommand> commands;

    @Override
    public void init() {
        commands = new HashMap<>();
        commands.put(ServletCommand.BOOK_VIEW, new ViewBooksCommand(_bookService));
        commands.put(ServletCommand.BOOK_FIND_BY_TITLE, new FindByTitleCommand(_bookService));
        commands.put(ServletCommand.BOOK_FIND_BY_AUTHOR, new FindByAuthorCommand(_bookService));
        commands.put(ServletCommand.BOOK_FIND_BY_KEYWORD, new FindByKeywordCommand(_bookService));
        commands.put(ServletCommand.BOOK_CREATE, new CreateBookCommand(_bookService));
        commands.put(ServletCommand.BOOK_UPDATE, new UpdateBookCommand(_bookService));
        commands.put(ServletCommand.BOOK_DELETE, new DeleteBookCommand(_bookService));
        commands.put(ServletCommand.BOOK_MANAGE, new ViewBookManageCommand(_bookService));
        commands.put(ServletCommand.BOOK_VIEW_UPDATE, new ViewUpdateBookCommand(_bookService));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            String servletPath = request.getServletPath();
            ICommand command = commands.get(servletPath);
            command.execute(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            String servletPath = request.getServletPath();
            ICommand command = commands.get(servletPath);
            command.execute(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
