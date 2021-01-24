package com.todfragon.todolist.todo.repository.file;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.todfragon.todolist.todo.domain.Item;
import com.todfragon.todolist.todo.domain.ItemStatus;

import lombok.AccessLevel;
import lombok.Getter;

/**
 * 存储的Item
 *
 * @author sunjing
 */
@Getter(value = AccessLevel.PRIVATE)
final class StorageItem {

    @JsonProperty
    private Integer index;

    @JsonProperty
    private String name;

    @JsonProperty
    private ItemStatus status;

    @JsonProperty
    private String userName;

    static StorageItem from(Item item) {
        StorageItem storageItem = new StorageItem();
        storageItem.index = item.index();
        storageItem.name = item.name();
        storageItem.status = item.status();
        storageItem.userName = item.userName();
        return storageItem;
    }

    Item toItem() {
        return Item.builder().index(getIndex()).name(getName()).status(getStatus()).userName(getUserName()).build();
    }

    Boolean isEqualToIndexFrom(StorageItem storageItem) {
        return getIndex().equals(storageItem.index);
    }

    void setStatusFrom(StorageItem storageItem) {
        this.status = storageItem.status;
    }
}
