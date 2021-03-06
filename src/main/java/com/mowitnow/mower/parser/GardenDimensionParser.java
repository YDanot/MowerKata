package com.mowitnow.mower.parser;

import com.mowitnow.mower.GardenDimension;
import com.mowitnow.mower.exception.InvalidInitialLimitDimensionException;

public class GardenDimensionParser {

    public GardenDimension parse(String dimensionRaw) throws InvalidInitialLimitDimensionException {
        try {

            int limitX = Integer.parseInt(dimensionRaw.split(" ")[0]);
            int limitY = Integer.parseInt(dimensionRaw.split(" ")[1]);
            return new GardenDimension(limitX, limitY);
        } catch (NumberFormatException numberFormatException) {
            throw new InvalidInitialLimitDimensionException(numberFormatException.getMessage(), numberFormatException);
        }
    }
}
