package ua.goit.petStore.controller;

import ua.goit.petStore.controller.commands.*;
import ua.goit.petStore.controller.commands.orderCommands.CreateOrder;
import ua.goit.petStore.controller.commands.orderCommands.InfoOrder;
import ua.goit.petStore.controller.commands.petCommands.InfoPets;
import ua.goit.petStore.controller.commands.userCommands.*;
import ua.goit.petStore.exception.ExitException;
import ua.goit.petStore.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StoreController {

    private final View view;
    private final List<Command> commands;

    public StoreController(View view) {
        this.view = view;
        this.commands = new ArrayList<>(Arrays.asList(
                new Help(view),
                new Exit(view),
                new CreateUser(view),
                new UserLogin(view),
                new UserLogout(view),
                new InfoUser(view),
                new UpdateUser(view),
                new CreateOrder(view),
                new InfoOrder(view),
                new InfoPets(view)
        ));
    }

    public void run() {
        view.write("Welcome!");
        executeCommand();
    }

    private void executeCommand() {
        try {
            while (true) {
                view.write("Please, enter \"help\" to see available commands:");
                String input = view.read();
                boolean isIncorrectCommand = true;
                for (Command command : commands) {
                    if (command.canProcess(input)) {
                        command.process();
                        isIncorrectCommand = false;
                    }
                }
                if (isIncorrectCommand) {
                    view.write("Incorrect command. Please, try again.");
                }
            }
        } catch (ExitException e) {
            view.write("Good Bye!");
        }
    }
}
