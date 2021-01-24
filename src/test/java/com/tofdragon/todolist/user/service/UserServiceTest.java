package com.tofdragon.todolist.user.service;

import org.hamcrest.core.Is;
import org.junit.Test;
import com.todfragon.todolist.user.repository.file.UserFileRepository;
import com.todfragon.todolist.user.service.UserService;

import static org.junit.Assert.assertThat;

/**
 * 用户服务测试
 *
 * @author sunjing
 */
public class UserServiceTest {

    @Test
    public void should_is_login_success() {
        UserService userService = new UserService(new UserFileRepository());
        assertThat(userService.isLoginSuccess("user1", "123456"), Is.is(true));
        assertThat(userService.isLoginSuccess("user1", "123457"), Is.is(false));
    }
}
