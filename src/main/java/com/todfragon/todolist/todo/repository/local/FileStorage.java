package com.todfragon.todolist.todo.repository.local;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 文件存储
 *
 * @author sunjing
 */
final class FileStorage {

    private final ObjectMapper objectMapper;

    public FileStorage() {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    void add(StorageItem storageItem) {
        List<StorageItem> storageItems = read();
        storageItems.add(storageItem);
        write(storageItems);
    }

    void updateStatus(StorageItem updatedStorageItem) {
        List<StorageItem> storageItems = read().stream().filter(storageItem -> {
            if (storageItem.getIndex().equals(updatedStorageItem.getIndex())) {
                storageItem.setStatus(updatedStorageItem.getStatus());
            }
            return true;
        }).collect(Collectors.toList());
        write(storageItems);
    }

    List<StorageItem> read() {
        Path path = fileDbPath();
        if (Files.notExists(path)) {
            initFileDb(path);
        }

        try {
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, StorageItem.class);
            return objectMapper.readValue(path.toFile(), javaType);
        } catch (IOException e) {
            throw new RuntimeException("Read file database error", e);
        }
    }

    void deleteAll() {
        write(Collections.EMPTY_LIST);
    }

    private Path fileDbPath() {
        return Paths.get(System.getProperty("user.dir") + File.separator + "todo-list-db.txt");
    }

    private void initFileDb(Path path) {
        try {
            Files.createFile(path);
            objectMapper.writeValue(path.toFile(), Collections.EMPTY_LIST);
        } catch (IOException e) {
            throw new RuntimeException("Init file database error", e);
        }
    }

    private void write(List<StorageItem> storageItems) {
        try {
            objectMapper.writeValue(fileDbPath().toFile(), storageItems);
        } catch (IOException e) {
            throw new RuntimeException("Write file database error", e);
        }
    }
}
