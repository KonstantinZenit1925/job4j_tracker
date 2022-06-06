package ru.job4j.ex;

public class ElementNotFoundException extends Exception {
    public static class FindEl {
        public static int indexOf(String[] value, String key) throws ElementNotFoundException {
            int rsl = -1;
            for (int i = 0; i < value.length; i++) {
                if (value[i] == key) {
                    System.out.println(i);
                } else {
                    System.out.println("Элемент не найден исключение");
                }
            }
            return rsl;
        }
    }

    public static void main(String[] args)  {
        String[] seasons  = new String[] {"Winter", "Spring", "Summer"};
        try {
            FindEl.indexOf(seasons, "Autumn");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
