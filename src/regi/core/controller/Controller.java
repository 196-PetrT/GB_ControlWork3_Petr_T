package regi.core.controller;

import regi.core.Animal;
import regi.core.SpecialAnimals;
import regi.core.view.View;
import regi.impl.ConsoleView;
import regi.resources.AnimalRepository;

import java.util.Scanner;

import static regi.core.SpecialAnimals.Cat;

public class Controller {
    private final View view;
    private AnimalRepository<Animal> animalRepository;

    public Controller(AnimalRepository<Animal> animalRepository) {
    this.animalRepository = animalRepository;
    this.view = new ConsoleView(this);
    }

    public static void getByIdAnimal() {

    }

    public void getAllAnimals() {
        StringBuilder builder = new StringBuilder();
        String format = "\n %-8s | %-14s | %-18s | %-7s | %-20s | %-20s ";
        builder.append(String.format(format, "Id", "ИМЯ", "ДАТА РОЖДЕНИЯ", "ВОЗРАСТ(в месяцах)", "ПОЛ", "ОКРАС",
                "ВЫУЧЕННЫЕ КОМАНДЫ", "ВИД ЖИВОТНОГО"));
        builder.append("\n");
        // todo метод добавления данных с БД
//        id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
//                name VARCHAR(20) NOT NULL,
//        birthday DATE NOT NULL,
//        age VARCHAR(50) NOT NULL,
//        sex VARCHAR(50) NOT NULL,
//        color VARCHAR(50) NOT NULL,
//        learned_commands VARCHAR(50),
//                learnability BOOLEAN NOT NULL,
//                species_animals VARCHAR(50)
        System.out.println(builder.toString());
    }



    public void updateAnimal(int id) {
    }

    public void delete(int id) {
    }

    public void getCommands(int id) {
    }

    public void learnCommands(int id, Scanner in) {
    }

    public void addCat(SpecialAnimals cat) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = in.nextLine();
        System.out.print("Введите дату рождения (дд.мм.гггг): ");
        String birthdate = in.nextLine();
        System.out.print("Введите пол: ");
        String sex = in.nextLine();
        System.out.print("Введите окрас: ");
        String color = in.nextLine();

//        SpecialAnimals cat = new Cat();
//        Cat.setName(name);
//        Cat.setBirthdate(birthdate);
//        Cat.setSex(sex);
//        Cat.setColor(color);
//        animalRepository.create(animal);
        // todo реализовать добавление животного
    }

    public void addDog(SpecialAnimals special) {
    }

    public void addHamster(SpecialAnimals special) {
    }

    public void addHorse(SpecialAnimals special) {
    }

    public void addCamel(SpecialAnimals special) {
    }

    public void addDonkey(SpecialAnimals special) {

    }
}
