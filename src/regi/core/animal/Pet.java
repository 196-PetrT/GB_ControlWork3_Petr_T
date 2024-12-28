package regi.core.animal;

import java.util.List;

public interface Pet <T> {

    List <T> getAll();
    T getBy_Pets_id(int Pets_id);
    void setPets_id(String Pets_id);
    String getSpecies_pets();
    void setSpecies_pets(String Species_pets);
    String getType_animals();
    void setType_animals(String Type_animals);

}
