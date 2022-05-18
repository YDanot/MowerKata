package com.mowitnow.mower.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class FileUtils {
    public static String getContent(String filename, Class<?> aClass) throws URISyntaxException, IOException {
        URI fileLocation = Objects.requireNonNull(aClass.getResource(filename)).toURI();
        return Files.readString(Paths.get(fileLocation));
    }
}
