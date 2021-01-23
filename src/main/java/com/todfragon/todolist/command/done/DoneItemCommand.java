package com.todfragon.todolist.command.done;

import com.todfragon.todolist.command.AbstractCommand;
import com.todfragon.todolist.command.domain.CommandContext;
import com.todfragon.todolist.command.done.domain.DoneItemArgs;

/**
 * 完成待办命令
 *
 * @author sunjing
 */
public class DoneItemCommand extends AbstractCommand {

    public static final String NAME = "done";

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public void execute(CommandContext commandContext) {
        DoneItemArgs doneItemArgs = DoneItemArgs.create(commandContext.getArgs());

        outputLn("Item " + doneItemArgs.getItemIndex() + " done");
    }
}
