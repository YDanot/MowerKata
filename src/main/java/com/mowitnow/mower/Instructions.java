package com.mowitnow.mower;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class Instructions {

    private final List<Instruction> instructions = new ArrayList<>();

    public void add(Instruction instruction) {
        this.instructions.add(instruction);
    }

    public void addAll(List<Instruction> instructionList) {
        instructions.addAll(instructionList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instructions that = (Instructions) o;
        return new HashSet<>(instructions).containsAll(that.instructions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instructions);
    }

    public void launchActions(Consumer<Instruction> doAction) {
        instructions.forEach(doAction);
    }
}
