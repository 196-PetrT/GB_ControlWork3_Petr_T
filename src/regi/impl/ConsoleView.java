package regi.impl;

import regi.core.SpecialAnimals;
import regi.core.TypeAnimals;
import regi.core.controller.Controller;
import regi.core.util.Operations;
import regi.core.view.View;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class ConsoleView implements View {

    private final Controller controller;

    public ConsoleView(Controller controller) {
        this.controller = controller;

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
        System.out.print(
                "\nl - Список всех животных в реестре" +
                        "\na - Завести новое животное" +
                        "\nd - Удалить запись" +
                        "\nu - Изменить данные о животном" +
                        "\nc - Что умеет животное" +
                        "\nn - Дрессировка" +
                        "\ne - Выйти из реестра" +
                        "\nвыберите действие (l, a, d, u, c, n, e) : ");

    }

    @Override
    public String prompt() {
        Scanner in = new Scanner(System.in);
        System.err.println("Вы хотите завершить программу?... (y/n)");
        return in.nextLine();
    }

    @Override
    public void getOperation() {
        Scanner in = new Scanner(System.in);

        boolean flag = true;
        int id;
        while (flag) {
            String operation = in.nextLine();
            switch (operation) {
                case "l":
//                    System.out.println("list");
                    controller.getAllAnimals();
                    break;
                case "a":
                    TypeAnimals type = menuChoice(in);
                    if (type == TypeAnimals.getType(1)) {
                        System.out.println("Выбрано добавление питомца");
                        Scanner sp = new Scanner(System.in);
                        SpecialAnimals special = menuChoiceSpecialPet(sp);
                        if (special == SpecialAnimals.getSpecial(1)) controller.addAnimal(SpecialAnimals.Cat);
                        if (special == SpecialAnimals.getSpecial(2)) controller.addAnimal(SpecialAnimals.Dog);
                        if (special == SpecialAnimals.getSpecial(3)) controller.addAnimal(SpecialAnimals.Hamster);
                        }
                    if (type == TypeAnimals.getType(2)) {
                        System.out.println("Выбрано добавление вьючного животного");
                        Scanner sp = new Scanner(System.in);
                        SpecialAnimals special = menuChoiceSpecialPacked(sp);
                        if (special == SpecialAnimals.getSpecial(4)) controller.addAnimal(SpecialAnimals.Horse);
                        if (special == SpecialAnimals.getSpecial(5)) controller.addCamel(SpecialAnimals.Camel);
                        if (special == SpecialAnimals.getSpecial(6)) controller.addDonkey(SpecialAnimals.Donkeys);
                        }
                    break;
                case "d":
                    while (true) {
                        System.out.println("del"); //
//                        id = menuChoice(in).ordinal();
//                        if (id != 0)
//
//                            controller.delete(id);

                        break;
                    }
                    break;
                case "u":
                    while (true) {
                        System.out.println("update"); //
//
//                        id = menuChoice(in).ordinal();
//                        if (id != 0) {
//                            controller.updateAnimal(id);
//                        } else
                            break;
                    }

                case "c":
                    while (true) {
                        System.out.println("commands"); //
//
//                        id = menuChoice(in).ordinal();
//                        if (id != 0)
//                            controller.getCommands(id);
//                        else
                            break;
                    }
                    break;
                case "n":
                    System.out.println("new commands"); //
//
//                    id = menuChoice(in).ordinal();
//                    if (id != 0)
//                        controller.learnCommands(id, in);

                    break;
                case "e":
                    flag = false;
                    break;

                default:
                    System.err.println("Entered invalid operation. " + "\nвыберите действие (l, a, d, u, c, n, e ): ");
                    break;

            }
        }
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

    private TypeAnimals menuChoice (Scanner in) {
        System.out.println("Какое животное добавить:\n1 - питомец\n2 - вьючное");

        while (true) {
            String key = in.next();
            switch (key) {
                case "1":
                    return TypeAnimals.Pet;
                case "2":
                    return TypeAnimals.Packed;
                case "e":
                    return null;
                default:
                    System.out.println("Такого варианта нет, введите число 1 или 2, \ne - Возврат в основное меню");
                    break;
            }
        }
    }

    private SpecialAnimals menuChoiceSpecialPet (Scanner in) {
        System.out.println("Какое животное добавить:\n1 - Кошка\n2 - Собака\n3 - Хомяк\ne - Возврат в основное меню");

        while (true) {
            String key = in.next();
//            int key = Integer.parseInt(in.next());
            switch (key) {
                case "1":
                    return SpecialAnimals.Cat;
                case "2":
                    return SpecialAnimals.Dog;
                case "3":
                    return SpecialAnimals.Hamster;
                case "e":
                    return null;
                default:
                    System.out.println("Такого варианта нет, введите число 1, 2 или 3, \ne - Возврат в основное меню");
                    break;
            }
        }
    }

    private SpecialAnimals menuChoiceSpecialPacked (Scanner in) {
        System.out.println("Какое животное добавить:\n4 - Лошадь\n5 - Верблюд\n6 - Осёл\ne - Возврат в основное меню");

        while (true) {
            String key = in.next();
            switch (key) {
                case "4":
                    return SpecialAnimals.Horse;
                case "5":
                    return SpecialAnimals.Camel;
                case "6":
                    return SpecialAnimals.Donkeys;
                case "e":
                    return null;
                default:
                    System.out.println("Такого варианта нет, введите число 4, 5 или 6, \ne - Возврат в основное меню");
                    break;
            }
        }
    }
}
