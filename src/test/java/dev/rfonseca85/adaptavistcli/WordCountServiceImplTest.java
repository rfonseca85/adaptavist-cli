package dev.rfonseca85.adaptavistcli;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import dev.rfonseca85.adaptavistcli.service.WordCountServiceImpl;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordCountServiceImplTest {

  private WordCountServiceImpl wordCountService;

  @BeforeEach
  public void setUp() {
    wordCountService = new WordCountServiceImpl();
  }

  @Test
  public void testCountWords() throws Exception {
    String text = "Hello hello world world world";
    LinkedHashMap<String, Integer> expected = new LinkedHashMap<>();
    expected.put("world", 3);
    expected.put("hello", 2);

    LinkedHashMap<String, Integer> actual = wordCountService.countWords(text);

    assertEquals(expected, actual, "The word count map should be sorted by count in descending order");
  }

  @Test
  public void testCountWordsWithPunctuation() throws Exception {
    String text = "Hello, hello. World world world!";
    LinkedHashMap<String, Integer> expected = new LinkedHashMap<>();
    expected.put("world", 3);
    expected.put("hello", 2);

    LinkedHashMap<String, Integer> actual = wordCountService.countWords(text);

    assertEquals(expected, actual, "The word count map should be sorted by count in descending order");
  }

  @Test
  public void testCountWordsWithEmptyText() throws Exception {
    String text = "";
    LinkedHashMap<String, Integer> actual = wordCountService.countWords(text);

    assertTrue(actual.isEmpty(), "The word count map should be empty for an empty text");
  }

  @Test
  public void testCountWordsWithNullText() throws Exception {
    String text = null;
    LinkedHashMap<String, Integer> actual = wordCountService.countWords(text);

    assertTrue(actual.isEmpty(), "The word count map should be empty for a null text");
  }

}