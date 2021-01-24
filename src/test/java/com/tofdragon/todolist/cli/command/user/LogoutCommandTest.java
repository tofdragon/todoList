package com.tofdragon.todolist.cli.command.user;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import com.todfragon.todolist.cli.command.domain.CommandContext;
import com.todfragon.todolist.cli.command.domain.args.Args;
import com.todfragon.todolist.cli.command.facade.ConsoleInput;
import com.todfragon.todolist.cli.command.facade.ConsoleOutput;
import com.todfragon.todolist.cli.command.user.logout.LogoutCommand;
import com.todfragon.todolist.security.Session;

import static org.junit.Assert.assertThat;

/**
 * 退出测试
 *
 * @author sunjing
 */
public class LogoutCommandTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @After
    public void after() {
        systemOutRule.clearLog();
    }

    @Test
    public void should_show_logout_success() {
        LogoutCommand loginCommand = new LogoutCommand();
        loginCommand.execute(CommandContext.builder().args(Args.create("todo logout")).input(new ConsoleInput()).output(
                new ConsoleOutput()).session(new Session()).build());

        assertThat(systemOutRule.getLogWithNormalizedLineSeparator(), Is.is("Logout success!\n"));
    }
}
