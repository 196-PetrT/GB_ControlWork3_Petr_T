import core.Pet.Pet;
import core.UserView.ConsoleView;
import core.controller.Controller;
import core.resources.AnimalRepository;
import core.resources.PetRepository;

public class Main {
    public static void main(String[] args) {
        // запуск контроллера, подключение к репозиторию и запуск консольного управления программой
        AnimalRepository <Pet> animalRegistry = new PetRepository();
        Controller controller = new Controller(animalRegistry);

        // new ConsoleView(controller).start();


    }
}