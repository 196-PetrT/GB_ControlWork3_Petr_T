package regi.core;

public enum TypeAnimals {

    Pet (1,"Питомцы"),
    Packed (2, "Вьючные");

    private final int id_type;
    private final String type;

    TypeAnimals(int id_type, String type) {
        this.id_type = id_type;
        this.type = type;
    }

    public static TypeAnimals getType (int id){
        switch (id) {
            case 1 -> {return TypeAnimals.Pet;}
            case 2 -> {return TypeAnimals.Packed;}
            default -> {return null;}
        }
    }

    public int getId_type() {
        return id_type;
    }

    public String getType() {
        return type;
    }
}
