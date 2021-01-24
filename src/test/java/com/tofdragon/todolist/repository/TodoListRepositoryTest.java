package com.tofdragon.todolist.repository;

import java.util.List;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.todfragon.todolist.domain.Item;
import com.todfragon.todolist.repository.TodoListRepository;
import com.todfragon.todolist.repository.local.TodoListFileRepository;

import static org.junit.Assert.assertThat;

/**
 * 待办资源库
 *
 * @author sunjing
 */
public class TodoListRepositoryTest {

    private TodoListRepository todoListRepository;

    @Before
    public void before() {
        todoListRepository = new TodoListFileRepository();
        todoListRepository.deleteAll();
    }

    @After
    public void after() {
        todoListRepository.deleteAll();
    }

    @Test
    public void should_save_item() {
        todoListRepository.save(Item.create(1, "item1"));
        todoListRepository.save(Item.create(2, "item2"));

        Item item = todoListRepository.findItemByIndex(1);

        assertThat(item.index(), Is.is(1));
        assertThat(item.name(), Is.is("item1"));
    }

    @Test
    public void should_update_item_status_to_done() {
        todoListRepository.save(Item.create(1, "item1"));
        todoListRepository.save(Item.create(2, "item2"));

        Item unDoneItem = todoListRepository.findItemByIndex(1);
        assertThat(unDoneItem.index(), Is.is(1));
        assertThat(unDoneItem.isUnDone(), Is.is(true));

        unDoneItem.done();
        todoListRepository.updateItemToDone(unDoneItem);

        Item doneItem = todoListRepository.findItemByIndex(1);
        assertThat(doneItem.index(), Is.is(1));
        assertThat(doneItem.isDone(), Is.is(true));
    }

    @Test
    public void should_query_undone_items() {
        todoListRepository.save(Item.create(1, "item1"));
        todoListRepository.save(Item.create(2, "item2"));
        todoListRepository.save(Item.create(3, "item2"));

        List<Item> unDoneItems = todoListRepository.findUnDoneItems();

        assertThat(unDoneItems.size(), Is.is(3));
        assertThat(unDoneItems.get(0).index(), Is.is(1));
        assertThat(unDoneItems.get(0).isUnDone(), Is.is(true));
    }

    @Test
    public void should_query_all_items() {
        todoListRepository.save(Item.create(1, "item1"));
        todoListRepository.save(Item.create(2, "item2"));
        todoListRepository.save(Item.create(3, "item2"));

        List<Item> allItems = todoListRepository.findAllItems();

        assertThat(allItems.size(), Is.is(3));
        assertThat(allItems.get(0).index(), Is.is(1));
        assertThat(allItems.get(0).isUnDone(), Is.is(true));

        assertThat(allItems.get(1).index(), Is.is(2));
        assertThat(allItems.get(1).isUnDone(), Is.is(true));
    }

    @Test
    public void should_right_count() {
        todoListRepository.save(Item.create(1, "item1"));
        todoListRepository.save(Item.create(2, "item2"));
        todoListRepository.save(Item.create(3, "item2"));
        todoListRepository.save(Item.create(4, "item2"));

        assertThat(todoListRepository.count(), Is.is(4));
    }
}
