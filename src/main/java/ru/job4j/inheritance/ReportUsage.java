package ru.job4j.inheritance;

public class ReportUsage {

    public static void main(String[] args) {
        JSONReport report2 = new JSONReport();
        String text2 = report2.generate("name", "body");
        System.out.println(text2);
    }
}
