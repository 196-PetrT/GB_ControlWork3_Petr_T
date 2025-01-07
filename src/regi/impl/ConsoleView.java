package regi.impl;

import regi.core.SpecialAnimals;
import regi.core.TypeAnimals;
import regi.core.presenter.Presenter;
import regi.core.view.View;
import regi.resources.AnimalRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;


public class ConsoleView implements View {

    private Presenter presenter;

    public ConsoleView(Presenter presenter) {
        this.presenter = presenter;
    }

    public ConsoleView() {
        super();
    }



    @Override
    public void start() {
        View.super.start();

    }

    @Override
    public void prepare() {
        clearConsole();
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
                        "\nвыберите действие (l, a, n, e) : ");

    }

    private void clearConsole() {
        System.out.print("\033[H\033[J");
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
                    presenter.displayAllAnimals();
                    break;
                case "a":
                    TypeAnimals type = menuChoice(in);
                    if (type == TypeAnimals.getType(1)) {
                        System.out.println("Выбрано добавление питомца");
                        Scanner sp = new Scanner(System.in);
                        SpecialAnimals special = menuChoiceSpecialPet(sp);
                        if (special == SpecialAnimals.getSpecial(1)) presenter.addAnimal(SpecialAnimals.Cat);
                        if (special == SpecialAnimals.getSpecial(2)) presenter.addAnimal(SpecialAnimals.Dog);
                        if (special == SpecialAnimals.getSpecial(3)) presenter.addAnimal(SpecialAnimals.Hamster);
                        }
                    if (type == TypeAnimals.getType(2)) {
                        System.out.println("Выбрано добавление вьючного животного");
                        Scanner sp = new Scanner(System.in);
                        SpecialAnimals special = menuChoiceSpecialPacked(sp);
                        if (special == SpecialAnimals.getSpecial(4)) presenter.addAnimal(SpecialAnimals.Horse);
                        if (special == SpecialAnimals.getSpecial(5)) presenter.addAnimal(SpecialAnimals.Camel);
                        if (special == SpecialAnimals.getSpecial(6)) presenter.addAnimal(SpecialAnimals.Donkey);
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
        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя: ");
        return in.nextLine();
    }

    @Override
    public Date getBirthdate() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите дату рождения (дд.мм.гггг): ");
        String birthdateStr = in.nextLine();
        return parseDate(birthdateStr);
    }

    @Override
    public String getSex() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите пол: ");
        return in.nextLine();
    }

    @Override
    public String getColor() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите окрас: ");
        return in.nextLine();
    }

    @Override
    public String getLearned_commands() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите выученные команды: ");
        return in.nextLine();
    }

    private Date parseDate(String dateStr) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            return format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
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
        System.out.println("Выберите животное:\n1 - Кошка\n2 - Собака\n3 - Хомяк\ne - Возврат в основное меню");

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
        System.out.println("Выберите животное:\n4 - Лошадь\n5 - Верблюд\n6 - Осёл\ne - Возврат в основное меню");

        while (true) {
            String key = in.next();
            switch (key) {
                case "4":
                    return SpecialAnimals.Horse;
                case "5":
                    return SpecialAnimals.Camel;
                case "6":
                    return SpecialAnimals.Donkey;
                case "e":
                    return null;
                default:
                    System.out.println("Такого варианта нет, введите число 4, 5 или 6, \ne - Возврат в основное меню");
                    break;
            }
        }
    }
}
