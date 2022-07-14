package ru.job4j.collection;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.collection.Order;
import ru.job4j.collection.OrderConvert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrderConvertTest {
    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        Assert.assertThat(map.get("3sfe"), Is.is(new Order("3sfe", "Dress")));
    }

    @Test
    public void whenDuplicateOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        orders.add(new Order("5frg", "Diablo"));
        orders.add(new Order("5frg", "Diablo"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        int expectedSize = 2;
        int outSize = map.size();
        Assert.assertEquals(expectedSize, outSize);
    }
}