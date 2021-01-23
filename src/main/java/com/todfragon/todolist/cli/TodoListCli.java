package com.todfragon.todolist.cli;

import java.util.Scanner;

import com.todfragon.todolist.cli.command.facade.CommandFacade;

/**
 * 待办Cli
 *
 * @author sunjing
 */
public final class TodoListCli {

    private final CommandFacade commandFacade = new CommandFacade();

    /**
     * 运行
     */
    public void run() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String input = in.nextLine();
            handleCommand(input);
        }
    }

    private void handleCommand(String input) {
        try {
            commandFacade.handle(input);
        } catch (Exception e) {
            formatErrorOutput(e);
        }
    }

    private void formatErrorOutput(Exception e) {
        System.err.println("The input command is incorrect, please re-enter");
        System.err.println(e.toString());
        System.err.println();
    }
}
