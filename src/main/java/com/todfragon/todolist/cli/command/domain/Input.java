package com.todfragon.todolist.cli.command.domain;

/**
 * 输入
 *
 * @author sunjing
 */
public interface Input {

    /**
     * 下一行输入
     *
     * @return 下一行输入信息
     */
    String nextLine();

    /**
     * 是否有下一行
     *
     * @return true:是 false:否
     */
    Boolean hasNextLine();
}
