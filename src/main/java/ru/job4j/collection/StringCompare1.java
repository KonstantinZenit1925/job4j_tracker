package ru.job4j.collection;

import java.util.Comparator;
import java.util.Objects;

public class StringCompare1 implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        if (Objects.equals(left, right)) {
            return 0;
        }
        if (left == null) {
            return -1;
        }
        if (right == null) {
            return 1;
        }
        return left.compareTo(right);
    }
}

