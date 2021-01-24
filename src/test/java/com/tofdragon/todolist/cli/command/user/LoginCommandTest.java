package com.tofdragon.todolist.cli.command.user;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import com.todfragon.todolist.cli.command.domain.CommandContext;
import com.todfragon.todolist.cli.command.domain.Input;
import com.todfragon.todolist.cli.command.domain.args.Args;
import com.todfragon.todolist.cli.command.facade.ConsoleOutput;
import com.todfragon.todolist.cli.command.user.login.LoginCommand;
import com.todfragon.todolist.cli.command.user.login.domain.LoginArgs;
import com.todfragon.todolist.security.Session;
import com.todfragon.todolist.user.repository.file.UserFileRepository;
import com.todfragon.todolist.user.service.UserService;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * 登录命令测试
 *
 * @author sunjing
 */
public class LoginCommandTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @After
    public void after() {
        systemOutRule.clearLog();
    }

    @Test
    public void should_login_user_args() {
        Args args = Args.create("todo login -u user");
        LoginArgs loginArgs = LoginArgs.create(args);

        assertThat(args.commandName(), is("login"));
        assertThat(loginArgs.userName(), is("user"));
    }

    @Test
    public void should_show_login_success() {
        LoginCommand loginCommand = new LoginCommand(new UserService(new UserFileRepository()));
        loginCommand.execute(CommandContext.builder().args(Args.create("todo login -u user1")).input(new Input() {
            @Override
            public String nextLine() {
                return "123456";
            }

            @Override
            public Boolean hasNextLine() {
                return true;
            }
        }).output(new ConsoleOutput()).session(new Session()).build());

        assertThat(systemOutRule.getLogWithNormalizedLineSeparator(), Is.is("Password:Login success!\n"));
    }

    @Test
    public void should_session_is_login_when_login_success() {
        Session session = new Session();

        LoginCommand loginCommand = new LoginCommand(new UserService(new UserFileRepository()));
        loginCommand.execute(CommandContext.builder().args(Args.create("todo login -u user1")).input(new Input() {
            @Override
            public String nextLine() {
                return "123456";
            }

            @Override
            public Boolean hasNextLine() {
                return true;
            }
        }).output(new ConsoleOutput()).session(session).build());

        assertThat(session.isLoginIn(), Is.is(true));
    }

}
