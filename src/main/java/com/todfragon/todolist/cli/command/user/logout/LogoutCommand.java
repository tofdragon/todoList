package com.todfragon.todolist.cli.command.user.logout;

import com.todfragon.todolist.cli.command.AbstractCommand;
import com.todfragon.todolist.cli.command.domain.CommandContext;

/**
 * 退出
 *
 * @author sunjing
 */
public final class LogoutCommand extends AbstractCommand {

    private static final String NAME = "logout";

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public void execute(CommandContext commandContext) {
        commandContext.getOutput().infoLn("Logout success!");
    }
}
