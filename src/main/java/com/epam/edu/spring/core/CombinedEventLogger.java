package com.epam.edu.spring.core;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CombinedEventLogger implements EventLogger {
    @Autowired
    private final List<EventLogger> loggersForCombinedLogger;

    @Override
    public void logEvent(Event event) {
        loggersForCombinedLogger.forEach(logger -> logger.logEvent(event));
    }
}
