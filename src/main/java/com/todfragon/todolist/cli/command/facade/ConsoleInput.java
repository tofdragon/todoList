package com.todfragon.todolist.cli.command.facade;

import java.util.Scanner;

import com.todfragon.todolist.cli.command.domain.Input;

/**
 * 控制台输入
 *
 * @author sunjing
 */
public final class ConsoleInput implements Input {

    private final Scanner scanner;

    public ConsoleInput() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }

    @Override
    public Boolean hasNextLine() {
        return scanner.hasNextLine();
    }
}
