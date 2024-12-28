package regi.impl;

import regi.core.TypeAnimals;
import regi.core.controller.Controller;
import regi.core.exceptions.UncorrectDBException;
import regi.core.util.Operations;
import regi.core.view.View;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class ConsoleView implements View {
    private final List<String> validOperations;
    Controller controller;

    public ConsoleView(Controller controller) {
        this.controller = controller;
        this.validOperations = Arrays.stream(Operations.values())
                .map(Operations::name)
               .collect(Collectors.toList());
    }
    public boolean isValidOperation(String operation) {
        return validOperations.contains(operation);
    }


    @Override
    public void start() {
        View.super.start();

    }

    @Override
    public void prepare() {
        int spaceSize = (110 - "РЕЕСТР ЖИВОТНЫХ".length()) / 2;
        String captionLine = " ".repeat(spaceSize) + "РЕЕСТР ЖИВОТНЫХ по состоянию на " + LocalDate.now() + " ".repeat(spaceSize);
        System.out.println(captionLine);

// Todo

    }

    @Override
    public String prompt() {
        Scanner in = new Scanner(System.in);

        System.err.println("Continue?... (y/n)");
        return in.nextLine();
    }

    @Override
    public String getOperation() {

        int id;

        Scanner in = new Scanner(System.in);
        System.out.print(
                "\nl - Список всех животных в реестре" +
                        "\na - Завести новое животное" +
                        "\nd - Удалить запись" +
                        "\nu - Изменить данные о животном" +
                        "\nc - Что умеет животное" +
                        "\nn - Дрессировка" +
                "\nвыберите действие (l, a, d, u, c, n, ) : ");
        String operation = in.nextLine();
        while (true) {
            if (isValidOperation(operation)) {
                System.err.println("Entered invalid operation. " + "\nвыберите действие (l, a, d, u, c, n, ): ");
                operation = in.nextLine();
            } else return operation;
            switch (operation) {
                case "l":
                    controller.getAllAnimals();
                    break;
                case "a":
                    TypeAnimals type = menuChoice(in);
                    if (type != null) {
                        controller.addAnimal(type);
                        System.out.println("ОК");
                    }
                    break;
                case "d":
                    while (true) {
                        id = menuChoice(in).getId_type();
                        if (id != 0)
                            controller.delete(id);
                        break;
                    }
                    break;
                case "u":
                    while (true) {
                        id = menuChoice(in).getId_type();
                        if (id != 0) {
                            controller.updateAnimal(id);
                        }
                        else
                            break;
                    }

                case "c":
                    while (true) {
                        id = menuChoice(in).getId_type();
                        if (id != 0)
                            controller.getCommands(id);
                        else
                            break;
                    }
                    break;
                case "n":
                    id = menuChoice(in).getId_type();
                    if (id != 0)
                        controller.learnCommands(id, in);
                    break;
            }
        }
    }

    private TypeAnimals menuChoice(Scanner in) {

        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getBirthdate() {
        return null;
    }

    @Override
    public String getAge() {
        return null;
    }
}
