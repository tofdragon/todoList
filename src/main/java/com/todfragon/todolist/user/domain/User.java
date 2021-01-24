package com.todfragon.todolist.user.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author sunjing
 */
public final class User {

    @JsonProperty
    private String name;

    @JsonProperty
    private String password;

    public static User create(String name, String password) {
        User user = new User();
        user.name = name;
        user.password = password;
        return user;
    }

    public Boolean isEqualToNameAndPassword(String name, String password) {
        return this.name.equals(name) && this.password.equals(password);
    }

    public Boolean isEqualToName(String name) {
        return this.name.equals(name);
    }
}
