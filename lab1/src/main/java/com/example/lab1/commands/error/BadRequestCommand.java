package com.example.lab1.commands.error;

import com.example.lab1.commands.ICommand;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BadRequestCommand implements ICommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setStatus(400);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/bad_request.jsp");
        dispatcher.forward(request, response);
    }
}
