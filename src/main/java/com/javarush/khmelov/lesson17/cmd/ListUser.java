package com.javarush.khmelov.lesson17.cmd;

import com.javarush.khmelov.lesson17.entity.User;
import com.javarush.khmelov.lesson17.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collection;

public class ListUser implements Command {
    private final UserService userService;

    public ListUser(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<User> users = userService.getAll();
        req.setAttribute("users", users);
        return getJspPage();
    }
}