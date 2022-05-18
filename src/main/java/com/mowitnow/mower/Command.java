package com.mowitnow.mower;

import java.util.Optional;
import java.util.stream.Stream;

public enum Command {
    LEFT("G"),
    RIGHT("D"),
    FORWARD("A");

    private final String action;

    Command(String action) {
        this.action = action;
    }

    public static Optional<Command> of(String commandRaw) {
        return Stream.of(values())
                .filter(command -> command.getAction().equals(commandRaw))
                .findFirst();
    }

    public String getAction() {
        return action;
    }
}
