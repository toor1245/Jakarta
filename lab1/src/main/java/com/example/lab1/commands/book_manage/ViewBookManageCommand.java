package com.example.lab1.commands.book_manage;

import com.example.lab1.commands.ICommand;
import com.example.lab1.services.BookService;
import com.example.lab1.models.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;

public class ViewBookManageCommand implements ICommand {
    private final BookService _bookService;

    public ViewBookManageCommand(BookService bookService) {
        _bookService = bookService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<Book> books = _bookService.get_books();
        request.setAttribute("books", books);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/book_manage.jsp");
        dispatcher.forward(request, response);
    }
}
