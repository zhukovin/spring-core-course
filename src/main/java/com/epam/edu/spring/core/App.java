package com.epam.edu.spring.core;

import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@RequiredArgsConstructor
class App {
    //    private final EventLogger eventLogger;
    private final Client client;
    private final EventLogger defaultLogger;
    private final Map<EventType, EventLogger> loggers;

    void logEvent(Event event) {
        event.setMessage(personalizedMessageOf(event));
        dispatch(event);
    }

    private void dispatch(Event event) {
        specificLoggerFor(event).orElse(defaultLogger).logEvent(event);
    }

    private Optional<EventLogger> specificLoggerFor(Event event) {
        return ofNullable(loggers.get(event.getType()));
    }

    private String personalizedMessageOf(Event event) {
        return event.getMessage()
                .replaceAll("\\{greeting}", client.getGreeting())
                .replaceAll("\\{fullName}", client.getFullName());
    }
}
