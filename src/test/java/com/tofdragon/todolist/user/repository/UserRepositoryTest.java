package com.tofdragon.todolist.user.repository;

import org.hamcrest.core.Is;
import org.junit.Test;
import com.todfragon.todolist.user.domain.User;
import com.todfragon.todolist.user.repository.UserRepository;
import com.todfragon.todolist.user.repository.file.UserFileRepository;

import static org.junit.Assert.assertThat;

/**
 * 用户资源库加载
 *
 * @author sunjing
 */
public class UserRepositoryTest {

    @Test
    public void should_find_by_name() {
        UserRepository userRepository = new UserFileRepository();
        User user = userRepository.findByName("user1").get();

        assertThat(user.isEqualToNameAndPassword("user1", "123456"), Is.is(true));
    }
}
