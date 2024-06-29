package dev.rfonseca85.testcli.service;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * This class implements the WordCountService interface. It provides a method to
 * count the occurrences
 * of each word in a given text and return a map of words and their counts,
 * sorted by the count in descending order.
 * 
 * @author Rafael Fonseca
 * @since 2024-04-24
 */
@Service
public class WordCountServiceImpl implements WordCountService {

  @Override
  public LinkedHashMap<String, Integer> countWords(String text) throws Exception {

    if (text == null) {
      return new LinkedHashMap<>();
    }

    // Split the text into words
    String[] words = text.toLowerCase().split("\\s+");

    // Count occurrences of each word and store in a map
    Map<String, Integer> wordCount = new HashMap<>();
    for (String word : words) {
      // Remove anything other than words and convert to lowercase (lowercase can be
      // removed if case sensitivity is desired)
      String cleanedWord = word.toLowerCase().replaceAll("[^a-zA-Z]", "");
      if (!cleanedWord.isEmpty()) {
        wordCount.put(cleanedWord, wordCount.getOrDefault(cleanedWord, 0) + 1);
      }
    }

    // Sort the map by value (count of occurrences) in descending order
    LinkedHashMap<String, Integer> sortedWordCount = new LinkedHashMap<>();
    wordCount.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .forEachOrdered(entry -> sortedWordCount.put(entry.getKey(), entry.getValue()));

    return sortedWordCount;
  }

}
