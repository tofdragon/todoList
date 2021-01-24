package com.todfragon.todolist;

import com.todfragon.todolist.cli.TodoListCli;
import com.todfragon.todolist.cli.command.domain.Input;
import com.todfragon.todolist.cli.command.domain.Output;
import com.todfragon.todolist.cli.command.facade.ConsoleInput;
import com.todfragon.todolist.cli.command.facade.ConsoleOutput;
import com.todfragon.todolist.security.Session;

/**
 * 启动入口
 *
 * @author sunjing
 * @since 1.0.0
 */
public class TodoListApplication {

    public static void main(String[] args) {
        Session session = new Session();
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();

        new TodoListCli(session, input, output).run();
    }
}
