package regi.impl.Pet;

import regi.core.Animal;
import regi.core.SpecialAnimals;
import regi.core.animal.Pet;

import java.util.Date;
import java.util.List;

public class Cat extends Animal implements Pet{
    protected String species;
    private String special;


    public Cat(String name, Date birthDate, String sex, String colors) {
        super();

    }

    public static void create(String name, Date birthDate, String sex, String colors) {
        new Cat(name, birthDate, sex, colors);
    }


    @Override
    public List getAll() {
        return null;
    }

    @Override
    public Object getBy_Pets_id(int Pets_id) {
        return null;
    }

    @Override
    public void setPets_id(String Pets_id) {

    }

    @Override
    public String getSpecies_pets() {
        return null;
    }

    @Override
    public void setSpecies_pets() {

    }

    @Override
    public void setType_animals(String Type_animals) {

    }
}
