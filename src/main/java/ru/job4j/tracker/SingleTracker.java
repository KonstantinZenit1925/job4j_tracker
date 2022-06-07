package ru.job4j.tracker;

public class SingleTracker {

    private static SingleTracker instance = null;

    private final Tracker tracker = new Tracker();

    private SingleTracker() {

    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return null;
    }

    public Item[] findAll() {
        return null;
    }

    public Item[] findByName(String key) {
        return null;
    }

    private int indexOf(int id) {
        return 0;
    }

    public boolean replace(int id, Item item) {
        return false;
    }

    public boolean delete(int id) {
        return false;
    }

}
