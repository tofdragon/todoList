package com.todfragon.todolist.cli.command.facade.exception;

/**
 * @author sunjing
 */
public final class NotFoundCommandException extends RuntimeException {

    public NotFoundCommandException(String commandName) {
        super(String.format("Command %s does not exist", commandName));
    }
}
