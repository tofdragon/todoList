package com.todfragon.todolist.service.domain;

import lombok.Getter;

/**
 * 增加待办项请求
 *
 * @author sunjing
 */
@Getter
public final class AddItemRequest {

    private String userName;

    private String itemName;

    private AddItemRequest() {
    }

    public static AddItemRequest create(String userName, String itemName) {
        AddItemRequest addItemRequest = new AddItemRequest();
        addItemRequest.userName = userName;
        addItemRequest.itemName = itemName;
        return addItemRequest;
    }
}
