package com.todfragon.todolist.user.repository.file;

import java.util.List;

import com.todfragon.todolist.file.FileStorage;
import com.todfragon.todolist.user.domain.User;

/**
 * 文件存储
 *
 * @author sunjing
 */
final class UserFileStorage {

    private final FileStorage<User> fileStorage;

    UserFileStorage() {
        final String fileName = ".todo-config";
        fileStorage = new FileStorage<>(fileName);
    }

    List<User> read() {
        return fileStorage.read(User.class);
    }
}
