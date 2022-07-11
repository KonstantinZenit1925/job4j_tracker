package ru.job4j.collection;

import java.util.Comparator;

/**
 * Kомпаратор по возрастанию приоритета.
 */
public class JobAscendingByPriority implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        return Integer.compare(o1.getPriority(), o2.getPriority());
    }
}
