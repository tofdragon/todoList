package com.todfragon.todolist.repository;

import java.util.List;

import com.todfragon.todolist.domain.Item;

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
     * 查询待办项根据待办index
     *
     * @param index 待办index
     * @return 查询到的待办项
     */
    Item findItemByIndex(int index);

    /**
     * 查询未完成的待办
     *
     * @return 未完成待办集合
     */
    List<Item> findUnDoneItems();

    /**
     * 查询所有状态的待办
     *
     * @return 所有待办集合
     */
    List<Item> findAllItems();

    /**
     * 修改待办项为完成
     *
     * @param item 待办项
     */
    void updateItemToDone(Item item);

    /**
     * 总数
     *
     * @return 总数
     */
    Integer count();

    /**
     * 删除所有
     */
    void deleteAll();
}
