package regi.resources;

import java.util.List;

public interface AnimalRepository <T> {
    // Вывести список животных по дате рождения
    void listAllAnimals();

    List<T> getAllAnimals();

    // Добавление нового животного
    void addAnimal(T animal);

    // Обучение новым командам
    void updateAnimal(T animal);




}
