package ua.goit.petStore.controller.commands;

public interface Command {

    boolean canProcess(String input);

    void process();
}
