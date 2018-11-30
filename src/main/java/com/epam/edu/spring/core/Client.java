package com.epam.edu.spring.core;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class Client {
    @Value("${id}")
    private String id;
    @Value("${name}")
    private String fullName;
    @Value("${greeting}")
    private String greeting;
}
