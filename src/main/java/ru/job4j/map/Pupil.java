package ru.job4j.map;
/**
 * Класс Pupil описывает ученика.
 */
import java.util.List;

public record Pupil(String name, List<Subject> subjects) {
}
