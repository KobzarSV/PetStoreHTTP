package ua.goit.petStore.controller.commands;

import ua.goit.petStore.httpUtils.UserHttpUtil;
import ua.goit.petStore.model.userModel.User;
import ua.goit.petStore.view.View;

import java.io.IOException;

import static ua.goit.petStore.controller.commands.Commands.USER_LOGIN;

public class UserLogin implements Command {

    private final View view;

    public UserLogin(View view) {
        this.view = view;
    }

    @Override
    public boolean canProcess(String input) {
        return input.equals(USER_LOGIN.getName());
    }

    @Override
    public void process() {
        view.write("Enter username:");
        String username = view.read();
        view.write("Enter password:");
        String password = view.read();

        User user = new User(username, password);
        try {
            UserHttpUtil.userLogin(username, password);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        view.write("Login successful. \n" +
                "Hello " + username);
    }
}
