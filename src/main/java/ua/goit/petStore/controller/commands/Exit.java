package ua.goit.petStore.controller.commands;

import ua.goit.petStore.exception.ExitException;
import ua.goit.petStore.view.View;

import static ua.goit.petStore.controller.commands.Commands.EXIT;

public class Exit implements Command {

    private final View view;

    public Exit(View view) {
        this.view = view;
    }

    @Override
    public boolean canProcess(String input) {
        return input.equals(EXIT.getName());
    }

    @Override
    public void process() {
        throw new ExitException();
    }
}
