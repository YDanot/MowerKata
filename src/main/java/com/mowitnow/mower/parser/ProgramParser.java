package com.mowitnow.mower.parser;

import com.mowitnow.mower.GardenDimension;
import com.mowitnow.mower.Program;
import com.mowitnow.mower.exception.IllegalPositionException;
import com.mowitnow.mower.exception.InvalidInitialLimitDimensionException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProgramParser {

    public Program parse(String configurationRaw) throws InvalidInitialLimitDimensionException, IllegalPositionException {
        String[] configurationArray = configurationRaw.split(System.lineSeparator());

        GardenDimension dimensionGarden = new GardenDimensionParser().parse(configurationArray[0]);
        return new Program(dimensionGarden);
    }

}
