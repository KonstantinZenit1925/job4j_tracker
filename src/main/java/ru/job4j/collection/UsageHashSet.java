package ru.job4j.collection;

import java.util.HashSet;

public class UsageHashSet {
    public static void main(String[] args) {
        HashSet<String> autos = new HashSet<>();
        autos.add("Лада");
        autos.add("БМВ");
        autos.add("Вольво");
        autos.add("Тайота");
        for (String name : autos) {
            System.out.println(name);
        }
    }
}
