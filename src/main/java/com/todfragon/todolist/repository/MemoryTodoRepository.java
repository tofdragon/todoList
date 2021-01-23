package com.todfragon.todolist.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.todfragon.todolist.domain.Item;

/**
 * 内存
 *
 * @author sunjing
 */
public final class MemoryTodoRepository implements TodoListRepository {

    private final List<Item> items = new ArrayList();

    @Override
    public void saveItem(Item item) {
        items.add(item);
    }

    @Override
    public Item findItemByIndex(int index) {
        return items.stream().filter(item -> item.indexEqualsOf(index)).findAny().orElse(null);
    }

    @Override
    public List<Item> findUnDoneItems() {
        return items.stream().filter(item -> item.isUnDone()).collect(Collectors.toList());
    }

    @Override
    public List<Item> findAllItems() {
        return items.stream().collect(Collectors.toList());
    }

    @Override
    public void updateItemToDone(int index) {
        Optional<Item> foundItem = items.stream().filter(item -> item.indexEqualsOf(index)).findAny();
        if (foundItem.isPresent()) {
            foundItem.get().done();
        }
    }

    @Override
    public Integer count() {
        return items.size();
    }
}
