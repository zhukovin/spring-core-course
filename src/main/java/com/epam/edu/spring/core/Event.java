package com.epam.edu.spring.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

@Component
@Scope("prototype")
@RequiredArgsConstructor
@Getter
public class Event {
    private final int id = new Random().nextInt();

    @Autowired
    private final Date date;
    @Autowired
    private final DateFormat dateFormat;

    @Setter
    private String message;
    @Setter
    private EventType type;

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", date=" + dateFormat.format(date) +
                ", message='" + message + '\'' +
                '}';
    }
}
