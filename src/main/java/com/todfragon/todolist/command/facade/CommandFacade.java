package com.todfragon.todolist.command.facade;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.todfragon.todolist.command.Command;
import com.todfragon.todolist.command.add.AddItemCommand;
import com.todfragon.todolist.command.domain.CommandContext;
import com.todfragon.todolist.command.domain.args.Args;
import com.todfragon.todolist.command.done.DoneItemCommand;
import com.todfragon.todolist.command.list.ListItemCommand;

/**
 * @author sunjing
 */
public final class CommandFacade {

    private static final List<Command> COMMANDS = ImmutableList.of(
            new AddItemCommand(), new DoneItemCommand(), new ListItemCommand());

    public void handle(final String input) {
        Args args = Args.create(input);
        findCommandBy(args.commandName()).execute(CommandContext.create(args));
    }

    private Command findCommandBy(final String commandName) {
        return COMMANDS.stream().filter(command -> command.name().equals(commandName))
                .findAny().orElse(null);
    }
}
