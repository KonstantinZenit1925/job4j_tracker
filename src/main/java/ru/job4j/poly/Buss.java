package ru.job4j.poly;

public class Buss implements Transport {

    @Override
    public void drive() {
        System.out.println("Автобус едет в Нью-Йорк");
    }

    @Override
    public void passengers(int amount) {
        System.out.println("Количество пассажиров в автобусе: " + amount);
    }

    @Override
    public int refuel(int fuel) {
        final int oneGallon = 7;
        int total = oneGallon * fuel;
        System.out.println("Стоимость топлива после заправки составляет: " + (fuel * oneGallon) + "$.");
        return total;
    }

    public static void main(String[] args) {
        Buss buss = new Buss();
        buss.drive();
        buss.passengers(50);
        buss.refuel(50);
    }
}
