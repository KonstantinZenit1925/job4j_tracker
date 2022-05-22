package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        String say = "Неизвестное слово. ";
        System.out.println(say + eng);
        return say;
    }

    public static void main(String[] args) {
        DummyDic dummyDic = new DummyDic();
        dummyDic.engToRus("Error");
    }
}
