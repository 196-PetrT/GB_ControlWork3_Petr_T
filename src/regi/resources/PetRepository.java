package core.resources;

import core.Pet.Pet;

import java.util.List;

public class PetRepository implements AnimalRepository <Pet> {

    @Override
    public List<Pet> getAll() {
        return null;
    }

    @Override
    public Pet getByAnimal_id(int Animal_id) {
        return null;
    }

    @Override
    public int create(Pet animal) {
        return 0;
    }

    @Override
    public int update(Pet animal) {
        return 0;
    }

    @Override
    public void delete(int animal) {

    }
}
