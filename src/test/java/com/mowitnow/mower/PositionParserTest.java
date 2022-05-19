package com.mowitnow.mower;
// probablement une erreur de package ce test devrait être dans com.mowitnow.mower.parser
import com.mowitnow.mower.exception.IllegalPositionException;
import com.mowitnow.mower.parser.PositionParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.mowitnow.mower.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PositionParserTest {

    @Test
    // ce test est très bien, toutes les données nécessaires à sa compréhension sont accessible directement
    // sans avoir à ouvrir un autre fichier
    void parse_valid_position_from_origin() throws IllegalPositionException {
        String originPositionRaw = "0 0 N";

        Position initialPosition = new PositionParser().parse(originPositionRaw);

        assertThat(initialPosition.getX()).isEqualTo(0);
        assertThat(initialPosition.getY()).isEqualTo(0);
        assertThat(initialPosition.getDirection()).isEqualTo(NORTH);
    }

    @ParameterizedTest
    @ValueSource(strings = {"N 0 0", "0 N 0", "N N N"})
    void must_raise_illegal_position_exception_when_position_is_invalid(String originPositionRaw) {
        assertThrows(IllegalPositionException.class, () -> new PositionParser().parse(originPositionRaw));
    }

    @Test
    void must_raise_illegal_position_exception_when_direction_is_invalid() {
        String originPositionRaw = "0 0 0";

        IllegalPositionException illegalPositionException = assertThrows(IllegalPositionException.class,
                () -> new PositionParser().parse(originPositionRaw), "IllegalPositionException was expected");

        assertThat(illegalPositionException.getMessage()).isEqualTo("Unable to parse direction");
    }
}
