package com.mowitnow.mower.parser;

import com.mowitnow.mower.GardenDimension;
import com.mowitnow.mower.Position;
import com.mowitnow.mower.Program;
import com.mowitnow.mower.exception.IllegalPositionException;
import com.mowitnow.mower.exception.InvalidInitialLimitDimensionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.mowitnow.mower.Direction.NORTH;
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

        //difficile de comprendre ici pourquoi ton test devrait passer
        // il faut aller ouvrir le fichier etc...
        // tu devrais plutôt écrire en dur la configuration dans ton test pour plus de clarter
        assertThat(program.dimensionGarden()).isEqualTo(new GardenDimension(5, 5));
    }

    @Test
    void must_initialize_position() throws InvalidInitialLimitDimensionException, IllegalPositionException {
        Program program = new ProgramParser().parse(fileContent);

        //difficile de comprendre ici pourquoi ton test devrait passer
        // il faut aller ouvrir le fichier etc...
        // tu devrais plutôt écrire en dur la liste d'instruction dans ton test pour plus de clarter
        assertThat(program.getMowerPosition(0)).isEqualTo(new Position(1, 2, NORTH));
    }

}
