package com.mowitnow.mower;

import static com.mowitnow.mower.Direction.*;

public record MowerMovement(Position position) {

    public void doAction(Instruction instruction) {
        Direction direction = position.getDirection();

        switch (instruction) {
            case LEFT -> position.setDirection(direction.getLeft());
            case RIGHT -> position.setDirection(direction.getRight());
            case FORWARD -> moveToDesiredDirection(direction);
        }

    }

    private void moveToDesiredDirection(Direction direction) {
        if (direction == NORTH) {
            position.setY(position.getY() + 1);
        } else if (direction == EAST) {
            position.setX(position.getX() + 1);
        } else if (direction == SOUTH) {
            position.setY(position.getY() - 1);
        } else if (direction == WEST) {
            position.setX(position.getX() - 1);
        }
    }

}

