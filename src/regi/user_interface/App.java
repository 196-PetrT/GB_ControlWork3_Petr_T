package regi.user_interface;

import regi.core.Animal;
import regi.core.presenter.Presenter;
import regi.impl.ConsoleView;
import regi.resources.AnimalRepository;

public class App {

    ConsoleView ui;
    AnimalRepository <Animal> animalRegistry = new sqlRepository();
    Presenter presenter = new Presenter(animalRegistry);
    public App() {
        ui = new ConsoleView(presenter);
        ui.start();
    }

}
