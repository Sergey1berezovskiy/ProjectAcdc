package com.javarush.berezovskiy.entity;
import java.util.Map;

public class QuestForrestStory extends Quest {
    public QuestForrestStory(User user) {
        super(user);
    }
    protected Map<Integer, String> makeStory(){
        return Map.of(
                0, "%s проснулся посреди обломков. В животе урчит.".formatted(getUserName()),
                1, "Вы обнаруживаете запасы еды и воды в обломках самолета, что позволяет вам выжить на протяжении нескольких дней. Набравшись сил, вы...",
                2, "Вы встречаете других выживших пассажиров недалеко от разбитого самолета и они объединяются, чтобы найти способ выбраться на связь с миром." +
                        "За неделю, прожитую вместе с новыми друзьями, вы решаете, что надо...",
                3, "В поисках способа спасения %s натыкается на старый таинственный лес, который может оказаться ключом к спасению. Попав в глубины леса, вы видите останки человека...".formatted(getUserName()),
                4, "Покопавшись в останках, вы находите старый дневник предыдущего выжившего,который помогает понять, как выбраться."+
                        "Следуя дневнику, вы находите маяк. Поднявшись на самый верх вы находите радиостанцию. Внимательно посмотрев на нее, вы решаете...",
                5, "Вы вызвали спасателей. Вам удалось спастись и помочь остальным выжившим"
        );
    }
    protected Map<Integer, String> makeStoryAfterInvalidVariant(){
        return Map.of(
                0, "Вы так долго ждали спасателей, что незаметно уснули. Температура опустилась так низко, что вы замерзли и умерли",
                1, "Костер не разгорался и вы попробовали подлить к него жидкость, которую вы нашли. Жидкость проливается случайно на вас. От испуга вы наступаете ногой в костер и сгораете заживо",
                2, "Как бы вы ни старались, но лекарств и бинтов у вас нет и раненные начинают умирают один за одним. Вы решаете, что все попытки спастись безнадежны и глубокой ночью кончаете с собой",
                3, "Вы спотыкаетесь об ветку. Неудачно падаете вниз со склона и погибаете",
                4, "Вы решили остаться с остальными выжившими, но вернувшись, вы никого не обнаружили. %s остался совершенно один без помощи.".formatted(getUserName())
        );
    }
    protected Map<Integer, String> makeValidAnswers(){
        return Map.of(
                0, "Попробовать отыскать еду",
                1, "Отправляетесь на разведку",
                2, "Пойти на вылазку",
                3,"Исследовать останки",
                4, "Попробовать включить ее"
        );
    }

    protected Map<Integer, String> makeInvalidAnswers() {
        return Map.of(
                0, "Ждать спасателей",
                1, "Пробуете разжечь костер",
                2, "Остаться для поддержания раненных",
                3, "Пойти дальше",
                4, "Разбить ее"
        );
    }

}