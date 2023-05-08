package com.example.lab1;

import com.example.lab1.accessors.BookCommandAccessor;
import com.example.lab1.commands.ICommand;
import com.example.lab1.commands.ServletCommand;

import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
    @EJB
    private BookCommandAccessor _bookCommandAccessor;

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            String servletPath = request.getServletPath();
            ICommand command = _bookCommandAccessor.getHttpGetCommand(servletPath);
            command.execute(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            String servletPath = request.getServletPath();
            ICommand command = _bookCommandAccessor.getHttpPostCommand(servletPath);
            command.execute(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
