package com.todfragon.todolist.cli.command.facade;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.todfragon.todolist.cli.command.Command;
import com.todfragon.todolist.cli.command.security.NeedLoginCommand;
import com.todfragon.todolist.cli.command.todo.add.AddItemCommand;
import com.todfragon.todolist.cli.command.todo.done.DoneItemCommand;
import com.todfragon.todolist.cli.command.todo.list.ListItemCommand;
import com.todfragon.todolist.cli.command.user.login.LoginCommand;
import com.todfragon.todolist.cli.command.user.logout.LogoutCommand;
import com.todfragon.todolist.todo.repository.file.TodoListFileRepository;
import com.todfragon.todolist.todo.service.TodoListService;
import com.todfragon.todolist.user.repository.file.UserFileRepository;
import com.todfragon.todolist.user.service.UserService;

/**
 * 命令工厂
 *
 * @author sunjing
 */
final class CommandFactory {

    static List<Command> create() {
        TodoListService todoListService = new TodoListService(new TodoListFileRepository());
        UserService userService = new UserService(new UserFileRepository());

        return ImmutableList.of(needLogin(new AddItemCommand(todoListService)),
                needLogin(new DoneItemCommand(todoListService)),
                needLogin(new ListItemCommand(todoListService)),
                new LoginCommand(userService), new LogoutCommand());
    }

    private static Command needLogin(Command command) {
        return new NeedLoginCommand(command);
    }
}
