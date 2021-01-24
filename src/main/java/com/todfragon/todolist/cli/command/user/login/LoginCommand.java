package com.todfragon.todolist.cli.command.user.login;

import com.todfragon.todolist.cli.command.AbstractCommand;
import com.todfragon.todolist.cli.command.domain.CommandContext;
import com.todfragon.todolist.cli.command.user.login.domain.LoginArgs;

/**
 * 登录
 *
 * @author sunjing
 */
public final class LoginCommand extends AbstractCommand {

    private static final String NAME = "login";

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public void execute(CommandContext commandContext) {
        LoginArgs loginArgs = LoginArgs.create(commandContext.getArgs());

        commandContext.getOutput().info("Password:");

        String password = commandContext.getInput().nextLine();
        commandContext.getOutput().infoLn("Login success!");
    }
}
