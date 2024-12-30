package regi.user_interface;

import regi.core.Animal;
import regi.resources.AnimalRepository;

import java.util.List;

public class sqlRepository implements AnimalRepository<Animal> {
    @Override
    public List<Animal> getAll() {
        return null;
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
