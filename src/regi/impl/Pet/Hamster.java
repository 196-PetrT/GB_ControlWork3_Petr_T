package regi.impl.Pet;

import regi.core.Animal;
import regi.core.SpecialAnimals;
import regi.core.animal.Pet;


public class Hamster extends Animal implements Pet {


    @Override
    public SpecialAnimals getSpecies_pets() {
        return SpecialAnimals.Hamster;
    }

}