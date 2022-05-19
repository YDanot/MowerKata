package com.mowitnow.mower.parser;

import com.mowitnow.mower.*;
import com.mowitnow.mower.exception.IllegalPositionException;
import com.mowitnow.mower.exception.InvalidInitialLimitDimensionException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*
C'est plutôt une bonne chose d'isoler la logique de parsing dans une classe à part
Les différentes sous-parser (com.mowitnow.mower.parser.CommandParser, com.mowitnow.mower.parser.GardenDimensionParser...)
ne sont pas indispensable et pourrait se retrouver dans des simples méthodes ici, ou transformer ces classes en inner class
Mais c'est du chipotage ;-)
 */
public class ProgramParser {

    public Program parse(String configurationRaw) throws InvalidInitialLimitDimensionException, IllegalPositionException {
        String[] configurationArray = configurationRaw.split(System.lineSeparator());

        GardenDimension dimensionGarden = new GardenDimensionParser().parse(configurationArray[0]);
        Mowers mowers = new Mowers();

        for (int i = 1; i < configurationArray.length ;i+=2){
            Position position = new PositionParser().parse(configurationArray[i]);
            Instructions instructions = getLineInstruction(configurationArray[i + 1]);
            mowers.addMover(new Mower(position, instructions));
        }


        return new Program(dimensionGarden, mowers);
    }

    private Instructions getLineInstruction(String commandRaw) {
        List<Instruction> instructionList = commandRaw.chars()
                .mapToObj(Character::toString)
                .map(Instruction::of)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        Instructions instructions = new Instructions();
        instructions.addAll(instructionList);
        return instructions;
    }
}
