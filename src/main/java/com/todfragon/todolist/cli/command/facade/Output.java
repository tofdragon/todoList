package com.todfragon.todolist.cli.command.facade;

/**
 * @author sunjing
 */
public final class Output {

    public void errorLn(String error) {
        System.err.println(error);
    }

    public void infoLn(String error) {
        System.out.println(error);
    }
}
