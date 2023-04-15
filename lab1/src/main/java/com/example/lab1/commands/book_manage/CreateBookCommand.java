package com.example.lab1.commands.book_manage;

import com.example.lab1.commands.ICommand;
import com.example.lab1.services.BookService;
import com.example.lab1.view_models.AuthorViewModel;
import com.example.lab1.view_models.BookViewModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CreateBookCommand implements ICommand {
    private final BookService _bookService;
    private static int _authorId = 0;

    public CreateBookCommand(BookService bookService) {
        _bookService = bookService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Get request parameters
        String title = request.getParameter("title");
        String author = request.getParameter("author");

        // Store models into book service
        AuthorViewModel authorViewModel = new AuthorViewModel(_authorId++, author);
        BookViewModel bookViewModel = new BookViewModel(title, authorViewModel);
        _bookService.add(bookViewModel);

        // Set books attribute and forward to book manage page
        request.setAttribute("books", _bookService.getBooks());
        request.getRequestDispatcher("/WEB-INF/views/book_manage.jsp").forward(request, response);
    }
}
