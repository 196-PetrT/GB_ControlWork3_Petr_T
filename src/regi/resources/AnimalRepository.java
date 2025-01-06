package regi.resources;
import regi.core.SpecialAnimals;

import java.util.List;

public interface AnimalRepository <T> {
    // Вывести список животных по дате рождения
    void listAllAnimals();

    List<T> getAllAnimals();

//    T getByAnimal_id(int Animal_id);

    // Добавление нового животного
    void addAnimal(T animal);

    // Список команд животного



    // Обучение новым командам





}
