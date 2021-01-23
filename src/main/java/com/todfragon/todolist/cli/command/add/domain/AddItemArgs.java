package com.todfragon.todolist.cli.command.add.domain;

import com.todfragon.todolist.cli.command.domain.args.Args;

/**
 * 增加待办项参数
 *
 * @author sunjing
 */
public final class AddItemArgs {

    private Args args;

    private AddItemArgs() {
    }

    public static AddItemArgs create(Args args) {
        AddItemArgs addItemArgs = new AddItemArgs();
        addItemArgs.args = args;
        return addItemArgs;
    }

    public String getItemName() {
        return this.args.firstParameter();
    }
}
