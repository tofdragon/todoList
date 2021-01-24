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

    public Item addItem(String name) {
        Integer index = ItemIndexFactory.create(todoListRepository.count()).nextIndex();
        Item item = Item.create(index, name);
        todoListRepository.save(item);
        return item;
    }

    public void doneItem(Integer index) {
        Item item = todoListRepository.findItemByIndex(index);
        item.done();
        todoListRepository.updateItemToDone(item);
    }

    public Item queryItemByIndex(Integer index) {
        return todoListRepository.findItemByIndex(index);
    }

    public List<Item> listUnDoneItems() {
        return Collections.unmodifiableList(todoListRepository.findUnDoneItems());
    }

    public List<Item> listAllItems() {
        return Collections.unmodifiableList(todoListRepository.findAllItems());
    }
}
