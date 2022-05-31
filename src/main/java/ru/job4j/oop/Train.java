package ru.job4j.oop;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Поезд едет по железной дороге");
    }

    @Override
    public void refueling() {
        int tankTrain = 15;
        System.out.println("Объем запаса угля в тендере паровоза составляет: " + tankTrain + " тонн");
    }
}
