package regi.core;

public enum SpecialAnimals {
    Dog, Hamster, Cat, Horse, Camel, Donkeys;

    public static SpecialAnimals getType (int id){
        switch (id){
            case 1:
                return SpecialAnimals.Cat;
            case 2:
                return SpecialAnimals.Dog;
            case 3:
                return SpecialAnimals.Hamster;
            case 4:
                return SpecialAnimals.Horse;
            case 5:
                return SpecialAnimals.Camel;
            case 6:
                return SpecialAnimals.Donkeys;
            default:
                return null;
        }
    }

}
