package dev.rfonseca85.adaptavistcli;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dev.rfonseca85.adaptavistcli.utils.FileManipulation;

public class FileManipulationTest {

  @TempDir
  Path tempDir;

  private Path testFile;

  @BeforeEach
  public void setUp() throws Exception {
    testFile = tempDir.resolve("test.txt");
    Files.write(testFile, "Hello\nWorld".getBytes());
    // Temp file will be delete automatically on JUnit 5
  }

  @Test
  public void testReadFile() {
    StringBuilder result = FileManipulation.readFile(testFile.toString());
    assertEquals("Hello\nWorld\n", result.toString(), "The content of the file should be read correctly");
  }

  @Test
  public void testReadFileWithEmptyPath() {
    Exception exception = assertThrows(RuntimeException.class, () -> FileManipulation.readFile(""));
    assertEquals("File path is empty", exception.getMessage(),
        "An exception should be thrown if the file path is empty");
  }

  @Test
  public void testReadFileWithNonExistentFile() {
    Exception exception = assertThrows(RuntimeException.class,
        () -> FileManipulation.readFile("non_existent_file.txt"));
    assertEquals("File does not exist", exception.getMessage(),
        "An exception should be thrown if the file does not exist");
  }

  @Test
  public void testReadFileWithInvalidExtension() throws IOException {
    Path invalidFile = tempDir.resolve("test.invalid");
    Files.createFile(invalidFile); // Create the file

    // Check if the file exists
    assertTrue(Files.exists(invalidFile), "The file should be created");

    Exception exception = assertThrows(RuntimeException.class, () -> FileManipulation.readFile(invalidFile.toString()));
    assertEquals("Invalid file extension. Only .txt files are supported.", exception.getMessage(),
        "An exception should be thrown if the file extension is not .txt");
  }
}