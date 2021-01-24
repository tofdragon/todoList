package com.todfragon.todolist.cli.command;

import com.todfragon.todolist.cli.command.facade.Output;

/**
 * @author sunjing
 */
public abstract class AbstractCommand implements Command {

    protected final void outputLn(String str) {
        new Output().infoLn(str);
    }
}
