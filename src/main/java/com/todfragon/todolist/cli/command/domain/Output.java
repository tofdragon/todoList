package com.todfragon.todolist.cli.command.domain;

/**
 * 输出
 *
 * @author sunjing
 */
public interface Output {

    /**
     * 换行输出error
     *
     * @param error 错误信息
     */
    void errorLn(String error);

    /**
     * 输出error
     *
     * @param error 错误信息
     */
    void error(String error);

    /**
     * 换行输出info
     *
     * @param info info信息
     */
    void infoLn(String info);

    /**
     * 输出info
     *
     * @param info info信息
     */
    void info(String info);
}
