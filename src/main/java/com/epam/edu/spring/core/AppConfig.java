package com.epam.edu.spring.core;

import org.springframework.context.annotation.*;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.text.DateFormat.getDateTimeInstance;
import static java.util.Arrays.asList;

@Configuration
@ComponentScan(basePackages = "com.epam.edu.spring.core")
@PropertySources({
        @PropertySource("classpath:client.properties"),
        @PropertySource("classpath:loggers.properties")
})
public class AppConfig {

    @Bean
    public Map<EventType, EventLogger> eventTypeLoggers(
            ConsoleEventLogger consoleEventLogger, CombinedEventLogger combinedEventLogger) {
        Map<EventType, EventLogger> map = new HashMap<>();
        map.put(EventType.INFO, consoleEventLogger);
        map.put(EventType.ERROR, combinedEventLogger);
        return map;
    }

    @Bean
    public List<EventLogger> loggersForCombinedLogger(ConsoleEventLogger consoleEventLogger, FileEventLogger fileEventLogger) {
        return asList(consoleEventLogger, fileEventLogger);
    }

    @Bean
    public DateFormat dateFormat() {
        return getDateTimeInstance();
    }

    @Bean
    public Date currentDate() {
        return new Date();
    }

//    @Bean("fileEventLogger")
//    public FileEventLogger fileEventLogger() {
//        return new FileEventLogger();
//    }
}
