package com.mowitnow.mower.parser;

import com.mowitnow.mower.Command;
import com.mowitnow.mower.exception.CommandUnknownException;

public class CommandParser {
    public Instruction parse(String commandRaw) throws CommandUnknownException {

        return Instruction
                .of(commandRaw)
                .orElseThrow(() -> new CommandUnknownException("Command unknown exception " + commandRaw));
    }
}
