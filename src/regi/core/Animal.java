package regi.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;
import java.util.UUID;

public abstract class Animal {
    protected int id_animal;
    protected String name;
    protected Date birthDate;
    protected String age;
    protected String sex;
    protected String color;
    protected String learned_commands;
    protected SpecialAnimals special_animals;
    protected TypeAnimals type_animals;

   public Animal() {
       super();
   }

    public Animal(int id_animal, String name,Date birthDate, String age, String sex, String color,
                  String learned_commands, SpecialAnimals special_animals,TypeAnimals type_animals) {
       this.id_animal = id_animal;
       this.name = name;
       this.birthDate = birthDate;
       this.age = age;
       this.sex = sex;
       this.color = color;
       this.learned_commands = learned_commands;
       this.special_animals = special_animals;
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

    public int getId_animal() {
        return id_animal;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getColor() {
        return color;
    }

    public String getLearned_commands() {
        return learned_commands;
    }

    public SpecialAnimals getSpecial_animals() {
        return special_animals;
    }

    public TypeAnimals getType_animals() {
        return type_animals;
    }
}
