package com.tofdragon.todolist.cli.command.args;

import org.junit.Test;
import com.todfragon.todolist.cli.command.add.domain.AddItemArgs;
import com.todfragon.todolist.cli.command.domain.args.Args;
import com.todfragon.todolist.cli.command.done.domain.DoneItemArgs;
import com.todfragon.todolist.cli.command.list.domain.ListItemArgs;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * 命令行参数
 *
 * @author sunjing
 */
public class ArgsTest {

    @Test
    public void should_add_item_command() {
        Args args = Args.create("todo add item1");
        AddItemArgs addItemArgs = AddItemArgs.create(args);

        assertThat(args.commandName(), is("add"));
        assertThat(addItemArgs.getItemName(), is("item1"));
    }

    @Test
    public void should_done_item_command() {
        Args args = Args.create("todo done 1");
        DoneItemArgs doneItemArgs = DoneItemArgs.create(args);

        assertThat(args.commandName(), is("done"));
        assertThat(doneItemArgs.getItemIndex(), is(1));
    }

    @Test
    public void should_list_item_command() {
        Args list = Args.create("todo list");
        Args listAll = Args.create("todo list --all");

        ListItemArgs listItemArgs = ListItemArgs.create(list);
        ListItemArgs listAllItemRequest = ListItemArgs.create(listAll);

        assertThat(list.commandName(), is("list"));
        assertThat(listItemArgs.isListUnDone(), is(true));

        assertThat(listAll.commandName(), is("list"));
        assertThat(listAllItemRequest.isListAll(), is(true));
    }

}
