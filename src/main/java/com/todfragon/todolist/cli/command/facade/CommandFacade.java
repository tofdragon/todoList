package com.todfragon.todolist.cli.command.facade;

import java.util.List;
import java.util.Optional;

import com.todfragon.todolist.cli.command.Command;
import com.todfragon.todolist.cli.command.domain.CommandContext;
import com.todfragon.todolist.cli.command.domain.Input;
import com.todfragon.todolist.cli.command.domain.Output;
import com.todfragon.todolist.cli.command.domain.args.Args;
import com.todfragon.todolist.cli.command.facade.exception.NotFoundCommandException;
import com.todfragon.todolist.security.Session;

/**
 * @author sunjing
 */
public final class CommandFacade {

    private final List<Command> commands;

    private final Session session;

    public CommandFacade(Session session) {
        this.session = session;
        this.commands = CommandFactory.create();
    }

    public void handle(final String userInput, final Input input, final Output output) {
        Args args = Args.create(userInput);
        Optional<Command> command = findCommandBy(args.commandName());
        if (!command.isPresent()) {
            throw new NotFoundCommandException(args.commandName());
        }

        CommandContext commandContext =
                CommandContext.builder().args(args).input(input).output(output).session(session).build();
        command.get().execute(commandContext);
    }

    private Optional<Command> findCommandBy(final String commandName) {
        return commands.stream().filter(command -> command.name().equals(commandName)).findAny();
    }
}
