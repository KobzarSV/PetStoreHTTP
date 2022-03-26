package ua.goit.petStore.model.petModel;

import ua.goit.petStore.model.petModel.Category;
import ua.goit.petStore.model.petModel.Pet;
import ua.goit.petStore.model.petModel.PetStatus;
import ua.goit.petStore.model.petModel.Tag;

import java.util.ArrayList;
import java.util.List;

public class CreatedPets {

    public static List<Pet> petsList = new ArrayList<>();

    public static void addPets() {
        Category dog = new Category();
        dog.setId(1);
        dog.setName("dog");

        List<Tag> tagList = new ArrayList<>();
        Tag tag = new Tag();
        tag.setId(1);
        tag.setName("white");
        tagList.add(tag);

        Pet pet1 = new Pet();
        pet1.setId(1);
        pet1.setCategory(dog);
        pet1.setName("Dogie");
        pet1.setPhotoUrls(List.of("Dogie Photo"));
        pet1.setTags(tagList);
        pet1.setStatus(PetStatus.AVAILABLE);

        Pet pet1Update = new Pet();
        pet1Update.setId(1);
        pet1Update.setCategory(dog);
        pet1Update.setName("Dogie");
        pet1Update.setPhotoUrls(List.of("Dogie Photo"));
        pet1Update.setTags(tagList);
        pet1Update.setStatus(PetStatus.SOLD);

        petsList.add(pet1);
        petsList.add(pet1Update);
    }
}
