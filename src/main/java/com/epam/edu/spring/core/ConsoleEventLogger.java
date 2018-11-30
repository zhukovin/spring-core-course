package com.epam.edu.spring.core;

import org.springframework.stereotype.Component;

@Component
class ConsoleEventLogger implements EventLogger {
    @Override
    public void logEvent(Event event) {
        print(event);
    }

    private void print(Object x) {
        System.out.println(x);
    }
}
