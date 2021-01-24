package com.todfragon.todolist.cli;

/**
 * session会话
 *
 * @author sunjing
 */
public final class Session {

    private String userName;

    public void loginIn(String userName) {
        this.userName = userName;
    }

    public void logout() {
        this.userName = null;
    }

    public Boolean isLoginIn() {
        return this.userName != null;
    }

    public String currentUserName() {
        return this.userName;
    }
}
