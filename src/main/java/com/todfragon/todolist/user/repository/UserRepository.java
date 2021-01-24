package com.todfragon.todolist.user.repository;

import java.util.Optional;

import com.todfragon.todolist.user.domain.User;

/**
 * 用户资源库
 *
 * @author sunjing
 */
public interface UserRepository {

    /**
     * 查找用户根据用户名
     *
     * @param name 用户名
     * @return 用户
     */
    Optional<User> findByName(String name);
}
