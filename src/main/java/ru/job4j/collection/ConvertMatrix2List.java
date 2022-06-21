package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] index : array) {
            for (int j : index) {
                list.add(j);
            }
        }
        return list;
    }
}