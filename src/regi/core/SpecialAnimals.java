package regi.core;

public enum SpecialAnimals {
    Cat( "cats"),
    Dog ( "dogs"),
    Hamster ( "humsters"),

    Horse( "horses"),
    Camel( "camels"),
    Donkey( "donkeys"),;

    private final String str_special;

    SpecialAnimals(String str_special) {

        this.str_special = str_special;

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

    public String getStr_special() {
        return str_special;
    }
}
