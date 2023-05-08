package com.example.lab1;

import java.io.*;
import java.util.HashMap;

import com.example.lab1.models.Student;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    private static final HashMap<String, Student> students = new HashMap<>();

    static {
        students.put("mhohsadze", new Student("Mykola Hohsadze  IO-21mn", "https://i.stack.imgur.com/GsDIl.jpg"));
        students.put("dtymochko", new Student("Dmytro Tymochko  IO-21mn", "https://i.stack.imgur.com/GsDIl.jpg"));
        students.put("dsolovyov", new Student("Daniil Solovyov  IO-21mn", "https://i.stack.imgur.com/GsDIl.jpg"));
        students.put("vdiachenko", new Student("Vladyslav Diachenko  IO-21mp", "https://i.stack.imgur.com/GsDIl.jpg"));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String student = request.getParameter("student");
        Student studentViewModel = students.get(student);

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + studentViewModel.get_name() + "</h1>");
        out.println("<img src='" + studentViewModel.get_imageUrl() + "' width='300' height='250'/>");
        out.println("<br/>");
        out.println("<a href='" + request.getContextPath() + "'>Move to Home page</a>");
        out.println("</body></html>");
    }

    public void init() {
    }

    public void destroy() {
    }
}