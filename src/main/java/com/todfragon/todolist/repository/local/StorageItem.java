package com.todfragon.todolist.repository.local;

import com.todfragon.todolist.domain.Item;
import com.todfragon.todolist.domain.ItemStatus;

import lombok.Getter;
import lombok.Setter;

/**
 * 存储的Item
 *
 * @author sunjing
 */
@Getter
@Setter
class StorageItem {

    private Integer index;

    private String name;

    private ItemStatus status;

    public static StorageItem from(Item item) {
        StorageItem storageItem = new StorageItem();
        storageItem.index = item.index();
        storageItem.name = item.name();
        storageItem.status = item.status();
        return storageItem;
    }

    public Item toItem() {
        return Item.create(this.getIndex(), this.getName(), this.getStatus());
    }
}
