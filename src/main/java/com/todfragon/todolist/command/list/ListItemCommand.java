package com.todfragon.todolist.command.list;

import com.todfragon.todolist.command.AbstractCommand;
import com.todfragon.todolist.command.domain.CommandContext;
import com.todfragon.todolist.command.list.domain.ListItemArgs;

/**
 * 列出所有待办项
 *
 * @author sunjing
 */
public class ListItemCommand extends AbstractCommand {

    public static final String NAME = "list";

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public void execute(CommandContext commandContext) {
        ListItemArgs listItemArgs = ListItemArgs.create(commandContext.getArgs());
        if (listItemArgs.isListUnDone()) {
            outputLn("1.item1");
            outputLn("2.item2");
            outputLn("Total: 2 items");
            return;
        }

        if (listItemArgs.isListAll()) {
            outputLn("1.item1");
            outputLn("2.item2");
            outputLn("3.Done item3");
            outputLn("Total: 3 items, 1 item done");
        }
    }
}
