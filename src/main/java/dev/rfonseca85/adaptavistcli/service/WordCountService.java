package dev.rfonseca85.adaptavistcli.service;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * This interface defines a service for counting the occurrences of each word in
 * a given text.
 * It declares a method to count the words and return a map of words and their
 * counts, sorted by the count in descending order.
 * 
 * @author Rafael Fonseca
 * @since 2024-04-24
 */
@Service
public interface WordCountService {
  LinkedHashMap<String, Integer> countWords(String text) throws Exception;

}
