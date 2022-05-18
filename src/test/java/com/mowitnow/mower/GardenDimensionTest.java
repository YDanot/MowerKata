package com.mowitnow.mower;

import com.mowitnow.mower.exception.InvalidInitialLimitDimensionException;
import com.mowitnow.mower.parser.GardenDimensionParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GardenDimensionTest {

    @Test
    void parse_valid_garden_limit_dimension() throws InvalidInitialLimitDimensionException {
        String dimensionRaw = "5 5";

        GardenDimension dimensionGarden = new GardenDimensionParser().parse(dimensionRaw);

        assertThat(dimensionGarden.limitX()).isEqualTo(5);
        assertThat(dimensionGarden.limitY()).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"A,5", "5,A", "A,A"})
    void raise_an_invalid_initial_limit_dimension_exception_when_given_format_is_not_valid(String dimensionRaw) {
        assertThrows(InvalidInitialLimitDimensionException.class, () -> new GardenDimensionParser().parse(dimensionRaw));
    }
}