package com.mowitnow.mower;

/*
MowerMovement pourquoi pas mais pourquoi un record ?
et pourquoi position en tant qu'attribut ?
Il serait plus clair de mettre directement le mower en tant qu'attribut dans ce cas là
 */
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
        switch (direction) {
            case NORTH -> position.setY(position.getY() + 1);
            case EAST -> position.setX(position.getX() + 1);
            case SOUTH -> position.setY(position.getY() - 1);
            case WEST -> position.setX(position.getX() - 1);
        }
    }

}

