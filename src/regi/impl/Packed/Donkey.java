package regi.impl.Packed;

import regi.core.Animal;
import regi.core.SpecialAnimals;
import regi.core.animal.Packed;

public class Donkey extends Animal implements Packed {
    @Override
    public SpecialAnimals getSpecies_packed() {
        return SpecialAnimals.Donkey;
    }
}
