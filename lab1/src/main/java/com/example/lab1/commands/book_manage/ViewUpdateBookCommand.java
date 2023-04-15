package com.example.lab1.commands.book_manage;

import com.example.lab1.commands.ICommand;
import com.example.lab1.services.BookService;
import com.example.lab1.view_models.BookViewModel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewUpdateBookCommand implements ICommand {

    private final BookService _bookService;

    public ViewUpdateBookCommand(BookService _bookService) {
        this._bookService = _bookService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int bookId = Integer.parseInt(request.getParameter("id"));
        BookViewModel book = _bookService.getById(bookId);
        request.setAttribute("id", bookId);
        request.setAttribute("title", book.get_title());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/update_book.jsp");
        dispatcher.forward(request, response);
    }
}
