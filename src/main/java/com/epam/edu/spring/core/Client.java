package com.epam.edu.spring.core;

import lombok.Data;

@Data
public class Client {
    private final String id;
    private final String fullName;
    private String greeting;
}
