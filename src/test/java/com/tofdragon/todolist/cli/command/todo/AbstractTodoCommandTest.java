package com.tofdragon.todolist.cli.command.todo;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import com.todfragon.todolist.cli.command.domain.CommandContext;
import com.todfragon.todolist.cli.command.domain.args.Args;
import com.todfragon.todolist.cli.command.facade.ConsoleInput;
import com.todfragon.todolist.cli.command.facade.ConsoleOutput;
import com.todfragon.todolist.security.Session;
import com.todfragon.todolist.todo.repository.file.TodoListFileRepository;
import com.todfragon.todolist.todo.service.TodoListService;

/**
 * 抽象的命令测试
 *
 * @author sunjing
 */
public abstract class AbstractTodoCommandTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    private TodoListService todoListService;

    private TodoListFileRepository todoListFileRepository;

    private Session session;

    @Before
    public void before() {
        todoListFileRepository = new TodoListFileRepository();
        todoListService = new TodoListService(todoListFileRepository);
        session = new Session();

        session.loginIn("user1");
        todoListFileRepository.deleteAll();
    }

    @After
    public void after() {
        systemOutRule.clearLog();
        todoListFileRepository.deleteAll();
    }

    protected final TodoListService getTodoListService() {
        return todoListService;
    }

    protected final CommandContext createCommandContextWithSession(Args args) {
        return CommandContext.builder().args(args)
                .input(new ConsoleInput()).output(new ConsoleOutput()).session(session).build();
    }
}
