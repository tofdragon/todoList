package com.todfragon.todolist.todo.domain;

import lombok.Builder;

/**
 * 待办项
 *
 * @author sunjing
 */
@Builder
public final class Item {

    private final Integer index;

    private final String name;

    @Builder.Default
    private ItemStatus status = ItemStatus.UN_DONE;

    private final String userName;

    public Integer index() {
        return this.index;
    }

    public String name() {
        return this.name;
    }

    public void done() {
        this.status = ItemStatus.DONE;
    }

    public Boolean isEqualToIndex(Integer index) {
        return this.index().equals(index);
    }

    public ItemStatus status() {
        return this.status;
    }

    public Boolean isUnDone() {
        return this.status == ItemStatus.UN_DONE;
    }

    public Boolean isDone() {
        return this.status == ItemStatus.DONE;
    }

    public String userName() {
        return this.userName;
    }
}
