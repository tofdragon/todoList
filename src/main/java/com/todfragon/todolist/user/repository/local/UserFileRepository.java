package com.todfragon.todolist.user.repository.local;


import java.util.Optional;

import com.todfragon.todolist.user.domain.User;
import com.todfragon.todolist.user.repository.UserRepository;

/**
 * 文件存储
 *
 * @author sunjing
 */
public class UserFileRepository implements UserRepository {

    private final FileStorage fileStorage;

    public UserFileRepository() {
        this.fileStorage = new FileStorage();
    }

    @Override
    public Optional<User> findByName(String name) {
        return this.fileStorage.read().stream().filter(user -> user.isEqualsName(name)).findAny();
    }
}
