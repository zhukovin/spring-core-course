package com.epam.edu.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {
    public static void main(String[] args) {

        try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml")) {

            App app = (App) context.getBean("app");

            app.logEvent(newEvent(context, message("winter is coming!")));
            app.logEvent(newEvent(context, message("winter is over!")));
            app.logEvent(newEvent(context, message("winter is over!")));
            app.logEvent(newEvent(context, message("winter is over!")));
            app.logEvent(newEvent(context, message("winter is over!")));
        }
    }

    private static String message(String text) {
        return "{greeting} {fullName}, " + text;
    }

    private static Event newEvent(ApplicationContext context, String message) {
        Event event = (Event) context.getBean("event");
        event.setMessage(message);
        return event;
    }
}
