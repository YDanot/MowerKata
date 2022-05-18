package com.mowitnow.mower;

import com.mowitnow.mower.parser.ProgramParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.mowitnow.mower.Direction.EAST;
import static com.mowitnow.mower.Direction.NORTH;
import static com.mowitnow.mower.utils.FileUtils.getContent;
import static org.assertj.core.api.Assertions.assertThat;

public class MowerProgramTest {

    private Program program;

    @BeforeEach
    void setUp() throws Exception {
        String fileContent = getContent("program.command", MowerProgramTest.class);
        program = new ProgramParser().parse(fileContent);
    }

    @Test
    void move_all_mowers_to_specific_position() {
        program.start();
        assertThat(program.getMowerPosition(0)).isEqualTo(new Position(1, 3, NORTH));
        assertThat(program.getMowerPosition(1)).isEqualTo(new Position(5, 1, EAST));
    }
}
