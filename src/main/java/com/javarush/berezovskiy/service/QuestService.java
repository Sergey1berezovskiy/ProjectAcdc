package com.javarush.berezovskiy.service;

import com.javarush.berezovskiy.entity.Quest;

import java.util.Map;

public class QuestService {

    public QuestService(QuestBuilder questBuilder) {
    }

    public String[] writeStory(Quest quest, int step) {
        Map<Integer, String> mainStory = quest.getStoryMap();
        Map<Integer, String> validAnswers = quest.getValidAnswers();
        Map<Integer, String> invalidAnswers = quest.getInvalidAnswers();
        Map<Integer, String> invalidStory = quest.getStoryAfterInvalidVariant();

        return new String[]{
                mainStory.get(step),
                validAnswers.get(step),
                invalidAnswers.get(step),
                invalidStory.get(step)
        };
    }
}
