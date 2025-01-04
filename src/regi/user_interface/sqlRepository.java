package regi.user_interface;

import regi.core.Animal;
import regi.core.SpecialAnimals;
import regi.resources.AnimalRepository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class sqlRepository implements AnimalRepository<Animal> {

    public static Connection connection;
    public static Statement statement;
    public static String sqlStr;
    public static ResultSet resultSet;
    public static String url = "jdbc:mysql://localhost:3306/humanfriends";
    public static String username = "root";
    public static String password = "31245";
    private Animal animals;


//    static {
//        try {
//            connection = DriverManager.getConnection(url, username, password);
//        } catch (SQLException ex) {
//            Logger.getLogger(sqlRepository.class.getName()).log(Level.SEVERE, null, ex);
//            throw new RuntimeException();
//        }
//    }
//
//    static {
//        try {
//            statement = connection.createStatement();
//        } catch (SQLException ex) {
//            Logger.getLogger(sqlRepository.class.getName()).log(Level.SEVERE, null, ex);
//            throw new RuntimeException();
//        }
//    }

//    public Animal(int id_animal, String name,LocalDate birthDate, String age, String sex, String color,
//                  String learned_commands, SpecialAnimals special_animals,TypeAnimals type_animals) {
//        this.id_animal = id_animal;
//        this.name = name;
//        this.birthDate = birthDate;
//        this.age = age;
//        this.sex = sex;
//        this.color = color;
//        this.learned_commands = learned_commands;
//        this.special_animals = special_animals;
//        this.type_animals = type_animals;
//

    @Override
    public List <Animal> getAll() {

        List<Animal> allAnimal = new ArrayList<>();
        Animal animal;
        sqlStr = "SELECT name, birthday, species_animals FROM humanfriends.all_animal ORDER BY id";
        try {
            // opening database connection to MySQL server
            connection = DriverManager.getConnection(url, username, password);
            // getting Statement object to execute query
            statement = connection.createStatement();

            // executing SELECT query
            resultSet = statement.executeQuery(sqlStr);
            int id = 0;
            String format = "\n %-15s  %-15s  %-15s  %-15s ";
            System.out.printf(format, "Id", "КЛИЧКА", "ДАТА РОЖДЕНИЯ", "ВИД");
            while (resultSet.next()) {
                id += 1;
                String name = resultSet.getString(1);
                LocalDate birthdate = resultSet.getDate(2).toLocalDate();
                String special = resultSet.getString(3);

                System.out.printf(format, id, name, birthdate, special);


//                animal = Animal.createAnimal(special, name, birthdate);
//                animal.setId_animal(id);
//                allAnimal.add(animal);
            }
            System.out.println();

        } catch (SQLException ex) {
            Logger.getLogger(sqlRepository.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException();

        } finally {
            try {
                connection.close();
            } catch (SQLException ignored) {
            }
            try {
                statement.close();
            } catch (SQLException ignored) {
            }
            try {
                resultSet.close();
            } catch (SQLException ignored) {
            }

        }
        return allAnimal;
    }

    @Override
    public Animal getByAnimal_id(int Animal_id) {
        return null;
    }

    @Override
    public void create(Animal animal) {

    }

    @Override
    public Animal update(int Animal_id) {
        return null;
    }

    @Override
    public Animal delete(int animal) {

        return null;
    }


}
