package ru.job4j.collection;

import java.util.Comparator;

/**
 * Компаратора по возрастанию по полям имени
 */
public class JobAscendingByName implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
