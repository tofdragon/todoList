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

    private Output output;

    private Input input;

    private CommandContext() {
    }

    public static CommandContext create(Args args, Input input, Output output) {
        CommandContext context = new CommandContext();
        context.args = args;
        context.input = input;
        context.output = output;
        return context;
    }
}
