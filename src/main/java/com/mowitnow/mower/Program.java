package com.mowitnow.mower;

public record Program(GardenDimension dimensionGarden, Mowers mowers) {

    public Position getMowerPosition(int index) {
        return mowers.getMoverPositionBy(index);
    }

    public Instructions getMowerInstructions(int index) {
        return mowers.getInstructionBy(index);
    }
}
