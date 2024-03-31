package com.javarush.berezovskiy.entity;

import com.javarush.berezovskiy.constants.Constants;
import lombok.Getter;
import java.util.Map;

@Getter
public abstract class Quest {
    private final Map<Integer, String> storyMap;
    private final Map<Integer, String> storyAfterInvalidVariant;
    private final Map<Integer, String> validAnswers;
    private final Map<Integer, String> invalidAnswers;
    private final User user;

    protected Quest(User user){
        this.user = user;
        storyMap = makeStory();
        storyAfterInvalidVariant = makeStoryAfterInvalidVariant();
        validAnswers = makeValidAnswers();
        invalidAnswers = makeInvalidAnswers();

    }
    protected abstract Map<Integer, String> makeStory();
    protected abstract Map<Integer, String> makeStoryAfterInvalidVariant();
    protected abstract Map<Integer, String> makeValidAnswers();
    protected abstract Map<Integer, String> makeInvalidAnswers();

    public abstract String getQuestName();

    protected String getUserName(){
        if(getUser().getName() != null && !getUser().getName().isBlank())
            return getUser().getName();
        else return Constants.DEFAULT_USERNAME;
    }
}
