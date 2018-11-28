package com.epam.edu.spring.core;

public interface EventLogger {
    void logEvent(String message);
    void logEvent(Event event);
}
