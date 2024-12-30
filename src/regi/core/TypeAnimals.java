package regi.core;

public enum TypeAnimals {

    Pet, Packed;

    public static TypeAnimals getType (int id){
        switch (id){
            case 1:
                return TypeAnimals.Pet;
            case 2:
                return TypeAnimals.Packed;
            default:
                return null;
        }
    }
}
