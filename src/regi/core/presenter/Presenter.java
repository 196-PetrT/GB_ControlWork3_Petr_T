package regi.core.presenter;

import regi.core.Animal;
import regi.core.SpecialAnimals;
import regi.core.exceptions.IncorrectDataTypeException;
import regi.core.util.AdderAnimal;
import regi.core.view.View;
import regi.impl.ConsoleView;
import regi.resources.AnimalRepository;
import java.time.LocalDate;
import java.util.List;


public class Presenter {

    private final AnimalRepository<Animal> animalRepository;

    private final View view;

    public Presenter(AnimalRepository<Animal> animalRepository) {
        this.animalRepository = animalRepository;
        this.view = new ConsoleView(this);
    }

    public List<Animal> addAllAnimals(){
        return animalRepository.getAllAnimals();
    }


    public void displayAllAnimals() {
        try {
            animalRepository.listAllAnimals();
        } catch (IncorrectDataTypeException e) {
            System.err.println("Ошибка вывода данных");
        }
    }


    public void addAnimal(SpecialAnimals special) {
        // String[] addedAnimalArray = new String[] {String.valueOf(special), view.getName(), , , view.getColor(), view.getLearned_commands()};
        String name = view.getName();
        LocalDate birthday = view.getBirthdate();
        String sex = view.getSex();
        String color = view.getColor();
        String learned_commands = view.getLearned_commands();

        try {
            animalRepository.addAnimal(AdderAnimal.createAnimal(special, name, birthday, sex, color, learned_commands));

        } catch (IncorrectDataTypeException e) {
            System.err.println("Ошибка добавления данных");
        }

    }

    public void updateAnimal(List <Animal> allAnimals, SpecialAnimals special, int id) {

        String new_learned_commands = view.getLearned_commands();

        for (Animal animalTable : allAnimals) {
            if (special == animalTable.getSpecial_animals()) {
                if (id == animalTable.setId_animal()) {
                    animalTable.setLearned_commands(new_learned_commands);
                    try {
                        animalRepository.updateAnimal(animalTable);

                    } catch (IncorrectDataTypeException e) {
                        System.err.println("Ошибка изменения данных");
                    }
                }
            }

        }

    }
}
