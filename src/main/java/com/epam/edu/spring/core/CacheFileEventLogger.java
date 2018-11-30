package com.epam.edu.spring.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

@Component
public class CacheFileEventLogger extends FileEventLogger {

    @Value("${cacheCapacity}")
    private int cacheCapacity;

    private List<Event> cache = new ArrayList<>();

    @Override
    public void logEvent(Event event) {
        if (cacheIsFull()) {
            flushCache();
            cache.clear();
        }
        cache.add(event);
    }

    @PreDestroy
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
