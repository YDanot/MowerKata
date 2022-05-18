package com.mowitnow.mower.parser;

import com.mowitnow.mower.Instruction;
import com.mowitnow.mower.exception.CommandUnknownException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InstructionParserTest {

    @ParameterizedTest
    @ValueSource(strings = {"B", "C", "F"})
    void raise_an_command_unknown_exception_when_command_is_invalid(String commandRaw) {
        CommandUnknownException commandUnknownException = assertThrows(CommandUnknownException.class,
                () -> new CommandParser().parse(commandRaw), "CommandUnknownException was expected ");

        assertThat(commandUnknownException.getMessage()).isEqualTo("Command unknown exception " + commandRaw);
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "D", "G"})
    void parse_valid_command(String commandRaw) throws CommandUnknownException {
        Assertions.assertThat(Instruction.values()).contains(new CommandParser().parse(commandRaw));
    }
}

