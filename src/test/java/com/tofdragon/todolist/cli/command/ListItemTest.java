package com.tofdragon.todolist.cli.command;

import org.hamcrest.core.Is;
import org.junit.Test;
import com.todfragon.todolist.cli.command.domain.CommandContext;
import com.todfragon.todolist.cli.command.domain.args.Args;
import com.todfragon.todolist.cli.command.list.ListItemCommand;

import static org.junit.Assert.assertThat;

/**
 * 查询待办项
 *
 * @author sunjing
 */
public class ListItemTest extends AbstractCommandTest {

    @Test
    public void should_show_unDone_item() {
        getTodoListService().addItem("item1");
        getTodoListService().addItem("item2");
        getTodoListService().addItem("item3");

        getTodoListService().doneItem(3);

        ListItemCommand listItemCommand = new ListItemCommand(getTodoListService());
        listItemCommand.execute(CommandContext.create(Args.create("todo list")));
        assertThat(systemOutRule.getLogWithNormalizedLineSeparator(),
                Is.is("1.item1\n2.item2\nTotal: 2 items\n"));
    }

    @Test
    public void should_show_all_item() {
        getTodoListService().addItem("item1");
        getTodoListService().addItem("item2");
        getTodoListService().addItem("item3");

        getTodoListService().doneItem(3);

        ListItemCommand listItemCommand = new ListItemCommand(getTodoListService());
        listItemCommand.execute(CommandContext.create(Args.create("todo list --all")));
        assertThat(systemOutRule.getLogWithNormalizedLineSeparator(),
                Is.is("1.item1\n2.item2\n3.Done item3\nTotal: 3 items, 1 item done\n"));
    }
}