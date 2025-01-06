package regi.core;

public enum SpecialAnimals {
    Cat(1, "Кот"),
    Dog (2, "Собака"),
    Hamster (3, "Хомяк"),

    Horse(4, "Лошадь"),
    Camel(5, "Верблюд"),
    Donkey(6, "Осёл"),;

    private final int id_special;
    private final String special;

    SpecialAnimals(int id_special, String special) {
        this.id_special = id_special;
        this.special = special;

    }

    public static SpecialAnimals getSpecial (int id){
        switch (id) {
            case 1 -> {return SpecialAnimals.Cat;}
            case 2 -> {return SpecialAnimals.Dog;}
            case 3 -> {return SpecialAnimals.Hamster;}
            case 4 -> {return SpecialAnimals.Horse;}
            case 5 -> {return SpecialAnimals.Camel;}
            case 6 -> {return SpecialAnimals.Donkey;}
            default -> {return null;}
        }
    }

    public int getId_special() {
        return id_special;
    }

    public String getSpecial() {
        return special;
    }
}
