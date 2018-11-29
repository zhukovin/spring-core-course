package com.epam.edu.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static com.epam.edu.spring.core.EventType.ERROR;
import static com.epam.edu.spring.core.EventType.INFO;

public class SpringApp {
    public static void main(String[] args) {

        try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml")) {

            App app = (App) context.getBean("app");

            app.logEvent(newErrorEvent(context, message("Winter is coming!")));
            app.logEvent(newInfoEvent(context, message("Winter is over!")));
            app.logEvent(newInfoEvent(context, message("Winter is over!")));
            app.logEvent(newUntypedEvent(context, message("Winter is over!")));
            app.logEvent(newInfoEvent(context, message("Winter is over!")));
        }
    }

    private static String message(String text) {
        return "{greeting}, {fullName}! " + text;
    }

    private static Event newInfoEvent(ApplicationContext context, String message) {
        return newEvent(INFO, context, message + " (i)");
    }

    private static Event newErrorEvent(ApplicationContext context, String message) {
        return newEvent(ERROR, context, message + " (e)");
    }

    private static Event newUntypedEvent(ApplicationContext context, String message) {
        return newEvent(null, context, message + " (u)");
    }

    private static Event newEvent(EventType type, ApplicationContext context, String message) {
        Event event = (Event) context.getBean("event");
        event.setType(type);
        event.setMessage(message);
        return event;
    }
}
