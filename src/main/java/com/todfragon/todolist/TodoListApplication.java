package com.todfragon.todolist;

import com.todfragon.todolist.cli.TodoListCli;

/**
 * 启动入口
 *
 * @author sunjing
 * @since 1.0.0
 */
public class TodoListApplication {

    public static void main(String[] args) {
        new TodoListCli().run();
    }
}
