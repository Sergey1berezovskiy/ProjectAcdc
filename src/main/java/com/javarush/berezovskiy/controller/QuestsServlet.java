package com.javarush.berezovskiy.controller;

import com.javarush.berezovskiy.entity.Quest;
import com.javarush.berezovskiy.entity.User;
import com.javarush.berezovskiy.service.QuestBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/quest")
public class QuestsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        String name = req.getParameter("name");
        User user = new User(name);
        QuestBuilder questBuilder = new QuestBuilder(user);
        Map<Integer, Quest> questMap = questBuilder.getQuestMap();
        List<String> questNames = new ArrayList<>();
        for(Map.Entry<Integer, Quest> integerQuestEntry : questMap.entrySet()) {
            String questName = integerQuestEntry.getValue().getQuestName();
            questNames.add(questName);
        }
        req.setAttribute("questNames", questNames);

        getServletContext().getRequestDispatcher("/quest.jsp").forward(req,resp);
    }
}
