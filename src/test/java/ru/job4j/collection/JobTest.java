package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenJobAscendingName() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Impl task", 0),
                new Job("Error next iteration", 4)
        );
        List<Job> expected = Arrays.asList(
                new Job("Error next iteration", 4),
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        Collections.sort(jobs, new JobAscendingByName());
        assertEquals(jobs, expected);
    }

    @Test
    public void whenJobAscendingPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Impl task", 0),
                new Job("Error next iteration", 4)
        );
        List<Job> expected = Arrays.asList(
                new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("Error next iteration", 4)
        );
        Collections.sort(jobs, new JobAscendingByPriority());
        assertEquals(jobs, expected);
    }
}