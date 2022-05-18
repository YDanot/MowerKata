package com.mowitnow.mower;

import java.util.Optional;
import java.util.stream.Stream;

public enum Direction {
    NORTH("N"),
    WEST("W"),
    EAST("E"),
    SOUTH("S");

    private final String command;

    Direction(String command) {
        this.command = command;
    }

    public static Optional<Direction> of(String command) {
        return Stream.of(values())
                .filter(direction -> direction.getCommand().equals(command))
                .findFirst();
    }

    public String getCommand() {
        return command;
    }
}
