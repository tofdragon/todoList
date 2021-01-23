package com.tofdragon.todolist.cli.command;

import org.hamcrest.core.Is;
import org.junit.Test;
import com.todfragon.todolist.cli.command.add.AddItemCommand;
import com.todfragon.todolist.cli.command.domain.CommandContext;
import com.todfragon.todolist.cli.command.domain.args.Args;

import static org.junit.Assert.assertThat;

/**
 * 增加待办项
 *
 * @author sunjing
 */
public class AddItemCommandTest extends AbstractCommandTest {

    @Test
    public void should_show_add_item() {
        AddItemCommand addItemCommand = new AddItemCommand(getTodoListService());
        addItemCommand.execute(CommandContext.create(Args.create("todo add item1")));
        assertThat(systemOutRule.getLogWithNormalizedLineSeparator(), Is.is("1.item1\nItem 1 added\n"));
    }

}