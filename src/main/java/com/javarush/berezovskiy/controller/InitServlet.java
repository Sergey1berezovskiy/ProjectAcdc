package com.javarush.berezovskiy.controller;

import com.javarush.berezovskiy.constants.Constants;
import com.javarush.berezovskiy.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/start")
public class InitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(true);
        req.setAttribute("name", Constants.DEFAULT_USERNAME);
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

}
