package regi.core;

import java.time.LocalDate;

public abstract class Animal {
    protected int id_animal;
    protected String name;
    protected LocalDate birthDate;
    protected String sex;
    protected String color;
    protected String learned_commands;
    protected SpecialAnimals special_animals;

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getColor() {
        return color;
    }

    public String getSex() {
        return sex;
    }

    public String getLearned_commands() {
        return learned_commands;
    }

    public SpecialAnimals getSpecial_animals() {
        return special_animals;
    }

    public TypeAnimals getType_animals(SpecialAnimals special) {
        return switch (special) {
            case Cat, Dog, Hamster -> TypeAnimals.Pet;
            case Horse, Camel, Donkey -> TypeAnimals.Packed;
        };
    }

    public int getId_animal() {
        return id_animal;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
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

    public void setSpecial_animals(SpecialAnimals special) {
        this.special_animals = special;
    }

    public int setId_animal() {
        return id_animal;
    }
}
