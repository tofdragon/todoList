package com.todfragon.todolist.cli.command.facade;

import java.util.List;

import com.todfragon.todolist.cli.command.Command;
import com.todfragon.todolist.cli.command.domain.CommandContext;
import com.todfragon.todolist.cli.command.domain.args.Args;

/**
 * @author sunjing
 */
public final class CommandFacade {

    private static final List<Command> COMMANDS = CommandFactory.create();

    public void handle(final String input) {
        Args args = Args.create(input);
        findCommandBy(args.commandName()).execute(CommandContext.create(args));
    }

    private Command findCommandBy(final String commandName) {
        return COMMANDS.stream().filter(command -> command.name().equals(commandName))
                .findAny().orElse(null);
    }
}
