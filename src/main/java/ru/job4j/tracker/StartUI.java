package ru.job4j.tracker;
import java.util.Scanner;

public class StartUI {
    /**
     * Метод init() - инициализирует приложение и запускает выполнение различных пользовательских действий;
     * Сделае вечный цикл while в метод init() внутри которого будем вызывать метод showMenu()
     * int select = Integer.parseInt(scanner.nextLine()) это перменная проиницилизирована методом
     * который отвечает за ввод с консоли, по аналогии с тем как мы делали в предыдущих заданиях.
     */
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select != 6) {
                System.out.println("Пользователь выбрал: " + select);
            } else {
                run = false;
            }
        }

    }

    /**
     * Метод showMenu() - выводит на экран меню доступных пользовательских действий;
     * все пункты меню сделамем через массив строк и разобьем через цикл for
     */
    private void showMenu() {
        String[] menu = {
                "Add new Item", "Show all items", "Edit item",
                "Delete item", "Find item by id", "Find items by name",
                "Exit Program"
        };
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }

    }

    /** Main() просто запускает наше приложение
     * В методе main() создается объект Scanner, который позволит получать данные с консоли от пользователя,
     * Tracker будет служить хранилищем заявок.В следующей строке:  new StartUI().init(scanner, tracker);
     * мы создаем объект класса StartUI и сразу на этом объекте вызываем метод init(). Поскольку дальше
     * этот объект мы не будем переиспользовать, то мы не записываем созданный объект в переменную.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }

}
