package ru.job4j.collection;


import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftString = left.split("\\.");
        int leftInt = Integer.parseInt(leftString[0]);
        String[] rightString = right.split("\\.");
        int rightInt = Integer.parseInt(rightString[0]);
        return Integer.compare(leftInt, rightInt);
    }
}

