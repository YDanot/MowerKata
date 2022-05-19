package com.mowitnow.mower.parser;

import com.mowitnow.mower.Instruction;
import com.mowitnow.mower.exception.CommandUnknownException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*
Ce test et la classe com.mowitnow.mower.Command sont à supprimer
 */
public class CommandParserTest {

    @ParameterizedTest
    @ValueSource(strings = {"B", "C", "F"})
    void raise_an_command_unknown_exception_when_command_is_invalid(String commandRaw) {
        CommandUnknownException commandUnknownException = assertThrows(CommandUnknownException.class,
                () -> new CommandParser().parse(commandRaw), "CommandUnknownException was expected ");

        assertThat(commandUnknownException.getMessage()).isEqualTo("Command unknown exception " + commandRaw);
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "D", "G"})
    void can_parse_valid_command(String commandRaw) throws CommandUnknownException {
        assertThat(Instruction.values()).contains(new CommandParser().parse(commandRaw));
    }
}
