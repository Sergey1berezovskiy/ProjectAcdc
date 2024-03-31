package com.javarush.berezovskiy.service;

import com.javarush.berezovskiy.entity.Quest;

import java.util.HashMap;
import java.util.Map;

public class QuestService {

    private final QuestBuilder questBuilder;
    public QuestService(QuestBuilder questBuilder){
        this.questBuilder = questBuilder;
    }
    public Map<Integer, Quest> showQuests(){
        return questBuilder.getQuestMap();
    }

    public Map<Integer, String[]> writeStory(Quest quest, int step){
        Map<Integer, String> mainStory = quest.getStoryMap();
        Map<Integer, String> validAnswers = quest.getValidAnswers();
        Map<Integer, String> invalidAnswers = quest.getInvalidAnswers();
        Map<Integer, String> invalidStory = quest.getStoryAfterInvalidVariant();

        String[] stringArray = new String[]{
                mainStory.get(step),
                validAnswers.get(step),
                invalidAnswers.get(step),
                invalidStory.get(step)
        };
        return Map.of(step,stringArray);
    }
}
