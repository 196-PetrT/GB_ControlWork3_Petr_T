package regi.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public abstract class Animal {
    String type_animals;

    public Animal(String type_animals) {
        this.type_animals = type_animals;

        try {
            String url = "jdbc:mysql://localhost/store?serverTimezone=Europe/Moscow&useSSL=false";
            String username = "root";
            String password = "31245";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                Statement statement = conn.createStatement();
                int rows = statement.executeUpdate("SELECT animals_id, type_animals FROM HumanFriends.animals ORDER BY animals_id");
                System.out.printf("Added %d rows", rows);
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }
}
