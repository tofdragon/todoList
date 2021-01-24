package com.todfragon.todolist.file;

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

/**
 * 文件存储
 *
 * @author sunjing
 */
public final class FileStorage<T> {

    private final ObjectMapper objectMapper;

    private final String fileName;

    public FileStorage(String fileName) {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        this.fileName = fileName;
    }

    public List<T> read(Class clazz) {
        Path path = fileDbPath();
        if (Files.notExists(path)) {
            initFileDb(path);
        }

        try {
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, clazz);
            return objectMapper.readValue(path.toFile(), javaType);
        } catch (IOException e) {
            throw new RuntimeException(String.format("Read %s file database error", fileName), e);
        }
    }

    public void write(List<T> data) {
        try {
            objectMapper.writeValue(fileDbPath().toFile(), data);
        } catch (IOException e) {
            throw new RuntimeException(String.format("Write file %s database error", fileName), e);
        }
    }

    public void deleteAll() {
        write(Collections.EMPTY_LIST);
    }

    private Path fileDbPath() {
        return Paths.get(System.getProperty("user.dir") + File.separator + fileName);
    }

    private void initFileDb(Path path) {
        try {
            Files.createFile(path);
            objectMapper.writeValue(path.toFile(), Collections.EMPTY_LIST);
        } catch (IOException e) {
            throw new RuntimeException(String.format("Init file %s database error", fileName), e);
        }
    }
}
