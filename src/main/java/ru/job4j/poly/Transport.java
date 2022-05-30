package ru.job4j.poly;

public interface Transport {
    /**
     * В интерфейсе объявите три метода:
     * ехать (без параметров, без возвращаемого типа),
     * пассажиры (принимает число пассажиров, без возвращаемого типа),
     * заправить (принимает кол-во топлива, возвращает цену).
     */
    void drive();

    void passengers(int amount);

    int refuel(int fuel);
}
