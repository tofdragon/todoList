package com.todfragon.todolist.cli.command.facade;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.todfragon.todolist.cli.command.Command;
import com.todfragon.todolist.cli.command.add.AddItemCommand;
import com.todfragon.todolist.cli.command.done.DoneItemCommand;
import com.todfragon.todolist.cli.command.list.ListItemCommand;
import com.todfragon.todolist.repository.local.TodoListFileRepository;
import com.todfragon.todolist.service.TodoListService;

/**
 * 命令工厂
 *
 * @author sunjing
 */
final class CommandFactory {

    static List<Command> create() {
        TodoListService todoListService = new TodoListService(new TodoListFileRepository());

        return ImmutableList.of(new AddItemCommand(todoListService),
                new DoneItemCommand(todoListService), new ListItemCommand(todoListService));

    }
}
