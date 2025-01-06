package regi.core.presenter;

import regi.core.Animal;
import regi.core.SpecialAnimals;
import regi.resources.AnimalRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Presenter {

    private final AnimalRepository<Animal> animalRepository;

    public Presenter(AnimalRepository<Animal> animalRepository) {
    this.animalRepository = animalRepository;
    }

    public static void getByIdAnimal() {
    }

    public void getAllAnimals() {
        try {
            animalRepository.listAllAnimals();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void updateAnimal(int id) {
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
        System.out.print("Введите выученные команды: ");
        String learning_commands = in.nextLine();
//        Animal.create(name, birthdate, sex, color);
//        Cat.setName(name);
//        Cat.setBirthdate(birthdate);
//        Cat.setSex(sex);
//        Cat.setColor(color);
//        animalRepository.create(animal);
        // todo реализовать добавление животного
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
