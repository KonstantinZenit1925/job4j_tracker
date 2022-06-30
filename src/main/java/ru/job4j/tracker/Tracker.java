package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {

    /**Поле private Item[] items = new Item[100] содержит возможное количество заявлений.
     Оно у нас ограничено сотней позиций. **/
    
    private final List<Item> items = new ArrayList<>();
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
        items.add(item);
        return item;
    }
    /** Метод public Item findById(int id) Находим индекс.
     * * Если индекс найден возвращаем item, иначе null */

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }
    /**
     * Метод public Item[] findAll() возвращает копию массива items без null элементов (без пустых ячеек).

     */

    public List<Item> findAll() {
        return List.copyOf(items);
    }
    /**
     * Метод проверяет в цикле все элементы массива items, сравнивая name
     * (используя метод getName класса Item) с аргументом метода String key.
     * Элементы, у которых совпадает name, копирует в результирующий массив и возвращает его.
     * Алгоритм этого метода аналогичен методу findAll.
     * @return
     */

    public List<Item> findByName(String key) {
        List<Item> list = new ArrayList<>();
        for (Item item: items) {
            if (item != null && item.getName().equals(key)) {
                list.add(item);
            }
        }
        return list;
    }

    /**
     * Метод, который будет возвращать index по id.
     * indexOf объявлен как private, потому что он используется только внутри системы.
     */
    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;

    }

    /**
     * Метод замены заявки. Tracker.replace
     */
    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            item.setId(id);
            items.set(index, item);
        }
        return result;
    }

    /** Метод удаления заявки.
     */

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            items.remove(index);
        }
        return result;
    }
}
