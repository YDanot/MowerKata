package com.mowitnow.mower;

public record Mower(Position position, Instructions instructions) {


    public void start() {
        MowerMovement mowerMovement = new MowerMovement(position);
        instructions.launchActions(mowerMovement::doAction);
    }
}
