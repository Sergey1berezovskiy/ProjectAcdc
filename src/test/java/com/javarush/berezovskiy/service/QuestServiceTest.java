package com.javarush.berezovskiy.service;

import com.javarush.berezovskiy.entity.Quest;
import com.javarush.berezovskiy.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class QuestServiceTest {
    private QuestService questService;
    private Quest mockQuest;
    private User mockUser;
    private String story = "Story 1";
    private String validAnswer = "Valid Answer 1";
    private String invalidAnswer = "Invalid Answer 1";
    private String invalidStory = "Invalid Story 1";
    private int storyStep = 1;

    @BeforeEach
    public void setUp() {
        mockQuest = Mockito.mock(Quest.class);
        mockUser = Mockito.mock(User.class);
        questService = new QuestService(new QuestBuilder(mockUser));
    }

    @Test
    void whenGetStoryMap_ThenGetCorrectStory() {
        Map<Integer, String> mockStoryMap = new HashMap<>();
        mockStoryMap.put(storyStep, story);
        Mockito.when(mockQuest.getStoryMap()).thenReturn(mockStoryMap);
        String getStory = mockQuest.getStoryMap().get(storyStep);
        assertEquals(story, getStory);
    }

    @Test
    void whenGetValidAnswer_ThenGetCorrectValidAnswer() {
        Map<Integer, String> mockValidAnswerMap = new HashMap<>();
        mockValidAnswerMap.put(storyStep, validAnswer);
        Mockito.when(mockQuest.getValidAnswers()).thenReturn(mockValidAnswerMap);
        String getValidAnswer = mockQuest.getValidAnswers().get(storyStep);
        assertEquals(validAnswer, getValidAnswer);
    }

    @Test
    void whenGetInvalidAnswer_ThenGetCorrectInvalidAnswer() {
        Map<Integer, String> mockInvalidAnswerMap = new HashMap<>();
        mockInvalidAnswerMap.put(storyStep, invalidAnswer);
        Mockito.when(mockQuest.getInvalidAnswers()).thenReturn(mockInvalidAnswerMap);
        String getInvalidAnswer = mockQuest.getInvalidAnswers().get(storyStep);
        assertEquals(invalidAnswer, getInvalidAnswer);

    }

    @Test
    void whenGetInvalidStory_ThenGetCorrectInvalidStory() {
        Map<Integer, String> invalidStoryMap = new HashMap<>();
        invalidStoryMap.put(storyStep, invalidStory);
        Mockito.when(mockQuest.getStoryAfterInvalidVariant()).thenReturn(invalidStoryMap);
        String getInvalidStory = mockQuest.getStoryAfterInvalidVariant().get(storyStep);
        assertEquals(invalidStory, getInvalidStory);

    }

    @Test
    void whenWriteStory_ThenGetStoryFromStringArray() {
        Map<Integer, String> mockStoryMap = new HashMap<>();
        mockStoryMap.put(storyStep, story);
        Mockito.when(mockQuest.getStoryMap()).thenReturn(mockStoryMap);

        String[] storyArray = questService.writeStory(mockQuest, storyStep);
        String mockStory = storyArray[0];
        assertEquals(story, mockStory);
    }

    @Test
    void whenWriteStory_ThenGetValidAnswerFromStringArray() {
        Map<Integer, String> mockValidMap = new HashMap<>();
        mockValidMap.put(storyStep, validAnswer);
        Mockito.when(mockQuest.getValidAnswers()).thenReturn(mockValidMap);

        String[] storyArray = questService.writeStory(mockQuest, storyStep);
        String mockValidAnswer = storyArray[1];
        assertEquals(validAnswer, mockValidAnswer);
    }

    @Test
    void whenWriteStory_ThenGetInValidAnswerFromStringArray() {
        Map<Integer, String> mockValidMap = new HashMap<>();
        mockValidMap.put(storyStep, invalidAnswer);
        Mockito.when(mockQuest.getInvalidAnswers()).thenReturn(mockValidMap);

        String[] storyArray = questService.writeStory(mockQuest, storyStep);
        String mockInvalidAnswer = storyArray[2];
        assertEquals(invalidAnswer, mockInvalidAnswer);
    }

    @Test
    void whenWriteStory_ThenGetInValidStoryFromStringArray() {
        Map<Integer, String> mockValidMap = new HashMap<>();
        mockValidMap.put(storyStep, invalidStory);
        Mockito.when(mockQuest.getStoryAfterInvalidVariant()).thenReturn(mockValidMap);

        String[] storyArray = questService.writeStory(mockQuest, storyStep);
        String mockInvalidAnswer = storyArray[3];
        assertEquals(invalidStory, mockInvalidAnswer);
    }

    @Test
    void whenQuestIsNull_ThenGetNPE() {
        assertThrows(NullPointerException.class, () -> questService.writeStory(null, 1));
    }

    @Test
    void whenStepIsNegative_ThenGetNull() {
        Map<Integer, String> emptyStoryMap = new HashMap<>();
        Mockito.when(mockQuest.getStoryMap()).thenReturn(emptyStoryMap);
        Mockito.when(mockQuest.getValidAnswers()).thenReturn(emptyStoryMap);
        Mockito.when(mockQuest.getInvalidAnswers()).thenReturn(emptyStoryMap);
        Mockito.when(mockQuest.getStoryAfterInvalidVariant()).thenReturn(emptyStoryMap);

        String[] storyArray = questService.writeStory(mockQuest, -1);
        assertNull(storyArray[0]);
        assertNull(storyArray[1]);
        assertNull(storyArray[2]);
        assertNull(storyArray[3]);
    }
}