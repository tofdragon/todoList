package com.todfragon.todolist.cli.command.security;

import com.todfragon.todolist.cli.command.AbstractCommand;
import com.todfragon.todolist.cli.command.Command;
import com.todfragon.todolist.cli.command.domain.CommandContext;

/**
 * 需要登录命令
 *
 * @author sunjing
 */
public final class NeedLoginCommand extends AbstractCommand {

    private final Command command;

    public NeedLoginCommand(Command command) {
        this.command = command;
    }

    @Override
    public String name() {
        return command.name();
    }

    @Override
    public void execute(CommandContext commandContext) {
        if (commandContext.getSession().isLoginIn()) {
            this.command.execute(commandContext);
            return;
        }
        commandContext.getOutput().infoLn("User is not logged in, please log in!");
    }
}
