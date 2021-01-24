package com.todfragon.todolist.repository.local;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.todfragon.todolist.domain.Item;
import com.todfragon.todolist.repository.TodoListRepository;

/**
 * 内存
 *
 * @author sunjing
 */
public final class TodoListMemoryRepository implements TodoListRepository {

    private final List<StorageItem> items = new ArrayList();

    @Override
    public void save(Item item) {
        items.add(StorageItem.from(item));
    }

    @Override
    public Item findItemByIndex(int index) {
        return items.stream().map(StorageItem::toItem).filter(item -> item.indexEqualsOf(index)).findAny().orElse(null);
    }

    @Override
    public List<Item> findUnDoneItems() {
        return items.stream().map(StorageItem::toItem).filter(item -> item.isUnDone()).collect(Collectors.toList());
    }

    @Override
    public List<Item> findAllItems() {
        return items.stream().map(StorageItem::toItem).collect(Collectors.toList());
    }

    @Override
    public void updateItemToDone(Item doneItem) {
        Optional<StorageItem> foundItem = items.stream().filter(storageItem ->
                storageItem.getIndex().equals(doneItem.index())).findAny();
        if (foundItem.isPresent()) {
            foundItem.get().setStatus(doneItem.status());
        }
    }

    @Override
    public Integer count() {
        return items.size();
    }

    @Override
    public void deleteAll() {
        this.items.clear();
    }
}
