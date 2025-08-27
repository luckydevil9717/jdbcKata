package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/java_test_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "9796";

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                        .applySetting("hibernate.connection.url", URL)
                        .applySetting("hibernate.connection.username", USER)
                        .applySetting("hibernate.connection.password", PASSWORD)
                        .applySetting("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
                        .applySetting("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect")
                        .applySetting("hibernate.hbm2ddl.auto", "update")
                        .applySetting("hibernate.hbm2ddl.auto", "create-drop")
                        .build();

                sessionFactory = new MetadataSources(registry)
                        .addAnnotatedClass(jm.task.core.jdbc.model.User.class)
                        .buildMetadata()
                        .buildSessionFactory();

            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Ошибка при создании SessionFactory", e);
            }
        }
        return sessionFactory;
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка соединения с базой данных", e);
        }
    }


    // реализуйте настройку соеденения с БД
}
