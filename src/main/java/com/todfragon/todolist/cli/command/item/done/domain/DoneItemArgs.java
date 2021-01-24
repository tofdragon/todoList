package com.todfragon.todolist.cli.command.item.done.domain;

import com.todfragon.todolist.cli.command.domain.args.Args;

/**
 * 完成待办项参数
 *
 * @author sunjing
 */
public final class DoneItemArgs {

    private Args args;

    private DoneItemArgs() {
    }

    public static DoneItemArgs create(Args args) {
        DoneItemArgs doneItemArgs = new DoneItemArgs();
        doneItemArgs.args = args;
        return doneItemArgs;
    }

    public Integer getItemIndex() {
        return Integer.parseInt(this.args.firstParameter());
    }
}
