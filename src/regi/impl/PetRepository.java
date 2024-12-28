package regi.impl;

import regi.core.Animal;
import regi.core.animal.Pet;
import regi.resources.AnimalRepository;

import java.util.List;

public class PetRepository implements AnimalRepository {

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public Object getByAnimal_id(int Animal_id) {
        return null;
    }

    @Override
    public void create(Object animal) {

    }

    @Override
    public void update(Object animal) {

    }

    @Override
    public Object update(int Animal_id) {
        return null;
    }

    @Override
    public Object delete(int Animal_id) {
        return null;
    }
}