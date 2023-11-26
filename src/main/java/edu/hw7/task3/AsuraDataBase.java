package edu.hw7.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AsuraDataBase implements PersonDataBase {
    private final Map<Integer, Person> database = new HashMap<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    private int index = 0;

    public AsuraDataBase() {
    }

    @Override
    public synchronized void add(Person person) {
        lock.writeLock().lock();
        database.put(index, person);
        index++;
        lock.writeLock().unlock();
    }

    @Override
    public synchronized void delete(int id) {
        lock.writeLock().lock();
        database.remove(id);
        lock.writeLock().unlock();
    }

    @Override
    public synchronized List<Person> findByName(String name) {
        lock.readLock().lock();
        List<Person> res = new ArrayList<>();
        for (var pers : database.values()) {
            if (pers.name().equals(name)) {
                res.add(pers);
            }
        }
        lock.readLock().unlock();
        return res;
    }

    @Override
    public synchronized List<Person> findByAddress(String address) {
        lock.readLock().lock();
        List<Person> res = new ArrayList<>();
        for (var pers : database.values()) {
            if (pers.address().equals(address)) {
                res.add(pers);
            }
        }
        lock.readLock().unlock();
        return res;
    }

    @Override
    public synchronized List<Person> findByPhone(String phone) {
        lock.readLock().lock();
        List<Person> res = new ArrayList<>();
        for (var pers : database.values()) {
            if (pers.name().equals(phone)) {
                res.add(pers);
            }
        }
        lock.readLock().unlock();
        return res;
    }
}
