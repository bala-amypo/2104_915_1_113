package com.example.demo.servlet;

import jakarta.servlet.http.*;
import java.io.IOException;

public class BasicServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().write("Servlet is running");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setStatus(HttpServletResponse.SC_CREATED);
        resp.getWriter().write("Servlet POST handled");
    }
}
