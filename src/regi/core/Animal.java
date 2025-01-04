package regi.core;

import java.util.Date;

public abstract class Animal {
    protected int id_animal;
    protected String name;
    protected Date birthDate;
    protected String age;
    protected String sex;
    protected String color;
    protected String learned_commands;
    protected SpecialAnimals special_animals;
    protected TypeAnimals type_animals;


    public Animal() {
       super();
   }

       public static Animal createAnimal(SpecialAnimals special, String name, Date birthdate) {

       Animal animal = createNewAnimal(String.valueOf(special));
           if (animal != null) {
               animal.setName(name);
           }
           if (animal != null) {
               animal.setBirthDate(birthdate);
           }
           return  animal;
    }

    public static void create(SpecialAnimals special, String name, Date birthdate, String sex, String color) {
        Animal animal = createAnimal(special, name, birthdate);
        if (animal!= null) {
            animal.setSex(sex);
        }
        if (animal!= null) {
            animal.setColor(color);
        }
        // todo реализовать добавление животного
    }


    public int getId_animal() {
        return id_animal;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getColor() {
        return color;
    }

    public String getLearned_commands() {
        return learned_commands;
    }

    public SpecialAnimals getSpecial_animals() {
        return special_animals;
    }

    public TypeAnimals getType_animals() {
        return type_animals;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }

    public static Animal createNewAnimal(String special) {
        return null;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
