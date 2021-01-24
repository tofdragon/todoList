package com.todfragon.todolist.cli.command.domain.args;

import java.util.Collections;
import java.util.List;

/**
 * 命令参数
 *
 * @author sunjing
 * @since 1.0.0
 */
public final class Args {

    /**
     * 命令的名称
     */
    private String commandName;

    /**
     * 命令的选项值
     */
    private List<String> parameters;

    Args() {
    }

    /**
     * 输入
     * <p>
     * 格式: todo 命令 参数值[或空]
     * </p>
     *
     * @param input 输入
     * @return 参数
     */
    public static Args create(String input) {
        return new ArgsBuilder(input).build();
    }

    public String commandName() {
        return commandName;
    }

    public List<String> parameters() {
        return Collections.unmodifiableList(this.parameters);
    }

    public String parameter(Integer index) {
        return parameters().get(index);
    }

    public String firstParameter() {
        return parameters().get(0);
    }

    void fillParameters(List<String> parameters) {
        this.parameters = parameters;
    }

    void fillCommandName(String commandName) {
        this.commandName = commandName;
    }
}