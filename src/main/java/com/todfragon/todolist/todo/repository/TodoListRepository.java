package com.todfragon.todolist.todo.repository;

import java.util.List;
import java.util.Optional;

import com.todfragon.todolist.todo.domain.Item;

/**
 * @author sunjing
 */
public interface TodoListRepository {

    /**
     * 保存待办项
     *
     * @param item 待办项
     */
    void save(Item item);

    /**
     * 查询待办项根据用户名和待办index
     *
     * @param userName 用户名
     * @param index    待办index
     * @return 待办项
     */
    Optional<Item> findItemBy(String userName, int index);

    /**
     * 根据用户名查询未完成的待办
     *
     * @param userName 用户名
     * @return 待办项集合
     */
    List<Item> findUnDoneItems(String userName);

    /**
     * 根据用户查询所有的待办
     *
     * @param userName 用户名
     * @return 待办项集合
     */
    List<Item> findAllItems(String userName);

    /**
     * 修改待办项为完成
     *
     * @param item 待办项
     */
    void updateItemToDone(Item item);

    /**
     * 当前用户待办总数
     *
     * @param userName 用户名
     * @return 当前用户待办总数
     */
    Integer count(String userName);

    /**
     * 删除所有
     */
    void deleteAll();
}
