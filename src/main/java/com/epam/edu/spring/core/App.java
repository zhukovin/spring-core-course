package com.epam.edu.spring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Component
//@RequiredArgsConstructor
class App {
    @Autowired
    private Client client;
    @Autowired
    @Qualifier("fileEventLogger")
    private EventLogger defaultLogger;
    @Autowired
    private Map<EventType, EventLogger> eventTypeLoggers;

    void logEvent(Event event) {
        event.setMessage(personalizedMessageOf(event));
        dispatch(event);
    }

    private void dispatch(Event event) {
        specificLoggerFor(event).orElse(defaultLogger).logEvent(event);
    }

    private Optional<EventLogger> specificLoggerFor(Event event) {
        return ofNullable(eventTypeLoggers.get(event.getType()));
    }

    private String personalizedMessageOf(Event event) {
        return event.getMessage()
                .replaceAll("\\{greeting}", client.getGreeting())
                .replaceAll("\\{fullName}", client.getFullName());
    }
}
