package regi.user_interface;

import regi.core.Animal;
import regi.core.controller.Controller;
import regi.impl.ConsoleView;
import regi.resources.AnimalRepository;

public class App {

    ConsoleView ui;
    AnimalRepository<Animal> animalRegistry = new sqlRepository();
    Controller controller = new Controller(animalRegistry);
    public App() {
        ui = new ConsoleView(controller);
        ui.start();
    }

}
