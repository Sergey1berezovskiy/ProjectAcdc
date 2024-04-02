package com.javarush.berezovskiy.entity;
import com.javarush.berezovskiy.constants.Constants;

import java.util.Map;

public class QuestSpaceStory extends Quest {
    private final String name;
    public QuestSpaceStory(User user) {
        super(user);
        this.name = Constants.QUEST_COSMOS_NAME;
    }

    @Override
    public String getQuestName() {
        return this.name;
    }

    protected Map<Integer, String> makeStory(){
        return Map.of(
                0, ("Свет ярких лучей пронзает глаза, когда %s осознает, что окружен чужеродными существами." +
                        "Его сердце бьется сумасшедшим ритмом, а мозг переплетается чувствами страха и удивления.\n" +
                        "Вы принимаете решение.."
                        ).formatted(getUserName()),
                1, "%s убегает по коридорам, но за ним бегут. %s видит слева дверь, а справа отсек, похожий на мусорный. Вы...".formatted(getUserName(),getUserName()),
                2, "Открыв отсек, %s падает вниз и оказывается на в мусорном контейнере. Оборачиваясь по сторонам %s видит пистолет. Вы...".formatted(getUserName(),getUserName()),
                3, "Убив всех инопланетян, %s оборачивается и видит огромного босса. Вы решаете...".formatted(getUserName()),
                4, "%s убежал в комнату, где лежит куча оружия. Вы принимаете решение".formatted(getUserName()),
                5, "Только %s взяли оружие, как все помещение заполнилось врагами. Курок на взводе. Скорее всего выжить не удастся. Вы...".formatted(getUserName()),
                6, "Это была жесткая схватка. %s слышит какой-то раздражающий звук, из-за которого начинает уноситься куда-то. Все это время вы спали, а это был уникальный сон. Пора собираться на работу".formatted(getUserName())
        );
    }
    protected Map<Integer, String> makeStoryAfterInvalidVariant(){
        return Map.of(
                0, "Инопланетяне видят, что вы не сопротивляетесь. Привязывают и вытаскивают все органы. Вы мертвы",
                1, "Вы забегаете в дверь. Дверь закрывается. Включается защита из лазеров, которая безжалостно расстреливает вас",
                2, "Какой-то мусор порезал вашу руку и туда попал яд, от которого вы моментально умираете",
                3, "Вы начинаете стрелять в босса, но пистолет его не берет. Смеясь, он берет вас и разрывает пополам",
                4, "Это оказывается не меч, а электрошокер, который срабатывает и тут же убивает вас",
                5, "Вы стреляете в себя. Оказывается, что на самом деле вы все это время спали, но в ваших руках оказался пистолет, которым вы убили себя в реальности"
        );
    }
    protected Map<Integer, String> makeValidAnswers(){
        return Map.of(
                0, "Бежать",
                1, "Залезть в отсек",
                2, "Берете пистолет",
                3, "Бежать",
                4,"Взять BFG",
                5, "Будете сражаться"
        );
    }

    protected Map<Integer, String> makeInvalidAnswers() {
        return Map.of(
                0, "Замереть",
                1, "Открыть дверь",
                2, "Прячетесь в мусоре",
                3, "Стрелять в босса",
                4, "Взять меч",
                5, "Убьете себя"
        );
    }

}