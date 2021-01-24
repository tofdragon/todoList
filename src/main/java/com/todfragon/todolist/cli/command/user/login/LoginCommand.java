package com.todfragon.todolist.cli.command.user.login;

import com.todfragon.todolist.cli.command.AbstractCommand;
import com.todfragon.todolist.cli.command.domain.CommandContext;
import com.todfragon.todolist.cli.command.user.login.domain.LoginArgs;
import com.todfragon.todolist.user.service.UserService;

/**
 * 登录
 *
 * @author sunjing
 */
public final class LoginCommand extends AbstractCommand {

    private static final String NAME = "login";

    private final UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public void execute(CommandContext commandContext) {
        LoginArgs loginArgs = LoginArgs.create(commandContext.getArgs());

        commandContext.getOutput().info("Password:");

        String password = commandContext.getInput().nextLine();

        if (userService.isLoginSuccess(loginArgs.userName(), password)) {
            commandContext.getSession().loginIn(loginArgs.userName());
            commandContext.getOutput().infoLn("Login success!");
            return;
        }
        commandContext.getOutput().infoLn("Login failed, username or password is incorrect!");
    }
}
