package com.todfragon.todolist.cli;

import java.util.Scanner;

import com.todfragon.todolist.cli.command.facade.CommandFacade;
import com.todfragon.todolist.cli.command.facade.Output;

/**
 * 待办Cli
 *
 * @author sunjing
 */
public final class TodoListCli {

    private final CommandFacade commandFacade = new CommandFacade();

    private final Output output = new Output();

    /**
     * 运行
     */
    public void run() {
        outputTip();
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
        } finally {
            beautifyOutput();
        }
    }

    private void outputTip() {
        output.infoLn("please input your command");
    }

    private void formatErrorOutput(Exception e) {
        output.errorLn("The input command is incorrect, please re-enter");
        output.errorLn(e.toString());
    }

    private void beautifyOutput() {
        output.errorLn("");
    }
}
