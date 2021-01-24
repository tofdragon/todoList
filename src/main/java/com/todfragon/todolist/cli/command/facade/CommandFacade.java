package com.todfragon.todolist.cli.command.facade;

import java.util.List;

import com.todfragon.todolist.cli.Session;
import com.todfragon.todolist.cli.command.Command;
import com.todfragon.todolist.cli.command.domain.CommandContext;
import com.todfragon.todolist.cli.command.domain.Input;
import com.todfragon.todolist.cli.command.domain.Output;
import com.todfragon.todolist.cli.command.domain.args.Args;

/**
 * @author sunjing
 */
public final class CommandFacade {

    private final List<Command> commands;

    private final Session session;

    public CommandFacade() {
        this.session = new Session();
        this.commands = CommandFactory.create(session);
    }

    public void handle(final String userInput, final Input input, final Output output) {
        Args args = Args.create(userInput);
        findCommandBy(args.commandName()).execute(CommandContext.create(args, input, output, session));
    }

    private Command findCommandBy(final String commandName) {
        return commands.stream().filter(command -> command.name().equals(commandName))
                .findAny().orElse(null);
    }
}
