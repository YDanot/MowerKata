package com.mowitnow.mower.parser;

import com.mowitnow.mower.GardenDimension;
import com.mowitnow.mower.Program;
import com.mowitnow.mower.exception.IllegalPositionException;
import com.mowitnow.mower.exception.InvalidInitialLimitDimensionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.mowitnow.mower.utils.FileUtils.getContent;
import static org.assertj.core.api.Assertions.assertThat;

public class ProgramParserTest {

    private String fileContent;

    @BeforeEach
    void setUp() throws URISyntaxException, IOException {
        fileContent = getContent("parser.command", ProgramParser.class);
    }

    @Test
    void must_initialize_mower_coordinate() throws InvalidInitialLimitDimensionException, IllegalPositionException {
        Program program = new ProgramParser().parse(fileContent);
        assertThat(program.dimensionGarden()).isEqualTo(new GardenDimension(5, 5));
    }

}
