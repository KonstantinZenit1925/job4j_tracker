package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User rsl = null;
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                rsl = user;
                break;
            }
        }
        if (rsl == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return rsl;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.getUsername().length() < 3 || !user.isValid()) {
            throw new UserInvalidException("Пользователь не валидный");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {new User("Petr Arsentev", true)};
        User user = null;
        try {
            user = findUser(users, "Petr Arsentev");
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            System.out.println("Пользователь не найден");
        }
        try {
            if (validate(user)) {
                System.out.println("Пользователь не валидный");
            }
        } catch (UserInvalidException e) {
            e.printStackTrace();
        }
    }
}
