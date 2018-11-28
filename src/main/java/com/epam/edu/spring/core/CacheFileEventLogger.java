package com.epam.edu.spring.core;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CacheFileEventLogger implements EventLogger {

    private final FileEventLogger delegateLogger;
    private final int cacheCapacity;

    private List<Event> cache = new ArrayList<>();

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
        cache.forEach(delegateLogger::logEvent);
    }
}
