package ua.goit.petStore.controller.commands.userCommands;

import ua.goit.petStore.controller.commands.Command;
import ua.goit.petStore.httpUtils.UserHttpUtil;
import ua.goit.petStore.view.View;

import java.io.IOException;

import static ua.goit.petStore.controller.commands.Commands.INFO_USER;

public class InfoUser implements Command {

    private final View view;

    public InfoUser(View view) {
        this.view = view;
    }

    @Override
    public boolean canProcess(String input) {
        return input.equalsIgnoreCase(INFO_USER.getName());
    }

    @Override
    public void process() {
        view.write("Enter username:");
        String username = view.read();

        try {
            UserHttpUtil.getUserByUsername(username);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
