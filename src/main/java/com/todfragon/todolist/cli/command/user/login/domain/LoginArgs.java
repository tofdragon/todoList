package com.todfragon.todolist.cli.command.user.login.domain;

import com.todfragon.todolist.cli.command.domain.args.Args;

/**
 * 登录
 *
 * @author sunjing
 */
public class LoginArgs {

    private Args args;

    private LoginArgs() {
    }

    public static LoginArgs create(Args args) {
        LoginArgs loginArgs = new LoginArgs();
        loginArgs.args = args;
        return loginArgs;
    }

    public String userName() {
        final Integer userNameIndex = 1;
        return this.args.parameter(userNameIndex);
    }
}
