package ru.job4j.collection;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import ru.job4j.collection.User;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserTest {
    @Test
    public void whenAsc() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
        Iterator<User> it = users.iterator();
        MatcherAssert.assertThat(it.next(), Matchers.is(new User("Ivan", 31)));
        MatcherAssert.assertThat(it.next(), Matchers.is(new User("Petr", 32)));
    }

    @Test
    public void whenAscForUsersWithEqualNameButDifferentAge() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 35));
        users.add(new User("Ivan", 31));
        users.add(new User("Petr", 25));
        users.add(new User("Ivan", 29));
        users.add(new User("Petr", 33));
        users.add(new User("Ivan", 27));
        Set<User> expected = new TreeSet<>(
                Arrays.asList(
                        new User("Ivan", 27),
                        new User("Ivan", 29),
                        new User("Ivan", 31),
                        new User("Petr", 25),
                        new User("Petr", 33),
                        new User("Petr", 35)
                )
        );
        MatcherAssert.assertThat(users, Matchers.is(expected));
    }

    @Test
    public void whenComparePetrVSIvan() {
        int rsl = new User("Petr", 32)
                .compareTo(
                        new User("Ivan", 31)
                );
        MatcherAssert.assertThat(rsl, Matchers.greaterThan(0));
    }

    @Test
    public void whenComparePetrVSPetrWithDifferentAge() {
        int rsl = new User("Petr", 31)
                .compareTo(
                        new User("Petr", 32)
                );
        MatcherAssert.assertThat(rsl, Matchers.lessThan(0));
    }
}