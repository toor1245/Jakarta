package com.example.lab1.commands.book;

import com.example.lab1.commands.ICommand;
import com.example.lab1.services.BookService;
import com.example.lab1.models.Book;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;

public class ViewBooksCommand implements ICommand {
    private BookService _bookService;

    public ViewBooksCommand(BookService bookService) {
        _bookService = bookService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<Book> books = _bookService.get_books();
        request.setAttribute("books", books);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/book.jsp");
        dispatcher.forward(request, response);
    }
}
