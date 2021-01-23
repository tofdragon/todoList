package com.todfragon.todolist.domain;

/**
 * 待办项索引创建者
 *
 * @author sunjing
 */
public final class ItemIndexFactory {

    private Integer currentIndex;

    private ItemIndexFactory() {
    }

    public static ItemIndexFactory create(Integer currentIndex) {
        ItemIndexFactory itemIndexFactory = new ItemIndexFactory();
        itemIndexFactory.currentIndex = currentIndex;
        return itemIndexFactory;
    }

    public Integer index() {
        return currentIndex + 1;
    }

}
