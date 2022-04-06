package ua.goit.petStore.controller.commands.userCommands;

import ua.goit.petStore.controller.commands.Command;
import ua.goit.petStore.httpUtils.UserHttpUtil;
import ua.goit.petStore.model.userModel.User;
import ua.goit.petStore.view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ua.goit.petStore.controller.commands.Commands.UPDATE_USER;

public class UpdateUser implements Command {

    private final View view;

    public UpdateUser(View view) {
        this.view = view;
    }

    @Override
    public boolean canProcess(String input) {
        return input.equalsIgnoreCase(UPDATE_USER.getName());
    }

    @Override
    public void process() {
        view.write("Enter username:");
        String username = view.read();
        try {
            UserHttpUtil.getUserForUpdate(username);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        long id = Long.parseLong(UserHttpUtil.id.substring(6).replace(",", ""));
        int status = Integer.parseInt(UserHttpUtil.status.substring(13).replace("}", ""));

        view.write("Enter new values");
        view.write("If the value does not change, press \"Enter\"");

        view.write("Enter username");
        String newUsername = view.read();
        if (newUsername.equals("")) {
            newUsername = UserHttpUtil.username.substring(12).replace("\"", "");
        }
        view.write("Enter first name:");
        String firstName = view.read();
        if (firstName.equals("")) {
            firstName = UserHttpUtil.firstName.substring(13).replace("\"", "");
        }
        view.write("Enter last name:");
        String lastName = view.read();
        if (lastName.equals("")) {
            lastName = UserHttpUtil.lastName.substring(12).replace("\"", "");
        }
        view.write("Enter email:");
        String email = view.read();
        if (email.equals("")) {
            email = UserHttpUtil.email.substring(9).replace("\"", "");
        }
        view.write("Enter password:");
        String password = view.read();
        if (password.equals("")) {
            password = UserHttpUtil.password.substring(12).replace("\"", "");
        }
        view.write("Enter phone number:");
        String phone = view.read();
        if (phone.equals("")) {
            phone = UserHttpUtil.phone.substring(9).replace("\"", "");
        }

        User user = new User(id, newUsername, firstName, lastName, email, password, phone, status);
        try {
            UserHttpUtil.updateUserPut(username, user);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        view.write("User updated");
    }
}
