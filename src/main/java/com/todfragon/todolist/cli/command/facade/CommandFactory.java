package com.todfragon.todolist.cli.command.facade;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.todfragon.todolist.cli.Session;
import com.todfragon.todolist.cli.command.Command;
import com.todfragon.todolist.cli.command.todo.add.AddItemCommand;
import com.todfragon.todolist.cli.command.todo.done.DoneItemCommand;
import com.todfragon.todolist.cli.command.todo.list.ListItemCommand;
import com.todfragon.todolist.cli.command.user.login.LoginCommand;
import com.todfragon.todolist.cli.command.user.logout.LogoutCommand;
import com.todfragon.todolist.repository.local.TodoListFileRepository;
import com.todfragon.todolist.service.TodoListService;
import com.todfragon.todolist.user.repository.local.UserFileRepository;
import com.todfragon.todolist.user.service.UserService;

/**
 * 命令工厂
 *
 * @author sunjing
 */
final class CommandFactory {

    static List<Command> create(Session session) {
        TodoListService todoListService = new TodoListService(new TodoListFileRepository());
        UserService userService = new UserService(new UserFileRepository());

        return ImmutableList.of(new AddItemCommand(todoListService),
                new DoneItemCommand(todoListService), new ListItemCommand(todoListService),
                new LoginCommand(userService), new LogoutCommand());
    }
}
