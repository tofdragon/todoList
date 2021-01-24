package com.todfragon.todolist.user.service;

import java.util.Optional;

import com.todfragon.todolist.user.domain.User;
import com.todfragon.todolist.user.repository.UserRepository;

/**
 * 用户服务
 *
 * @author sunjing
 */
public final class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Boolean isLoginSuccess(final String name, final String password) {
        Optional<User> user = userRepository.findByName(name);
        return user.map(value -> value.isEqualToNameAndPassword(name, password)).orElse(false);
    }

}
