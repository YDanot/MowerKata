package com.mowitnow.mower;

import java.util.Optional;
import java.util.stream.Stream;

/*
Même commentaire que pour #com.mowitnow.mower.Instruction pour la représentation et le model
 */
public enum Direction {

    NORTH("N", "W", "E"),
    WEST("W", "S", "N"),
    EAST("E", "N", "S"),
    SOUTH("S", "E", "W");

    private final String command;
    private final String left;
    private final String right;

    Direction(String command, String left, String right) {
        this.command = command;
        this.left = left;
        this.right = right;
    }

    public static Optional<Direction> of(String command) {
        return Stream.of(values())
                .filter(direction -> direction.getCommand().equals(command))
                .findFirst();
    }

    public String getCommand() {
        return command;
    }

    public Direction getLeft() {
        return of(left).orElseThrow();
    }

    public Direction getRight() {
        return of(right).orElseThrow();
    }
}
