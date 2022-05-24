package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int z) {
        return z - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int c) {
        return c / x;
    }

    public int sumAllOperation(int d) {
        return sum(d) + minus(d) + multiply(d) + divide(d);
    }

    public static void main(String[] args) {
        int result = sum(10);
        System.out.println("Статичный метод вычисления суммы: " + result);
        int result2 = minus(25);
        System.out.println("Статичный метод вычисления  разности: " + result2);
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        int rsl2 = calculator.divide(5);
        int rsl3 = calculator.sumAllOperation(10);
        System.out.println("Нестатический метод вычисления произведения: " + rsl);
        System.out.println("Нестатический метод вычисления деления: " + rsl2);
        System.out.println("Нестатический метод результат суммирования всех операций: " + rsl3);
    }
}
