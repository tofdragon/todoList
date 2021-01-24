package com.tofdragon.todolist.user.service;

import org.hamcrest.core.Is;
import org.junit.Test;
import com.todfragon.todolist.user.repository.local.UserFileRepository;
import com.todfragon.todolist.user.service.UserService;

import static org.junit.Assert.assertThat;

/**
 * 用户服务测试
 *
 * @author sunjing
 */
public class UserServiceTest {

    @Test
    public void should_is_same_user_name_and_password() {
        UserService userService = new UserService(new UserFileRepository());
        assertThat(userService.isMatchUserNameAndPassword("user1", "123456"), Is.is(true));
        assertThat(userService.isMatchUserNameAndPassword("user1", "123457"), Is.is(false));
    }
}
