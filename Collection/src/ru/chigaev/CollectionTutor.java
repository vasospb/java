package ru.chigaev;

import java.util.*;
import org.junit.Test;

/**
 * 1) Имплементрируйте метод joinByCycle(). Проверьте результат.
 * Имплементируйте методы getAnimalsList(), getAnimalsSet(), getAnimalsOrderedSet()
 * и верните их значения.
 * Как отличаются полученные результаты?
 * Имплементируйте метод joinByIterator()
 */
public class CollectionTutor {
   private String[] animals =
            {"Корова", "Гусь", "Кошка", "Собака", "Слон",
                    "Заяц", "Змея", "Курица", "Лошадь", "Человек",
                    "Корова", "Змея"};

    /**
     * Метод должен возвращать ArrayList со всеми животными
     */
    public List<String> getAnimalsList(String[] a ) {
        List<String> arrayList = new ArrayList<String>();
        arrayList = Arrays.asList(a);
        return arrayList;
    }

    /**
     * Метод должен возвращать Set со всеми животными
     */
    public Set<String> getAnimalsSet() {

        return null;
    }

    class Animal {
        String name;

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    /**
     * Метод должен брать коллекцию строк c
     * и возвращать одну строку, состоящую из
     * элементов коллекции, соединенных запятой,
     * используя цикл for
     */
    public String joinByCycle(Collection<?> c) {
        return null;
    }

    /**
     * Метод должен брать коллекцию строк c
     * и возвращать одну строку, состоящую из
     * элементов коллекции, соединенных запятой,
     * используя итератор
     */
    public String joinByIterator(Collection<?> c) {
        return null;
    }

    @Test
    public void testCollections() {

    }

}

