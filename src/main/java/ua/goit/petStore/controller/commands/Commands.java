package ua.goit.petStore.controller.commands;

public enum Commands {
    CREATE_USER("create user"),
    USER_LOGIN("log in"),
    USER_LOGOUT("log out"),
    INFO_PETS("info pets"),
    CREATE_ORDER("create order"),
    INFO_ABOUT_ORDER("info order"),
    HELP("help"),
    EXIT("exit");

    private String name;

    Commands(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
