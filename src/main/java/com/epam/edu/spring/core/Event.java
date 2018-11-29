package com.epam.edu.spring.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

@RequiredArgsConstructor
@Getter
public class Event {
    private final int id = new Random().nextInt();
    private final Date date;
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
