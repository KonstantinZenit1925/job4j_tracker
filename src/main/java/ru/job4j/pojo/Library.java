package ru.job4j.pojo;

import java.util.Objects;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Фантастика", 500);
        Book book2 = new Book("Классика", 800);
        Book book3 = new Book("Мемуары", 300);
        Book book4 = new Book("Clean code", 1000);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int index = 0; index < books.length; index++) {
            Book pr = books[index];
            System.out.println(pr.getName() + " - " + pr.getCount());
        }
        System.out.println("********************************");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book pr = books[index];
            System.out.println(pr.getName() + " - " + pr.getCount());
        }
        System.out.println("********************************");
        for (int index = 0; index < books.length; index++) {
            Book pr = books[index];
            if (Objects.equals(pr.getName(), book4.getName())) {
                System.out.println(pr.getName() + " - " + pr.getCount());
            }
        }
    }

}
