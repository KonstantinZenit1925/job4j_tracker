package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagikBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        int answer = new Random().nextInt(3);
        input.nextLine();
        if (answer == 0) {
            System.out.println("Да");
        } else {
            System.out.println("Может быть");
        }
        if (answer == 1) {
            System.out.println("Нет");
        }
    }
}
