package com.tofdragon.todolist.cli.command;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import com.todfragon.todolist.repository.MemoryTodoRepository;
import com.todfragon.todolist.service.TodoListService;

/**
 * 抽象的命令测试
 *
 * @author sunjing
 */
public abstract class AbstractCommandTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    private TodoListService todoListService;

    @Before
    public void before() {
        todoListService = new TodoListService(new MemoryTodoRepository());
    }

    @After
    public void after() {
        systemOutRule.clearLog();
    }

    protected final TodoListService getTodoListService() {
        return todoListService;
    }
}
