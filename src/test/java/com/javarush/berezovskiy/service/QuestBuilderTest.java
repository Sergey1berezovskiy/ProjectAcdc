package com.javarush.berezovskiy.service;

import com.javarush.berezovskiy.entity.Quest;
import com.javarush.berezovskiy.entity.QuestForrestStory;
import com.javarush.berezovskiy.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class QuestBuilderTest {
    private QuestBuilder questBuilder;
    private User mockUser;
    private QuestBuilder mockQuestBuilder;

    @BeforeEach
    void setUp() {
        mockUser = Mockito.mock(User.class);
        mockQuestBuilder = Mockito.mock(QuestBuilder.class);
        questBuilder = new QuestBuilder(mockUser);
    }

    @Test
    void WhenGetQuestMap_ThenGetNotNull(){
        assertNotNull(questBuilder.getQuestMap());
    }

    @Test
    void WhetGetQuestMap_ThenMapNotEmpty(){
        assertFalse(questBuilder.getQuestMap().isEmpty());
    }

    @Test
    void whenGetQuestMapSize_ThenGetCorrectValue(){
        Quest forrestQuest = new QuestForrestStory(mockUser);
        Mockito.when(mockQuestBuilder.getQuestMap()).thenReturn(Map.of(0,forrestQuest));
        int mapSize = mockQuestBuilder.getQuestMap().size();
        assertEquals(1, mapSize);
    }

    @Test
    void WhenUserGetName_ThenGetCorrectName(){
        User user = new User("Petr");
        String name = "Petr";
        assertEquals(name, user.getName());
    }

    @Test
    void WhenGetUser_ThenGetCorrectUser() {
        Quest quest = questBuilder.getQuestMap().get(0);
        assertSame(quest.getUser(), mockUser);
    }
}