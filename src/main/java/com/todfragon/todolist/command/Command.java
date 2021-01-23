package com.todfragon.todolist.command;

import com.todfragon.todolist.command.domain.CommandContext;

/**
 * 执行
 *
 * @author sunjing
 */
public interface Command {

    /**
     * 名称
     *
     * @return 名称
     */
    String name();

    /**
     * 执行
     *
     * @param commandContext 上下文
     */
    void execute(CommandContext commandContext);
}
