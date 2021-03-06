package com.tofdragon.todolist.cli.command.todo;

import org.hamcrest.core.Is;
import org.junit.Test;
import com.todfragon.todolist.cli.command.domain.args.Args;
import com.todfragon.todolist.cli.command.todo.list.ListItemCommand;
import com.todfragon.todolist.cli.command.todo.list.domain.ListItemArgs;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * 查询待办项
 *
 * @author sunjing
 */
public class ListItemTestTodo extends AbstractTodoCommandTest {

    @Test
    public void should_list_args() {
        Args list = Args.create("todo list");
        Args listAll = Args.create("todo list --all");

        ListItemArgs listItemArgs = ListItemArgs.create(list);
        ListItemArgs listAllItemRequest = ListItemArgs.create(listAll);

        assertThat(list.commandName(), is("list"));
        assertThat(listItemArgs.isListUnDone(), is(true));

        assertThat(listAll.commandName(), is("list"));
        assertThat(listAllItemRequest.isListAll(), is(true));
    }

    @Test
    public void should_show_unDone_item() {
        final String userName = "user1";

        getTodoListService().addItem(userName, "item1");
        getTodoListService().addItem(userName, "item2");
        getTodoListService().addItem(userName, "item3");

        getTodoListService().doneItem(userName, 3);

        ListItemCommand listItemCommand = new ListItemCommand(getTodoListService());
        listItemCommand.execute(createCommandContextWithSession(Args.create("todo list")));
        assertThat(systemOutRule.getLogWithNormalizedLineSeparator(),
                Is.is("1.item1\n2.item2\nTotal: 2 items\n"));
    }

    @Test
    public void should_show_all_item() {
        final String userName = "user1";
        getTodoListService().addItem(userName, "item1");
        getTodoListService().addItem(userName, "item2");
        getTodoListService().addItem(userName, "item3");

        getTodoListService().doneItem(userName, 3);

        ListItemCommand listItemCommand = new ListItemCommand(getTodoListService());
        listItemCommand.execute(createCommandContextWithSession(Args.create("todo list --all")));
        assertThat(systemOutRule.getLogWithNormalizedLineSeparator(),
                Is.is("1.item1\n2.item2\n3.Done item3\nTotal: 3 items, 1 item done\n"));
    }
}
