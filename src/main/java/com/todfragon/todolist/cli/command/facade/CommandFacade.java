package com.todfragon.todolist.cli.command.facade;

import java.util.List;

import com.todfragon.todolist.cli.command.Command;
import com.todfragon.todolist.cli.command.domain.CommandContext;
import com.todfragon.todolist.cli.command.domain.Input;
import com.todfragon.todolist.cli.command.domain.Output;
import com.todfragon.todolist.cli.command.domain.args.Args;

/**
 * @author sunjing
 */
public final class CommandFacade {

    private static final List<Command> COMMANDS = CommandFactory.create();

    public void handle(final String userInput, final Input input, final Output output) {
        Args args = Args.create(userInput);
        findCommandBy(args.commandName()).execute(CommandContext.create(args, input, output));
    }

    private Command findCommandBy(final String commandName) {
        return COMMANDS.stream().filter(command -> command.name().equals(commandName))
                .findAny().orElse(null);
    }
}
