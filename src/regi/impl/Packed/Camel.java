package regi.impl.Packed;

import regi.core.Animal;
import regi.core.SpecialAnimals;
import regi.core.TypeAnimals;
import regi.core.animal.Packed;

public class Camel extends Animal implements Packed {
    @Override
    public SpecialAnimals getSpecies_packed() {
        return SpecialAnimals.Camel;
    }
    @Override
    public TypeAnimals getType() {
        return TypeAnimals.Packed;
    }
}
