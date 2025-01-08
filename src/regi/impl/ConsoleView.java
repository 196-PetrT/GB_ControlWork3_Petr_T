package regi.impl;

import regi.core.SpecialAnimals;
import regi.core.TypeAnimals;
import regi.core.exceptions.IncorrectDataTypeException;
import regi.core.presenter.Presenter;
import regi.core.view.View;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class ConsoleView implements View {

    private final Presenter presenter;

    public ConsoleView(Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void start() {
        View.super.start();

    }

    @Override
    public void prepare() {
        clearConsole();
//        presenter.addAllAnimals();
        int spaceSize = (110 - "РЕЕСТР ЖИВОТНЫХ".length()) / 2;
        String captionLine = " ".repeat(spaceSize) + "РЕЕСТР ЖИВОТНЫХ по состоянию на " + LocalDate.now() + " ".repeat(spaceSize);
        System.out.println(captionLine);
        System.out.print(
                """
                        l - Список всех животных в реестре
                        a - Завести новое животное
                        d - Удалить запись
                        n - обновить сведения о выученных командах
                        e - Выйти из реестра
                        выберите действие (l, a, n, e) :\s""");

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
        while (flag) {
            String operation = in.nextLine();
            switch (operation) {
                case "l":
                    presenter.displayAllAnimals();
                    break;
                case "a":
                    TypeAnimals type = menuChoice(in);
                    if (type == TypeAnimals.getType(1)) {
                        System.out.println("Выбрано добавление питомца");

                        Scanner sp = new Scanner(System.in);
                        SpecialAnimals special = menuChoiceSpecialPet(sp);
                        presenter.addAnimal(special);
                        break;
                        }

                    if (type == TypeAnimals.getType(2)) {
                        System.out.println("Выбрано добавление вьючного животного");
                        Scanner sp = new Scanner(System.in);
                        SpecialAnimals special = menuChoiceSpecialPacked(sp);
                        presenter.addAnimal(special);
                        break;
                        }

                case "n":
                    System.out.println("Выбрано изменение сведений о выученных командах");

                    type = menuChoice(in);
                    if (type == TypeAnimals.getType(1)) {
                        System.out.println("Выбрано изменение сведений о питомце");

                        Scanner sp = new Scanner(System.in);
                        SpecialAnimals special = menuChoiceSpecialPet(sp);

                        System.out.print("Введите Id животного: ");
                        String id = in.nextLine();
                        presenter.updateAnimal(presenter.addAllAnimals(), special, Integer.parseInt(id));
                        break;
                    }

                    if (type == TypeAnimals.getType(2)) {
                        System.out.println("Выбрано изменение сведений о вьючном животном");

                        Scanner sp = new Scanner(System.in);
                        SpecialAnimals special = menuChoiceSpecialPacked(sp);

                        System.out.print("Введите Id животного: ");
                        String id = in.nextLine();
                        presenter.updateAnimal(presenter.addAllAnimals(), special, Integer.parseInt(id));
                        break;
                    }
                case "e":
                    flag = false;
                    break;

                default:
                    System.err.println("Действие не найдено. " + "\nВыберите действие (l, a, n, e ): ");
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
    public LocalDate getBirthdate() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите дату рождения (yyyy-MM-dd): ");
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



    private LocalDate parseDate(String dateStr) {
        LocalDate localDate = null;
        try {
            // Определите DateTimeFormatter для ввода формата
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            // Преобразуйте вводимые пользователем данные в LocalDate
            localDate = LocalDate.parse(dateStr, formatter);

        } catch (IncorrectDataTypeException e) {
            System.err.println("Ошибка при анализе даты. Введите дату рождения в формате 'yyyy-MM-dd'. ");
        }
        return localDate;

    }



    private TypeAnimals menuChoice (Scanner in) {
        System.out.println("Какое животное добавить:\n1 - питомец\n2 - вьючное");
        String key = in.nextLine();
        while (true) {
            switch (key) {
                case "1":
                    return TypeAnimals.Pet;
                case "2":
                    return TypeAnimals.Packed;
                case "e":
                    return null;
                default:
                    System.err.println("Такого варианта нет, введите число 1 или 2, \ne - Возврат в основное меню");
                    break;
            }
        }
    }

    private SpecialAnimals menuChoiceSpecialPet (Scanner in) {
        System.out.println("Выберите животное:\n1 - Кошка\n2 - Собака\n3 - Хомяк\ne - Возврат в основное меню");
        String key = in.nextLine();
        while (true) {
            switch (key) {
                case "1", "2", "3":
                    System.out.println("Выбран вид: " + SpecialAnimals.getSpecial(Integer.parseInt(key)));
                    return SpecialAnimals.getSpecial(Integer.parseInt(key));
                case "e":
                    return null;
                default:
                    System.err.println("Такого варианта нет, введите число 1, 2 или 3, \ne - Возврат в основное меню");
                    break;
            }
        }
    }

    private SpecialAnimals menuChoiceSpecialPacked (Scanner in) {
        System.out.println("Выберите животное:\n4 - Лошадь\n5 - Верблюд\n6 - Осёл\ne - Возврат в основное меню");
        String key = in.nextLine();
        while (true) {
            switch (key) {
                case "4", "5", "6":
                    System.out.println("Выбран вид: " + SpecialAnimals.getSpecial(Integer.parseInt(key)));
                    return SpecialAnimals.getSpecial(Integer.parseInt(key));
                case "e":
                    return null;
                default:
                    System.err.println("Такого варианта нет, введите число 4, 5 или 6, \ne - Возврат в основное меню");
                    break;
            }
        }
    }
}
