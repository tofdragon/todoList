package com.todfragon.todolist.todo.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.todfragon.todolist.todo.domain.Item;
import com.todfragon.todolist.todo.domain.ItemIndexFactory;
import com.todfragon.todolist.todo.repository.TodoListRepository;

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
        Item item = Item.builder().index(index).name(itemName).userName(userName).build();
        todoListRepository.save(item);
        return item;
    }

    public void doneItem(String userName, Integer index) {
        Optional<Item> item = todoListRepository.findItemBy(userName, index);
        if (!item.isPresent()) {
            return;
        }
        item.get().done();
        todoListRepository.updateItemToDone(item.get());
    }

    public Optional<Item> queryItemByIndex(String userName, Integer index) {
        return todoListRepository.findItemBy(userName, index);
    }

    public List<Item> listUnDoneItems(String userName) {
        return Collections.unmodifiableList(todoListRepository.findUnDoneItems(userName));
    }

    public List<Item> listAllItems(String userName) {
        return Collections.unmodifiableList(todoListRepository.findAllItems(userName));
    }
}
