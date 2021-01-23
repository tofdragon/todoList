package com.todfragon.todolist.cli.command;

/**
 * @author sunjing
 */
public abstract class AbstractCommand implements Command {

    protected final void outputLn(String str) {
        System.out.println(str);
    }

    protected final void output(String str) {
        System.out.print(str);
    }
}
