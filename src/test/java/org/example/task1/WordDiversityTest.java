package org.example.task1;

import org.junit.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class WordDiversityTest {
    @Test
    public void testWordDiversity() {
        String text = "apple banana cherry banana apple";

        Set<String> uniqueWords = WordDiversity.getUniqueWords(text);

        assertEquals(3, uniqueWords.size());
        assertTrue(uniqueWords.contains("apple"));
        assertTrue(uniqueWords.contains("banana"));
        assertTrue(uniqueWords.contains("cherry"));
    }

    @Test
    public void testWordDiversity_EmptyText() {
        String text = "";
        Set<String> uniqueWords = WordDiversity.getUniqueWords(text);

        assertEquals(0, uniqueWords.size());
    }

    @Test
    public void testWordDiversity_NoDuplicates() {
        String text = "apple banana cherry";
        Set<String> uniqueWords = WordDiversity.getUniqueWords(text);

        assertEquals(3, uniqueWords.size());
        assertTrue(uniqueWords.contains("apple"));
        assertTrue(uniqueWords.contains("banana"));
        assertTrue(uniqueWords.contains("cherry"));
    }

    @Test
    public void testWordDiversity_IgnoreCase() {
        String text = "Apple apple BANANA banana";
        Set<String> uniqueWords = WordDiversity.getUniqueWords(text);

        assertEquals(2, uniqueWords.size());
        assertTrue(uniqueWords.contains("apple"));
        assertTrue(uniqueWords.contains("banana"));
    }
}