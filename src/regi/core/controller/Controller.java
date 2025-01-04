package regi.core.controller;

import regi.core.Animal;
import regi.core.SpecialAnimals;
import regi.impl.ConsoleView;
import regi.impl.Pet.Cat;
import regi.resources.AnimalRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Controller {

    private final AnimalRepository<Animal> animalRepository;

    public Controller(AnimalRepository<Animal> animalRepository) {
    this.animalRepository = animalRepository;
    }

    public static void getByIdAnimal() {
    }

    public void getAllAnimals() {
        try {
            animalRepository.getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void updateAnimal(int id) {
    }

    public void delete(int id) {
    }

    public void getCommands(int id) {
    }

    public void learnCommands(int id, Scanner in) {
    }

    public void addAnimal(SpecialAnimals special) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = in.nextLine();
        System.out.print("Введите дату рождения (дд.мм.гггг): ");
        String birthdateStr = in.nextLine();
        Date birthdate = parseDate(birthdateStr);
        System.out.print("Введите пол: ");
        String sex = in.nextLine();
        System.out.print("Введите окрас: ");
        String color = in.nextLine();

//        Animal.create(name, birthdate, sex, color);
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

    private Date parseDate(String dateStr) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            return format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
