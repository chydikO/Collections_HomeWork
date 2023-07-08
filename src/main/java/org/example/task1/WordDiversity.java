package org.example.task1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordDiversity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть рядок тексту:");
        String inputText = scanner.nextLine();
        Set<String> uniqueWords = getUniqueWords(inputText);

        System.out.println("Унікальних слів: " + uniqueWords.size());
    }

    public static Set<String> getUniqueWords(String text) {
        String[] words = text.split("\\s+");
        HashSet<String> uniqueWords = new HashSet<>();

        for (String word : words) {
            if (!word.isBlank()) {
                uniqueWords.add(word.toLowerCase());
            }
        }
        return uniqueWords;
    }
}
