package regi.core.util;

import regi.core.Animal;
import regi.core.SpecialAnimals;
import regi.impl.Packed.Camel;
import regi.impl.Packed.Donkey;
import regi.impl.Packed.Horse;
import regi.impl.Pet.Cat;
import regi.impl.Pet.Dog;
import regi.impl.Pet.Hamster;
import java.time.LocalDate;

public class AdderAnimal {


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


    public static Animal createAnimal(SpecialAnimals special, String name, LocalDate birthdate, String sex, String color, String learned_commands){
        Animal newAnimal = createNewAnimal(special);
        newAnimal.getType_animals(special);
        newAnimal.setSpecial_animals(special);
        newAnimal.setName(name);
        newAnimal.setBirthDate(birthdate);
        newAnimal.setSex(sex);
        newAnimal.setColor(color);
        newAnimal.setLearned_commands(learned_commands);
//        System.err.println("Добавлено животное вида " + special.getStr_special() + ": " + name);
        return newAnimal;

    }
        // id, name, birthday, age, sex, color, learned_commands, learnability, species_animals
}
