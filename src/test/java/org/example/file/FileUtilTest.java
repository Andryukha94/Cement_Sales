package org.example.file;

import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileUtilTest {

    @Test
    void readLines_shouldReturnCorrectLines() throws Exception {
        Path tempFile = Files.createTempFile("test-read", ".txt");

        List<String> expected = List.of("hello", "world");
        Files.write(tempFile, expected);

        List<String> actual = FileUtil.readLines(tempFile.toString());

        assertEquals(expected, actual);
    }

    @Test
    void writeLines_shouldWriteCorrectly() throws Exception {
        Path tempFile = Files.createTempFile("test-write", ".txt");

        List<String> lines = List.of("line1", "line2");
        FileUtil.writeLines(tempFile.toString(), lines);

        List<String> actual = Files.readAllLines(tempFile);

        assertEquals(lines, actual);
    }
}