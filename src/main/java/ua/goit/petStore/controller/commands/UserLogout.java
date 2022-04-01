package ua.goit.petStore.controller.commands;

import ua.goit.petStore.httpUtils.UserHttpUtil;
import ua.goit.petStore.view.View;

import java.io.IOException;

import static ua.goit.petStore.controller.commands.Commands.USER_LOGOUT;

public class UserLogout implements Command {

    private final View view;

    public UserLogout(View view) {
        this.view = view;
    }

    @Override
    public boolean canProcess(String input) {
        return input.equals(USER_LOGOUT.getName());
    }

    @Override
    public void process() {

        try {
            UserHttpUtil.userLogout();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        view.write("Exit successful. \n" +
                "Good buy!");
    }
}
