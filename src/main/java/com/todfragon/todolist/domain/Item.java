package com.todfragon.todolist.domain;

/**
 * 待办项
 *
 * @author sunjing
 */
public final class Item {

    private Integer index;

    private String name;

    private ItemStatus status;

    private Item() {
    }

    public static Item create(Integer index, String name) {
        Item item = new Item();
        item.index = index;
        item.name = name;
        item.status = ItemStatus.UN_DONE;
        return item;
    }

    public Integer index() {
        return this.index;
    }

    public String name() {
        return this.name;
    }

    public void done() {
        this.status = ItemStatus.DONE;
    }

    public Boolean indexEqualsOf(Integer index) {
        return this.index().equals(index);
    }

    private ItemStatus status() {
        return this.status;
    }

    public Boolean isUnDone() {
        return this.status == ItemStatus.UN_DONE;
    }

    public Boolean isDone() {
        return this.status == ItemStatus.DONE;
    }
}
