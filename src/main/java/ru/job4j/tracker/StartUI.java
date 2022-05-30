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
     * Следующий блок позволяет реализовать замену заявок если пункт меню будет 2
     * Здесь мы выводим информацию для пользователя, используем метод реплейс а так же создаем проверку на ошибку при замене заявки
     * Следующий блок позволяет реализовать удаление заявок если пункт меню будет 3
     * Здесь мы удаляем заявку с помощью метода делит, и выводим сообщения
     * Меню 4
     * Позволяет найти заявку по id, используем метод для поиска заявки по id в классе
     * Tracker предназначен вспомогательный метод indexOf() который используется в методе findById():
     * Меню 5
     * Ищем заявку по названию, используем findByName
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
            } else if (select == 2) {
                System.out.println("=== Edit item ===");
                System.out.print("Enter id: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Заявка изменена успешно.");
                } else {
                    System.out.println("Ошибка замены заявки.");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                System.out.print("Enter id: ");
                int id = Integer.parseInt(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("Заявка удалена успешно.");
                } else {
                    System.out.println("Ошибка удаления заявки.");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by id ===");
                System.out.print("Enter id: ");
                int id = Integer.parseInt(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Заявка с введенным id: " + id + " не найдена.");
                }
            }  else if (select == 5) {
                System.out.println("=== Find items by name ===");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item[] items = tracker.findByName(name);
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Заявки с именем: " + name + " не найдены.");
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
