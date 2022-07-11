package ru.job4j.collection;

import java.util.Comparator;

/**
 * Компаратора по убыванию по полям имени
 */
public class JobDescByName implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        return o2.getName().compareTo(o1.getName());
    }
}
