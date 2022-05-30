package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    /**
     * Метод init() - инициализирует приложение и запускает выполнение различных пользовательских действий;
     * Сделает вечный цикл while в метод init() внутри которого будем вызывать метод showMenu()
     * int select = Integer.parseInt(scanner.nextLine()) это перменная проиницилизирована методом
     * который отвечает за ввод с консоли, по аналогии с тем как мы делали в предыдущих заданиях.
     * Далее в блоке if
     * 1. Сообщить пользователю, что мы находимся в пункте добавления новой заявки в хранилище;
     * 2. Сообщить пользователю, что он должен ввести имя для создания заявки;
     * 3. Создать новую заявку с именем, которое мы ввели с консоли;
     * 4. Добавить заявку в хранилище Tracker.
     * 5. выводим сообщение пользователю с номером заявки "Добавленная заявка: " + item
     * Следующий блок позволяет реализовать вывод всех заявок если пункт меню будет 1. Вывести все заявки, а
     * если их нет, то сообщение что хранилище пусто
     */
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Добавленная заявка: " + item);
            } else if (select == 1) {
                System.out.println("=== Show all items ===");
                Item[] items = tracker.findAll();
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Хранилище еще не содержит заявок");
                }
            } else if (select == 6) {
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

    /**
     * Main() просто запускает наше приложение
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
