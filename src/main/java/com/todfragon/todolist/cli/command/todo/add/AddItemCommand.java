package com.todfragon.todolist.cli.command.todo.add;

import com.todfragon.todolist.cli.command.AbstractCommand;
import com.todfragon.todolist.cli.command.domain.CommandContext;
import com.todfragon.todolist.cli.command.todo.add.domain.AddItemArgs;
import com.todfragon.todolist.domain.Item;
import com.todfragon.todolist.service.TodoListService;

/**
 * 增加待办项命令
 *
 * @author sunjing
 */
public final class AddItemCommand extends AbstractCommand {

    private static final String NAME = "add";

    private final TodoListService todoListService;

    public AddItemCommand(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public void execute(CommandContext commandContext) {
        AddItemArgs addItemArgs = AddItemArgs.create(commandContext.getArgs());

        Item addedItem = todoListService.addItem(commandContext.getSession().currentUserName(),
                addItemArgs.getItemName());

        commandContext.getOutput().infoLn(String.format("1.%s", addedItem.name()));
        commandContext.getOutput().infoLn(String.format("Item %s added", addedItem.index()));
    }
}
