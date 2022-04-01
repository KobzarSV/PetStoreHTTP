package ua.goit.petStore.controller.commands;

import ua.goit.petStore.httpUtils.PetHttpUtil;
import ua.goit.petStore.model.petModel.PetStatus;
import ua.goit.petStore.view.View;

import java.io.IOException;

import static ua.goit.petStore.controller.commands.Commands.INFO_PETS;

public class InfoPets implements Command {

    private final View view;
    PetStatus petStatus;

    public InfoPets(View view) {
        this.view = view;
    }

    @Override
    public boolean canProcess(String input) {
        return input.equals(INFO_PETS.getName());
    }

    @Override
    public void process() {
        view.write("Enter status pet\n" +
                "Example: \"available\" or \"a\", \"pending\" of \"p\", \"sold\" or \"s\"");
        String status = view.read();
        if (status.equalsIgnoreCase("available") | status.equalsIgnoreCase("a")) {
            petStatus = PetStatus.AVAILABLE;
        } else if (status.equalsIgnoreCase("pending") | status.equalsIgnoreCase("p")) {
            petStatus = PetStatus.PENDING;
        } else if (status.equalsIgnoreCase("sold") | status.equalsIgnoreCase("s")) {
            petStatus = PetStatus.SOLD;
        } else {
            view.write("Incorrect command. Please, try again.\n" +
                    "Example: available or a, pending of p, sold or s");
        }
        try {
            PetHttpUtil.getPetByStatus(petStatus);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
