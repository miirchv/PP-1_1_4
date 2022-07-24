package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        // реализуйте алгоритм здесь


//        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
//
//        userDaoJDBC.createUsersTable();
//
//        userDaoJDBC.saveUser("Ivan", "Ivanov", (byte) 20);
//        userDaoJDBC.saveUser("Petr", "Petrov", (byte) 22);
//        userDaoJDBC.saveUser("Alex", "Alexov", (byte) 25);
//        userDaoJDBC.saveUser("Nikolay", "Nikolaev", (byte) 30);
//
//        List<User> allUsers = userDaoJDBC.getAllUsers();
//        for (int i = 0; i < allUsers.size(); i++) {
//            System.out.println(allUsers.get(i));
//        }
//
//        userDaoJDBC.cleanUsersTable();
//
//      userDaoJDBC.dropUsersTable();

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
