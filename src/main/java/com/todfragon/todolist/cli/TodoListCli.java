package com.todfragon.todolist.cli;

import com.todfragon.todolist.cli.command.domain.Input;
import com.todfragon.todolist.cli.command.domain.Output;
import com.todfragon.todolist.cli.command.facade.CommandFacade;
import com.todfragon.todolist.cli.command.facade.ConsoleInput;
import com.todfragon.todolist.cli.command.facade.ConsoleOutput;

/**
 * 待办Cli
 *
 * @author sunjing
 */
public final class TodoListCli {

    private final CommandFacade commandFacade;

    private final Input input;

    private final Output output;

    public TodoListCli() {
        this.input = new ConsoleInput();
        this.output = new ConsoleOutput();
        this.commandFacade = new CommandFacade();
    }

    /**
     * 运行
     */
    public void run() {
        outputTip();
        while (input.hasNextLine()) {
            String userInput = input.nextLine();
            handleCommand(userInput);
        }
    }

    private void handleCommand(String userInput) {
        try {
            commandFacade.handle(userInput, input, output);
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
