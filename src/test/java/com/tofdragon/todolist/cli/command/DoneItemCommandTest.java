package com.tofdragon.todolist.cli.command;

import org.hamcrest.core.Is;
import org.junit.Test;
import com.todfragon.todolist.cli.command.domain.CommandContext;
import com.todfragon.todolist.cli.command.domain.args.Args;
import com.todfragon.todolist.cli.command.done.DoneItemCommand;

import static org.junit.Assert.assertThat;

/**
 * 完成待办
 *
 * @author sunjing
 */
public class DoneItemCommandTest extends AbstractCommandTest {

    @Test
    public void should_show_done_item() {
        DoneItemCommand doneItemCommand = new DoneItemCommand(getTodoListService());

        getTodoListService().addItem("item1");
        doneItemCommand.execute(CommandContext.create(Args.create("todo done 1")));
        assertThat(systemOutRule.getLogWithNormalizedLineSeparator(), Is.is("Item 1 done\n"));
    }
}
