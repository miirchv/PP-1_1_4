package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Petr", "Petrov", (byte) 20);
        userService.saveUser("Alexsandr", "Alexsandrov", (byte) 20);
        userService.saveUser("Ivan", "Ivanov", (byte) 25);
        userService.saveUser("Alexey", "Alexeev", (byte) 20);

        List<User> allUsers = userService.getAllUsers();
        for (User user : allUsers) {
            System.out.println(user);
        }

        userService.cleanUsersTable();


        userService.dropUsersTable();
    }
}
