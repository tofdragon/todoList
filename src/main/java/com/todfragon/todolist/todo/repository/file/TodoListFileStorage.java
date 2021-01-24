package com.todfragon.todolist.todo.repository.file;

import java.util.List;
import java.util.stream.Collectors;

import com.todfragon.todolist.file.FileStorage;

/**
 * 文件存储
 *
 * @author sunjing
 */
final class TodoListFileStorage {

    private final FileStorage<StorageItem> fileStorage;

    TodoListFileStorage() {
        final String fileName = "todo-list-db.txt";
        fileStorage = new FileStorage<>(fileName);
    }

    void add(StorageItem storageItem) {
        List<StorageItem> storageItems = read();
        storageItems.add(storageItem);
        write(storageItems);
    }

    void updateStatus(StorageItem updatedStorageItem) {
        List<StorageItem> storageItems = read().stream().filter(storageItem -> {
            if (storageItem.isEqualToIndexFrom(updatedStorageItem)) {
                storageItem.setStatusFrom(updatedStorageItem);
            }
            return true;
        }).collect(Collectors.toList());
        write(storageItems);
    }

    List<StorageItem> read() {
        return fileStorage.read(StorageItem.class);
    }

    void deleteAll() {
        fileStorage.deleteAll();
    }

    private void write(List<StorageItem> storageItems) {
        fileStorage.write(storageItems);
    }
}
