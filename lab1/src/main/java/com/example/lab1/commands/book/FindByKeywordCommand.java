package com.example.lab1.commands.book;

import com.example.lab1.commands.ICommand;
import com.example.lab1.services.BookService;
import com.example.lab1.models.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

public class FindByKeywordCommand implements ICommand {
    private final BookService _bookService;

    public FindByKeywordCommand(BookService bookService) {
        _bookService = bookService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        ArrayList<Book> books = _bookService.findByKeyword(keyword);

        request.setAttribute("books", books);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/book.jsp");
        dispatcher.forward(request, response);
    }
}
