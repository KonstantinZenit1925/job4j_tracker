package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int number = Math.min(left.length(), right.length());
        int res = 0;
        for (int i = 0; i < number && res == 0; i++) {
            res = Character.compare(left.charAt(i), right.charAt(i));
        }
        return res == 0 ? Integer.compare(left.length(), right.length()) : res;
    }
}