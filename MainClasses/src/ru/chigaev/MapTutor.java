package ru.chigaev;

/**
 * Created by vaso on 06.04.2016.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * 1) Реализуйте методы fillAnimalsLengthMap() и printMap().
 * 		Изучите результаты работы программы.
 * 2) Реализуйте методы fillLengthAnimalsMap() и printMapOfSets()
 * 		Изучите результаты работы программы.
 */
public class MapTutor extends Tutor {
    Map<String,Integer> animalsLengthMap = new HashMap<String, Integer>();

    Map<Integer,Set<String>> lengthAnimalsMap = new HashMap<Integer,Set<String>>();

    String [] animals =
            {"Корова", "Гусь", "Кошка", "Собака", "Слон",
                    "Человек", "Заяц", "Змея", "Курица", "Лошадь",
                    "Корова", "Змея"};

    /**
     * заполняет таблицу animalsLengthMap значениями
     * animal => animal.length()
     * например
     * "Корова" => 6
     * "Змея" => 4
     */
    public void fillAnimalsLengthMap() {
    }

    /**
     * Выводит на печать содержимое animalsLengthMap,
     * перечисляя ключ и значение
     */
    public void printMap(Map<?,?> map) {
    }

    /**
     * Заполняет таблицу lengthAnimalsMap значениями
     * длина названия животного => список животных с такой длиной названия
     * например
     * 4 => Змея, Слон, Гусь
     * 5 => Кошка
     * 6 => Лошадь, Собака, Корова
     */
    public void fillLengthAnimalsMap() {
    }

    /**
     * печатает содержимое таблицы lengthAnimalsMap,
     * выводя ключ и список значений
     */
    public void printMapOfSets(Map<Integer,Set<String>> map) {
    }

    @Test
    public void testMap() {
        fillAnimalsLengthMap();
        log("== printMap animalsLengthMap");
        printMap(animalsLengthMap);

        log("== printMap treemap animalsLengthMap");
        SortedMap<String, Integer> sortedMap = new TreeMap<String,Integer>(animalsLengthMap);
        printMap(sortedMap);

        log("== print lengthAnimalsMap");
        fillLengthAnimalsMap();
        printMapOfSets(lengthAnimalsMap);

        SortedMap<Integer,Set<String>> sortedMap2 = new TreeMap<Integer,Set<String>>(lengthAnimalsMap);

        log("== sortedMap headSet where key<6");
        printMapOfSets(sortedMap2.headMap(6));

        log("== sortedMap subMap 5..7");
        printMapOfSets(sortedMap2.subMap(5,7));
    }

    @Test
    public void fillAnimalsLengthMap_default_fillsAnimalsLengthMapWithData() {
        animalsLengthMap.clear();
        fillAnimalsLengthMap();
        assertEquals(6, (int) animalsLengthMap.get("Корова"));
        assertEquals(4, (int) animalsLengthMap.get("Гусь"));
    }

    @Test
    public void fillLengthAnimalsMap_default_fillLengthAnimalsMapWithData() {
        lengthAnimalsMap.clear();
        fillLengthAnimalsMap();
        assertTrue(lengthAnimalsMap.get(6).contains("Корова"));
        assertTrue(lengthAnimalsMap.get(4).contains("Гусь"));
    }
}
