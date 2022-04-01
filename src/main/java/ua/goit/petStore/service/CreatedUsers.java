package ua.goit.petStore.service;

import ua.goit.petStore.model.userModel.User;

import java.util.ArrayList;
import java.util.List;

public class CreatedUsers {

    public static List<User> usersList = new ArrayList<>();

    public static void addUsers() {
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("AP");
        user1.setFirstName("Andrey");
        user1.setLastName("Petrov");
        user1.setEmail("petrov@gmail.com");
        user1.setPassword("12345678");
        user1.setPhone("+380993332211");
        user1.setUserStatus(1);

        User user2 = new User();
        user2.setId(2);
        user2.setUsername("VS");
        user2.setFirstName("Vitaliy");
        user2.setLastName("Sidorov");
        user2.setEmail("sidorov@gmail.com");
        user2.setPassword("11111111");
        user2.setPhone("+380998887766");
        user2.setUserStatus(1);

        User user1Update = new User();
        user1Update.setId(1);
        user1Update.setUsername("AP");
        user1Update.setFirstName("Andrey");
        user1Update.setLastName("Petrov");
        user1Update.setEmail("petrov@gmail.com");
        user1Update.setPassword("12345678");
        user1Update.setPhone("+380990000001");
        user1Update.setUserStatus(1);

        usersList.add(user1);
        usersList.add(user2);
        usersList.add(user1Update);
    }
}
