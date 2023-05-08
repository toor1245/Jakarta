package com.example.lab1.commands.book_manage;

import com.example.lab1.commands.ICommand;
import com.example.lab1.services.BookService;
import com.example.lab1.models.Author;
import com.example.lab1.models.Book;
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
        Author authorViewModel = new Author(_authorId++, author);
        Book book = new Book(title, authorViewModel);
        _bookService.add(book);

        // Set _books attribute and forward to book manage page
        request.setAttribute("books", _bookService.get_books());
        request.getRequestDispatcher("/WEB-INF/views/book_manage.jsp").forward(request, response);
    }
}
