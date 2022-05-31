package ru.job4j.oop;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Самолет летает по воздуху");
    }

    @Override
    public void refueling() {
        int tankBoeing737300 = 23830;
        System.out.println("Объем заправки бака самолета Boeing737-300 составляет: " + tankBoeing737300 + " литров");

    }
}
