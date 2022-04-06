package ua.goit.petStore.controller.commands.orderCommands;

import ua.goit.petStore.controller.commands.Command;
import ua.goit.petStore.httpUtils.OrderHttpUtil;
import ua.goit.petStore.view.View;

import java.io.IOException;

import static ua.goit.petStore.controller.commands.Commands.INFO_ABOUT_ORDER;

public class InfoOrder implements Command {

    private final View view;

    public InfoOrder(View view) {
        this.view = view;
    }

    @Override
    public boolean canProcess(String input) {
        return input.equals(INFO_ABOUT_ORDER.getName());
    }

    @Override
    public void process() {
        view.write("Enter pet id:");
        long petId = Long.parseLong(view.read());

        try {
            OrderHttpUtil.getOrderById(petId);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
