package com.epam.edu.spring.core;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class App {
    private final EventLogger eventLogger;
    private final Client client;

    void logEvent(Event event) {
        event.setMessage(personalizedMessageOf(event));
        eventLogger.logEvent(event);
    }

    private String personalizedMessageOf(Event event) {
        return event.getMessage()
                .replaceAll("\\{greeting}", client.getGreeting())
                .replaceAll("\\{fullName}", client.getFullName())
                ;
    }
}
