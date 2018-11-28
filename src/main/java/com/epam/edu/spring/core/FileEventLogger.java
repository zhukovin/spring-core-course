package com.epam.edu.spring.core;

import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.writeStringToFile;

@RequiredArgsConstructor
public class FileEventLogger implements EventLogger {
    private static final boolean APPEND = true;
    private static final String ENCODING = "utf-8";

    private final String filename;

    private File file;

    private void init() throws IOException {
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
        try {
            writeStringToFile(file, event.getMessage(), ENCODING, APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
