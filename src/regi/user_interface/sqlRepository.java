package regi.user_interface;

import regi.core.Animal;
import regi.core.SpecialAnimals;
import regi.core.TypeAnimals;
import regi.core.util.AdderAnimal;
import regi.core.util.SqlConnector;
import regi.resources.AnimalRepository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class sqlRepository implements AnimalRepository<Animal> {

    private static SqlConnector connector;
    private static Connection connection;
    private static Statement statement;
    private static String sqlStr;
    private static ResultSet resultSet;
    private AdderAnimal adderAnimal;


    @Override
    public void listAllAnimals() {
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
            // id, name, birthday, age, sex, color, learned_commands, learnability, species_animals

            String[] allAnimalArray = {"cats", "dogs", "humsters", "horses", "camels", "donkeys"};
            for (String animalTable : allAnimalArray) {
                sqlStr = "SELECT name, birthday, sex, color, learned_commands, species_animals FROM " + animalTable + " ORDER BY birthday";
                resultSet = statement.executeQuery(sqlStr);
                int id = 0;
                while (resultSet.next()) {
                    id += 1;
                    String name = resultSet.getString(1);
                    Date birthdate = Date.valueOf(resultSet.getDate(2).toLocalDate());
                    String sex = resultSet.getString(3);
                    String color = resultSet.getString(4);
                    String learned_commands = resultSet.getString(5);
                    SpecialAnimals special = ChoiceSpecial(resultSet.getString(5));

                    animal = adderAnimal.createAnimal(special, name, birthdate, sex, color, learned_commands);
                    // (SpecialAnimals special, String name, Date birthdate, String sex, String color, String learned_commands
                    animal.setId_animal(id);
                    allAnimal.add(animal);
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
        try {
            // opening database connection to MySQL server
            connector = SqlConnector.getSqlConnector();
            connection = DriverManager.getConnection(connector.url(), connector.username(), connector.password());
            // getting Statement object to execute query
            statement = connection.createStatement();
            // executing SELECT query
            // id, name, birthday, age, sex, color, learned_commands, learnability, species_animals

            String strSpecial = strChoiceSpecial(animal.getSpecial_animals());

            if (animal.getType_animals() == TypeAnimals.Pet) {
                sqlStr = "INSERT INTO " + strSpecial + " (name, birthday, age, sex, color, learned_commands, learnability, " +
                        "species_pets) VALUES ('" + animal.getName() + "', '" + animal.getBirthDate() + "', " +
                        "    CONCAT(TIMESTAMPDIFF(YEAR, birthday, CURDATE()), ' y ', TIMESTAMPDIFF(MONTH, birthday, CURDATE()) % 12, ' m ')," +
                        " '" + animal.getSex() + "', '" + animal.getColor() + "', '" + animal.getLearned_commands() +
                        "', 1, '" + animal.getSpecial_animals() + "');";
            }
            else {
                sqlStr = "INSERT INTO strSpecial (name, birthday, age, sex, color, learned_commands, learnability, " +
                        "species_packed) VALUES ('" + animal.getName() + "', '" + animal.getBirthDate() + "', " +
                        "    CONCAT(TIMESTAMPDIFF(YEAR, birthday, CURDATE()), ' y ', TIMESTAMPDIFF(MONTH, birthday, CURDATE()) % 12, ' m ')," +
                        " '" + animal.getSex() + "', '" + animal.getColor() + "', '" + animal.getLearned_commands() +
                        "', 1, '" + animal.getSpecial_animals() + "');";
            }
//            String[] allAnimalArray = {"cats", "dogs", "humsters", "horses", "camels", "donkeys"};
//            prepSt.setString(1, animal.getName());
//            prepSt.setDate(2, Date.valueOf(animal.get()));
//            prepSt.setString(3, animal.getClass().getSimpleName());
//
//            rows = prepSt.executeUpdate();
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

    private SpecialAnimals ChoiceSpecial(String special) {
         while (true) {
            switch (special) {
                case "cats":
                    return SpecialAnimals.Cat;
                case "dogs":
                    return SpecialAnimals.Dog;
                case "humsters":
                    return SpecialAnimals.Hamster;
                case "horses":
                    return SpecialAnimals.Horse;
                case "camels":
                    return SpecialAnimals.Camel;
                case "donkeys":
                    return SpecialAnimals.Donkey;
                default:
                    break;
            }
        }
    }

    private String strChoiceSpecial (SpecialAnimals special) {
        while (true) {
            switch (special) {
                case Cat:
                    return "cats";
                case Dog:
                    return "dogs";
                case Hamster:
                    return "humsters";
                case Horse:
                    return "horses";
                case Camel:
                    return "camels";
                case Donkey:
                    return "donkeys";
                default:
                    break;
            }
        }
    }

}
