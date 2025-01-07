package regi.core.presenter;

import regi.core.Animal;
import regi.core.SpecialAnimals;
import regi.core.util.AdderAnimal;
import regi.core.view.View;
import regi.impl.ConsoleView;
import regi.resources.AnimalRepository;

import java.util.Date;


public class Presenter {

    private final AnimalRepository<Animal> animalRepository;
    private  AdderAnimal adderAnimal;
    private final View view;

    public Presenter(AnimalRepository<Animal> animalRepository) {
    this.animalRepository = animalRepository;
        this.view = new ConsoleView();

    }

    public static void getByIdAnimal() {
    }

    public void displayAllAnimals() {
        try {
            animalRepository.listAllAnimals();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void addAnimal(SpecialAnimals special) {
        // String[] addedAnimalArray = new String[] {String.valueOf(special), view.getName(), , , view.getColor(), view.getLearned_commands()};
        String name = view.getName();
        Date birthday = view.getBirthdate();
        String sex = view.getSex();
        String color = view.getColor();
        String learned_commands = view.getLearned_commands();
        try {
            animalRepository.addAnimal(adderAnimal.createAnimal(special, name, birthday, sex, color, learned_commands));
            // (SpecialAnimals special, String name, Date birthdate, String sex, String color, String learned_commands)
            System.out.println("add real");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // SpecialAnimals special, String name, Date birthdate, String sex, String color, String learned_commands
    }


}
