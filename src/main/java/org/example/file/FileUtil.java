package org.example.file;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileUtil {
    public static List<String> readLines(String inputPath) {
        try {
            return Files.readAllLines(Paths.get(inputPath));
        } catch (Exception error) {
            throw new IORuntimeException(inputPath, error);
        }
    }

    public static void writeLines(String filePath, List<String> lines) {
        try {
            Files.write(Paths.get(filePath), lines);
        } catch (Exception error) {
            throw new IORuntimeException(filePath, error);
        }
    }
}
