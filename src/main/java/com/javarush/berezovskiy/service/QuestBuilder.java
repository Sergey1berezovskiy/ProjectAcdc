package com.javarush.berezovskiy.service;

import com.javarush.berezovskiy.entity.Quest;
import com.javarush.berezovskiy.entity.QuestForrestStory;
import com.javarush.berezovskiy.entity.User;
import lombok.Getter;

import java.util.Map;

@Getter
public class QuestBuilder {

    private final Map<Integer, Quest> questMap;
    public QuestBuilder(User user){
        questMap = Map.of(
                0, new QuestForrestStory(user),
                1, new QuestForrestStory(user)
        );
    }
}
