package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Jack", "Doe", (byte) 30);// реализуйте алгоритм здесь
        userService.saveUser("Jasmin", "Taylor", (byte) 28);// реализуйте алгоритм здесь
        userService.saveUser("Mike", "Miller", (byte) 29);// реализуйте алгоритм здесь
        userService.saveUser("Anna", "Brown", (byte) 34);// реализуйте алгоритм здесь
        userService.getAllUsers().forEach(System.out::println);

        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
