package com.todfragon.todolist.user.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sunjing
 */
@Getter
@Setter
public final class User {

    private String name;

    private String password;

    public static User create(String name, String password) {
        User user = new User();
        user.name = name;
        user.password = password;
        return user;
    }

    public Boolean isMatchUserNameAndPassword(String name, String password) {
        return this.name.equals(name) && this.password.equals(password);
    }

    public Boolean isEqualsName(String name) {
        return this.name.equals(name);
    }
}
