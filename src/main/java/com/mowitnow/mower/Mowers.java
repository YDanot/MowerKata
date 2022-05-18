package com.mowitnow.mower;

import java.util.ArrayList;
import java.util.List;

public class Mowers {

    private final List<Mower> mowers = new ArrayList<>();

    public void addMover(Mower mower) {
        mowers.add(mower);
    }

    public Position getMoverPositionBy(int index) {
        Mower mower = mowers.get(index);
        return mower.position();
    }

    public Instructions getInstructionBy(int index) {
        Mower mower = mowers.get(index);
        return mower.instructions();
    }

    public void start() {
        mowers.forEach(Mower::start);
    }
}
