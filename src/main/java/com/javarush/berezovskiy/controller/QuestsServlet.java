package com.javarush.berezovskiy.controller;

import com.javarush.berezovskiy.entity.Quest;
import com.javarush.berezovskiy.entity.User;
import com.javarush.berezovskiy.service.QuestBuilder;
import com.javarush.berezovskiy.service.QuestService;
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
    private QuestService questService;
    private Quest quest;
    private String questName;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        String name = req.getParameter("name");
        User user = new User(name);
        QuestBuilder questBuilder = new QuestBuilder(user);
        nullQuestService();

        Map<Integer, Quest> questMap = questBuilder.getQuestMap();
        List<String> questNames = getQuestNames(questMap);
        int stepOfQuest = -1;

        httpSession.setAttribute("stepOfQuest", stepOfQuest);
        httpSession.setAttribute("questBuilder", questBuilder);
        req.setAttribute("questNames", questNames);
        req.setAttribute("stepOfQuest", stepOfQuest);

        getServletContext().getRequestDispatcher("/quest.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        QuestBuilder questBuilder = (QuestBuilder) httpSession.getAttribute("questBuilder");
        questName = req.getParameter("questNames");
        if (questService == null) {
            httpSession.setAttribute("stepOfQuest", 0);
            httpSession.setAttribute("questNames", questName);
            questService = new QuestService(questBuilder);
            int questNumber = getQuestNumber(questBuilder);
            quest = getQuest(questBuilder, questNumber);//проверка какой квест
        }

        int stepOfQuest = getStepOfQuest(httpSession);
        int questSize = getQuestSize();

        String[] questVariants = questService.writeStory(quest, stepOfQuest);
        req.setAttribute("story", questVariants[0]);
        if(questSize != stepOfQuest ) {
            req.setAttribute("validAnswer", questVariants[1]);
            req.setAttribute("invalidAnswer", questVariants[2]);
            req.setAttribute("invalidStory", questVariants[3]);
        }
        stepOfQuest++;

        httpSession.setAttribute("stepOfQuest", stepOfQuest);
        getServletContext().getRequestDispatcher("/quest.jsp").forward(req, resp);


    }

    private int getQuestSize() {
        return quest.getStoryMap().size() - 1;
    }

    private static Quest getQuest(QuestBuilder questBuilder, int questNumber) {
        return questBuilder.getQuestMap().get(questNumber);
    }
    private static int getStepOfQuest(HttpSession httpSession) {
        return (int) httpSession.getAttribute("stepOfQuest");
    }

    private int getQuestNumber(QuestBuilder questBuilder) {
        int questNumber = 0;
        for (Map.Entry<Integer, Quest> integerQuestEntry : questBuilder.getQuestMap().entrySet()) {
            if(integerQuestEntry.getValue().getQuestName().equals(questName)){
                questNumber = integerQuestEntry.getKey();
            }
        }
        return questNumber;
    }
    private static List<String> getQuestNames(Map<Integer, Quest> questMap) {
        List<String> questNames = new ArrayList<>();
        for (Map.Entry<Integer, Quest> integerQuestEntry : questMap.entrySet()) {
            String questName = integerQuestEntry.getValue().getQuestName();
            questNames.add(questName);
        }
        return questNames;
    }
    private void nullQuestService() {
        if(questService != null){
            questService = null;
        }
    }
}
