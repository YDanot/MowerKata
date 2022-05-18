package com.mowitnow.mower.parser;

import com.mowitnow.mower.Direction;
import com.mowitnow.mower.Position;
import com.mowitnow.mower.exception.IllegalPositionException;

import java.util.Optional;

public class PositionParser {

    public Position parse(String originPositionRaw) throws IllegalPositionException {
        try {
            String[] originArraySpited = originPositionRaw.split(" ");
            int x = Integer.parseInt(originArraySpited[0]);
            int y = Integer.parseInt(originArraySpited[1]);

            Optional<Direction> optionalDirection = Direction.of(originArraySpited[2]);
            Direction direction = optionalDirection.orElseThrow(() -> new IllegalPositionException("Unable to parse direction"));

            return new Position(x, y , direction);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalPositionException(numberFormatException.getMessage(), numberFormatException);
        }
    }
}
