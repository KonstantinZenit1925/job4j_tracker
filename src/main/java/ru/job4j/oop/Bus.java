package ru.job4j.oop;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Автобус едет по трассе");
    }

    @Override
    public void refueling() {
        int tankBus = 250;
        System.out.println("Объем заправки бака автобуса Икарус состовляет: " + tankBus + " литров");
    }
}
