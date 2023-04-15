package com.example.lab1.commands.book_manage;

import com.example.lab1.commands.ICommand;
import com.example.lab1.services.BookService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteBookCommand implements ICommand {
    private final BookService _bookService;

    public DeleteBookCommand(BookService bookService) {
        _bookService = bookService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int bookId = Integer.parseInt(request.getParameter("id"));
        _bookService.remove(bookId);
        request.setAttribute("books", _bookService.getBooks());
        request.getRequestDispatcher("/WEB-INF/views/book_manage.jsp").forward(request, response);
    }
}
