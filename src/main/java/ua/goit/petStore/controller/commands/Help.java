package ua.goit.petStore.controller.commands;

import ua.goit.petStore.view.View;

import static ua.goit.petStore.controller.commands.Commands.*;

public class Help implements Command {

    private final View view;

    public Help(View view) {
        this.view = view;
    }

    @Override
    public boolean canProcess(String input) {
        return input.equals(HELP.getName());
    }

    @Override
    public void process() {
        view.write("Enter \"" + HELP.getName() + "\" to see available commands.");
        view.write("Enter \"" + EXIT.getName() + "\" to exit.");
        view.write("Enter \"" + CREATE_USER.getName() + "\" to create user");
        view.write("Enter \"" + USER_LOGIN.getName() + "\" for log in");
        view.write("Enter \"" + USER_LOGOUT.getName() + "\" for log out");
        view.write("Enter \"" + INFO_PETS.getName() + "\" view pets by status");
        view.write("Enter \"" + CREATE_ORDER.getName() + "\" to create order");
        view.write("Enter \"" + INFO_ABOUT_ORDER.getName() + "\" to info order");
    }
}
