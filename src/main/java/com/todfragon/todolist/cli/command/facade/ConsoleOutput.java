package com.todfragon.todolist.cli.command.facade;

import com.todfragon.todolist.cli.command.domain.Output;

/**
 * 控制台输出
 *
 * @author sunjing
 */
public final class ConsoleOutput implements Output {

    @Override
    public void errorLn(String error) {
        System.err.println(error);
    }

    @Override
    public void error(String error) {
        System.err.print(error);
    }

    @Override
    public void infoLn(String info) {
        System.out.println(info);
    }

    @Override
    public void info(String info) {
        System.out.print(info);
    }
}
