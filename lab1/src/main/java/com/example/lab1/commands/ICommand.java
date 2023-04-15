package com.example.lab1.commands;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ICommand {
    void execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
