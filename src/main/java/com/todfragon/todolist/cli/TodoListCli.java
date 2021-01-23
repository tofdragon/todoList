package com.todfragon.todolist.cli;

import java.util.Scanner;

import com.todfragon.todolist.command.facade.CommandFacade;

/**
 * 待办Cli
 *
 * @author sunjing
 */
public final class TodoListCli {

    /**
     * 运行
     */
    public void run() {
        final CommandFacade commandFacade = new CommandFacade();

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String input = in.nextLine();
            commandFacade.handle(input);
        }
    }
}
