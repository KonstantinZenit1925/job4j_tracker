package ru.job4j.inheritance.collection;

import org.junit.Test;
import ru.job4j.collection.UniqueText;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UniqueTextTest {

    @Test
    public void isEquals() {
        String origin = "My cat eats a mouse and milk";
        String text = "My cat eats milk and a mouse";
        Assert.assertThat(UniqueText.isEquals(origin, text), Is.is(true));
    }

    @Test
    public void isNotEquals() {
        String origin = "My cat eats a mouse";
        String text = "A mouse is eaten by a cat";
        Assert.assertThat(UniqueText.isEquals(origin, text), Is.is(false));
    }
}