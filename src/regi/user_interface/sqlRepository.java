package regi.user_interface;

import regi.core.Animal;
import regi.core.SpecialAnimals;
import regi.core.util.SqlConnector;
import regi.impl.Pet.Cat;
import regi.resources.AnimalRepository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class sqlRepository implements AnimalRepository<Animal> {

    public static SqlConnector connector;
    public static Connection connection;
    public static Statement statement;
    public static String sqlStr;
    public static ResultSet resultSet;
    private Animal animals;


    @Override
    public void listAllAnimals() {

        List<Animal> allAnimal = new ArrayList<>();
        Animal animal;

        try {
            // opening database connection to MySQL server
            connector = SqlConnector.getSqlConnector();
            connection = DriverManager.getConnection(connector.url(), connector.username(), connector.password());
            // getting Statement object to execute query
            statement = connection.createStatement();
            // executing SELECT query
            String[] allAnimalArray = {"cats", "dogs", "humsters", "horses", "camels", "donkeys"};
            for (String animalTable : allAnimalArray) {
                sqlStr = "SELECT name, birthday, learned_commands FROM " + animalTable + " ORDER BY birthday";
                resultSet = statement.executeQuery(sqlStr);
                int id = 0;
                String format = "\n %-15s  %-15s  %-15s  %-25s %-15s";
                System.out.printf(format, "Id", "КЛИЧКА", "ДАТА РОЖДЕНИЯ", "ВЫУЧЕННЫЕ КОМАНДЫ", "ВИД");
                while (resultSet.next()) {
                    id += 1;
                    String name = resultSet.getString(1);
                    LocalDate birthdate = resultSet.getDate(2).toLocalDate();
                    String learned_commands = resultSet.getString(3);

                    System.out.printf(format, id, name, birthdate, learned_commands, animalTable);



//                animal = Animal.createAnimal(special, name, birthdate);
//                animal.setId_animal(id);
//                allAnimal.add(animal);
                }
                System.out.println("\nВсего животных " + animalTable + " в реестре: " + id);


            }



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
    }

    @Override
    public List<Animal> getAllAnimals() {

        List<Animal> allAnimal = new ArrayList<>();
        Animal animal;

        try {
            // opening database connection to MySQL server
            connector = SqlConnector.getSqlConnector();
            connection = DriverManager.getConnection(connector.url(), connector.username(), connector.password());
            // getting Statement object to execute query
            statement = connection.createStatement();
            // executing SELECT query
            String[] allAnimalArray = {"cats", "dogs", "humsters", "horses", "camels", "donkeys"};
            for (String animalTable : allAnimalArray) {
                sqlStr = "SELECT name, birthday, learned_commands FROM " + animalTable + " ORDER BY birthday";
                resultSet = statement.executeQuery(sqlStr);
                int id = 0;
                while (resultSet.next()) {
                    id += 1;
                    String name = resultSet.getString(1);
                    LocalDate birthdate = resultSet.getDate(2).toLocalDate();
                    String learned_commands = resultSet.getString(3);

//                    animal = addAnimal(animalTable);
//                    animal.setId_animal(id);
//                    allAnimal.add(animal);
                }
            }
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
    public void addAnimal(Animal animal) {
        
    }

}
