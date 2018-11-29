package com.epam.edu.spring.core;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CombinedEventLogger implements EventLogger {
    private final List<EventLogger> loggers;

    @Override
    public void logEvent(Event event) {
        loggers.forEach(logger -> logger.logEvent(event));
    }
}
