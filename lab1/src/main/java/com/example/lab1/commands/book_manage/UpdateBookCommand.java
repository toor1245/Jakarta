package com.example.lab1.commands.book_manage;

import com.example.lab1.commands.ICommand;
import com.example.lab1.services.BookService;
import com.example.lab1.models.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateBookCommand implements ICommand {
    private final BookService _bookService;

    public UpdateBookCommand(BookService bookService) {
        _bookService = bookService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // Get request parameters
        int bookId = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");

        // Update book by id
        Book book = new Book(bookId, title);
        _bookService.update(bookId, book);

        // Set attributes for page
        request.setAttribute("id", book.get_id());
        request.setAttribute("title", book.get_title());

        // Forward to update_book page with new parameters
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/update_book.jsp");
        dispatcher.forward(request, response);
    }
}
