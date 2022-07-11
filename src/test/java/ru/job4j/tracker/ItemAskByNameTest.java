package ru.job4j.tracker;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ItemAskByNameTest {

    @Test
    public void whenSortAsk() {
        List<Item> items = Arrays.asList(
                new Item("n"),
                new Item("s"),
                new Item("c"),
                new Item("d")

        );

        List<Item> expected = Arrays.asList(
                new Item("c"),
                new Item("d"),
                new Item("n"),
                new Item("s")

        );
        Collections.sort(items, new  ItemAskByName());
        assertThat(expected, is(items));
    }

    @Test
    public void whenSortDeskAsk() {
        List<Item> items = Arrays.asList(
                new Item("a"),
                new Item("c"),
                new Item("b"),
                new Item("d")

        );

        List<Item> expected = Arrays.asList(
                new Item("d"),
                new Item("c"),
                new Item("b"),
                new Item("a")

        );
        Collections.sort(items, new ItemDescByName());
        assertThat(expected, is(items));
    }
}