package ua.goit.petStore.service;

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

        Category cat = new Category();
        cat.setId(2);
        cat.setName("cat");

        List<Tag> tagList = new ArrayList<>();
        Tag tag = new Tag();
        tag.setId(1);
        tag.setName("white");
        tagList.add(tag);

        Pet pet1 = new Pet();
        pet1.setId(1);
        pet1.setCategory(dog);
        pet1.setName("Dogie");
        pet1.setPhotoUrls(List.of(
                "https://mobimg.b-cdn.net/v3/fetch/0e/0e26b1b65946ee36fac9605ae67e4ac8.jpeg"));
        pet1.setTags(tagList);
        pet1.setStatus(PetStatus.AVAILABLE.name().toLowerCase());

        Pet pet1Update = new Pet();
        pet1Update.setId(1);
        pet1Update.setCategory(dog);
        pet1Update.setName("Dogie");
        pet1Update.setPhotoUrls(List.of(
                "https://mobimg.b-cdn.net/v3/fetch/0e/0e26b1b65946ee36fac9605ae67e4ac8.jpeg"));
        pet1Update.setTags(tagList);
        pet1Update.setStatus(PetStatus.SOLD.name().toLowerCase());

        Pet pet2 = new Pet();
        pet2.setId(2);
        pet2.setCategory(dog);
        pet2.setName("Sharik");
        pet2.setPhotoUrls(List.of(
                "https://post.medicalnewstoday.com/wp-content/uploads/sites/3/2020/02/322868_1100-800x825.jpg"));
        pet2.setTags(tagList);
        pet2.setStatus(PetStatus.AVAILABLE.name().toLowerCase());

        Pet pet3 = new Pet();
        pet3.setId(3);
        pet3.setCategory(cat);
        pet3.setName("Myrchik");
        pet3.setPhotoUrls(List.of(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQREFaMHccdkm6eJZdnDwrF_2sKIyoQMk0sXQ&usqp=CAU"));
        pet3.setTags(tagList);
        pet3.setStatus(PetStatus.AVAILABLE.name().toLowerCase());

        petsList.add(pet1);
        petsList.add(pet2);
        petsList.add(pet3);
        petsList.add(pet1Update);
    }
}
