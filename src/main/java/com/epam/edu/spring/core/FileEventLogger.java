package com.epam.edu.spring.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.writeStringToFile;

@Component
public class FileEventLogger implements EventLogger {
    private static final boolean APPEND = true;
    private static final String ENCODING = "utf-8";
    @Value("${fileName}")
    private String filename;

    private File file;

    @PostConstruct
    public void init() throws IOException {
        file = new File(filename);
        String fileAbsolutePath = file.getAbsolutePath();
        if(!file.exists() && !file.createNewFile())
            throw new IOException("Cannot create " + fileAbsolutePath);

        if(!file.canWrite()) {
            throw new IOException("Cannot write to " + fileAbsolutePath);
        }
    }

    @Override
    public void logEvent(Event event) {
        assertBeanIsInitialized();
        try {
            writeStringToFile(file, event + "\n", ENCODING, APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void assertBeanIsInitialized() {
        if (file == null) {
            String message = "Please specify init-method=\"init\" when defining the bean.";
            System.out.println(message);
            throw new IllegalStateException(message);
        }
    }
}
