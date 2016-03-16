package ru.chigaev;
import org.junit.*;

/**
 * Данный класс делает то же, что делает стандартный ArrayList:
 * увеличивает размер массива, когда массив заполнен.
 *
 * Реализуйте метод deleteAnimal(int position)
 *
 */
public class ArrayCopyTutor {
    int animals_capacity = 5;
    int animals_expand_by = 5;
    int animals_size = 0;
    String[] animals = new String[animals_capacity];

    public void addAnimal(String animal) {
        if (animals_size>=animals_capacity) {
            expandAnimalsArray();
        }
        animals[animals_size] = animal;
        animals_size++;
    }

    private void expandAnimalsArray() {
        int old_animals_size = animals_capacity;
        animals_capacity += animals_expand_by;
        String[] animals_new = new String[animals_capacity];
        System.arraycopy(animals, 0, animals_new, 0, old_animals_size);
        animals = animals_new;
    }

    public void insertAnimal(int position, String animal) {
        if (position<0 || position>animals_size-1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (position==animals_size-1) {
            addAnimal(animal);
        } else {
            if (animals_size>=animals_capacity) {
                expandAnimalsArray();
            }
            System.arraycopy(animals, position, animals, position+1, animals_size-position);
            animals[position] = animal;
            animals_size++;
        }
    }

    public void deleteAnimal(int position) {
    }

    public void showAnimals() {
        for (int i=0;i<animals_size; i++) {
            System.out.println(i+") "+animals[i]);
        }
    }

    @Test
    public void testAnimals() {
        addAnimal("Лошадь");
        addAnimal("Носорог");
        addAnimal("Собака");
        addAnimal("Змея");
        addAnimal("Обезьяна");
        addAnimal("Индюк");
        addAnimal("Косуля");
        addAnimal("Лев");
        addAnimal("Тигр");
        addAnimal("Кошка");
        addAnimal("Черепаха");
        insertAnimal(1, "Человек");
        deleteAnimal(2);
        showAnimals();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void deleteAnimal_emptyArray_throwsIndexOutOfBoundsException() {
        ArrayCopyTutor it = make_array_with_items(0);
        it.deleteAnimal(1);

    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void deleteAnimal_deleteItemWithIndexOutOfBound_throwsIndexOutOfBoundsException() {
        ArrayCopyTutor it = make_array_with_items(1);
        it.deleteAnimal(2);
    }

    @Test
    public void deleteAnimal_deleteFirstItemFromArrayWith1Item_deleteThatItem() {
        ArrayCopyTutor it = make_array_with_items(1);
        it.deleteAnimal(0);

        Assert.assertEquals(0, it.animals_size);
    }

    @Test
    public void deleteAnimal_deleteFirstItemFromArrayWith2Items_deleteThatItem() {
        ArrayCopyTutor it = make_array_with_items(1);
        it.addAnimal("last");

        it.deleteAnimal(0);

        Assert.assertEquals(1, it.animals_size);
        Assert.assertEquals("last", it.animals[0]);
    }


    private ArrayCopyTutor make_array_with_items(int n) {
        ArrayCopyTutor result = new ArrayCopyTutor();

        for (int i = 0; i < n; i++) {
            result.addAnimal("Item " + i);
        }

        return result;
    }
}
