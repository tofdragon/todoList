package com.tofdragon.todolist.service;

import java.util.List;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import com.todfragon.todolist.domain.Item;
import com.todfragon.todolist.repository.MemoryTodoRepository;
import com.todfragon.todolist.service.TodoListService;

import static org.junit.Assert.assertThat;

/**
 * 待办服务
 *
 * @author sunjing
 */
public class TodoListServiceTest {

    private TodoListService todoListService;

    @Before
    public void before() {
        todoListService = new TodoListService(new MemoryTodoRepository());
    }

    @Test
    public void should_right_add_item() {
        Item itemCreated1 = todoListService.addItem("item1");

        Item itemCreated2 = todoListService.addItem("item2");

        assertThat(itemCreated1.index(), Is.is(1));
        assertThat(itemCreated1.name(), Is.is("item1"));

        assertThat(itemCreated2.index(), Is.is(2));
        assertThat(itemCreated2.name(), Is.is("item2"));
    }

    @Test
    public void should_item_status_is_done() {
        Item itemCreated = todoListService.addItem("item1");

        assertThat(itemCreated.index(), Is.is(1));
        assertThat(itemCreated.isUnDone(), Is.is(true));

        todoListService.doneItem(1);
        assertThat(itemCreated.isDone(), Is.is(true));
    }

    @Test
    public void should_list_undone_items() {
        Item itemCreated1 = todoListService.addItem("item1");
        todoListService.addItem("item2");
        todoListService.addItem("item3");

        todoListService.doneItem(itemCreated1.index());

        List<Item> unDoneItems = todoListService.listUnDoneItems();

        assertThat(unDoneItems.size(), Is.is(2));
        assertThat(unDoneItems.get(0).index(), Is.is(2));
    }

    @Test
    public void should_list_all_items() {
        Item itemCreated1 = todoListService.addItem("item1");
        todoListService.addItem("item2");
        todoListService.addItem("item3");

        todoListService.doneItem(itemCreated1.index());

        List<Item> allItems = todoListService.listAllItems();

        assertThat(allItems.size(), Is.is(3));
        assertThat(allItems.get(0).index(), Is.is(1));
        assertThat(allItems.get(0).isDone(), Is.is(true));

        assertThat(allItems.get(1).index(), Is.is(2));
        assertThat(allItems.get(1).isUnDone(), Is.is(true));
    }
}
