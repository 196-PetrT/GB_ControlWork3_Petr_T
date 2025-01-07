package regi.core.util;

import regi.core.Animal;
import regi.core.SpecialAnimals;
import regi.impl.Packed.Camel;
import regi.impl.Packed.Donkey;
import regi.impl.Packed.Horse;
import regi.impl.Pet.Cat;
import regi.impl.Pet.Dog;
import regi.impl.Pet.Hamster;

import java.util.Date;

public abstract class AdderAnimal {


    public static Animal createNewAnimal(SpecialAnimals special) {
        return switch (special) {
            case Cat -> new Cat();
            case Dog -> new Dog();
            case Hamster -> new Hamster();
            case Horse -> new Horse();
            case Camel -> new Camel();
            case Donkey -> new Donkey();
        };

    }

    public Animal createAnimal(SpecialAnimals special, String name, Date birthdate, String sex, String color, String learned_commands){
        Animal animal = createNewAnimal(special);
        animal.setName(name);
        animal.setBirthDate(birthdate);
        animal.setSex(sex);
        animal.setColor(color);
        animal.setLearned_commands(learned_commands);

        return animal;
    }
        // id, name, birthday, age, sex, color, learned_commands, learnability, species_animals
}
