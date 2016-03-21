package ru.chigaev;

/**
 * Created by vaso on 22.03.2016.
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class StringBuilderTutor {

    String [] animals =
            {"Корова", "Гусь", "Кошка", "Собака", "Слон",
                    "Заяц", "Змея", "Курица", "Лошадь", "Человек"};

    /**
     * Метод должен вернуть строку:
     * "Список животных: Корова, Гусь, ..., Человек."
     * Для реализации используйте StringBuilder
     */
    public String getAnimalsString() {
        StringBuilder sb=new StringBuilder("Список животных: ");
        String comma=", ";
        for (String s:animals
             ) {
            sb.append(s).append(comma);
        }
       sb.replace(sb.length()-2,sb.length(),".");
        return sb.toString();
    }

    @Test
    public void testGetAnimalsString() {
        String animalsString = getAnimalsString();
        System.out.println(animalsString);
        assertEquals("Список животных: Корова, Гусь, Кошка, Собака, Слон, "+
                "Заяц, Змея, Курица, Лошадь, Человек.", animalsString);
    }

}
