package com.epam.edu.spring.core;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class App {
    private final EventLogger eventLogger;
    private final Client client;

    void logEvent(Event event) {
        event.setMessage(event.getMessage().replaceAll(client.getId(), client.getFullName()));
        eventLogger.logEvent(event);
    }
}
