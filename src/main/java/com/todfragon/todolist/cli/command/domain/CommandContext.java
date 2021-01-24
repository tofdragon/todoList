package com.todfragon.todolist.cli.command.domain;

import com.todfragon.todolist.cli.command.domain.args.Args;
import com.todfragon.todolist.security.Session;

import lombok.Builder;
import lombok.Getter;

/**
 * 上下文
 *
 * @author sunjing
 */
@Getter
@Builder
public final class CommandContext {

    private Args args;

    private Output output;

    private Input input;

    private Session session;

    public Boolean isLoginIn() {
        return getSession().isLoginIn();
    }

    public String currentLoginUserName() {
        return getSession().currentUserName();
    }
}
