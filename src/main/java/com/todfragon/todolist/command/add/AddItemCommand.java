package com.todfragon.todolist.command.add;

import com.todfragon.todolist.command.AbstractCommand;
import com.todfragon.todolist.command.add.domain.AddItemArgs;
import com.todfragon.todolist.command.domain.CommandContext;

/**
 * 增加待办项命令
 *
 * @author sunjing
 */
public final class AddItemCommand extends AbstractCommand {

    public static final String NAME = "add";

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public void execute(CommandContext commandContext) {
        AddItemArgs addItemArgs = AddItemArgs.create(commandContext.getArgs());

        outputLn("1." + addItemArgs.getItemName());
        outputLn("Item " + 1 + " added");
    }
}
