package com.todfragon.todolist.cli.command.domain;

import com.todfragon.todolist.cli.command.domain.args.Args;

import lombok.Getter;

/**
 * 上下文
 *
 * @author sunjing
 */
@Getter
public final class CommandContext {

    private Args args;

    private CommandContext() {
    }

    public static CommandContext create(Args args) {
        CommandContext context = new CommandContext();
        context.args = args;
        return context;
    }
}
