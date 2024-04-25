package dev.rfonseca85.adaptavistcli.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * This utility class provides a method to read a text file and return its
 * contents as a StringBuilder.
 * It checks if the file path is not empty, if the file exists, and if the file
 * extension is .txt.
 * If any of these checks fail, it throws a RuntimeException.
 * 
 * @author Rafael Fonseca
 * @since 2024-04-24
 */
public class FileManipulation {

  public static StringBuilder readFile(String filePath) {

    // check if file path is empty
    if (filePath == null || filePath.isEmpty())
      throw new RuntimeException("File path is empty");

    // check if file exists
    if (!new File(filePath).exists())
      throw new RuntimeException("File does not exist");

    // check the file extension
    if (!filePath.endsWith(".txt"))
      throw new RuntimeException("Invalid file extension. Only .txt files are supported.");

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      StringBuilder textBuilder = new StringBuilder();
      String line;
      while ((line = reader.readLine()) != null) {
        textBuilder.append(line).append("\n");
      }
      return textBuilder;
    } catch (IOException e) {
      throw new RuntimeException("Error reading file");
    }

  }
}
