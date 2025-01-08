package regi.impl.Pet;

import regi.core.Animal;
import regi.core.SpecialAnimals;
import regi.core.TypeAnimals;
import regi.core.animal.Pet;


public class Cat extends Animal implements Pet {


    @Override
    public SpecialAnimals getSpecies_pets() {
        return SpecialAnimals.Cat;
    }

    @Override
    public TypeAnimals getType() {
        return TypeAnimals.Pet;
    }

}