package com.todfragon.todolist.cli.command.item.list.domain;

import com.todfragon.todolist.cli.command.domain.args.Args;

/**
 * 查看待办项
 *
 * @author sunjing
 */
public final class ListItemArgs {

    private Args args;

    private ListItemArgs() {
    }

    public static ListItemArgs create(Args args) {
        ListItemArgs listItemArgs = new ListItemArgs();
        listItemArgs.args = args;
        return listItemArgs;
    }

    private ListType listType() {
        if (args.parameters().isEmpty()) {
            return ListType.UN_DONE;
        }

        final String queryAllParameterValue = "--all";
        if (args.firstParameter().equals(queryAllParameterValue)) {
            return ListType.ALL;
        }

        throw new RuntimeException("unknown list type!");
    }

    public Boolean isListUnDone() {
        return listType() == ListType.UN_DONE;
    }

    public Boolean isListAll() {
        return listType() == ListType.ALL;
    }

}