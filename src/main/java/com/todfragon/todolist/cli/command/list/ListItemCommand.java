package com.todfragon.todolist.cli.command.list;

import java.util.List;

import com.todfragon.todolist.cli.command.AbstractCommand;
import com.todfragon.todolist.cli.command.domain.CommandContext;
import com.todfragon.todolist.cli.command.list.domain.ListItemArgs;
import com.todfragon.todolist.domain.Item;
import com.todfragon.todolist.service.TodoListService;

/**
 * 列出所有待办项
 *
 * @author sunjing
 */
public final class ListItemCommand extends AbstractCommand {

    private static final String NAME = "list";

    private final TodoListService todoListService;

    public ListItemCommand(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public void execute(CommandContext commandContext) {
        ListItemArgs listItemArgs = ListItemArgs.create(commandContext.getArgs());
        if (listItemArgs.isListUnDone()) {
            outputUnDone();
            return;
        }

        if (listItemArgs.isListAll()) {
            outputList();
        }
    }

    private void outputUnDone() {
        List<Item> unDoneItems = todoListService.listUnDoneItems();
        unDoneItems.forEach(item -> outputLn(String.format("%s.%s", item.index(), item.name())));
        outputLn(String.format("Total: %d items", unDoneItems.size()));
    }

    private void outputList() {
        List<Item> allItems = todoListService.listAllItems();
        allItems.forEach(item -> {
            String status = item.isDone() ? "Done " : "";
            outputLn(String.format("%s.%s%s", item.index(), status, item.name()));
        });

        Long doneItemsCount = allItems.stream().filter(item -> item.isDone()).count();
        outputLn(String.format("Total: %d items, %d item done", allItems.size(), doneItemsCount));
    }
}
