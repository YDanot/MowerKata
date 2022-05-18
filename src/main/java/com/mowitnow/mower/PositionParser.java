package com.mowitnow.mower;

public class PositionParser {

    public Position parse(String originPositionRaw) throws IllegalPositionException {
        try {
            int x = Integer.parseInt(originPositionRaw.split(" ")[0]);
            int y = Integer.parseInt(originPositionRaw.split(" ")[1]);

            String direction = originPositionRaw.split(" ")[2];

            return new Position(x, y , direction);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalPositionException(numberFormatException.getMessage(), numberFormatException);
        }
    }
}
