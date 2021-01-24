package com.tofdragon.todolist.cli.command.todo;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import com.todfragon.todolist.cli.Session;
import com.todfragon.todolist.cli.command.domain.args.Args;
import com.todfragon.todolist.cli.command.todo.done.DoneItemCommand;
import com.todfragon.todolist.cli.command.todo.done.domain.DoneItemArgs;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * 完成待办
 *
 * @author sunjing
 */
public class DoneItemTodoCommandTest extends AbstractTodoCommandTest {

    private final Session session = new Session();

    @Before
    public void before() {
        super.before();
        session.loginIn("user1");
    }


    @Test
    public void should_done_args() {
        Args args = Args.create("todo done 1");
        DoneItemArgs doneItemArgs = DoneItemArgs.create(args);

        assertThat(args.commandName(), is("done"));
        assertThat(doneItemArgs.getItemIndex(), is(1));
    }

    @Test
    public void should_show_done_item() {
        final String userName = "user1";

        DoneItemCommand doneItemCommand = new DoneItemCommand(getTodoListService());

        getTodoListService().addItem(userName, "item1");
        doneItemCommand.execute(createCommandContextWithSession(Args.create("todo done 1")));
        assertThat(systemOutRule.getLogWithNormalizedLineSeparator(), Is.is("Item 1 done\n"));
    }
}
