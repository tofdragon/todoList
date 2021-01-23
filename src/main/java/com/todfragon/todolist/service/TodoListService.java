package com.todfragon.todolist.service;

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

    public Item addItem(String name) {
        Item item = Item.create(ItemIndexFactory.create(todoListRepository.count()).index(), name);
        todoListRepository.saveItem(item);
        return item;
    }

    public void doneItem(Integer index) {
        todoListRepository.updateItemToDone(index);
    }

    public List<Item> listUnDoneItems() {
        return todoListRepository.findUnDoneItems();
    }

    public List<Item> listAllItems() {
        return todoListRepository.findAllItems();
    }
}
