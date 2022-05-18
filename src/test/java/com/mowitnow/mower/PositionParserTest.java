package com.mowitnow.mower;
import org.junit.jupiter.api.Test;

import static com.mowitnow.mower.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PositionParserTest {

    @Test
    void parse_valid_position_from_origin() throws IllegalPositionException {
        String originPositionRaw = "0 0 N";
        Position initialPosition = new PositionParser().parse(originPositionRaw);

        assertThat(initialPosition.x()).isEqualTo(0);
        assertThat(initialPosition.x()).isEqualTo(0);
        assertThat(initialPosition.direction()).isEqualTo(NORTH);
    }
}
