package com.mowitnow.mower;

import java.util.Optional;
import java.util.stream.Stream;

public enum Instruction {
    LEFT("G"),
    RIGHT("D"),
    FORWARD("A");

    private final String action;

    Instruction(String action) {
        this.action = action;
    }

    public static Optional<Instruction> of(String commandRaw) {
        return Stream.of(values())
                .filter(command -> command.getAction().equals(commandRaw))
                .findFirst();
    }

    public String getAction() {
        return action;
    }

}
