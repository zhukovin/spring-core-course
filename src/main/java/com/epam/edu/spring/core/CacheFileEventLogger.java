package com.epam.edu.spring.core;

import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {

//    private final FileEventLogger delegateLogger;
    private final int cacheCapacity;

    private List<Event> cache = new ArrayList<>();

    public CacheFileEventLogger(String filename, int cacheCapacity) {
        super(filename);
        this.cacheCapacity = cacheCapacity;
    }

    @Override
    public void logEvent(Event event) {
        if (cacheIsFull()) {
            flushCache();
            cache.clear();
        }
        cache.add(event);
    }

    public void destroy() {
        flushCache();
    }

    private boolean cacheIsFull() {
        return cache.size() == cacheCapacity;
    }

    private void flushCache() {
        cache.forEach(super::logEvent);
    }
}
