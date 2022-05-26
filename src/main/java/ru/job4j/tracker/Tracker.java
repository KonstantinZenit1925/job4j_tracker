package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Objects;

public class Tracker {
    /**Поле private Item[] items = new Item[100] содержит возможное количество заявлений.
     Оно у нас ограничено сотней позиций. **/
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    /**
     * Метод public Item add(Item item) добавляет заявку, переданную в аргументах в массив заявок items.
     * В методе add нужно проставить уникальный ключ в объект Item item. Это нужно сделать через метод setId.
     * Поле ids используется для генерации нового ключа. В нашем примере мы используем последовательность.
     * То есть каждый вызов метод add будет добавлять в поле ids единицу.
     * Так мы сможем обеспечить уникальность поле id в Item.
     * Аналогичный подход используется в базах данных.
     */
    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        /**Метод public Item findById(int id) проверяет в цикле все элементы массива items,
         * сравнивая id с аргументом int id и возвращает найденный Item. Если Item не найден - возвращает null.
         */
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        /**
         * Метод public Item[] findAll() возвращает копию массива items без null элементов (без пустых ячеек).
         * Перебирать все 100 элементов не нужно. У нас есть поле size.
         * Это поле и есть размер нового массива.
         * Чтобы получить новый массив, нужно использовать метод Arrays.copyOf.
         * Этот метод принимает два параметра: массив элементов и новый размер.
         */
        return Arrays.copyOf(items, 100);
    }

    public Item[] findByName(String key) {
        /**
         * проверяет в цикле все элементы массива items, сравнивая name
         * (используя метод getName класса Item) с аргументом метода String key.
         * Элементы, у которых совпадает name, копирует в результирующий массив и возвращает его.
         * Алгоритм этого метода аналогичен методу findAll.
         */
        Item[] items2 = new Item[this.items.length];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().contains(key)) {
                System.out.println(items[i].getName());
                items2[count] = this.items[i];
                count++;
            }
        }
        return Arrays.copyOf(items2, count);
    }
}