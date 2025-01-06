package regi.core;

import java.util.Date;

public abstract class Animal {
    protected int id_animal;
    protected String name;
    protected Date birthDate;
    protected String sex;
    protected String color;
    protected String learned_commands;
    protected String special_animals;
    protected TypeAnimals type_animals;


    public String getLearned_commands() {
        return learned_commands;
    }

    public String getSpecial_animals() {
        return special_animals;
    }

    public TypeAnimals getType_animals() {
        return type_animals;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }

    public static Animal createNewAnimal(String special) {
        return null;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setLearned_commands(String learned_commands) {
        this.learned_commands = learned_commands;
    }

    public void setSpecial_animals(String special_animals) {
        this.special_animals = special_animals;
    }

    public void setType_animals(TypeAnimals type_animals) {
        this.type_animals = type_animals;
    }
}
