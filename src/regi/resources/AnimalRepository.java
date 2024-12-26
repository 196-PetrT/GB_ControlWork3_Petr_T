package core.resources;
import java.util.List;
public interface AnimalRepository <T>{

    List <T> getAll();
    T getByAnimal_id(int Animal_id);
    int create(T animal);
    int update(T animal);
    void delete (int animal);
}
