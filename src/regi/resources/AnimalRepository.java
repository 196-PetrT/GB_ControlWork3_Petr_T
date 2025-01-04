package regi.resources;
import regi.core.Animal;
import regi.core.animal.Pet;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public interface AnimalRepository <T> {
    List<T> getAll();

    T getByAnimal_id(int Animal_id);

    void create(T animal);

    T update(int Animal_id);

    T delete(int Animal_id);
}
