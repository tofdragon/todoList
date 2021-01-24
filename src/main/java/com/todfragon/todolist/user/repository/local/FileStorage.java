package com.todfragon.todolist.user.repository.local;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.todfragon.todolist.user.domain.User;

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

    List<User> read() {
        Path path = fileDbPath();
        if (Files.notExists(path)) {
            initFileDb(path);
        }

        try {
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, User.class);
            return objectMapper.readValue(path.toFile(), javaType);
        } catch (IOException e) {
            throw new RuntimeException("Read file database error", e);
        }
    }

    private Path fileDbPath() {
        return Paths.get(System.getProperty("user.dir") + File.separator + ".todo-config");
    }

    private void initFileDb(Path path) {
        try {
            Files.createFile(path);
            objectMapper.writeValue(path.toFile(), Collections.EMPTY_LIST);
        } catch (IOException e) {
            throw new RuntimeException("Init file database error", e);
        }
    }
}
