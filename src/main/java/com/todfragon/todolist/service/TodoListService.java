package com.todfragon.todolist.service;

import java.util.Collections;
import java.util.List;

import com.todfragon.todolist.domain.Item;
import com.todfragon.todolist.domain.ItemIndexFactory;
import com.todfragon.todolist.repository.TodoListRepository;

/**
 * 待办服务
 *
 * @author sunjing
 */
public final class TodoListService {

    private final TodoListRepository todoListRepository;

    public TodoListService(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    public Item addItem(String userName, String itemName) {
        Integer index = ItemIndexFactory.create(todoListRepository.count(userName)).nextIndex();
        Item item = Item.create(index, itemName, userName);
        todoListRepository.save(item);
        return item;
    }

    public void doneItem(String userName, Integer index) {
        Item item = todoListRepository.findItemByIndex(userName, index);
        item.done();
        todoListRepository.updateItemToDone(item);
    }

    public Item queryItemByIndex(String userName, Integer index) {
        return todoListRepository.findItemByIndex(userName, index);
    }

    public List<Item> listUnDoneItems(String userName) {
        return Collections.unmodifiableList(todoListRepository.findUnDoneItems(userName));
    }

    public List<Item> listAllItems(String userName) {
        return Collections.unmodifiableList(todoListRepository.findAllItems(userName));
    }
}
