package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Jack", "Doe", (byte) 30);
        userService.saveUser("Jasmin", "Taylor", (byte) 28);
        userService.saveUser("Mike", "Miller", (byte) 29);
        userService.saveUser("Anna", "Brown", (byte) 34);
//        userService.getAllUsers().forEach(System.out::println);

        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
