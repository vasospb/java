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
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 * 1) Имплементрируйте метод joinByCycle(). Проверьте результат.
 * 		Имплементируйте методы getAnimalsList(), getAnimalsSet(), getAnimalsOrderedSet()
 * 		и верните их значения.
 * 		Как отличаются полученные результаты? 
 * 		Имплементируйте метод joinByIterator()
 */
public class CollectionTutor {
    String [] animals =
            {"Корова", "Гусь", "Кошка", "Собака", "Слон",
                    "Заяц", "Змея", "Курица", "Лошадь", "Человек",
                    "Корова", "Змея"};

    /**
     * Метод должен возвращать ArrayList со всеми животными
     */
    public List<String> getAnimalsList(String[] a) {
        List<String> arrayAnimals = new ArrayList<String>();
             arrayAnimals   = Arrays.asList(a);
        return arrayAnimals;
    }

    /**
     * Метод должен возвращать Set со всеми животными  
     */
    public Set<String> getAnimalsSet() {
        Set<String> hs = new HashSet<String>();
        for (String a: animals
             ) {
            hs.add(a);
                 }

        return hs;
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
    public String joinByCycle(Collection<String> c) {
        String sa= new String();
        for (String s: c
             ) {
         sa=sa+", "+s;

        }
        return sa;
    }

    /**
     * Метод должен брать коллекцию строк c
     * и возвращать одну строку, состоящую из 
     * элементов коллекции, соединенных запятой,
     * используя итератор
     */
    public String joinByIterator(Collection<String> c) {
        return null;
    }

    @Test
    public void testCollections() {
        System.out.println("getAnimalsList: "+joinByCycle(Arrays.asList(animals)));

        System.out.println("getAnimalsList: "+joinByCycle(getAnimalsList(animals)));
        System.out.println("getAnimalsSet: "+joinByCycle(getAnimalsSet()));

    //    System.out.println("getAnimalsList by iterator: "+joinByIterator(getAnimalsList()));
    }

}
