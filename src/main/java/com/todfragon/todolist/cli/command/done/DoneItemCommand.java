package com.todfragon.todolist.cli.command.done;

import com.todfragon.todolist.cli.command.AbstractCommand;
import com.todfragon.todolist.cli.command.domain.CommandContext;
import com.todfragon.todolist.cli.command.done.domain.DoneItemArgs;
import com.todfragon.todolist.service.TodoListService;

/**
 * 完成待办命令
 *
 * @author sunjing
 */
public final class DoneItemCommand extends AbstractCommand {

    private static final String NAME = "done";

    private final TodoListService todoListService;

    public DoneItemCommand(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public void execute(CommandContext commandContext) {
        DoneItemArgs doneItemArgs = DoneItemArgs.create(commandContext.getArgs());

        todoListService.doneItem(doneItemArgs.getItemIndex());

        outputLn(String.format("Item %s done", doneItemArgs.getItemIndex()));
    }
}
