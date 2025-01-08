package regi.user_interface;

import regi.core.Animal;
import regi.core.SpecialAnimals;
import regi.core.TypeAnimals;
import regi.core.util.AdderAnimal;
import regi.core.util.SqlConnector;
import regi.resources.AnimalRepository;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
                System.out.println("\n Всего животных " + animalTable + " в реестре: " + id);
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
                sqlStr = "SELECT name, birthday, sex, color, learned_commands FROM " + animalTable + " ORDER BY birthday";
                resultSet = statement.executeQuery(sqlStr);
                int id = 0;
                while (resultSet.next()) {
                    id += 1;
                    String name = resultSet.getString(1);
                    LocalDate birthdate = LocalDate.parse(resultSet.getString(2), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    String sex = resultSet.getString(3);
                    String color = resultSet.getString(4);
                    String learned_commands = resultSet.getString(5);
                    SpecialAnimals special = ChoiceSpecial(animalTable);

                    animal = AdderAnimal.createAnimal(special, name, birthdate, sex, color, learned_commands);
                    animal.setId_animal(id);
                    allAnimal.add(animal);
                }
            }
            return allAnimal;

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
    public void addAnimal(Animal animal) {
        try {
            connector = SqlConnector.getSqlConnector();
            connection = DriverManager.getConnection(connector.url(), connector.username(), connector.password());
            statement = connection.createStatement();

            String strSpecial = strChoiceSpecial(animal.getSpecial_animals());

            if (animal.getType_animals(animal.getSpecial_animals()) == TypeAnimals.Pet) {
                sqlStr = "INSERT INTO " + strSpecial + "(name, birthday, age, sex, color, learned_commands, learnability, " +
                        "species_pets) VALUES ('" + animal.getName() + "', '" + animal.getBirthDate() + "', " +
                        "    CONCAT(TIMESTAMPDIFF(YEAR, birthday, CURDATE()), ' y ', TIMESTAMPDIFF(MONTH, birthday, CURDATE()) % 12, ' m ')," +
                        " '" + animal.getSex() + "', '" + animal.getColor() + "', '" + animal.getLearned_commands() +
                        "', 1, '" + strSpecial + "');";
                statement.executeUpdate(sqlStr);

            }
            if (animal.getType_animals(animal.getSpecial_animals()) == TypeAnimals.Packed)
            {
                sqlStr = "INSERT INTO " + strSpecial + "(name, birthday, age, sex, color, learned_commands, learnability, " +
                        "species_packed) VALUES ('" + animal.getName() + "', '" + animal.getBirthDate() + "', " +
                        "    CONCAT(TIMESTAMPDIFF(YEAR, birthday, CURDATE()), ' y ', TIMESTAMPDIFF(MONTH, birthday, CURDATE()) % 12, ' m ')," +
                        " '" + animal.getSex() + "', '" + animal.getColor() + "', '" + animal.getLearned_commands() +
                        "', 1, '" + animal.getSpecial_animals() + "');";
                statement.executeUpdate(sqlStr);
            }
            System.err.println("Добавлено новое животное вида " + strSpecial);

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
        }
    }

    @Override
    public void updateAnimal(Animal animal) {
        try {
            connector = SqlConnector.getSqlConnector();
            connection = DriverManager.getConnection(connector.url(), connector.username(), connector.password());
            statement = connection.createStatement();

            String strSpecial = strChoiceSpecial(animal.getSpecial_animals());
            System.err.println(strSpecial + animal.getLearned_commands());
            sqlStr = "UPDATE " + strSpecial + " SET learned_commands = " + animal.getLearned_commands() + " WHERE "+ strSpecial+ "_id = " + animal.getId_animal() + ";";
            statement.executeUpdate(sqlStr);

            System.err.println("Сведения о выученных командах обновлены");

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
        }
    }

    private SpecialAnimals ChoiceSpecial(String str_special) {
         while (true) {
            switch (str_special) {
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
        return special.getStr_special();
    }

}
