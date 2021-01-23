package com.todfragon.todolist.cli.command.domain.args;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 参数构建者
 *
 * @author sunjing
 */
final class ArgsBuilder {

    private final String[] inputArgs;

    ArgsBuilder(String input) {
        final String inputSeparator = " ";
        inputArgs = input.split(inputSeparator);
    }

    Args build() {
        Args args = new Args();
        args.fillCommandName(commandName());
        args.fillParameters(parameters());
        return args;
    }

    private List<String> parameters() {
        if (inputArgs.length <= 1) {
            return Collections.EMPTY_LIST;
        }

        final Integer parameterStartIndex = 2;
        String[] parameters = Arrays.copyOfRange(inputArgs, parameterStartIndex, inputArgs.length);
        return parameters.length > 0 ? Arrays.asList(parameters) : Collections.EMPTY_LIST;
    }

    private String commandName() {
        final Integer commandNameIndex = 1;
        return inputArgs[commandNameIndex];
    }
}
