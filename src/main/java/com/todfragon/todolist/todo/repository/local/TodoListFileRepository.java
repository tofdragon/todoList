package com.todfragon.todolist.todo.repository.local;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.todfragon.todolist.todo.domain.Item;
import com.todfragon.todolist.todo.repository.TodoListRepository;

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
    public Item findItemByIndex(String userName, int index) {
        return allItems(userName).filter(item -> item.indexEqualsOf(index)).findAny().orElse(null);
    }

    private Stream<Item> allItems(String userName) {
        return fileStorage.read().stream().map(StorageItem::toItem).filter(item -> item.userName().equals(userName));
    }

    @Override
    public List<Item> findUnDoneItems(String userName) {
        return allItems(userName).filter(Item::isUnDone).collect(Collectors.toList());
    }

    @Override
    public List<Item> findAllItems(String userName) {
        return allItems(userName).collect(Collectors.toList());
    }

    @Override
    public void updateItemToDone(Item doneItem) {
        fileStorage.updateStatus(StorageItem.from(doneItem));
    }

    @Override
    public Integer count(String userName) {
        return (int) allItems(userName).count();
    }

    @Override
    public void deleteAll() {
        fileStorage.deleteAll();
    }
}
