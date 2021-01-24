package com.tofdragon.todolist.cli.command;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import com.todfragon.todolist.repository.local.TodoListFileRepository;
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

    private TodoListFileRepository todoListFileRepository;

    @Before
    public void before() {
        todoListFileRepository = new TodoListFileRepository();
        todoListService = new TodoListService(todoListFileRepository);
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
}
