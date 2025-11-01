package org.example.file;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileUtil {
    public static List<String> readLines(String inputPath) throws Exception {
        return Files.readAllLines(Paths.get(inputPath));
    }

    public static void writeLines(String filePath, List<String> lines) throws Exception {
        Files.write(Paths.get(filePath), lines);
    }
}
