package ru.job4j.pojo;

import java.time.format.DateTimeFormatter;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Иван Петров");
        student.setGroup(1456);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println(student.getName()
                + " студент факультета Кибернетики группы № " + student.getGroup() + " учится в СпбГУ с: "
                + student.getData().format(formatter));
    }
}