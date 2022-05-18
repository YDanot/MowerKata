package com.mowitnow.mower.parser;

import com.mowitnow.mower.Command;
import com.mowitnow.mower.exception.CommandUnknownException;

public class CommandParser {
    public Command parse(String commandRaw) throws CommandUnknownException {
        return Command
                .of(commandRaw)
                .orElseThrow(() -> new CommandUnknownException("Command unknown exception " + commandRaw));
    }
}
