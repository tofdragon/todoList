package com.todfragon.todolist.repository.local;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.todfragon.todolist.domain.Item;
import com.todfragon.todolist.repository.TodoListRepository;

/**
 * 文件
 *
 * @author sunjing
 */
public final class TodoListFileRepository implements TodoListRepository {

    private final FileStorage fileStorage;

    public TodoListFileRepository() {
        this.fileStorage = new FileStorage();
    }

    @Override
    public void save(Item item) {
        fileStorage.add(StorageItem.from(item));
    }

    @Override
    public Item findItemByIndex(int index) {
        return allItems().filter(item -> item.indexEqualsOf(index)).findAny().orElse(null);
    }

    private Stream<Item> allItems() {
        return fileStorage.read().stream().map(StorageItem::toItem);
    }

    @Override
    public List<Item> findUnDoneItems() {
        return allItems().filter(Item::isUnDone).collect(Collectors.toList());
    }

    @Override
    public List<Item> findAllItems() {
        return allItems().collect(Collectors.toList());
    }

    @Override
    public void updateItemToDone(Item doneItem) {
        fileStorage.updateStatus(StorageItem.from(doneItem));
    }

    @Override
    public Integer count() {
        return (int) allItems().count();
    }

    @Override
    public void deleteAll() {
        fileStorage.deleteAll();
    }
}
