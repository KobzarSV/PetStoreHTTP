package ua.goit.petStore.controller.commands.userCommands;

import ua.goit.petStore.controller.commands.Command;
import ua.goit.petStore.httpUtils.UserHttpUtil;
import ua.goit.petStore.model.userModel.User;
import ua.goit.petStore.view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ua.goit.petStore.controller.commands.Commands.CREATE_USER;

public class CreateUser implements Command {

    private final View view;

    public CreateUser(View view) {
        this.view = view;
    }

    @Override
    public boolean canProcess(String input) {
        return input.equals(CREATE_USER.getName());
    }

    @Override
    public void process() {
        view.write("Enter username");
        String username = view.read();
        view.write("Enter first name:");
        String firstName = view.read();
        view.write("Enter last name:");
        String lastName = view.read();
        view.write("Enter email:");
        String email = view.read();
        view.write("Enter password:");
        String password = view.read();
        view.write("Enter phone number:");
        String phone = view.read();

        User user = new User(username, firstName, lastName, email, password, phone);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        try {
            UserHttpUtil.createUserWithList(userList);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        view.write("User created");
    }
}
