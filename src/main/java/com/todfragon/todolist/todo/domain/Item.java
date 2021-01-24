package com.todfragon.todolist.todo.domain;

/**
 * 待办项
 *
 * @author sunjing
 */
public final class Item {

    private Integer index;

    private String name;

    private ItemStatus status;

    private String userName;

    private Item() {
    }

    public static Item create(Integer index, String itemName, String userName) {
        Item item = new Item();
        item.index = index;
        item.name = itemName;
        item.status = ItemStatus.UN_DONE;
        item.userName = userName;
        return item;
    }

    public static Item create(Integer index, String itemName, ItemStatus itemStatus, String userName) {
        Item item = create(index, itemName, userName);
        item.status = itemStatus;
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
