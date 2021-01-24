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

    public Boolean isMatchUserNameAndPassword(String name, String password) {
        Optional<User> user = userRepository.findByName(name);
        if (!user.isPresent()) {
            return false;
        }
        return user.get().isMatchUserNameAndPassword(name, password);
    }

}
