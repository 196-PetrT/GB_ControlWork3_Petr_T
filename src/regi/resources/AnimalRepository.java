package regi.resources;
import regi.core.Animal;
import regi.core.animal.Pet;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public interface AnimalRepository <T>{
//    Statement sqlSt = null;
//    ResultSet resultSet = null;
//    String SQLstr = null;
//    default List <T> getAll(){
//        List<Animal> registry = new ArrayList<Animal>();
//        Animal animals;
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            try (Connection dbConnection = getConnection()) {
//                sqlSt = dbConnection.createStatement();
//                SQLstr = "SELECT animals_id, type_animals FROM HumanFriends.all_animals ORDER BY animals_id\""; // todo
//                resultSet = sqlSt.executeQuery(SQLstr);
//                while (resultSet.next()) {
//
//                    PetType type = PetType.getType(resultSet.getInt(1));
//                    int id = resultSet.getInt(2);
//                    String name = resultSet.getString(3);
//                    LocalDate birthday = resultSet.getDate(4).toLocalDate();
//
//                    animals = petCreator.createPet(type, name, birthday);
//                    animals.setId(id);
//                    registry.add(animals);
//                }
//                return (List<T>) registry;
//            }
//        } catch (ClassNotFoundException | IOException | SQLException ex) {
//            Logger.getLogger(AnimalRepository.class.getName()).log(Level.SEVERE, null, ex);
//            throw new RuntimeException(ex.getMessage());
//        }
//    };
//    T getByAnimal_id(int Animal_id);
//    int create(T animal);
//    int update(T animal);
//    void delete (int animal);


    public static Connection getConnection() throws SQLException, IOException {

        try {
            String url = "jdbc:mysql://localhost/store?serverTimezone=Europe/Moscow&useSSL=false";
            String username = "root";
            String password = "31245";
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    List<T> getAll();

    T getByAnimal_id(int Animal_id);

    void create(T animal);

    void update(T animal);

    T update(int Animal_id);

    T delete(int Animal_id);
}
