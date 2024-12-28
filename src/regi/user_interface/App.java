package regi.user_interface;

import regi.core.Animal;
import regi.core.animal.Pet;
import regi.core.controller.Controller;
import regi.impl.ConsoleView;
import regi.resources.AnimalRepository;
import regi.impl.PetRepository;

public class App {
    ConsoleView ui;
    AnimalRepository<Animal> animalRegistry = new Repository();
    Controller controller = new Controller(animalRegistry);
    public App() {
        // запуск контроллера, подключение к репозиторию и запуск консольного управления программой


        ui = new ConsoleView(controller);
        ui.start();

    }

}
