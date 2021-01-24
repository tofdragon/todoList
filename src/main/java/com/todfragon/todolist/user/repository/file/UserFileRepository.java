package com.todfragon.todolist.user.repository.file;


import java.util.Optional;

import com.todfragon.todolist.user.domain.User;
import com.todfragon.todolist.user.repository.UserRepository;

/**
 * 文件存储
 *
 * @author sunjing
 */
public class UserFileRepository implements UserRepository {

    private final UserFileStorage userFileStorage;

    public UserFileRepository() {
        this.userFileStorage = new UserFileStorage();
    }

    @Override
    public Optional<User> findByName(String name) {
        return this.userFileStorage.read().stream().filter(user -> user.isEqualToName(name)).findAny();
    }
}
